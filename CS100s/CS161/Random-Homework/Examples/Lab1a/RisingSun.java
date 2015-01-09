import objectdraw.*;
import java.awt.*;
/**
 * A mouse driven  window that displays a sun
 */
public class RisingSun extends FrameWindowController {
  private FilledOval sun;
  private Color lightPurple;
  
  public void begin () {
    lightPurple = new Color( 0, 0, 0);
    sun = new FilledOval(100,320,100,100,canvas);
    sun.setColor(lightPurple);
    new Text ("Please click on canvas repeatedly", 20, 20, canvas);
  }
  
  /**
   *Move the sun with each click 
   */
  public void onMouseClick (Location pressPoint) {
    
    sun.move(0, -5);
  }
  
  /**
   * reset sunset on mouse exit
   */
  public void onMouseExit( Location point ) {
    sun.moveTo(100, 320);
    
  }
}
