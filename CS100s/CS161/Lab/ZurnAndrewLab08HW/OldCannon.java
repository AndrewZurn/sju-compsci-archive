import objectdraw.*;
import java.awt.*;
import javax.swing.*;
/**
 * A cannon program
 */

public class OldCannon extends FrameWindowController{
   // Force of gravity
   private static final double G=9.8;
   
   private double velocity,angle;
   
//methods to calculate various pieces of information
  public double height(double v0,double a, double t) {
    return(v0*Math.sin(a)*t-G*t*t/2.0);
  }
  public double horiz(double v0,double a, double t) {
    return(v0*Math.cos(a)*t);
  }
  public double timeToHit(double v0, double a) {
    return(2*v0*Math.sin(a)/G);
  }
  public double cannonDistance(double v0, double a) {
    return(horiz(v0,a,timeToHit(v0,a)));
  }
  
  public double verticalVelocity(double v0, double a) {
    return(v0*Math.sin(a)-G*timeToHit(v0,a));
  }
  /**
   * On click, the cannon "fires" and we ask for the user to enter the angle of the
   * cannon and the velocity of the cannonball and, then, print out how long it
   * takes before the cannonball hits the ground and how far it travels.
   */
  public void onMouseClick(Location point){
    canvas.clear();
    new FilledRect(0,0,canvas.getWidth(),canvas.getHeight(),canvas).setColor(Color.YELLOW);
    angle=PopUpInput.getDouble("Please enter the angle the cannon shoots at in degrees.")/180*Math.PI;
    velocity=PopUpInput.getDouble("Enter the cannon ball's original velocity in meters per second.");
    new Text("A cannon ball which is shot from a cannon at an angle of "+(angle*180/Math.PI)+" degrees",20,20,canvas).setColor(Color.BLUE);
    new Text("and at an initial velocity of "+velocity+" meters per second",20,40,canvas).setColor(Color.BLUE);
    new Text("will hit the ground in "+timeToHit(velocity,angle)+" seconds",20,60,canvas).setColor(Color.BLUE);
    new Text("at a distance of "+cannonDistance(velocity,angle)+" meters from the cannon.",20,80,canvas).setColor(Color.BLUE);
    new Text("and with a vertical velocity of "+verticalVelocity(velocity,angle)+".", 20,100,canvas).setColor(Color.BLUE);
  }
  
}
