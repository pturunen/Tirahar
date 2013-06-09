/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kekoharjoitus;

/**
 * LUOKKA ON TYÖNALLA ,EI KUULUNUT PALAUTUS SETTIIN 5
 * @author pturunen
 */
public class Fibonaccikeko {
    
    private  Fibonaccipuu min;
    
    /**
     * Konstruktori
     */
    public Fibonaccikeko(){
       this.min = null;
    }
    
    /**
     * Luo tyhjän fibonaccikeko olion
     * @return Fibonaccikeko olio
     */
    public static Fibonaccikeko makeHeap(){
        Fibonaccikeko keko = new Fibonaccikeko();
        return keko;
    }
    
    /**
     * Palauttaa minimikeon pienimmän alkion
     * @return Solmu olio, tai null jos keko tyhjä
     */
    public Solmu findMin(){
        Solmu solmu = null;
        if (min != null){
            solmu = min.getValue();
        }
        return solmu;
    }
    
    /**
     * Lisää Solmu luokan olion minimikekoon
     * omistajuus olioon siirtyy 
     * @param x Solmu luokan olio,joka lisätään kekoon
     */
    public void insert(Solmu x){
       if (x == null || x.getValue() == Integer.MAX_VALUE){
            return;
        }
     Fibonaccipuu uusi = createNewFibonaccipuu(x);
     if (uusi != null){
            if (this.getMin()!=null)  {
                Fibonaccikeko keko = this.makeHeap();
                keko.setMin(uusi);
                Fibonaccikeko temp = Fibonaccikeko.merge(keko, this);
                this.setMin(temp.getMin());
            }
            else {
                this.setMin(uusi);
         }
     } 
  
    }
  
    /**
     * Palauttaa Fibonaccikeko olion pienimmän arvon omaavan
     * Fibonaccipuu olion
     * 
     * @param fibonaccipuu Fibonacipuu olio tai null jos keko tyhjä
     */
    public Fibonaccipuu getMin(){
        return this.min;
    }
    
    /**
     * Asettaa Fibonaccikeko olion jäsenmuuttujaan
     * min parametrina annetun Fibonaccipuu olion
     * 
     * @param fibonaccipuu Fibonacipuu olio
     */
    private void setMin(Fibonaccipuu fibonaccipuu){
        this.min =fibonaccipuu;
    }
    
    /**
     * Luodaan uusi Fobonaccipuu olio jonka jäsenmuuttujaksi asetetaan
     * parametrina annettu Solmu olio
     * @param x Solmu luokan olio josta luodaan uusi Fibonaccipuu olio
     * @return Fibonaccipuu olio
     */
    private Fibonaccipuu createNewFibonaccipuu(Solmu x){
        Fibonaccipuu puu = new Fibonaccipuu();
        puu.setValue(x);
        return puu;
    }
    
    /**
     *
     * @return
     */
    public int deleteMin(/* heap */){
         /* to be implemented*/
        return 0;
    }
    
    /**
     *
     */
    public void decreaseKey(){
        /* to be implemented*/ 
    }
    
    /**
    * Yhdistää kaksi kekoa toisiinsa,luoden uuden keon ja
     * tuhoten keon keko1 ja keko2
     * Juurilistam alkiot eivät ole suuruusjärjestyksessä, juurilistassa
     * voi olla saman degreen alkioita.Merge operaatio ei yhdistä niitä.
     * Vain juurilistan pienin alkio päivitetään tarvittaesa.
     * keko1 vasen yhdistetään keko2:sen vasempaan ja 
     * keko2 vasen keko1 vasempaan
     * Jos keossa on vain yksi alkio, vasen ja oikea ovat null
     * Vain kahden alkion lista muodostaa rengaslistan
     * @param keko1 yhdistettävä Fibonaccikeko olio
     * @param keko2 yhdistettävä Fibonaccikeko olio
     * @return uusi Fibonaccikeko olio, tai null jos t1 ja t2 null
     */
    public static Fibonaccikeko merge(Fibonaccikeko keko1, Fibonaccikeko keko2){
        Fibonaccikeko keko = null;
        if (keko1== null || keko2==null){
            return nullVersionMerge(keko1, keko2);
        }
        Fibonaccipuu suurempi = null;
        keko = Fibonaccikeko.makeHeap();
        Fibonaccipuu uusiMin = null;
        if (keko1.findMin().getValue() <= keko2.findMin().getValue()){
                keko.setMin(keko1.getMin());
                suurempi = keko2.getMin();
            }
        else {
                keko.setMin(keko2.getMin());
                suurempi = keko1.getMin();
            }
        uusiMin = keko.getMin();
        Fibonaccipuu keko1vasen = keko1.getMin().getSiblingL();
        Fibonaccipuu keko2vasen = keko2.getMin().getSiblingL();
        if (keko1vasen == null){
            asetaLinkit(suurempi,uusiMin );
            if (keko2vasen!= null){
                asetaLinkit(uusiMin,keko2vasen );
            }
            else {
                asetaLinkit(uusiMin,suurempi );
            }
        }
        else {
            asetaLinkit(suurempi,keko1vasen );
            if (keko2vasen!= null){
                asetaLinkit(uusiMin,keko2vasen );
            }
            else {
                asetaLinkit(uusiMin,suurempi );
            }
        }
        return keko;        
    }
    
    
    private static void asetaLinkit(Fibonaccipuu vasen, Fibonaccipuu oikea){
        if (vasen == null || oikea == null){
            return;
        }
        vasen.setSiblingL(oikea);
        oikea.setSiblingR(vasen);
    }
    
    private static Fibonaccikeko nullVersionMerge(Fibonaccikeko keko1, Fibonaccikeko keko2){
        Fibonaccikeko keko = null;
        if (keko1== null && keko2==null){
            return null;
        }
        keko = Fibonaccikeko.makeHeap();
        if (keko1 == null && keko2 != null){
            keko.setMin(keko2.getMin());
            keko2 = null;
        }
        else if (keko2 == null && keko1 != null){
            keko.setMin(keko1.getMin());
            keko1 = null;
        }
        return keko;
    }
}
