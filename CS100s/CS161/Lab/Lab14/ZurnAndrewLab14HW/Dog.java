import objectdraw.*;
import java.awt.*;

/**
 * class to create a rabbit like contestent to run races
 */
public class Dog extends ActiveObject implements Racer {
  
  private static final int DELAY = 290;
  
  /*
   * body, head, leg1-leg4 are designed to be used to build the Rabbit.
   * xPos, yPos are the Rabbit's position.
   */
  private FilledOval body, head, ear,leg2,leg4, tail;
  private double xPos,yPos, finish;
  private String racerName;

  
  private Race myRace;
  
  private RandomIntGenerator dogMoves=new RandomIntGenerator(2,8);
  private RandomIntGenerator crowdMoves = new RandomIntGenerator(1,12);
  private double moveMax = 35;
  private double moveCount = 0;

  /**
   * Constructor to create a new rabbit runner with x and y coordinates
   */
  public Dog(double x, double y, double endLine, DrawingCanvas canvas, Race theRace, String name) {
    racerName=name;
    xPos=x;
    yPos=y;
    finish = endLine;
    myRace = theRace;
    buildDog(canvas);
  }
  
  /**
   * Constructor to create a new rabbit runner at a Location, point
   */
  public Dog(Location p, double endLine,  DrawingCanvas canvas, Race theRace) {
    xPos=p.getX();
    yPos=p.getY();
    finish = endLine;
    myRace = theRace;
    buildDog(canvas);

  }
  
/**
 *method to build a rabbit
 */
  private void buildDog(DrawingCanvas canvas) {
    tail=new FilledOval(xPos-9,yPos+11, 16, 4, canvas);
    body=new FilledOval(xPos-3,yPos+10,20,11,canvas);
    leg2=new FilledOval(xPos-1,yPos+15,5,10,canvas);
    ear = new FilledOval(xPos + 13, yPos+4, 4, 5, canvas);
    leg4=new FilledOval(xPos+8,yPos+15,5,10,canvas);
    head=new FilledOval(xPos+10,yPos+7,15,9,canvas);
  }
  
  /**
   * method to run the race
   */
  public void run() {
    
    while (getX() + 23 < finish) {
          move(dogMoves.nextValue(), 0);
          pause(DELAY);
    }
    move(25,0);
    myRace.raceOver(racerName);
    
    
    
  }
/**
 * move method to have all the parts of a rabbit move together
 */
  public void move(double x, double y) {
    xPos=xPos+x;
    yPos=yPos+y;
    leg2.move(x,y);
    ear.move(x, y);
    leg4.move(x,y);
    body.move(x,y);
    head.move(x,y);
    tail.move(x,y);
  }

  /** 
   * change the color 
   */ 
  public void setColor(Color color){
    leg2.setColor(color);
    ear.setColor(color);
    leg4.setColor(color);
    body.setColor(color);
    head.setColor(color);
    tail.setColor(color);
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