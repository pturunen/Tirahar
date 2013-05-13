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
public class BinomikekoTest {
    
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of makeHeap method, of class Binomikeko.
     */
    @Test
    public void testMakeHeap() {
        System.out.println("makeHeap");
        Binomikeko instance = new Binomikeko();
        instance.makeHeap();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findMin method, of class Binomikeko.
     */
    @Test
    public void testFindMin() {
        System.out.println("findMin");
        Binomikeko instance = new Binomikeko();
        int expResult = 0;
        int result = instance.findMin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class Binomikeko.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Binomikeko instance = new Binomikeko();
        instance.insert();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteMin method, of class Binomikeko.
     */
    @Test
    public void testDeleteMin() {
        System.out.println("deleteMin");
        Binomikeko instance = new Binomikeko();
        int expResult = 0;
        int result = instance.deleteMin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decreaseKey method, of class Binomikeko.
     */
    @Test
    public void testDecreaseKey() {
        System.out.println("decreaseKey");
        Binomikeko instance = new Binomikeko();
        instance.decreaseKey();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of merge method, of class Binomikeko.
     */
    @Test
    public void testMerge() {
        System.out.println("merge");
        Binomikeko instance = new Binomikeko();
        instance.merge();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
