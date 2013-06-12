/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kekoharjoitus;

/**
 * 
 * @author pturunen
 */
public class Fibonaccikeko {
    
    private  Fibonaccipuu min;
    private int n;
    private int maxdegree = 0;
    
    /**
     * Konstruktori
     */
    public Fibonaccikeko(){
       this.min = null;
       this.n =0;
    }
    
    /**
     * Luo tyhjän fibonaccikeko olion
     * @return Fibonaccikeko olio
     */
    public static Fibonaccikeko makeHeap(){
        Fibonaccikeko keko = new Fibonaccikeko();
        return keko;
    }
    
    /**
     * Palauttaa minimikeon pienimmän alkion
     * @return Solmu olio, tai null jos keko tyhjä
     */
    public Solmu findMin(){
        Solmu solmu = null;
        if (min != null){
            solmu = min.getValue();
        }
        return solmu;
    }
    
    /**
     * Lisää Solmu luokan olion minimikekoon
     * omistajuus olioon siirtyy 
     * @param x Solmu luokan olio,joka lisätään kekoon
     */
    public void insert(Solmu x){
       if (x == null || x.getValue() == Integer.MAX_VALUE){
            return;
        }
        Fibonaccipuu uusi = createNewFibonaccipuu(x);
        if (uusi != null){
            if (this.getMin()!=null)  {
                Fibonaccikeko keko = Fibonaccikeko.makeHeap();
                keko.setMin(uusi);
                Fibonaccikeko temp = Fibonaccikeko.merge(keko, this);
                this.setMin(temp.getMin());
            }
            else {
                this.setMin(uusi);
            }
        } 
        n++;
    }
  
    /**
     * Palauttaa Fibonaccikeko olion pienimmän arvon omaavan
     * Fibonaccipuu olion
     * 
     * @param fibonaccipuu Fibonacipuu olio tai null jos keko tyhjä
     */
    public Fibonaccipuu getMin(){
        return this.min;
    }
    
    /**
     * Asettaa Fibonaccikeko olion jäsenmuuttujaan
     * min parametrina annetun Fibonaccipuu olion
     * 
     * @param fibonaccipuu Fibonaccipuu olio
     */
    private void setMin(Fibonaccipuu fibonaccipuu){
        this.min =fibonaccipuu;
    }
    
    /**
     * Luodaan uusi Fobonaccipuu olio jonka jäsenmuuttujaksi asetetaan
     * parametrina annettu Solmu olio
     * @param x Solmu luokan olio josta luodaan uusi Fibonaccipuu olio
     * @return Fibonaccipuu olio
     */
    private Fibonaccipuu createNewFibonaccipuu(Solmu x){
        Fibonaccipuu puu = new Fibonaccipuu();
        puu.setValue(x);
        return puu;
    }
    
    /**
     * Poistaa pienimmän alkion keosta ja palauttaa osoittimen ko alkioon
     * Fibonaccikeon poisto toimii seuraavasti;
     * poistetaan ensin minimialkio juurilistasta ja sen mahdollinen
     * lapsilista yhdistetaan juurilistaan,Paivitetaan parent linkit ja
     * yhdistetaan saman degree arvon omaavat juurilistan alkiot toisiinsa.
     * @return Solmu luokan olio, poistetaan keosta
     */
    public Solmu deleteMin(){
        if (this.getMin()== null){
            return null;
        }
        Fibonaccipuu minimi = this.getMin();
        if (!this.getMin().hasSibling() && this.getMin().getChild()==null){
            this.setMin(null);
            return minimi.getValue();
        }
        
        Fibonaccipuu lapsi = this.getMin().getChild();
        removelistasta(minimi);
        
        if (minimi.hasSibling()){
            this.setMin(minimi.getSiblingR());
            sulauta(this.getMin(),lapsi);
        }
        else {
            this.setMin(lapsi);
        }
        //kay juurilista lapi ja null parent ja laske samalla
        //pienin arvo ,paivita se
        n--;
        puhdista();
        return minimi.getValue();
    }
    
