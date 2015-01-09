import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * This program illustrates the use of popup
 * menus and MouseListener.
 */
public class PopupAndMouseListener extends JFrame
  implements ActionListener,MouseListener {
  private JPopupMenu rightClickMenu,leftClickMenu;
  private JMenuItem red,green,blue,black,quit,clear;
  private JTextArea textArea;
  
  public PopupAndMouseListener() {
    /* Note that JPopupMenu is created much like
       JMenu. You create it and add items to it.
       The items are attached to an ActionListener.*/
    rightClickMenu=new JPopupMenu("Right");
    leftClickMenu=new JPopupMenu("Left");
    red=new JMenuItem("red");
    red.addActionListener(this);
    green=new JMenuItem("green");
    green.addActionListener(this);
    blue=new JMenuItem("blue");
    blue.addActionListener(this);
    black=new JMenuItem("black");
    black.addActionListener(this);
    quit=new JMenuItem("quit");
    quit.addActionListener(this);
    clear=new JMenuItem("clear");
    clear.addActionListener(this);
    rightClickMenu.add(red);
    rightClickMenu.add(green);
    rightClickMenu.add(blue);
    rightClickMenu.add(black);
    leftClickMenu.add(quit);
    leftClickMenu.add(clear);
    Container contentPane=getContentPane();
    
    /* We are adding a MouseListener to the
     * textArea. */
    textArea=new JTextArea(30,30);
    textArea.addMouseListener(this);
    contentPane.add(textArea);
    setSize(300,300);
  }
  public void actionPerformed(ActionEvent e) {
    Object source=e.getSource();
    if(source==red) {
      textArea.setForeground(Color.red);
    }
    else if(source==green) {
      textArea.setForeground(Color.green);
    }
    else if(source==blue) {
      textArea.setForeground(Color.blue);
    }
    else if(source==black) {
      textArea.setForeground(Color.black);
    }
    else if(source==quit) {
      System.exit(0);
    }
    else if(source==clear) {
      textArea.setText("");
    }
  }
  
  /**
   * Note that implementing a MouseListener
   * means that you need to implement all 5 of 
   * the following methods.
   *    mouseClicked acts when a full click is
   *        completed on the object with the
   *        MouseListener.
   *    mouseEntered acts when you move onto
   *        the object with the MouseListener
   *    mouseExited acts when you move off of
   *        the object with the MouseListener.
   *    mousePressed responds when you press
   *        a mouse button on the object.
   *    mouseReleased responds when you release
   *        a mouse button on the object.
   */
  public void mouseClicked(MouseEvent e) {
  }
  public void mouseEntered(MouseEvent e) {
  }
  public void mouseExited(MouseEvent e) {
  }
  public void mousePressed(MouseEvent e) {
    if(e.getComponent()==textArea) {
      if(e.getButton()==MouseEvent.BUTTON1) {
        leftClickMenu.show(e.getComponent(),20,20);
      }
      else if(e.getButton()==MouseEvent.BUTTON3) {
        rightClickMenu.show(e.getComponent(),20,20);
      }
    }
  }
  public void mouseReleased(MouseEvent e) {
  }
  public static void main(String [] args) {
    new PopupAndMouseListener().setVisible(true);
  }
}