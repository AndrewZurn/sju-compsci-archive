import objectdraw.*;
import java.awt.*;

// Draws broccoli on the screen and allows user to drag it around
public class BroccoliDrag extends FrameWindowController {

    private static final Location ROOT_LOCN = new Location(200,375);
    private static final double START_STEM = 100.0;

    private Location lastCoords;  // Where mouse was before last move
    
    private BroccoliPart plant;   // Broccoli object to be drawn & moved
    
    private boolean broccoliPressed; // whether the broccoli has been pressed
    
    // Create the broccoli
    public void begin() {
        plant = new Broccoli( ROOT_LOCN, START_STEM, Math.PI/2.0, canvas );
    }
    
    // Get ready to move broccoli
    public void onMousePress( Location pt ) {
        lastCoords = pt;
        broccoliPressed = plant.contains( pt );
    }
    
    // Drag the broccoli around
    public void onMouseDrag( Location pt ) {
        if ( broccoliPressed ) {
            plant.move( pt.getX()-lastCoords.getX(), pt.getY()-lastCoords.getY() );
            lastCoords = pt;
        }
    }
    
}
