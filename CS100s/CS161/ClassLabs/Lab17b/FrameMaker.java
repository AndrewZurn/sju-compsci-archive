import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// demonstrates the family of classes which extend FramedDisplay
public class FrameMaker extends FrameWindowController implements ActionListener {
    
    // coordinates and dimensions of the frame
    private static final double CORNER_X = 175;
    private static final double CORNER_Y = 100;
    private static final double HEIGHT = 30;
    private static final double WIDTH = 300;
    
    // what to put inside of a FramedText object
    private static final String LABEL = new String("Hello");
    
    // allows choice of objects
    private JComboBox choice;
    
    // the selected object
    private FrameIfc target;
    
    // changes the current target (if applicable)
    private JButton update;

    // highlights the target
    private JButton light;

    // un-highlight the target
    private JButton ulight;
    
    // draw the gui components and initialize target to be a FramedDisplay
    public void begin() {
        
        JPanel controlPanel = new JPanel();
        
        update = new JButton("Update");
        update.addActionListener(this);
        
        choice = new JComboBox();
        choice.addItem( new String("FramedDisplay"));
        choice.addItem( new String("FramedText"));
        choice.addItem( new String("FramedBarMeter"));
        choice.addItem( new String("FramedCounter"));
        choice.addActionListener(this);
        
        light = new JButton("Highlight");
        light.addActionListener(this);

        ulight = new JButton("Un-Highlight");
        ulight.addActionListener(this);

        controlPanel.add(update);
        controlPanel.add(choice);
        controlPanel.add(light);
        controlPanel.add(ulight);
        
        Container contentPane = getContentPane();
        contentPane.add(controlPanel, BorderLayout.SOUTH);
        
        target = new FramedDisplayTester(CORNER_X, CORNER_Y, WIDTH, HEIGHT, canvas);
        
    }
    
    // if the update button was pressed, update target
    // otherwise, change target to the selected object type
    public void actionPerformed( ActionEvent evt ){
        Object selected = choice.getSelectedItem();
        
        if (evt.getSource() == update){
            target.update();
        }
        else if (evt.getSource() == light){
            target.highlight();
        }
        else if (evt.getSource() == ulight){
            target.unHighlight();
        }
        else {
            canvas.clear();
            if (selected.equals("FramedDisplay")){
                target = new FramedDisplayTester(CORNER_X, CORNER_Y, WIDTH,
                                                 HEIGHT, canvas);
            }
            else if (selected.equals("FramedText")){
                target = new FramedTextTester( LABEL, CORNER_X, CORNER_Y,
                                               WIDTH, HEIGHT, canvas);
            }
            else if (selected.equals("FramedBarMeter")){
                target = new FramedBarMeterTester( .5, CORNER_X, CORNER_Y,
                                                   WIDTH, HEIGHT, canvas);
            }
            else {
                target = new FramedCounterTester( CORNER_X, CORNER_Y,
                                                  WIDTH, HEIGHT, canvas);
            }
        }
        
    }
    
    
}
