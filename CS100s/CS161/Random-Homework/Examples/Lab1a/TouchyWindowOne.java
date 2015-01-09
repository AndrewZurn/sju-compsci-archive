import objectdraw.*;
import java.awt.*;
/**
 * A simple mouse driven text window that displays a text 
 * message when the mouse button is pressed.
 */
public class TouchyWindowOne extends FrameWindowController {
               
  /**
   * provide a message when the mouse button is pressed
   */
  public void onMousePress (Location point) {
   /* canvas.clear();
    * 
    */
    new Text("Hah", 190, 50, canvas );
  }
  
  /**
   * clear the canvas when the mouse button is released
   */
  public void onMouseRelease( Location point ) {
    canvas.clear();
    new Text("Bye", 250, 250, canvas);
  }
}

