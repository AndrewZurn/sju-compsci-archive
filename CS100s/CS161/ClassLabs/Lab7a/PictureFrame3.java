import objectdraw.*;
import java.awt.*;

/**
 * Picture Frame on a canvas with a loop of decorative lines on one side.
 **/ 
public class PictureFrame3  {
  
  private static final double FRAME_WIDTH = 120;
  private static final double FRAME_HEIGHT = 180;
  private static final double EDGE = 10;
  private static final Color FRAME_COLOR = new Color(180, 130,130);
  private static final double LINE_SPACING = 10;
   
  private FilledRect outerFrame;
  private FilledRect innerFrame;
  
  
  public PictureFrame3(double leftSide, double top, DrawingCanvas canvas){
    
    
    double linePosition = top;
    
    outerFrame = new FilledRect(leftSide - EDGE, top - EDGE, FRAME_WIDTH + (2*EDGE), 
                                FRAME_HEIGHT+ (2*EDGE), canvas);
    outerFrame.setColor(FRAME_COLOR);
    innerFrame = new FilledRect(leftSide , top , 
                                FRAME_WIDTH , FRAME_HEIGHT, canvas);
    innerFrame.setColor(Color.white);
    
    while (linePosition <= top + FRAME_HEIGHT) {
      
      new Line(leftSide - EDGE, linePosition, leftSide-1, linePosition, canvas);
      linePosition = linePosition + LINE_SPACING;
    }
  }
}