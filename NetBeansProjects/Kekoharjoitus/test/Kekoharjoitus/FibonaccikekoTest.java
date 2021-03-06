/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kekoharjoitus;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Fibonaccikeko luokan yksikkötestiluokka
 * @author pturunen
 */
public class FibonaccikekoTest {
    
    public Fibonaccikeko instanssi =null;
    public Fibonaccikeko instanssi2 = null;
    public Fibonaccikeko instanssiUusi = null;
    public Fibonaccipuu binomipuu = null;
    public Fibonaccipuu binomipuu2 = null;
    public Solmu solmu = null;
    public Solmu solmu2 = null;
    public int arvo =0;
    Random generator = null;
    
    
    public FibonaccikekoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       instanssi = new Fibonaccikeko();
       instanssi2 = new Fibonaccikeko();
       binomipuu = new Fibonaccipuu();
       binomipuu2 = new Fibonaccipuu();
       arvo = 8;
       solmu = new Solmu(arvo);
       arvo=2;
       solmu2 = new Solmu(arvo);
       
       generator = new Random(); 
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Testi Fibonaccikeko konstruktorille
     */
    @Test
    public void testaaKonstruktoriFibonaccikekoTest(){
       assertEquals(null, instanssi.findMin());
    }
    
    
    /**
     * Testi MakeHeap() perustapaus
     * odotettu tulos funktio palauttaa Fibonaccikeko olion
     */
    @Test
    public void perustapausMakeHeapTest(){
       instanssi =Fibonaccikeko.makeHeap();
       assertEquals(null, instanssi.findMin());
    }

    /**
     * Testaa insert() 
     * odotettu lopputulos ,kekoon onnistuu yhden solmun lisäys
     * keko on kekoehdon mukaisesti ehyt lisäyksen jälkeen
     * palauttaa tarkistuksessa oikean minimikeon arvon
     */
    @Test
    public void insertYksiSolmuInsertTest() {
        assertNull(instanssi.findMin());
        instanssi.insert(solmu);
        Solmu solmuMin = instanssi.findMin();
        assertNotNull(solmuMin);
        assertEquals(solmu.getValue(), solmuMin.getValue());
    }
    
    /**
     * Testaa insert() 
     * odotettu lopputulos ,kekoon onnistuu solmun lisäys
     * keko on kekoehdon mukaisesti ehyt lisäyksen jälkeen
     * palauttaa tarkistuksessa oikean minimikeon arvon
     * juurilistan kolme solmua,
     *  12 ;degree 0
     *   7  ;degree 1
     *  15 ;degree 2
     *  heapsize = 7 solmua
     */
    @Test
    public void insert7SolmuInsertTest() {
        assertNull(instanssi.findMin());
        int pienin = Integer.MAX_VALUE;
        int [] taulukko = {41,28,33,15,7,25,12};
        for (int i =0;i<taulukko.length;i++){
            solmu = new Solmu(taulukko[i]);
            instanssi.insert(solmu);
            if (pienin > solmu.getValue()){
                pienin = solmu.getValue();
            }
            assertEquals(pienin, instanssi.findMin().getValue());
        }
        assertEquals(pienin, instanssi.findMin().getValue());
        assertEquals(pienin,instanssi.getMin().getValue().getValue());
    }
    
    /**
     * Testaa insert() 
     * odotettu lopputulos ,kekoon onnistuu solmun lisäys
     * keko on kekoehdon mukaisesti ehyt lisäyksen jälkeen
     * palauttaa tarkistuksessa oikean minimikeon arvon
     * juurilistan kolme solmua,
     * generoidaan satunnaisesti 9260 solmua
     */
    @Test
    public void UseanSolmunLisaysInsertTest(){
        assertNull(instanssi.findMin());
        int pienin = Integer.MAX_VALUE;
        for (int i =0;i<9260;i++){
            solmu = new Solmu(generator.nextInt());
            instanssi.insert(solmu);
            if (pienin > solmu.getValue()){
                pienin = solmu.getValue();
            }
        }
        assertEquals(pienin, instanssi.findMin().getValue());
        assertEquals(pienin,instanssi.getMin().getValue().getValue());
    }
    
