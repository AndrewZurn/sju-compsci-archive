import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Typing in the text field and hitting return adds text to text area.
// Clicking on button erases the text area.
public class TextApplication extends FrameController implements ActionListener {
    private static final int ROWS = 10; // rows in TextArea
    private static final int COLS = 30; // cols in text field & area
    
    private JTextField inField;         // Input field
    private JTextArea output;           // output area
    private JButton clear;              // button to clear output

    public void begin() {
        Container contentPane = getContentPane();
        JPanel topPanel = new JPanel();       // prepare text field & label
        JLabel inLabel = new JLabel("Type input here:");
        inField = new JTextField(COLS);
        inField.addActionListener(this);

        topPanel.add(inLabel);
        topPanel.add(inField);
        contentPane.add(topPanel,BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();     // prepare text area & label
        JLabel outLabel = new JLabel("Output:");
        output = new JTextArea(ROWS, COLS);
        output.setEditable(false);        // Prevent user from wrting in output
        centerPanel.add(outLabel);
        centerPanel.add(new JScrollPane(output));
        contentPane.add(centerPanel,BorderLayout.CENTER);
        
        JPanel bottomPanel = new JPanel();     // create button
        clear = new JButton("clear output");
        clear.addActionListener(this);
        bottomPanel.add(clear);
        contentPane.add(bottomPanel,BorderLayout.SOUTH);
        validate();
    }

    // add text to area if user hits return, else erase text area
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == inField){
            output.append(inField.getText()  );
            inField.setText("");
        } else {
            output.setText("");
        }
    }
}
