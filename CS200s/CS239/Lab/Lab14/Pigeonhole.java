import java.util.*;
/**
 * This class is used to test the Pigeonhole Principle.
 */
public class Pigeonhole {
  
  /**
   * This method simply tests the method generateSequence to
   * make sure it works. You will change this method so that it
   * loops 10,000 times calling generateSequence each time and,
   * then, determines whether two of the numbers add
   * up to 21. It should return a count of how many times this
   * happens. (In the case where we do
   *                  generateSequence(20,11)
   * the count should be 10000. In the cases where you do
   *                  generateSequence(20,m)
   * where m=2,3,4,5,6,7,8,9,10 you should get some cases where
   * the count is not 10000. Print out the number count/10000.0 for
   * each case. You should see increasing values for 2-10 and a
   * value of 1 for 11.)
   */
  public void testGenerateSequence() {
    int count = 0;
    ArrayList<Integer> test;
    for(int i=2;i<=10;i++) {
      count = 0;
      for(int j = 0; j<10000; j++){
        test=generateSequence(20,i);
        if( checkSum21(test) ){
          count++;
        }
      }
      System.out.println(count/10000.0);
    }
  }
  
  public boolean checkSum21(ArrayList<Integer> list){
    for(int i = 0; i<list.size(); i++){
      for(int j = list.size(); j>0; j--){
        if( list.get(i) + list.get(j-1) == 21 ){
          return true;
        }
      }
    }
    return false;
  }

  
  
  /**
   * generateSequence(n,count) generates count distinct random numbers
   * from 1 to n (including 1 and n). We use it for a first test of
   * the combinatorial principle called the Pigeonhole Principle.
   */   
  public ArrayList<Integer> generateSequence(int n, int count) {
    TreeSet<Integer> intSet=new TreeSet<Integer>();
    while(intSet.size()<count) {
      intSet.add((int)(n*Math.random()+1));
    }
    ArrayList<Integer> temp=new ArrayList<Integer>();
    for(Integer x:intSet) {
      temp.add(x);
    }
    return(temp);
  }
  
  /**
   * The usual main to start the program. Modify for your own use.
   */
  public static void main(String [] args) {
    new Pigeonhole().testGenerateSequence();
  }
}