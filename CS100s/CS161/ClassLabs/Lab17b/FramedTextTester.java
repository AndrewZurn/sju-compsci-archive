import objectdraw.*;

// allows testing of the FramedText class
public class FramedTextTester implements FrameIfc {
    
    private FramedText text;
    
    // current size of the text
    private int currSize;
    
    public FramedTextTester( String contents, double x, double y,
                             double width, double height,
                             DrawingCanvas canvas ){
        
        text = new FramedText(contents, x, y, width, height, canvas);
        currSize = 13;
    }
    
    // calls whichever method will update the contents of the display
    // in this case, the size of the text is increased by 1
    public void update(){
        text.setTextSize( currSize++ );
    }
    
    // highlight the display
    public void highlight(){
        text.highlight();
    }
    
    // un-highlight the display
    public void unHighlight(){
        text.unHighlight();
    }
    
}
