import java.util.*;

public class EchoInteger2 {
  Scanner sc;
  
  public EchoInteger2() {
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
        System.out.println ("Not a number, try again");
      }
    }

  }
  
  public static void main(String [] args) {
    
    EchoInteger2 app = new EchoInteger2();
    app.repeat();
    
  }
}
    
    
    