/*
 * Fraction.java
 */

/** 
 * Fraction is an interface for objects that represent rational numbers as fractions.
 * 
 * @author Xu, Runbo and Zurn, Andrew
 * @version January 19, 2011
 */
public interface Fraction {
  
  /**
   * A method that will add the expressed number to the fraction.
   * @param addend The number to be added.
   */
  public Fraction addToThis(Fraction addend);
  
  /**
   * A method that will subtract the expressed number from the fraction.
   * @param subtrahend The number to be subtracted.
   */
  public Fraction subtractFromThis(Fraction subtrahend);
  
  /**
   * A method that will multiply the expressed number by the fraction.
   * @param multiplier The number to be used to multiplied.
   */
  public Fraction multiplyThisBy(Fraction multiplier);
  
  /**
   * A method that will divide the expressed number by the fraction.<br>
   * <b>Precondition:</b>The divisor must be a number greater than or less than zero.
   * @param divisor The number to be used to divide by.
   * @throws DivideByZeroRuntimeException If divisor is zero.
   */
  public Fraction divideThisBy(Fraction divisor) throws DivideByZeroRuntimeException;
  
  /**
   * A method to check the equality of two objects.<br>
   * <b>Precondition:</b>Niether objects can be null.<br>
   * <b>Postcondition:</b>Will return <i>true</i> if the objects are equivalent, or <i>false</i> if not equivalent.
   * @param other The object to be checked for equality against another object.
   */
  public boolean equals(Object other);
  
  /**
   * A method to return as an integer, the numerator of the fraction.
   */
  public Integer getNumerator();
  
  
  /**
   * A method to return as an integer, the demoninator of a fraction.
   */
  public Integer getDenominator();
  
}
