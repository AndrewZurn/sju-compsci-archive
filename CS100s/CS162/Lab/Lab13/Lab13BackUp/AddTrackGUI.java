import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import RecordCollection.*;
import java.util.*;

public class AddTrackGUI extends JFrame implements ActionListener {
  
  private JTextField titleText, lengthText, numberText, ratingText, releaseText;
  private JLabel title, length, number, rating, release, people, goLabel, addAnother;
  private JButton go, addPeople, addAnotherButton;
  private JPanel centerPanel;
  private ArrayList<Track> tracksList;
  private String trackTitle, trackLength, trackNumber, trackRating, trackRelease;
  private AddPeopleGUI addPeopleGUI;
  
  public AddTrackGUI () {
    
    centerPanel = new JPanel();
    
    titleText = new JTextField ("");
    lengthText = new JTextField ("");
    numberText = new JTextField ("");
    ratingText = new JTextField ("");
    releaseText = new JTextField ("");
    
    title = new JLabel ("Title");
    length = new JLabel ("Song Length");
    number = new JLabel ("Song Number");
    rating = new JLabel ("Song Rating");
    release = new JLabel ("Release Date");
    people = new JLabel ("Press To Add People");
    goLabel = new JLabel("Press Go When Last Track Entered");
    addAnother = new JLabel("Add This Track");
    
    go = new JButton ("GO!");
    addAnotherButton = new JButton ("Add");
    addAnotherButton.addActionListener(this);
    
    go.addActionListener(this);
    addPeople = new JButton ("That Worked On The Song");
    addPeople.addActionListener(this);
    
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
    centerPanel.add(people);
    centerPanel.add(addPeople);
    centerPanel.add(addAnother);
    centerPanel.add(addAnotherButton);
    centerPanel.add(goLabel);
    centerPanel.add(go);
    centerPanel.setLayout(new GridLayout(8,2));
    
    Container thisFrame =  getContentPane();
    thisFrame.add(centerPanel, BorderLayout.CENTER);
    setVisible(true);
    setSize(510, 200);
    
    tracksList = new ArrayList<Track>();
  }
  
  public ArrayList<Track> getTrackList(){
    return tracksList;
  }
  
  public void actionPerformed (ActionEvent evt) {
    Object source=evt.getSource();
    if (source == addPeople) {
      addPeopleGUI = new AddPeopleGUI();
    }
    else if(source == addAnotherButton){
      trackTitle = titleText.getText();
      trackLength = lengthText.getText();
      trackNumber = numberText.getText();
      trackRating = ratingText.getText();
      trackRelease = releaseText.getText();
      titleText.setText("");
      lengthText.setText("");
      numberText.setText("");
      ratingText.setText("");
      releaseText.setText("");
      tracksList.add(new Track(trackTitle, trackLength, trackNumber,
                               trackRating, trackRelease, addPeopleGUI.returnMusicPeople()));
    }
    else {
      tracksList.add(new Track(trackTitle, trackLength, trackNumber,
                               trackRating, trackRelease, addPeopleGUI.returnMusicPeople()));
     setVisible(false); 
    }
  }
  
  public Track returnTrack(){
    return null;
  }
  
  public static void main(String [] args){
    new AddTrackGUI();
  }
  
  
}