import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Zurn, Andrew   and  Xu, Runbo    Color Box

public class ColorBox extends FrameWindowController implements KeyListener{
  
  private FilledRect rect;
  private Location rectPos = new Location (25, 25);
  //private double RECT_WIDTH;
  //private double RECT_HEIGHT;
  
  private JTextField redField, greenField, blueField;
  private JLabel redLabel, greenLabel, blueLabel;
  
  private int red, green, blue;
  private Color newColor;
  
  
  public void begin(){
    
    rect = new FilledRect( 0, 0, canvas.getWidth(), canvas.getHeight(), canvas);
    rect.setColor(Color.WHITE);
    
    JPanel southPanel = new JPanel();
    
    redField = new JTextField("255", JTextField.LEFT);
    greenField = new JTextField("255", JTextField.LEFT);
    blueField = new JTextField("255", JTextField.LEFT);
    new Text ("Enter values between 0 and 255 to change the box color", 0, 0, canvas);
    
    redField.addKeyListener( this );
    greenField.addKeyListener( this );
    blueField.addKeyListener( this );
    
    redLabel = new JLabel("Red", JLabel.RIGHT );
    greenLabel = new JLabel("Green", JLabel.RIGHT );
    blueLabel = new JLabel("Blue", JLabel.RIGHT );
    
    southPanel.add(redLabel);
    southPanel.add(redField);
    southPanel.add(greenLabel);
    southPanel.add(greenField);
    southPanel.add(blueLabel);
    southPanel.add(blueField);
    southPanel.setLayout(new GridLayout (3, 2));
    
    Container contentPane = getContentPane();
    contentPane.add(southPanel, BorderLayout.SOUTH);
    contentPane.validate();
    
  }
  
  public void keyReleased(KeyEvent e){}
  public void keyTyped(KeyEvent e){}
  
  public void keyPressed( KeyEvent e){
    int key = e.getKeyCode();
    if ( key == KeyEvent.VK_ENTER){
      red = Integer.parseInt(redField.getText());
      green = Integer.parseInt(greenField.getText());
      blue = Integer.parseInt(blueField.getText());
      if(red>=0 && red<=255 && green>=0 && green<=255 && blue>=0 && blue<=255){
        newColor = new Color(red, green, blue);
        rect.setColor(newColor);
        
      }
      
      else{
        System.out.println("Error, Please Enter Values between 0 and 255");
      }
      
      
      
    }
  }
}