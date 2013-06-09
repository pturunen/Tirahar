/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kekoharjoitus;

/**
 * 
 * @author pturunen
 */
public class Binomikeko {
    
    private  Binomipuu juurilistaMin;
    
    
    public Binomikeko(){
        this.juurilistaMin = null;
    }
    
    /**
     * Luo uuden tyhjän binomikeon
     * @return Binomikeko luokan olion
     */
    public static Binomikeko makeHeap(){
        Binomikeko binomikeko = new Binomikeko();
        return binomikeko;
    }
    
    /**
     * Palauttaa keon pienimmän arvon eli Solmu olion,
     * jonka value arvo on keon pienin.Solmu säilyy keossa
     * @return null, jos keko tyhjä, muutoin Solmu luokan olio
     */
    public Solmu findMin(){
        Binomipuu binomipuu= juurilistaMin;
        Solmu pienin = null;
        if (binomipuu != null){
            pienin = juurilistaMin.getValue();
            while (pienin != null && binomipuu != null){
                if (binomipuu.getValue() != null && 
                        pienin.getValue() > binomipuu.getValue().getValue()){
                        pienin = binomipuu.getValue();
                    }
                    binomipuu = binomipuu.getSibling();
                }
        }
        return pienin;
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
     Binomipuu uusi = createNewBinomipuu(x);
     if (uusi != null && this.getJuuriListaMin()!=null)  {
        Binomikeko keko = this.makeHeap();
        keko.setjuuriListMin(uusi);
        Binomikeko temp=Binomikeko.merge(keko, this);
        this.setjuuriListMin(temp.getJuuriListaMin());
     }
     else {
         this.setjuuriListMin(uusi);
     }
    }
    
    /**
     * Yhdistää kaksi binomipuuta toisiinsa
     * @param juuri Binomipuu olio johon liitetään lapsi
     * @param lapsi Binomipuu olio joka liitetään juureen
     * Mitään ei tehdä jos jompikumpi annetuista parametreista 
     * on null.
     */
    private void link(Binomipuu juuri, Binomipuu lapsi){
        if (lapsi != null && juuri != null){
            lapsi.setParent(juuri);
            lapsi.setSibling(juuri.getChild());
            juuri.setChild(lapsi);
            juuri.setDegree(juuri.getDegree()+ 1);
        }
    }
    
    /**
     * Luodaan uusi Binomipuu olio jonka jäsenmuuttujaksi asetetaan
     * parametrina annettu Solmu olio
     * @param x Solmu luokan olio josta luodaan uusi Binomipuu olio
     * @return Binomipuu olio
     */
    private Binomipuu createNewBinomipuu(Solmu x){
        Binomipuu puu = new Binomipuu();
        puu.setValue(x);
        return puu;
    }
    
    /**
     * Lomittaa kaksi Binomikeko olion juurilistaa toisiinsa ja
     * luo uuden Binomikeko olion
     * @param keko1 Binomikeko olio 
     * @param keko2 Binomikeko olio
     * Binomikeon juurilista täytetään pienemmästä suurempaan
     * binomipuun degree arvon perusteella.Funktio vain lisää
     * binomipuu oikeaan paikkaan listassa.Ei tee yhdistystä juurilistan
     * binomipuihin, joilla sama degree arvo.
     * @return Binomikeko ,sisältää uuden yhdistetyn juurilistan
     */
    private static Binomikeko lomitaJuuriListat(Binomikeko keko1,
                                                            Binomikeko keko2){
        Binomikeko kekoUusi = null;
        if (keko1 !=null && keko2 != null &&  
                keko1.getJuuriListaMin()!=null &&
                                        keko2.getJuuriListaMin()!=null){
            Binomipuu puu1 = keko1.getJuuriListaMin();
            Binomipuu puu2 = keko2.getJuuriListaMin();
            Binomipuu puuPrev = null;
            Binomipuu puuCurr = null;
            kekoUusi = Binomikeko.makeHeap();
            if (puu1.getDegree() <=puu2.getDegree()){
               kekoUusi.setjuuriListMin(keko1.getJuuriListaMin());
               puu1 = keko1.getJuuriListaMin().getSibling();
            }
            else {
                kekoUusi.setjuuriListMin(keko2.getJuuriListaMin());
                puu2 = keko2.getJuuriListaMin().getSibling();
            }
            puuPrev = kekoUusi.getJuuriListaMin();
            while (puu1 != null || puu2 !=null){
                if (puu1 == null ||puu2!=null && 
                        puu2.getDegree() <= puu1.getDegree()){
                    puuCurr = puu2;
                    puu2 = puu2.getSibling();
                }
                else if (puu2 == null || puu1 != null &&
                        puu1.getDegree() <= puu2.getDegree()){
                    puuCurr = puu1;
                    puu1 = puu1.getSibling();
                }
                puuPrev.setSibling(puuCurr);
                puuPrev = puuCurr;
            }
        }
        return kekoUusi;
    }
    
