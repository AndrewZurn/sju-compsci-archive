import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// Control speed of falling ball with labeled slider
public class LabelBallController extends FrameWindowController 
                                 implements ChangeListener {
                                 
    private static final int SLOW_SPEED = 2,  // min speed
                             FAST_SPEED = 6;  // max speed
                             
    private FallingBall droppedBall; // the falling ball
    
    private JSlider speedSlider;     // slider to set speed
    
    private int speed = SLOW_SPEED;  // speed of ball
            
    
    private JLabel speedLabel, titleLabel;   

    // construct and add GUI items
    public void begin() {
        JPanel southPanel = new JPanel();
        
        // construct label and slider, and add to southPanel
        titleLabel =new JLabel("SliderBall", JLabel.CENTER);
        speedLabel = new JLabel( "Use the slider to adjust the speed" );
        speedSlider = new JSlider( JSlider.HORIZONTAL, SLOW_SPEED,
                                   FAST_SPEED, SLOW_SPEED );
        southPanel.add( speedLabel );
        southPanel.add( speedSlider );
        
        // add the panel to south of window
        Container contentPane = getContentPane();
        contentPane.add( southPanel, BorderLayout.SOUTH );
        contentPane.add(titleLabel, BorderLayout.NORTH);
        contentPane.validate();
        
        // Add listener only for slider
        speedSlider.addChangeListener ( this );
    }
    
    //Make a new ball when the user clicks
    public void onMouseClick( Location point ) {
        droppedBall = new FallingBall( point, speed, canvas );
    }
    
    // Update speed from slider
    public void stateChanged( ChangeEvent evt ) {
        speed = speedSlider.getValue ();
//        if ( droppedBall != null ) {
            droppedBall.setSpeed( speed );
//        }
        speedLabel.setText( "The speed is " + speed );
    }  
}
