public class AlgorithmTimer{
  
  public static long timer0(int n) {
    long startTime=System.currentTimeMillis();
    for(int i=0;i<10000;i++) {
      for(int j=0;j<n;j++) {
        for(int k=0;k<n;k++) {
          Math.sin(j+k);
        }
      }
    }
    return(System.currentTimeMillis()-startTime);
  }
  
  public static long timer1(int n) {
    long startTime=System.currentTimeMillis();
    for(int i=0;i<10000;i++) {
      for(int j=0;j<n;j++) {
        for(int k=0;k*k<n;k++) {
          Math.sin(j+k);
        }
      }
    }
    return(System.currentTimeMillis()-startTime);
  }
  
  public static long timer2(int n) {
    long startTime=System.currentTimeMillis();
    for(int i=0;i<10000;i++) {
      for(int j=0;j<n;j++) {
        for(int k=0;k<Math.log(n);k++) {
          Math.sin(j+k);
        }
      }
    }
    return(System.currentTimeMillis()-startTime);
  }
  
  public static long timer3(int n) {
    long startTime=System.currentTimeMillis();
    for(int i=0;i<10000;i++) {
      for(int j=0;j<n;j++) {
        for(int k=0;k<n;k++) {
          for(int m=0;m<n;m++) {
            Math.sin(j+k+m);
          }
        }
      }
    }
    return(System.currentTimeMillis()-startTime);
  }
  
  public static void main(String[] args){
    for(int i = 10; i<=100; i= i+10){
      System.out.println( "Timer 0 at: " + timer0(i) );
    }
    for(int i = 10; i<=100; i= i+10){
      System.out.println( "Timer 1 at: " + timer1(i) );
    }
    for(int i = 10; i<=100; i= i+10){
      System.out.println( "Timer 2 at: " + timer2(i) );
    }
    for(int i = 10; i<=100; i= i+10){
      System.out.println( "Timer 3 at: " + timer3(i) );
    }
  }
}