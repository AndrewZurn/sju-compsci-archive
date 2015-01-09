import java.util.*;
import java.io.*;

public class EchoInteger3 {
  Scanner sc;
  
  public EchoInteger3()  {
    sc = new Scanner(System.in);
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

  }
  
  public static void main(String [] args)  {
    
    EchoInteger3 app = new EchoInteger3();
    app.repeat();
    
  }
}
    
    
    