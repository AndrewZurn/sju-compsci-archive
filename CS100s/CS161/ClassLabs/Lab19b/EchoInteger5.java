import java.util.*;
import java.io.*;

public class EchoInteger5 {
  Scanner sc;
  ArrayList<Integer> numbers = new ArrayList<Integer>();
  public EchoInteger5() throws FileNotFoundException {
    sc = new Scanner(new File("data"));
  }
  
  public void read() {
    int number = 0;
    while(sc.hasNextInt()) {
      try {
        number = sc.nextInt();
        numbers.add(number);
      }
      catch(InputMismatchException e) {
        sc.nextLine();
        System.out.println ("Not a number, try again");
      }
    }
    sc.close();
  }
  
  public void display() {
    for(int num : numbers){
      System.out.println(num);
    }
  }
  public static void main(String [] args){
    
    try {
      EchoInteger5 app = new EchoInteger5();
      app.read();
      app.display();
    }
    catch(FileNotFoundException e){
      System.out.println("Something goofy happened!!!");
    }
    System.out.println("We're done");
    
  }
}
