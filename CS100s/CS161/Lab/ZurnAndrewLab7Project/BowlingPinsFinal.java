import objectdraw.*;
import java.awt.*;

/**
 *  A set of Bowling pins viewed from the top
 */
public class BowlingPinsFinal {
  
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
  public BowlingPinsFinal(int wantedPin, double xPinStart, double yPinStart, DrawingCanvas canvas) {
    int rowCount = 0;
    double xPinSpot = xPinStart;
    double yPinSpot = yPinStart;
    int PIN_WANTED = wantedPin;
    
    while( NUMBER_ROWS < PIN_WANTED ){
      new FramedOval (xPinStart, yPinStart, PIN_SIZE, PIN_SIZE, canvas);
      NUMBER_ROWS = NUMBER_ROWS + 1;
      xPinStart = xPinStart - PIN_LEG;
      yPinStart = yPinStart - PIN_LEG;
    }                                                        
    rowCount = 2;
    
    if ( rowCount % 2==0){
      
      xPinSpot = xPinSpot + PIN_LEG;
      yPinSpot = yPinSpot - PIN_LEG;
      while ( PIN_COUNT < 2){
        new FramedOval ( xPinSpot, yPinSpot, PIN_SIZE, PIN_SIZE, canvas);
        PIN_COUNT = PIN_COUNT + 1;  
      }
      rowCount = rowCount + 1;
      PIN_COUNT = 2;
    }
    
    
    
    if (rowCount % 3 == 0){
      yPinSpot = yPinSpot - PIN_LEG;
      xPinSpot = xPinSpot - PIN_LEG;
      PIN_COUNT = 1;
      
      while( PIN_COUNT < 3){
        new FramedOval ( xPinSpot, yPinSpot, PIN_SIZE, PIN_SIZE, canvas);
        xPinSpot = xPinSpot + PIN_SPACING + PIN_SIZE;
        PIN_COUNT = PIN_COUNT + 1;
      }
      rowCount = rowCount + 1;
    }
    
    if (rowCount % 4 == 0){
      xPinSpot = xPinSpot - (3*PIN_SPACING)-PIN_LEG;
      yPinSpot = yPinSpot - PIN_LEG;
      PIN_COUNT = 1;
      while( PIN_COUNT < 4){
        new FramedOval ( xPinSpot, yPinSpot, PIN_SIZE, PIN_SIZE, canvas);
        xPinSpot = xPinSpot + PIN_SIZE + PIN_SPACING;
        PIN_COUNT = PIN_COUNT + 1;
      }
      rowCount = rowCount + 1;
      
    }
    
    if (PIN_WANTED >= 5){
      if (rowCount % 5 == 0){
        xPinSpot = xPinSpot - (3*(PIN_SPACING+PIN_SIZE))-PIN_LEG;
        yPinSpot = yPinSpot - PIN_LEG;
        PIN_COUNT = 1;
        while( PIN_COUNT < 5){
          new FramedOval ( xPinSpot, yPinSpot, PIN_SIZE, PIN_SIZE, canvas);
          xPinSpot = xPinSpot + PIN_SIZE + PIN_SPACING;
          PIN_COUNT = PIN_COUNT + 1;
        }
        rowCount = rowCount + 1;
        
      }
      
      if (PIN_WANTED >= 6){
        if (rowCount % 6 == 0){
          xPinSpot = xPinSpot - (4*(PIN_SPACING+PIN_SIZE))-PIN_LEG;
          yPinSpot = yPinSpot - PIN_LEG;
          PIN_COUNT = 1;
          while( PIN_COUNT < 6){
            new FramedOval ( xPinSpot, yPinSpot, PIN_SIZE, PIN_SIZE, canvas);
            xPinSpot = xPinSpot + PIN_SIZE + PIN_SPACING;
            PIN_COUNT = PIN_COUNT + 1;
          }
          rowCount = rowCount + 1;
          
          if (PIN_WANTED == 7){
            if (rowCount % 7 == 0){
              xPinSpot = xPinSpot - (5*(PIN_SPACING+PIN_SIZE))-PIN_LEG;
              yPinSpot = yPinSpot - PIN_LEG;
              PIN_COUNT = 1;
              while( PIN_COUNT < 7){
                new FramedOval ( xPinSpot, yPinSpot, PIN_SIZE, PIN_SIZE, canvas);
                xPinSpot = xPinSpot + PIN_SIZE + PIN_SPACING;
                PIN_COUNT = PIN_COUNT + 1;
              }
              rowCount = rowCount + 1;
            }
          }
        }
      }
    }
  }
}
    
    
    
    
    
    
    
    
