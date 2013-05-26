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
 *
 * @author pturunen
 */
public class KekoalkioTest {
    
    Kekoalkio keko;
    Kekoalkio keko2;
    int avain;
    int avain1;
    int avain2;
    Solmu solmu;
    Solmu solmu1;
    Solmu solmu2;
    int value;
    int aste;
    
    public KekoalkioTest() {
    }
    
    @BeforeClass
    public static  void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        keko = new Kekoalkio();
        solmu = new Solmu(2);
        keko2 = new Kekoalkio(solmu);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test Kekoalkion konstruktori
     * odotettu tulos:palauttaa keko olion ja jäsenmuuttujat
     * on alustettu oletetusti.
     */
    @Test
    public void testaaKonstruktoriKekoalkioTest() {
        assertTrue(null!=keko);
        assertNull(keko.getValue());
        assertNull(keko.getLeft());
        assertNull(keko.getRight());
        assertEquals(-1,keko.getKey());
        
        
        assertTrue(null!=keko2);
        assertNotNull(keko2.getValue());
        assertNull(keko.getLeft());
        assertNull(keko.getRight());
        assertEquals(-1,keko.getKey());
    }

    /**
     * Testaa setRight funktio 
     * odotettu tulos: palautetaan null, jos oikeaa linkkiä ei ole asetettu
     * ja palauttaa Kekoalkio olion joka ei ole null,
     * kun oikea linkki on asetettu
     */
    @Test
    public void testaaSetRightTest() {
        assertNull(keko.getRight());
        keko.setRight(keko2);
        assertNotNull(keko.getRight());
    }
    
    /**
     * Testaa getRight funktio 
     * odotettu tulos: palautetaan null, jos oikeaa linkkiä ei ole asetettu
     * ja palauttaa Kekoalkio olion joka ei ole null,
     * kun oikea linkki on asetettu
     */
    @Test
    public void testaaGetRightTest() {
        assertNull(keko.getRight());
        keko.setRight(keko2);
        assertNotNull(keko.getRight());
    }

    /**
     * Testaa setLeft funktio 
     * odotettu tulos: palautetaan null jos vasenta ei ole asetettu
     * ja palauttaa Kekoalkio olion joka ei ole null,
     * kun vasen linkki on asetettu
     */
    @Test
    public void testaaSetLeftTest() {
        assertNull(keko.getLeft());
        keko.setLeft(keko2);
        assertNotNull(keko.getLeft());
    }
    
    /**
     * Testaa getLeft funktio 
     * odotettu tulos: palautetaan null jos vasenta ei ole asetettu
     * ja palauttaa Kekoalkio olion joka ei ole null,
     * kun vasen linkki on asetettu
     */
    @Test
    public void testaaGetLeftTest() {
        assertNull(keko.getLeft());
        keko.setLeft(keko2);
        assertNotNull(keko.getLeft());
    }
   

    /**
     * Testaa setKey funktio, aseta validi arvo
     * odotettu tulos: jäsenmuuttuja key saa asetetun arvon
     * ja funktio palauttaa 0
     */
    @Test
    public void asetaPositiivinenArvoSetKeyTest() {
        assertEquals(-1,keko.getKey());
        assertEquals(0,keko.setKey(9));
        assertEquals(9,keko.getKey());
    }
    
    /**
     * Testaa setKey funktio, aseta negatiivinen arvo
     * odotettu tulos: jäsenmuuttuja key arvoa ei muuteta
     * ja funktio palauttaa -1
     */
    @Test
    public void asetaNegatiivinenArvoSetKeyTest() {
        assertEquals(-1,keko.getKey());
        keko.setKey(9);
        assertEquals(9,keko.getKey());
  
        assertEquals(-1,keko.setKey(-8));
        assertEquals(9,keko.getKey());
    }
    
    /**
     * Testaa getKey funktio, aseta validi arvo
     * odotettu tulos: jäsenmuuttuja key saa asetetun arvon
     * ja funktio palauttaa 0
     */
    @Test
    public void palautaNollaGetKeyTest() {
        assertEquals(-1,keko.getKey());
        assertEquals(0,keko.setKey(9));
        assertEquals(9,keko.getKey());
    }
    
     /**
     * Testaa getKey funktio, aseta negatiivinen arvo
     * odotettu tulos: jäsenmuuttuja key arvoa ei muuteta
     * ja funktio palauttaa -1
     */
    @Test
    public void palautaNegatiivinenGetKeyTest() {
        assertEquals(-1,keko.getKey());
        keko.setKey(9);
        assertEquals(9,keko.getKey());
  
        assertEquals(-1,keko.setKey(-8));
        assertEquals(9,keko.getKey());
    }
    
}
