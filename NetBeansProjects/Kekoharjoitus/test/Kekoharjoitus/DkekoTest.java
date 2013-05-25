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
    public void haarautumisaste2YksiSolmuInsert() {
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
    public void haarautumisaste5YksiSolmuInsert() {
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
    public void haarautumisaste2ViisiSolmuaInsert() {
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
    public void haarautumisaste2RandomSolmuaInsert() {
        assertEquals(solmuNull, instanssi2.findMin());
        for (int i=0;i<29;i++){
            solmuarvo =(int) Math.random();
            if (pienin > solmuarvo){
                pienin = solmuarvo;
            }
            solmu = new Solmu(solmuarvo);
            instanssi2.insert(solmu);
            assertEquals(pienin, instanssi2.findMin().getValue());
        }
        
        instanssi2.insert(solmu);
        assertEquals(solmu.getValue(), instanssi2.findMin().getValue());
    }
    
    /**
     * Testaa insert() 
     * odotettu lopputulos,kekoon onnistuu useamman kuin haarautumisaste 
     * solmun lisääminen solmun arvo valitaan satunnaisesti
     * keko on kekoehdon mukaisesti ehyt lisäyksen jälkeen
     * palauttaa tarkistuksessa oikean minimikeon arvon
     */
    @Test
    public void haarautumisaste20RandomSolmuaInsert() {
        assertEquals(solmuNull, instanssi20.getMin());
        for (int i=0;i<9260;i++){
            solmuarvo =(int) Math.random();
            if (pienin > solmuarvo){
                pienin = solmuarvo;
            }
            solmu = new Solmu(solmuarvo);
            instanssi20.insert(solmu);
            assertEquals(pienin, instanssi20.findMin().getValue());
        }
    }
    

    /**
     * Test of deleteMin method, of class Dkeko.
     */
    @Test
    public void testDeleteMin() {
        System.out.println("deleteMin");
        Dkeko instance = new Dkeko(2);
        Solmu expResult = null;
        Solmu result = instance.deleteMin();
        assertEquals(expResult, result);
        
        Dkeko instance5 = new Dkeko(5);
        Solmu five1 = new Solmu(7);
        instance5.insert(five1);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five1.getValue(), instance5.findMin().getValue());
        
        Solmu five2 = new Solmu(6);
        instance5.insert(five2);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five2.getValue(), instance5.findMin().getValue());
        
        Solmu five3 = new Solmu(5);
        System.out.println("------------testInsert BEFORE kolmas-------");
        instance5.insert(five3);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five3.getValue(), instance5.findMin().getValue());
        
        Solmu five4 = new Solmu(4);
        instance5.insert(five4);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five4.getValue(), instance5.findMin().getValue());
        
        Solmu five5 = new Solmu(3);
        instance5.insert(five5);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five5.getValue(), instance5.findMin().getValue());
        
        Solmu five6 = new Solmu(2);
        instance5.insert(five6);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five6.getValue(), instance5.findMin().getValue());
        
        Solmu five7 = new Solmu(1);
        assertEquals(0, instance5.getMin().getKey());
        System.out.println("five7 testcase begin");
        instance5.insert(five7);
        System.out.println("five7 testcase end");
        assertEquals(0,instance5.getMin().getKey());
        assertEquals(five7.getValue(), instance5.findMin().getValue());
        
        Solmu five8 = new Solmu(8);
        instance5.insert(five8);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five7.getValue(), instance5.findMin().getValue());
        
        //decrease value must be less than original value
        //expected result no changes
        Kekoalkio alkio =instance5.findKekoalkio(five7);
        instance5.decreaseKey(alkio, 10);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five7.getValue(), instance5.findMin().getValue());
      
        alkio =instance5.findKekoalkio(five8);
        instance5.decreaseKey(alkio, 0);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five8.getValue(), instance5.findMin().getValue());
        
        Solmu pienin;
        pienin = instance5.deleteMin();
        assertEquals(five8.getValue(), pienin.getValue());
        
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five7.getValue(), instance5.findMin().getValue());
        
        System.out.println(" keko "+instance5);
        pienin = instance5.deleteMin();
        assertEquals(five7.getValue(), pienin.getValue());
        
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five6.getValue(), instance5.findMin().getValue());
        
        pienin = instance5.deleteMin();
        assertEquals(five6.getValue(), pienin.getValue());
        
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five5.getValue(), instance5.findMin().getValue());
        
        pienin = instance5.deleteMin();
        assertEquals(five5.getValue(), pienin.getValue());
        
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five4.getValue(), instance5.findMin().getValue());
        
        pienin = instance5.deleteMin();
        assertEquals(five4.getValue(), pienin.getValue());
        
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five3.getValue(), instance5.findMin().getValue());
        
        pienin = instance5.deleteMin();
        assertEquals(five3.getValue(), pienin.getValue());
        
        assertEquals(0,instance5.getMin().getKey());
        assertEquals(five2.getValue(), instance5.findMin().getValue());
        
        pienin = instance5.deleteMin();
        assertEquals(five2.getValue(), pienin.getValue());
        
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five1.getValue(), instance5.findMin().getValue());
        
         pienin = instance5.deleteMin();
        assertEquals(five1.getValue(), pienin.getValue());
        
        assertEquals(null, instance5.findMin());
       
    }

    /**
     * Test of decreaseKey method, of class Dkeko.
     */
    @Test
    public void testDecreaseKey() {
        System.out.println("decreaseKey");
        Dkeko instance = new Dkeko(2);
        Solmu uusi = new Solmu(8);
        instance.insert(uusi);
        assertEquals(0, instance.getMin().getKey());
        assertEquals(8, instance.findMin().getValue());
        Solmu uusi2 = new Solmu(9);
        instance.insert(uusi2);
        assertEquals(0, instance.getMin().getKey());
        assertEquals(8, instance.findMin().getValue());
        
        Kekoalkio alkio = instance.findKekoalkio(uusi2);
        instance.decreaseKey(alkio,4);
        assertEquals(0, instance.getMin().getKey());
        assertEquals(4, instance.findMin().getValue());
        
        Dkeko instance5 = new Dkeko(5);
        System.out.println("---------------testDecreaseKey() insert 7");
        Solmu five1 = new Solmu(7);
        instance5.insert(five1);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five1.getValue(), instance5.findMin().getValue());
        System.out.println("---------------testDecreaseKey() insert 6");
        
        Solmu five2 = new Solmu(6);
        instance5.insert(five2);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five2.getValue(), instance5.findMin().getValue());
        System.out.println("---------------testDecreaseKey() insert 5");
        
        Solmu five3 = new Solmu(5);
        instance5.insert(five3);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five3.getValue(), instance5.findMin().getValue());
        System.out.println("---------------testDecreaseKey() insert 4");
        
        Solmu five4 = new Solmu(4);
        instance5.insert(five4);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five4.getValue(), instance5.findMin().getValue());
        System.out.println("---------------testDecreaseKey() insert 3");
        
        Solmu five5 = new Solmu(3);
        instance5.insert(five5);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five5.getValue(), instance5.findMin().getValue());
        System.out.println("---------------testDecreaseKey() insert 2");
        
        Solmu five6 = new Solmu(2);
        instance5.insert(five6);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five6.getValue(), instance5.findMin().getValue());
        
        System.out.println("---------------testDecreaseKey() insert 1");
        Solmu five7 = new Solmu(1);
        assertEquals(0, instance5.getMin().getKey());
        instance5.insert(five7);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five7.getValue(), instance5.findMin().getValue());
        
        System.out.println("---------------testDecreaseKey() insert 8");
        Solmu five8 = new Solmu(8);
        instance5.insert(five8);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five7.getValue(), instance5.findMin().getValue());
        
        //decrease value must be less than original value
        //expected result no changes
        System.out.println("---------------testDecreaseKey() decrease 1 to 10");
        alkio = instance5.findKekoalkio(five7);
        instance5.decreaseKey(alkio, 10);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five7.getValue(), instance5.findMin().getValue());
      
        
        System.out.println("---------------testDecreaseKey() decrease 8 to 0");
        System.out.println("---------- before--------\n"+instance5);
        alkio = instance5.findKekoalkio(five8);
        instance5.decreaseKey(alkio, 0);
        assertEquals(0, instance5.getMin().getKey());
        System.out.println("five8 value="+five8.getValue());
        assertEquals(five8.getValue(), instance5.findMin().getValue());
        
        System.out.println("---------- after--------\n"+instance5);
        
    }

    /**
     * Test of merge method, of class Dkeko.
     */
    @Test
    public void testMerge() {
        System.out.println("merge");
        
        Dkeko instance2 = new Dkeko(2);
        Solmu solmu=null;
        Dkeko instance5 = new Dkeko(5);
        for(int i=11;i>=2;i--){
            solmu = new Solmu(i);
            instance5.insert(solmu);
        }
        for(int i=1;i>=0;i--){
            solmu = new Solmu(i);
            instance2.insert(solmu);
        }
        System.out.println("keko t2"+instance5);
        System.out.println("------------------------------");
        System.out.println("keko t1"+instance2);
        System.out.println("------------------------------");
        
        Dkeko uusi = Dkeko.merge(instance2,instance5);
        
        if (uusi != null){
            System.out.println("uusi yhdistetty keko "+uusi);
        }
       // assertEquals(null, uusi);
       // assertEquals(0, uusi.findMin());
       // assertEquals(5, uusi.HeapSize());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
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
     suite.addTest(new DkekoTest("haarautumisaste2YksiSolmuInsert"));
     suite.addTest(new DkekoTest("haarautumisaste5YksiSolmuInsert"));
     suite.addTest(new DkekoTest("haarautumisaste2ViisiSolmuaInsert"));
     suite.addTest(new DkekoTest("haarautumisaste2RandomSolmuaInsert"));
     suite.addTest(new DkekoTest("haarautumisaste20RandomSolmuaInsert"));
     suite.addTest(new DkekoTest("testDeleteMin"));
     suite.addTest(new DkekoTest("testDecreaseKey"));
     suite.addTest(new DkekoTest("testMerge"));
        
    return suite;
 }
    
}
