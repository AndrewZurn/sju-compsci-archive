import java.util.*;
import java.io.*;

/**
 * A class to try out reading and writing from files
 */
public class PrintTester4 {
  
  Scanner sc,sc2;
  PrintWriter pw;
  
  public PrintTester4(String inFileName, String outFileName) {
    try {
        sc=new Scanner(new File(inFileName));    
    }
    catch(Exception e) {
      System.out.println("Error in scanner");
    }
    try {
     pw = new PrintWriter("../test/" + outFileName);
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
    new PrintTester4(args[0],args[1]);
  }
}

        
      