    /**
     * Poistaa min alkion juurilistasta ja
     * päivittää puu olion vasemman ja oikean alkion
     * linkit juurilistassa
     * @puu Fibonaccipuu olio poistettava olio jonka
     * sisrukset linkitetään yhteen
     */
    private void removelistasta(Fibonaccipuu puu){
        if (puu== null){
            return;
        }
        if (puu.hasSibling()){
            Fibonaccipuu  vasen = puu.getSiblingL();
            Fibonaccipuu  oikea = puu.getSiblingR();
            if (!puu.isSameSibling()){
                vasen.setSiblingR(oikea);
                oikea.setSiblingL(vasen);
            }
            else {
                vasen.setSiblingL(null);
                oikea.setSiblingR(null);
            }
        }
        puu.setSiblingL(null);
        puu.setSiblingR(null);
    }
    
    /**
     * Yhdistää kahden Fibonaccipuun linkit toisiinsa
     * @param  puu1 Fibonaccipuu yhdistettävä puu
     * @param  puu2 Fibonaccipuu yhdistettävä puu
     */
    private void sulauta(Fibonaccipuu puu1,Fibonaccipuu puu2){
        if (puu1== null||puu2== null){
            return;
        }
        Fibonaccipuu vika1 = null;
        Fibonaccipuu vika2 = null;
        if (puu1.hasSibling() && puu2.hasSibling()){
            vika1 = puu1.getSiblingL();
            vika2 = puu2.getSiblingL();
            vika1.setSiblingR(puu2);
            vika2.setSiblingR(puu1);
            puu2.setSiblingL(vika1);
            puu1.setSiblingL(vika2);
        }
        if (!puu1.hasSibling() && puu2.hasSibling()){
            vika2 = puu2.getSiblingL();
            puu1.setSiblingR(puu2);
            vika2.setSiblingR(puu1);
            puu2.setSiblingL(puu1);
            puu1.setSiblingL(vika2);
        }
        if (puu1.hasSibling() && !puu2.hasSibling()){
            vika1 = puu1.getSiblingL();
            vika1.setSiblingR(puu2);
            puu2.setSiblingR(puu1);
            puu2.setSiblingL(vika1);
            puu1.setSiblingL(puu2);
        }
        if (!puu1.hasSibling() && !puu2.hasSibling()){
            vika1 = puu1.getSiblingL();
            vika2 = puu2.getSiblingL();
            puu1.setSiblingR(puu2);
            puu2.setSiblingR(puu1);
            puu2.setSiblingL(puu1);
            puu1.setSiblingL(puu2);
        }
        
    }
    
    /**
     * Päivittää juurilistan parent viittaukset null:ksi
     * sekä linkittää juurilistan saman degreen omaavat yhteen
     */
    private void puhdista(){
        if (this.getMin() == null ||!this.getMin().hasSibling()){
            return;
        }
        Fibonaccipuu current = this.getMin().getSiblingR();
        int minimi = this.getMin().getValue().getValue();
        Fibonaccipuu [] asteet = new Fibonaccipuu[maxdegree+40];
        while (current != null && this.getMin() != current){
            current.setParent(null);
            if (minimi >= current.getValue().getValue()){
                minimi = current.getValue().getValue();
                this.setMin(current);
            }
            yhdistaSamanAsteiset(current,asteet);
            current = current.getSiblingR();
        }
    }
    
    /**
     * Funktio yhdistaa juurilistassa saman asteiset alkiot
     * @param puu Fibonaccipuu juurilistan alkio joka yhdistetaan
     * mahdollisesti samanasteisen toisen juurilistan alkion kanssa
     * jos sellainen juurilistasta löytyy
     * 
     */
    private void yhdistaSamanAsteiset(Fibonaccipuu puu,Fibonaccipuu [] asteet){
        Fibonaccipuu curr = puu;
        asteet[curr.getDegree()]= curr;
        curr = curr.getSiblingR();
        if (curr != null){
            Fibonaccipuu tupla = asteet[curr.getDegree()];
            while (tupla !=null){
                asteet[curr.getDegree()] = null;
                if (curr.getValue().getValue()>tupla.getValue().getValue()){
                    vaihdaArvot(curr, tupla);
                }
            removelistasta(tupla);
            link(curr, tupla);
            tupla = asteet[curr.getDegree()];
            }
            asteet[curr.getDegree()] = curr;
        }
    }
    
