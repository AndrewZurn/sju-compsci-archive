import acm.util.*;
import java.awt.*;
import java.awt.event.*;
import acm.program.*;
import acm.graphics.*;

/**
 * This class extends Animator and creates a face that continues to bounce
 * around the graphics area of GraphicsProgram gp forever.
 * 
 * @author Lynn R. Ziegler
 */
public class BouncingSmiley extends Animator {
  /* Our face moves speedX in the x direction and speedY in the y direction
   * during each time unit. size is the size of the face. */
  private double speedX,speedY,size;
  /* We need to know the GraphicsProgram where the BouncingBall moves. */
  private GraphicsProgram gp;
  /* face is our BouncingSmiley. */
  
  private SmileyFace face;
  
  /**
   * Note that with Animation classes we MUST call the super() constructor
   * in every constructor. In this case, we save the speed and 
   * GraphicsProgram so the animation (in the run() method) can proceed at
   * that speed on that GraphicsProgram's canvas.
   */
  public BouncingSmiley(double x, double y, double size, double speedX, 
                      double speedY, GraphicsProgram gp) {
    super();
    this.gp=gp;
    this.speedX=speedX;
    this.speedY=speedY;
    this.size=size;
    face=new SmileyFace(x,y,size);
    gp.add(face);
  }
  
  /**
   * run() is where the action is. We have designed run() so that it bounces
   * faces off the walls as they move in a "realistic" way.
   */
  public void run() {
    pause(50);
    while(true) {
      double rightSide=gp.getWidth()-size;
      double bottom=gp.getHeight()-size;
      face.move(speedX,speedY);
      if(face.getX()<0) {
        speedX=-speedX;
        face.setLocation(-face.getX(),face.getY());
      }
      else if(face.getX()>rightSide) {
        speedX=-speedX;
        face.setLocation(2*rightSide-face.getX(),face.getY());
      }
      if(face.getY()<0) {
        speedY=-speedY;
        face.setLocation(face.getX(),-face.getY());
      }
      else if(face.getY()>bottom) {
        speedY=-speedY;
        face.setLocation(face.getX(),2*bottom-face.getY());
      }
      pause(50);
    }
  }
}