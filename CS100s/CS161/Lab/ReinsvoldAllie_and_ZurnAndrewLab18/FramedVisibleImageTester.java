import objectdraw.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

/** 
 * A program to test the FramedVisualImage class
 */
public class FramedVisibleImageTester extends FrameWindowController implements  ActionListener {
  
  private static final double X_LOCATION = 50;
  private static final double Y_LOCATION = 50;
  private static final int FRAME_SIZE = 5;
  /**
   * Message with Test Results
   */ 
  private Text testMessage = new Text("", 0, 350, canvas);
  /**
   * the original image
   */ 
  private Image source;
  /**
   * the framed Image
   */ 
  private FramedVisibleImage artWork;
  /**
   * the GUI controls
   */ 
  private JComboBox optionSelection;
  /**
   * Initialize the user interface and get and display the image   
   */
  public void begin() {
    
    // create the transformation selection menu
    optionSelection = new JComboBox();
    optionSelection.addItem("Choose an option");
    optionSelection.addItem("Test getX");
    optionSelection.addItem("Test getY");
    optionSelection.addItem("Test move");
    optionSelection.addItem("Test setColor");
    optionSelection.addItem("Test hide");
    optionSelection.addItem("Test show");
    optionSelection.addItem("Test removeFromCanvas");
    
    
    getContentPane().add(optionSelection, BorderLayout.SOUTH);
    optionSelection.addActionListener(this);    
    validate();
    
    // get an image
    source = getImage("chapelhopkins.gif");
    
    artWork = new FramedVisibleImage(source, X_LOCATION, Y_LOCATION, FRAME_SIZE, canvas);   
  }
  
  
  /**
   *  update depending on menu selection
   */
  public void actionPerformed(ActionEvent e){
    Object option = optionSelection.getSelectedItem();
    
    if ( option.equals("Test getX")) {
      testMessage.setText("X should be " + artWork.getX()  );
    }
    else if ( option.equals("Test getY")) {
      testMessage.setText("Y should be " + artWork.getY()  );
    }
    else if ( option.equals("Test move")) {
      artWork.move(50,-20);
    }
    else if ( option.equals("Test setColor")) {
      artWork.setColor(Color.RED);
    }
    else if ( option.equals("Test hide")) {
      artWork.hide();
    }
    else if ( option.equals("Test show")) {
      artWork.show();
    }
    else if ( option.equals("Test removeFromCanvas")) {
      artWork.removeFromCanvas();
    }
    
  }
}



