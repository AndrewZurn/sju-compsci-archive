import RecordCollection.*;
import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class EditTrackGUI extends JFrame implements ActionListener {
  
  private JTextField titleText, lengthText, numberText, ratingText, releaseText;
  private JLabel title, length, number, rating, release, goLabel;
  private JButton go;
  private JPanel centerPanel;
  
  public EditTrackGUI (Track t) {
    
    centerPanel = new JPanel();
    
    titleText = new JTextField (t.getTitle());
    lengthText = new JTextField (t.getLength());
    numberText = new JTextField (t.getTrackNum());
    ratingText = new JTextField (t.getRating());
    releaseText = new JTextField (t.getReleaseDate());
    
    title = new JLabel ("Title");
    length = new JLabel ("Song Length");
    number = new JLabel ("Song Number");
    rating = new JLabel ("Song Rating");
    release = new JLabel ("Release Date");
    goLabel = new JLabel("Press Go When Finished");
    
    go = new JButton ("GO!");
    go.addActionListener(this);
    
    centerPanel.add(title);
    centerPanel.add(titleText);
    centerPanel.add(length);
    centerPanel.add(lengthText);
    centerPanel.add(number);
    centerPanel.add(numberText);
    centerPanel.add(rating);
    centerPanel.add(ratingText);
    centerPanel.add(release);
    centerPanel.add(releaseText);
    centerPanel.add(goLabel);
    centerPanel.add(go);
    centerPanel.setLayout(new GridLayout(6,2));
    
    Container thisFrame =  getContentPane();
    thisFrame.add(centerPanel, BorderLayout.CENTER);
    setVisible(true);
    setSize(450, 200);
    
  }
  
  public void actionPerformed (ActionEvent evt) {
    setVisible(false); 
  }
  
  public static void main(Track [] args){
    new EditTrackGUI(args [0]);
  }
  
  
}