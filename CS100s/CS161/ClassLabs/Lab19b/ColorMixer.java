import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Class which implements an applet which displays the color selected
// using three text fields.  It illustrates the use of the try-catch
// clause.
public class ColorMixer extends FrameWindowController implements ActionListener {

    // JTextFields to display current value of each color
    private JTextField redValueField, greenValueField, blueValueField;
    
    private FilledRect colorRect; // Rectangle displaying chosen color
    
    // Set up JTextFields and JLabels on panels
    public void begin() {
 
 redValueField = new JTextField("0", 3);
 greenValueField = new JTextField("0", 3);
 blueValueField = new JTextField("0", 3);

 // JLabels for color controlled by each of the three text fields
 JLabel redJLabel = new JLabel("Red", JLabel.RIGHT);
 JLabel blueJLabel = new JLabel(" Blue", JLabel.RIGHT);
 JLabel greenJLabel = new JLabel("Green", JLabel.RIGHT);
 
        // Set up panel to hold three text fields and their JLabels
        JPanel selectorPanel = new JPanel();
        
        // We want the JLabels and text fields to be next to each other, 
 // so we will use a GridLayout
        // This gives us:
        //    3 rows, one for each color
        //    2 columns, one for the JLabel, one for the text field
        //    10 pixels between the JLabel and text field
        //    5 pixels beween rows
        selectorPanel.setLayout(new GridLayout(3, 2, 10, 5));
 
 // Set up the JLabels and text fields
        selectorPanel.add(redJLabel);
        selectorPanel.add(redValueField);
        
        selectorPanel.add(blueJLabel);
        selectorPanel.add(blueValueField);
        
        selectorPanel.add(greenJLabel);
        selectorPanel.add(greenValueField);
        
        // Add listeners to the fields so we know when the user changes the value.
        redValueField.addActionListener(this);
        blueValueField.addActionListener(this);
        greenValueField.addActionListener(this);
        
        // Add panel to content pane of window
        Container contentPane = getContentPane();
        contentPane.add(selectorPanel, "South");
        contentPane.validate();
        
        // create color display
        colorRect =
            new FilledRect(0, 0, canvas.getWidth(), canvas.getHeight(), canvas);
    }
    
    // Get the value out of a text field and convert it to an integer.  
    // If the value cannot be converted to an integer, set it to zero.
    private int getColorMix(JTextField field) {
        String stringValue = field.getText();
        int mix;
        mix = Integer.parseInt(stringValue);
        
        return mix;
    }
    
    // This method is called whenever the user hits carriage return in a 
    // text field.  It repaints the colorRect with the color obtained from 
    // the text field values.
    public void actionPerformed(ActionEvent evt) {
        // get component color values
        int redValue = getColorMix(redValueField);
        int greenValue = getColorMix(greenValueField);
        int blueValue = getColorMix(blueValueField);
        
        // Create the new color and make it the color for colorRect
        Color newColor = new Color(redValue, greenValue, blueValue);
        colorRect.setColor(newColor);
    }
}
