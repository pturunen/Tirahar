/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kekoharjoitus;

/**
 * Minimikekojen perustietorakenne
 * Solmu luokan value arvo vastaa minimikeon key arvoa.
 * Minimikeko palauttaa pienimmän keon solmun, jonka Solmu.value
 * arvo on pienin.
 * @author pturunen
 */
public class Solmu {
    private int value;
    
    /**
     * Solmu luokan konstruktori
     */
        public Solmu(){
        this.value = Integer.MAX_VALUE;
    }
    
    /**
     *
     * @param value Solmu luokan olion arvo, jonka mukaan
     * minimikeko on järjestetään
     */
        public Solmu(int value) {
        this.value = value;
    }

    /**
     * Funktio palauttaa Solmu olion value arvon
     * @return Solmu olion parametrin value arvon
     */
    public int getValue() {
        return this.value;
    } 
    
    /**
     * Funktio asettaa Solmu olion value arvon
     * @param value integer arvo 
     */
    public void setValue(int value){
        this.value = value;
    }

}
