import objectdraw.*;
import java.awt.*;

/**
 * The Banner class creates a Framed Rectangle with a Text object inside 
 * containing whatever message is passed in..
 */
public class Banner {
  /** the space between the text and the rectangle */ 
  private final static double FRAMEWIDTH = 4;
  /** the frame of the banner */ 
  private FramedRect bannerFrame;
  /** the text object that holds the banner message */ 
  private Text message;
  
  /**
   * Creates a new banner with parameters of message, placement, and canvas
   * @param message the wanted message in the banner
   * @param placement of the word on the screen
   * @param canvas to be drawn upon
   */
  public Banner(String message, Location placement, DrawingCanvas canvas) throws  IllegalStateException {
    
    this.message = new Text(message, placement.getX() + FRAMEWIDTH, placement.getY() + FRAMEWIDTH,
                            canvas);
    bannerFrame = new FramedRect(placement, this.message.getWidth() + 2 * FRAMEWIDTH,
                                 this.message.getHeight() + 2 * FRAMEWIDTH, canvas);
  }
  
  /**
   * move() will move the banner the distance given by the parameters
   * @param dx movement in the x-axis direction
   * @param dy movement in the y-axis direction
   */
  public void move(double dx, double dy) {
    bannerFrame.move(dx,dy);
    message.move(dx,dy);
  }
  
  /**
   * moveTo() will move the upper left corner of the banner to the locatin specified
   * @param x move to a specific location on the x-axis
   * @param y move to a specific location on the y-axis
   */
  public void moveTo(double x, double y) {
    this.move(x - bannerFrame.getX(), y -bannerFrame.getY());
  }
  
  /**
   * getX() will return the x-coordinate of the upper left corner of the banner
   * @return the x-coordinate of the upper left corner
   */
  public double getX() {
    return bannerFrame.getX();
  }  
  
  /**
   * getY() will return the y-coordinate of the upper left corner of the banner.
   * @return the y-coordinate of the upper left corner
   */
  public double getY() {
    return bannerFrame.getY();
  }
  /**
   * getMessage() will return the String inside the Text object of the banner
   * @return string inside the banner
   */  
  public String getMessage() {
    return message.getText();
  }
  
  /**
   * removeFromCanvas() will remove a Banner from the canvas by removing the pieces form the canvas
   */
  public void removeFromCanvas() {
    bannerFrame.removeFromCanvas();
    message.removeFromCanvas();
  }
  
}
