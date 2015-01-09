import objectdraw.*;
import java.awt.*;

/**
 * Picture Frame to be put on a canvas.
 */
public class PictureFrame  { 
  
  //Frame size information
  private static final double FRAME_WIDTH = 120;
  private static final double FRAME_HEIGHT = 180;
  private static final double EDGE = 10; //width of frame edge
  private static final Color FRAME_COLOR = new Color(130, 30,40);
  private RandomIntGenerator randomColor;
  
  
  
  private FilledRect outerFrame;
  private FilledRect innerFrame;
  
  
  public PictureFrame(double leftSide, double top, DrawingCanvas canvas){
    
    outerFrame = new FilledRect(leftSide - EDGE, top - EDGE, FRAME_WIDTH + (2*EDGE), 
                                FRAME_HEIGHT+ (2*EDGE), canvas);
    outerFrame.setColor(FRAME_COLOR);
    innerFrame = new FilledRect(leftSide , top , 
                                FRAME_WIDTH , FRAME_HEIGHT, canvas);
    innerFrame.setColor(Color.white);
  }
  
  public void move(double dx, double dy){
    outerFrame.move(dx, dy);
    innerFrame.move(dx, dy);
  }
  
  public void setColor(Color newColor){
    outerFrame.setColor(newColor);
  }
  
  /*public void moveTo(double x, double y){
    outerFrame.moveTo( x, y);
    innerFrame.moveTo( x + 10, y + 10);
  }*/
  
  public void moveTo(Location movePoint){
    outerFrame.moveTo(movePoint.getX()-10, movePoint.getY()-10);
    innerFrame.moveTo(movePoint);
  }
}
  
