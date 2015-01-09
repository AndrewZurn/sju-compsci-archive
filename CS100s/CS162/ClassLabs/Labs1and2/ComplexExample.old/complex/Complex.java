package complex;
/**
 * Complex is the standard implementation of the
 * interface ComplexInterface which describes the
 * basic operations with complex numbers.
 * 
 * @author Lynn Ziegler
 * @version 1.0
 */
public class Complex implements ComplexInterface {
  
  /*
   * realPart and imaginaryPart are the two pieces
   * that make up the complex number
   *           realPart+i*imaginaryPart
   */
  private Double realPart,
                 imaginaryPart;
  
  /**
   * This constructor with no arguments produces the
   * complex number 0+0i.
   */
  public Complex() {
    realPart=0.0;
    imaginaryPart=0.0;
  }
  
  /**
   * The constructor Complex(Double real) produces the 
   * complex number
   *    real+0*i
   */
  public Complex(Double real) {
    realPart=real;
    imaginaryPart=0.0;
  }
  
  /**
   * the constructor Complex(Double realPart,Double imaginaryPart)
   * produces the complex number
   *     realPart+imaginaryPart*i
   */
  public Complex(Double realPart, Double imaginaryPart) {
    this.realPart=realPart;
    this.imaginaryPart=imaginaryPart;
  }
  
  /**
   * isZero() returns true if both the real and imaginary
   * parts of the number are 0.
   * @return boolean True if this comples number is 0+0i, false otherwise.
   */
  public boolean isZero() {
    return((realPart==0.0) && (imaginaryPart==0.0));
  }
  
  /**
   * multiply(a) returns this complex number multiplied by
   * complex number a.
   * @parm a The complex number to multiply this complex number by.
   * @return Complex Returns the product of this number and a.
   */
  public Complex multiply(Complex a) {
    return new Complex(getRealPart()*a.getRealPart()-
                           getImaginaryPart()*a.getImaginaryPart(),
                       getRealPart()*a.getImaginaryPart()+
                           getImaginaryPart()*a.getRealPart());
  }

  /**
   * divide(a) returns this complex number divided by a.
   * <b>precondition:</b> The parameter a is nonnegative
   * </p><br>
   * @parm a The complex number to divide this complex number by.
   * @return Complex Returns the quotient of this number and a.
   */
  public Complex divide(Complex a) throws ComplexDivideByZeroRuntimeException {
    if(a.isZero()) 
      throw new ComplexDivideByZeroRuntimeException(
                                  "You cannot divide by 0.0+0.0i");
    else {
      double denom=1.0/a.modulus();
      return this.multiplyByReal(denom).multiply(
                      a.conjugate().multiplyByReal(denom));
    }
  }
  
  /**
   * add(a) returns this complex number plus complex number a.
   * @parm a The complex number to add to this complex number.
   * @return Complex Returns the sum of this number and a.
   */
  public Complex add(Complex a) {
    return new Complex(getRealPart()+a.getRealPart(),
                       getImaginaryPart()+a.getImaginaryPart());
  }
  
  /**
   * subtract(a) returns this complex number minus complex number a.
   * @parm a The complex number to subtract from this complex number.
   * @return Complex Returns the difference of this number and a.
   */
  public Complex subtract(Complex a) {
    return new Complex(getRealPart()-a.getRealPart(),
                   getImaginaryPart()-a.getImaginaryPart());
  }
  
  /**
   * getRealPart() returns the real part of the complex
   * number.
   * @return The real part of this complex numbder.
   */
  public Double getRealPart() {
    return realPart;
  }
  
  /**
   * getImaginaryPart returns the imaginary part of
   * the complex number.
   * @return Double The imaginary part of this complex number.
   */
  public Double getImaginaryPart() {
    return imaginaryPart;
  }
  
  /**
   * modulus returns the complex modulus (or complex absolute value) of
   * this complex number.
   * @return Double The modulus (absolute value) of this complex number.
   */
  public Double modulus() {
    return Math.sqrt(realPart*realPart+imaginaryPart*imaginaryPart);
  }
  
  /**
   * argument returns the argument of the complex
   * number. (This is the angle - between -PI and PI -
   * of the complex number in the complex plane.)
   * @return Double The argument of the complex number.
   */
  public Double argument() {
    if(imaginaryPart==0.0) {
      if(realPart>=0.0) return 0.0;
      else return Math.PI;
    }
    else return Math.atan(realPart/imaginaryPart);
  }
  
  /**
   * conjugate returns the complex conjugate of the 
   * complex number. If the number is a+b*i then the
   * conjugate is a-b*i.
   * @return Complex The complex conjugate of this complex number.
   */
  public Complex conjugate() {
    return new Complex(realPart,-imaginaryPart);
  }
  
  /**
   * multiplyByReal(real) returns the complex number after
   * both real and imaginary parts are multiplied by the
   * number real.
   * @param real The real number to multiply this complex number by.
   * @return Complex The complex result of multipying this by real.
   */
  public Complex multiplyByReal(Double real) {
    return new Complex(real*realPart,real*imaginaryPart);
  }
  
  /**
   * toString() defines how complex numbers are printed.
   * Note that there are compact forms when there is no
   * real part or no imaginary part.
   * @return String A String which properly represents this number.
   */
  public String toString() {
    if(imaginaryPart==0.0) 
      return(""+realPart);
    else if(realPart==0.0) 
      return(""+imaginaryPart+"*i");
    else if (imaginaryPart>0.0) 
      return(""+realPart+"+"+imaginaryPart+"*i");
    else
      return(""+realPart+""+imaginaryPart+"*i");
  }
}