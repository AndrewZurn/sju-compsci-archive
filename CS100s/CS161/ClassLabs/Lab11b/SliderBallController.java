import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// Control speed of falling ball with slider
public class SliderBallController extends FrameWindowController 
                                  implements ChangeListener {
    
    private static final int SLOW_SPEED = -10,  // min speed
                             FAST_SPEED = 10;  // max speed
    
    private FallingBall droppedBall; // the falling ball
    
    private JSlider speedSlider;     // slider to set speed
    
    private int speed = (FAST_SPEED + SLOW_SPEED)/2;  // speed of ball
    
    // construct and add GUI items
    public void begin() {
        speedSlider = new JSlider( JSlider.VERTICAL, SLOW_SPEED,
                                   FAST_SPEED, (FAST_SPEED + SLOW_SPEED)/2 );
        speedSlider.addChangeListener ( this );

        Container contentPane = getContentPane();
        contentPane.add( speedSlider, BorderLayout.WEST );
        contentPane.validate();
    }
    
    // make a new ball when the player clicks
    public void onMouseClick( Location point ) {
        droppedBall = new FallingBall( point, speed, canvas );
    }
    
    // Get new speed from slider
    public void stateChanged( ChangeEvent evt ) {
        speed = speedSlider.getValue();
        if ( droppedBall != null ) {
            droppedBall.setSpeed( speed );
        }
    }
}