    /**
     * Poistaa pienimmän alkion keosta ja palauttaa osoittimen ko alkioon
     * @return Solmu luokan olio, poistetaan keosta
     */
    public Solmu deleteMin(){
        Binomipuu poista = this.findAndRemoveMin();
        Solmu solmu = null;
        if (poista != null){
            solmu = poista.getValue();
            if (poista.getChild() != null){
                Binomikeko keko = Binomikeko.makeHeap();
                insertBinomipuu(keko, poista.getChild());
                Binomikeko temp = null;
                if (this.getJuuriListaMin() != null){
                    temp=Binomikeko.merge(keko, this);
                    this.setjuuriListMin(temp.getJuuriListaMin());
                }
                else {
                    this.setjuuriListMin(keko.getJuuriListaMin());
                }
            }
        }
        
        return solmu;
    }
    
    /**
     * Kääntää lapsisolmujen järjestyksen sisaruslistassa
     * @param keko, Binomikeko jonka juuriListaMin saa uuden arvon
     * @param puu, Binomipuu olio joka aloittaa sisaruslistan
     */
    private void insertBinomipuu(Binomikeko keko, Binomipuu puu){
        if (keko == null || puu == null){
            return;
        }
        insertBinomipuu(keko, puu.getSibling()); 
        if (puu.getSibling() == null) {
            keko.setjuuriListMin(puu);
        }
    }        
            
            
    
    /**
     * Palauttaa keon pienimmän  eli Binomipuu olion juurilistasta,
     * jonka value arvo on keon pienin.Binomipuu poistetaan juurilistasta
     * @return null, jos keko tyhjä, muutoin Binomipuu luokan olio
     */
    private Binomipuu findAndRemoveMin(){
        Binomipuu curr= juurilistaMin;
        Binomipuu prev = null;
        Binomipuu pienin = null;
        Binomipuu ennenPieninta = null;
        if (curr != null){
            pienin = juurilistaMin;
            while (pienin != null && curr != null){
                if (curr.getValue() != null && 
                        pienin.getValue().getValue() >
                                                curr.getValue().getValue()){
                        pienin = curr;
                        ennenPieninta = prev;
                    }
                prev = curr;
                curr = curr.getSibling();
                    
                }
            this.removeMin(ennenPieninta,pienin);
        }
        return pienin;
    }
    
