
import objectdraw.*;
import java.awt.*;

/**
 * LadderTestingProgram
 */
public class CandleTest extends FrameWindowController{

    /**
     * Declare a Ladder
     */
    private Candle blueLight;
    private Location point = new Location(20, 50);
   
    
    public void begin() {
      
      // Create a new Candle   
      blueLight = new Candle(point, canvas);
      
    }
}
