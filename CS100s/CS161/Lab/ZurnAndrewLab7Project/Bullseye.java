import objectdraw.*;
import java.awt.*;

/**
 * class that displays a centered bullseye on the canvas
 */
public class Bullseye  {
  /**
   * space between two consecutive rings
   */
  private static final double RING_SPACE = 10;
  /**
   * total number of desired rings
   */
  private int NUMBER_OF_RINGS = 0;
  /**
   * diameter of outermost ring
   */
  private int LARGEST_RING = 120; 
  private FilledOval redBullseye;
  private FilledOval blackBullseye;


  public Bullseye (double x, double y, DrawingCanvas canvas){
    while (NUMBER_OF_RINGS < 6){
      if( NUMBER_OF_RINGS % 2 == 0){
        redBullseye = new FilledOval (x - 120, y - 120, LARGEST_RING, LARGEST_RING, canvas);
        LARGEST_RING = LARGEST_RING - 20;
        x = x + RING_SPACE;
        y = y + RING_SPACE;
        NUMBER_OF_RINGS = NUMBER_OF_RINGS + 1;
        redBullseye.setColor(Color.RED);
      }
      if (NUMBER_OF_RINGS % 2 == 1){
        blackBullseye = new FilledOval(x - 120, y - 120, LARGEST_RING, LARGEST_RING, canvas);
        LARGEST_RING = LARGEST_RING - 20;
        x = x + RING_SPACE;
        y = y + RING_SPACE;
        NUMBER_OF_RINGS = NUMBER_OF_RINGS + 1;
        blackBullseye.setColor(Color.BLACK);
      
    }
  }
    
  
  }
}



