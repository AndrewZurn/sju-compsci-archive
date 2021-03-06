import objectdraw.*;
import java.awt.*;

// A FramedText object displays a specified text message on a
// background framed by a distinct border.
public class FramedText extends FramedDisplay {
    
    protected Text message;            // The message displayed
    
    // Create a FramedText object displaying the text 'contents'
    // at the position and with the dimensions specified.
    public FramedText( String contents, double x, double y,
                       double width, double height,
                       DrawingCanvas canvas )
    {
        // construct the frame
        super( x, y, width, height, canvas );
        
        // Construct and appropriately position the message
        message = new Text ( contents, x, y, canvas );
        message.setColor( Color.white );
        positionContents();
    }
    
    // Position the message to center it in the frame
    protected void positionContents() {
        message.moveTo( displayLeft(), displayTop() );
        message.move( (displayWidth() - message.getWidth()) / 2,
                      (displayHeight() - message.getHeight()) / 2 );
    }        
    
    // Change the font size used
    public void setTextSize( int size ) {
        message.setFontSize( size );
        positionContents();
    }
    
    public void highlight() {
      super.highlight();
      message.setColor(Color.RED);
    }
    
    public void move(double dx, double dy) {
      super.move(dx,dy);
      message.move(dx, dy);
    }
      
    
}
