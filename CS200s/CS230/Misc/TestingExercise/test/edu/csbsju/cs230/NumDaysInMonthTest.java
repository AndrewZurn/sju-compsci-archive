/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.csbsju.cs230;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author awzurn
 */
public class NumDaysInMonthTest {
    
    public NumDaysInMonthTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNumDaysInMonth method, of class NumDaysInMonth.
     */
    @Test
    public void testGetNumDaysInMonth() throws Exception {
        System.out.println("getNumDaysInMonth");
        int month = 0;
        int year = 0;
        NumDaysInMonth instance = new NumDaysInMonth();
        // TODO review the generated test code and remove the default call to fail.
        
        month = 1;
        year = 2012;
        int expResult = 0;
        int result = instance.getNumDaysInMonth(month, year);
        assertEquals("Month 1 of 2012 is 31", 31, result);
    }

    /**
     * Test of isLeapYear method, of class NumDaysInMonth.
     */
    @Test
    public void testIsLeapYear() {
        System.out.println("isLeapYear");
        int year = 0;
        NumDaysInMonth instance = new NumDaysInMonth();
        boolean expResult = false;
        boolean result = instance.isLeapYear(year);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
