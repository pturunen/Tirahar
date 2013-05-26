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
    public Kekoalkio(){
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
    public Kekoalkio(Solmu value) {
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
    public Kekoalkio getLeft() {
        return this.left;
    }

    /**
     * Kekoalkio oliot on talletettu kaksisuuntaiseen linkitettyyn listaan
     * Kekoalkio oliossa on linkki edelliseen ja seuraavaan Kekoalkio olioon
     * @return Kekoalkio olio seuraavaan Kekoalkio olioon linkitetysssä listassa
     */
    public Kekoalkio getRight() {
        return this.right;
    }
    
 
     /**
     * Kekoalkio oliot on talletettu kaksisuuntaiseen linkitettyyn listaan
     * Kekoalkio oliossa on linkki edelliseen ja seuraavaan Kekoalkio olioon
     * @param vasen Kekoalkio olio, joka asetetaan ko Kekoalkio olion edelle
     *  linkitetyssä listassa
     */
    public void setLeft(Kekoalkio vasen){
        this.left = vasen;
    }

    /**
     * Kekoalkio oliot on talletettu kaksisuuntaiseen linkitettyyn listaan
     * Kekoalkio oliossa on linkki edelliseen ja seuraavaan Kekoalkio olioon
     * @param oikea  Kekoalkio olio, joka asetetaan ko Kekoalkio oliota seuraavaksi
     *  linkitetyssä listassa
     */
    public void setRight(Kekoalkio oikea){
        this.right = oikea;
    }
    
    /**
     * Funktio palauttaa Solmu olion
     * @return Solmu olio
     */
    public Solmu getValue() {
        return this.solmu;
    } 
    
    /**
     * Funktio asettaa Solmu olion Kekoalkion value kenttään
     * @param value Solmu luokan olio 
     */
    public void setValue(Solmu value){
        this.solmu = value;
    }
    
    /**
     * Funktio palauttaa Kekoalkion key arvon
     * key arvo kertoo Solmu olion paikan keossa
     * arvoalue 0-(keonkoko-1).key arvolla 0 löytyy
     * keon minimiarvo
     * @return int 
     */
    public int getKey(){
        return this.key;
    }

    /**
     * Funktio asettaa Kekoalkion key arvon
     * key arvo kertoo Solmu olion paikan keossa
     * arvoalue 0-(keonkoko-1).key arvolla 0 löytyy
     * keon minimiarvo
     * @param key int 
     * @return palauttaa nollan, jos asetettu arvo oli validi,
     * muutoin arvoa ei aseteta ja palautetaan -1
     */
    public int setKey(int key){
        if (key < 0){
            return -1;
        }
        this.key = key;
        return 0;
    }
    
}
