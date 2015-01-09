/*
 * Fraction.java
 */

package fraction;

/** 
 * Fraction is an interface for objects that represent rational numbers as fractions
 * 
 * @author Zurn,Andrew and Xu,Runbo
 * @version January 28, 2011
 */
public class IntFraction implements Fraction {
  private int numerator, denominator;
  
  public IntFraction(){
   numerator=0;
   denominator=1;
  }
  
  public IntFraction(int integer){
    numerator=integer;
    denominator=1;
  }
  public IntFraction(int num,int deno) throws ArithmeticException{
    if(deno!=0){
      this.numerator=num;
      this.denominator=deno;
      if(denominator<0){
        denominator=-denominator;
        numerator=-numerator;
      }
      int temp=GCD(numerator, denominator);
      numerator=numerator/temp;
      denominator=denominator/temp;
      System.out.println(numerator);
      System.out.println(denominator);
    }
    else{
      throw new ArithmeticException();
    }
  }
  /**
   * Add the specified addend to this Fraction and return the result
   * <p>
   * <b>postcondition</b> This Fraction is changed to its value plus
   * the value of addend.
   * </p><br>
   * @param addend the Fraction to add to this Fraction
   * @return the sum of this Fraction and addend
   */
  public IntFraction addToThis(Fraction addend) {
    numerator=numerator*addend.getDenominator()+denominator*addend.getNumerator();
    denominator=denominator*addend.getDenominator();
    return new IntFraction(numerator, denominator);
  }
  
  /**
   * Subtract the specified subtrahend from this Fraction and return the result
   * <p>
   * <b>postcondition</b> This Fraction is changed to its value minus
   * the value of subtrahend.
   * </p><br>
   * 
   * @param subtrahend the Fraction to subtract from this Fraction
   * @return the difference between this Fraction (the minuend) and subtrahend
   */
  public IntFraction subtractFromThis(Fraction subtrahend){
    numerator=numerator*subtrahend.getDenominator()-denominator*subtrahend.getNumerator();
    denominator=denominator*subtrahend.getDenominator();
    return new IntFraction(numerator, denominator);
  }
  
  /**
   * Multiply this Fraction by the specified multiplier and return the result
   * 
   * <p>
   * <b>postcondition</b> This Fraction is changed to its value times
   * the value of multiplier.
   * </p><br>
   * 
   * @param multiplier the Fraction to multiply this Fraction by
   * @return the product of this Fraction (the multiplicand) and multiplier
   */
  public IntFraction multiplyThisBy(Fraction multiplier){
    numerator=numerator*multiplier.getNumerator();
    denominator=denominator*multiplier.getDenominator();
    return new IntFraction(numerator, denominator);
  }
  
  /**
   * Divide this Fraction by the specified divisor and return the result
   * 
   * <p>
   * <b>precondition</b> The divisor is not the fraction 0/1.
   * </p><br>
   * <p>
   * <b>postcondition</b> This Fraction is changed to its value divided by
   * the value of divisor.
   * </p><br>
   * 
   * @param divisor the Fraction to divide this Fraction by
   * @return the quotient of this Fraction and divisor
   * @throws ArithmeticException if divisor is a zero Fraction
   */
  public IntFraction divideThisBy(Fraction divisor) throws ArithmeticException{
    if(divisor.getNumerator()!=0){
      numerator=numerator*divisor.getDenominator();
      denominator=denominator*divisor.getNumerator();
      return new IntFraction(numerator, denominator);
    }
    else{
      throw new ArithmeticException();
    }
  }
  
  /**
   * Compare this Fraction to another object to determine if they are equal
   * 
   * @param other the object to which to compare this Fraction
   * @return true if other is a Fraction equal to this Fraction; false otherwise
   */
  public boolean equals(Object other){
    if(!(other instanceof IntFraction)){
      return false; 
    }
    else{
      IntFraction otherFraction = (IntFraction) other;
      if(numerator==otherFraction.getNumerator() && denominator==otherFraction.getDenominator()){
        return true;
      }
      else{
        return false;
      }
    }
  }
  
  /**
   * Get the value of the numerator of this Fraction
   * 
   * @return the Integer value of the numerator
   */
  public Integer getNumerator(){
    return numerator;
  }
  
  
  /**
   * Get the value of the denominator of this Fraction
   * 
   * @return the Integer value of the denominator
   */
  public Integer getDenominator(){
    return denominator;
  }
  
  /**
   * GCD(m,n) returns the Greatest Common Divisor of m and n.
   * <p><b>precondition</b> m>=0 and n>=0
   * </p><br>
   * @param m The first number
   * @param n The second number
   * @return int the GCD of m and n
   * @throws IllegalArgumentException if m or n are negative
   */
  public Integer GCD(int m, int n){
    if(n!=0){
      return GCD(n, m%n);
      
    }
    System.out.println(m);
      return m;
  }
  
  public static void main (String []args){
   new IntFraction(12,18); 
  }
}
