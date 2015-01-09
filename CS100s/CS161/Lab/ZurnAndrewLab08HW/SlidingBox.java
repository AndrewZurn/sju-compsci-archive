import objectdraw.*;
import java.awt.*;

public class SlidingBox extends ActiveObject {
  
  private static final double BOXSIZE = 20;
  private static final double DELAY_TIME = 33;
  
  
  private FilledRect box;
  
  private DrawingCanvas canvas;
  private double xSpeed, ySpeed;
  
  public SlidingBox(Location boxLocation, double dx, double dy, DrawingCanvas aCanvas) {
    
    box = new FilledRect (boxLocation, dx, dy, BOXSIZE, BOXSIZE, aCanvas){
      canvas = aCanvas;
      start();
  }
  
  public void run() {
    while(
  }
}
