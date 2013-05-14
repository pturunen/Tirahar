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
     */
    public void insert(Solmu x){
        /* to be implemented*/
        /* update */
        heapSize = heapSize +1;
        Solmu uusi = new Solmu();
        uusi.setKey(heapSize-1);
        tail.setRight(uusi);
        decreaseKey(uusi,x.getValue());
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
     * Muuttaa keossa olevan alkion x arvoa pienemmäksi arvoon k
     */
    public int decreaseKey(Solmu x,int value){
        /* to be implemented*/ 
        /* nyt vaihdetaan olion arvo, pitaisko vaihtaa olio*/
        int res = ok;
        if(x.getKey() < 0 || x.getKey() >= heapSize){
            return error;
        }
        x.setValue(value);
        res = vaihdaJarjestys(x);
        return res;
    }
    
    public int vaihdaJarjestys(Solmu lapsi){
        int res=0;
        if(lapsi != null &&lapsi.getKey()==min.getKey() ){
            return res;
        }
        Solmu solmu=null;
        int p =  countParent(lapsi.getKey());
        solmu = findSolmu(p);
        if(solmu == null ){
            return error;  
        }
        if (solmu.getValue() > lapsi.getValue()){
            int apu = solmu.getValue();
            solmu.setValue(lapsi.getValue());
            lapsi.setValue(apu);
            res = vaihdaJarjestys(lapsi);
        }
        return res;
    }
    
    public int countParent(int child){
        int p = error;
        if(child ==0){
            return error;
        }
        p = (child-1)/d;
        return p;
    }
    
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
