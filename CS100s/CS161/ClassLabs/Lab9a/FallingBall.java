import objectdraw.*;
import java.awt.*;

public class FallingBall extends ActiveObject {
    
    // the size of the ball
    private static final int SIZE = 10;
    
    // the delay between successive moves of the ball
    private static final int DELAY_TIME = 33;
    // number of pixels ball falls in a single move
    private static final double Y_SPEED = 4;
    
    // the image of the ball
    private FilledOval ballGraphic;
    // the canvas
    private DrawingCanvas canvas;
    
    public FallingBall(Location initialLocation, DrawingCanvas aCanvas) {
        canvas = aCanvas;
        ballGraphic = new FilledOval(initialLocation, SIZE, SIZE, canvas);
        start();
    }
    
    public void run() {
        while (ballGraphic.getY() < canvas.getHeight() ) {
            ballGraphic.move(0, Y_SPEED);
            pause(DELAY_TIME);
        }
        ballGraphic.removeFromCanvas();
    }
}