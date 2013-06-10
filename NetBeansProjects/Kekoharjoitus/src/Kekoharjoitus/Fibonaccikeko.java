/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kekoharjoitus;

/**
 * LUOKKA ON TYÖNALLA ,EI KUULUNUT PALAUTUS SETTIIN 5
 * @author pturunen
 */
public class Fibonaccikeko {
    
    private  Fibonaccipuu min;
    private int n;
    
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
                Fibonaccikeko keko = this.makeHeap();
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
        removeMin(minimi);
        
        if (minimi.hasSibling()){
            this.setMin(minimi.getSiblingR());
            sulauta(this.getMin(),lapsi);
        }
        else {
            this.setMin(lapsi);
        }
        //kay juurilista lapi ja null parent ja laske samalla
        //pienin arvo ,paivita se
        //todo yhdista samanasteiset
        n--;
        puhdista();
        return minimi.getValue();
    }
    
    /**
     * Poistaa min alkion juurilistasta ja
     * päivittää minimin vasemman ja oikean alkion
     * linkit juurilistassa
     * @min Fibonaccipuu olio poistettava olio jonka
     * sisrukset linkitetään yhteen
     */
    private void removeMin(Fibonaccipuu min){
        if (min== null){
            return;
        }
        if (min.hasSibling()){
            Fibonaccipuu  vasen = min.getSiblingL();
            Fibonaccipuu  oikea = min.getSiblingR();
            if (!min.isSameSibling()){
                vasen.setSiblingR(oikea);
                oikea.setSiblingL(vasen);
            }
            else {
                vasen.setSiblingL(null);
                oikea.setSiblingR(null);
            }
        }
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
    }
    
    /**
     * Päivittää juurilistan parent viittaukset null:ksi
     * sekä linkittää juurilistan saman degreen omaavat yhteen
     */
    private void puhdista(){
        if (!this.getMin().hasSibling()){
            return;
        }
        int counter = 1;
        Fibonaccipuu current = this.getMin().getSiblingR();
        int minimi = this.getMin().getValue().getValue();
        while (current != null && this.getMin() != current){
            counter++;
            current.setParent(null);
            if (minimi > current.getValue().getValue()){
                minimi = current.getValue().getValue();
                this.setMin(current);
            }
            current = current.getSiblingR();
        }
        
        yhdistaSamanAsteiset(counter);
    }
    
    /*
     * KESKEN JATKA ...
     */
    private void yhdistaSamanAsteiset(int counter){
        int maxaste = 0;
        double j = 2;
        maxaste =( int)(Math.log(n)/Math.log(j));
        Fibonaccipuu [] asteet = new Fibonaccipuu[maxaste+1];
        Fibonaccipuu curr = this.getMin();
        asteet[curr.getDegree()]= curr;
        curr = curr.getSiblingR();
        Fibonaccipuu tupla = null;
        while (curr != null && curr != this.getMin()){
            tupla = asteet[curr.getDegree()];
            if (tupla != null){
               asteet[curr.getDegree()] = null;
               if (curr.getValue().getValue()>=tupla.getValue().getValue()){
                   //poista curr juurilistasta ja linkita tupla ja curr
               }
            }
        }
    }
    
    /**
     *
     */
    public void decreaseKey(){
        /* to be implemented*/ 
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
        if (keko1== null || keko2==null){
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
        uusiMin = keko.getMin();
        Fibonaccipuu keko1vasen = keko1.getMin().getSiblingL();
        Fibonaccipuu keko2vasen = keko2.getMin().getSiblingL();
        if (keko1vasen == null){
            asetaLinkit(suurempi,uusiMin );
            if (keko2vasen!= null){
                asetaLinkit(uusiMin,keko2vasen );
            }
            else {
                asetaLinkit(uusiMin,suurempi );
            }
        }
        else {
            asetaLinkit(suurempi,keko1vasen );
            if (keko2vasen!= null){
                asetaLinkit(uusiMin,keko2vasen );
            }
            else {
                asetaLinkit(uusiMin,suurempi );
            }
        }
        return keko;        
    }
    
    private static void asetaLinkit(Fibonaccipuu vasen, Fibonaccipuu oikea){
        if (vasen == null || oikea == null){
            return;
        }
        vasen.setSiblingL(oikea);
        oikea.setSiblingR(vasen);
    }
    
    private static Fibonaccikeko nullVersionMerge(Fibonaccikeko keko1, Fibonaccikeko keko2){
        Fibonaccikeko keko = null;
        if (keko1== null && keko2==null){
            return null;
        }
        keko = Fibonaccikeko.makeHeap();
        if (keko1 == null && keko2 != null){
            keko.setMin(keko2.getMin());
            keko2 = null;
        }
        else if (keko2 == null && keko1 != null){
            keko.setMin(keko1.getMin());
            keko1 = null;
        }
        return keko;
    }
}
