/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kekoharjoitus;

/**
 *
 * @author pturunen
 */
public class Dkeko {
    
    final int empty = 0;
    private int d=0;
    private int heapSize = 0;
    private Solmu min = null;
    private Solmu tail = null;
    final int error = -1;
    final int ok = 0;
    
    Dkeko(int k){
        this.d = k;
    }
    
    /**
     * Luo uuden tyhjän keon
     */
    public void makeHeap(){
        heapSize = 0;
        min = null;
        tail = min;
    }
    
    /**
     * Palauttaa keon pienimmän keyn solmun
     * @return null, jos keko tyhjä
     */
    public Solmu findMin(){
           return min;
    }
    
    /**
     * Lisää Solmu luokan olio minimikekoon
     * omistajuus olioon siirtyy 
     * @param x 
     */
    public void insert(Solmu x){
        /* to be implemented*/
        /* update */
        heapSize = heapSize +1;
        x.setKey(heapSize-1);
        tail.setRight(x);
        x.setLeft(tail);
        tail = x;
        decreaseKey(x,x.getValue());
    }
    
    /**
     * Poistaa pienimmän alkion keosta ja palauttaa osoittimen ko alkioon
     * @return
     */
    public Solmu deleteMin(){
         /* to be implemented*/
        /* delete and make heapify*/
        return min;
    }
    
    /**
     * Muuttaa keossa olevan solmun arvoa ja
     * paikkaa keossa, jos tarve vaatii
     * @param x 
     * @param value 
     * @return 
     */
    public int decreaseKey(Solmu x,int value){
        /* to be implemented*/ 
        //todo:nyt toteutus ylöspäin,po myös alaspäin
        int res = ok;
        if(x.getKey() < 0 || x.getKey() >= heapSize){
            return error;
        }
        x.setValue(value);
        res = vaihdaJarjestys(x);
        return res;
    }
    
    /**
     *
     * @param lapsi
     * @return
     */
    public int vaihdaJarjestys(Solmu lapsi){
        int res=0;
        if(lapsi != null && lapsi == min && lapsi.getKey()==min.getKey() ){
            /* oletetaan että solmu kuuluu kekoon ,validi key arvo*/
            /* todo:tarkista onko perusteltu olettamus*/
            return res;
        }
        Solmu solmu=null;
        int p =  countParent(lapsi.getKey());
        solmu = findSolmu(p);
        if(solmu == null ){
            return error;  
        }
        if (solmu.getValue() > lapsi.getValue()){
            lapsi = muutaOsoittimet(solmu,lapsi);
            res = vaihdaJarjestys(lapsi);
        }
        return res;
    }
    
    /**
     * Vaihdetaan Solmun paikkaa keossa,left ja right 
     *  linkit päivitetään, sekä key arvo
     * @param s1 
     * @param s2 
     * @return null, jos s1 tai s2 ovat null,muutoin s2 olio
     */
    public Solmu muutaOsoittimet(Solmu s1, Solmu s2){
        Solmu solmuL=null;
        Solmu solmuR=null;
        if(s1 == null || s2 == null){
            return null;
        }
        int apu=0;
        apu = s1.getKey();
        s1.setKey(s2.getKey());
        s2.setKey(apu);
        if(s2 == tail){
            tail = s1;
        }
        if(s1 == min){
            min=s2;
        }
        solmuL = s1.getLeft();
        solmuL.setRight(s2);
        s1.setLeft(s2.getLeft());
        s2.getLeft().setRight(s1);
        s2.setLeft(solmuL);
        
        solmuR = s1.getRight();
        solmuR.setLeft(s2);
        s1.setRight(s2.getRight());
        s2.setRight(solmuR);
        s1.getRight().setLeft(s1);
        
        return s2;
    }
    
    
    /**
     *
     * @param child
     * @return
     */
    public int countParent(int child){
        int p = error;
        if(child ==0){
            return error;
        }
        p = (child-1)/d;
        return p;
    }
    
    /**
     *
     * @param key
     * @return Solmu olio, joka vastaa key arvoa
     */
    public Solmu findSolmu(int key) {
        Solmu solmu = min;
        for(int i=min.getKey();i<heapSize;i++){
            if(solmu.getKey()== key){
                return solmu;
            }
            solmu = solmu.getRight();
        }
        return null;
    }
    
    /**
     * Yhdistää kaksi kekoa toisiinsa,luoden uuden keon ja
     * tuhoten keon T1 ja T2
     */
    public void merge(/*heap1, heap2*/){
        /* to be implemented*/ 
    }
}
