import objectdraw.*;
import java.awt.*;

public class WhatADrag extends FrameWindowController {
    
    // coordinates of original box location
    private static final double START_LEFT = 100;
    private static final double START_TOP = 100;

    // dimensions of box
    private static final double BOX_WIDTH = 150;
    private static final double BOX_HEIGHT = 150;
    
    private FilledRect box;       // box to be dragged

    private Location lastPoint;   // point where mouse was last seen
    
    // whether the box has been grabbed by the mouse
    private boolean boxGrabbed; 
    
    // make the box
    public void begin() {
        box = new FilledRect( START_LEFT, START_TOP,
                              BOX_WIDTH, BOX_HEIGHT, canvas );
    }
    
    // Save starting point and whether point was in box
    public void onMousePress( Location point ) {
        lastPoint = point;
        boxGrabbed = box.contains( point );
    }
    
    // if mouse is in box, then drag the box
    public void onMouseDrag( Location point ) {
        if ( boxGrabbed ) {
            box.move( point.getX() - lastPoint.getX(),
                      point.getY() - lastPoint.getY() );
            lastPoint = point;
        }
    }
}
