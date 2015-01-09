
public class InductionProofs{
  
  public static double fiboRegProof(int n){
    if( n == 1 || n == 2 ){
      return 1;
    }
    else if( n >= 3){
      return (fiboRegProof(n-1) + fiboRegProof(n-2));
    }
    else {
      return -1;
    }
  }
  
  public static double fiboFormulaProof(int n){
    n = n - 1;
    double right = ((1.0+(Math.sqrt(5.0)))/2.0);
    right = Math.pow(right, n+1);
    double left = ((1.0-(Math.sqrt(5.0)))/2.0);
    left = Math.pow(left, n+1);
    double combined = (right - left)/(Math.sqrt(5.0));
    return (Math.round(combined));
  }
  
  public static double otherRegProof(int x, int n){
    if( n == 0 ){
      return 1;
    }
    else if( n == 1 ){
      return Math.pow(x, n);
    }
    else if(n == 2){
      return Math.pow(x, n);
    }
    else if( n > 2){
      return ( otherRegProof(x, n-1) + otherRegProof(x, n-2) );
    }
    else{
      return -1;
    }
  }
  
  public static double othersecRegProof(int x, int n){
    double d = 1.0;
    while ( n != 0 ){
      d = d + Math.pow(x, n);
      n--;
    }
    return d;
  }
  
  public static double otherFormulaProof(int x, int n){
    double d = (Math.pow(x, n+1) - 1)/(x-1);
    return d;
  }
  
  public static void main(String[] args){
    System.out.println( fiboRegProof(25) );
    System.out.println( fiboFormulaProof(25) );
    //System.out.println( otherRegProof(10, 5) );
    System.out.println( otherFormulaProof(10, 5));
    System.out.println( othersecRegProof(10, 5));
  }
}