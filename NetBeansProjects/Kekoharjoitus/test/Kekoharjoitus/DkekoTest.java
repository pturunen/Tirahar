/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kekoharjoitus;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Random;
//import static org.junit.Assert.*;

/**
 *
 * @author pturunen
 */
public class DkekoTest extends TestCase{
    Dkeko instanssi =null;
    Dkeko instanssi2 =null;
    Dkeko instanssi3 =null;
    Dkeko instanssi5 =null;
    Dkeko instanssi20 =null;
    
    Solmu solmu = null;
    Solmu solmu1 = null;
    Solmu solmu2 = null;
    Solmu solmuNull = null;
    
    int solmuarvo = 0;
    int solmuarvo1 = 0;
    int solmuarvo2 = 0;
    
    int pienin =0;
    int suurin =0;
    Random generator = null;
    
    public DkekoTest(String testName) {
        super(testName);
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instanssi = null;
        instanssi2 = new Dkeko(2);
        instanssi3 = new Dkeko(3);
        instanssi5 = new Dkeko(5);
        instanssi20 = new Dkeko(20);
        solmuarvo = 0;
        solmuarvo1 = 1;
        solmuarvo2 = 2;
        solmu = new Solmu(solmuarvo);
        solmu1 = new Solmu(solmuarvo1);
        solmu2 = new Solmu(solmuarvo2);
        pienin=Integer.MAX_VALUE;
        suurin =0;
        generator = new Random();
    }
    
    @After
    public void tearDown() {
    }

    
    /**
     * Testi Dkeon konstruktorille
     */
    @Test
    public void testaaKonstruktoriDkekoTest(){
       assertEquals(2, instanssi2.getAste());
       assertEquals(3, instanssi3.getAste());
       assertEquals(5, instanssi5.getAste());
       assertEquals(20, instanssi20.getAste());
    }
    
    
    /**
     * Testi MakeHeap() perustapaus
     * odotettu tulos funktio palauttaa Dkeko olion
     */
    @Test
    public void aste2OkMakeHeapTest(){
       instanssi =Dkeko.makeHeap(2);
       assertEquals(2, instanssi.getAste());
       assertEquals(0, instanssi.getHeapSize());
       assertEquals(null, instanssi.getMin());
       assertEquals(null, instanssi.getTail());
       
       instanssi =Dkeko.makeHeap(20);
       assertEquals(20, instanssi.getAste());
       assertEquals(0, instanssi.getHeapSize());
       assertEquals(null, instanssi.getMin());
       assertEquals(null, instanssi.getTail());
    }
    
    /**
     * Testi MakeHeap() virhetapaus
     * odotettu tulos funktio palauttaa null
     */
    @Test
    public void asteNotOkMakeHeapTest(){
       instanssi =Dkeko.makeHeap(-2);
       assertEquals(null, instanssi);
       
       instanssi =Dkeko.makeHeap(7);
       assertEquals(7, instanssi.getAste());
       
       instanssi =Dkeko.makeHeap(0);
       assertEquals(null, instanssi);
    }

    /**
     * Testaa findMin 
     * odotettu lopputulos ,palauttaa null
     */
    @Test
    public void tyhjaKekoFindMinTest() {
        assertEquals(null, instanssi2.findMin());
        assertEquals(null, instanssi3.findMin());
        assertEquals(null, instanssi5.findMin());
    }

    /**
     * Testaa findMin 
     * odotettu lopputulos ,palauttaa yhden Solmu olion
     * joka pysyy keossa.
     */
    @Test
    public void yksiSolmuKekoFindMinTest() {
        assertEquals(null, instanssi2.findMin());
        instanssi2.insert(solmu1);
        assertEquals(1, solmu1.getValue());
        
        assertNotNull(instanssi2.findMin());
        assertEquals(solmu1.getValue(), instanssi2.findMin().getValue());
       
        assertNotNull(instanssi2.findMin());
        assertEquals(solmu1.getValue(), instanssi2.findMin().getValue());
    }
    
