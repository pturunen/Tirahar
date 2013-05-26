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
public class SolmuTest {
    
    int value;
    int value1;
    int value2;
    Solmu solmu;
    Solmu solmu1;
    Solmu solmu2;
    public SolmuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solmu = new Solmu();
        solmu1 = new Solmu(-1);
        solmu2 = new Solmu(7);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Testaa Solmu luokan konstruktori
     * odotettu tulos:palauttaa olion ja jäsenmuuttuja
     * on asetettu oletusarvoon
     */
    @Test
    public void testaaKonstruktoriTest() {
        assertTrue(solmu !=null);
        assertEquals(solmu.getValue(), Integer.MAX_VALUE); 
    }
    
    /**
     * Testaa getValue funktio
     * odotettu tulos : palauttaa kokonaisluvun
     */
    @Test
    public void palautaAsetettuArvoGetValueTest() {
        assertEquals(Integer.MAX_VALUE, solmu.getValue());
        solmu.setValue(3);
        assertEquals(3, solmu.getValue());
    }

    /**
     * Testaa setValue funktio
     * odotettu tulos: jäsenmuuttuja asetetaan annettuun arvoon
     */
    @Test
    public void asetaArvoSetValueTest() {
        assertEquals(Integer.MAX_VALUE, solmu.getValue());
        solmu.setValue(Integer.MAX_VALUE-1);
        assertEquals(Integer.MAX_VALUE-1, solmu.getValue());
    }
}
