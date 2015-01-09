import objectdraw.*;
import java.awt.*;

// draws a standard 8x8 checkerboard
public class Checkerboard extends FrameWindowController {
    
    // location and dimensions of the board
    private static final int LEFT = 20,
                             TOP = 20,
                             SIZE = 20;
    
    // draw the FilledRects that make up the board, row by row
    public void begin() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                FilledRect square = new FilledRect(LEFT + col*SIZE, TOP + row*SIZE, 
                                                   SIZE, SIZE, canvas);
                if ((row+col) % 2 == 0) {
                    square.setColor(Color.red);
                }
            }
        }
    }
    
}