    /**
     * Testaa findMin 
     * odotettu lopputulos ,palauttaa yhden Solmu olion
     * joka pysyy keossa.Asetetaan solmut järjestyksessä
     * suuremmasta pienempään
     */
    @Test
    public void keossa210SolmuSolmuKekoFindMinTest() {
        assertEquals(null, instanssi2.findMin());
        
        instanssi2.insert(solmu2);
        assertEquals(2, solmu2.getValue());
        assertNotNull(instanssi2.findMin());
        assertEquals(solmu2.getValue(), instanssi2.findMin().getValue());
        
        instanssi2.insert(solmu1);
        assertEquals(1, solmu1.getValue());
        assertNotNull(instanssi2.findMin());
        assertEquals(solmu1.getValue(), instanssi2.findMin().getValue());
        
        instanssi2.insert(solmu);
        assertEquals(0, solmu.getValue());
        assertNotNull(instanssi2.findMin());
        assertEquals(solmu.getValue(), instanssi2.findMin().getValue());
        
        assertNotNull(instanssi2.findMin());
        assertEquals(solmu.getValue(), instanssi2.findMin().getValue());
    }
    
    /**
     * Testaa findMin 
     * odotettu lopputulos ,palauttaa yhden Solmu olion
     * arvolla 0,pysyy koko ajan keon pienimpänä
     * joka pysyy keossa.Asetetaan solmut järjestyksessä
     * pienemmästä suurempaan
     */
    @Test
    public void keossa012SolmuSolmuKekoFindMinTest() {
        assertEquals(null, instanssi2.findMin());
        instanssi2.insert(solmu);
        assertEquals(0, solmu.getValue());
        assertNotNull(instanssi2.findMin());
        assertEquals(solmu.getValue(), instanssi2.findMin().getValue());
        
        instanssi2.insert(solmu1);
        assertEquals(1, solmu1.getValue());
        assertNotNull(instanssi2.findMin());
        assertEquals(solmu.getValue(), instanssi2.findMin().getValue());
        
        instanssi2.insert(solmu2);
        assertEquals(2, solmu2.getValue());
        assertNotNull(instanssi2.findMin());
        assertEquals(solmu.getValue(), instanssi2.findMin().getValue());
        
        assertNotNull(instanssi2.findMin());
        assertEquals(solmu.getValue(), instanssi2.findMin().getValue());
    }
    
    
    /**
     * Testaa insert() 
     * odotettu lopputulos ,kekoon onnistuu yhden solmun lisäys
     * keko on kekoehdon mukaisesti ehyt lisäyksen jälkeen
     * palauttaa tarkistuksessa oikean minimikeon arvon
     */
    @Test
    public void haarautumisaste2YksiSolmuInsertTest() {
        assertEquals(solmuNull, instanssi2.getMin());
        instanssi2.insert(solmu);
        assertEquals(solmu.getValue(), instanssi2.findMin().getValue());
    }

     /**
     * Testaa insert() 
     * odotettu lopputulos ,kekoon onnistuu yhden solmun lisäys
     * keko on kekoehdon mukaisesti ehyt lisäyksen jälkeen
     * palauttaa tarkistuksessa oikean minimikeon arvon
     */
    @Test
    public void haarautumisaste5YksiSolmuInsertTest() {
        assertEquals(solmuNull, instanssi5.getMin());
        instanssi5.insert(solmu);
        assertEquals(solmu.getValue(), instanssi5.findMin().getValue());
    }
    
    
    /**
     * Testaa insert() 
     * odotettu lopputulos,kekoon onnistuu useamman kuin haarautumisaste 
     * solmun lisääminen
     * keko on kekoehdon mukaisesti ehyt lisäyksen jälkeen
     * palauttaa tarkistuksessa oikean minimikeon arvon
     */
    @Test
    public void haarautumisaste2ViisiSolmuaInsertTest() {
        assertEquals(solmuNull, instanssi2.getMin());
        assertEquals(2, instanssi2.getAste());
        //isommasta pienempään järjestyksessä
        for (int i=4;i>=0;i--){
            solmu = new Solmu(i);
            instanssi2.insert(solmu);
            assertEquals(solmu.getValue(), instanssi2.findMin().getValue());
        }
        
        //pienemmästä isompaan solmu järjestyksessä
        instanssi2 =Dkeko.makeHeap(solmuarvo2);
        assertEquals(solmuNull, instanssi2.findMin());
        for (int i=0;i<5;i++){
            solmu = new Solmu(i);
            instanssi2.insert(solmu);
            assertEquals(0, instanssi2.findMin().getValue());
        }
        
        }
        
