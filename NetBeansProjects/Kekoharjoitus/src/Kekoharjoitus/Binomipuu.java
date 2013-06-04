/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kekoharjoitus;

/**
 *
 * @author pturunen
 */
public class Binomipuu {
    
    private Binomipuu parent;
    private Binomipuu sibling;
    private Binomipuu child;
    private int degree;
    private Solmu solmu;
    
    /**
     * Binomipuu luokan konstruktori
     */
    public Binomipuu(){
        this.parent = null;
        this.sibling = null;
        this.child = null;
        this.solmu = null;
        this.degree = 0;
    }
    
    /**
     * Binomipuu luokan konstruktori
     * @param value Solmu luokan olio
     * 
     */
    public Binomipuu(Solmu value) {
        this.solmu = value;
        this.parent = null;
        this.child = null;
        this.sibling = null;
    }

    /**
    * Funktio palauttaa Binomipuu olion ensimmäisen lapsen
    * @return Binomipuu olio tai null, jos lapsia ei ole
    */
    public Binomipuu getChild() {
        return this.child;
    }
    
    /**
    * Funktio asettaa Binomipuu olion ensimmäisen lapsen 
    * @param child Binomipuu 
    */
    public void setChild(Binomipuu child){
        this.child = child;
    }

    /**
    * Funktio palauttaa Binomipuu olion sisaruksen
    * @return Binomipuu olio tai null, jos sisarusta ei ole
    */
    public Binomipuu getSibling() {
        return this.sibling;
    }
    
    /**
    * Funktio asettaa Binomipuu olion sisaruksen 
    * @param sibling Binomipuu 
    */
    public void setSibling(Binomipuu sibling){
        this.sibling = sibling;
    }
    
    /**
    * Funktio palauttaa Solmu olion
    * @return Solmu olio
    */
    public Solmu getValue() {
        return this.solmu;
    } 
    
    /**
    * Funktio asettaa Solmu olion Binomipuu olion value kenttään
    * @param value Solmu luokan olio 
    */
    public void setValue(Solmu value){
        this.solmu = value;
    }
    
    /**
    * Funktio palauttaa Binomipuu olion vanhemman
    * @return Binomipuu olio tai null, jos vanhempaa ei ole 
    */
    public Binomipuu getParent(){
        return this.parent;
    }

    /**
    * Funktio asettaa Binomipuu olion vanhemman 
    * @param parent Binomipuu 
    */
    public void setParent(Binomipuu parent){
        this.parent = parent;
    }
    
     /**
     * Asettaa Binomipuu olion lapsien lukumäärän
     * @param degree lapsien lukumäärää kokonaisluku,
     * jos arvo negatiivinen jäsenmuuttujan arvoa ei muuteta
     * arvoalue positiivinen kokonaisluku
     */
     public void setDegree(int degree){
        if (degree >= 0){
            this.degree = degree;
        }
    }
     
     /**
     * Palauttaa Binomipuu olion lapsien lukumäärän
     * @return  Binomipuu olion degree arvo kokonaisluku
     * palauttaa 0, jos lapsia ei ole
     */
     public int getDegree(){
        return this.degree;
    }
}
