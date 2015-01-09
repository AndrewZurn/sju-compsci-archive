import java.util.*;
import java.io.*;
import javax.swing.*;

/**
 * A class to try out reading and writing from files
 */
public class PrintTester2 {
  
  Scanner sc,sc2;
  PrintWriter pw;
  
  public PrintTester2() {
    try {
        sc=new Scanner(new File("data"));    
        sc2 = new Scanner(System.in);
    }
    catch(Exception e) {
      System.out.println("Error in scanner");
    }
    try {
     System.out.print("enter Filename: ");
     pw = new PrintWriter("../test4/" + sc2.nextLine());
    }
    catch (FileNotFoundException e){
      System.out.println("Error " + e.getMessage());   
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

  public static void main(String [] args) {
    new PrintTester2();
  }
}

        
      