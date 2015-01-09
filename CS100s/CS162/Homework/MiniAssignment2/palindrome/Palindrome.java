/*
 * File: Palindrome.java
 */

import java.util.*;

/**
 * A class to determine if a word is a palindrome
 * @author Zurn, Andrew
 * @version 2/1/11
 */
public class Palindrome{
  /**
   * used to reverse the word 
   */
  private Stack<Character> stack;
  
  /**
   * used to access the input word
   */
  private String input;
  
  /**
   * Used to construct a palindrome of a string
   * @param in word to be reveresed
   */
  public Palindrome(String in){
    input=in;
  }
  
  /**
   * Used to verify if a word is a palindrome
   * @param in word to be reveresed
   * @return boolean will return true if it is a palindrome, false otherwise
   */
  public boolean palindrome(String in){
    stack = new Stack<Character>();
    for(int i = 0; i < in.length(); i++){
      stack.push(in.charAt(i));
    }
    String temp ="";
    while(!stack.isEmpty()){
      temp=temp+stack.pop();
    }
    return(in.equalsIgnoreCase(temp));
  }
  
  /**
   * a main method to run the program from the command line
   * @param args[] word to be used as the param of the palindrome constructor
   */
  public static void main(String args[]){
    Palindrome pd = new Palindrome(args[0]);
    System.out.println(pd.palindrome(args[0]));
  }
}
