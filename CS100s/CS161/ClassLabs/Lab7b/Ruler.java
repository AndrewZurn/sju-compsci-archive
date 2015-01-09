 import objectdraw.*;
import java.awt.*;

// Class to draw a ruler
public class Ruler extends FrameWindowController {
    
    // location and dimensions of the ruler
    private static final double RULER_X = 20;
    private static final double RULER_Y = 20;
    private static final double RULER_LENGTH = 300;
    private static final double RULER_WIDTH = 40;
    private static final double LINE_LENGTH = 4;
    private static final double SPACING = 5;
    private static final double INCH_LENGTH = 8;
    
    private double LINE_POSITION = 0;
    private static final double INCH_SPACING = 20;
    private double INCH_POSITION = 0;
    
   
    public void begin() {
        new FramedRect (RULER_X, RULER_Y, RULER_LENGTH, RULER_WIDTH, canvas);
        
      while (LINE_POSITION < RULER_LENGTH){
        new Line ( RULER_X + LINE_POSITION, RULER_Y, RULER_X + LINE_POSITION, RULER_Y + LINE_LENGTH, canvas);
        LINE_POSITION = LINE_POSITION + SPACING;
        
        while (INCH_POSITION < RULER_LENGTH){
        new Line ( RULER_X + INCH_POSITION, RULER_Y, RULER_X + INCH_SPACING, RULER_Y + INCH_LENGTH, canvas);
        INCH_POSITION = INCH_POSITION + 20;
        }
        
      }   
      
    }     
}
