import java.util.*;
import java.io.*;

/**
 * Class to read and multiply all numbers in a set file, "products".
 * @author Zurn, Andrew
 * @version Jan 23, 2011
 */
public class NumProduct{
  private ArrayList<Integer> numArray = new ArrayList<Integer>();
  private long product=1;
  
  /**
   * Will construct a scanner to read the items in a file, 
   * then multiply and display the resulting product.
   * @param file the file to be read
   */
  public NumProduct(String file)throws FileNotFoundException{
    int num = 0;
    Scanner sc = new Scanner(new FileReader(file));
    while (sc.hasNextInt()){
      num = sc.nextInt();
      numArray.add(num);
    }
    
    for(int i = 0; i<numArray.size(); i++){
      product = product * numArray.get(i);
    }
    sc.close();
    
    
    System.out.println("The product of the numbers in the file is: " +product);
  }
  
  /**
   * Allows the to run the program from the command line
   * @param args string to be used in the command line
   */
  public static void main(String[] args) throws FileNotFoundException{
    new NumProduct("Products");
  }
}
      