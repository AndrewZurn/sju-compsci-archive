import java.util.*;
import java.io.*;

public class SearchMethods {
  
  
  public static double[] genList(int size){
    double[] list = new double[size];
    for (int i = 0; i < size; i++){
      list[i] = 1000 * Math.random();
    }
    return list;
  }
  
  public static int[] genIntList(int size){
    int[] list = new int[size];
    for(int i = 0; i<size;i++){
      list[i] = (int)(1000*Math.random());
    }
    return list;
  }
  
  public static double findSmallest(double[] list){
    double min = list[0];
    for( int i = 1; i < list.length; i++){
      if (list[i]<min){
        min = list[i];
      }
    }
    return min;
  }
  
  public static void printIntList(int[] list){
    for (int i = 0; i < list.length; i++){
      System.out.printf("%8d", list[i]);
      if(i%5 == 4){
        System.out.println();
      }
    }
    System.out.println();
  }
  
  public static void printList(double[] list){
    for (int i = 0; i < list.length; i++){
      System.out.printf("%8.2f",list[i]);
      if (i%5 == 4){
        System.out.println();
      }
    }
    System.out.println();
  }
  
  public static int finIntValue(int[] list, int value){
    for(int i = 0; i<list.length; i++){
      if (value == list[i]){
        return value;
      }
    }
    return -1;
  }
  
  public static void main(String args[]) {
    double[] values ;
    values = genList(20);
    int[] intValues;
    intValues = genIntList(20);
    printList(values);
    printIntList(intValues);
    System.out.println(finIntValue(intValues, 357));
    System.out.println(findSmallest(values));
    
  }
  
  
}
