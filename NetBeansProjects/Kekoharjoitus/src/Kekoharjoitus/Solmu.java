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
   
    private Solmu left;
    private Solmu right;
    private int value;
    private int key;

    /**
     * Solmu luokan konstruktori
     */
    protected Solmu(){
        this.key = -1;
        this.left = null;
        this.right = null;
        this.value = Integer.MAX_VALUE;
    }
    
    /**
     *
     * @param value Solmu luokan olion arvo, jonka mukaan
     * minimikeko on järjestetty
     */
    protected Solmu(int value) {
        this.value = value;
        this.key = -1;
        this.left = null;
        this.right = null;
    }

    /**
     * Solmu oliot on talletettu kaksisuuntaiseen linkitettyyn listaan
     * Solmu oliossa on linkki edelliseen ja seuraavaan Solmu olioon
     * @return Solmu olio edelliseen Solmu olioon linkitetysssä listassa
     */
    protected Solmu getLeft() {
        return left;
    }

    /**
     * Solmu oliot on talletettu kaksisuuntaiseen linkitettyyn listaan
     * Solmu oliossa on linkki edelliseen ja seuraavaan Solmu olioon
     * @return Solmu olio seuraavaan Solmu olioon linkitetysssä listassa
     */
    protected Solmu getRight() {
        return right;
    }
    
 
     /**
     * Solmu oliot on talletettu kaksisuuntaiseen linkitettyyn listaan
     * Solmu oliossa on linkki edelliseen ja seuraavaan Solmu olioon
     * @param vasen Solmu olio, joka asetetaan ko Solmu olion edelle
     *  linkitetyssä listassa
     */
    protected void setLeft(Solmu vasen){
        this.left = vasen;
    }

    /**
     * Solmu oliot on talletettu kaksisuuntaiseen linkitettyyn listaan
     * Solmu oliossa on linkki edelliseen ja seuraavaan Solmu olioon
     * @param oikea  Solmu olio, joka asetetaan ko Solmu oliota seuraavaksi
     *  linkitetyssä listassa
     */
    protected void setRight(Solmu oikea){
        this.right = oikea;
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
    
    /**
     * Funktio palauttaa Solmu olion key arvon
     * key arvo kertoo Solmu olion paikan keossa
     * arvoalue 0-(keonkoko-1).key arvolla 0 löytyy
     * keon minimiarvo
     * @return intger Solmu olion key arvo
     */
    protected int getKey(){
        return key;
    }

    /**
     * Funktio asettaa Solmu olion key arvon
     * key arvo kertoo Solmu olion paikan keossa
     * arvoalue 0-(keonkoko-1).key arvolla 0 löytyy
     * keon minimiarvo
     * @param key integer Solmu olion key arvo
     */
    protected void setKey(int key){
        this.key = key;
    }
    
    
    @Override
    public String toString() {
        String l, r;

        if (left == null){
             l = "null";
        }
        else{
            l = left.toString();
        }
        if (right == null){
            r = "null";
        }
        else {
            r = right.toString();
        }
        return "Solmu["+value+", "+l+", "+r+"]";
    }

}
