/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kekoharjoitus;
import java.sql.Timestamp;
import java.util.Random;

/**
 * Kekoharjoitus pääluokka
 * Luokan testit kekojen suorituskyvyn vertailun 
 * apuvälineenä
 * @author pturunen
 */
public class Kekoharjoitus {
    
    /*
     * alustaa kaikissa keko testeissa käytetyn syötetaulukon
     */
    public static Solmu[] insert(int koko){
        Random generator = null;
        generator = new Random();
        Solmu solmu=null;
        Solmu[] taulukko = new Solmu[koko];
        for (int i =0;i<koko;i++){
            solmu = new Solmu(i+2);
            taulukko[i] = solmu;
        }
        return taulukko;
    }
    
    
    
    /*
     * dkeko,binomikeko ja fibonaccikeko testi insert operaatiolle
     * 
     */
    public static void insertTesti(int tkoko){
        Solmu[] taulukko = null;;
        int koko =tkoko;
        taulukko = Kekoharjoitus.insert(koko);
        Dkeko dkeko2 = new Dkeko(2);
        Dkeko dkeko19 = new Dkeko(19);
        Binomikeko bkeko = new Binomikeko();
        Fibonaccikeko fkeko = new Fibonaccikeko();
        
        long starttime =0;
        long endtime =0;
        System.out.println("-----------------------------------------------------------------------------------------");
        for (int i=0;i<koko;i++){
            starttime = System.currentTimeMillis()+starttime;
            dkeko2.insert(taulukko[i]);
            endtime = System.currentTimeMillis()+endtime;
        }
        System.out.println(" Dkeko (2 haaraa)  insert "+koko+" kpl solmuja,yht: aika= "+(endtime-starttime)+" millisekunttia");
        
        starttime =0;
        endtime =0;
        for (int i=0;i<koko;i++){
            starttime = System.currentTimeMillis()+starttime;
            dkeko19.insert(taulukko[i]);
            endtime = System.currentTimeMillis()+endtime;
        }
        System.out.println(" Dkeko (19 haaraa)  insert "+koko+" kpl solmuja,yht: aika= "+(endtime-starttime)+" millisekunttia");
   
        
        starttime =0;
        endtime =0;
        
        for (int i=0;i<koko;i++){
            starttime = System.currentTimeMillis()+starttime;
            bkeko.insert(taulukko[i]);
            endtime = System.currentTimeMillis()+endtime;
        }
        System.out.println(" Binomikeko        insert "+koko+" kpl solmuja,yht: aika= "+(endtime-starttime)+" millisekunttia");
        
        
        starttime =0;
        endtime =0;
        
        for (int i=0;i<koko;i++){
            starttime = System.currentTimeMillis()+starttime;
            fkeko.insert(taulukko[i]);
            endtime = System.currentTimeMillis()+endtime;
        }
        System.out.println(" Fibonaccikeko     insert "+koko+" kpl solmuja,yht aika= "+(endtime-starttime)+" millisekunttia");
        
    }
    
