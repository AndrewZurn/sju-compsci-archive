/**
 * This class is for exceptions occuring when you try operations
 * with different size RealMatrixes.
 */
public class RealMatrixError extends Error {
  public RealMatrixError() {
    super();
  }
  public RealMatrixError(String message) {
    super(message);
  }
}