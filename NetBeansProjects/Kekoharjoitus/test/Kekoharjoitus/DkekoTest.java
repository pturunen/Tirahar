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
import static org.junit.Assert.*;

/**
 *
 * @author pturunen
 */
public class DkekoTest extends TestCase{
    
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
        Dkeko instance = null;
        instance =  Dkeko.makeHeap(5);
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
        Solmu uusi = new Solmu(8);
        instance.insert(uusi);
        //System.out.println(" uusi"+uusi.getValue());
        //System.out.println(" min"+instance.findMin().getValue());
        assertEquals(uusi.getValue(), instance.findMin().getValue());
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
        assertEquals(uusi.getValue(), instance.findMin().getValue());
        
        Dkeko instance5 = new Dkeko(5);
        Solmu five1 = new Solmu(7);
        instance5.insert(five1);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five1.getValue(), instance5.findMin().getValue());
        //System.out.println("------------testInsert: after 7");
        
        Solmu five2 = new Solmu(6);
        instance5.insert(five2);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five2.getValue(), instance5.findMin().getValue());
        //System.out.println("------------testInsert: after 6");
        
        Solmu five3 = new Solmu(5);
        instance5.insert(five3);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five3.getValue(), instance5.findMin().getValue());
        //System.out.println("------------testInsert: after 5");
        
        Solmu five4 = new Solmu(4);
        instance5.insert(five4);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five4.getValue(), instance5.findMin().getValue());
        //System.out.println("------------testInsert: after 4");
        
        Solmu five5 = new Solmu(3);
        System.out.println("--------before inserting value3");
        instance5.insert(five5);
        System.out.println("--------after inserting value3");
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five5.getValue(), instance5.findMin().getValue());
       // System.out.println("------------testInsert: after 3 tail.value="+instance5.tail.getValue());
        System.out.println("------------testInsert: after 3 min.value="+instance5.findMin().getValue());
        
        Solmu five6 = new Solmu(2);
        instance5.insert(five6);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five6.getValue(), instance5.findMin().getValue());
       // System.out.println("------------testInsert: after 2 tail.value="+instance5.tail.getValue());
        System.out.println("------------testInsert: after 2 min.value="+instance5.findMin().getValue());
        
        Solmu five7 = new Solmu(1);
        assertEquals(0, instance5.getMin().getKey());
        instance5.insert(five7);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five7.getValue(), instance5.findMin().getValue());
       //System.out.println("------------testInsert: after 1 tail.value="+instance5.tail.getValue());
       System.out.println("------------testInsert: after 1 min.value="+instance5.findMin().getValue());
        
        Solmu five8 = new Solmu(8);
        instance5.insert(five8);
        assertEquals(0, instance5.getMin().getKey());
        assertEquals(five7.getValue(), instance5.findMin().getValue());
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
     suite.addTest(new DkekoTest("testMakeHeap"));
     suite.addTest(new DkekoTest("testFindMin"));
     suite.addTest(new DkekoTest("testInsert"));
     suite.addTest(new DkekoTest("testDeleteMin"));
     suite.addTest(new DkekoTest("testDecreaseKey"));
     suite.addTest(new DkekoTest("testMerge"));
     
    return suite;
 }
    
}
