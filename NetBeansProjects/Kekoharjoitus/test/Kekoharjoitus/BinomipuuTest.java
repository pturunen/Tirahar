/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kekoharjoitus;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Binomipuu luokan yksikkötestiluokka
 * @author pturunen
 */
public class BinomipuuTest {
    
    Binomipuu binomipuu;
    Binomipuu binomipuu2;
    int degree;
    int degree1;
    int degree2;
    Solmu solmu;
    Solmu solmu1;
    Solmu solmu2;
    int value;
    
    public BinomipuuTest() {
    }
    
    @BeforeClass
    public static  void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        binomipuu = new Binomipuu();
        solmu = new Solmu(2);
        binomipuu2 = new Binomipuu(solmu);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test Binomipuu konstruktori
     * odotettu tulos:palauttaa Binomipuu olion ja jäsenmuuttujat
     * on alustettu oletetusti.
     */
    @Test
    public void testaaKonstruktoriBinomipuuTest() {
        assertTrue(null!=binomipuu);
        assertNull(binomipuu.getValue());
        assertNull(binomipuu.getParent());
        assertNull(binomipuu.getSibling());
        assertNull(binomipuu.getChild());
        assertEquals(0,binomipuu.getDegree());
        
        
        assertTrue(null!=binomipuu2);
        assertNotNull(binomipuu2.getValue());
        assertNull(binomipuu2.getParent());
        assertNull(binomipuu2.getSibling());
        assertNull(binomipuu2.getChild());
        assertEquals(0,binomipuu2.getDegree());
    }

    /**
     * Testaa setParent funktio 
     * odotettu tulos: palautetaan null, jos vanhempaa ei ole asetettu
     * ja palauttaa Binomipuu olion joka ei ole null,
     * kun vanhempi Binomipuu olio on asetettu
     */
    @Test
    public void testaaSetParentTest() {
        assertNull(binomipuu.getParent());
        binomipuu.setParent(binomipuu2);
        assertNotNull(binomipuu.getParent());
    }
    
    /**
     * Testaa getParent funktio 
     * odotettu tulos: palautetaan null, jos vanhempaa ei ole asetettu
     * ja palauttaa Binomipuu olion joka ei ole null,
     * kun vanhempi Binomipuu olio on asetettu
     */
    @Test
    public void testaaGetParentTest() {
        assertNull(binomipuu.getParent());
        binomipuu.setParent(binomipuu2);
        assertNotNull(binomipuu.getParent());
    }

    /**
     * Testaa setSibling funktio 
     * odotettu tulos: palautetaan null, jos sisarusta ei ole asetettu
     * ja palauttaa Binomipuu olion joka ei ole null,
     * kun sisarus Binomipuu olio on asetettu
     */
    @Test
    public void testaaSetSiblingTest() {
        assertNull(binomipuu.getSibling());
        binomipuu.setSibling(binomipuu2);
        assertNotNull(binomipuu.getSibling());
    }
    
    /**
     * Testaa getSibling funktio 
     * odotettu tulos: palautetaan null, jos sisarusta ei ole asetettu
     * ja palauttaa Binomipuu olion joka ei ole null,
     * kun sisarus Binomipuu olio on asetettu
     */
    @Test
    public void testaaGetSiblingTest() {
        assertNull(binomipuu.getSibling());
        binomipuu.setSibling(binomipuu2);
        assertNotNull(binomipuu.getSibling());
    }
    
    /**
     * Testaa setChild funktio 
     * odotettu tulos: palautetaan null jos lasta ei ole asetettu
     * ja palauttaa Binomipuu olion joka ei ole null,
     * kun lapsi Binomipuu olio on asetettu
     */
    @Test
    public void testaaSetChildTest() {
        assertNull(binomipuu.getChild());
        binomipuu.setChild(binomipuu2);
        assertNotNull(binomipuu.getChild());
    }
    
    /**
     * Testaa getChild funktio 
     * odotettu tulos: palautetaan null jos lasta ei ole asetettu
     * ja palauttaa Binomipuu olion joka ei ole null,
     * kun lapsi Binomipuu olio on asetettu
     */
    @Test
    public void testaaGetChildTest() {
        assertNull(binomipuu.getChild());
        binomipuu.setChild(binomipuu2);
        assertNotNull(binomipuu.getChild());
    }
   
    /**
     * Testaa setDegree funktio, aseta validi arvo
     * odotettu tulos: jäsenmuuttuja degree saa asetetun arvon
     * ja funktio palauttaa 0
     */
    @Test
    public void asetaPositiivinenArvoSetDegreeTest() {
        assertEquals(0,binomipuu.getDegree());
        binomipuu.setDegree(9);
        assertEquals(9,binomipuu.getDegree());
    }
    
    /**
     * Testaa setDegree funktio, aseta negatiivinen arvo
     * odotettu tulos: jäsenmuuttuja degree arvoa ei muuteta
     */
    @Test
    public void asetaNegatiivinenArvoSetDegreeTest() {
        assertEquals(0,binomipuu.getDegree());
        binomipuu.setDegree(9);
        assertEquals(9,binomipuu.getDegree());
        binomipuu.setDegree(-8);
        assertEquals(9,binomipuu.getDegree());
    }
    
    /**
     * Testaa getDegree funktio, aseta validi arvo
     * odotettu tulos: jäsenmuuttuja degree saa asetetun arvon
     */
    @Test
    public void asetaValidiArvoGetDegreeTest() {
        assertEquals(0,binomipuu.getDegree());
        binomipuu.setDegree(100);
        assertEquals(100,binomipuu.getDegree());
    }
    
     /**
     * Testaa getDegree funktio, aseta negatiivinen arvo
     * odotettu tulos: jäsenmuuttuja degree arvoa ei muuteta
     */
    @Test
    public void palautaMuuttumatonArvoGetKeyTest() {
        assertEquals(0,binomipuu.getDegree());
        binomipuu.setDegree(90);
        assertEquals(90,binomipuu.getDegree());
        binomipuu.setDegree(-8);
        assertEquals(90,binomipuu.getDegree());
    }
    
}
