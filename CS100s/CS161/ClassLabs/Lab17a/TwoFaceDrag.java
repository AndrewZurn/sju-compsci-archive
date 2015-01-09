import objectdraw.*;
import java.awt.*;

public class TwoFaceDrag extends FrameWindowController {
    
    private static final int FACE_LEFT = 75,
                             FACE_TOP = 175,
                             FACE_GAP = 200;
    
    private FunnyFace happy;       // Funny face in window
    
    private TopHatFace straight; // Straight face in window
    
    private FunnyFace dragged;      // Face chosen to be dragged
    private TopHatFace dragged2;
    private Location lastPoint;    // Point where mouse was last seen
    
    private boolean dragging;      // Whether should be dragging face
    
    // Make the faces
    public void begin() {
        happy = new FunnyFace(FACE_LEFT,FACE_TOP, canvas);
        straight = new TopHatFace(FACE_GAP+FACE_LEFT,FACE_TOP, canvas);
    }
    
    // Save starting point and whether point was in one of faces --
    // and which one.
    public void onMousePress( Location point ) {
        lastPoint = point;
        
        if (happy.contains( point )) {
                dragged = happy;
                dragged2 = (TopHatFace)dragged;
                dragging = true;
        } else if (straight.contains ( point )) {
                dragged = straight;
                dragged2 = (TopHatFace)dragged;
                dragging = true;
        } else {
                dragging = false;
        }
    }
    
    // if mouse is in a face, then drag it with the mouse
    public void onMouseDrag( Location point ) {
        if ( dragging ) {
            dragged2.move( point.getX() - lastPoint.getX(),
                          point.getY() - lastPoint.getY() );
            lastPoint = point;
        }
    }
}