     /**
     * Testaa insert() 
     * odotettu lopputulos,kekoon onnistuu useamman kuin haarautumisaste 
     * solmun lisääminen solmun arvo valitaan satunnaisesti
     * keko on kekoehdon mukaisesti ehyt lisäyksen jälkeen
     * palauttaa tarkistuksessa oikean minimikeon arvon
     */
    @Test
    public void haarautumisaste2RandomSolmuaInsertTest() {
        assertEquals(solmuNull, instanssi2.findMin());
        for (int i=0;i<29;i++){
            solmuarvo = generator.nextInt(Integer.MAX_VALUE);
            if (pienin > solmuarvo){
                pienin = solmuarvo;
            }
            solmu = new Solmu(solmuarvo);
            instanssi2.insert(solmu);
            assertEquals(pienin, instanssi2.findMin().getValue());
        }
    }
    
    /**
     * Testaa insert() 
     * odotettu lopputulos,kekoon onnistuu useamman kuin haarautumisaste 
     * solmun lisääminen solmun arvo valitaan satunnaisesti
     * keko on kekoehdon mukaisesti ehyt lisäyksen jälkeen
     * palauttaa tarkistuksessa oikean minimikeon arvon
     */
    @Test
    public void haarautumisaste20RandomSolmuaInsertTest() {
        assertEquals(solmuNull, instanssi20.getMin());
        for (int i=0;i<9260;i++){
            solmuarvo =generator.nextInt();
            if (pienin > solmuarvo){
                pienin = solmuarvo;
            }
            solmu = new Solmu(solmuarvo);
            instanssi20.insert(solmu);
            assertEquals(pienin, instanssi20.findMin().getValue());
        }
    }
    
    /**
     * Testaa deleteMin() 
     * odotettu lopputulos,keko palauttaa null, koska keko tyhja
     * 
     */
    @Test
    public void tyhjakekodeleteMinTest() {
        assertNull(instanssi2.findMin());
        assertNull(instanssi2.deleteMin());
    }

    /**
     * Testaa deleteMin() 
     * odotettu lopputulos,keko palauttaa solmu kerrallaan kunnes
     * keko on tyhjä.keon minimisolmun arvo tarkistetaan ennen ja jälkeen
     * deleteMin operaatioita.Sen arvon tulee olla eri ennen ja jälkeen testin
     * 
     */
    @Test
    public void aste20RandomDeleteMinTest() {
        assertEquals(solmuNull, instanssi20.getMin());
        for (int i=0;i<9260;i++){
            solmuarvo =generator.nextInt();
            if (pienin > solmuarvo){
                pienin = solmuarvo;
            }
            solmu = new Solmu(solmuarvo);
            instanssi20.insert(solmu);
            assertEquals(pienin, instanssi20.findMin().getValue());
        }
        
        while (instanssi20.getHeapSize()!=0){
            pienin = instanssi20.findMin().getValue();
            assertEquals(pienin, instanssi20.deleteMin().getValue());
            if (instanssi20.getHeapSize()!=0){
              assertTrue(pienin != instanssi20.findMin().getValue());  
            } 
        }
    }
    
    /**
     * Testaa DecreaseKey() 
     * odotettu lopputulos,keko palauttaa -1, koska keko on tyhja
     * 
     */
    @Test
    public void tyhjaKekoDecreaseKeyTest() {
        assertNull(instanssi5.findMin());
        solmu = new Solmu(3);
        assertEquals(-1, instanssi5.decreaseKey(solmu, 2)); 
    }
    
    
    /**
     * Testaa DecreaseKey() 
     * odotettu lopputulos,keko palauttaa -1, koska keossa ei ole
     * parametrina annettua solmun arvoa
     * 
     */
    @Test
    public void arvoaEiLoydyKekoDecreaseKeyTest() {
        assertNull(instanssi5.findMin());
        solmu = new Solmu(3);
        instanssi5.insert(solmu);
        assertEquals(solmu.getValue(), instanssi5.findMin().getValue());
        assertEquals(-1, instanssi5.decreaseKey(solmu1, 0)); 
    }
     
