import objectdraw.*;
import java.awt.*;

public class BoxController extends FrameWindowController {
  
    /**
     * location of program instructions
     */ 
    private static final Location INSTR_LOCATION = new Location(100,25);
    private static final double SPEED_X = 3;
     private static final double SPEED_Y = 4;
    /**
     * program instructions
     */
    private Text instructions;
    
    public void begin() {       
        // display instructions
        instructions = new Text("Click to make a box that moves", INSTR_LOCATION, canvas);
        
    }
    
    
    public void onMouseClick(Location point) {
      // hide the instructions and make the SlidingBox
      instructions.hide();
      new SlidingBox(point, SPEED_X, SPEED_Y, canvas);
    }
}