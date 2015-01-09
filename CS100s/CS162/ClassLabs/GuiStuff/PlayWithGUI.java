import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * This class consists of one button that creates more instances of
 * this class. Each time, twice as many instances are created.
 */
public class PlayWithGUI extends JFrame implements ActionListener {
  //count is a variable shared by all instances. Thus, if it changes
  // it changes for all instances.
  public static int count=2;
  //playButton, when clicked, will create more instances of this class.
  private JButton playButton,killButton;
  
  //* create the playButton and make it "big" */
  public PlayWithGUI() {
    playButton=new JButton("Make more of me.");
    playButton.addActionListener(this);
    //set the font of the text in the button to bold, italic, size 30
    playButton.setFont(new Font("HelveticaBold",Font.ITALIC,30));
    add(playButton,BorderLayout.CENTER);
    setVisible(true);
    killButton=new JButton("Kill THEM ALL!");
    killButton.addActionListener(this);
    add(killButton,BorderLayout.EAST);
    pack();
  }
  
  /**
   * Only the button has action. It creates count new instances of this
   * class and, then, doubles count for the next press.
   */
  public void actionPerformed(ActionEvent e) {
    Object source=e.getSource();
    if(source==playButton) {
      int xOffset=100;
      int yOffset=0;
      PlayWithGUI next;
      for(int i=0;i<PlayWithGUI.count;i++) {
        next=new PlayWithGUI();
        next.setBounds(getX()+xOffset,getY()+yOffset,getWidth(),getHeight());
        yOffset=yOffset+60;
      }
      PlayWithGUI.count=2*PlayWithGUI.count;
    }
    else if(source==killButton) {
      System.exit(0);
    }
  }
  
  /**
   * Of course, main simply launches this GUI.
   */
  public static void main(String [] args) {
    new PlayWithGUI();
  }
}