import objectdraw.*;
import java.awt.*;
import javax.swing.*;

// display text field and copy contents to canvas when clicked
public class TextController extends FrameWindowController {
    private JTextField input, input2;
    
    public void begin() {
        // construct text field
        input = new JTextField( );
        input2 = new JTextField("Hello World");
        
        // Add text field to content pane of window
        Container contentPane = getContentPane();
        contentPane.add( input, BorderLayout.NORTH);
        contentPane.add( input2, BorderLayout.SOUTH);
        contentPane.validate();
    }
    
    // Add new text item where clicked.
    // Get contents from text field
    public void onMouseClick( Location point ){    
      
      if (point.getY() < canvas.getHeight()/2){
        new Text( input.getText(), point, canvas );
      }
      else{
        new Text( input2.getText(), point, canvas );
      }
       // input.setText("hello Fred");
    }
}
