/**
 * A DivideByZeroRuntimeException is thrown whenever a number is divided by zero.
 * @author Xu, Runbo and Zurn, Andrew
 * @version January 19, 2011
 */
public class DivideByZeroRuntimeException extends RuntimeException {
  /**
   * The exception to call upon the default construction of the parent exception.
   */
    public DivideByZeroRuntimeException() {
       super();
    }
    /**
     * The exception that will print out the message of the exception.
     * @param message The message to be displayed when this exception is present.
     */
    public DivideByZeroRuntimeException(String message) {
       super(message);
    }
}
