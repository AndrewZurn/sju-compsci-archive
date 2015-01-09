import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import RecordCollection.*;
import java.util.*;

public class AddRecordGUI extends JFrame implements ActionListener {
 
  private JLabel title, artistName, genre, producer, releaseDate, numberOfTracks, tracks, format, commentary, goLabel;
  private JButton go, addTrack, addArtist;
  private JTextField titleText, genreText, producerText, releaseText, numberOfText, formatText, commentaryText;
  private JPanel centerPanel;
  private AddTrackGUI addTrackGUI;
  private AddArtistGUI addArtistGUI;
  private String recordTitle, recordGenre, recordProducer, recordReleaseDate,
    numTracks, recordFormat, recordCommentary;
  private ArrayList<Track> trackList;
  private TreeMap<String, Record> recordMap;
  private TreeMap<String, Track> trackMap;
  private TreeMap<String, Artist> artistMap;
  private ArrayList<Artist> artistList;
  
  public AddRecordGUI (TreeMap<String, Record> recordMap, TreeMap<String, Track> trackMap,
                       TreeMap<String, Artist> artistMap) {
    
    this.recordMap = recordMap;
    this.trackMap = trackMap;
    this.artistMap = artistMap;
    
    artistList = new ArrayList<Artist>();
    
    centerPanel = new JPanel();
    
    go = new JButton ("GO!");
    addTrack = new JButton("Add Tracks to Album");
    addArtist = new JButton("Add Artists to Album");
    go.addActionListener(this);
    addTrack.addActionListener(this);
    addArtist.addActionListener(this);
   
    title = new JLabel("Album Title");
    artistName = new JLabel("Press To Add Artist");
    genre = new JLabel("Genre");
    producer = new JLabel("Producer");
    releaseDate = new JLabel("Release Date");
    numberOfTracks = new JLabel("Number of Tracks");
    tracks = new JLabel("Press To Add Tracks");
    format = new JLabel("Format");
    commentary = new JLabel("Commentary");
    goLabel = new JLabel("Press Go When Finished");
    
    titleText = new JTextField("");
    genreText = new JTextField("");
    producerText = new JTextField("");
    releaseText = new JTextField("");
    numberOfText = new JTextField("");
    formatText = new JTextField("");
    commentaryText = new JTextField("");
    
    
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
    centerPanel.add(tracks);
    centerPanel.add(addTrack);
    centerPanel.add(artistName);
    centerPanel.add(addArtist);
    centerPanel.add(goLabel);
    centerPanel.add(go);
    centerPanel.setLayout(new GridLayout(10,2));
    
    
    Container thisFrame = getContentPane();
    thisFrame.add(centerPanel, BorderLayout.CENTER);
    setVisible(true);
    setSize(400, 250);
  }
  
  public TreeMap<String, Record> getRecordMap(){
    return recordMap;
  }
  
  public TreeMap<String, Artist> getArtistMap(){
      return addArtistGUI.getArtistMap();
  }
  
  public TreeMap<String, Track> getTrackMap(){
      return addTrackGUI.getTrackMap();
  }
  
  
  
  public void actionPerformed (ActionEvent evt) {
    Object source=evt.getSource();
    if (source == addTrack) {
      addTrackGUI = new AddTrackGUI(trackMap);
    }
    else if (source == addArtist) {
      addArtistGUI = new AddArtistGUI(artistMap);
    }
    else {
      artistList = addArtistGUI.getArtistList();
      recordTitle = titleText.getText();
      recordGenre = genreText.getText();
      recordProducer = producerText.getText();
      recordReleaseDate = releaseText.getText();
      numTracks = numberOfText.getText();
      recordCommentary = commentaryText.getText();
      recordFormat = formatText.getText();
      Record record = new Record(recordTitle, artistList, recordGenre, recordProducer, recordReleaseDate,
                 numTracks, trackList, recordFormat, recordCommentary);
      recordMap.put(recordTitle, record);
      setVisible(false);
    }
    
    
  }

//  public static void main(String [] args){
//    new AddRecordGUI();
//  }
  
}