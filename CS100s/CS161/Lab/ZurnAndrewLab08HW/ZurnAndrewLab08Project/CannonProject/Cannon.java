import objectdraw.*;
import java.awt.*;

//Zurn, Andrew     Cannon class

public class Cannon extends ActiveObject {
  
  private FilledOval ball;
  
  /**
   * size of the cannonball and speed of simulation
   */ 
  private static final int BALLSIZE=20;
  private static final int DELAY_TIME=30;
  /**
   * Here is the accelaration of gravity in meters per second
   */ 
  private final double G=9.8;
  
  /**
   * Here is the value of DT, our small interval we are calculating at.
   */
  private static final double DT=0.1;
  
  /**
   * Here are the internal variables for the class
   */ 
  private double elapsedTime;
  private double verticalVelocity, horizontalVelocity;
  private double verticalPosition, horizontalPosition;
  private double dy, dx;
  private DrawingCanvas canvas;
  private double xPosition, yPosition, v0, A;
  
  public Cannon(double x, double y, double v0, double A, DrawingCanvas canvas){
    this.canvas = canvas;
    this.v0=v0;
    this.A=A;
    ball = new FilledOval(0, canvas.getHeight() - BALLSIZE, BALLSIZE, BALLSIZE, canvas);
    verticalVelocity=v0*Math.sin(A);
    horizontalVelocity=v0*Math.cos(A);
    xPosition = 0;
    yPosition = canvas.getHeight() - BALLSIZE;
    start();
  }
  
  public double timeToHit(double v0, double A) {
    return(2*v0*Math.sin(A)/G);
  }
  
  
  public void run(){
    
    
    //Time elapsed so far
    elapsedTime = System.currentTimeMillis();
    
    
    //while the ball is above the lower edge of the canvas
    while(ball.getY() <= canvas.getHeight() -BALLSIZE){
      //distance to move in the x and y directions after DT seconds
      dx = horizontalVelocity*DT;
      dy = -verticalVelocity*DT;
      
      xPosition += dx;
      yPosition += dy;
      
      ball.move(dx, dy);
      
      verticalVelocity -= G*DT;
      pause(DELAY_TIME);
    }
    
    System.out.println("The Elapsed Time Was " +timeToHit(v0, A) + " seconds");
    System.out.println("The Horizontal Velocity upon impact was " + horizontalVelocity + " meters/second" );
    System.out.println("The Vertical Velocity upon impact was " + verticalVelocity + " meters/second" );
    System.out.println("The Position of the Ball upon impact was " + xPosition + " meters");
 
  }
}

