import objectdraw.*;
import java.awt.*;
/**
 * A simple mouse driven text window that displays a text 
 * message when the mouse button is pressed.
 */
public class Measles extends FrameWindowController {
      private FilledOval dot;
      private Text message;

  /**
   * initiate the process with initial text
   */
  public void begin() {
    message = new Text("Click in this window to create measles", 20, 20, canvas);
    }
  
  /**
   * provide a message when the mouse enters the canvas
   */
  public void onMouseClick (Location pressPoint) {
    message.hide();
    dot = new FilledOval(pressPoint, 5, 5, canvas );
    dot.setColor(Color.red);
  }
  
  public void onMouseExit(Location exitPoint) {
    canvas.clear();
    new Text("You have been cured!", 50, 50, canvas);
  }
  
  public void onMouseEnter(Location entryPoint) {
    canvas.clear();
    message.show();
  }
}

