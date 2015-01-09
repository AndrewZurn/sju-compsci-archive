import objectdraw.*;
import java.awt.*;


// Zurn, Andrew   BlueBox class
public class BlueBox extends ActiveObject {
  
  private static final int MOVE_DIST = 4;
  private static final int DELAY_TIME = 33;
  private static final int LONG_DELAY = 500;
  private int xSpeed = MOVE_DIST;
  private int ySpeed = MOVE_DIST;
  private FilledRect rect, rect1, rect2, rect3, rect4, inArea, redBox;
  private DrawingCanvas canvas;
  private double inWidth, inHeight, height, width, initRedX, initRedY;
  
  
  
  
  public BlueBox (Location point, double width, double height, Color color,
                  FilledRect redBox, FilledRect inArea,
                  double inWidth, double inHeight, DrawingCanvas canvas){
    this.inArea = inArea;
    this.redBox = redBox;
    this.canvas = canvas;
    this.inWidth = inWidth;
    this.inHeight = inHeight;
    rect = new FilledRect (point, width, height, canvas);
    this.height = height;
    this.width = width;
    rect.setColor(color);
    start();
  }
  
  public void run() {
    pause (LONG_DELAY);
    while ( !rect.overlaps(redBox) ){
      if ( (rect.getX() + width) >= (inArea.getX() + inWidth) || rect.getX() <= inArea.getX()){
        xSpeed = -xSpeed;
      }
      
      if ( (rect.getY() + height) >= (inArea.getY() + inHeight) || rect.getY() <= inArea.getY()){
        ySpeed = -ySpeed;
      }
      
      rect.move(xSpeed, ySpeed);
      
      pause(DELAY_TIME);
    }

    redBox.moveTo(canvas.getWidth() + 35, canvas.getHeight() +35);
    

  }
  
  public void removeFromCanvas(){
    rect.removeFromCanvas();
  }


    
  }
  