    /*
     * dkeko,binomikeko ja fibonaccikeko yhdistelma testi operaatiolle
     * 
     */
    public static void yhdistelmaTesti(int tkoko){
        Solmu[] taulukko = null;;
        int koko =tkoko;
        taulukko = Kekoharjoitus.insert(koko);
        Dkeko dkeko2 = new Dkeko(2);
        Dkeko dkeko19 = new Dkeko(19);
        Binomikeko bkeko = new Binomikeko();
        Fibonaccikeko fkeko = new Fibonaccikeko();
        
        Dkeko dkeko2M = insertDkeko(100);
        Dkeko dkeko19M = insertD19keko(100);
        Binomikeko bkekoM = insertBkeko(100);
        Fibonaccikeko fkekoM = insertFkeko(100);
        
        long starttime =0;
        long endtime =0;
        System.out.println("-----------------------------------------------------------------------------------------");
        for (int i=0;i<koko;i++){
            starttime = System.currentTimeMillis()+starttime;
            dkeko2.insert(taulukko[i]);
            endtime = System.currentTimeMillis()+endtime;
        }
        System.out.println(" Dkeko2       syote lkm="+koko+" insert kaikki"+(endtime-starttime)+" ms yhteensa");
        starttime =0;
        endtime =0;
        for (int i=0;i<koko;i++){
            starttime = System.currentTimeMillis()+starttime;
            dkeko2.findMin();
            endtime = System.currentTimeMillis()+endtime;
        }
        System.out.println(" Dkeko2       syote lkm="+koko+" findMin*syote"+(endtime-starttime)+" ms yhteensa");
        
        
        starttime =0;
        endtime =0;
        Kekoalkio alkio=null;
        
        for (int i=0;i<koko;i++){
            alkio = dkeko2.findKekoalkio(taulukko[i]);
            starttime = System.currentTimeMillis()+starttime;
            dkeko2.decreaseKey(alkio,(taulukko[i].getValue()-1));
            endtime = System.currentTimeMillis()+endtime;
        }
        System.out.println(" Dkeko2       syote lkm="+koko+" decrease kaikki"+(endtime-starttime)+" ms yhteensa");

        
        starttime =0;
        endtime =0;
        for (int i=0;i<koko;i++){
            starttime = System.currentTimeMillis()+starttime;
            dkeko2.deleteMin();
            endtime = System.currentTimeMillis()+endtime;
        }
        System.out.println(" Dkeko2       syote lkm="+koko+" deleteMin kaikki"+(endtime-starttime)+" ms yhteensa");

        
        starttime =0;
        endtime =0;
        for (int i=0;i<koko;i++){
            starttime = System.currentTimeMillis()+starttime;
            Dkeko.merge(dkeko2,dkeko2M);
            endtime = System.currentTimeMillis()+endtime;
        }
        System.out.println(" Dkeko2       syote lkm="+koko+"+100   merge "+(endtime-starttime)+" ms yhteensa");

        
        //------------------------------------------------------------------
        starttime =0;
        endtime =0;
        for (int i=0;i<koko;i++){
            starttime = System.currentTimeMillis()+starttime;
            dkeko19.insert(taulukko[i]);
            endtime = System.currentTimeMillis()+endtime;
        }
        System.out.println(" Dkeko19       syote lkm="+koko+" insert kaikki"+(endtime-starttime)+" ms yhteensa");
   
        starttime =0;
        endtime =0;
        for (int i=0;i<koko;i++){
            starttime = System.currentTimeMillis()+starttime;
            dkeko19.findMin();
            endtime = System.currentTimeMillis()+endtime;
        }
        System.out.println(" dkeko19       syote lkm="+koko+" findMin*syote"+(endtime-starttime)+" ms yhteensa");
        
        
        starttime =0;
        endtime =0;
        alkio=null;
        
        for (int i=0;i<koko;i++){
            alkio = dkeko2.findKekoalkio(taulukko[i]);
            starttime = System.currentTimeMillis()+starttime;
            dkeko19.decreaseKey(alkio,(taulukko[i].getValue()-1));
            endtime = System.currentTimeMillis()+endtime;
        }
        System.out.println(" dkeko19       syote lkm="+koko+" decrease kaikki"+(endtime-starttime)+" ms yhteensa");

        
        starttime =0;
        endtime =0;
        for (int i=0;i<koko;i++){
            starttime = System.currentTimeMillis()+starttime;
            dkeko19.deleteMin();
            endtime = System.currentTimeMillis()+endtime;
        }
        System.out.println(" dkeko19       syote lkm="+koko+" deleteMin kaikki"+(endtime-starttime)+" ms yhteensa");

        starttime =0;
        endtime =0;
        for (int i=0;i<koko;i++){
            starttime = System.currentTimeMillis()+starttime;
            Dkeko.merge(dkeko19,dkeko19M);
            endtime = System.currentTimeMillis()+endtime;
        }
        System.out.println(" dkeko19       syote lkm="+koko+"+100 merge"+(endtime-starttime)+" ms yhteensa");

        //------------------------------------------------------------------
        
        starttime =0;
        endtime =0;
        
        for (int i=0;i<koko;i++){
            starttime = System.currentTimeMillis()+starttime;
            bkeko.insert(taulukko[i]);
            endtime = System.currentTimeMillis()+endtime;
        }
        System.out.println(" Binomikeko    syote lkm="+koko+" insert lkm"+(endtime-starttime)+" ms yhteensa");
    
        
        
        starttime =0;
        endtime =0;
        
        for (int i=0;i<koko;i++){
            starttime = System.currentTimeMillis()+starttime;
            bkeko.findMin();
            endtime = System.currentTimeMillis()+endtime;
        }
        System.out.println(" Binomikeko    syote lkm="+koko+" findMin*syote lkm"+(endtime-starttime)+" ms yhteensa");
        
        starttime =0;
        endtime =0;
        Binomipuu bpuu = null;
        for (int i=0;i<koko;i++){
            bpuu = bkeko.findBinomipuu(bkeko.getJuuriListaMin(),taulukko[i]);
            starttime = System.currentTimeMillis()+starttime;
            bkeko.decreaseKey(bpuu,bpuu.getValue(),(taulukko[i].getValue()-1));
            endtime = System.currentTimeMillis()+endtime;
        }
        System.out.println(" Binomikeko    syote lkm="+koko+" decrease kaikki"+(endtime-starttime)+" ms yhteensa");
   
        starttime =0;
        endtime =0;
        for (int i=0;i<koko;i++){
            starttime = System.currentTimeMillis()+starttime;
            bkeko.deleteMin();
            endtime = System.currentTimeMillis()+endtime;
        }
        System.out.println(" Binomikeko    syote lkm="+koko+" deleteMin kaikki"+(endtime-starttime)+" ms yhteensa");
 
        starttime =0;
        endtime =0;
        for (int i=0;i<koko;i++){
            starttime = System.currentTimeMillis()+starttime;
            Binomikeko.merge(bkeko,bkekoM);
            endtime = System.currentTimeMillis()+endtime;
        }
        System.out.println(" Binomikeko    syote lkm="+koko+"+100 merge"+(endtime-starttime)+" ms yhteensa");

        
        //------------------------------------------------------------------
        starttime =0;
        endtime =0;
        
        for (int i=0;i<koko;i++){
            starttime = System.currentTimeMillis()+starttime;
            fkeko.insert(taulukko[i]);
            endtime = System.currentTimeMillis()+endtime;
        }
        System.out.println(" Fibonaccikeko  syote lkm="+koko+" insert kaikki"+(endtime-starttime)+" ms yhteensa");
        
        starttime =0;
        endtime =0;
        
        for (int i=0;i<koko;i++){
            starttime = System.currentTimeMillis()+starttime;
            fkeko.findMin();
            endtime = System.currentTimeMillis()+endtime;
        }
        System.out.println(" Fibonaccikeko  syote lkm="+koko+" findMin*syote lkm"+(endtime-starttime)+" ms yhteensa");
  
        starttime =0;
        endtime =0;
        Fibonaccipuu fpuu = null;
        for (int i=0;i<koko;i++){
            fpuu = fkeko.findFibonaccipuu(fkeko.getMin(),taulukko[i] , fkeko.getMin());
            starttime = System.currentTimeMillis()+starttime;
            fkeko.decreaseKey(fpuu,taulukko[i].getValue()-1);
            endtime = System.currentTimeMillis()+endtime;
        }
        System.out.println(" Fibonaccikeko  syote lkm="+koko+" decrease kaikki"+(endtime-starttime)+" ms yhteensa");
  
        starttime =0;
        endtime =0;
        
        for (int i=0;i<koko;i++){
            starttime = System.currentTimeMillis()+starttime;
            fkeko.deleteMin();
            endtime = System.currentTimeMillis()+endtime;
        }
        System.out.println(" Fibonaccikeko  syote lkm="+koko+" deleteMin kaikki"+(endtime-starttime)+" ms yhteensa");
  
        starttime =0;
        endtime =0;
        
        for (int i=0;i<koko;i++){
            starttime = System.currentTimeMillis()+starttime;
            Fibonaccikeko.merge(fkeko,fkekoM);
            endtime = System.currentTimeMillis()+endtime;
        }
        System.out.println(" Fibonaccikeko  syote lkm="+koko+"+100 merge"+(endtime-starttime)+" ms yhteensa");
 
        
          
       
    }
    
