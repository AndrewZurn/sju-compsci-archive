import java.util.*;

public class EchoInteger {
  Scanner sc;
  
  public EchoInteger() {
    sc = new Scanner(System.in);
  }
  
  public void repeat() {
    int number = 0;
    while (number != -1){
      System.out.println("Enter an integer");
      number = sc.nextInt();
      System.out.println(number);
    }
  }
  
  public static void main(String [] args) {
    
    EchoInteger app = new EchoInteger();
    app.repeat();
    
  }
}


