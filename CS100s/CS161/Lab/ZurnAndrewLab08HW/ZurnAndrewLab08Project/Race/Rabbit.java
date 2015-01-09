import objectdraw.*;
import java.awt.*;

public class Rabbit extends ActiveObject {
  
  /**
   * body, head, leg1-leg4 are designed to be used to build the Rabbit.
   * xPos, yPos are the Rabbit's CURRENT position.
   */
  private DrawingCanvas canvas;
  private FilledOval body, head, ear,leg2,leg4;
  private double xPos,yPos;
  private  static final double DELAY_LONG=500;
  private  static final double DELAY_SHORT=33;
  private int ENDLINE;
  private RandomIntGenerator rabbitMoves;
  private int y, x;
  private int rabbitX;
  private int hiSpeed, loSpeed;
  
  public Rabbit(double x, double y, int FINISH, int highSpeed, int lowSpeed, DrawingCanvas canvas) {
    ENDLINE=FINISH;
    hiSpeed=highSpeed;
    loSpeed=lowSpeed;
    
    xPos=x;
    yPos=y;
    this.buildRabbit(canvas); 
    
  }
  
  // public Rabbit(Location p, int ENDLINE, DrawingCanvas canvas) {
  
//this(p.getX(),p.getY(),canvas);
  
  
  private void buildRabbit(DrawingCanvas canvas) {
    
    rabbitMoves = new RandomIntGenerator(loSpeed, hiSpeed);
    body=new FilledOval(xPos-3,yPos+10,20,13,canvas);
    leg2=new FilledOval(xPos,yPos+19,5,10,canvas);
    ear = new FilledOval(xPos + 14, yPos-4, 6, 12, canvas);
    leg4=new FilledOval(xPos+7,yPos+19,5,10,canvas);
    head=new FilledOval(xPos+12,yPos+6,10,10,canvas);
    this.setColor(Color.GRAY);
    
    
    start();
    
    
  }
  
  
  
  public void run(){
    
    
    while((body.getX()+25)<ENDLINE){
      
      move(x,y);
      
      pause(DELAY_SHORT);
      
    }
  }
  public void move(double x, double y) {
    
    rabbitX=rabbitMoves.nextValue();
    x=rabbitX;
    
    leg2.move(x,y);
    ear.move(x, y);
    leg4.move(x,y);
    body.move(x,y);
    head.move(x,y);
  }
  
  public void setColor(Color color){
    leg2.setColor(color);
    ear.setColor(color);
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