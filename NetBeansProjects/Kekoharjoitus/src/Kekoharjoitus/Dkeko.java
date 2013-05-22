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
    
    /**
     * Dkeon konstruktori
     * @param k alustaa d keon haarautumisasteen
     */
    Dkeko(int k){
        this.d = k;
    }
    
    /**
     * Luo uuden tyhjän keon
     */
    public void makeHeap(){
        //todo:tarkista voiko tämä muodostaa taulukosta
        //Solmu olioita minheapin.
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
        if(tail!=null){
            tail.setRight(x);
            
        }
        if(heapSize == 1){
            min = x;
        }
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
        Solmu mini = min;
        if (heapSize > 0){
           min = tail;
           min.setLeft(mini.getLeft());
           min.setRight(mini.getRight());
           min.setKey(mini.getKey());
           tail = tail.getLeft();
           heapSize = heapSize -1;
           minHeapify(min);
        }
        return mini;
    }
    
    
    private void minHeapify(Solmu solmu){
        //todo:lapsia d maara 1 to d
        if(heapSize == 0 || heapSize ==1){
            return;
        }
        Solmu lapsi = null;
        Solmu pienin = solmu;
        for (int i=1;i<= d;i++){
            lapsi = annaLapsi(solmu,i);
            if (lapsi!=null){
                if (lapsi.getKey() <= heapSize && lapsi.getValue() < pienin.getValue()){
                    pienin = lapsi;
                }
            }
        }
        if (pienin != solmu){
            //vaihdetaan solmujen paikkaa
            solmu = muutaOsoittimet(pienin,solmu);
            minHeapify(solmu);
        }
    }
    
    /*
     * dkeon lapset i = parent,
     * id +1,id+2,..,id +d
     */
    private Solmu annaLapsi(Solmu solmu,int monesko){
        Solmu lapsi = null;
        if (monesko > d || monesko == 0){
            return lapsi;
        }
        int lapsikey = (solmu.getKey()*d)+monesko;
        if (lapsikey < heapSize){
            lapsi = findSolmu(lapsikey);
        }
        return lapsi;
    }
    
    
    /**
     * Pienentää keossa olevan solmun arvoa ja
     * muuttaa solmun paikkaa keossa ylöspäin, jos tarve vaatii
     * @param x 
     * @param value 
     * @return 
     */
    public int decreaseKey(Solmu x,int value){
        /* to be implemented*/ 
        int res = error;
        if (x.getKey() < 0 || x.getKey() >= heapSize){
            return res;
        }
        if (x.getValue() < value){
            return error;
        }
        x.setValue(value);
        res = vaihdaJarjestys(x);
        return res;
    }
    
    /**
     *
     * @param lapsi Solmu olio, jota verrataan olion vanhempaan keossa
     * Jos vanhemman value arvo on suurempi, lapsi ja vanhempi vaihtavat
     * paikkaa keossa.Edetään keossa ylöspäin kunnes ollaan juuressa tai 
     * ei enää vaihtoa.
     * @return -1, jos virhe, muutoin 0
     */
    private int vaihdaJarjestys(Solmu lapsi){
        int res=0;
        
        if (lapsi != null && lapsi == min ){
            return res;
        }
        
        Solmu solmu;
        int p =  countParent(lapsi.getKey());
        solmu = findSolmu(p);
        if (solmu == null ){
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
     * @param s2 keossa kohteena oleva solmu
     * @return null, jos s1 tai s2 ovat null,muutoin s2 olio
     */
    private Solmu muutaOsoittimet(Solmu s1, Solmu s2){
        //todo:korjaa null tarkistukset heti alkuun
        //turha ja epaselva tarkastella pitkin matkaa!
        Solmu solmuL;
        Solmu solmuR;
        if (s1 == null || s2 == null){
            return null;
        }
        int apu;
        apu = s1.getKey();
        s1.setKey(s2.getKey());
        s2.setKey(apu);
        updateMinTail(s1,s2);
        solmuL = s1.getLeft();
        if (solmuL != null){
            solmuL.setRight(s2);
        }
        
        s1.setLeft(s2.getLeft());
        s2.getLeft().setRight(s1);
        s2.setLeft(solmuL);
        solmuR = s1.getRight();
        if (solmuR != null){
            solmuR.setLeft(s2);
        }
        
        s1.setRight(s2.getRight());
        s2.setRight(solmuR);
        if (s1.getRight()!=null){
            s1.getRight().setLeft(s1);
        }
        return s2;
    }
    
    
    private void updateMinTail(Solmu s1,Solmu s2){
        if (s2 == tail){
            tail = s1;
        }
        if (s1 == min){
            min=s2;
        }
        if (s1 == tail){
            s2 = tail;
        }
        if (s2 == min){
            min = s1;
        }
    }
    
    /**
     *
     * @param child
     * @return
     */
    private int countParent(int child){
        int p = error;
        if (child ==0){
            return p;
        }
        p = (child-1)/d;
        return p;
    }
    
    /**
     *
     * @param key
     * @return Solmu olio, joka vastaa key arvoa
     */
    private Solmu findSolmu(int key) {
        Solmu solmu = min;
        if (min!=null){
            for (int i=min.getKey();i<heapSize;i++){
                if (solmu.getKey()== key){
                    return solmu;
                }
                solmu = solmu.getRight();
            }
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
