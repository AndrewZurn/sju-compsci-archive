import objectdraw.*;
import java.awt.*;
import javax.swing.*;
/**
 * Created on Oct 8, 2003
 * @author kim
 *
 * Draw and drag around a bullseye to demonstrate recursive drawing.
 */
public class TargetController extends FrameWindowController {
  //eye can store either a BullsEye or a RingedTarget
  private TargetInterface eye;
  //used to specify the radius of the largest ring in the target
  private JTextField sizeField;
  //needed for dragging
  private boolean dragging = false;
  private Location lastPt;
  /**
   * setup interface
   */ 
  public void begin(){
    JPanel southPanel = new JPanel();
    JLabel instructions = new JLabel("Enter radius of largest target ring:");
    sizeField = new JTextField(""+(TargetInterface.MIN_OUTER-2), 10);
    southPanel.add(instructions);
    southPanel.add(sizeField);
    getContentPane().add(southPanel, BorderLayout.SOUTH);
    new Text("Click on canvas to create a target of the size specified",10,10,canvas);
  }
  /**
   * create shape
   */
  public void onMouseClick(Location pt) {
    int radius = Integer.parseInt(sizeField.getText());
    if (radius >= TargetInterface.MIN_OUTER) {
      eye = new RingedTarget(pt,radius,canvas);
    } 
    else {
      eye = new BullsEye(pt,radius,canvas);
    }
  }
  
  public void onMousePress(Location pt) {
    if (eye != null) {
      dragging = eye.contains(pt);
      lastPt = pt;
    } 
    else {
      dragging = false;
    }
  }
  
  public void onMouseDrag(Location pt){
    if (dragging) {
      eye.move(pt.getX() - lastPt.getX(),pt.getY() - lastPt.getY());
      lastPt = pt;
    }
  }
}
