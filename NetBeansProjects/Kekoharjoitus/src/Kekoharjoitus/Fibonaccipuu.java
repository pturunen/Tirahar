/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kekoharjoitus;

/**
 *
 * @author pturunen
 */
public class Fibonaccipuu {
    private Fibonaccipuu parent;
    private Boolean marked;
    private Fibonaccipuu siblingR;
    private Fibonaccipuu siblingL;
    private Fibonaccipuu child;
    private int degree;
    private Solmu solmu;
    
    /**
     * Fibonaccipuu luokan konstruktori
     */
    public Fibonaccipuu(){
        this.parent = null;
        this.marked = false;
        this.siblingL = null;
        this.siblingR = null;
        this.child = null;
        this.solmu = null;
        this.degree = 0;
    }
    
    /**
     * Fibonaccipuu luokan konstruktori
     * @param value Solmu luokan olio
     * 
     */
    public Fibonaccipuu(Solmu value) {
        this.solmu = value;
        this.parent = null;
        this.child = null;
        this.siblingL = null;
        this.siblingR = null;
        this.marked = false;
    }

    /**
    * Funktio palauttaa Fibonaccipuu olion ensimmäisen lapsen
    * @return Fibonaccipuu olio tai null, jos lapsia ei ole
    */
    public Fibonaccipuu getChild() {
        return this.child;
    }
    
    /**
    * Funktio asettaa Fibonaccipuu olion ensimmäisen lapsen 
    * @param child Fibonaccipuu 
    */
    public void setChild(Fibonaccipuu child){
        this.child = child;
    }

    /**
     * Funktio palauttaa tiedon onko oliolla sisaruksia
     * Yksi olio;vasen ja oikea sibling null
     * Yksi tai useampi sisarus, vasen ja oikea != null
     * @return boolean ,true jos ainakin yksi sisarus, false
     * muutoin
     */
    public boolean hasSibling(){
        return this.getSiblingL() !=null;
    }
    
     /**
     * Funktio palauttaa tiedon onko vasen ja oikea sisarus sama
     * olio
     * @return boolean ,true jos sama olio, muutoin false eli
     * Fibonaccipuu olioita enenmmän kuin kaksi
     */
    public boolean isSameSibling(){
        return this.getSiblingL() == this.getSiblingR();
    }
    
    /**
    * Funktio palauttaa Fibonaccipuu olion oikeanpuoleisen sisaruksen
    * @return Fibonaccipuu olio tai null, jos sisarusta ei ole
    */
    public Fibonaccipuu getSiblingR() {
        return this.siblingR;
    }
    
    /**
    * Funktio palauttaa Fibonaccipuu olion vasemmanpuoleisen sisaruksen
    * @return Fibonaccipuu olio tai null, jos sisarusta ei ole
    */
    public Fibonaccipuu getSiblingL() {
        return this.siblingL;
    }
    
    /**
    * Funktio asettaa Fibonaccipuu olion oikeanpuoleisen sisaruksen 
    * @param sibling Fibonaccipuu 
    */
    public void setSiblingR(Fibonaccipuu sibling){
        this.siblingR = sibling;
    }
    
    /**
    * Funktio asettaa Fibonaccipuu olion vasemmanpuoleisen sisaruksen 
    * @param sibling Fibonaccipuu 
    */
    public void setSiblingL(Fibonaccipuu sibling){
        this.siblingL = sibling;
    }
    
    /**
    * Funktio palauttaa Solmu olion
    * @return Solmu olio
    */
    public Solmu getValue() {
        return this.solmu;
    } 
    
    /**
    * Funktio asettaa Solmu olion Fibonaccipuu olion value kenttään
    * @param value Solmu luokan olio 
    */
    public void setValue(Solmu value){
        this.solmu = value;
    }
    
    /**
    * Funktio palauttaa Fibonaccipuu olion vanhemman
    * @return Fibonaccipuu olio tai null, jos vanhempaa ei ole 
    */
    public Fibonaccipuu getParent(){
        return this.parent;
    }

    /**
    * Funktio asettaa Fibonaccipuu olion vanhemman 
    * @param parent Fibonaccipuu 
    */
    public void setParent(Fibonaccipuu parent){
        this.parent = parent;
    }
    
    /**
    * Funktio palauttaa tiedon onko alkio merkitty
    * @return Boolean arvo true, jos alkio merkitty
    * muutoin arvo false
    */
    public Boolean getMarkedInfo(){
        return this.marked;
    }

    /**
    * Funktio asettaa alkion joko merkityksi tai merkitsemättömäksi
    * @param parent Boolean arvo true, jos alkio merkitään
    * muutoin false
    */
    public void setMarkedInfo(Boolean marked){
        this.marked = marked;
    }
    
     /**
     * Asettaa Fibonaccipuu olion lapsien lukumäärän
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
     * Palauttaa Fibonaccipuu olion lapsien lukumäärän
     * @return  Fibonaccipuu olion degree arvo kokonaisluku
     * palauttaa 0, jos lapsia ei ole
     */
     public int getDegree(){
        return this.degree;
    }
}