    /*
     * dkeko,binomikeko ja fibonaccikeko testi findMin operaatiolle
     * 
     */
    public static void findMinTesti(int tkoko){
        Solmu[] taulukko = null;;
        int koko =tkoko;
        taulukko = Kekoharjoitus.insert(koko);
        Dkeko dkeko2 = new Dkeko(2);
        Dkeko dkeko19 = new Dkeko(19);
        Binomikeko bkeko = new Binomikeko();
        Fibonaccikeko fkeko = new Fibonaccikeko();
        
        long starttime =0;
        long endtime =0;
        int pienin=Integer.MAX_VALUE;
        System.out.println("-----------------------------------------------------------------------------------------");
        for (int i=0;i<koko;i++){
            dkeko2.insert(taulukko[i]);
            if (pienin > taulukko[i].getValue()){
                pienin = taulukko[i].getValue();
            }
        }
        Solmu solmu = null;
        starttime = System.currentTimeMillis();
        solmu = dkeko2.findMin();
        endtime = System.currentTimeMillis();
        if (pienin != solmu.getValue()){
            System.out.println("TULOS VIRHEELLINEN!!!!!!!!!!");
        }
        System.out.println(" Dkeko (2 haaraa)  findMin "+koko+" kpl solmuja aika= "+(endtime-starttime)+" millisekunttia");
        
        
        starttime =0;
        endtime =0;
        for (int i=0;i<koko;i++){
            dkeko19.insert(taulukko[i]);
        }
        starttime = System.currentTimeMillis();
        solmu = dkeko19.findMin();
        endtime = System.currentTimeMillis();
        if (pienin != solmu.getValue()){
            System.out.println("TULOS VIRHEELLINEN!!!!!!!!!!");
        }
        
        System.out.println(" Dkeko (19 haaraa)  findMin "+koko+" kpl solmuja, aika= "+(endtime-starttime)+" millisekunttia");
   
        
        starttime =0;
        endtime =0;
        
        for (int i=0;i<koko;i++){
            bkeko.insert(taulukko[i]);
        }
        starttime = System.currentTimeMillis();
        solmu = bkeko.findMin();
        endtime = System.currentTimeMillis();
        if (pienin != solmu.getValue()){
            System.out.println("TULOS VIRHEELLINEN!!!!!!!!!!");
        }
        
        System.out.println(" Binomikeko        findMin "+koko+" kpl solmuja, aika= "+(endtime-starttime)+" millisekunttia");
        
        
        starttime =0;
        endtime =0;
        
        for (int i=0;i<koko;i++){
            fkeko.insert(taulukko[i]);
        }
        
        starttime = System.currentTimeMillis();
        solmu = fkeko.findMin();
        endtime = System.currentTimeMillis();
        if (pienin != solmu.getValue()){
            System.out.println("TULOS VIRHEELLINEN!!!!!!!!!!");
        }
        
        System.out.println(" Fibonaccikeko     findMin "+koko+" kpl solmuja, aika= "+(endtime-starttime)+" millisekunttia");
        
    }
    
