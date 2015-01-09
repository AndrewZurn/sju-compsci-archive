import java.awt.*;
import objectdraw.*;

// creates an instance of RadarStats and allows data to be added
// by clicking on the appropriate hour column.
public class RadarController extends FrameWindowController {
    private RadarStats stats;
    
    public void begin()
    {
        stats = new RadarStats( 55, canvas );
    }
    
    public void onMouseClick( Location point ) {
        stats.vehicleReport( 65, (int)( 24*(point.getX()-30)/(canvas.getWidth()-60)));
    }
}
