import objectdraw.*;
import java.awt.*;

/**  Program makes a FilledRect move from the upperleft corner to 
  *the lower right corner with each click.
  */
    
public class MoveRect extends FrameWindowController {
 // Put yur code here
  
  private FilledRect box;  //Rectangle identifier
  
  //Creates Blue Rect on screen
  public void begin() {
  box = new FilledRect ( 0,0, 50, 50, canvas);
  box.setColor( new Color(100,0,100) ); 
  }
  
  //Moves "box" to the bottom right corner
  public void onMouseClick (Location Point){
    box.move((canvas.getWidth()/20), (canvas.getHeight()/20));
  }
}