    /**
     * Yhdistää kaksi Fibonaccipuuta toisiinsa
     * @param juuri Fibonaccipuu olio johon liitetään lapsi
     * @param lapsi Fibonaccipuu olio joka liitetään juureen
     * Mitään ei tehdä jos jompikumpi annetuista parametreista 
     * on null.
     */
    private void link(Fibonaccipuu juuri, Fibonaccipuu lapsi){
        if (lapsi != null && juuri != null){
            lapsi.setParent(juuri);
            sulauta(lapsi,juuri.getChild());
            juuri.setChild(lapsi);
            juuri.setDegree(juuri.getDegree()+ 1);
            if (maxdegree < juuri.getDegree()){
                maxdegree = juuri.getDegree();
            }
            juuri.setMarkedInfo(Boolean.FALSE);
        }
    }
    
    /**
     * Vaihtaa paramterina annettujen olioden arvot päittäin
     * @param puu1 paramteri osoittaa funktion kutsun jälkeen puu2 olioon
     * @param puu2 paramteri osoittaa funktion kutsun jälkeen puu1 olioon
     */
    private void vaihdaArvot(Fibonaccipuu puu1, Fibonaccipuu puu2){
        Fibonaccipuu apu = puu1;
        puu1 = puu2;
        puu2 = apu;
    }
    
    
    /**
      * Pienentää keossa olevan solmun arvoa ja
     * muuttaa solmun paikkaa keossa ylöspäin, jos kekoehto rikki
     * @param binomipuu Binomipuu olio,jonka valuen arvo on alkio
     * @param alkio, Solmu olio,jonka arvoa
     * halutaan pienentää
     * @param value Solmu olion valuen uusi arvo
     * @return int saa arvon 0, tai -1 jos virhe käsittelyssä
     */
    public int decreaseKey(Fibonaccipuu puu,int value){
        if (puu == null ||puu.getValue()== null ||
                        puu.getValue().getValue() < value){
            return -1;
        }
        if ((puu.getParent() != null && 
                puu.getParent().getValue().getValue() <= value)||
                puu.getParent() == null){
            puu.getValue().setValue(value);
            if (this.findMin().getValue() > value){
                this.setMin(puu);
            }
            return 0;
        }
        puu.getValue().setValue(value);
        korota(puu);
        return 0;
    }
    
    /**
     * Korottaa parametrina annetun olion juurilistaan ja
     * merkitsee olion parentin merkityksi, jos parent jo merkitty
     * se myös nostetaan juurilistaan ja sen parent tarkistetaan jne.
     * @param puu Fibonaccipuu olio joka korotetaan juurilistaan
     */
    private void korota(Fibonaccipuu puu){
        if (puu == null){
            return;
        }
        if (puu.getMarkedInfo()){
            puu.setMarkedInfo(Boolean.FALSE);
        }
        if (puu.getParent() != null){
            puu.getParent().setDegree(puu.getParent().getDegree()-1);
            puu.getParent().setChild(null);
            if (puu.hasSibling()){
                puu.getParent().setChild(puu.getSiblingR());
            }
            removelistasta(puu);
            sulauta(this.getMin(),puu);
            if (this.getMin().getValue().getValue() >
                                                puu.getValue().getValue()){
               this.setMin(puu); 
            }
            if (puu.getParent().getMarkedInfo()){
                    korota(puu.getParent());
            }
            else {
                puu.getParent().setMarkedInfo(Boolean.TRUE);
            }
        }
    }
    
    
    
