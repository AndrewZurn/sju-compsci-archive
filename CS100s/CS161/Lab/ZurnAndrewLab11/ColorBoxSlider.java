import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// Zurn, Andrew   and  Xu, Runbo    Color Box

public class ColorBoxSlider extends FrameWindowController implements ChangeListener{
  
  private FilledRect rect;
  private Location rectPos = new Location (25, 25);
  //private double RECT_WIDTH;
  //private double RECT_HEIGHT;
  private int LOW_COLOR = 0;
  private int HIGH_COLOR = 255;
  
  private JSlider redField, greenField, blueField;
  private JLabel redLabel, greenLabel, blueLabel, redValue, greenValue, blueValue;
  
  private int red, green, blue;
  private Color newColor;
  
  
  public void begin(){
    
    rect = new FilledRect( 0, 0, canvas.getWidth(), canvas.getHeight(), canvas);
    rect.setColor(Color.WHITE);
    
    JPanel southPanel = new JPanel();
    
    redField = new JSlider(JSlider.HORIZONTAL, LOW_COLOR, HIGH_COLOR, HIGH_COLOR);
    greenField = new JSlider(JSlider.HORIZONTAL, LOW_COLOR, HIGH_COLOR, HIGH_COLOR);
    blueField = new JSlider(JSlider.HORIZONTAL, LOW_COLOR, HIGH_COLOR, HIGH_COLOR);
    
    
    redField.addChangeListener( this );
    greenField.addChangeListener( this );
    blueField.addChangeListener( this );
    
    redLabel = new JLabel("Red", JLabel.RIGHT );
    greenLabel = new JLabel("Green", JLabel.RIGHT );
    blueLabel = new JLabel("Blue", JLabel.RIGHT );
    redValue = new JLabel("" + redField.getValue());
    greenValue = new JLabel("" + greenField.getValue());
    blueValue = new JLabel("" + blueField.getValue());
    
    southPanel.add(redLabel);
    southPanel.add(redField);
    southPanel.add(redValue);
    southPanel.add(greenLabel);
    southPanel.add(greenField);
    southPanel.add(greenValue);
    southPanel.add(blueLabel);
    southPanel.add(blueField);
    southPanel.add(blueValue);
    southPanel.setLayout(new GridLayout (3, 3));
    
    Container contentPane = getContentPane();
    contentPane.add(southPanel, BorderLayout.SOUTH);
    contentPane.validate();
    
  }
  
  
  public void stateChanged( ChangeEvent evt){
    red = redField.getValue();
    green = greenField.getValue();
    blue = blueField.getValue();
    if(red>=0 && red<=255 && green>=0 && green<=255 && blue>=0 && blue<=255){
      newColor = new Color(red, green, blue);
      rect.setColor(newColor);
      redValue.setText(" " + red);
      greenValue.setText(" " + green);
      blueValue.setText(" " + blue);
      
    }
    
    else{
      System.out.println("Error, Please Enter Values between 0 and 255");
    }
    
    
    
  }
}
