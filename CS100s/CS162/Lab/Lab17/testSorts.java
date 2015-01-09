import java.util.*;
/**
 * This class is simply used to test the three sorting algorithms in
 * the Sorts class - insertion sort, merge sort, and quick sort. We
 * do 10 sorts on each size. If we are testing quickSort or mergeSort
 * we use sizes 1000, 2000, 3000, 4000, 5000, 6000, ..., 10000. 
 * If we are testing insertionSort we use sizes 100, 200, ..., 1000.
 */
public class testSorts {
  
  //temp is a temporary ArrayList<Integer> for our tests.
  private ArrayList<Integer> tempArray;
  //sc is used to read in choices for kinds of sorts.
  private Scanner sc=new Scanner(System.in);
  //size holds the number of current elements, totalCount what it says
  private int size,totalCount;
  
  /**
   * run() asks for which sort you would like to sort and, then,
   * runs that sort through the 10 cases for that sort and returns
   * the counts. You then use those counts in a spreadsheet as in
   * the example in the Sorts handout to "guess" the performance of
   * the three sorts.
   */
  public void run() {
    System.out.println("Enter 1 for insertionSort\n"+
                       "      2 for mergeSort\n"+
                       "      3 for quickSort");
    int choice=sc.nextInt();
    if(choice==1) { //insertionSort
      for(int i=0;i<10;i++) {
        totalCount=0;
        size=100*(i+1);
        for(int j=0;j<10;j++) {
          tempArray=new ArrayList<Integer>();
          for(int k=0;k<size;k++) {
            tempArray.add((int)(100*Math.random()));
          }
          Sorts.insertionSort(tempArray,0,size-1);
          totalCount=totalCount+Sorts.getCount();
        }
        System.out.println("Insertion Sort - size="+size+
                           " and count="+totalCount);
      }
    }
    
    else if(choice == 2){
      for(int i=0;i<10;i++) {
        totalCount=0;
        size=1000*(i+1);
        for(int j=0;j<10;j++) {
          tempArray=new ArrayList<Integer>();
          for(int k=0;k<size;k++) {
            tempArray.add((int)(100*Math.random()));
          }
          Sorts.mergeSort(tempArray,0,size-1);
          totalCount=totalCount+Sorts.getCount();
        }
        System.out.println("Merge Sort - size="+size+
                           " and count="+totalCount);
      }
    }
    
    else if(choice == 3){
      for(int i=0;i<10;i++) {
        totalCount=0;
        size=1000*(i+1);
        for(int j=0;j<10;j++) {
          tempArray=new ArrayList<Integer>();
          for(int k=0;k<size;k++) {
            tempArray.add((int)(100*Math.random()));
          }
          Sorts.quickSort(tempArray,0,size-1);
          totalCount=totalCount+Sorts.getCount();
        }
        System.out.println("Quick Sort - size="+size+
                           " and count="+totalCount);
      }
    }
  }
  public static void main(String [] args) {
    new testSorts().run();
  }
}
  