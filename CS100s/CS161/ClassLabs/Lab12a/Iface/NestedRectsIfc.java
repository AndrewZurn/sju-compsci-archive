import objectdraw.*;
import java.awt.*;

// Interface for base and recursive classes for nested rectangles
public interface NestedRectsIfc {
    // move nested rectangles to (x,y)
    void moveTo(double x, double y);
    // remove nested rectangles from canvas
    void removeFromCanvas();
    void setColor(Color newColor);
}
