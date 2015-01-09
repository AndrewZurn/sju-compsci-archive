import objectdraw.*;
import java.applet.AudioClip;

// class to animate the bouncing of a ball
public class Dribbler extends ActiveObject {
    
    // number of times to move the ball before it changes direction
    private static final int MOVES = 9;
    
    private static final double MOVESIZE = 8.6;  // how far to move each time
    private static final int DELAY = 35;         // delay between moves
    
    private VisibleImage ball;
    private boolean moving;
    
    public Dribbler( VisibleImage theBall)
    {
        ball = theBall;
        moving = true;
        this.start();
    }
    
    // stop moving the ball
    public void stopDribbling()
    {
        moving = false;
    }
    
//Move the ball up and down
	public void run()
    {
        
        while ( moving ) {
            int moveCount;
            
            // make the ball bounce down
            moveCount = 0;
            while ( moveCount < MOVES && moving)
                {
                    ball.move(0, MOVESIZE);
                    pause( DELAY );
                    moveCount ++;
                }
            
            
            // make the ball bounce up
            moveCount = 0;
            while ( moveCount < MOVES && moving)
                {
                    ball.move(0,-MOVESIZE);
                    pause( DELAY );
                    moveCount ++;
                }
        }
    }
}
