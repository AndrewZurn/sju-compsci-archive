import objectdraw.*;
import java.awt.*;

/**
 *  Class to place a Bullseye on a canvas
 */
public class BullseyeTester extends FrameWindowController {
  
  /**
   * default location of the Bullseye
   */ 
  private static final double DEFAULT_X = 250;
  private static final double DEFAULT_Y = 250;
  private double RING_SIZE = 100;
  private double RING_SPACING = 20;
  
  
  /**
   * create a new set of Bullseyes on the canvas
   */
  public void begin() { 

    new Bullseye(DEFAULT_X, DEFAULT_Y,  canvas);
  }       
}
