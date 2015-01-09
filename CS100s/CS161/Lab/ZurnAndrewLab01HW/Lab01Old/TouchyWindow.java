import objectdraw.*;
import java.awt.*;
/**
 * A simple mouse driven text window that displays a text 
 * message when the mouse button is pressed.
 */
public class TouchyWindow extends FrameWindowController {
  
  /**
   * initiate the process with initial text
   */
  public void begin() {
    new Text("Click in this window.", 20, 20, canvas);
  }
  /**
   * provide a message when the mouse button is pressed
   */
  public void onMousePress (Location point) {
    canvas.clear();
    new Text("I'm touched", 40, 50, canvas );
  }
  
  /**
   * clear the canvas when the mouse button is released
   */
  public void onMouseRelease( Location point ) {
    canvas.clear();
  }
}


