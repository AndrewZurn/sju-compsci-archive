import objectdraw.*;
import java.awt.*;

public class DropCollector extends FrameWindowController {

    // location of program instructions
    private static final Location INSTR_LOCATION = new Location(100,25);

    // ratio of canvas filled by the collector when the program starts
    private static final double COLLECTOR_RATIO = 0.0;
    
    private FilledRect collector;  // collects falling drops
    
    public void begin() {       
        // display instructions
        new Text("Click to make a falling raindrop...", INSTR_LOCATION, canvas);
        
        // construct a collector for the falling drops
        collector = new FilledRect(0, canvas.getHeight()-canvas.getHeight()*COLLECTOR_RATIO,
                                   canvas.getWidth(), canvas.getHeight() * COLLECTOR_RATIO, canvas);
    }
    
    public void onMouseClick(Location point) {
        // make a new droplet when the player clicks
        new FallingDroplet(point, canvas, collector);
    }
}
