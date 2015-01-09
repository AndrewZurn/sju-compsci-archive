import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// display text field and copy contents to canvas when clicked
// Clear screen when clicked on "clear" button
public class TextButtonController extends FrameWindowController 
                                  implements ActionListener {
    private JTextField input;
    private Text putText, clickText;
    private int clickAmt = 0 ;

    
        
    public void begin() {
      putText = new Text ("", 50, 50, canvas);
       clickText = new Text ("You have clicked " + clickAmt + " times", 60, 60, canvas);
        // construct text field and button
        input = new JTextField( "Enter text here" );  
        JButton textButton = new JButton( "Put Text" );
       
        // Add text field and button to content pane of window
        Container contentPane = getContentPane();
        contentPane.add( input, BorderLayout.NORTH );
        contentPane.add( textButton,BorderLayout.SOUTH );
        contentPane.validate();
        
        // Set this class to respond to button clicks
        textButton.addActionListener( this );
    }
    
    // Add new text item where clicked.
    // Get contents from text field
    public void onMouseClick( Location point ){
        new Text( input.getText(), point, canvas );
    }
    
    public void actionPerformed( ActionEvent evt ) {
      if( clickAmt == 1){
      putText.setText(input.getText());
      clickText.setText("You have clicked " + clickAmt + " time");
      clickAmt ++;
      }
      else{
        putText.setText(input.getText());
      clickText.setText("You have clicked " + clickAmt + " times");
      clickAmt ++;
      }
      
      
      
      
      
    }
}
