import java.util.*;
public class PartitionExample2 {
  static int count;
  public static <T extends Comparable<T>> int partition2(ArrayList<T> a,
                                                         int left,int right) {
    T temp;
    int lp=left;
    int rp=right+1;
    int mid=(left+right)/2;
    T small=a.get(left);
    T medium=a.get(mid);
    T large=a.get(right);
    count=count+1;
    if(medium.compareTo(small)<0) {
      temp=medium;
      medium=small;
      small=temp;
    }
    count=count+1;
    if(large.compareTo(medium)<0) {
      temp=large;
      large=medium;
      medium=temp;
      count=count+1;
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
  
    public static <T extends Comparable<T>> void qSort(ArrayList<T> a,
                                                     int left,int right) {
    if(right>left) {
      count++;
      int p=partition2(a,left,right);
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
    qSort(a,0,a.size()-1);
    //System.out.println(partition2(a,0,a.size()-1));
    for(int i=0;i<a.size();i++) {
      System.out.print(a.get(i)+"|");
    }
    System.out.println();
    System.out.println(count);
  }
}
