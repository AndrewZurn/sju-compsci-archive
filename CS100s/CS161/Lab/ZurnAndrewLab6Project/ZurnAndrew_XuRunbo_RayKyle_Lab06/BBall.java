import objectdraw.*;
import java.awt.Color;

/**
 * Zurn, Andrew  Xu, Runbo  Ray, Kyle   BBall Class
 * A class that implements a nice looking basketball
 */ 

public class BBall {
  /**
   * the color to draw the ball
   */ 
  private static final Color BALL_ORANGE = new Color(250, 85, 10);
  /**
   * size and starting angles for cut arc in degrees
   */ 
  private static final int CUTSIZE = 100;
  private static final int RIGHTCUTSTART = 90 + (180 - CUTSIZE) / 2;
  private static final int LEFTCUTSTART = 270 + (180 - CUTSIZE) / 2;
  /**
   * the orange part of the ball
   */ 
  private FilledOval body;
  /**
   * the border of the ball
   */ 
  private FramedOval border;
  /**
   * the two curves on the sides of the ball
   */ 
  private FramedArc leftCut, rightCut;
  /**
   * the vertical and horizontal lines through the ball
   */ 
  private Line vert, horiz;  
  /**
   * initial coordinates of basketball
   */ 
  private double initX, initY;
  
  private double size;
  
  /**
   * Create a new basketball
   */ 
  public BBall(double left, double top, double size, DrawingCanvas aCanvas){
    // draw the circles that make it look like a ball
    body = new FilledOval(left, top, size, size, aCanvas);
    body.setColor(BALL_ORANGE);             
    border = new FramedOval(left, top, size, size, aCanvas);
    // draw the lines and arcs that make it look like a basketball
    rightCut = new FramedArc( left + size * 2 / 3, top,size, size,RIGHTCUTSTART, CUTSIZE, aCanvas);
    leftCut =  new FramedArc( left - size * 2 / 3, top,size, size,LEFTCUTSTART, CUTSIZE, aCanvas);
    vert =  new Line( left + size / 2, top,left + size / 2, top + size, aCanvas);
    horiz = new Line( left, top + size / 2,left + size, top + size / 2, aCanvas);
    
    // remember the ball's starting position
    initX = left;
    initY= top;
  }
  
  /**
   * move the ball by specified offsets
   */ 
  public void move(double dx, double dy){
    body.move(dx, dy);
    border.move(dx, dy);
    rightCut.move(dx, dy);
    leftCut.move(dx, dy);
    vert.move(dx, dy);
    horiz.move(dx, dy);
  }       
  
  /**
   * check to see if the ball contains a specified location
   */ 
  public boolean contains(Location point){
    return body.contains(point);
  }
  
  /**
   * move the ball to a specified position
   */ 
  public void moveTo(double x, double y) {
    // determine how far away (x,y) is and then use this.move(dx,dy) instead
    double dx, dy;
    dx = x - body.getX();
    dy = y - body.getY();
    this.move(dx, dy);
  }
  
  /**
   * return the ball to its starting position (initX, initY)
   */ 
  public void reset(){
    /*body.moveTo(initX, initY);
    border.moveTo(initX, initY);
    rightCut.moveTo(initX + size * 2/3, initY);
    leftCut.moveTo(initX - size * 2/3, initY);
    vert.moveTo(initX + size / 2, initY);
    horiz.moveTo(initX, initY + size / 2);
    */
    
    this.moveTo(initX, initY);
     
  }
  
  /**
   * return the x coordinate of ball's corner
   */ 
  public double getX(){ 
    return body.getX();
  }
  
  /**
   * return the y coordinate of ball's corner
   */ 
  public double getY(){
    return body.getY();   
  }
  
}
