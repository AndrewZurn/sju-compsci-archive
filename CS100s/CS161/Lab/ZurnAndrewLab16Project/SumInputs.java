import java.util.*;

public class SumInputs {
  Scanner sc;
  ArrayList<Integer> inList;
  int result=0;
  /** 
   * Basic constructor for SortInputs
   */
  public SumInputs()
  {
   sc=new Scanner(System.in);
  }

  /** 
   * insertionSort(ArrayList<Integer> A,int lastSpot) will sort
   * ArrayList<Integer> A using the insertion algorithm. This means,
   * first look at the element at position 1. If it is smaller than
   * the one at position 0, then make the element at 1 what used to
   * be at 0, and make the one at 0 what used to be at 1. Then let
   * i=2. Find the first place less than 2 (if any) where the element
   * at position 2 is smaller than that element, move that element and
   * the others after that up and put the thing that used to be at 2
   * into that spot. Continue until you have looked at all elements
   * from 0 to lastSpot-1. At this point, the elements from 0 to
   * lastSpot-1 should be sorted.
   */
  public void sumThem(ArrayList<Integer> A,int lastSpot) {
    /*int j;
    int temp;
    for(int i=1;i<lastSpot;i++) {
      temp=A.get(i);
      j=i;
      while((j>0) && (temp<A.get(j-1))) {
        A.set(j,A.get(j-1));
        j=j-1;
      }
      A.set(j,temp);
    }*/
    for(int i=0; i<lastSpot;i++){
     result+=A.get(i); 
    }
  }


  /** 
   * run() reads in the input numbers, sorts them, and, then,
   * outputs them in sorted order.
   */
  public void run() {
    inList=new ArrayList<Integer>();
    while(sc.hasNextInt()) {
      inList.add(sc.nextInt());
    }
    sumThem(inList,inList.size());
    /*for(int i=0;i<inList.size();i++) {
      System.out.println(inList.get(i));
    }*/
    System.out.println(result);
  }
}
