import objectdraw.*;
import java.awt.Color;

// Draw wagon wheels
public class WagonWheel extends FrameWindowController {
        
    // Number of spokes to draw
    private static final int SPOKES = 8;
    
    // dimensions of wheel
    private static final double RADIUS = 50;
    private static final double THICKNESS = 3;
    private static final double HUB = 15;
    
    
    // Draw a wagon wheel where the mouse is clicked
    public void onMouseClick(Location point){
        double centerx = point.getX();
        double centery = point.getY();
        
        // draw the rim
        new FilledOval( centerx - RADIUS, centery - RADIUS,
                        2*RADIUS, 2*RADIUS, canvas);
        new FilledOval( centerx - RADIUS+THICKNESS, 
                        centery - RADIUS+THICKNESS,
                        2*(RADIUS-THICKNESS), 
                        2*(RADIUS-THICKNESS), 
                        canvas).setColor(Color.white);
        
        // draw the hub
        new FilledOval( centerx - HUB/2, centery - HUB/2,
                        HUB, HUB, canvas);
        
        // draw the spokes
        double theta = 0;
        
        while ( theta < 2*Math.PI) {
          double dx = RADIUS*Math.cos(theta);
          double dy = RADIUS*Math.sin(theta);
          
          new Line( centerx, centery, centerx + dx,
                   centery + dy, canvas).move(1,0);
          new Line( centerx, centery, centerx + dx,
                   centery + dy, canvas).move(-1,0);
          new Line( centerx, centery, centerx + dx,
                   centery + dy, canvas).move(0,1);
/*          new Line( centerx, centery, centerx + dx,
                   centery + dy, canvas).move(0,-1);
  */          new Line( centerx, centery, centerx + dx,
                   centery + dy, canvas);

          theta += 2*Math.PI/SPOKES;
        }
    }
    
    public void onMouseExit(Location point){
      canvas.clear();
    }
}
