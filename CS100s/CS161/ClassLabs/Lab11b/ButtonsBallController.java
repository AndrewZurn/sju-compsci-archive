import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Control speed of falling ball with buttons
public class ColoredBoxController extends FrameWindowController 
                                   implements ActionListener {
    
   // private static final int SLOW_SPEED = 2,  // slow setting
                             //MEDIUM_SPEED = 4,// medium setting
                             //FAST_SPEED = 6;  // fast setting

    private FilledRect rect; // the falling ball
    
    private JButton redButton,       // Buttons to control speed
                    blueButton,
                    yellowButton,
                    blackButton;
    private Color color;
                               
    //private int speed;                // Current speed setting
    
    // display buttons
    public void begin() {
        //speed = SLOW_SPEED;
        
        JPanel southPanel = new JPanel();
        
        redButton = new JButton( "RED" );
        blueButton = new JButton( "BLUE" );
        yellowButton = new JButton( "YELLOW" );
        blackButton = new JButton("BLACK");
        
        fastButton.addActionListener( this );
        mediumButton.addActionListener( this );
        slowButton.addActionListener( this );
        quitButton.addActionListener( this );
        
        southPanel.add( redButton );
        southPanel.add( blueButton );
        southPanel.add( yellowButton );
        southPanel.add( blackButton );
        southPanel.setLayout( new GridLayout(1,4));
         
        Container contentPane = getContentPane();
        contentPane.add( southPanel, BorderLayout.SOUTH );
        contentPane.validate();
    }
    
    // make a new ball when the player clicks
    public void onMouseClick( Location point ) {
        rect = new FilledRect( point, 25, 25, canvas);
        rect.setColor(color);
    }

    // set new speed when the player clicks a button
    public void actionPerformed( ActionEvent evt ) {
        if ( evt.getSource() == redButton ) {
            color = Color.RED;
        } else if ( evt.getSource() == blueButton ) {
            color = Color.BLUE;
        } else if(evt.getSource() == yellowButton ) {
          color = Color.YELLOW;
        } else {
            color = Color.BLACK;
        }
        
 
        
    }
    
}
