/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kekoharjoitus;

/**
 *
 * @author pturunen
 */
public class Solmu {
    private int value;
    
    /**
     * Solmu luokan konstruktori
     */
        Solmu(){
        this.value = Integer.MAX_VALUE;
    }
    
    /**
     *
     * @param value Solmu luokan olion arvo, jonka mukaan
     * minimikeko on järjestetty
     */
        Solmu(int value) {
        this.value = value;
    }

    /**
     * Funktio palauttaa Solmu olion value arvon
     * @return Solmu olion parametrin value arvon
     */
    protected int getValue() {
        return value;
    } 
    
    /**
     * Funktio asettaa Solmu olion value arvon
     * @param value integer arvo 
     */
    protected void setValue(int value){
        this.value = value;
    }

}
