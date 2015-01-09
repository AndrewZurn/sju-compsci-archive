/*
 * File: PostfixTest.java
 */

import postfix.*;

import junit.framework.*;
import java.util.*;
import arrayStack.*;
/**
 * A JUnit test case class for the DoubleTank class.
 * 
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class PostfixTest extends TestCase {
  //We need just one pf to test lots of stuff.
  private Postfix pf1;
  private TreeMap<Character,Double> values=new TreeMap<Character,Double>();
  
  public void setUp() {
    //This loop puts the values 0.0 to 25.0 in a->z
    for(char c='a';c<'z';c++) {
      values.put(c,1.0*(c-'a'));
    }
    pf1 = new Postfix(values);
  }
  
  /**
   * This method tests whether Postfix evaluate works.
    */
  public void testEvaluate() {
    /*
     * The following works but it is, in fact, a bad test. When
     * comparing doubles you should generally not use equality
     * since roundoff occurs in computation involving doubles.
     * Instead, you should use approximate comparisons.
     */
    assertEquals("1*2*3*4==24",pf1.evaluate("bcde***"),24.0);
    /* Here is a better test. Note we assume variables are accurate
     * to within epsilon times the result. However, if the expected
     * result is 0 we just assume within epsilon. Note that my 
     * value of epsilon is actually pretty high. Double values are
     * generally good to about 14 decimal places so even after
     * several operations we should expect something better than
     * the 7 decimal places of epsilon.
     */
    double epsilon=0.0000001;
    double result=pf1.evaluate("bcde***");
    double expectedValue=24.0;
    if(expectedValue==0.0) {
      assertTrue("Value is within epsilon",Math.abs(result-24.0)<epsilon);
    }
    else {
      assertTrue("Value is within a multiple of epsilon.",
                 Math.abs(result-expectedValue)<expectedValue*result);
    }
    /* do as tests the three quiz problems from class:
     *     5 6 7 8 + - *              which had answer -45.0
     *     5 6 7 + - 3 2 * /           which had answer -4.0/3.0
     *     3 4 2 ^ * 5 6 7 + - /      which had answer -6.0
     * Don't forget that you must use the variable with the
     * correct value. For example, 'd' corresponds to 3.0.
     * Use the epsilon test described above for each one.
     */
    assertEquals("It should equal to -45.0", pf1.evaluate("fghi+-*"), -45.0);
    assertEquals("It should equal to -4.0/3.0", pf1.evaluate("fgh+-dc*/"), -4.0/3.0);
    assertEquals("It should equal to -6.0", pf1.evaluate("dec^*fgh+-/"), -6.0);
  }
  
  /**
   * This method tests whether division by zero throws an exception.
    */
  public void testDivideByZero() {
    try {
      /*
       * Put in a statement of the form
       *      double result=pf1.evaluate(expression);
       * where expression will be a String representing an expression
       * that will require division by 0.0
       */
      pf1.evaluate("ca/");
      fail("Division by zero worked!");
    }
    catch(Exception e) { //Note we print out the exception this time
                         //You can see the exception in the Interactions tab
      System.out.println(e);
    }
  }
  
  /**
   * This method tests whether bad expressions throw exceptions.
    */
  public void testBadExpressions() {
    try {
      pf1.evaluate("cb%");
      fail("Something is wrong with the expression");
    }
    catch(Exception e) { //Note we print out the exception this time
                         //You can see the exception in the Interactions tab
      System.out.println(e);
    }
    try {
      pf1.evaluate("ch+-");
      fail("Something is wrong with the expression");
    }
    catch(Exception e) { //Note we print out the exception this time
                         //You can see the exception in the Interactions tab
      System.out.println(e);
    }
    try {
      pf1.evaluate("chhs+-");
      fail("Something is wrong with the expression");
    }
    catch(Exception e) { //Note we print out the exception this time
                         //You can see the exception in the Interactions tab
      System.out.println(e);
    }
  }
}
