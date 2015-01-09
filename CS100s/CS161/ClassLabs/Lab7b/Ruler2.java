import objectdraw.*;
import java.awt.*;

// Class to draw a ruler
public class Ruler2 extends FrameWindowController {
  
  // location and dimensions of the ruler
  private static final double RULER_X = 20;
  private static final double RULER_Y = 20;
  private static final double RULER_LENGTH = 300;
  private static final double RULER_WIDTH = 40;
  private static final double LINE_LENGTH = 2;
  private static final double SPACING = 5;
  private static final double INCH_LENGTH = 12;
  private static final double HALFINCH_LENGTH = 8;
  private static final double QUARTERINCH_LENGTH = 4;
  
  public void begin(){
    double linePosition = RULER_X + SPACING;
    int lineCount = 1;
    
    new FramedRect (RULER_X, RULER_Y, RULER_LENGTH, RULER_WIDTH, canvas);
    
    while (linePosition < RULER_LENGTH + RULER_X){
      if (lineCount % 8 == 0){
        new Line (linePosition, RULER_Y + RULER_WIDTH, linePosition, RULER_Y + RULER_WIDTH - INCH_LENGTH, canvas);
      }
      else if (lineCount % 4 == 0){
        new Line(linePosition, RULER_Y + RULER_WIDTH, linePosition,  RULER_Y + RULER_WIDTH - HALFINCH_LENGTH, canvas);
      }
      else if (lineCount % 2 == 0){
        new Line(linePosition, RULER_Y + RULER_WIDTH, linePosition,  RULER_Y + RULER_WIDTH - QUARTERINCH_LENGTH, canvas);
      }
      
      else {
        
        
        new Line(linePosition, RULER_Y + RULER_WIDTH, linePosition, RULER_Y + RULER_WIDTH - LINE_LENGTH, canvas);
      }
      
      linePosition = linePosition + SPACING;
      lineCount ++;
    }
  }
}