    /**
     * Testaa findMin 
     * odotettu lopputulos ,palauttaa null
     */
    @Test
    public void tyhjaKekoFindMinTest() {
        assertEquals(null, instanssi.findMin());
    }

    /**
     * Testaa findMin 
     * asetetaan kaksi Solmu oliota Fibonaccikekoon, siten että ensimmäisen Solmu 
     * olion value arvo on suurempi kuin toisen.
     * odotettu lopputulos ,palauttaa yhden Solmu olion
     * joka pysyy keossa.
     */
    @Test
    public void kaksiSolmuaKekoFindMinTest() {
        assertEquals(null, instanssi.findMin());
        instanssi.insert(solmu);
        assertEquals(solmu.getValue(), instanssi.findMin().getValue());
        assertTrue(solmu.getValue() > solmu2.getValue());
        instanssi.insert(solmu2);
        assertEquals(solmu2.getValue(), instanssi.findMin().getValue());
    }

    /**
     * Testaa deleteMin 
     * odotettu lopputulos ; palauttaa binomikeon pienimmän arvon omaavan
     * Solmu olion ja poistaa sen keosta.
     */
    @Test
    public void keossaYksiSolmuDeleteMinTest() {
        assertNull(instanssi.findMin());
        assertNull(instanssi.deleteMin());
        instanssi.insert(solmu);
        assertEquals(solmu.getValue(), instanssi.deleteMin().getValue());
    }

    /**
     * Testaa deleteMin 
     * odotettu lopputulos ; palauttaa binomikeon pienimmän arvon omaavan
     * Solmu olion ja poistaa sen keosta.
     */
    @Test
    public void MontaSolmuaPoistaKaikkiDeleteMinTest() {
        assertNull(instanssi.findMin());
        assertNull(instanssi.deleteMin());
        int[] taulukko = {2,5,9,10,22,33,3,90,1,40,11,12,13,8,4,400,32,18,7,21,4000,200};
        alustaKeot(instanssi,taulukko);
        assertEquals(1, instanssi.deleteMin().getValue());
        assertEquals(2, instanssi.deleteMin().getValue());
        assertEquals(3, instanssi.deleteMin().getValue());
    }
    
    /**
     * Testaa deleteMin 
     * odotettu lopputulos ; palauttaa binomikeon pienimmän arvon omaavan
     * Solmu olion ja poistaa sen keosta.
     * random arvot suuremilla solmumäärillä,kaikki yksitellen
     * kunnes keko tyhjä
     */
    @Test
    public void randomDeleteMinTest() {
        //pre-ehto
       assertNull(instanssi.findMin());
        assertNull(instanssi.deleteMin());
        //keon alustus
        int pienin = Integer.MAX_VALUE;
       for (int i =0;i<2000;i++){
            //solmu = new Solmu(generator.nextInt(1000));
           solmu = new Solmu(i);
            instanssi.insert(solmu);
            if (pienin > solmu.getValue()){
                pienin = solmu.getValue();
            }
        }
        while (instanssi.findMin() != null){
            pienin = instanssi.findMin().getValue();
            assertEquals(pienin, instanssi.deleteMin().getValue());
        }
    }

    /**
     * Testaa DecreaseKey() 
     * odotettu lopputulos,keko palauttaa -1, koska keko on tyhja
     * 
     */
    @Test
    public void tyhjaKekoDecreaseKeyTest() { 
        assertNull(instanssi.findMin());
        solmu2 = new Solmu(9);
        Fibonaccipuu puu = new Fibonaccipuu();     
        assertEquals(-1, instanssi.decreaseKey(puu, 2)); 
    }
    
