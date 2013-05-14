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

    public Solmu(){
        this.key = -1;
        this.left = null;
        this.right = null;
        this.value = Integer.MAX_VALUE;
    }
    
    public Solmu(int value, Solmu left, Solmu right) {
        this.value = value;
        this.key = -1;
        this.left = left;
        this.right = right;
    }

    public Solmu(int value) {
        this.value = value;
        // left ja right ovat null
    }

    public Solmu getLeft() {
        return left;
    }

    public Solmu getRight() {
        return right;
    }
    
    public void setLeft(Solmu vasen){
        this.left = vasen;
    }

    public void setRight(Solmu oikea){
        this.right = oikea;
    }
    
    public int getValue() {
        return value;
    } 
    
    public void setValue(int value){
        this.value = value;
    }
    
    public int getKey(){
        return key;
    }

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