    /*
     * dkeon alustus delete ja decrease testeja varten
     */
    public static Dkeko insertDkeko(int tkoko){
        Solmu[] taulukko = null;
        int koko =tkoko;
        taulukko = Kekoharjoitus.insert(koko);
        Dkeko dkeko2 = new Dkeko(2);
        int pienin=Integer.MAX_VALUE;
        for (int i=0;i<koko;i++){
            dkeko2.insert(taulukko[i]);
            if (pienin > taulukko[i].getValue()){
                pienin = taulukko[i].getValue();
            }
        }
        return dkeko2;
    }
    
    /*
     * dkekon alustus delete ja decrease testeja varten
     */
    public static Dkeko insertD19keko(int tkoko){
        Solmu[] taulukko = null;
        int koko =tkoko;
        taulukko = Kekoharjoitus.insert(koko);
        Dkeko dkeko19 = new Dkeko(19);
        int pienin=Integer.MAX_VALUE;
        for (int i=0;i<koko;i++){
            dkeko19.insert(taulukko[i]);
            if (pienin > taulukko[i].getValue()){
                pienin = taulukko[i].getValue();
            }
        }
        return dkeko19;
    }
    
    /*
     * binomikeon alustus delete ja decrease testeja varten
     */
    public static Binomikeko insertBkeko(int tkoko){
        Solmu[] taulukko = null;
        int koko =tkoko;
        taulukko = Kekoharjoitus.insert(koko);
        Binomikeko bkeko = new Binomikeko();
        int pienin=Integer.MAX_VALUE;
        for (int i=0;i<koko;i++){
            bkeko.insert(taulukko[i]);
            if (pienin > taulukko[i].getValue()){
                pienin = taulukko[i].getValue();
            }
        }
        return bkeko;
    }
    
    /*
     * fibonaccikeon alustus delete ja decrease testeja varten
     */
    public static Fibonaccikeko insertFkeko(int tkoko){
        Solmu[] taulukko = null;
        int koko =tkoko;
        taulukko = Kekoharjoitus.insert(koko);
        Fibonaccikeko fkeko = new Fibonaccikeko();
        int pienin=Integer.MAX_VALUE;
        for (int i=0;i<koko;i++){
            fkeko.insert(taulukko[i]);
            if (pienin > taulukko[i].getValue()){
                pienin = taulukko[i].getValue();
            }
        }
        return fkeko;
    }
    
