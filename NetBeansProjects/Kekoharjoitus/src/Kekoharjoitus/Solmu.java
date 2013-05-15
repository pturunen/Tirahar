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
     *
     */
    protected Solmu(){
        this.key = -1;
        this.left = null;
        this.right = null;
        this.value = Integer.MAX_VALUE;
    }
    
    /**
     *
     * @param value
     * @param left
     * @param right
     */
    protected Solmu(int value, Solmu left, Solmu right) {
        this.value = value;
        this.key = -1;
        this.left = left;
        this.right = right;
    }

    /**
     *
     * @param value
     */
    protected Solmu(int value) {
        this.value = value;
        // left ja right ovat null
    }

    /**
     *
     * @return
     */
    protected Solmu getLeft() {
        return left;
    }

    /**
     *
     * @return
     */
    protected Solmu getRight() {
        return right;
    }
    
    /**
     *
     * @param vasen
     */
    protected void setLeft(Solmu vasen){
        this.left = vasen;
    }

    /**
     *
     * @param oikea
     */
    protected void setRight(Solmu oikea){
        this.right = oikea;
    }
    
    /**
     *
     * @return
     */
    protected int getValue() {
        return value;
    } 
    
    /**
     *
     * @param value
     */
    protected void setValue(int value){
        this.value = value;
    }
    
    /**
     *
     * @return
     */
    protected int getKey(){
        return key;
    }

    /**
     *
     * @param key
     */
    protected void setKey(int key){
        this.key = key;
    }
    
    public String toString() {
        String l, r;

        if (left == null)
            l = "null";
        else
            l = left.toString();

        if (right == null)
            r = "null";
        else
            r = right.toString();

        return "Solmu["+value+", "+l+", "+r+"]";
    }

}
