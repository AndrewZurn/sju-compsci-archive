 import objectdraw.*;
import java.awt.*;

public class Craps extends FrameWindowController {

private static final double TEXT_LEFT = 10;   // x coord of text output
    private static final double STATUS_TOP = 70;  // y coord of status text
    private static final double MESSAGE_TOP = 50; // y coord of message text

    private boolean newGame = true;     // True if starting new game
    private Text status,                // Display status of game
                 message;               // Display dice roll value
    private int point;                  // number to roll for win
    // Generator for roll of a die
    private RandomIntGenerator dieGenerator = new RandomIntGenerator( 1,6 );
    
    // Create status and message on canvas
    public void begin() {
        status = new Text( "", TEXT_LEFT, STATUS_TOP, canvas );
        message = new Text( "", TEXT_LEFT, MESSAGE_TOP, canvas );
    }
    
    // For each click, roll the dice and report the results
    public void onMouseClick( Location pt ) {
        // get values for both dice and display sum
        int roll = dieGenerator.nextValue() + dieGenerator.nextValue();
        message.setText( "You rolled a " + roll + "!" );
        
        if ( newGame ) {                      // start a new game
            if ( roll == 7 || roll == 11 ) {  // 7 or 11 wins on first throw
                status.setText( "You win!" );
            }
            else if ( roll == 2 || roll == 3 || roll == 12 ) {  // 2, 3, or 12 loses
                status.setText( "You lose!" );
            }
            else {                      // Set roll to be the point to be made
                status.setText( "Try for your point!" );
                point = roll;
                newGame = false;         // no longer a new game
            }
        }
        else {                          // continue trying to make the point
            if ( roll == 7 ) {          // 7 loses when trying for point
                status.setText( "You lose!" );
                newGame = true;         // set to start new game
            }
            else if ( roll == point ) { // making the point wins!
                status.setText( "You win!" );
                newGame = true;
            }
            else {                      // keep trying
                status.setText( "Keep trying for " + point + " ..." );
            }
        }        
    }
}