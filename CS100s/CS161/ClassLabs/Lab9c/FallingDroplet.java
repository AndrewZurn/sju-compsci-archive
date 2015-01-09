import objectdraw.*;
import java.awt.*;

public class FallingDroplet extends ActiveObject {
    
    // the size of the droplet
    private static final int SIZE = 10;
    
    // the delay between successive moves of the droplet
    private static final int DELAY_TIME = 33;
    // number of pixels droplet falls in a single move
    private static final double Y_SPEED = 4;
    
    private FilledOval dropletGraphic; // the droplet
    
    // collector into which droplet falls
    private FilledRect collector;

    public FallingDroplet(Location initialLocation, DrawingCanvas canvas,
                          FilledRect aCollector) {
        
        // draw the droplet
        dropletGraphic = new FilledOval(initialLocation, SIZE, SIZE, canvas);
        
        // remember the collector for later
        collector = aCollector;

        // start the motion of the droplet
        start();
    }
    
    public void run() {

        while (dropletGraphic.getY() < collector.getY() ) {
            dropletGraphic.move(0, Y_SPEED);
            pause(DELAY_TIME);
        }

        dropletGraphic.removeFromCanvas();
        if (collector.getY() > 0) {
            collector.setHeight(collector.getHeight() + SIZE/4);
            collector.move(0, -SIZE/4);
        }
    }
}
