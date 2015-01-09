import java.util.*;
public class PartitionExample {
  static int count;
  public static <T extends Comparable<T>> int partition(ArrayList<T> a,int left,int right) {
    T temp;
    int lp=left;
    int rp=right+1;
    T pValue=a.get(left);
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
  
  public static <T extends Comparable<T>> void quickSort(ArrayList<T> a,
                                                     int left,int right) {
    int maxpos=0;
    for(int i=1;i<=right;i++) {
      if(a.get(i).compareTo(a.get(maxpos))>0) maxpos=i;
    }
    T temp=a.get(right);
    a.set(right,a.get(maxpos));
    a.set(maxpos,temp);
    qSort(a,left,right);
  }
        
  public static <T extends Comparable<T>> void qSort(ArrayList<T> a,
                                                     int left,int right) {
    if(right>left) {
      count++;
      int p=partition(a,left,right);
      qSort(a,left,p-1);
      qSort(a,p+1,right);
    }
  }
  
  public static void main(String [] args) {
    count=0;
    ArrayList<Integer> a=new ArrayList<Integer>();
    int max=Integer.parseInt(args[0]);
    for(int i=0;i<20;i++) {
      a.add((int)(Math.random()*max));
      System.out.print(a.get(i)+"|");
    }
    System.out.println();
    quickSort(a,0,a.size()-1);
    //System.out.println(partition(a,0,a.size()-1));
    for(int i=0;i<a.size();i++) {
      System.out.print(a.get(i)+"|");
    }
    System.out.println();
    System.out.println(count);
  }
}
