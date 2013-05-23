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
       // System.out.println("insert() BEGIN "+this);
       // System.out.println("heapSize ennen lisaysta="+heapSize);
        heapSize = heapSize +1;
       // System.out.println("heapSize kasvatettu="+heapSize);
        x.setKey(heapSize-1);
       // System.out.println("uuden olion key="+x.getKey());
        if(heapSize == 1){
            min = x;
        }
        if (tail!=null){
            tail.setRight(x);
        }      
        x.setLeft(tail);
        tail = x;
        decreaseKey(x,x.getValue());
        //System.out.println("-----------------------insert() END "+this);
        //System.out.println("insert() end");
    }
    
    /**
     * Poistaa pienimmän alkion keosta ja palauttaa osoittimen ko alkioon
     * @return 
     */
    public Solmu deleteMin(){
        //System.out.println("deleteMin() BEGIN"+this);
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
        //System.out.println("deleteMin() END"+this);
        return mini;
    }
    
    
    private void minHeapify(Solmu solmu){
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
            solmu = muutaOsoittimet(pienin,solmu);
            minHeapify(solmu);
        }
    }
    
    /*
     * dkeon lapset i = parent,
     * id +1,id+2,..,id +d
     * @param solmu, vanhempi solmu, jonka lasta etsitään
     * @return Solmu luokan olio tai null, jos lasta ei ole
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
        int res = error;
       // System.out.println("decreaseKey()");
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
        //System.out.println("vaihdaJarjestys lapsi.getValue="+lapsi.getValue());
        if (lapsi != null && lapsi == min ){
           // System.out.println("lapsi==min");
           // System.out.println("heapSize="+heapSize);
            return res;
        }
        
        Solmu solmu;
        int p =  countParent(lapsi.getKey());
        solmu = findSolmu(p);
        if (solmu == null ){
           // System.out.println("solmu==null");
            return error;  
        }
        if (solmu.getValue() > lapsi.getValue()){
           // System.out.println("parent.value > lapsi.value");
            lapsi = muutaOsoittimet(solmu,lapsi);
            res = vaihdaJarjestys(lapsi);
        }
        return res;
    }
    
    /**
     * Vaihdetaan Solmun paikkaa keossa,left ja right 
     *  linkit päivitetään, sekä key arvo
     * @param s1 vaihdettava solmu,lapsi tai aikuinen
     * @param s2 keossa kohteena oleva solmu
     * @return null, jos s1 tai s2 ovat null,muutoin s2 olio
     */
    private Solmu muutaOsoittimet(Solmu s1, Solmu s2){
        System.out.println("muutaOsoittimet()"); 
       
        if (s1 == null || s2 == null){
            System.out.println("s1==null || s2== null");
            return null;
        }
     //   System.out.println("p.value="+s1.getValue()+" p.key="+s1.getKey());
     //   System.out.println("l.value="+s2.getValue()+" l.key="+s2.getKey());
        
        Solmu solmuL1 = s1.getLeft();
        Solmu solmuR1 = s1.getRight();
        Solmu solmuL2 = s2.getLeft();
        Solmu solmuR2 = s2.getRight();
        
        if (heapSize == 2){
            s1.setLeft(s2);
            s1.setRight(s2.getRight());
            s2.setLeft(s1.getLeft());
            s2.setRight(s1);
        }
        else{
            s1.setLeft(solmuL2);
            s1.setRight(solmuR2);
            s2.setLeft(solmuL1);
            s2.setRight(solmuR1);
        
            if (solmuL1!=null){
                solmuL1.setRight(s2);
            }
            if (solmuL2!=null){
                solmuL2.setRight(s1);
            }
            if (solmuR1!=null){
                solmuR1.setLeft(s2);
            }
            if (solmuR2!=null){
                solmuR2.setLeft(s1);
            }
        } 
        
        int apu;
        apu = s1.getKey();
        s1.setKey(s2.getKey());
        s2.setKey(apu);
        updateMinTail(s1,s2);
        
        /*
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
        * */
        return s2;
    }
    
    /*
     * Päivitetään dkeon min ja tail 
     */
    private void updateMinTail(Solmu s1,Solmu s2){
        if (s2 == tail){
          //  System.out.println("updateMinTail s2 old tail, s1 new tail");
            tail = s1;
        }
        else if (s1 == tail){
          //  System.out.println("updateMinTail s1 old tail, s2 new tail");
            s2 = tail;
        }
        
        if (s1 == min){
          // System.out.println("updateMinTail s1 old min, s2 new min");
           min=s2;
        }
        else if (s2 == min){
         //   System.out.println("updateMinTail s2 old min, s1 new tail");
            min = s1;
        }
    }
    
    /**
     *
     * @param child Solmu luokan olion key arvo, jonka vanhempaa etsitään
     * @return vanhemman key arvo
     */
    private int countParent(int child){
        System.out.println("countParent child.key="+child);
        int p = error;
        if (child ==0){
            return p;
        }
        p = (child-1)/d;
        System.out.println("parent key="+p);
        return p;
    }
    
    /**
     * Etsitään key arvoa vastaavaa Solmu luokan oliota Dkeosta
     * @param key Solmu luokan olion key arvo 
     * @return Solmu olio tai null jos key arvoa vastaavaa oliota ei löydy
     */
    private Solmu findSolmu(int key) {
       // System.out.println("findSolmu() key="+key);
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
    
    @Override
    public String toString(){
        String keko = "";
        keko = "\n Dkeko: d="+d+" heapSize="+heapSize+"\n";
        if (heapSize >0){
            //keko=keko+" min key="+min.getKey()+" min value="+min.getValue()+"\n";
            //keko=keko+" tail key="+tail.getKey()+" tail value="+tail.getValue()+"\n\n";
            Solmu next = min;
            int count = 0;
            int kerroin = 0;
            for (int i=0;i< heapSize;i++){
                next = findSolmu(i);
                count++;
                if(next!=null){
                    keko=keko+"| v="+next.getValue()+" k="+next.getKey()+" ";
                    if (count==(int)Math.pow(d, kerroin)){
                        kerroin++;
                        keko=keko+"\n";
                        count=0;
                    }
                }
                
            }
        }
        
        return keko;
    }
    
    
}
