import objectdraw.*;
import java.awt.*;

/**
 * Class that allows a user to draw a grassy scene
 */
public class ClickGrass extends FrameWindowController {
  
  // level of the horizon
  private static final int GROUND_LINE = 270;
  
  // position and radius of the sun
  private static final int SUN_INSET = 50,      
    SUN_SIZE = 75;
  
  // level and spacing of the blades of grass
  private static final int GRASS_TOP = 255,
    GRASS_SPACING = 3;
  
  private final static Color SUN_COLOR = new Color(250,200,10);
  private final static Color GRASS_COLOR = new Color(100,250,10);
  
  private FilledOval sun;
  private double bladePosition; // x coordinate of next blade of grass
  private Line grassBlade;
  
  /** 
   * draw solid ground and sun
   */
  public void begin() {
    new FilledRect(0, GROUND_LINE, canvas.getWidth(),
                   canvas.getHeight()-GROUND_LINE, canvas );
    sun = new FilledOval(SUN_INSET, SUN_INSET, SUN_SIZE, SUN_SIZE,
                         canvas);
    sun.setColor(SUN_COLOR);
    bladePosition = 0;
  }
  /**
   * Add grass with a mouse click
   */
  public void onMouseClick(Location point) {
    
      new Line(bladePosition, GRASS_TOP, bladePosition, GROUND_LINE, 
               canvas);
      bladePosition = bladePosition + GRASS_SPACING;
  }
}
