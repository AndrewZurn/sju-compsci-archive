import java.awt.*;
import objectdraw.*;

// This program demonstrates the use of interfaces with objectdraw shapes.
public class DrawingProgram extends FrameWindowController {

    // Size and locations of buttons in the palette used to create shapes
    private static final int BUTTON_HEIGHT = 40;
    private static final int BUTTON_WIDTH = 40;
    private static final int PALETTE_X = 0;
    private static final int PALETTE_Y = 0;
    
    // Location of icon labeling shape buttons
    private static final int ICON_MARGIN = 10;
    private static final int ICON_X = PALETTE_X + ICON_MARGIN;
    private static final int ICON_DIM = BUTTON_WIDTH - (2 * ICON_MARGIN);
    
    // Location and shape of the drawing area
    private static final int AREA_X = PALETTE_X + BUTTON_WIDTH;
    private static final int AREA_Y = PALETTE_Y;
    private static final int AREA_WIDTH = 300;
    private static final int AREA_HEIGHT = 300;
    
    // Location and shape of the buttons used to change colors
    private static final int COLORS_X = AREA_X + AREA_WIDTH + 2;
    private static final int COLORS_Y = PALETTE_Y;
    private static final int COLOR_WIDTH = BUTTON_WIDTH;
    private static final int COLOR_HEIGHT = BUTTON_HEIGHT;
    
    // Default location and size when we create a new shape
    private static final int DEFAULT_SIZE = 50;
    private static final Location DEFAULT_LOC =
        new Location(AREA_X + AREA_WIDTH / 2 - DEFAULT_SIZE / 2, AREA_Y + AREA_HEIGHT / 2 - DEFAULT_SIZE / 2);
    
    // The shape buttons
    private FramedRect rectButton;
    private FramedRect ovalButton;
    private FramedRect solidRectButton;
    private FramedRect drawingArea;
    
    // The variable to hold the last shape created
    private DrawableInterface newShape;
    
    // Used to support the usual dragging algorithm
    private boolean dragging;
    private Location lastMouse;
    
    // Buttons to change color
    private FilledRect redRect, blueRect, greenRect, yellowRect;
    
    /* 
     * Draws the program with the buttons and a blank drawing area
     */
    public void begin() {
        // Create palette
        rectButton = new FramedRect(PALETTE_X, PALETTE_Y, BUTTON_WIDTH, BUTTON_HEIGHT, canvas);
        new FramedRect(ICON_X, rectButton.getY() + ICON_MARGIN, ICON_DIM, ICON_DIM, canvas);
        ovalButton = new FramedRect(PALETTE_X, rectButton.getY() + BUTTON_HEIGHT, BUTTON_WIDTH, BUTTON_HEIGHT, canvas);
        new FilledOval(ICON_X, ovalButton.getY() + ICON_MARGIN, ICON_DIM, ICON_DIM, canvas);
        solidRectButton =
          new FramedRect(PALETTE_X, ovalButton.getY() + BUTTON_HEIGHT, BUTTON_WIDTH, BUTTON_HEIGHT, canvas);
        new FilledRect(ICON_X, solidRectButton.getY() + ICON_MARGIN, ICON_DIM, ICON_DIM, canvas);
        
        // Draw the drawing area
        drawingArea = new FramedRect(AREA_X, AREA_Y, AREA_WIDTH, AREA_HEIGHT, canvas);
        
        // Create color palette
        redRect = new FilledRect(COLORS_X, COLORS_Y, COLOR_WIDTH, COLOR_HEIGHT, canvas);
        redRect.setColor(Color.red);
        blueRect = new FilledRect(COLORS_X, redRect.getY() + COLOR_HEIGHT, COLOR_WIDTH, COLOR_HEIGHT, canvas);
        blueRect.setColor(Color.blue);
        greenRect = new FilledRect(COLORS_X, blueRect.getY() + COLOR_HEIGHT, COLOR_WIDTH, COLOR_HEIGHT, canvas);
        greenRect.setColor(Color.green);
        yellowRect = new FilledRect(COLORS_X, greenRect.getY() + COLOR_HEIGHT, COLOR_WIDTH, COLOR_HEIGHT, canvas);
        yellowRect.setColor(Color.yellow);
    }
    
    /* 
     * When the user clicks the button on a shape button, create that shape.
     * When the user clicks on a color button, change the color of the last
     * shape created.  If the drawing area is empty, clicking on a color button
     * does nothing.
     */
    public void onMouseClick(Location loc) {
        // Handle shape buttons
        if (rectButton.contains(loc)) {
            newShape = new FramedRect(DEFAULT_LOC, DEFAULT_SIZE, DEFAULT_SIZE, canvas);
        } else if (ovalButton.contains(loc)) {
            newShape = new FilledOval(DEFAULT_LOC, DEFAULT_SIZE, DEFAULT_SIZE, canvas);
        } else if (solidRectButton.contains(loc)) {
            newShape = new FilledRect(DEFAULT_LOC, DEFAULT_SIZE, DEFAULT_SIZE, canvas);
        } else if (newShape != null) {
            // Handle color buttons
            if (redRect.contains(loc)) {
                newShape.setColor(Color.red);
            } else if (blueRect.contains(loc)) {
                newShape.setColor(Color.blue);
            } else if (greenRect.contains(loc)) {
                newShape.setColor(Color.green);
            } else if (yellowRect.contains(loc)) {
                newShape.setColor(Color.yellow);
            }
        }
    }
    
    /* 
     * Drag the shape with the mouse.  Notice that it doesn't matter what
     * kind of shape (FramedRect, FilledOval, etc.) we have.
     */
    public void onMouseDrag(Location loc) {
        if (dragging) {
            newShape.move(loc.getX() - lastMouse.getX(), loc.getY() - lastMouse.getY());
            lastMouse = loc;
        }
    }
    
    /* 
     * Start a drag
     */
    public void onMousePress(Location loc) {
        if (newShape != null && newShape.contains(loc)) {
            dragging = true;
            lastMouse = loc;
        }
    }
    
    /* 
     * Stop a drag
     */
    public void onMouseRelease(Location arg0) {
        dragging = false;
    }
    
}
