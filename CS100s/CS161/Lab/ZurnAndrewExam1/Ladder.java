import objectdraw.*;
import java.awt.*;

public class Ladder {
  
  public static final Color RUNG_COLOR = Color.BLACK;  // default color of ladder
  public static final double RUNG_SPACING = 28;  // gap between rungs in pixels
  public static final double L_WIDTH = 80; // width of the lader in pixels
  private double wantedLength;
  private double ladderLength = 0;
  private double length;
  private static final int X_POS = 20;
  static double yPos;
  static final double RUNG_SIZE = 7;
  static DrawingCanvas canvas;
  /**
   * Complete the constructor for the Ladder class to create a ladder using the 
   * constants RUNG_SPACING and L_WIDTH rungs. Your Ladder should be designed 
   * in such a way that it would be easy to change it to a different size in the 
   * future: i.e. use loops and constants and make sure that the left and right 
   * edges can extend as needed and more rungs added.  The ladder should reach the bottom of the canvas.
   */ 
  public Ladder (double length, DrawingCanvas canvas){
    new FilledRect(X_POS, 10, 10, length, canvas);
    new FilledRect(X_POS + L_WIDTH, 10, 10, length, canvas);
    
    ladderLength = 0;
    this.canvas = canvas;
    yPos = length - (RUNG_SPACING/2) + RUNG_SIZE;
    this.length = wantedLength;
    
    while ( yPos > (wantedLength + RUNG_SPACING/2)){
      new FilledRect (X_POS, yPos, L_WIDTH, RUNG_SIZE, canvas);
      yPos = yPos - RUNG_SPACING;
   }
      
  }
 

  
}