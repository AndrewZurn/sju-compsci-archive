
/**
 * Will find the sum, the sum of the numbers squared and cubed, in an Array.
 * @author Zurn, Andrew
 * @version Jan 23, 2011
 */
public class SimpleLoops{
  //Array of ints to hold the values 1 through 100
  private int[] intArray = new int[101];
  //int class to hold the sum total
  private int sumTotal = 0;
  //int class to hold the sum of the numbers squared
  private int sumSquared = 0;
  //int class to hold the sum of the numbers cubed
  private int sumCubed = 0;
  
  /** 
   * Will find the sum, the sum of the numbers squared and cubed, in an Array
   */
  public SimpleLoops(){
  
    for(int i = 0; i<=100; i++){
      intArray[i] = i;
      sumTotal = sumTotal + i;
      sumSquared = sumSquared + (i*i);
      sumCubed = sumCubed + (i*i*i);
    }
  
    System.out.println("The sum of the numbers in the collection is: " +sumTotal);
    System.out.println("The sum of the numbers squared in the collection is: " +sumSquared);
    System.out.println("the sum of the numbers cubed in the collection is: " +sumCubed);
  }

  /**
   * Allows the to run the program from the command line
   * @param args string to be used in the command line
   */
  public static void main(String[] args){
    new SimpleLoops();
  }
}
    