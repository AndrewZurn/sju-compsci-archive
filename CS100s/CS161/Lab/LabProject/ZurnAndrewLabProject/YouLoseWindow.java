import objectdraw.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

/** 
  * A pop-up class used when the used acquires three strikes
  * @author Andrew Zurn
  */

public class YouLoseWindow extends FrameWindowController implements ActionListener{
  
  /** lines of text used on the canvas */
  private Text line1, line2, line3;
  
  /** JButton used to exit the system */
  private JButton exit;
  
  /** int used to display the acquired score on the screen */
  private int theScore;
  
  /**
   * Contructor of the YouLoseWindow with a paramter of the score acquired in-game
   * @param score the score acquired inside the game
   */
  public YouLoseWindow(int score){
    theScore = score;
  }
  
  public void begin(){
    line1 = new Text ( "You Earned 3 Strikes!!!", 
                      (canvas.getWidth()/2) - 140, (canvas.getHeight()/2) - 45, canvas);
    line2 = new Text ( "You Lose!", (canvas.getWidth()/2) - 90, (canvas.getHeight()/2) - 25, canvas);
    line3 = new Text ( "Your Score was " + theScore + "!", (canvas.getWidth()/2) - 65,
                      canvas.getHeight() - 45, canvas);
    line2.setBold();
    line1.setFontSize(25);
    line2.setFontSize(35);
    line3.setFontSize(15);
    Container contentPane = getContentPane();
    exit = new JButton ("Exit Game");
    exit.addActionListener( this );
    contentPane.add(exit, BorderLayout.SOUTH);
  }
  
  /**
   * determines when a GUI compenent is used
   * @param evt the GUI compenent used
   */
  public void actionPerformed(ActionEvent evt){
    if (evt.getSource() == exit){
      System.exit(0);
    }
  }
}