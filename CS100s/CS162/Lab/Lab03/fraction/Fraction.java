/*
 * Fraction.java
 */

package fraction;

/** 
 * Fraction is an interface for objects that represent rational numbers as fractions
 * 
 * @author J. Andrew Holey
 * @version January 13, 2009
 */
public interface Fraction {
  
  /**
   * Add the specified addend to this Fraction and return the result
   * <p>
   * <b>postcondition</b> This Fraction is changed to its value plus
   * the value of addend.
   * </p><br>
   * @param addend the Fraction to add to this Fraction
   * @return the sum of this Fraction and addend
   */
  public Fraction addToThis(Fraction addend);
  
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
  public Fraction subtractFromThis(Fraction subtrahend);
  
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
  public Fraction multiplyThisBy(Fraction multiplier);
  
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
  public Fraction divideThisBy(Fraction divisor);
  
  /**
   * Compare this Fraction to another object to determine if they are equal
   * 
   * @param other the object to which to compare this Fraction
   * @return true if other is a Fraction equal to this Fraction; false otherwise
   */
  public boolean equals(Object other);
  
  /**
   * Get the value of the numerator of this Fraction
   * 
   * @return the Integer value of the numerator
   */
  public Integer getNumerator();
  
  
  /**
   * Get the value of the denominator of this Fraction
   * 
   * @return the Integer value of the denominator
   */
  public Integer getDenominator();
  
  /**
   * GCD(m,n) returns the Greatest Common Divisor of m and n.
   * <p><b>precondition</b> m>=0 and n>=0
   * </p><br>
   * @param m The first number
   * @param n The second number
   * @return int the GCD of m and n
   * @throws IllegalArgumentException if m or n are negative
   */
  public Integer GCD(int m, int n);
}
