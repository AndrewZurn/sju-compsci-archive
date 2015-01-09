import objectdraw.*;
import java.awt.*;
/**
 * From the eventfulJava materials
 * Include your name, lab section and a description of the program here.
 * Andrew Zurn, CS161 8:00am Lab, Random Color Line Scribbler
 */
public class RandomColor extends FrameWindowController{
       /**
        * location where the mouse was last
        */
        private Location lastPoint; 
        /**
         *  current color for drawing
         */
        private Color currentColor; 
        private RandomIntGenerator colorGenerator;
        private Integer colorTest;

       /**
        * remember point of press
        * generate a random color with which lines will be drawn 
        */
        public void onMousePress(Location point) {
                lastPoint = point;
                colorGenerator = new RandomIntGenerator( 1, 5);
                colorTest = colorGenerator.nextValue();
                if (colorTest == 1){
                  currentColor = Color.BLACK;
                }
                if (colorTest == 2){
                  currentColor = Color.RED;
                }
                if (colorTest == 3){
                  currentColor = Color.GREEN;
                }
                if (colorTest == 4){
                  currentColor = Color.BLUE;
                }
                if (colorTest == 5){
                  currentColor = Color.YELLOW;
                }
        }

      /**
        * scribbles with the currently set color  
        */
        public void onMouseDrag(Location point) {
        (new Line( lastPoint, point, canvas)).setColor(currentColor);
          lastPoint = point;
        }
}