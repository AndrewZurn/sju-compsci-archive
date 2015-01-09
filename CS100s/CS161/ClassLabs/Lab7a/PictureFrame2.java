import objectdraw.*;
import java.awt.*;

/** 
 * Picture Frame on a canvas with a corner line.
 */
public class PictureFrame2  { 
  private static final double FRAME_WIDTH = 120;
  private static final double FRAME_HEIGHT = 180;
  private static final double EDGE = 10;
  private static final Color FRAME_COLOR = new Color(130, 130,40);
  private static final double LINE_SPACING = 5;
   
  private FilledRect outerFrame;
  private FilledRect innerFrame;
  
  
  public PictureFrame2(double leftSide, double top, DrawingCanvas canvas){
    
    outerFrame = new FilledRect(leftSide - EDGE, top - EDGE, FRAME_WIDTH + (2*EDGE), 
                                FRAME_HEIGHT+ (2*EDGE), canvas);
    outerFrame.setColor(FRAME_COLOR);
    innerFrame = new FilledRect(leftSide , top , 
                                FRAME_WIDTH , FRAME_HEIGHT, canvas);
    innerFrame.setColor(Color.white);
    new Line(leftSide - EDGE, top -EDGE, leftSide, top, canvas);
  }
}