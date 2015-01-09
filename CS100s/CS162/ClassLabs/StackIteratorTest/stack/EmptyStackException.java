package stack;
/**
 * EmptyStackException is Thrown whenever an attempt is
 * made to pop or peek at an empty stack.
 */
public class EmptyStackException extends RuntimeException {
  /**
   * This is thrown when the thrower does not wish
   * to send a message with the exception.
   */
  public EmptyStackException() {
    super();
  }
  
  /**
   * This is thrown when the thrower wishes to send
   * a message with the exception.
   */
  public EmptyStackException(String message) {
    super(message);
  }
}