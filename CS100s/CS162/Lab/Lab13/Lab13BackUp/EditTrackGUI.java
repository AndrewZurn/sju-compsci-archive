import RecordCollection.*;
import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class EditTrackGUI extends JFrame implements ActionListener {
  
  private JTextField titleText, lengthText, numberText, ratingText, releaseText;
  private JLabel title, length, number, rating, release, goLabel, people;
  private JButton go, editPeople;
  private JPanel centerPanel;
  private Track track;
  private ArrayList<MusicPeople> input;
  private TreeMap<String, Track> trackMap;
  
  public EditTrackGUI (Track t, TreeMap<String, Track> trackMap) {
    
    track = t;
    this.trackMap=trackMap;
    
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
    people = new JLabel ("Press To Edit People");
    
    go = new JButton ("GO!");
    go.addActionListener(this);
    editPeople = new JButton ("Who Worked On This Song");
    editPeople.addActionListener(this);
    
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
    centerPanel.add(editPeople);
    centerPanel.add(goLabel);
    centerPanel.add(go);
    centerPanel.setLayout(new GridLayout(7,2));
    
    Container thisFrame =  getContentPane();
    thisFrame.add(centerPanel, BorderLayout.CENTER);
    setVisible(true);
    setSize(500, 200);
    
  }
  
  public Track getEditedTrack () {
   return track; 
  }
  
  public TreeMap<String, Track> getTrackMap(){
    return trackMap;
  }
  
  public void actionPerformed (ActionEvent evt) {
    Object source=evt.getSource();
    trackMap.remove(track.getTitle());
    if (source == editPeople) {
      input = track.getPeople();
      for (int i = 0; i < input.size(); i++){
        new EditPeopleGUI (input.get(i)); 
      }
    }
    else {
      track.changeRating(ratingText.getText());
      track.changeReleaseDate(releaseText.getText());
      track.changeTrackNum(numberText.getText());
      track.changeLength(lengthText.getText());
      track.changeTitle(titleText.getText());
      trackMap.put(track.getTitle(), track);
      setVisible(false); 
    }
  }
  
//  public static void main(Track [] args){
//    new EditTrackGUI(args [0]);
//  }
  
  
}