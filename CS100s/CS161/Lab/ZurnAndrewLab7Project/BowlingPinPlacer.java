import objectdraw.*;
import java.awt.*;

/**
 *  Class to place a set of pins on a canvas
 */
public class BowlingPinPlacer extends FrameWindowController {
  
  /**
   * default location of the lowest pin
   */ 
  private static final double DEFAULT_X = 200;
  private static final double DEFAULT_Y = 200;
  private static final int WANTED_PINS = 6;  //can display from 4 to 7 rows of pins
  
  
  /**
   * create a new set of Bowling Pins on the canvas
   */ 
  public void begin() { 
    
    new BowlingPinsFinal(WANTED_PINS, DEFAULT_X, DEFAULT_Y, canvas);
  }       
}
