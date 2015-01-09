import RecordCollection.*;
import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class EditRecordGUI extends JFrame implements ActionListener {
 
  private JLabel title, genre, producer, releaseDate, numberOfTracks, format, commentary, goLabel;
  private JButton go;
  private JTextField titleText, genreText, producerText, releaseText, numberOfText, formatText, commentaryText;
  private JPanel centerPanel;
  
  public EditRecordGUI (Record r) {
    
    centerPanel = new JPanel();
    
    go = new JButton ("GO!");
    go.addActionListener(this);
   
    title = new JLabel("Album Title");
    genre = new JLabel("Genre");
    producer = new JLabel("Producer");
    releaseDate = new JLabel("Release Date");
    numberOfTracks = new JLabel("Number of Tracks");
    format = new JLabel("Format");
    commentary = new JLabel("Commentary");
    goLabel = new JLabel("Press Go When Finished");
    
    titleText = new JTextField(r.getTitle());
    genreText = new JTextField(r.getGenre());
    producerText = new JTextField(r.getProducer());
    releaseText = new JTextField(r.getReleaseDate());
    numberOfText = new JTextField(r.getNumber());
    formatText = new JTextField(r.getFormat());
    commentaryText = new JTextField(r.getCommentary());
    
    
    centerPanel.add(title);
    centerPanel.add(titleText);
    centerPanel.add(genre);
    centerPanel.add(genreText);
    centerPanel.add(producer);
    centerPanel.add(producerText);
    centerPanel.add(releaseDate);
    centerPanel.add(releaseText);
    centerPanel.add(numberOfTracks);
    centerPanel.add(numberOfText);
    centerPanel.add(format);
    centerPanel.add(formatText);
    centerPanel.add(commentary);
    centerPanel.add(commentaryText);
    centerPanel.add(goLabel);
    centerPanel.add(go);
    centerPanel.setLayout(new GridLayout(8,2));
    
    
    Container thisFrame = getContentPane();
    thisFrame.add(centerPanel, BorderLayout.CENTER);
    setVisible(true);
    setSize(400, 250);
  }
  
  
  
  public void actionPerformed (ActionEvent evt) {
    setVisible(false);
  }
  
  
  public static void main(Record [] args){
    new EditRecordGUI(args [0]);
  }
  
  
}