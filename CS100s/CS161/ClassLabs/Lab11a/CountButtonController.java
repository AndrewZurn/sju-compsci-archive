import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// display text field and copy contents to canvas when clicked
// Clear screen when clicked on "clear" button
public class CountButtonController extends FrameWindowController 
                                  implements ActionListener {
    private JTextField input;
    private int count;
    private Text results;
        
    public void begin() {
        // construct text field and button
        input = new JTextField( "Enter text here" );  
        JButton countButton = new JButton( "count" );
        results = new Text("", 50,50,canvas);
       
        // Add text field and button to content pane of window
        Container contentPane = getContentPane();
        contentPane.add( input, BorderLayout.NORTH );
        contentPane.add( countButton,BorderLayout.SOUTH );
        contentPane.validate();
        
        // Set this class to respond to button clicks
        countButton.addActionListener( this );
    }
    
    // Add new text item where clicked.
    // Get contents from text field
    public void onMouseClick( Location point ){
        new Text( input.getText(), point, canvas );
        count++;
              
    }
    
    public void actionPerformed( ActionEvent evt ) {
      count++;
      results.setText("Count is " + count + " times");

      
    }
}
