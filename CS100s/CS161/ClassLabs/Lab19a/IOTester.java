import java.io.*;
import java.util.*;
import javax.swing.*;

public class IOTester {
  
  Scanner sc;
  PrintWriter pw;
  
  public IOTester() {
  }
  
  public void everyOther() {
    String word;
    boolean even = false;
    try {
      JFileChooser fc=new JFileChooser(new File("/net/people/faculty/cs/jschnepf/CS161/test"));
      int returnVal=fc.showOpenDialog(null);
      if(returnVal==JFileChooser.APPROVE_OPTION) {
        sc=new Scanner(fc.getSelectedFile()); 
      }
      fc=new JFileChooser(new File("/net/people/faculty/cs/jschnepf/CS161/test"));
      returnVal=fc.showOpenDialog(null);
      if(returnVal==JFileChooser.APPROVE_OPTION) {
        pw = new PrintWriter(fc.getSelectedFile());
      }
      while (sc.hasNext()){
        
        word = sc.next();
        if(even){
          pw.println(word);
        }
        even = !even;
      }
      pw.close();
    }
    catch(Exception e) {
        System.out.println("Error in input");
    }
    System.out.println("Goodbye");
  }
  
  public static void main(String[] args) {
    IOTester mytest = new IOTester();
    mytest.everyOther();
  }
}