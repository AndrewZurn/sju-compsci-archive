import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.io.*;
/**
 * An ActiveObject class which creates animated banner on the canvas. 
 */ 
public class BannerMover extends ActiveObject {
  /**
   * Pause time 
   */ 
  private static final int DELAY_TIME = 15;
  /**
   * Current speed Banner only moves horizontally in the X-direction
   */ 
  private double xSpeed = 4;
  /**
   * Allows the other classes to forces a banner to stop moving
   */ 
  private boolean moving;
  /**
   * The banner object to be animated
   */ 
  private Banner theBanner;
  /**
   * canvas to draw on
   */ 
  private DrawingCanvas canvas;
  
  /** a RandomWord class */
  private RandomWord randomWord;
  
  /** a double used to reference wanted wordSpeed */
  private double wordSpeed;
  
  /** a string to reference the wanted list of words to be used across the screen */
  private String selectedList;
  
  /** a string to reference the wanted word across the screen */
  private String theWord;
  
  /** used to reference the game passed back to the bannerMover */
  private ScrollingWordGame game;
  
  /**
   * Create a Banner given the parameters wordList, speed, and aCanvas
   * @param wordList a string of the wanted list to choose a word from
   * @param speed a double value used to dictate the speed of the word across the screen
   * @param aCanvas used to draw on the canvas
   * @param theGame used to reference the game
   */ 
  public BannerMover(String wordList, double speed, ScrollingWordGame theGame,
                     DrawingCanvas aCanvas) throws FileNotFoundException, IOException, IllegalStateException{
    selectedList = wordList;
    game = theGame;
    canvas = aCanvas;
    wordSpeed = speed;
    randomWord = new RandomWord(selectedList);
    theWord = randomWord.getWord();
    
    //Create banner
    theBanner = new Banner(theWord, new Location(0,100), canvas);
    moving = true;
    //System.out.println(theWord);
    start();
  }
  
  /**
   * run the active object part of the class
   */
  public void run() {
    try{
      //move until Banner disappears or is forced to stop
      while (theBanner.getX() < canvas.getWidth() && moving) {
        theBanner.move(wordSpeed, 0);
        pause(DELAY_TIME);
      }
      theBanner.removeFromCanvas();
      game.incrimentStrikes();
    }
    //used to catch the exception that the bannerFrame creates
    catch(IllegalStateException ie){}
  }
  
  /**
   * Allows us to change banner's moving speed
   * @param x the wanted speed of the object
   */ 
  public void setSpeed(double x) {
    xSpeed = x;
  }
  
  /**
   * Allows us to access the text inside the banner
   * @return the message inside the banner
   */ 
  public String getText() {
    return theBanner.getMessage();
  }
  
  /**
   * Allows us to force the banner to stop moving
   */
  public void stopMoving(){
    moving = false;  
  }
  
  /**
   * return the double of the x-coordinate
   * @return x-coordinate of upper left corner
   */
  public double getX(){
    return theBanner.getX();
  }
  
  /** remove banner from the canvas */
  public void removeFromCanvas(){
    theBanner.removeFromCanvas();
  }
}
