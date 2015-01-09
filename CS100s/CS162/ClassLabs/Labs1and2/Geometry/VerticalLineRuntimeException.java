public class VerticalLineRuntimeException extends RuntimeException {
  /**
   * The default constructor is thrown when the line is vertical
   * and no message is specified.
   */
  public VerticalLineRuntimeException() {
    super();
  }
  
  /**
   * This constructor is called when this exception is thrown
   * with a message.
   */
  public VerticalLineRuntimeException(String message) {
    super(message);
  }
}