    /**
     * Testaa DecreaseKey() 
     * odotettu lopputulos,keko palauttaa 0, ja muutettu arvo 
     * on keon minimiarvo joten se palautetaan finMin kyselyssä
     * 
     */
    @Test
    public void yksiAlkioDecreaseKeyTest() { 
        assertNull(instanssi.findMin());
        solmu = new Solmu(8);
        instanssi.insert(solmu);
        assertEquals(solmu.getValue(),instanssi.findMin().getValue());
        Fibonaccipuu mini = instanssi.getMin();
        Fibonaccipuu dec = instanssi.findFibonaccipuu(mini,solmu,mini);
        assertEquals(dec.getValue().getValue(),solmu.getValue());
        assertEquals(0, instanssi.decreaseKey(dec, 2)); 
        assertEquals(2,instanssi.findMin().getValue());
    }

    /**
     * Testaa DecreaseKey() 
     * odotettu lopputulos,keko palauttaa 0, ja muutettu arvo 
     * on keon minimiarvo joten se palautetaan finMin kyselyssä
     * 
     */
    @Test
    public void montaAlkiotaDecreaseKeyTest() { 
        assertNull(instanssi.findMin());  
        int [] taulukko = {55,45,4,30,24,9,22,8,50,48,31,29,17,10,44,6,37,3,18};
        alustaKeot(instanssi,taulukko);
        assertEquals(3,instanssi.findMin().getValue());
        solmu = new Solmu(29);
        Fibonaccipuu mini = instanssi.getMin();
        Fibonaccipuu dec = instanssi.findFibonaccipuu(mini,solmu,mini);
        assertEquals(dec.getValue().getValue(),solmu.getValue());
        assertEquals(0, instanssi.decreaseKey(dec, 2)); 
        assertEquals(2,instanssi.findMin().getValue());
    }
    
    /**
     * Testaa DecreaseKey() 
     * odotettu lopputulos,keko palauttaa -1, koska muutettava
     * arvo on suurempi kuin Solmun alkuperäinen arvo
     * 
     */
    @Test
    public void liianSuuriArvoKekoDecreaseKeyTest() {
        assertNull(instanssi.findMin());  
        int [] taulukko = {55,45,4,30,24,9,22,8,50,48,31,29,17,10,44,6,37,3,18};
        alustaKeot(instanssi,taulukko);
        assertEquals(3,instanssi.findMin().getValue());
        solmu = new Solmu(29);
        Fibonaccipuu mini = instanssi.getMin();
        Fibonaccipuu dec = instanssi.findFibonaccipuu(mini,solmu,mini);
        assertEquals(dec.getValue().getValue(),solmu.getValue());
        assertEquals(-1, instanssi.decreaseKey(dec, 33)); 
        assertEquals(3,instanssi.findMin().getValue());
    }
 
    /**
     * Testaa DecreaseKey() 
     * odotettu lopputulos,keko palauttaa 0, 
     * 
     */
    @Test
    public void randomArvoDecreaseKeyTest() {
        //pre-ehto
        assertNull(instanssi.findMin());
        //keon alustus
        int suurin = 0;
        int pienin = Integer.MAX_VALUE;
        for (int i =0;i<920;i++){
            solmu = new Solmu(generator.nextInt());
            instanssi.insert(solmu);
            if (pienin > solmu.getValue()){
                pienin = solmu.getValue();
            }
            if (suurin <solmu.getValue()){
                suurin = solmu.getValue();
            }
        }
        solmu.setValue(suurin);
        assertEquals(pienin,instanssi.findMin().getValue());
        Fibonaccipuu mini = instanssi.getMin();
        Fibonaccipuu dec = instanssi.findFibonaccipuu(mini,solmu,mini);
        assertEquals(dec.getValue().getValue(),solmu.getValue());
        assertEquals(0, instanssi.decreaseKey(dec, suurin-3)); 
    }
 
 
    /**
     * Testaa merge() 
     * odotettu lopputulos; taulukko2 sisaltaa pienemman minimi arvon
     * mergen jälkeen uuden keon minimi arvo on taulukko2 minimiarvo
     */
    @Test
    public void yhdistaKaksiKekoaMergeTest() {
        //Ensimmainen keko
        assertNull(instanssi.findMin());
        int [] taulukko = {41,28,33,15,7,25,12};
        alustaKeot(instanssi,taulukko);
        //Toinen keko
        int [] taulukko2 = {55,45,32,30,24,23,22,8,50,48,31,29,17,10,44,6,37,3,18};
        alustaKeot(instanssi2,taulukko2);
        Fibonaccikeko uusi = Fibonaccikeko.merge(instanssi, instanssi2);
        assertEquals(3,uusi.findMin().getValue());
    }
    
