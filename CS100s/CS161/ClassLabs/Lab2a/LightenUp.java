import objectdraw.*;
import java.awt.*;

/** A program to simulate the brightening of the sky at sunrise
  */
public class LightenUp extends FrameWindowController {

    private FilledRect sky;     // background rectangle
    private int brightness,blueBrightness;     // brightness of sky's color and sun coler
    private FilledOval sun;     // Circle that represents the sun

    public void begin() {
            // Create the sky and make it a dark gray
        brightness = 50;
        blueBrightness = 150;
        sky = new FilledRect( 0, 0, canvas.getWidth(), canvas.getHeight(), canvas );
        sky.setColor( new Color( brightness, brightness, blueBrightness));

            // Place the sun and some brief instructions on the screen
        sun = new FilledOval( 50, 250, 100, 100, canvas);
        sun.setColor(Color.YELLOW);
        new Text( "Please click the mouse repeatedly", 20, 20, canvas);
    }

       // Brighten the sky and move the sun with each click
    public void onMouseClick(Location point) {
        brightness = brightness + 1;
        blueBrightness = blueBrightness - 3;
        sky.setColor( new Color(brightness, brightness, blueBrightness));
        sun.move(0, -5);
    }
}