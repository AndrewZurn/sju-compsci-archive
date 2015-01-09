/**
 * This class is for exceptions occuring when you try operations
 * with different size RealVectors.
 */
public class RealVectorError extends Error {
  public RealVectorError() {
    super();
  }
  public RealVectorError(String message) {
    super(message);
  }
}