import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// demonstrates the family of classes which extend FramedDisplay
public class FrameMaker2 extends FrameWindowController {
  
  // coordinates and dimensions of the frame
  private static final double CORNER_X = 175;
  private static final double CORNER_Y = 100;
  private static final double HEIGHT = 30;
  private static final double WIDTH = 100;
  
  // what to put inside of a FramedText object
  private static final String LABEL = new String("Hello");
  private static final String LABEL2 = new String("Goodbye");
  
 
  public void begin() {
    FramedCounter fc = new FramedCounter(CORNER_X, CORNER_Y,
                                         WIDTH, HEIGHT, canvas);
    FramedText ft = fc;
    
   
    
    
    FramedText ft2 = new FramedText("Hello", CORNER_X, CORNER_Y+50,
                                    WIDTH, HEIGHT, canvas);
    
    FramedCounter fc2;

//Test 
    
    //  fc2 = ft2;
     // fc2 = ft;
   //  fc2 =(FramedCounter)ft2;
    
    if (ft2 instanceof FramedCounter){
      fc2 = (FramedCounter)ft2;
    }
    
    
  }
  
  
}