     /*
     * dkeko,binomikeko ja fibonaccikeko testi deleteMin operaatiolle
     * 
     */
    public static void deleteMinTesti(int tkoko){
        Dkeko dkeko2 = insertDkeko(tkoko);
        Dkeko dkeko19 = insertD19keko(tkoko);
        Binomikeko bkeko = insertBkeko(tkoko);
        Fibonaccikeko fkeko = insertFkeko(tkoko);
        //-------------------------------------------------------------------
        long starttime =0;
        long endtime =0;
       
        System.out.println("-------------------------------------------------");
        
        Solmu solmu = null;
        starttime = System.currentTimeMillis();
        solmu = dkeko2.deleteMin();
        endtime = System.currentTimeMillis();
        System.out.println(" Dkeko (2 haaraa)  deleteMin "+tkoko+
   " kpl solmuja , yhden solmun aika= "+(endtime-starttime)+" millisekunttia");
        
        starttime =0;
        endtime =0;
        long kokoaika = 0;
        while (dkeko2.findMin() != null){
            starttime = System.currentTimeMillis();
            solmu = dkeko2.deleteMin();
            endtime = System.currentTimeMillis();
            kokoaika = kokoaika + (endtime-starttime);
            starttime =0;
            endtime =0;
        }
        System.out.println(" Dkeko (2 haaraa)  deleteMin "+tkoko+
            " kpl solmuja, KAIKKI aika= "+kokoaika+" millisekunttia");
        
//--------------------------------------------------------------------------        
        starttime =0;
        endtime =0;
        starttime = System.currentTimeMillis();
        solmu = dkeko19.deleteMin();
        endtime = System.currentTimeMillis();
        System.out.println(" Dkeko (19 haaraa)  deleteMin "+tkoko+
                " kpl solmuja, aika= "+(endtime-starttime)+" millisekunttia");
   
        starttime =0;
        endtime =0;
        kokoaika = 0;
        int counter = 0;
        while (dkeko19.findMin() != null){
           
            counter++;
            starttime = System.currentTimeMillis();
            solmu = dkeko19.deleteMin();
            endtime = System.currentTimeMillis();
            kokoaika = kokoaika + (endtime-starttime);
            starttime =0;
            endtime =0;
        }
         System.out.println("dkeko19 counter="+counter);
        System.out.println(" Dkeko (19 haaraa)  deleteMin "+tkoko+
                " kpl solmuja KAIKKI aika= "+kokoaika+" millisekunttia");
 
//------------------------------------------------------------------------        
        
        starttime =0;
        endtime =0;
        starttime = System.currentTimeMillis();
        solmu = bkeko.deleteMin();
        endtime = System.currentTimeMillis();
        System.out.println(" Binomikeko        deleteMin "+tkoko+
                " kpl solmuja, aika= "+(endtime-starttime)+" millisekunttia");
        
        starttime =0;
        endtime =0;
        kokoaika = 0;
        counter =0;
        while (bkeko.findMin() != null){
            counter++;
            starttime = System.currentTimeMillis();
            solmu = bkeko.deleteMin();
            endtime = System.currentTimeMillis();
            kokoaika = kokoaika + (endtime-starttime);
            starttime =0;
            endtime =0;
        }
        
        System.out.println("binomikeko counter="+counter);
        System.out.println(" Binomikeko         deleteMin "+tkoko+
                " kpl solmuja, KAIKKI aika= "+kokoaika+" millisekunttia");
 
//-------------------------------------------------------------------------        
        starttime =0;
        endtime =0;
        starttime = System.currentTimeMillis();
        solmu = fkeko.deleteMin();
        endtime = System.currentTimeMillis();
        System.out.println(" Fibonaccikeko     deleteMin "+tkoko+
                " kpl solmuja, aika= "+(endtime-starttime)+" millisekunttia");
        
        starttime =0;
        endtime =0;
        kokoaika = 0;
        counter =0;
        while (fkeko.findMin() != null){
            counter++;
            starttime = System.currentTimeMillis();
            solmu = fkeko.deleteMin();
            endtime = System.currentTimeMillis();
            kokoaika = kokoaika + (endtime-starttime);
            starttime =0;
            endtime =0;
        }
        System.out.println(" Fibonaccikeko   "+counter+" deleteMin "+tkoko+
                " kpl solmuja, KAIKKI aika= "+kokoaika+" millisekunttia");

    }
    
