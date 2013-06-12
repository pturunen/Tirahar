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
    private int d =0;
    private int heapSize = 0;
    private Kekoalkio min = null;
    private Kekoalkio tail = null;
    final int error = -1;
    final int ok = 0;
    
    /**
     * Dkeon konstruktori
     * @param d alustaa dkeon haarautumisasteen
     */
    public Dkeko(int d){
        this.d = d;
        this.heapSize =0;
        this.min = null;
        this.tail = min;        
    }
    
    /**
     * Dkeon konstruktori
     * @param k alustaa d keon haarautumisasteen
     * @param heapSize keon koko
     * @param min Kekoalkio olio, kaksisuuntaisen linkitetyn listan 
     * ensimmäinen alkio, sisältää Solmu olion, jonka value kentän arvon
     * perusteella minimikeko palauttaa pienimmän arvon
     * @param tail Kekoalkion olio, kaksisuuntaisen linkitetyn listan viimeinen
     * alkio
     */
    public Dkeko(int k,int heapSize,Kekoalkio min,Kekoalkio tail){
        this.d = k;
        this.heapSize =heapSize;
        this.min = min;
        this.tail = tail;        
    }
    
    /**
     * Luo uuden tyhjän keon
     * @param d, alustaa dkeon haarautumisasteen
     * @return Dkeko luokan olion
     */
    public static Dkeko makeHeap(int d){
        if (d <1){
            return null;
        }
        return new Dkeko(d);
    }
    
    /**
     * Palauttaa keon pienimmän arvon eli Solmu olion,
     * jonka value arvo on keon pienin.Solmu säilyy keossa
     * @return null, jos keko tyhjä, muutoin Solmu luokan olio
     */
    public Solmu findMin(){
        Solmu result=null;
        if (this.min!=null){
            result = new Solmu(this.min.getValue().getValue());
        }
           return result;
    }
    
    /**
     * Lisää Solmu luokan olion minimikekoon
     * omistajuus olioon siirtyy 
     * @param x Solmu luokan olio,joka lisätään kekoon
     */
    public void insert(Solmu x){
       if (x == null || findKekoalkio(x)!=null) {
           return;
       }
        this.heapSize = this.heapSize +1;
        Kekoalkio alkio = new Kekoalkio();
        alkio.setKey(this.heapSize-1);
        alkio.setValue(x);
       
        if (this.heapSize == 1){
            this.min = alkio;
        }
        if (tail!=null){
            tail.setRight(alkio);
        }      
        alkio.setLeft(tail);
        tail = alkio;
        decreaseKey(tail,x.getValue());
    }
    
    /**
     * Poistaa pienimmän alkion keosta ja palauttaa osoittimen ko alkioon
     * @return Solmu luokan olio, poistetaan keosta
     */
    public Solmu deleteMin(){
        Kekoalkio mini = null;
        Solmu solmu=null;
        if (heapSize > 0){
           mini =  new Kekoalkio(min.getValue());
           min.setValue(tail.getValue()); 
           if ( tail.getLeft()!=null){
               tail.getLeft().setRight(null); 
           }
           
           tail = tail.getLeft();
           heapSize = heapSize -1;
           if (heapSize > 1){
               minHeapify(min);
           }
           if (heapSize == 0){
               min = null;
               tail=null;
           }
           solmu = mini.getValue();
        }
        return solmu;
    }
    
    /**
     * @param alkio Kekoalkio luokan olio, jos olio on 
     * rikkonut kekoehdon, funktio korjaa keon
     */
    private void minHeapify(Kekoalkio alkio){
        if(heapSize == 0 || heapSize ==1){
            return;
        }
        Kekoalkio child = null;
        Kekoalkio pienin = alkio;
        for (int i=1;i<= d;i++){
            child = getChild(alkio,i);
            if (child!=null){
                if (child.getKey() <= heapSize && 
                    child.getValue().getValue() < pienin.getValue().getValue()){
                    pienin = child;
                }
            }
        }
        Kekoalkio uusi;
        if (pienin != alkio){
            //lapsi oli pienempi,alkuper alkio putoaa keossa alemmas
            uusi = vaihdaPaikkaa(pienin,alkio);
            minHeapify(uusi);
        }
    }
    
    /**
     * Funktio palauttaa Kekoalkio olion lapsen keosta
     * @param alkio, vanhempi Kekoalkio olio, jonka lasta etsitään
     * @param monesko ,lapsien järjestysnumero väli 1-d
     * funktiolta voi kysyä yhden lapsen kerrallaan
     * @return Kekoalkio luokan olio tai null, jos lasta ei ole
     */
    private Kekoalkio getChild(Kekoalkio alkio,int monesko){
        Kekoalkio child = null;
        if (monesko > this.d || monesko == 0){
            return child;
        }
        int childKey = (alkio.getKey()*d)+monesko;
        if (childKey < this.heapSize){
            child = findSolmu(childKey);
        }
        return child;
    }
    
    /**
     * Pienentää keossa olevan solmun arvoa ja
     * muuttaa solmun paikkaa keossa ylöspäin, jos kekoehto rikki
     * @param alkio, Solmu olio,jonka arvoa
     * halutaan pienentää
     * @param value Solmu olion valuen uusi arvo
     * @return int saa arvon 0, tai -1 jos virhe käsittelyssä
     */
    public int decreaseKey(Kekoalkio alkio,int value){
        int res = error;
        if (alkio==null){
            return res;
        }
        
        if (alkio.getKey() < 0 || alkio.getKey() >= heapSize ||
                                                alkio.getValue()==null){
            return res;
        }
        if (alkio.getValue().getValue() < value){
            return error;
        }
        alkio.getValue().setValue(value);
        res = vaihdaJarjestys(alkio);
        return res;
    }
    
    /**
     *
     * @param child Kekoalkion olio, jota verrataan olion vanhempaan keossa
     * Jos vanhemman value arvo on suurempi, lapsi ja vanhempi vaihtavat
     * paikkaa keossa.Edetään keossa ylöspäin kunnes ollaan juuressa tai 
     * ei enää vaihtoa.
     * @return -1, jos virhe, muutoin 0
     */
    private int vaihdaJarjestys(Kekoalkio child){
        int res=0;
        Kekoalkio uusi;
        if (child != null && child == min ){
            return res;
        }
        Kekoalkio parent;
        int p =  countParent(child.getKey());
        parent = findSolmu(p);
        if (parent == null ){
            return error;  
        }
        if (parent.getValue().getValue() > child.getValue().getValue()){
            uusi = vaihdaPaikkaa(parent,child);
            res = vaihdaJarjestys(uusi);
        }
        return res;
    }
    
    /**
     * Vaihdetaan Solmu olion paikkaa keossa
     * @param s1 Kekoalkio olio,jonka value saa s2 valuen arvon eli Solmu olion
     * @param s2 Kekoalkio olio,jonka value saa s1 valuen arvon eli Solmu olion
     * @return null, jos virhe käsittelyssä, muutoin palauttaa s1 olion
     */
    private Kekoalkio vaihdaPaikkaa(Kekoalkio s1, Kekoalkio s2){ 
        if (s1 == null || s2 == null){
            return null;
        }
        Solmu apu;
        apu = s1.getValue();
        s1.setValue(s2.getValue());
        s2.setValue(apu);
        return s1;
    }
    
    /**
     * Funktio palauttaa paramterina annetun lapsen keyn perusteella 
     * vanhemman key arvon keossa
     * @param childKey Kekoalkion luokan olion key arvo, jonka vanhempaa etsitään
     * @return vanhemman key arvo
     */
    private int countParent(int childKey){
        int parentKey = error;
        if (childKey ==0){
            return parentKey;
        }
        parentKey = (childKey-1)/d;
        return parentKey;
    }
    
    /**
     * Etsitään key arvoa vastaavaa Kekoalkio luokan oliota Dkeosta
     * @param key Kekoalkio luokan olion key arvo 
     * @return Kekoalkio olio tai null, jos key arvoa vastaavaa oliota ei löydy
     */
    private Kekoalkio findSolmu(int key) {
        Kekoalkio alkio = min;
        if (min!=null){
            for (int i=0;i<heapSize;i++){
                if (alkio.getKey()== key){
                    return alkio;
                }
                alkio = alkio.getRight();
            }
        }
        return null;
    }
    
    /**
     * Etsitään Solmu luokan olion vastaavaa Kekoalkio luokan oliota Dkeosta
     * @param solmu Solmu luokan olion,jonka Kekoalkio halutaan saada selville 
     * @return Kekoalkio olio tai null, jos Solmua vastaavaa oliota ei löydy
     */
    public Kekoalkio findKekoalkio(Solmu solmu){
        Kekoalkio alkio = min;
        if (solmu!=null){
            for (int i=0;i<heapSize;i++){
                if (alkio.getValue().getValue()== solmu.getValue()){
                    return alkio;
                }
                alkio = alkio.getRight();
            }
        }
        return null;
    }
    
    /**
     * Yhdistää kaksi kekoa toisiinsa,luoden uuden keon ja
     * tuhoten keon T1 ja T2
     * Uuden keon haarautumisaste on suuremman keon mukaan
     * @param t1 yhdistettävä Dkeko olio, ei saa olla null
     * @param t2 yhdistettävä Dkeko olio, ei saa olla null
     * @return uusi Dkeko olio, tai null jos t1 tai t2 null
     */
    public static Dkeko merge(Dkeko t1, Dkeko t2){ 
        Dkeko suuri=null;
        Dkeko pieni=null;
        if (t1==null || t2==null){
            return null;
        }
        suuri =t2;
        pieni =t1;
        if (t1.getHeapSize() > t2.getHeapSize()){
            suuri =t1;
            pieni =t2;
        }
        Dkeko uusi = null;
        uusi = new Dkeko(suuri.getAste(),suuri.getHeapSize(),
                                    suuri.getMin(),suuri.getTail());
        suuri=null;
        Solmu solmu =null;
        while (pieni.findMin()!=null){
            solmu = pieni.deleteMin();
            uusi.insert(solmu);
        }
        return uusi;
    }
    
    /**
     * Yhdistää kaksi kekoa toisiinsa,luoden uuden keon ja
     * tuhoten keon T1 ja T2.
     * Bottom up heap construction, haarautumisaste valitaan
     * suurimman haarautumisateen mukaan
     * Uuden keon haarautumisaste on suuremman keon mukaan
     * @param t1 yhdistettävä Dkeko olio, ei saa olla null
     * @param t2 yhdistettävä Dkeko olio, ei saa olla null
     * @return uusi Dkeko olio, tai null jos t1 tai t2 null
     */
    public static Dkeko mergeBottomUp(Dkeko t1, Dkeko t2){ 
        Dkeko suuri=null;
        Dkeko pieni=null;
        if (t1==null || t2==null){
            return null;
        }
        suuri =t2;
        pieni =t1;
        if (t1.getHeapSize() != t2.getHeapSize()){
            if (t1.getHeapSize() > t2.getHeapSize()){
                suuri =t1;
                pieni =t2;
            }
        }
        else {
            if (t1.getAste() > t2.getAste()){
                suuri =t1;
                pieni =t2;
            }
        }
        Dkeko uusi;
        int heapsize = suuri.getHeapSize() + pieni.getHeapSize();
        suuri.getTail().setRight(pieni.getMin());
        pieni.getMin().setLeft(suuri.getTail());
        uusi = new Dkeko(suuri.getAste(),heapsize,
                                    suuri.getMin(),pieni.getTail());
        suuri=null;
        pieni=null;
        asetaKeyt(uusi,uusi.getMin(),0);
        return uusi;
    }
    
    private static void asetaKeyt(Dkeko uusi, Kekoalkio alkio,int key){
        if (uusi.getHeapSize() <= key){   
            return;
        }
        if (alkio != null){
            alkio.setKey(key);
            asetaKeyt(uusi, alkio.getRight(),key+1);
            uusi.minHeapify(alkio);
        }
        
    }
    
    /**
     * Funktio palauttaa dkeon koon
     * @return int keon koko
     */
    public int getHeapSize(){
        return this.heapSize;
    }
    
    /**
     * Funktio palauttaa dkeon viimeisen alkion
     * @return Kekoalkio olio
     */
    public Kekoalkio getTail(){
        return this.tail;
    }
    
    /**
     * Funktio palauttaa dkeon ensimmäisen alkion
     * @return Kekoalkio olio
     */
    public Kekoalkio getMin(){
        return this.min;
    }
    
    /**
     * Funktio palauttaa dkeon haarautumisasteen
     * @return int 
     */
    public int getAste(){
        return this.d;
    }
}
