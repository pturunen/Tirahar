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
public class DkekoTest {
    
    public DkekoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of makeHeap method, of class Dkeko.
     */
    @Test
    public void testMakeHeap() {
        System.out.println("makeHeap");
        Dkeko instance = new Dkeko(2);
        instance.makeHeap();
        Solmu expResult = null;
        Solmu result = instance.findMin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of findMin method, of class Dkeko.
     */
    @Test
    public void testFindMin() {
        System.out.println("findMin");
        Dkeko instance = new Dkeko(2);
        Solmu expResult = null;
        Solmu result = instance.findMin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class Dkeko.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Dkeko instance = new Dkeko(2);
        Solmu uusi = new Solmu();
        instance.insert(uusi);
        assertEquals(0, instance.findMin().getKey());
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decreaseKey method, of class Dkeko.
     */
    @Test
    public void testDecreaseKey() {
        System.out.println("decreaseKey");
        Dkeko instance = new Dkeko(2);
        Solmu uusi = new Solmu();
        instance.decreaseKey(uusi,4);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of merge method, of class Dkeko.
     */
    @Test
    public void testMerge() {
        System.out.println("merge");
        Dkeko instance = new Dkeko(2);
        instance.merge();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
