public class Problem2 {
  public int f(int n) {
    if(n<=0) return 0;
    else return(3*n*n-3*n+1+f(n-1));
  }
  public void run() {
    //your tests of f go here. run on several n's to get the pattern
    System.out.println( f(1) );
    System.out.println( f(2) );
    System.out.println( f(3) );
    System.out.println( f(4) );
    System.out.println( f(5) );
  }
  public static void main(String [] args) {
    new Problem2().run();
  }
}
