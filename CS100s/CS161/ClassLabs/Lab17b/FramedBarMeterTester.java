import objectdraw.*;

// allows testing of the FramedBarMeter class
public class FramedBarMeterTester implements FrameIfc {
    
    // how much to increment the bar
    private static final double INCREMENT = 0.10;
    
    // a margin of error
    private static final double ERROR = 0.01;

    private FramedBarMeter meter;
    
    // current fraction of display area used by bar
    private double currFraction;
    
    public FramedBarMeterTester( double fraction, double x, double y,
                                 double width, double height,
                                 DrawingCanvas canvas ){
        
        meter = new FramedBarMeter(fraction, x, y, width, height, canvas);
        currFraction = fraction;
    }
    
    // calls whichever method will update the contents of the display
    // in this case, the bar will increase to fill the frame
    public void update(){
        // ERROR is added to accommodate for rounding errors
        if( currFraction + ERROR < 1.0 ){
            currFraction = currFraction + INCREMENT;
            meter.setFraction(currFraction);
        }
    }
    
    // highlight the display
    public void highlight(){
        meter.highlight();
    }
    
    // un-highlight the display
    public void unHighlight(){
        meter.unHighlight();
    }
    
}
