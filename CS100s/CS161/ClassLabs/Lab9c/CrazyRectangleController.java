import objectdraw.*;
import java.awt.*;


public class CrazyRectangleController extends FrameWindowController {
  
  private static final double DEM_HEIGHT = 40;
  private static final double DEM_WIDTH = 40;
  
  private static final double REP_HEIGHT = 110;
  private static final double REP_WIDTH = 25;
  
  private  CrazyRectangle rep, dem;
  private FilledRect minnesota;
  
  private RandomIntGenerator positioner;

  public void begin() {
    positioner= new RandomIntGenerator(0,canvas.getWidth());
    minnesota = new FilledRect(positioner.nextValue(),positioner.nextValue(), 10,10,canvas);
  }
  
  public void onMouseClick(Location point){
    rep = new CrazyRectangle (positioner.nextValue(),positioner.nextValue(),REP_WIDTH, REP_HEIGHT,Color.RED, minnesota, canvas);
    dem = new CrazyRectangle (positioner.nextValue(),positioner.nextValue(),DEM_WIDTH,DEM_HEIGHT,Color.BLUE,minnesota,canvas);
  }
  
}