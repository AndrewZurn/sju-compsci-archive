import objectdraw.*;
import java.awt.*;

/**
 *  A set of Bowling pins viewed from the top
 */
public class BowlingPins {
  
  /**
   * The size of a pin
   */ 
  private static final double PIN_SIZE = 20;
  /**
   * The number of rows of pins
   */ 
  private int NUMBER_ROWS = 0;
  private int PIN_COUNT = 1;
  
  private static final double PIN_SPACING = PIN_SIZE * 2;
  
  private static final double PIN_LEG = 28.3;
  
  /*
   * Draws a set of bowling pins on the canvas.  The lowest pin is at pinStart.
   */
  public BowlingPins(double xPinStart, double yPinStart, DrawingCanvas canvas) {
    int rowCount = 0;
    int pinLimit = 1;
    double xPinSpot = xPinStart;
    double yPinSpot = yPinStart;
    
    while( NUMBER_ROWS < 4 ){
      new FramedOval (xPinStart, yPinStart, PIN_SIZE, PIN_SIZE, canvas);
      NUMBER_ROWS = NUMBER_ROWS + 1;
      xPinStart = xPinStart - PIN_LEG;
      yPinStart = yPinStart - PIN_LEG;
      
      
      while ( NUMBER_ROWS < PIN_COUNT ){
        xPinSpot = xPinSpot + PIN_LEG;
        yPinSpot = yPinSpot - PIN_LEG;
        new FramedOval (xPinSpot, yPinSpot, PIN_SIZE, PIN_SIZE, canvas);
        PIN_COUNT ++;
        
        
      }
    }
  }
}






