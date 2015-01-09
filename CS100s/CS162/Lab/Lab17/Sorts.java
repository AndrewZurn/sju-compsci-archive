import java.util.*;
public class Sorts {
  //We use count to count comparisons in our sorts.
  static int count; 
  /* We use an ArrayList<ArrayList<Integer>> to pregenerate many
   * ArrayLists so we can do long average counts. */
  static ArrayList<ArrayList<Integer>> testArrays;
  
  /**
   * insertionSort(a,first,last) sorts the ArrayList a from first to
   * last (inclusive at both ends). It does it by moving down the
   * ArrayList and moving each element up to the spot it belongs in
   * when the ArrayList is sorted. This is an order n-squared algorithm
   * but it is very fast for small arrays.
   */
  public static <T extends Comparable<T>> void insertionSort(ArrayList<T> a,
                                                     int first,int last) {
    T temp;
    int j;
    for(int i=first+1;i<=last;i++) {
      //We will move the thing at i into sorted position.
      j=i;
      /* As long as the thing at j is smaller than the thing
       *   at j-1 and j>first, swap them. This puts the thing
       *   at j into its correct spot (eventually). */
      count++;
      while((j>first) && (a.get(j).compareTo(a.get(j-1))<0)) {
        temp=a.get(j);
        a.set(j,a.get(j-1));
        a.set(j-1,temp);
        j--;
        count++;
      }
    }
  }
  
  /**
   * merge(a,first,middle,last) merges the part of the ArrayList
   * a from first to middle with the part from middle+1 to last.
   * Assuming the two parts were sorted, then all of the elements
   * from first to last (inclusive at both ends) will be sorted.
   */
  public static <T extends Comparable<T>> void merge(ArrayList<T> a, int first,
                                              int middle, int last) {
    ArrayList<T> temp=new ArrayList<T>();
    int l=first;
    int r=middle+1;
    //grab the first two values in the stuff to be merged
    T left=a.get(l);
    T right=a.get(r);
    while((l<=middle) && (r<=last)) {
      /* if left is small, add the left item and move the
       *   left pointer right. */
      count++;
      if(left.compareTo(right)<0) {
        temp.add(left);
        l++;
        if(l<=middle) {
          //set left to the value at the new spot.
          left=a.get(l);
        }
      }
      else { /* right is small, so add it to temp and move
              * the right pointer right.*/
        temp.add(right);
        r++;
        if(r<=last) {
          //set right to the value at the new spot.
          right=a.get(r);
        }
      }
    }
    /* If there are any values left in the left half, add
     *    them to temp.
     */
    while(l<=middle) {
      temp.add(a.get(l));
      l++;
    }
    /* If there are any values left in the right half, add
     *    them to temp.
     */
    while(r<=last) {
      temp.add(a.get(r));
      r++;
    }  
    //copy temp back into the right spots in array a.
    for(int i=first;i<=last;i++) {
      a.set(i,temp.get(i-first));
    }
  }
  
  /**
   * mergeSort(a,first,last) sorts the ArrayList a from first to
   * last (inclusive of both ends). It does it by dividing the
   * ArrayList into two parts, sorting the two parts recursively,
   * and then merging the two sorted parts together. Mergesort is
   * an order n log(n) algorithm and is generally slightly slower
   * than quicksort. However, Mergesort is also order n log(n) in
   * the worst case (when quicksort could be order n squared).
   */
  public static <T extends Comparable<T>> void mergeSort(ArrayList<T> a,
                                                  int first,int last) {
    if(first<last) {
      int middle=(first+last)/2;
      mergeSort(a,first,middle);
      mergeSort(a,middle+1,last);
      merge(a,first,middle,last);
    }
  }
  
  /**
   * This version of partition uses the median of three method to pic the
   * partition value and, then, does a usual partition for quickSort.
   */
  public static <T extends Comparable<T>> int partition(ArrayList<T> a,
                                                         int left,int right) {
    T temp;
    int lp=left;
    int rp=right+1;
    int mid=(left+right)/2;
    T small=a.get(left);
    T medium=a.get(mid);
    T large=a.get(right);
    count++;
    if(medium.compareTo(small)<0) {
      temp=medium;
      medium=small;
      small=temp;
    }
    count++;
    if(large.compareTo(medium)<0) {
      temp=large;
      large=medium;
      medium=temp;
      count++;
      if(medium.compareTo(small)<0) {
        temp=medium;
        medium=small;
        small=temp;
      }
    }
    a.set(left,medium);
    a.set(mid,small);
    a.set(right,large);
    T pValue=medium;
    while(lp<rp) {
      rp=rp-1;
      count++;
      while(a.get(rp).compareTo(pValue)>0) {
        rp=rp-1;
        count++;
      }
      lp=lp+1;
      count++;
      while(a.get(lp).compareTo(pValue)<0) {
        lp=lp+1;
        count++;
      }
      if(lp<rp) {
        temp=a.get(lp);
        a.set(lp,a.get(rp));
        a.set(rp,temp);
      }
    }
    a.set(left,a.get(rp));
    a.set(rp,pValue);
    return(rp);
  }
  
  /**
   * This is quickSort using the median of 3 partition method.
   */
  public static <T extends Comparable<T>> void quickSort(ArrayList<T> a,
                                                     int left,int right) {
    if(right>left) {
      count++;
      int p=partition(a,left,right);
      quickSort(a,left,p-1);
      quickSort(a,p+1,right);
    }
  }
  
  /**
   * Like the use of count this is just used for testing actual
   * performance of these sorts. In a real case you would want to
   * remove all references to the count value.
   */
  public static int getCount() {
    int temp=count;
    count=0;
    return(temp);
  }
}