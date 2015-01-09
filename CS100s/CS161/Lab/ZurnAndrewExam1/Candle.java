import objectdraw.*;
import java.awt.*;

public class Candle extends ActiveObject {
  
  public static final double CANDLE_HEIGHT = 100;  // Height of candle in pixels in pixels
  public static final double CANDLE_WIDTH = 20; // width of the candle in pixels
  public static final double FLAME_HEIGHT = 30;  // Height of flame in pixels in pixels
  public static final double FLAME_WIDTH = 15; // width of the flame in pixels
  private static final double DELAY_TIME = 2000;
  
  public FilledRect candleBody;
  public FilledOval flame;
  private static final int CANDLE_REPS = 200;
  private int numReps = 0;
  
  /**
   * class to display a candle on canvas
   */ 
  public Candle (Location point, DrawingCanvas canvas){
    double x = point.getX();
    double y = point.getY();
    candleBody = new FilledRect(x, y + FLAME_HEIGHT, CANDLE_WIDTH, CANDLE_HEIGHT, canvas);
    candleBody.setColor(Color.BLUE);
    flame = new FilledOval(x + (CANDLE_WIDTH - FLAME_WIDTH)/2, y, FLAME_WIDTH,FLAME_HEIGHT, canvas);
    flame.setColor(Color.ORANGE);
    start();
  }
  
  public void run(){  
    while ( numReps < CANDLE_REPS){
      if( numReps % 2 == 0){
        flame.setColor(Color.YELLOW);
        numReps = numReps + 1;
        pause(DELAY_TIME);
      }
      if( numReps % 2==1){
        flame.setColor(Color.ORANGE);
        numReps = numReps + 1;
        pause(DELAY_TIME);
      }
    }
    
    
    
    
    
  }
}
