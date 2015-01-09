import objectdraw.*;
import java.awt.*;

/** A program that draws perpendicular lines that move
 so that they always intersect at the mouse's current
 position */
public class CrossHairs extends FrameWindowController {

 private Line vert, horiz; // lines forming crosshairs

 private int canvasWidth, canvasHeight;
 
 private Location baseHorz, baseVert;

 // Initially center the lines
 public void begin() {
  canvasWidth = canvas.getWidth();
  canvasHeight = canvas.getHeight();

  vert = new Line(canvasWidth / 2, 0, canvasWidth / 2, canvasHeight,
    canvas);
  horiz = new Line(0, canvasHeight / 2, canvasWidth, canvasHeight / 2,
    canvas);
  baseHorz = new Location (canvasWidth, canvasHeight/2);
  baseVert = new Location (canvasWidth/2, canvasHeight);
 }

 // move the lines so that they intersect at the mouse
 public void onMouseDrag(Location point) {
  vert.setEndPoints(point, baseVert);

  horiz.setEndPoints(point, baseHorz);
 }
}
