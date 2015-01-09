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
    new FilledOval(-20, 50, 70, 240, canvas);
    }
  
  /**
   * provide a message when the mouse enters the canvas
   */
  public void onMousePress (Location pressPoint) {
    canvas.clear();    
    new Text("Hah", pressPoint, canvas );
  }
  
  /**
   * clear the canvas when the mouse exits the canvas
   */
  public void onMouseRelease( Location releasePoint ) {
    canvas.clear();
    new Text("Bye", releasePoint, canvas);
  }
}

