import objectdraw.*;
import java.awt.*;

/**
 * Class that draws a grassy scene
 */
public class Grass extends FrameWindowController {
    
    // level of the horizon
    private static final int GROUND_LINE = 270;
    
    // position and radius of the sun
    private static final int SUN_INSET = 50,      
                             SUN_SIZE = 75;

    // level and spacing of the blades of grass
    private static final int GRASS_TOP = 255,
                             GRASS_SPACING = 3;

/**       
  *  draw solid ground,sun and grass
  */
    public void begin() {
        new FilledRect(0, GROUND_LINE, canvas.getWidth(),
                       canvas.getHeight()-GROUND_LINE, canvas );
        new FilledOval(SUN_INSET, SUN_INSET, SUN_SIZE, SUN_SIZE,
                       canvas);
        
        // add the blades of grass
        double bladePosition = 0; // where to draw next blade of grass
        while ( bladePosition < canvas.getWidth() ) {
            new Line(bladePosition,GRASS_TOP,bladePosition,GROUND_LINE,
                     canvas);
            bladePosition = bladePosition + GRASS_SPACING;
        }
    }
}
