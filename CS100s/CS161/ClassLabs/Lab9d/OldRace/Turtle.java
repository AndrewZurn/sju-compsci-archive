import objectdraw.*;
import java.awt.*;

public class Turtle extends ActiveObject {
  
  /*
   * body, head, leg1-leg4 are designed to be used to build the turtle.
   * xPos, yPos are the turtle's position.
   */
  private FilledOval body, head, leg1,leg2,leg3,leg4;
  private double xPos,yPos;
  private double end;
  private double delay=100;
  private RandomIntGenerator turtleMoves=new RandomIntGenerator(5,10);
  
  public Turtle(double x, double y,double finish,DrawingCanvas canvas) {
    xPos=x;
    yPos=y;
    buildTurtle(canvas);
    end=finish;
    start();
  }
  
  public Turtle(Location p,DrawingCanvas canvas) {
    xPos=p.getX();
    yPos=p.getY();
    buildTurtle(canvas);
    
  }
  
  public void run(){
    pause(500);
    while (head.getX()+8<end){
      this.move(turtleMoves.nextValue(), 0);
      pause(delay);
    }
  }
  
  private void buildTurtle(DrawingCanvas canvas) {
    leg1=new FilledOval(xPos,yPos,5,10,canvas);
    body=new FilledOval(xPos-3,yPos+5,20,20,canvas);
    leg2=new FilledOval(xPos,yPos+19,5,10,canvas);
    leg3=new FilledOval(xPos+14,yPos,5,10,canvas);
    leg4=new FilledOval(xPos+14,yPos+19,5,10,canvas);
    head=new FilledOval(xPos+16,yPos+11,8,8,canvas);
    this.setColor(Color.GREEN);
  }
  

  
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
  
  public void setColor(Color color){
    leg1.setColor(color);
    leg2.setColor(color);
    leg3.setColor(color);
    leg4.setColor(color);
    body.setColor(color);
    head.setColor(color);
  }
  
  public double getX() {
    return xPos;
  }
  public double getY() {
    return yPos;
  }
}