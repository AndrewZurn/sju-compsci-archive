public class Problem3 {
  public int f(int n) {
    if(n<=0) {
      return 3;
    }
    else if(n==1) {
      return(9);
    }
    else {
      return(4*f(n-1)-3*f(n-2));
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
    new Problem3().run();
  }
}
