import objectdraw.*;
import java.awt.*;

// A FramedCounter object displays a numeric counter on
// a background framed by a distinct border
public class FramedCounter extends FramedText {
    
    private int counter = 0;          // Current value of counter
    
    // Create a FramedCounter object displaying 0
    // at the position and with the dimensions specified
    public FramedCounter( double x, double y, double width, double height,
                          DrawingCanvas canvas ) {
        super( "0", x, y, width, height, canvas );
    }
    
    //  Increase the counter's value and update display
    public void increment( int amount ) {
        counter = counter + amount;
        message.setText( counter );
        positionContents();
    }   
}
