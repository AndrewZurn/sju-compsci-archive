import objectdraw.*;
import java.awt.*;
/**
 * A mouse driven window that displays a sun
 */
public class RisingSun2 extends FrameWindowController {
  private FilledOval risingSun;
  
  public void begin () {
    risingSun = new FilledOval(100,320,100,100,canvas);
   risingSun.setColor(Color.red);
    new Text ("Please click on canvas repeatedly", 20, 20, canvas);
  }
  
  /**
   *Move the sun with each click 
   */
  public void onMouseClick (Location mousePosition) {
    
    risingSun.moveTo(mousePosition.getX(), mousePosition.getY() );
  }
  
  /**
   * reset the canvas when the mouse exits
   */
  public void onMouseExit( Location point ) {
      risingSun.moveTo(100,320);
   
  }
}