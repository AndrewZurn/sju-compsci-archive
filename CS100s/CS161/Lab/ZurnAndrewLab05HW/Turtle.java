import objectdraw.*;
import java.awt.*;

public class Turtle {
  
  /**
   * body, head, leg1-leg4 are designed to be used to build the turtle.
   */
  private FilledOval body, head, leg1,leg2,leg3,leg4;

 /**
  * xPos, yPos are the turtle's position.
  */
  private double xPos,yPos;

  /**
   * constructor which takes x and y
   */
  public Turtle(double x, double y,DrawingCanvas canvas) {
    xPos=x;
    yPos=y;
    buildTurtle(canvas);
  }

  /**
   * another constructor which takes a point intead of x and y
   */
  public Turtle(Location p,DrawingCanvas canvas) {
    xPos=p.getX();
    yPos=p.getY();
    buildTurtle(canvas);
  }
  
  /**
   * a method which actually creates the turtle on the canvas
   */
  private void buildTurtle(DrawingCanvas canvas) {
    leg1=new FilledOval(xPos,yPos,5,10,canvas);
    body=new FilledOval(xPos-3,yPos+5,20,20,canvas);
    leg2=new FilledOval(xPos,yPos+19,5,10,canvas);
    leg3=new FilledOval(xPos+14,yPos,5,10,canvas);
    leg4=new FilledOval(xPos+14,yPos+19,5,10,canvas);
    head=new FilledOval(xPos+16,yPos+11,8,8,canvas);
  }
  
  /**
   * a mutator method to move the turtle
   */ 
  public void move(double x, double y) {
    xPos=xPos+x;
    yPos=yPos+y;
    leg1.move(x,y);
    leg2.move(x,y);
    leg3.move(x,y);
    leg4.move(x,y);
    body.move(x,y);
    head.move(x,y);
  }

  /**
   * a mutator method to change the color of the turtle
   */ 
  public void setColor(Color color){
    leg1.setColor(color);
    leg2.setColor(color);
    leg3.setColor(color);
    leg4.setColor(color);
    body.setColor(color);
    head.setColor(color);
  }

  /**
   * an accessor method which returns the X coordinate of the turtle
   */  
  public double getX() {
    return this.xPos;
  }

  /**
   * an accessor method which returns the Y coordinate of the turtle
   */
  public double getY() {
    return this.yPos;
  }

}