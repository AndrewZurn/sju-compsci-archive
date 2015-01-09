import objectdraw.*;
import java.awt.*;

public class Turtle extends ActiveObject {
  
  /**
   * body, head, leg1-leg4 are designed to be used to build the turtle.
   * xPos, yPos are the turtle's CURRENT position.
   */
    private DrawingCanvas canvas;
  private FilledOval body, head, leg1,leg2,leg3,leg4;
  private double xPos,yPos;
  private static final double DELAY_LONG=500;
  private static final double DELAY_SHORT=33;
  private int ENDLINE;
    private RandomIntGenerator turtleMoves;
    private int turtleX;
    private int x,y;
    private int hiSpeed, loSpeed;
  public Turtle(double x, double y, int FINISH, int highSpeed, int lowSpeed, DrawingCanvas canvas) {
     hiSpeed=highSpeed;
      loSpeed=loSpeed;
    
     
  
    ENDLINE=FINISH;
    xPos=x;
    yPos=y;
    this.buildTurtle(canvas);
    
  }
  
  //public Turtle(Location p, int ENDLINE, DrawingCanvas canvas) {
    //this(p.getX(),p.getY(),canvas);
  
  
  private void buildTurtle(DrawingCanvas canvas) {
    
     
    turtleMoves= new RandomIntGenerator(loSpeed , hiSpeed);
    leg1=new FilledOval(xPos,yPos,5,10,canvas);
    body=new FilledOval(xPos-3,yPos+5,20,20,canvas);
    leg2=new FilledOval(xPos,yPos+19,5,10,canvas);
    leg3=new FilledOval(xPos+14,yPos,5,10,canvas);
    leg4=new FilledOval(xPos+14,yPos+19,5,10,canvas);
    head=new FilledOval(xPos+16,yPos+11,8,8,canvas);
    this.setColor(Color.GREEN);
 
 
  
    start();}
  public void run(){ 
  
    
    while((body.getX()+25)<ENDLINE){
        move(x,y);
         pause(DELAY_SHORT);
        
    }
  }
  public void move(double x, double y) {
    turtleX=turtleMoves.nextValue();
    x=turtleX;
  
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