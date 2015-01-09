import objectdraw.*;
import java.awt.*;
/**
 * A mouse driven text window that displays the sun 
 */
public class RisingSun3 extends FrameWindowController {
  private FilledOval sun;
  private Text instructions;
  
  public void begin () {
    
    sun = new FilledOval(canvas.getWidth()/4, 
                         canvas.getHeight() - canvas.getWidth()/4,
                         canvas.getWidth()/2,
                         canvas.getWidth()/2,
                         canvas);
    
    sun.setColor(Color.red);
    instructions = new Text ("Please click on canvas ", 0, 20, canvas);
    instructions.move( (canvas.getWidth() - instructions.getWidth())/2, 20);
  }
  
  /**
   *Move the sun with each click 
   */
  public void onMouseClick (Location mousePosition) {
    
    sun.moveTo(100, mousePosition.getY() );
  }
  
  /**
   * reset the canvas when the mouse exits
   */
  public void onMouseExit( Location point ) {
    sun.moveTo(100, 320);
    
  }
}