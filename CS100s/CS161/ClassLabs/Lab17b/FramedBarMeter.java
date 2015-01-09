import objectdraw.*;
import java.awt.*;

// A FramedBarMeter displays a variable length rectangle on a
// background framed by a distinct border.
public class FramedBarMeter extends FramedDisplay {   
    // Space between the frame and the bar
    private static final double INSET=2;
    
    // The bar itself
    private FilledRect bar;
    
    // Create frame and bar filling a fraction of the display
    public FramedBarMeter( double fraction,
                           double x, double y,
                           double width, double height,
                           DrawingCanvas canvas ) {
        super( x, y, width, height, canvas );
        
        bar = new FilledRect( displayLeft()+INSET, 
                              displayTop()+INSET, 
                              (displayWidth() - 2*INSET) * fraction, 
                              displayHeight() - 2*INSET, canvas );
        bar.setColor(Color.blue);
    }
    
    //  Change the fraction of the display filled by the bar
    public void setFraction( double fraction ) {
        bar.setWidth( (displayWidth() - 2*INSET)*fraction );
    }
    
}
