import objectdraw.*;
import java.awt.*;
/**
 *  A simple test program for CS 161.
 * 
 */
public class MyTest  {

  public void printout(){
    int x = 3;
    int y = -1;
    int z = 2;
    boolean valid = false;
    
    System.out.println("Hello");
    
    System.out.println (  x*y > -z);
    System.out.println((3 * x + 4 * y > z) &&  x * y > -z );
    System.out.println( !(x + y > 4) || (x - y < z)); //|| (x ? y < z));
    System.out.println( !valid || x > y);
  }

  public static void main(String[] args) {
    MyTest mytest = new MyTest();
    mytest.printout();
  }}
