import objectdraw.*;
import java.awt.*;
/**
 * A simple mouse driven text window that displays a text 
 * message when the mouse button is pressed.
 */
public class TouchyWindowThree extends FrameWindowController {
  
  /**
   * initiate the process with initial text
   */
  public void begin() {
    new Text("Click in this window.", 20, 20, canvas);
    new FilledOval(-20, 50, 70, 240, canvas);
    
    
               }
  /**
   * provide a message when the mouse button is pressed
   */
  public void onMouseEnter (Location point) {
   /* canvas.clear();
    * 
    */
    new Text("Hah", 190, 50, canvas );
  }
  
  /**
   * clear the canvas when the mouse button is released
   */
  public void onMouseExit( Location point ) {
    canvas.clear();
    new Text("Bye", 250, 250, canvas);
  }
}

