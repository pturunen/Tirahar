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

    public Solmu(int value, Solmu left, Solmu right) {
        this.value = value;
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

    public int getValue() {
        return value;
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
