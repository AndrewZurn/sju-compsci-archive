0import objectdraw.*;
import java.awt.*;

/** 
 * A program to simulate the rolling of a pair of dice.
 */
 
public class RollAnotherOne extends FrameWindowController {
    
        // Coordinates to determine positions of text displayed
    private static final int TEXT_X = 30;
    private static final int PROMPT_Y = 30;
    private static final int RESULT_Y = 100;
    
    
        // The object that represents a single die
    private RandomIntGenerator die =  new RandomIntGenerator( 1, 6);
    
        // A Text message updated to describe each simulated roll
    private Text result;
    
        // value of each die on a given roll
    private int roll1;
    private int roll2;
    
        // Display a prompt and create the Text used to display the results
    public void begin() {
        new Text( "Click to make me roll the dice", 
                  TEXT_X, PROMPT_Y, canvas );
        result = new Text( "", TEXT_X, RESULT_Y, canvas );
    }
    
        // Roll the dice with each click
    public void onMouseClick(Location point) {
        roll1 = die.nextValue();
        roll2 = die.nextValue();
        
        result.setText("You rolled a " + roll1 +  " and a " + roll2 +
                       " for a total of " + ( roll1+roll2) );
    }   
}
