import objectdraw.*;

// allows testing of the FramedDisplay class
public class FramedDisplayTester implements FrameIfc {
    
    private FramedDisplay disp;
    
    public FramedDisplayTester( double x, double y,
                                double width, double height,
                                DrawingCanvas canvas ){
        
        disp = new FramedDisplay(x, y, width, height, canvas);
    }
    
    // calls whichever method will update the contents of the display
    // in this case, there is none.
    public void update(){
        
    }
    
    // highlight the display
    public void highlight(){
        disp.highlight();
    }
    
    // un-highlight the display
    public void unHighlight(){
        disp.unHighlight();
    }
    
}
