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
 *
 * @author pturunen
 */
public class BinomikekoTest {
    
    public Binomikeko instanssi =null;
    public Binomikeko instanssi2 = null;
    public Binomikeko instanssiUusi = null;
    public Binomipuu binomipuu = null;
    public Binomipuu binomipuu2 = null;
    public Solmu solmu = null;
    public Solmu solmu2 = null;
    public int arvo =0;
    Random generator = null;
    
    public BinomikekoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       instanssi = new Binomikeko();
       instanssi2 = new Binomikeko();
       binomipuu = new Binomipuu();
       binomipuu2 = new Binomipuu();
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
     * Testi Binomikeko konstruktorille
     */
    @Test
    public void testaaKonstruktoriBinomikekoTest(){
       assertEquals(null, instanssi.findMin());
    }
    
    /**
     * Testi MakeHeap() perustapaus
     * odotettu tulos funktio palauttaa Binomikeko olion
     */
    @Test
    public void aste2OkMakeHeapTest(){
       instanssi =Binomikeko.makeHeap();
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
        assertEquals(solmu.getValue(), instanssi.findMin().getValue());
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
     * asetetaan kaksi Solmu oliota Binomikekoon, siten että ensimmäisen Solmu 
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
        assertEquals(solmu.getValue(), instanssi.findMin().getValue());
        assertEquals(solmu.getValue(), instanssi.deleteMin().getValue());
    }

    /**
     * Testaa DecreaseKey() 
     * odotettu lopputulos,keko palauttaa -1, koska keko on tyhja
     * 
     */
    @Test
    public void tyhjaKekoDecreaseKeyTest() {
        assertNull(instanssi.findMin());
        assertEquals(-1, instanssi.decreaseKey(solmu, 2)); 
    }

    /**
     * Testaa merge() 
     * odotettu tulos: palauttaa uuden keko olion, jonka 
     * pienin alkio on sama kuin t1
     */
    @Test
    public void testaaT1PieninMergeTest() {
        for (int i=12;i>=3;i--){
            
            solmu = new Solmu(i);
            instanssi2.insert(solmu);
        }
        for(int i=2;i>=1;i--){
            solmu = new Solmu(i);
            instanssi.insert(solmu);
        }
        int summa = instanssi.getHeapSize() + instanssi2.getHeapSize();
        instanssiUusi = Binomikeko.merge(instanssi,instanssi2);
        assertEquals(1, instanssiUusi.findMin().getValue());
        assertEquals(summa, instanssiUusi.getHeapSize());
    }
    
     /**
     * Testaa merge() 
     * odotettu tulos: palauttaa uuden keko olion, jonka 
     * pienin alkio on sama kuin t2
     */
    @Test
    public void testaaT2PieninMergeTest() {
        for (int i=12;i>=3;i--){
            
            solmu = new Solmu(i);
            instanssi.insert(solmu);
        }
        for(int i=2;i>=1;i--){
            solmu = new Solmu(i);
            instanssi2.insert(solmu);
        }
        int summa = instanssi.getHeapSize() + instanssi2.getHeapSize();
        instanssiUusi = Binomikeko.merge(instanssi,instanssi2);
        assertEquals(1, instanssiUusi.findMin().getValue());
        assertEquals(summa, instanssiUusi.getHeapSize());
    }
}
