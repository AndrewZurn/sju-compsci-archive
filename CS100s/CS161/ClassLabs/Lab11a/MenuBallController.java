import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Menu controls speed of falling ball
public class MenuBallController extends FrameWindowController implements ActionListener {
    
    // location of instructions
    private Location INSTR_LOCATION = new Location(canvas.getWidth()/2,25);
    
    private static final int SLOW_SPEED = 2,   // slow setting
                             MEDIUM_SPEED = 4, // medium setting
                             FAST_SPEED = 6;   // fast setting
    
    private FallingBall droppedBall; // the falling ball
    
    private JComboBox speedChoice;   // Combo box to select ball speed
    private int speed;               // Current speed setting
    
    // display instructions and combo box
    public void begin() {
        new Text( "Click to make a falling ball...", INSTR_LOCATION, canvas );

        speed = SLOW_SPEED;

        speedChoice = new JComboBox();         //construct combo box
        
        speedChoice.addItem ( "Slow" );        // Add 3 entries
        speedChoice.addItem ( "Medium" );
        speedChoice.addItem ( "Fast" );
        speedChoice.setSelectedItem( "Slow" ); // Display "Slow" initially

        speedChoice.addActionListener ( this );    // this class is listener
        
        Container contentPane = getContentPane(); // Add combo box to south
        contentPane.add( speedChoice, BorderLayout.SOUTH );
        contentPane.validate();
    }
    
    // make a new ball when the player clicks
    public void onMouseClick( Location point ) {
        droppedBall = new FallingBall( point, speed, canvas );
    }
    
    // reset ball speed from combo box setting
    public void actionPerformed( ActionEvent evt ) {
        Object newLevel = speedChoice.getSelectedItem ();
        if ( newLevel.equals( "Slow" )) {
            speed = SLOW_SPEED;
        } else if ( newLevel.equals( "Medium" )) {
            speed = MEDIUM_SPEED;
        } else if ( newLevel.equals( "Fast" )) {
            speed = FAST_SPEED;
        }
        if ( droppedBall != null ) {
        droppedBall.setSpeed( speed );
        }
    }
}
