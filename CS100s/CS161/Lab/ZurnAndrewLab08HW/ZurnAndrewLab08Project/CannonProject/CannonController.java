import objectdraw.*;
import java.awt.*;

public class CannonController extends FrameWindowController{
  
  private double velocity, angle;
  private static final double BALLSIZE = 20;
   
  public void onMouseClick(Location point){
    canvas.clear();

    angle=PopUpInput.getDouble("Please enter the angle the cannon shoots at in degrees.")/180*Math.PI;
    velocity=PopUpInput.getDouble("Enter the cannon ball's original velocity in meters per second.");
    
    new Cannon(0, canvas.getHeight() - BALLSIZE, velocity, angle, canvas);
    start();
    
    

  }
  
}