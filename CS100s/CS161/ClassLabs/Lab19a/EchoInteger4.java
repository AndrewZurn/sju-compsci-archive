import java.util.*;
import java.io.*;

public class EchoInteger4{
  Scanner sc;
  
  public EchoInteger4()  {
    sc = new Scanner(new File("data2"));
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
  
  public static void main(String [] args)  {
    
    EchoInteger4 app = new EchoInteger4();
    app.repeat();
    
  }
}
    
    
    