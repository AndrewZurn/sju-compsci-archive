package complex;
/**
 * ComplexDivideByZeroRuntimeException is thrown when you attempt to
 * divide by the complex number 0(=0+0i).
 */
public class ComplexDivideByZeroRuntimeException extends RuntimeException {
  /**
   * The default constructor when the Exception is thrown without
   * a message.
   */
  public ComplexDivideByZeroRuntimeException() {
    super();
  }
  
  /**
   * The constructor when the Exception is thrown with a message.
   */
  public ComplexDivideByZeroRuntimeException(String message) {
    super(message);
  }
}