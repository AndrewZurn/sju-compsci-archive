import objectdraw.*;
import java.awt.*;

/** class to display a PictureFrame.
  * 
  */
public class FrameJob extends FrameWindowController {
  
  private static final int FACE_LEFT = 30, // location of PictureFrame
    FACE_TOP = 30;
  private static final int SHIFT = 10;
  private static final Location FACE_POINT = new Location(FACE_LEFT, FACE_TOP);
  
  private PictureFrame woodFrame;
  public void begin() {
    woodFrame = new PictureFrame(FACE_LEFT, FACE_TOP, canvas);
  }
  
  public void onMouseClick(Location point) {
   woodFrame.move( SHIFT, 2 * SHIFT);
  }
  
  public void onMouseExit (Location point){
    woodFrame.setColor (Color.BLUE);
 }  
}
