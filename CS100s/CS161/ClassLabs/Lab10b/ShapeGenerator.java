import objectdraw.*;
import java.awt.*;

public class ShapeGenerator extends ActiveObject {
    private static final int MIN_SIZE = 10; // Minimum dimension of new object
    private int maxX, maxY;                 // Largest x, y values in window
    private DrawingCanvas canvas;           // canvas on which to draw objects
    private int delay = 4000;               // pause time between drawing objects
    
    // Random number generators for size and location of next graphic object
    private RandomIntGenerator widthGenerator, heightGenerator, 
                               xGenerator, yGenerator;
    
    // Random number generator to choose whether to draw oval or rectangle
    private RandomIntGenerator shapeSelector;
    
    // Random number generator to choose color of new graphic object
    private RandomIntGenerator colorGenerator;
    
    // Last shape generated in window
    private DrawableInterface lastShape;
    
    /* Create a new shape generator.  The dimensions of the shapes generated are 
           bounded by the parameters.  The shapes are drawn on theCanvas */
    public ShapeGenerator (int maxWidth, int maxHeight, int maxX, int maxY, 
                           DrawingCanvas theCanvas) {
        this.maxX = maxX;
        this.maxY = maxY;
        canvas = theCanvas;
        
        shapeSelector = new RandomIntGenerator (1, 2);
        colorGenerator = new RandomIntGenerator (0, 255);
        
        widthGenerator = new RandomIntGenerator (MIN_SIZE, maxWidth);
        heightGenerator = new RandomIntGenerator (MIN_SIZE, maxHeight);
        xGenerator = new RandomIntGenerator (0, maxX - MIN_SIZE);
        yGenerator = new RandomIntGenerator (0, maxY - MIN_SIZE);
        
        start();
    }
    
    // Return last shape generated
    public DrawableInterface getLastShape () {
        return lastShape;
    }
    
    // Cut the pause time in half
    public void goFaster () {
        delay = delay / 2;
    }

 /* Generate new ovals and rectangles in random places and colors, pausing by
           delay between generation of new objects.
        */ 
    public void run () {
        // Dimensions and location of new object
        int nextWidth, nextHeight, nextX, nextY;
        
        // components of the color of new object
        int redness, greenness, blueness;

        while (true) {
            // Generate new object's width & height
            nextWidth = widthGenerator.nextValue ();  
            nextHeight = heightGenerator.nextValue ();
            
            // Generate x and y coordinates of object
            nextX = xGenerator.nextValue ();        
            nextY = yGenerator.nextValue ();
            
            // Determine whether rectangle or oval
            if (shapeSelector.nextValue () == 1) {  
                lastShape = new FilledRect (nextX, nextY, nextWidth, nextHeight, 
                                            canvas);
            }
            else {
                lastShape = new FilledOval (nextX, nextY, nextWidth, nextHeight, 
                                            canvas);
            }
            
            redness = colorGenerator.nextValue();   // Generate color components
            greenness = colorGenerator.nextValue ();
            blueness = colorGenerator.nextValue();
            lastShape.setColor (new Color (redness, greenness, blueness));
            
            pause (delay);         // Give the user a chance to click on object
        }
    }       
}
