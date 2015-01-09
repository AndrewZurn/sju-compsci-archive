import java.util.*;
import java.io.*;

public class SearchTest {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double[] values ;
    double searchValue;
    int[] values2;
    int searchValue2;
    
    //generate random list of doubles
    values = SearchMethods.genDoubleList(20);
    
    //print the values
    SearchMethods.printDoublesList(values);
    
     System.out.println("enter double value");
    searchValue = sc.nextDouble();
    System.out.println("Found in slot: " + 
                       SearchMethods.findDoubleValue(values, searchValue));    
   //generate random list of doubles
    values2 = SearchMethods.genIntList(20);
    
    //print the values
    SearchMethods.printIntList(values2);

    System.out.println("enter integer value");
    searchValue2 = sc.nextInt();
    System.out.println("Found in slot: " + 
                       SearchMethods.findIntValue(values2, searchValue2));
                       
   
    
  }
}