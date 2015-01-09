 import objectdraw.*;
import java.awt.*;

public class DiceGame extends FrameWindowController {

private static final double TEXT_LEFT = 10;   // x coord of text output
    private static final double STATUS_TOP = 70;  // y coord of status text
    private static final double MESSAGE_TOP = 50; // y coord of message text

    private boolean newGame = true;     // True if starting new game
    private Text status,                // Display status of game
                 message;               // Display dice roll value
    private int point;                  // number to roll for win
    // Generator for roll of a die
    private RandomIntGenerator dieGenerator = new RandomIntGenerator( 1,6 );
    
    private int score;
    
    // Create status and message on canvas
    public void begin() {
        status = new Text( "", TEXT_LEFT, STATUS_TOP, canvas );
        message = new Text( "", TEXT_LEFT, MESSAGE_TOP, canvas );
        score = 0;
    }
    
    // For each click, roll the dice and report the results
    public void onMouseClick( Location pt ) {
        // get values for both dice and display sum
        int roll = dieGenerator.nextValue() + dieGenerator.nextValue();
        message.setText( "You rolled a " + roll + "!" );
        status.setText ( "Your score is " + score + "!");
        
        if ( roll <= 5){
          //( roll == 2 || roll == 3 || roll == 4 || roll == 5){
          score = score + 2;
          status.setText ( "Your score is " + (score ) + "!");
        }
        else if ( roll <=8 ){
          //(roll == 6 || roll == 7 || roll == 8){
            score = score + 3;
            status.setText ( "Your score is " + (score) + "!");
          }
          
        else if ( roll <= 11){
          //( roll == 9 || roll == 10 || roll == 11 || roll == 12){
            score = (score - 5);
            status.setText ( "Your score is " + (score) + "!");
        }
            
            else if ( roll == 12){
              score = 0;
                status.setText ( "Your score is " + (score) + "!");
            }
    }
    
    public void onMouseExit (Location point){
      canvas.clear();
      status = new Text( "Your score is", TEXT_LEFT, STATUS_TOP, canvas );
      message = new Text ( " ", TEXT_LEFT, MESSAGE_TOP, canvas);
    }
}