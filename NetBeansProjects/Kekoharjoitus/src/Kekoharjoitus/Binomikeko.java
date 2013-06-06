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
     Binomipuu edellinen = null;
     if (uusi != null)  {
         edellinen = getEdellinenJuuriListassa(uusi.getDegree());
     }
     liitaJuurilistaan(edellinen, uusi);
     //todo: juurilistan lapikaynti
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
     * Liittää Binomipuu olion binomikeon juurilistaan
     * @param edellinen Binomipuu olio, jos null, Binomipuu liitetään
     * juurilistaan ensimmäiseksi,muutoin olion jälkeen
     * @param binomipuu Binomipuu olio,joka liitetään juurilistaan
     * olion sibling saa uuden arvon riippuen
     * paikasta juurilistassa
     * Binomikeon juurilista täytetään pienemmästä suurempaan
     * binomipuun degree arvon perusteella.Funktio vain lisää
     * binomipuu oikeaan paikkaan listassa.ei tee yhdistystä juurilistan
     * binomipuihin, joilla sama degree arvo.
     */
    private void liitaJuurilistaan(Binomipuu edellinen, Binomipuu binomipuu){
        if (binomipuu != null){
            if (edellinen == null ){
                if (juurilistaMin == null){
                    juurilistaMin = binomipuu;
                }
                else {
                    binomipuu.setSibling(juurilistaMin);
                    juurilistaMin = binomipuu;
                }
            }
            else {
                binomipuu.setSibling(edellinen.getSibling());
                edellinen.setSibling(binomipuu);
            }
        } 
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
        return 0;
    }
    
    /**
     * Yhdistää kaksi kekoa toisiinsa,luoden uuden keon ja
     * tuhoten keon T1 ja T2
     * @param t1 yhdistettävä Binomikeko olio, ei saa olla null
     * @param t2 yhdistettävä Binomikeko olio, ei saa olla null
     * @return uusi Binomikeko olio, tai null jos t1 tai t2 null
     */
    public static Binomikeko merge(Binomikeko t1,Binomikeko t2){
        /* to be implemented*/ 
        Binomikeko binomikeko = Binomikeko.makeHeap();
        return binomikeko;
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
     * Palauttaa juurilistasta sen binomipuu olion, jonka
     * degree arvo on pienempi kuin parametrina annettu value
     * @return  Binomipuu olio ,palauttaa null, jos binomikeko on tyhjä
     * tai juurilistan ensimmäisen degree on suurempi kuin value
     */
    private Binomipuu getEdellinenJuuriListassa(int value){
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
}
