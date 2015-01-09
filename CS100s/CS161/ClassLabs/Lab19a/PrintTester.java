import java.util.*;
import java.io.*;
import javax.swing.*;

/**
 * A class to try out reading and writing from files
 */
public class PrintTester {
  
  Scanner sc;
  PrintWriter pw;
  
  public PrintTester() {
    try {
      JFileChooser fc=new JFileChooser(new File("/net/people/faculty/cs/jschnepf/CS161/"));
      int returnVal=fc.showOpenDialog(null);
      if(returnVal==JFileChooser.APPROVE_OPTION) {
        sc=new Scanner(new File("data"));    
      }
    }
    catch(Exception e) {
      System.out.println("Error " + e.getMessage());
    }
    try {
      JFileChooser fc1=new JFileChooser(new File("/net/people/faculty/cs/jschnepf/CS161/test"));
      int returnVal=fc1.showOpenDialog(null);
      if(returnVal==JFileChooser.APPROVE_OPTION) {
        pw=new PrintWriter(fc1.getSelectedFile());    
      }
      
      String value;
      boolean even = false;
      while (sc.hasNext()) {
        value = sc.next();
        System.out.println(value);
        if(even){
          pw.println(value);
        }
        even = !even;
      }
      pw.close();
      sc.close();
    }
    catch (Exception e) {
      System.out.println("Error in file I/O");     
    }
  }
  public static void main(String [] args) {
    new PrintTester();
  }
}

        
      