import java.util.*;
import java.io.*;

public class EchoInteger7 {
  Scanner sc;
  ArrayList<Integer> myList = new ArrayList<Integer>();
  
  public EchoInteger7() throws FileNotFoundException {
    sc = new Scanner(new File("data"));
  }
  
  public void repeat() {
    int number = 0;
    while(number != -1) {
      //System.out.println("Enter an integer");
      try {
      number = sc.nextInt();
      myList.add(number);
      System.out.println(number);
      }
      catch(InputMismatchException e) {
        sc.nextLine();
        System.out.println ("Not a number, try again");
      }
    }
    sc.close();
    for (int i = myList.size()-1; i >= 0; i--) {
            System.out.println(myList.get(i));
    }
  }
  
  public static void main(String [] args) throws FileNotFoundException {
    
    EchoInteger7 app = new EchoInteger7();
    app.repeat();
    
  }
}
    
    
    