     /*
     * dkeko,binomikeko ja fibonaccikeko testi decreaseKey operaatiolle
     * 
     */
    public static void decreaseKeyTesti(int tkoko){
        Dkeko dkeko2 = insertDkeko(tkoko);
        Dkeko dkeko19 = insertD19keko(tkoko);
        Binomikeko bkeko = insertBkeko(tkoko);
        Fibonaccikeko fkeko = insertFkeko(tkoko);
        
        long starttime =0;
        long endtime =0;
       
        System.out.println("-------------------------------------------------");
        
        
        Solmu solmu = null;
        Kekoalkio puu = dkeko2.findKekoalkio(dkeko2.findMin());
        int value = puu.getValue().getValue() -1;
        int tulos =0;
        starttime = System.currentTimeMillis();
        tulos =dkeko2.decreaseKey(puu, value);
        endtime = System.currentTimeMillis();
        if (tulos != 0){
            System.out.println("TULOS VIRHEELLINEN");
        }
        System.out.println(" Dkeko (2 haaraa)  decreaseKey, pienin arvo "+tkoko+
                " kpl solmuja aika= "+(endtime-starttime)+" millisekunttia");
        
        starttime =0;
        endtime =0;
        solmu = new Solmu(tkoko);
        puu = dkeko2.findKekoalkio(solmu);
        value = 1;
        tulos =0;
        starttime = System.currentTimeMillis();
        tulos =dkeko2.decreaseKey(puu, value);
        endtime = System.currentTimeMillis();
        if (dkeko2.findMin().getValue()!=1){
            System.out.println("TULOS VIRHEELLINEN");
        }
        System.out.println(" Dkeko (2 haaraa)  decreaseKey,not min  "+tkoko+
                " kpl solmuja aika= "+(endtime-starttime)+" millisekunttia");
        
        
        starttime =0;
        endtime =0;
        puu = dkeko19.findKekoalkio(dkeko19.findMin());
        value = puu.getValue().getValue() -1;
        starttime = System.currentTimeMillis();
        tulos =dkeko19.decreaseKey(puu, value);
        endtime = System.currentTimeMillis();
        if (tulos != 0){
            System.out.println("TULOS VIRHEELLINEN");
        }
        System.out.println(" Dkeko (19 haaraa)  decreaseKey "+tkoko+
                " kpl solmuja aika= "+(endtime-starttime)+" millisekunttia");
   
        starttime =0;
        endtime =0;
        Binomipuu bpuu = bkeko.findBinomipuu(bkeko.getJuuriListaMin(), bkeko.findMin());
        value = bkeko.findMin().getValue()-1;
        starttime = System.currentTimeMillis();
        tulos = bkeko.decreaseKey(bpuu, bkeko.findMin(), value);
        endtime = System.currentTimeMillis();
        if (tulos != 0){
            System.out.println("TULOS VIRHEELLINEN");
        }
        System.out.println(" Binomikeko        decreaseKey "+tkoko+
                " kpl solmuja aika= "+(endtime-starttime)+" millisekunttia");
        
        starttime =0;
        endtime =0;
        solmu = new Solmu(tkoko);
        bpuu = bkeko.findBinomipuu(bkeko.getJuuriListaMin(), solmu);
        value = 1;
        tulos =0;
        starttime = System.currentTimeMillis();
        tulos = bkeko.decreaseKey(bpuu, solmu, value);
        endtime = System.currentTimeMillis();
        if (bkeko.findMin().getValue()!=1){
            System.out.println("TULOS VIRHEELLINEN");
        }
         System.out.println(" Binomikeko        decreaseKey not minimi"+tkoko+
                 " kpl solmuja aika= "+(endtime-starttime)+" millisekunttia");
        
       
        starttime =0;
        endtime =0;
        value = fkeko.findMin().getValue() -1;
        Fibonaccipuu fpuu = fkeko.findFibonaccipuu(fkeko.getMin(),fkeko.findMin(), fkeko.getMin());
        
        starttime = System.currentTimeMillis();
        tulos = fkeko.decreaseKey(fpuu, value);
        endtime = System.currentTimeMillis();
        if (tulos != 0){
            System.out.println("TULOS VIRHEELLINEN");
        }
        System.out.println(" Fibonaccikeko     decreaseKey "+tkoko+
                " kpl solmuja aika= "+(endtime-starttime)+" millisekunttia");

        starttime =0;
        endtime =0;
        solmu = new Solmu(tkoko);
        fpuu = fkeko.findFibonaccipuu(fkeko.getMin(),solmu, fkeko.getMin());
        value = 1;
        tulos =0;
        starttime = System.currentTimeMillis();
        tulos = fkeko.decreaseKey(fpuu, value);
        endtime = System.currentTimeMillis();
        if (fkeko.findMin().getValue()!=1){
            System.out.println("TULOS VIRHEELLINEN");
        }
        System.out.println(" Fibonaccikeko     decreaseKey not minimi"+tkoko+
                " kpl solmuja aika= "+(endtime-starttime)+" millisekunttia");
    }
    
    
    /*
     * dkeko,binomikeko ja fibonaccikeko testi deleteMin operaatiolle
     * 
     */
    public static void doAllTesti(int tkoko){
        Dkeko dkeko2 = insertDkeko(tkoko);
        Dkeko dkeko19 = insertD19keko(tkoko);
        Binomikeko bkeko = insertBkeko(tkoko);
        Fibonaccikeko fkeko = insertFkeko(tkoko);
        
        long starttime =0;
        long endtime =0;
       
        System.out.println("--kekon koko alussa ="+tkoko+" solmua---------");
        
        Solmu solmu = null;
        Solmu solmu2 = null;
        Solmu solmu3 = null;
        
        Dkeko keko2 = null;
        Dkeko mergeKeko = null;
        solmu = new Solmu(8989);
        solmu2 = new Solmu(3);
        
        starttime = System.currentTimeMillis();
        dkeko2.insert(solmu);
        dkeko2.findMin();
        keko2 = Dkeko.makeHeap(2);
        keko2.insert(solmu2);
        mergeKeko = Dkeko.merge(dkeko2, keko2);
        solmu = mergeKeko.deleteMin();
        endtime = System.currentTimeMillis();
        System.out.println(" Dkeko 2:insert+findMin+makeHeap+insert+merge+deleteMin, aika= "+(endtime-starttime)+" millisekunttia");
        
        
        Dkeko keko19 = null;
        Dkeko mergeKeko19 = null;
        solmu = new Solmu(8989);
        solmu2 = new Solmu(3);
        
        starttime = System.currentTimeMillis();
        dkeko19.insert(solmu);
        dkeko19.findMin();
        keko19 = Dkeko.makeHeap(19);
        keko19.insert(solmu2);
        mergeKeko19 = Dkeko.merge(dkeko19, keko19);
        solmu = mergeKeko19.deleteMin();
        endtime = System.currentTimeMillis();
        System.out.println(" Dkeko 19:insert+findMin+makeHeap+insert+merge+deleteMin, aika= "+(endtime-starttime)+" millisekunttia");       
        
 
        Binomikeko binomikeko = null;
        Binomikeko bkekoMerge = null;
        solmu = new Solmu(8989);
        solmu2 = new Solmu(3);
        
        starttime = System.currentTimeMillis();
        bkeko.insert(solmu);
        bkeko.findMin();
        binomikeko = Binomikeko.makeHeap();
        binomikeko.insert(solmu2);
        bkekoMerge = Binomikeko.merge(binomikeko, bkeko);
        solmu = bkekoMerge.deleteMin();
        endtime = System.currentTimeMillis();
        System.out.println(" Binomikeko:insert+findMin+makeHeap+insert+merge+deleteMin, aika= "+(endtime-starttime)+" millisekunttia");       
 
        
//------------------------------------------------------------------------        
        
        Fibonaccikeko fibokeko = null;
        Fibonaccikeko fkekoMerge = null;
        solmu = new Solmu(8989);
        solmu2 = new Solmu(3);
        
        starttime = System.currentTimeMillis();
        fkeko.insert(solmu);
        fkeko.findMin();
        fibokeko = Fibonaccikeko.makeHeap();
        fibokeko.insert(solmu2);
        fkekoMerge = Fibonaccikeko.merge(fibokeko, fkeko);
        solmu = fkekoMerge.deleteMin();
        endtime = System.currentTimeMillis();
        System.out.println(" Fibonaccikeko:insert+findMin+makeHeap+insert+merge+deleteMin, aika= "+(endtime-starttime)+" millisekunttia");       
 

    }
    
    
    /*
     * dkeko,binomikeko ja fibonaccikeko testi deleteMin operaatiolle
     * Insert,ja decrase ja findMin ennemistö , muutama delete
     * 
     */
    public static void doAllTesti2(int tkoko){
        Dkeko dkeko2 = insertDkeko(tkoko);
        Dkeko dkeko19 = insertD19keko(tkoko);
        Binomikeko bkeko = insertBkeko(tkoko);
        Fibonaccikeko fkeko = insertFkeko(tkoko);
        
        long starttime =0;
        long endtime =0;
       
        System.out.println("--kekon koko alussa ="+tkoko+" solmua---------");
        
        Solmu solmu = null;
        Solmu solmu2 = null;
        Solmu solmu3 = null;
        Solmu solmu4 = null;
        Solmu solmu5 = null;
        
        
        Dkeko keko2 = null;
        Dkeko mergeKeko = null;
        solmu = new Solmu(8989);
        solmu2 = new Solmu(3);
        solmu4 = new Solmu(6);
        solmu5 = new Solmu(9);
        
        starttime = System.currentTimeMillis();
        dkeko2.insert(solmu);
        dkeko2.findMin();
        dkeko2.insert(solmu4);
        keko2 = Dkeko.makeHeap(2);
        keko2.insert(solmu2);
        mergeKeko = Dkeko.merge(dkeko2, keko2);
        solmu = mergeKeko.deleteMin();
        mergeKeko.insert(solmu5);
        endtime = System.currentTimeMillis();
        System.out.println(" Dkeko 2:insert+findMin+insert+makeHeap+insert+merge+insert+deleteMin, aika= "+(endtime-starttime)+" millisekunttia");
        
        
        Dkeko keko19 = null;
        Dkeko mergeKeko19 = null;
        solmu = new Solmu(8989);
        solmu2 = new Solmu(3);
        solmu4 = new Solmu(6);
        solmu4 = new Solmu(6);
        solmu5 = new Solmu(9);
        
        starttime = System.currentTimeMillis();
        dkeko19.insert(solmu);
        dkeko19.findMin();
        dkeko19.insert(solmu4);
        keko19 = Dkeko.makeHeap(19);
        keko19.insert(solmu2);
        mergeKeko19 = Dkeko.merge(dkeko19, keko19);
        mergeKeko19.insert(solmu5);
        solmu = mergeKeko19.deleteMin();
        endtime = System.currentTimeMillis();
        System.out.println(" Dkeko 19:insert+findMin+insert+makeHeap+insert+merge+insert+deleteMin, aika= "+(endtime-starttime)+" millisekunttia");       
        
 
        Binomikeko binomikeko = null;
        Binomikeko bkekoMerge = null;
        solmu = new Solmu(8989);
        solmu2 = new Solmu(3);
        solmu4 = new Solmu(6);
        solmu5 = new Solmu(9);
        
        starttime = System.currentTimeMillis();
        bkeko.insert(solmu);
        bkeko.findMin();
        bkeko.insert(solmu4);
        binomikeko = Binomikeko.makeHeap();
        binomikeko.insert(solmu2);
        bkekoMerge = Binomikeko.merge(binomikeko, bkeko);
        bkekoMerge.insert(solmu5);
        solmu = bkekoMerge.deleteMin();
        endtime = System.currentTimeMillis();
        System.out.println(" Binomikeko:insert+findMin+insert+makeHeap+insert+merge+insert+deleteMin, aika= "+(endtime-starttime)+" millisekunttia");       
 
        
//------------------------------------------------------------------------        
        
        Fibonaccikeko fibokeko = null;
        Fibonaccikeko fkekoMerge = null;
        solmu = new Solmu(8989);
        solmu2 = new Solmu(3);
        solmu4 = new Solmu(6);
        solmu5 = new Solmu(9);
        
        
        
        starttime = System.currentTimeMillis();
        fkeko.insert(solmu);
        fkeko.findMin();
        fkeko.insert(solmu4);
        fibokeko = Fibonaccikeko.makeHeap();
        fibokeko.insert(solmu2);
        fkekoMerge = Fibonaccikeko.merge(fibokeko, fkeko);
        fkekoMerge.insert(solmu5);
        solmu = fkekoMerge.deleteMin();
        endtime = System.currentTimeMillis();
        System.out.println(" Fibonaccikeko:insert+findMin+insert+makeHeap+insert+merge+insert+deleteMin, aika= "+(endtime-starttime)+" millisekunttia");       
 

    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Solmu[] taulukko = null;
        int koko =1;
        taulukko = Kekoharjoitus.insert(koko);
        
       
        int[]taulu = {1,100,1000,30002};
        for (int i=0;i<taulu.length;i++){
            insertTesti(taulu[i]);
        }
        for (int i=0;i<taulu.length;i++){
            findMinTesti(taulu[i]);
        }
       
        int[]taulu2 = {1,100,1000,30004};
        for (int i=0;i<taulu2.length;i++){
            deleteMinTesti(taulu2[i]);
        }
       
        int[]taulu3 = {3002};
        for (int i=0;i<taulu3.length;i++){
            decreaseKeyTesti(taulu3[i]);
        }
      
        int[]taulu4 = {5002};
        for (int i=0;i<taulu4.length;i++){
            doAllTesti(taulu4[i]);
        }
        
        
        
        for (int i=0;i<taulu4.length;i++){
            doAllTesti2(taulu4[i]);
        }
       
        int[]taulu5 = {6002};
        for (int i=0;i<taulu4.length;i++){
            yhdistelmaTesti(taulu4[i]);
        }
        
        
    }
}
