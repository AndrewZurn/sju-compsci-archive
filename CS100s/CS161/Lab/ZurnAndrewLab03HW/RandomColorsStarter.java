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

       /**
        * remember point of press
        * generate a random color with which lines will be drawn 
        */
        public void onMousePress(Location point) {
                lastPoint = point;
                //currentColor = Color.GREEN;
                colorGenerator=new RandomIntGenerator( 1, 5);
                if(colorGenerator == 1 .setColor(BLACK)){
                }
        }

      /**
        * scribbles with the currently set color  
        */
        public void onMouseDrag(Location point) {
                new Line( lastPoint, point, canvas).setColor( currentColor);
                lastPoint = point;
        }

}