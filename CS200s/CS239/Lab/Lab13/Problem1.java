public class Problem1 {
  public int f(int n) {
    if(n<=1) {
      return 2;
    }
    else {
      return(2*n+f(n-1));
    }
  }
  public void run() {
    //put your test calls to f here. Run on several n's to get the pattern
    System.out.println( f(1) );
    System.out.println( f(2) );
    System.out.println( f(3) );
    System.out.println( f(4) );
    System.out.println( f(5) );
  }
  public static void main(String [] args) {
    new Problem1().run();
  }
}
