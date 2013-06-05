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
        //todo
        //juurilistaMin osoittaa juurilistan Binomipuu olioon,
        //jonka degree on pienin.binomikeon juurilista on järjestyksessä
        //pienimmästä degreestä isompaan.
        //juurilista on käytävä läpi ja etsittava pienimman
        //Binomipuu.getValue.getValue omaava juurisolmu
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
        /* to be implemented*/
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
            count = count + juurialkio.getDegree();
            juurialkio = juurialkio.getSibling();
        }
        return count;
    }
}
