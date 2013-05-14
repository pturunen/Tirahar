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
    public Solmu(){
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
    public Solmu(int value, Solmu left, Solmu right) {
        this.value = value;
        this.key = -1;
        this.left = left;
        this.right = right;
    }

    /**
     *
     * @param value
     */
    public Solmu(int value) {
        this.value = value;
        // left ja right ovat null
    }

    /**
     *
     * @return
     */
    public Solmu getLeft() {
        return left;
    }

    /**
     *
     * @return
     */
    public Solmu getRight() {
        return right;
    }
    
    /**
     *
     * @param vasen
     */
    public void setLeft(Solmu vasen){
        this.left = vasen;
    }

    /**
     *
     * @param oikea
     */
    public void setRight(Solmu oikea){
        this.right = oikea;
    }
    
    /**
     *
     * @return
     */
    public int getValue() {
        return value;
    } 
    
    /**
     *
     * @param value
     */
    public void setValue(int value){
        this.value = value;
    }
    
    /**
     *
     * @return
     */
    public int getKey(){
        return key;
    }

    /**
     *
     * @param key
     */
    public void setKey(int key){
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
