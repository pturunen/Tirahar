/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kekoharjoitus;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 
 * @author pturunen
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({FibonaccikekoTest.class, DkekoTest.class, KekoharjoitusTest.class, BinomikekoTest.class})
public class KekoharjoitusSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
