import objectdraw.*;
import java.awt.*;
/**
 * A simple mouse driven text window that displays a text 
 * message when the mouse button is pressed.
 */
public class MyTouchyWindow extends FrameWindowController {
  
  /**
   * initiate the process with initial text
   */
  public void begin() {
    new Text("Click in this window.", 20, 20, canvas);
    new FilledOval(120, 150, 60, 140, canvas);
     
    
               }
  /**
   * provide a message when the mouse button is pressed
   */
  public void onMouseClick (Location point) {
    canvas.clear();
    
    
    new Text("Hah", 100, 150, canvas );
  }
}

