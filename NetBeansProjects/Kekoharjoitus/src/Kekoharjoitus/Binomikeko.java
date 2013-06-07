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
    private static Binomikeko lomitaJuuriListat(Binomikeko keko1, Binomikeko keko2){
        Binomikeko kekoUusi = null;
        if (keko1 !=null && keko2 != null &&  
                keko1.getJuuriListaMin()!=null && keko2.getJuuriListaMin()!=null){
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
         /* to be implemented*/
        return null;
    }
    
    /**
     * Pienentää keossa olevan solmun arvoa ja
     * muuttaa solmun paikkaa keossa ylöspäin, jos kekoehto rikki
     * @param alkio, Solmu olio,jonka arvoa
     * halutaan pienentää
     * @param value Solmu olion valuen uusi arvo
     * @return int saa arvon 0, tai -1 jos virhe käsittelyssä
     */
    public int decreaseKey(Solmu alkio, int value){
        /* to be implemented*/ 
        return -1;
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
                   next.getSibling() != null && next.getSibling().getDegree() ==
                   curr.getDegree()){
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
     * Palauttaa juurilistasta sen binomipuu olion, jonka
     * degree arvo on pienempi kuin parametrina annettu value
     * @return  Binomipuu olio ,palauttaa null, jos binomikeko on tyhjä
     * tai juurilistan ensimmäisen degree on suurempi kuin value
     */
  /*  private Binomipuu getEdellinenJuuriListassa(int value){
        Binomipuu juurialkio = this.juurilistaMin;
        Binomipuu edellinen =null;
        while (juurialkio != null){
            if (juurialkio.getDegree() < value){
                edellinen = juurialkio;
            }
            else {
                return edellinen;
            }
        }
        return edellinen;
    }
    * */
}