    /**
     * Palauttaa binomikeosta value arvoa vastaavan Fibonaccipuu olion
     * @param puu Fibonaccipuu olio, keon juurilistamin
     * @param value Solmu olio, jonka Fibonaccipuu oliota haetaan, verrataan
     * Solmu olion arvoa ei osoitetta
     * @param vrt Fibonaccipuu head olio listalle,alussa sama kuin puu arvo
     * @return  Fibonaccipuu olio ,palauttaa null, jos binomikeko on tyhjä
     */
    public Fibonaccipuu findFibonaccipuu(Fibonaccipuu puu,Solmu value,Fibonaccipuu vrt){
        Fibonaccipuu match = null;
        if (puu == null || value.getValue() == Integer.MAX_VALUE ){
            return null;
        }
        if (puu.getValue().getValue() == value.getValue()){
            return puu;
        }
        if (vrt != puu.getSiblingR()){
            match = findFibonaccipuu(puu.getSiblingR(),value,vrt);
            if (match == null){
                vrt = puu.getChild();
                match = findFibonaccipuu(puu.getChild(),value,vrt);
            }
        }
        return match;
    }
    
    
    
    /**
    * Yhdistää kaksi kekoa toisiinsa,luoden uuden keon ja
     * tuhoten keon keko1 ja keko2
     * Juurilistam alkiot eivät ole suuruusjärjestyksessä, juurilistassa
     * voi olla saman degreen alkioita.Merge operaatio ei yhdistä niitä.
     * Vain juurilistan pienin alkio päivitetään tarvittaesa.
     * keko1 vasen yhdistetään keko2:sen vasempaan ja 
     * keko2 vasen keko1 vasempaan
     * Jos keossa on vain yksi alkio, vasen ja oikea ovat null
     * Vain kahden alkion lista muodostaa rengaslistan
     * @param keko1 yhdistettävä Fibonaccikeko olio
     * @param keko2 yhdistettävä Fibonaccikeko olio
     * @return uusi Fibonaccikeko olio, tai null jos t1 ja t2 null
     */
    public static Fibonaccikeko merge(Fibonaccikeko keko1, Fibonaccikeko keko2){
        Fibonaccikeko keko = null;
        if (keko1== null || keko2==null || keko1.getMin() == null ||
                keko2.getMin() == null){
            return nullVersionMerge(keko1, keko2);
        }
        Fibonaccipuu suurempi = null;
        keko = Fibonaccikeko.makeHeap();
        Fibonaccipuu uusiMin = null;
        keko.setMin(keko2.getMin());
        suurempi = keko1.getMin();
        if (keko1.findMin().getValue() <= keko2.findMin().getValue()){
                keko.setMin(keko1.getMin());
                suurempi = keko2.getMin();
            }
        keko.maxdegree = keko1.maxdegree;
        if (keko2.maxdegree > keko.maxdegree){
            keko.maxdegree = keko2.maxdegree;
        }
        keko.sulauta(keko1.getMin(),keko2.getMin());
        return keko;        
    }
    
/**
 * Funktio palauttaa uuden keon, jos toinen annetuista keko olioista on null
 * @param keko1 Fibonaccikeko olio 
 * @param keko2 Fibonaccikeko olio 
 * @return Fibonaccikeko olion, jos toinen parametrina annetuista keoista oli null
 * muutoin jos molemmat null tai molemmat != null ,palauttaa null
 */
    private static Fibonaccikeko nullVersionMerge(Fibonaccikeko keko1, Fibonaccikeko keko2){
        Fibonaccikeko keko = null;
        if (keko1== null && keko2==null){
            return null;
        }
        keko = Fibonaccikeko.makeHeap();
        if ((keko1 == null ||keko1.getMin() == null )&& keko2 != null){
            keko.setMin(keko2.getMin());
            keko2 = null;
        }
        else if ((keko2 == null || keko2.getMin()== null)&& keko1 != null){
            keko.setMin(keko1.getMin());
            keko1 = null;
        }
        return keko;
    }
}