    /**
     * Poistaa keon pienimmän  eli Binomipuu olion juurilistasta,
     * jonka value arvo on keon pienin.
     * @param edellinen , Binomipuu olio juurilistassa ennen poistettavaa
     * @param poistettava, Binomipuu olio joka poistetaan juurilistasta
     * 
     */
    private void removeMin(Binomipuu edellinen,Binomipuu poistettava){   
        if (poistettava != null){
            if (edellinen == null){
                Binomipuu next = poistettava.getSibling();
                this.setjuuriListMin(next);
            }
            else {
                edellinen.setSibling(poistettava.getSibling());
            }
        }
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
    public int decreaseKey(Binomipuu binomipuu,Solmu alkio, int value){
        int error = -1;
        int ok = 0;
        Binomipuu apu = null;
        Binomipuu apu2 = null;
        if (binomipuu == null || alkio == null|| value > alkio.getValue()||
                binomipuu.getValue().getValue()!= alkio.getValue()){
            return error;
        }
        binomipuu.getValue().setValue(value);
        apu = binomipuu;
        apu2 = apu.getParent();
        while (apu2 != null &&
                apu.getValue().getValue() < apu2.getValue().getValue()){
                this.vaihdaPaikkaa(apu2, apu);
                apu = apu2;
                apu2 = apu.getParent();
        }
        return ok;
    }
    
    private void vaihdaPaikkaa(Binomipuu iso, Binomipuu pieni){
        Solmu solmu = null;
        solmu = iso.getValue();
        iso.setValue(pieni.getValue());
        pieni.setValue(solmu);        
    }
    
    
    /**
     * Yhdistää kaksi kekoa toisiinsa,luoden uuden keon ja
     * tuhoten keon T1 ja T2
     * Lomittaa juurilistat ja yhdistaa saman degreen juurilistan
     * alkiot toisiinsa.
     * @param t1 yhdistettävä Binomikeko olio, ei saa olla null
     * @param t2 yhdistettävä Binomikeko olio, ei saa olla null
     * @return uusi Binomikeko olio, tai null jos t1 tai t2 null
     */
    public static Binomikeko merge(Binomikeko t1,Binomikeko t2){
        Binomikeko uusi = lomitaJuuriListat(t1, t2);
        if (uusi !=null){
            uusi = yhdistaJuuriLista(uusi);
        }
        return uusi;
    }
    
    /**
     * Yhdistää saman degreen juurilistan
     * alkiot toisiinsa.Funktion suorituksen jalkeen vain yksi jokaista
     * degree astetta juurilistassa
     * @param keko Binomikeko olio, ei saa olla null
     * @return uusi Binomikeko olio, null jos keko oli null
     */
    private static Binomikeko yhdistaJuuriLista(Binomikeko keko){
       if (keko == null){
           return keko;
       }
       Binomipuu prev = null;
       Binomipuu curr = keko.juurilistaMin;
       Binomipuu next = curr.getSibling();
       while (next != null){
           if (curr.getDegree() != next.getDegree() ||
                   next.getSibling() != null && 
                            next.getSibling().getDegree() ==curr.getDegree()){
               prev = curr;
               curr = next;
           }
           else {
               if (curr.getValue().getValue() <= next.getValue().getValue()){
                   curr.setSibling(next.getSibling());
                   keko.link(curr, next);
               }
               else {
                   if (prev == null ){
                       keko.juurilistaMin = next;
                   }
                   else {
                       prev.setSibling(next);
                   }
                   keko.link(next, curr);
                   curr = next;
               }
           }
           next = curr.getSibling();
       }
        return keko;
    }
    
    /**
     * Palauttaa binomikeon solmujen lukumäärän
     * @return  int ,palauttaa 0, jos binomikeko on tyhjä
     */
    public int getHeapSize(){
        Binomipuu juurialkio = this.juurilistaMin;
        int count =0;
        while (juurialkio != null){
            count = count + (int)Math.pow(2,juurialkio.getDegree());
            juurialkio = juurialkio.getSibling();
        }
        return count;
    }
    
    /**
     * Palauttaa juurilistan pienimmän alkion 
     * @return Binomipuu juurilistan pienimmän degree
     * arvon omaava alkio tai null jos juurilista tyhjä
     */
    public Binomipuu getJuuriListaMin(){
        return this.juurilistaMin;
    }
  
    /**
     * Asettaa Binomikeko olion jäsenmuuttujaan
     * juurilistaMin parametrina annetun Binomipuu olion
     * 
     * @param binomipuu Binomipuu olio
     */
    private void setjuuriListMin(Binomipuu binomipuu){
        this.juurilistaMin =binomipuu;
    }
    
    /**
     * Palauttaa binomikeosta value arvoa vastaavan Binomipuu olion
     * @param puu Binomipuu olio, keon juurilistamin
     * @param value Solmu olio, jonka Binomipuu oliota haetaan
     * @return  Binomipuu olio ,palauttaa null, jos binomikeko on tyhjä
     */
    public Binomipuu findBinomipuu(Binomipuu puu,Solmu value){
        Binomipuu match = null;
        if (puu == null || value.getValue() == Integer.MAX_VALUE ){
            return null;
        }
        if (puu.getValue().getValue() == value.getValue()){
            return puu;
        }
        match = findBinomipuu(puu.getSibling(),value);
        if (match == null){
            match = findBinomipuu(puu.getChild(),value);
        }
        return match;
    }
    
}
