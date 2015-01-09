package complex;
/**
 * interface ComplexInterface defines complex numbers and
 * the usual elementary operations you can perform on them.
 * 
 * @author Lynn Ziegler
 */
interface ComplexInterface {
  
  /**
   * isZero() returns true if both the real and imaginary
   * parts of the number are 0.
   * @return boolean True exactly when this number is 0+0i.
   */
  public boolean isZero();
  
  /**
   * multiply(a) returns this complex number multiplied by
   * complex number a.
   * @parm a The complex number to multiply this complex number by.
   * @return Complex Returns the product of this number and a.
   */
  public Complex multiply(Complex a);
  
  /**
   * divide(a) returns this complex number divided by a.
   * <b>precondition:</b> The parameter a is nonnegative
   * </p><br>
   * @parm a The complex number to divide this complex number by.
   * @return Complex Returns the quotient of this number and a.
   */
  public Complex divide(Complex a) throws ComplexDivideByZeroRuntimeException;
  
  /**
   * add(a) returns this complex number plus complex number a.
   * @parm a The complex number to add to this complex number.
   * @return Complex Returns the sum of this number and a.
   */
  public Complex add(Complex a);
  
  /**
   * subtract(a) returns this complex number minus complex number a.
   * @parm a The complex number to subtract from this complex number.
   * @return Complex Returns the difference of this number and a.
   */
  public Complex subtract(Complex a);
  
  /**
   * getRealPart() returns the real part of the complex
   * number.
   * @return The real part of this complex numbder.
   */
  public Double getRealPart();
  
  /**
   * getImaginaryPart returns the imaginary part of
   * the complex number.
   * @return Double The imaginary part of this complex number.
   */
  public Double getImaginaryPart();
  
  /**
   * modulus returns the complex modulus (or complex absolute value) of
   * this complex number.
   * @return Double The modulus (absolute value) of this complex number.
   */
  public Double modulus();
  
  /**
   * argument returns the argument of the complex
   * number. (This is the angle - between -PI and PI -
   * of the complex number in the complex plane.)
   * @return Double The argument of the complex number.
   */
  public Double argument();
  
  /**
   * conjugate returns the complex conjugate of the 
   * complex number. If the number is a+b*i then the
   * conjugate is a-b*i.
   * @return Complex The complex conjugate of this complex number.
   */
  public Complex conjugate();
  
  /**
   * multiplyByReal(real) returns the complex number after
   * both real and imaginary parts are multiplied by the
   * number real.
   * @param real The real number to multiply this complex number by.
   * @return Complex The complex result of multipying this by real.
   */
  public Complex multiplyByReal(Double real);
  
  /**
   * toString() defines how complex numbers are printed.
   * Note that there are compact forms when there is no
   * real part or no imaginary part.
   * @return String A String which properly represents this number.
   */
  public String toString();
}