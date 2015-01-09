/**
 * BadWhateverException is thrown every time you try to create
 * a Whatever with a negative parameter.
 */
public class BadWhateverException extends Exception {
  
  /**
   * Every exception has a default constructor which simply
   * calls the default constructor of the parent.
   */
  public BadWhateverException() {
    super();
  }
  
  /**
   * Every exception also has a constructor with a string
   * parameter that allows you to make your program print
   * out that message when this exception occurs. This can
   * be something as detailed as what line the error occurred
   * on if you wish.
   */
  public BadWhateverException(String message) {
    super(message);
  }
}