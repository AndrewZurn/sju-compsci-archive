import objectdraw.*;
import java.awt.*;

public class RainCloud extends ActiveObject {
    
    private static final int MAX_DROPS = 100;
    private static final int DELAY_TIME = 500;
    
    // the canvas on which drops will be drawn
    private DrawingCanvas canvas;
    // pool in which drops will be collected
    private FilledRect collector;
    
    public RainCloud(DrawingCanvas aCanvas, FilledRect aCollector) {
        
        // remember the canvas for dropping rain later
        canvas = aCanvas;
        // remember the collector
        collector = aCollector;

        // start the rain
        start();
    }
    
    public void run() {

        // will later generate random drop locations for rain
        RandomIntGenerator xGenerator = new RandomIntGenerator(0, canvas.getWidth());
        int dropCount = 0;
        // generate specified number of raindrops
        while (dropCount < MAX_DROPS) {
            new FallingDroplet(new Location(xGenerator.nextValue(), 0),
                            canvas, collector);
            pause(DELAY_TIME);
            dropCount++;
        }
    }
}
