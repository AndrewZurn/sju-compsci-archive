import objectdraw.*;
import java.awt.*;

public class TwoFaceDrag extends FrameWindowController {
    
    private static final int FACE_LEFT = 75,
                             FACE_TOP = 175,
                             FACE_GAP = 200;
    
    private Location startPoint = new Location(10, 10);
    
    private FunnyFace happy;       // Funny face in window
    
    private StraightFace straight; // Straight face in window
    
    private Movable dragged;      // Face chosen to be dragged

    private Location lastPoint;    // Point where mouse was last seen
    
    private boolean dragging;      // Whether should be dragging face
    
    // Make the faces
    public void begin() {
        happy = new FunnyFace(FACE_LEFT,FACE_TOP, canvas);
        straight = new StraightFace(FACE_GAP+FACE_LEFT,FACE_TOP, canvas);
    }
    
    // Save starting point and whether point was in one of faces --
    // and which one.
    public void onMousePress( Location point ) {
        lastPoint = point;
        
        if (happy.contains( point )) {
                dragged = happy;
                dragging = true;
        } else if (straight.contains ( point )) {
                dragged = straight;
                dragging = true;
        } else {
                dragging = false;
        }
        if (dragging){
          dragged.moveTo(startPoint);
        }
    }
    
    // if mouse is in a face, then drag it with the mouse
    public void onMouseDrag( Location point ) {
        if ( dragging ) {
            dragged.move( point.getX() - lastPoint.getX(),
                          point.getY() - lastPoint.getY() );
            lastPoint = point;
        }
    }
}
