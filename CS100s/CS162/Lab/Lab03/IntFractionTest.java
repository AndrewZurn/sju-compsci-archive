/*
 * File: IntFtactionTest.java
 * 
 */


import fraction.*;

import junit.framework.*;

/**
 * This class will test IntFraction
 * 
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 * 
 * @author Zurn,Andrew and Xu,Runbo
 */
public class IntFractionTest extends TestCase {
 private IntFraction num1, num2, num3, num4;
 
 /**
  * Create 4 new IntFractions
  */
 public void setUp() {
   num1=new IntFraction();
   num2=new IntFraction(4);
   num3=new IntFraction(2,4);
   num4=new IntFraction(-9,-2);
  }
 
 /**
  * This method tests add method in IntFractions
  */
 public void testAdd(){
   num2=num2.addToThis(num3);
   assertEquals("The result should be 9/2", num2, new IntFraction(9, 2));
 }
 
 /**
  * This method tests add method in IntFractions
  */
 public void testsubtract(){
   num2=num2.subtractFromThis(num3);
   assertEquals("The result should be 7/2", num2, new IntFraction(7, 2));
 }
 
 /**
  * This method tests add method in IntFractions
  */
 public void testmulti(){
   num2=num2.multiplyThisBy(num3);
   assertEquals("The result should be 2", num2, new IntFraction(4,2));
 }
 
 /**
  * This method tests the implementation of a negative IntFraction
  */
 public void testNegative(){
   assertEquals("It should be (-9, 2)", num4, new IntFraction(9,2));
 }
 
 /**
  * This method tests divide method in IntFractions
  */
 public void testdivide(){
   num2=num2.divideThisBy(num3);
   assertEquals("The result should be 8", num2, new IntFraction(8));
 }
 
 /**
  * This method tests euqal method in IntFractions
  */
 public void testEquals(){
  assertTrue("THis should be true", num3.equals(new IntFraction(1,2)));
 }
 
 /**
  * This method tests exceptions in IntFractions
  */
 public void testException(){
   try{
      new IntFraction(9,0);
      fail("Denominator should not be 0!");
    }
    catch(ArithmeticException ie){}
    try{
      num2.divideThisBy(new IntFraction());
      fail("The fraction can not be divided by zero");
    }
    catch(ArithmeticException ie){}
 }
}