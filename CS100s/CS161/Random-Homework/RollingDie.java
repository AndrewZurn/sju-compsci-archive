import objectdraw.*;
import java.awt.*;

public class RollingDie extends FrameWindowController {
  private static final int TEXT_X=30;
  private static final int PROMPT_Y=30;
  private static final int RESULT_Y=100;
  
  private static final int NUM_SIDES=6;
  
  private RandomIntGenerator die=new RandomIntGenerator(1, 6);

  private Text result;
  
  private int roll1;
  private int roll2;
  
  public void begin() {
    new Text( "Click to make me roll the dice", TEXT_X, PROMPT_Y, canvas);
    result=new Text ("", TEXT_X, RESULT_Y, canvas);
  }
  
  public void onMouseClick (Location Point) {
    roll1=die.nextValue();
    roll2=die.nextValue();
    
    result.setText( "You rolled a " + roll1 + " and a " + roll2 + " for a total of " + (roll1 + roll2) );
  }
  
}


