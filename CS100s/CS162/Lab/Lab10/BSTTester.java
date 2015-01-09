/*
 * File: BSTTester.java
 */

import zhstructures.*;
import java.util.*;
import javax.swing.*;

/**
 * This class implements a program that tests a class implementing the
 * ZHBinarySearchTree interface
 * 
 * @author J. Andrew Holey
 * @version October 27, 2008
 */
public class BSTTester{

  private ZHBinarySearchTree<Integer> tree;
  
  public BSTTester(){
    System.out.println("Welcome to the Binary Search Tree Tester");
    tree = new ZHLinkedBinarySearchTree<Integer>();
  }
  
  public void runTester() {
    char cmd;
    do
    {
      menu ();
      cmd = acceptCommand ();
      doCommand (cmd);
    }
    while ((cmd != 'q') && (cmd != 'Q'));
  }
  
  private void menu() {
    System.out.println();
    System.out.println("\tE is the tree Empty?");
    System.out.println("\tC does the tree Contain a specified element");
    System.out.println("\tA Add an element");
    System.out.println("\tR Remove an element");
    System.out.println("\tT Traverse the tree using its iterator");
    System.out.println("\tQ Quit the program");
    System.out.println();
  }
  
  private char acceptCommand() {
    char cmd;
    String s = JOptionPane.showInputDialog("Enter command: ");;
    cmd = s.charAt(0);
    return cmd;
  }
  
  private void doCommand(char cmd) {
    switch (cmd)
    {
      case 'e': case 'E':
        empty();
        break;
      case 'c': case 'C':
        contains();
        break;
     case 'a': case 'A':
        add();
        break;
      case 'r': case 'R':
        remove();
        break;
      case 't': case 'T':
        traverse();
        break;
      case 'q': case 'Q':
        quit ();
        break;
      default:
        System.out.println("Invalid command--try again");
    }
  }
  
  /** empty
    * 
    * Report whether the tree is empty or not using the isEmpty() method
    */
  private void empty() {
    if (tree.isEmpty()) {
      System.out.println("The tree is empty.");
    }
    else {
      System.out.println("The tree is not empty.");
    }
  }
  
  /** contains
    * 
    * Report whether each tree contains a given element
    */
  private void contains() {
    Integer element;
    try {
      String s = JOptionPane.showInputDialog
                 ("Enter an integer to test for tree membership: ");
      element = new Integer(s);
      if (tree.contains(element)) {
        System.out.println("The tree contains element " + element);
      }
      else {
        System.out.println("The tree does not contain element " + element);
      }
    }
    catch (NumberFormatException nfe) {
      System.out.println("Entry was not in integer format.");
    }
  }
  
  /** traverse
    * 
    * Report the contents of the tree using the iterator
    */
  private void traverse() {
    System.out.print("The tree contains: {");
    for (Integer element : tree) {
      System.out.print(" " + element);
    }
    System.out.println(" }");
  }
  
  /** add
    *
    * Prompt the user for an element to add and add the element to the tree.
    */
  private void add() {
    Integer element;
    try {
      String s = JOptionPane.showInputDialog
                 ("Enter an integer to add to the tree: ");
      element = new Integer(s);
      if (tree.add(element)) {
        System.out.println("Element " + element + " added to the tree");
      }
      else {
        System.out.println("Element " + element + " was already in the tree");
      }
    }
    catch (NumberFormatException nfe) {
      System.out.println("Last input was not valid, nothing added");
    }
  }

  /** remove 
    * 
    * Remove the first element from the tree
    */
  private void remove() {
    Integer element;
    try {
      String s = JOptionPane.showInputDialog
                 ("Enter an integer to remove from the tree: ");
      element = new Integer(s);
      if (tree.remove(element)) {
        System.out.println("Element " + element + " removed from the tree");
      }
      else {
        System.out.println("Element " + element + " was not in the tree");
      }
    }
    catch (NumberFormatException nfe) {
      System.out.println("Last input was not valid, nothing added");
    }
  }

  /** quit
    * 
    * Method to terminate the BSTTester program
    */
  private void quit() {        
    System.out.println("Now exiting the Binary Search Tree Tester\n");
  }
  
  /** Main program--creates and runs BSTTester
    * @param args the command line arguments (not used)
    */
  public static void main (String args[]) {
    BSTTester tester = new BSTTester ();
    tester.runTester();
  }
}
