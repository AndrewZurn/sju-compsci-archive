import objectdraw.*;
import java.awt.*;

// Class to recursively draw broccoli
public class Broccoli implements BroccoliPart {
    
    private static final double MIN_SIZE = 25.0;
    private static final double SHRINK_PERCENT = 0.75;
    
    private BroccoliPart left, center, right;   // branches of broccoli
    private AngLine stem;                       // stem of broccoli
    
    // Draw broccoli by recursively drawing branches (and flowers)
    public Broccoli(Location startCoords, double size, 
                    double direction, DrawingCanvas canvas) {
        // Draw stem and color green
        stem = new AngLine(startCoords,size,direction,canvas);  
        stem.setColor(Color.green);
        Location destCoords = stem.getEnd();    // end of stem
        
        if ( size > MIN_SIZE ) {                // Big enough to keep growing
            left = new Broccoli(destCoords, SHRINK_PERCENT*size, 
                                direction + Math.PI/9.0, canvas);
            center = new Broccoli(destCoords, SHRINK_PERCENT*size, direction, canvas);
            right = new Broccoli(destCoords, SHRINK_PERCENT*size, 
                                 direction - Math.PI/9.0, canvas);              
        } else {                                // Draw flowers
            left = new Flower(destCoords, SHRINK_PERCENT*size, 
                              direction + Math.PI/9.0, canvas);
            center = new Flower(destCoords, SHRINK_PERCENT*size, direction, canvas);
            right = new Flower(destCoords, SHRINK_PERCENT*size,  
                               direction - Math.PI/9.0, canvas);
        }
    }
    
    // move the broccoli part by dx in the horizontal direction and
    // dy in the vertical direction
    public void move( double dx, double dy) {
        stem.move(dx,dy);                 // move stem 
        
        left.move(dx,dy);                 // move other parts
        center.move(dx,dy);
        right.move(dx,dy);
    }
    
    // whether a point is contained in the broccoli
    public boolean contains( Location point ) {
        return stem.contains(point) || left.contains(point) || 
            center.contains(point) || right.contains(point);
    }
}
