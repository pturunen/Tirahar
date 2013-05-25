/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kekoharjoitus;

/**
 * Kekoalkio luokan oliot muodostavat linkitetyn listan
 * @author pturunen
 */
public class Kekoalkio {
    
    private Kekoalkio left;
    private Kekoalkio right;
    private Solmu solmu;
    private int key;
    
    /**
     * Kekoalkio luokan konstruktori
     */
    protected Kekoalkio(){
        this.key = -1;
        this.left = null;
        this.right = null;
        this.solmu = null;
    }
    
    /**
     * Kekoalkion luokan konstruktori
     * @param value Solmu luokan olio
     * 
     */
    protected Kekoalkio(Solmu value) {
        this.solmu = value;
        this.key = -1;
        this.left = null;
        this.right = null;
    }

    /**
     * Kekoalkio oliot on talletettu kaksisuuntaiseen linkitettyyn listaan
     * Kekoalkio oliossa on linkki edelliseen ja seuraavaan Kekoalkio olioon
     * @return Kekoalkio olio edelliseen Kekoalkio olioon linkitetysssä listassa
     */
    protected Kekoalkio getLeft() {
        return left;
    }

    /**
     * Kekoalkio oliot on talletettu kaksisuuntaiseen linkitettyyn listaan
     * Kekoalkio oliossa on linkki edelliseen ja seuraavaan Kekoalkio olioon
     * @return Kekoalkio olio seuraavaan Kekoalkio olioon linkitetysssä listassa
     */
    protected Kekoalkio getRight() {
        return right;
    }
    
 
     /**
     * Kekoalkio oliot on talletettu kaksisuuntaiseen linkitettyyn listaan
     * Kekoalkio oliossa on linkki edelliseen ja seuraavaan Kekoalkio olioon
     * @param vasen Kekoalkio olio, joka asetetaan ko Kekoalkio olion edelle
     *  linkitetyssä listassa
     */
    protected void setLeft(Kekoalkio vasen){
        this.left = vasen;
    }

    /**
     * Kekoalkio oliot on talletettu kaksisuuntaiseen linkitettyyn listaan
     * Kekoalkio oliossa on linkki edelliseen ja seuraavaan Kekoalkio olioon
     * @param oikea  Kekoalkio olio, joka asetetaan ko Kekoalkio oliota seuraavaksi
     *  linkitetyssä listassa
     */
    protected void setRight(Kekoalkio oikea){
        this.right = oikea;
    }
    
    /**
     * Funktio palauttaa Solmu olion
     * @return Solmu olio
     */
    protected Solmu getValue() {
        return solmu;
    } 
    
    /**
     * Funktio asettaa Solmu olion Kekoalkion value kenttään
     * @param value Solmu luokan olio 
     */
    protected void setValue(Solmu value){
        this.solmu = value;
    }
    
    /**
     * Funktio palauttaa Kekoalkion key arvon
     * key arvo kertoo Solmu olion paikan keossa
     * arvoalue 0-(keonkoko-1).key arvolla 0 löytyy
     * keon minimiarvo
     * @return int 
     */
    protected int getKey(){
        return key;
    }

    /**
     * Funktio asettaa Kekoalkion key arvon
     * key arvo kertoo Solmu olion paikan keossa
     * arvoalue 0-(keonkoko-1).key arvolla 0 löytyy
     * keon minimiarvo
     * @param key int
     */
    protected void setKey(int key){
        this.key = key;
    }
    
}