    /**
     * Testaa merge() 
     * odotettu lopputulos; taulukko2 sisaltaa pienemman minimi arvon
     * mergen jälkeen uuden keon minimi arvo on taulukko2 minimiarvo
     * koska taulukko1 on null
     */
    @Test
    public void yhdistaEkaNullKekoaMergeTest() {
        //Ensimmainen keko
        assertNull(instanssi.findMin());
        assertNull(instanssi.getMin());
        //Toinen keko
        int [] taulukko2 = {55,45,32,30,24,23,22,8,50,48,31,29,17,10,44,6,37,3,18};
        alustaKeot(instanssi2,taulukko2);
        Fibonaccikeko uusi = Fibonaccikeko.merge(instanssi, instanssi2);
        assertEquals(3,uusi.findMin().getValue());
    }
    
     /**
     * Testaa merge() 
     * odotettu lopputulos; taulukko2 sisaltaa pienemman minimi arvon
     * mergen jälkeen uuden keon minimi arvo on taulukko2 minimiarvo
     * koska taulukko1 on null
     */
    @Test
    public void yhdistaTokaNullKekoaMergeTest() {
        //Ensimmainen keko
        assertNull(instanssi.findMin());
        assertNull(instanssi.getMin());
        //Toinen keko
        int [] taulukko2 = {55,45,32,30,24,23,22,8,50,48,31,29,17,10,44,6,37,3,18};
        alustaKeot(instanssi2,taulukko2);
        Fibonaccikeko uusi = Fibonaccikeko.merge(instanssi2, instanssi);
        assertEquals(3,uusi.findMin().getValue());
    }
    
    
    /**
     * Testaa findBinomipuu() apufunktio decreaseKey funktiolle
     * Annetaan parametrina Solmu olio jonka arvoa halutaan muuttaa
     * Palauttaa Binomipuu olion jossa ko Solmu olio on talletettuna
     * Testataan että funktio löytää kaikki asetetut 7 solmua
     *
     */
    @Test
    public void insert7SolmuaFindBinomipuuTest() {
        assertNull(instanssi.findMin());
        int pienin = Integer.MAX_VALUE;
        int [] taulukko = {41,28,33,15,7,25,12};
        for (int i =0;i<taulukko.length;i++){
            solmu = new Solmu(taulukko[i]);
            instanssi.insert(solmu);
            if (pienin > solmu.getValue()){
                pienin = solmu.getValue();
            }
            assertEquals(pienin, instanssi.findMin().getValue());
        }
        assertEquals(pienin, instanssi.findMin().getValue());
    }
 


    void alustaKeot(Fibonaccikeko instanssi,int[] taulukko){
        assertNull(instanssi.findMin());
        int pienin = Integer.MAX_VALUE;
        for (int i =0;i<taulukko.length;i++){
            solmu = new Solmu(taulukko[i]);
            instanssi.insert(solmu);
            if (pienin > solmu.getValue()){
                pienin = solmu.getValue();
            }
            assertEquals(pienin, instanssi.findMin().getValue());
        }
        assertEquals(pienin, instanssi.findMin().getValue());
    }
}
