import objectdraw.*;
import java.awt.*;

/**
 *  class to drag a funny face around - uses FunnyFace class.
 */
public class RevFaceDrag extends FrameWindowController {
  
  private static final int FACE_LEFT = 170, // location of FunnyFace
    FACE_TOP = 170;
  private static final Location FACE_POINT = new Location(FACE_LEFT, FACE_TOP);
  private FunnyFace happy, happy2;            // FunnyFace to be dragged
  
  private Location lastPoint;         // point where mouse was last seen
  
  // whether happy has been grabbed by the mouse
  private boolean happyGrabbed = false; 
  
  /**
   *  make the FunnyFace
   */
  public void begin() {
    happy = new FunnyFace(FACE_LEFT,FACE_TOP, canvas);
    //        happy = new FunnyFace(FACE_POINT, canvas);
    happy2 = new FunnyFace(FACE_LEFT + 80, FACE_TOP - 80, canvas);
  }
  
  /**
   *  Save starting point and whether point was in happy
   */
  public void onMousePress( Location point ) {
    lastPoint = point;
    happyGrabbed = happy.contains( point );
  }
  
  /**
   *  if mouse is in happy, then drag happy
   */
  public void onMouseDrag( Location point ) {
    if ( happyGrabbed ) {
      happy.move( point.getX() - lastPoint.getX(),
                 point.getY() - lastPoint.getY() );
      lastPoint = point;
    }
  }
}
