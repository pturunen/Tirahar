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
        assertEquals(12,instanssi.getJuuriListaMin().getValue().getValue());
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
        assertEquals(0, instanssi.decreaseKey(solmu, 2)); 
    }

    /**
     * Testaa merge() 
     *
     * keko 1
     * 12---->7---->15
     *       25   28 ->33
     *            41
     * keko 2
     * 18----->3---------------------------->6
     *         37               8---->29------->10--->44
     *                   30-->23-->22  48->31   17
     *                 45->32 24       50
     *                 55
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
        Binomikeko uusi = Binomikeko.merge(instanssi, instanssi2);
        assertEquals(3,uusi.findMin().getValue());
        
    }
    
    void alustaKeot(Binomikeko instanssi,int[] taulukko){
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
