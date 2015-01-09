import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// demonstrates the family of classes which extend FramedDisplay
public class FrameMaker3 extends FrameWindowController {
  
  // coordinates and dimensions of the frame
  private static final double CORNER_X = 175;
  private static final double CORNER_Y = 100;
  private static final double HEIGHT = 30;
  private static final double WIDTH = 100;
  
  // what to put inside of a FramedText object
  private String label = new String("Hello");
  private  String label2 = new String("Goodbye");
  private FramedText ft  ;
   private FramedText ft2; 
 
  public void begin() {
   
     ft = new FramedText(label, CORNER_X, CORNER_Y,
                                    WIDTH, HEIGHT, canvas);
    
    ft2 = ft;
    }
    
    public void onMouseClick( Location point) {
      ft2.move(0,100);
    
    
  }
  
  
}


