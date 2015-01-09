import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// this class allows the user to type urls into a text field.  Matching urls 
// are displayed below.

// NOTE:
// This class uses a DocumentListener to monitor a text component for changes.
// The DocumentListener is not described in the textbook, but it is necessary
// to use this type of listener rather than a KeyListener in order to properly
// interpret the information being entered or removed from the text component. 

public class UrlListController extends FrameController
                               implements ActionListener, DocumentListener {
    
    private static final int ROWS = 10; // rows in TextArea
    private static final int COLS = 30; // cols in text field & area
    
    private JTextField inField;         // Input field
    private JTextArea output;           // output area
    private UrlListIfc theList;         // the list of urls

    public void begin() {
        Container contentPane = getContentPane();
        
        JPanel topPanel = new JPanel();      // prepare text field & label
        JLabel inLabel = new JLabel("Type urls here:");
        inField = new JTextField(COLS);
        inField.addActionListener(this);
        inField.getDocument().addDocumentListener(this);
        
        topPanel.add(inLabel);
        topPanel.add(inField);
        contentPane.add(topPanel, BorderLayout.NORTH);
        
        JPanel centerPanel = new JPanel();     // prepare text area & label
        JLabel outLabel = new JLabel("Matches:");
        output = new JTextArea(ROWS, COLS);
        output.setEditable(false);
        
        centerPanel.add(outLabel);
        centerPanel.add(new JScrollPane(output));
        contentPane.add(centerPanel, BorderLayout.CENTER);
        
        validate();
        
        theList = new EmptyUrlList();
    }
    
    // add url to list if user presses enter and url is not in the list
    public void actionPerformed(ActionEvent evt) {
        String text = new String( inField.getText() );
        if( !theList.contains(text) ){
            theList = new NonemptyUrlList( text, theList );
            output.setText(text);
        }
    }
    
    // display matching urls from the list when information is added 
    // to the JTextField
    public void insertUpdate( DocumentEvent evt ) {
        UrlListIfc matches = theList.getMatches( inField.getText() );
        output.setText( matches.toString() );
    }
    
    // display matching urls from the list when information in the JTextField
    // is removed
    public void removeUpdate( DocumentEvent evt ) {
        UrlListIfc matches = theList.getMatches( inField.getText() );
        output.setText( matches.toString() );
    }

    // necessary for compliance with DocumentListener interface
    public void changedUpdate( DocumentEvent evt ) {
    }
}
