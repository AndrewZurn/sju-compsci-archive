import java.awt.*;
import java.awt.event.*;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * ScrollingPaneGUI shows how one can build the beginnings of a simple editor
 * using a JTextArea inside a JScrollPane.
 * 
 * @author Lynn Ziegler
 */
public class ScrollingPaneGUI extends JFrame 
  implements ActionListener {
  /* editorPlace is the JTextArea where we edit stuff. scrollBarThingy
   * is the scrollBars for that editor area. */
  private JTextArea editorPlace;
  private JScrollPane scrollBarThingy;
  /* printStuff is the button that shows how we can manipulate the stuff
   * in the editorPlace. We put it in panel jp for two reasons. First, if
   * we didn't it would grow large and ugly. Second, it makes it easy to
   * add more buttons and stuff to that panel later. */
  private JButton printStuff,quitButton;
  private JPanel jp;
  
  /**
   * This shows how to layout a button in the north and a scrolling JTextArea
   * in the center and activate them to do stuff. */
  public ScrollingPaneGUI() {
    //create the JPanel and add the button to it.
    jp=new JPanel();
    printStuff=new JButton("Print the stuff");
    printStuff.addActionListener(this);
    jp.add(printStuff);
    quitButton=new JButton("Quit");
    quitButton.addActionListener(this);
    jp.add(quitButton);
    add(jp,BorderLayout.NORTH);
    //create the scrolling edit area and add it to the screen.
    editorPlace=new JTextArea(60,60);
    GraphicsEnvironment ge=
      GraphicsEnvironment.getLocalGraphicsEnvironment();
    for(String s:ge.getAvailableFontFamilyNames()) {
      editorPlace.append(s+"\n");
    }
    scrollBarThingy=new JScrollPane(editorPlace);
    add(scrollBarThingy,BorderLayout.CENTER);
    setSize(300,300);
    setVisible(true);
  }
  
  /**
   * the only action is that of the printStuff button.
   */
  public void actionPerformed(ActionEvent e) {
    Object source=e.getSource();
    if(source==printStuff) {
      System.out.println(editorPlace.getText());
    }
    else if(source==quitButton) {
      System.exit(0);
    }
  }
  
  /**
   * Create an instance of this class.
   */
  public static void main(String [] args) {
    new ScrollingPaneGUI();
  }
}