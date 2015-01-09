/*
 * File: PalindromeTest.java
 */
import palindrome.*;
import junit.framework.*;

/**
 * Used to test the palindrome class
 * @author Zurn, Andrew
 * @version 2/1/11
 */
public class PalindromeTest extends TestCase{
  /**
   * strings used for testing
   */
  private String string1, string2, string3, string4, string5, string6, string7;
  
  /**
   * palindromes classes used for testing
   */
  private Palindrome pd1, pd2, pd3, pd4, pd5, pd6, pd7;
  
  /**
   * Set up of the test class
   */
  public void setUp(){
    string1="a";
    string2="level";
    string3="I was saw I";
    string4="kAyaK";
    string5="hannah";
    string6="";
    string7="not me";
    pd1= new Palindrome(string1);
    pd2= new Palindrome(string2);
    pd3= new Palindrome(string3);
    pd4= new Palindrome(string4);
    pd5= new Palindrome(string5);
    pd6= new Palindrome(string6);
    pd7= new Palindrome(string7);
  }
  
  /**
   * used to test a one letter character
   */
  public void testOneLetter(){
    assertTrue("This should be true!", pd1.palindrome(string1));
  }
  
  /**
   * used to test a multiple letter word
   */
  public void testMultiChars(){
    assertTrue("This should be true!", pd2.palindrome(string2));
  }
   
  /**
   * used to test multiple words
   */
  public void testMultiWords(){
    assertTrue("This should be true!", pd3.palindrome(string3));
  }
   
  /**
   * used to test a word with different cases of letters
   */
  public void testDiffCases(){
    assertTrue("This should be true!", pd4.palindrome(string4));
  }
   
  /**
   * used to test a word of even length
   */
  public void testEvenLength(){
    assertTrue("This should be true!", pd5.palindrome(string5));
  }
   
  /**
   * used to test a word of odd length
   */
  public void testOddLength(){
    assertTrue("This should be true!", pd6.palindrome(string6));
  }
   
  /**
   * used to test an empty string
   */
  public void testEmptyString(){
    assertFalse("This should be False!", pd7.palindrome(string7));
  }
}
  
    