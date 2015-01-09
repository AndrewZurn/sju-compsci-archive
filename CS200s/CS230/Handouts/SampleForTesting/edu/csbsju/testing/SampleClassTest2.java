/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.csbsju.testing;

import junit.framework.TestCase;

/**
 *
 * @author irahal
 */
public class SampleClassTest2 extends TestCase {
    
    private SampleClass sample1, sample2;
    
    @Override
    protected void setUp() throws Exception {
        sample1 = new SampleClass(5);
        sample2 = new SampleClass(4);
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getClassSize method, of class SampleClass.
     */
    public void testGetClassSize() {
        System.out.println("getClassSize");
        int expResult = 5;
        int result = sample1.getClassSize();
        assertEquals("size for sample 1 should be " + expResult,expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        expResult = 4;
        result = sample2.getClassSize();
        assertEquals("size for sample 2 should be " + expResult,expResult, result);
    }

    /**
     * Test of setClassSize method, of class SampleClass.
     */
    public void testSetClassSize() {
        System.out.println("setClassSize");
        int expResult = 10;
        sample1.setClassSize(expResult);
        int result = sample1.getClassSize();
        assertEquals("size for sample 1 should now be " + expResult, expResult, result);

    }

    /**
     * Test of getClassScores method, of class SampleClass.
     */
    public void testGetClassScores() {

    }

    /**
     * Test of setClassScores method, of class SampleClass.
     */
    public void testSetClassScores() {

    }

    /**
     * Test of getAverage method, of class SampleClass.
     */
    public void testGetAverage() {
        System.out.println("getAverage");
        double expResult = 80.0;
        double[] scores1 = {80, 90, 100, 70, 60};
        sample1.setClassScores(scores1);
        double result = sample1.getAverage();
        assertEquals("average for sample 1 should be " +  expResult, expResult, result);
        
        expResult = 75.0;
        double[] scores2 = {80, 90, 70, 60};
        sample2.setClassScores(scores2);
        result = sample2.getAverage();
        assertEquals("average for sample 2 should be " +  expResult, expResult, result);       
    }

    /**
     * Test of getMedian method, of class SampleClass.
     */
    public void testGetMedian() {
        System.out.println("getMedian");
        double expResult = 80.0;
        double[] scores1 = {80, 90, 100, 70, 60};
        sample1.setClassScores(scores1);
        double result = sample1.getMedian();
        assertEquals("median for sample 1 should be " +  expResult, expResult, result);
        
        
        expResult = 75.0;
        double[] scores2 = {80, 90, 70, 60};
        sample2.setClassScores(scores2);
        result = sample2.getMedian();
        assertEquals("median for sample 2 should be " +  expResult, expResult, result);
    }
}