    /**
     * Testaa DecreaseKey() 
     * odotettu lopputulos,keko palauttaa -1, koska 
     * parametrina annettua solmun arvoa yritetaan kasvattaa keossa
     * 
     */
    @Test
    public void increaseYritysDecreaseKeyTest() {
        assertNull(instanssi5.findMin());
        solmu = new Solmu(3);
        instanssi5.insert(solmu);
        assertEquals(solmu.getValue(), instanssi5.findMin().getValue());
        assertEquals(-1, instanssi5.decreaseKey(solmu, 4)); 
    }
    
    /**
     * Testaa decreaseKey
     * odotettu lopputulos,keossa olevan solmun arvon pienentäminen onnistuu
     * ja solmusta tulee keon pienin alkio
     */
    @Test
    public void aste5RandomDecreaseKeyTest() {
        assertEquals(solmuNull, instanssi5.findMin());
        for (int i=0;i<59;i++){
            solmuarvo =generator.nextInt(Integer.MAX_VALUE);
            if (pienin > solmuarvo){
                pienin = solmuarvo;
            }
            if (suurin < solmuarvo){
                suurin = solmuarvo;
            }
            solmu = new Solmu(solmuarvo);
            instanssi5.insert(solmu);
            assertEquals(pienin, instanssi5.findMin().getValue());
        }
        
        instanssi5.deleteMin();
        assertTrue(pienin != instanssi5.findMin().getValue());
        solmu1.setValue(suurin);
        instanssi5.decreaseKey(solmu1, pienin);
        assertEquals(pienin, instanssi5.findMin().getValue());
    }

    /**
     * Testaa merge()
     */
    @Test
    public void testaaMergeTest() {
        for(int i=12;i>=3;i--){
            solmu = new Solmu(i);
            instanssi5.insert(solmu);
        }
        for(int i=2;i>=1;i--){
            solmu = new Solmu(i);
            instanssi2.insert(solmu);
        }
        
        instanssi = Dkeko.merge(instanssi2,instanssi5);
        assertEquals(1, instanssi.findMin().getValue());
    }
    
     public static junit.framework.Test suite(){
     junit.framework.TestSuite suite = new junit.framework.TestSuite();
     suite.addTest(new DkekoTest("testaaKonstruktoriDkekoTest"));
     suite.addTest(new DkekoTest("aste2OkMakeHeapTest"));
     suite.addTest(new DkekoTest("asteNotOkMakeHeapTest"));
     suite.addTest(new DkekoTest("tyhjaKekoFindMinTest"));
     suite.addTest(new DkekoTest("yksiSolmuKekoFindMinTest"));
     suite.addTest(new DkekoTest("keossa210SolmuSolmuKekoFindMinTest"));
     suite.addTest(new DkekoTest("keossa012SolmuSolmuKekoFindMinTest"));
     suite.addTest(new DkekoTest("haarautumisaste2YksiSolmuInsertTest"));
     suite.addTest(new DkekoTest("haarautumisaste5YksiSolmuInsertTest"));
     suite.addTest(new DkekoTest("haarautumisaste2ViisiSolmuaInsertTest"));
     suite.addTest(new DkekoTest("haarautumisaste2RandomSolmuaInsertTest"));
     suite.addTest(new DkekoTest("haarautumisaste20RandomSolmuaInsertTest"));
     suite.addTest(new DkekoTest("aste20RandomDeleteMinTest"));
     suite.addTest(new DkekoTest("tyhjaKekoDecreaseKeyTest"));
     suite.addTest(new DkekoTest("arvoaEiLoydyKekoDecreaseKeyTest"));
     suite.addTest(new DkekoTest("increaseYritysDecreaseKeyTest"));
     suite.addTest(new DkekoTest("aste5RandomDecreaseKeyTest"));
     suite.addTest(new DkekoTest("testaaMergeTest"));
           
    return suite;
 }
    
}
