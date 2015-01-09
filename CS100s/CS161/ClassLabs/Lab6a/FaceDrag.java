import objectdraw.*;
import java.awt.*;

/**
 *  class to drag a funny face around.
 */
public class FaceDrag extends FrameWindowController {
  
  private static final int faceHeight = 60,  // location and dimensions of the face
    faceWidth = 60,
    FACE_LEFT = 170,
    FACE_TOP = 170;
  
  private static final int EYE_OFFSET = 20,   // eye location and size
    EYE_RADIUS = 8;
  
  private static final int MOUTH_HEIGHT = 10, // location and dimensions of the mouth
    mouthWidth = faceWidth/2,
    MOUTH_LEFT = FACE_LEFT+(faceWidth-mouthWidth)/2,
    MOUTH_TOP = FACE_TOP+2*faceHeight/3;
  
  private FramedOval head;              // head to be dragged
  private FramedOval mouth;             // mouth
  private FramedOval leftEye, rightEye; // eyes
  private Location lastPoint;    // point where mouse was last seen
  
  // whether the face has been grabbed by the mouse
  private boolean faceGrabbed = false;    
  
  /**
   *  make the face
   */
  public void begin() {
    head = new FramedOval(FACE_LEFT, FACE_TOP,
                          faceWidth, faceHeight, canvas);
    mouth = new FramedOval(MOUTH_LEFT, MOUTH_TOP,
                           mouthWidth, MOUTH_HEIGHT, canvas);
    leftEye = new FramedOval(FACE_LEFT+EYE_OFFSET-EYE_RADIUS/2, 
                             FACE_TOP+EYE_OFFSET, EYE_RADIUS, EYE_RADIUS, canvas);
    rightEye = new FramedOval(FACE_LEFT+faceWidth-EYE_OFFSET-EYE_RADIUS/2, 
                              FACE_TOP+EYE_OFFSET, EYE_RADIUS, EYE_RADIUS, canvas);
  }
  
  /**
   *  Save point where mouse pressed and whether point was in face
   */
  public void onMousePress(Location point) {
    lastPoint = point;
    faceGrabbed = head.contains(point);
  }
  
  /**
   *  if mouse is in face, then drag the face
   */
  public void onMouseDrag(Location point) {
    if ( faceGrabbed ) {
      head.move( point.getX() - lastPoint.getX(),
                point.getY() - lastPoint.getY() );
      leftEye.move( point.getX() - lastPoint.getX(),
                   point.getY() - lastPoint.getY() );
      rightEye.move( point.getX() - lastPoint.getX(),
                    point.getY() - lastPoint.getY() );
      mouth.move( point.getX() - lastPoint.getX(),
                 point.getY() - lastPoint.getY() );
      lastPoint = point;
    }
  }        
}
