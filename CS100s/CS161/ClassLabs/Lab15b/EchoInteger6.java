import java.util.*;
import java.io.*;
import javax.swing.*;

public class EchoInteger6 {
  Scanner sc;
  
  public EchoInteger6() throws FileNotFoundException {
    try {
      JFileChooser fc=new JFileChooser(new File("/net/people/faculty/cs/schnepf/CS161/"));
      int returnVal=fc.showOpenDialog(null);
      if(returnVal==JFileChooser.APPROVE_OPTION) {
        sc=new Scanner(fc.getSelectedFile());  
        
      }
    }
    catch(Exception e) {
      System.out.println("error in file chooser");
    }
  }
  
  public void repeat() {
    int number = 0;
    while(number != -1) {
      System.out.println("Enter an integer");
      try {
      number = sc.nextInt();
      System.out.println(number);
      }
      catch(InputMismatchException e) {
        sc.nextLine();
        System.out.println ("Not a number, try again");
      }
    }
    sc.close();
  }
  
  public static void main(String [] args) throws FileNotFoundException {
    
    EchoInteger6 app = new EchoInteger6();
    app.repeat();
    
  }
}
    
    
    