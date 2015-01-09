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
      if (sc.hasNextInt()) {
        number = sc.nextInt();
        System.out.println(number);
      }
      else {
        sc.nextLine();
      }
    }
  }
  
  public static void main(String [] args) {
    
    EchoInteger2 app = new EchoInteger2();
    app.repeat();
    
  }
}


