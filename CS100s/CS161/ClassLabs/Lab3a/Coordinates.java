import objectdraw.*;
import java.awt.*;

/**
 * This program provides the coordinates of mouse clicks
 * Modify the program to center the text on the canvas 
 * (Note that to do so you need to know how long the Text is
 * by using Text.getWidth()
 * You can then move the text to the right location
 */
 
public class Coordinates extends FrameWindowController {

  private Text response;
    // When the mouse button is clicked, note its location
    public void onMousePress( Location pressPoint) {
        canvas.clear();
        response = new Text ("You did clicked on " + pressPoint.getX() + ", " +
                  pressPoint.getY(), 0, 0, canvas);
        response.setFontSize(16);
        response.move ((canvas.getWidth()/2 - response.getWidth()/2), (canvas.getHeight()/2 -
                                                                      response.getHeight()/2));
        if(pressPoint.getX()<=canvas.getWidth()/2){
          if(pressPoint.getY()<=canvas.getHeight()/2){
          response.setColor(Color.GREEN);
          }
        }
        else{response.setColor(Color.BLUE);
        
    }
    

    }
}
