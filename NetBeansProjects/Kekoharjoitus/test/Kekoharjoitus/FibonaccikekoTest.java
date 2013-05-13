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
public class FibonaccikekoTest {
    
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of makeHeap method, of class Fibonaccikeko.
     */
    @Test
    public void testMakeHeap() {
        System.out.println("makeHeap");
        Fibonaccikeko instance = new Fibonaccikeko();
        instance.makeHeap();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findMin method, of class Fibonaccikeko.
     */
    @Test
    public void testFindMin() {
        System.out.println("findMin");
        Fibonaccikeko instance = new Fibonaccikeko();
        int expResult = 0;
        int result = instance.findMin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class Fibonaccikeko.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Fibonaccikeko instance = new Fibonaccikeko();
        instance.insert();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteMin method, of class Fibonaccikeko.
     */
    @Test
    public void testDeleteMin() {
        System.out.println("deleteMin");
        Fibonaccikeko instance = new Fibonaccikeko();
        int expResult = 0;
        int result = instance.deleteMin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decreaseKey method, of class Fibonaccikeko.
     */
    @Test
    public void testDecreaseKey() {
        System.out.println("decreaseKey");
        Fibonaccikeko instance = new Fibonaccikeko();
        instance.decreaseKey();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of merge method, of class Fibonaccikeko.
     */
    @Test
    public void testMerge() {
        System.out.println("merge");
        Fibonaccikeko instance = new Fibonaccikeko();
        instance.merge();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
