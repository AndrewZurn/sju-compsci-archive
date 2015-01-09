public class MontyHall{
  
  
  public static int run(){ //swap refused
    int count = 0;
    int prizeBox;
    int yourBox;
    for(int i = 0; i<10000; i++){
      prizeBox = (int) (3*Math.random());
      yourBox = (int) (3*Math.random());
      if(prizeBox == yourBox){
        count++;
      }
    }
    return (count);
  }
  
  public static int run2(){ //with swap
    int count = 0;
    int prizeBox;
    int yourBox;
    double x;
    for(int i = 0; i<10000; i++){
      prizeBox = (int) (3*Math.random());
      yourBox = (int) (3*Math.random());
      x = Math.random();
      if( x>=0.5 ){
        if( prizeBox == yourBox ){
          count++;
        }
      }
      else if( x<0.5 ){
        if( prizeBox != yourBox ){
          count++;
        }
      }
    }
    return count;
  }
    
  public static void main(String[] args){
    for(int i = 0; i<10; i++){
      System.out.println( "When the swap is refused, the percentage of the right box picked is: " +
                         (int) run()/10000.0); //swap refused
      System.out.println( "When the swap is made randomly, the percentage of the right box picked is: " +
                         (int) run2()/10000.0 +"\n"); //with swap
    }
  }
}