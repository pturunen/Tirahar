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
        this.heapSize =0;
        this.min = null;
        this.tail = min;        
    }
    
    Dkeko(int k,int heapSize,Solmu min,Solmu tail){
        this.d = k;
        this.heapSize =heapSize;
        this.min = min;
        this.tail = tail;        
    }
    
    /**
     * Luo uuden tyhjän keon
     */
    public static Dkeko makeHeap(int d){
        return new Dkeko(d);
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
        System.out.println("deleteMin()-->"+this);
        Solmu mini = min;
        Solmu newTail = null;
        if (heapSize > 0){
           System.out.println("min.v="+min.getValue()+" min.k="+min.getKey());
           min = tail;
           newTail = tail.getLeft();
           System.out.println("min.v="+min.getValue()+" min.k="+min.getKey());
           System.out.println("tail.v="+tail.getValue()+" tail.k="+tail.getKey());
           min.setLeft(mini.getLeft());
           min.setRight(mini.getRight());
           if (mini.getRight()!=null){
               mini.getRight().setLeft(min);
           }
           min.setKey(mini.getKey());
           tail = newTail;
           if (newTail!=null){
               newTail.setRight(null);
           }
           heapSize = heapSize -1;
           if (heapSize > 1){
               minHeapify(min);
           }
           if (heapSize == 0){
               min = null;
           }
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
        //System.out.println("-----------------------decreaseKey() before "+this);
        if (x.getKey() < 0 || x.getKey() >= heapSize){
            return res;
        }
        if (x.getValue() < value){
            return error;
        }
        x.setValue(value);
        res = vaihdaJarjestys(x);
        //System.out.println("------------------------decreaseKey() after "+this);
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
           //System.out.println("lapsi==min");
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
            //System.out.println("parent.value > lapsi.value");
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
        if (s1 == null || s2 == null){
            return null;
        }
        int apu;
        apu = s1.getKey();
        s1.setKey(s2.getKey());
        s2.setKey(apu);
        updateMinTail(s1,s2);
        //L1<-->S1<-->R1  L2<--->S2<--->R2
        Solmu solmuL = s1.getLeft();
        if (solmuL != null){
            solmuL.setRight(s2);
        }
        s1.setLeft(s2.getLeft());
        if (s2.getLeft()!=null){
            s2.getLeft().setRight(s1);
        }
        s2.setLeft(solmuL);
        if (solmuL!= null){
            solmuL.setRight(s2);
        }
        Solmu solmuR = s1.getRight();
        if (solmuR != null){
            solmuR.setLeft(s2);
        }
        s1.setRight(s2.getRight());
        if (s2.getRight()!= null){
            s2.getRight().setLeft(s1);
        }
        s2.setRight(solmuR);
        if (s1.getRight()!=null){
            s1.getRight().setLeft(s1);
        }
        return s2;
    }
    
    /*
     * Päivitetään dkeon min ja tail 
     */
    private void updateMinTail(Solmu s1,Solmu s2){
        if (s2 == tail){
            tail = s1;
        }
        else if (s1 == tail){
            s2 = tail;
        }
        
        if (s1 == min){
           min=s2;
        }
        else if (s2 == min){
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
        if(this.findSolmu(p)!=null){
            System.out.println("parent value"+this.findSolmu(p).getValue());
        }
        
        return p;
    }
    
    /**
     * Etsitään key arvoa vastaavaa Solmu luokan oliota Dkeosta
     * @param key Solmu luokan olion key arvo 
     * @return Solmu olio tai null jos key arvoa vastaavaa oliota ei löydy
     */
    private Solmu findSolmu(int key) {
        Solmu solmu = min;
        if (min!=null){
            for (int i=0;i<heapSize;i++){
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
     * Uuden keon heapSize on suuremman keon heapSize
     * @param t1 yhdistettävä Dkeko olio, ei saa olla null
     * @param t2 yhdistettävä Dkeko olio, ei saa olla null
     * @return uusi Dkeko olio, tai null jos t1 tai t2 null
     */
    public static Dkeko merge(Dkeko t1, Dkeko t2){
        
        /* to be implemented*/ 
        //TODO
        Dkeko suuri=null;
        Dkeko pieni=null;
        if (t1==null || t2==null){
            return null;
        }
        
        if (t1.getHeapSize() > t2.getHeapSize()){
             System.out.println("merge t1 > t2");
            suuri =t1;
            pieni =t2;
        }
        else {
            System.out.println("merge t2 > t1 ");
            suuri =t2;
            pieni =t1;
        }
        
        Dkeko uusi = null;
        uusi = new Dkeko(suuri.getAste(),suuri.getHeapSize(),
                                    suuri.findMin(),suuri.getTail());
        
        System.out.println("uusi.min.value="+uusi.findMin().getValue());
        System.out.println("uusi.tail.value="+uusi.getTail().getValue());
        System.out.println("uusi.HeapSize="+uusi.getHeapSize());
        
        suuri=null;
        for (int i=0;i < uusi.getHeapSize();i++){
            System.out.println(uusi.findSolmu(i).getValue());
        }
        Solmu solmu =null;
        
        System.out.println("uusi keko ennen yhdistysta "+uusi);
        
        while (pieni.findMin()!=null){
            solmu = pieni.deleteMin();
            System.out.println("pienen solmu ="+solmu.getValue()+" solmu.key"+solmu.getKey());
            uusi.insert(solmu);
        }
        return uusi;
    }
    
    
    public int getHeapSize(){
        return this.heapSize;
    }
    
    public Solmu getTail(){
        return this.tail;
    }
    
    public int getAste(){
        return d;
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
