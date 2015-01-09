import objectdraw.*;
import java.awt.*;

/**
 * class to create a rabbit like contestent to run races
 */
public class Rabbit extends ActiveObject {
  
  private static final int DELAY = 290;
  
  /*
   * body, head, leg1-leg4 are designed to be used to build the Rabbit.
   * xPos, yPos are the Rabbit's position.
   */
  private FilledOval body, head, ear,leg2,leg4;
  private double xPos,yPos, finish;
  
  private Race myRace;
  
  private RandomIntGenerator rabbitMoves=new RandomIntGenerator(0,15);

  /**
   * Constructor to create a new rabbit runner with x and y coordinates
   */
  public Rabbit(double x, double y, double endLine, DrawingCanvas canvas, Race theRace) {
    xPos=x;
    yPos=y;
    finish = endLine;
    myRace = theRace;
    buildRabbit(canvas);
  }
  
  /**
   * Constructor to create a new rabbit runner at a Location, point
   */
  public Rabbit(Location p, double endLine,  DrawingCanvas canvas, Race theRace) {
    xPos=p.getX();
    yPos=p.getY();
    finish = endLine;
    myRace = theRace;
    buildRabbit(canvas);

  }
  
/**
 *method to build a rabbit
 */
  private void buildRabbit(DrawingCanvas canvas) {
    body=new FilledOval(xPos-3,yPos+10,20,13,canvas);
    leg2=new FilledOval(xPos,yPos+19,5,10,canvas);
    ear = new FilledOval(xPos + 14, yPos-4, 6, 12, canvas);
    leg4=new FilledOval(xPos+7,yPos+19,5,10,canvas);
    head=new FilledOval(xPos+14,yPos+6,10,10,canvas);
    this.setColor(Color.GRAY);

  }
  
  /**
   * method to run the race
   */
  public void run() {
    
    while (getX() + 23 < finish) {
          move(rabbitMoves.nextValue(), 0);
          pause(DELAY);
    }
    move(25,0);
    myRace.raceOver("rabbit");
    
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
}