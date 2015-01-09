import java.util.*;
import java.io.*;

public class EchoInteger5 {
  Scanner sc;
  
  public EchoInteger5()  {
   //sc = new Scanner(new File("data"));
    
    
    try {
      sc = new Scanner(new File("data6"));
      
    }
    catch (Exception e){
      System.out.println("Error in scanner");
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
    
    EchoInteger5 app = new EchoInteger5();
    app.repeat();
    
  }
}
    
    
    
