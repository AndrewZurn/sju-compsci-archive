import objectdraw.*;
import java.awt.*;

/**
 * class to create a turtle like contestent to run races
 */
public class Turtle extends ActiveObject implements Racer  {
  
  private static final int DELAY = 75;
  
  /*
   * body, head, leg1-leg4 are designed to be used to build the turtle.
   * xPos, yPos are the turtle's position.
   */
  private FilledOval body, head, leg1,leg2,leg3,leg4;
  private double xPos,yPos, finish;
  private Race myRace;
  private RandomIntGenerator turtleMoves=new RandomIntGenerator(1,3);
  private String racerName;
  private RandomIntGenerator crowdMoves = new RandomIntGenerator(1,5);
  private double moveMax = 35;
  private double moveCount = 0;
  

  
  /**
   * Constructor to create a new turtle racer with x and y coordinates
   */
  
  public Turtle(double x, double y,double endLine,  DrawingCanvas canvas, Race theRace, String name) {
    racerName=name;
    xPos=x;
    yPos=y;
    finish = endLine;
    myRace = theRace;
    buildTurtle(canvas);
    
  }
  
  /**
   * Constructor to create a new turtle runner at a Location, point
   */
  public Turtle(Location p,double endLine,  DrawingCanvas canvas, Race theRace) {
    xPos=p.getX();
    yPos=p.getY();
    finish = endLine;
    myRace = theRace;
    buildTurtle(canvas);
    
  }
  
  /**
   *method to build a turtle
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
   * method to run the race
   */
  
  public void run() {
    while (getX() +23 < finish) {
      move(turtleMoves.nextValue(), 0);
      pause(DELAY);
    }
    move(25,0);
    myRace.raceOver(racerName);
    
  }
  
  /**
   * move method to have all the parts of a turtle move together
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
   * change the color 
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
   * Return the x coordinate
   */
  public double getX() {
    return xPos;
  }
  
  /**
   * Return the y coordinate
   */
  public double getY() {
    return yPos;
  }
  
  public void moveCrowd(){
    while(moveCount < moveMax){
      move(0, -crowdMoves.nextValue());
      pause(DELAY);
      moveCount ++;
    }
  }
}