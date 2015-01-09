import objectdraw.*;
import java.awt.*;

public class CrazyRectangle extends ActiveObject {
  
  private static final int STEP_SIZE = 4;
  private static final int DELAY_TIME = 33;
  
  private double xStep = STEP_SIZE;
  private double yStep = STEP_SIZE;
  private FilledRect rect, state;
  private DrawingCanvas canvas;
  
  
  public CrazyRectangle(double x, double y, double length, double width,Color color,FilledRect state, DrawingCanvas canvas) {
    this.canvas = canvas;
    this.state = state;
    rect = new FilledRect(x,y , length, width, canvas);
    rect.setColor(color);
    start();
  }
  
  public void run() {
    while (!rect.overlaps(state)) {
      //if we reach the leftmost or rightmost part of the canvas, change x-direction
      if (rect.getX() <= 0 || (rect.getWidth()+rect.getX()) >= canvas.getWidth()) {
        xStep = -xStep;
      }
      //if we reach the top or bottom of canvas, change y-direction
      if (rect.getY() <= 0 || (rect.getY()+rect.getHeight()) >= canvas.getHeight()) {
        yStep = -yStep;
      }
      //move rectangle
      rect.move(xStep, yStep);
      
      pause(DELAY_TIME);
    }
    //if this rect and the state rectangle overlap, announce this rect to be the winner,    
    //stop moving, and remove the state rectangle from canvas
    System.out.println("Code " + rect.getColor() + " won Minnesota ... LOSER!!!");
    state.removeFromCanvas();
  } 
}