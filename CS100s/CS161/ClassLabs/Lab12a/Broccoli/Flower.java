import objectdraw.*;
import java.awt.*;

public class Flower implements BroccoliPart {
    
    private static final int BUD_SIZE = 3;
    
    private AngLine stem;                   // stem of broccoli
    
    private FilledOval bud;                 // flower of broccoli plant
    
    // Construct stem with flower at end
    public Flower(Location startCoords, double size, 
                  double direction, DrawingCanvas canvas ) {
        // Draw stem and color green
        stem = new AngLine( startCoords, size, direction, canvas );  
        stem.setColor( Color.green );

        Location destCoords = stem.getEnd();    // end of stem
        
        bud = new FilledOval( destCoords, BUD_SIZE, BUD_SIZE, canvas );
        bud.setColor( Color.yellow );
    }
    
    // move the broccoli part by dx in the horizontal direction and}
    // dy in the vertical direction
    public void move( double dx, double dy) {
        stem.move(dx,dy);                       // move stem
        bud.move(dx,dy);                        // move bud
    }

    // return whether a point is contained in the flower
    public boolean contains( Location point ) {
        return stem.contains( point ) || bud.contains( point );
    }
}
