
import objectdraw.*;
import java.awt.*;

/**
 * LadderTestingProgram
 */
public class LadderTest extends FrameWindowController{

    /**
     * Declare a Ladder
     */
    private Ladder safetyLadder;
    private double length = 200;
   
    
    public void begin() {
      
      // Create a new Ladder   
      safetyLadder = new Ladder(length, canvas);
      
    }
}
