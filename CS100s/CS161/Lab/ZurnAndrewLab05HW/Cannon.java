import objectdraw.*;
import java.awt.*;
/**
 * A Cannon program that allows us to compute and display the height of the ball after t seconds, 
 * the horizontal distance travelled by the ball after t seconds, time needed for ball to hit ground, 
 * and distance needed for ball  to hit ground
 * 
 * @author Zurn, Andrew;  Xu, Runbo;Bruening,Robert
 */

public class Cannon extends FrameWindowController{
/**
 * Here are the constants that you need. 
 * Give them initial values and use them to test your program
 * No instance variables are required
 */
  private static final double VEL_0 = 15 ;
  private static final double ANGLE = 1 ;
  private static final double TIME = 2 ;
  private static final double GRAVITY = 9.8 ;
  private double height;
  private double v0, t, A;

/**
 * initiate the screen   
 */
  public void begin() {
    
    
  }
  
  /**
   * Here is an example of one of the cannon functions - height
   */
  public double height(double v0, double A, double t) {
    //put your code here...remember, all four  methods are accessors and MUST return certain values
    return v0*Math.sin(A)*t - (1.0/2.0)*GRAVITY*t*t;
    
  }
  
  public double horiz(double v0, double A, double t) {
    return v0*Math.cos(A)*t;
  }
  
  public double timeToHit (double v0, double A){
    return 2*v0*Math.sin(A)/GRAVITY;
  }
  
  public double distanceToHit(double v0, double A){
    return v0*Math.cos(A)*this.timeToHit(v0, A);
      //2*v0*Math.sin(A)/GRAVITY;
  }
  /**
   * Display the results of the cannon functions with Text in onMouseClick
   * e.g. new Text("Height is " + this.height(VEL_0, ANGLE, TIME), 40, 80, canvas);
   */
  public void onMouseClick(Location point){
    new Text(" The Height is " + this.height(VEL_0 , ANGLE, TIME)+ " meters", 40, 40, canvas);
    new Text(" The horiz is " + this.horiz(VEL_0 , ANGLE, TIME) + " meters", 40, 60, canvas);
    new Text(" The time is " + this.timeToHit(VEL_0 , ANGLE)+ " seconds", 40, 120, canvas);
    new Text(" The distance is " + this.distanceToHit(VEL_0 , ANGLE) + " meters", 40, 140, canvas);
  }
  
}