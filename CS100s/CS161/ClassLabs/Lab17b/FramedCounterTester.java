import objectdraw.*;

// allows testing of the FramedCounter class
public class FramedCounterTester implements FrameIfc {
    
    private FramedCounter count;
    
    public FramedCounterTester( double x, double y,
                             double width, double height,
                             DrawingCanvas canvas ){
        
        count = new FramedCounter(x, y, width, height, canvas);
    }
    
    // calls whichever method will update the contents of the display
    // in this case, the count is increased by 1
    public void update(){
        count.increment(1);
    }
    
    // highlight the display
    public void highlight(){
        count.highlight();
    }
    
    // un-highlight the display
    public void unHighlight(){
        count.unHighlight();
    }
    
}
