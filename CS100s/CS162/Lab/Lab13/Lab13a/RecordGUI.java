import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import RecordCollection.*;
import fileStuff.*;
import java.io.*;
import java.util.*;

public class RecordGUI extends JFrame  implements ActionListener {
  private Container thisFrame;
  private JPanel southPanel, topSouth, botSouth, midSouth;
  private JComboBox comboBox;
  private JTextField inputField;
  private JTextArea field;
  private JButton searchButton, displayButton, editButton, addRecordButton,
    addTrackButton, addArtistButton, helpButton, systemExit;
  private JMenuBar myMenuBar;
  private JMenu fileMenu;
  private JMenuItem quitItem, helpItem;
  private JScrollPane scrolly;
  private ObjectInputStream artist, record, track;
  private TreeMap<String, Artist> myArtists;
  private TreeMap<String, Record> myRecords;
  private TreeMap<String, Track> myTracks;
  private AddTrackGUI addTrackGUI;
  private AddRecordGUI addRecordGUI;
  private AddArtistGUI addArtistGUI;
  private EditArtistGUI editArtistGUI;
  private EditRecordGUI editRecordGUI;
  private EditTrackGUI editTrackGUI;
  
  
  public RecordGUI() throws Exception {
    
    artist = FileChooser.openObjectReader();
    record = FileChooser.openObjectReader();
    track = FileChooser.openObjectReader();
    
    myArtists =  (TreeMap<String,Artist>) artist.readObject();
    myRecords = (TreeMap<String,Record>) record.readObject();
    myTracks = (TreeMap<String,Track>) track.readObject();
    
    myMenuBar=new JMenuBar();
    setJMenuBar(myMenuBar);
    fileMenu = new JMenu("File");
    quitItem = new JMenuItem("Exit");
    quitItem.addActionListener(this);
    helpItem = new JMenuItem("Help");
    helpItem.addActionListener(this);
    fileMenu.add(helpItem);
    fileMenu.add(quitItem);
    myMenuBar.add(fileMenu);
    
    
    comboBox = new JComboBox();
    comboBox.addItem("Record/Album");
    comboBox.addItem("Track");
    comboBox.addItem("Artist");
    
    field = new JTextArea(100,100);
    field.setEditable(false);
    field.setLineWrap(true);
    scrolly = new JScrollPane(field);
    
    searchButton = new JButton("Search");
    displayButton = new JButton("Display All");
    editButton = new JButton("Edit Something");
    addRecordButton = new JButton("Add Record");
    addTrackButton = new JButton("Add Track");
    addArtistButton = new JButton("Add Artist");
    helpButton = new JButton("Help");
    systemExit = new JButton("Exit");
    searchButton.addActionListener(this);
    displayButton.addActionListener(this);
    editButton.addActionListener(this);
    addRecordButton.addActionListener(this);
    addTrackButton.addActionListener(this);
    addArtistButton.addActionListener(this);
    helpButton.addActionListener(this);
    systemExit.addActionListener(this);
    
    inputField = new JTextField("User Input Area");
    
    southPanel = new JPanel();
    topSouth = new JPanel();
    botSouth = new JPanel();
    midSouth = new JPanel();
    topSouth.add(inputField);
    topSouth.add(searchButton);
    midSouth.add(addRecordButton);
    midSouth.add(addTrackButton);
    midSouth.add(addArtistButton);
    midSouth.add(editButton);
    botSouth.add(comboBox);
    botSouth.add(displayButton);
    botSouth.add(helpButton);
    botSouth.add(systemExit);
    southPanel.add(topSouth);
    southPanel.add(midSouth);
    southPanel.add(botSouth);
    southPanel.setLayout(new GridLayout(3,1));
    
    thisFrame=getContentPane();
    thisFrame.add(scrolly,BorderLayout.CENTER);
    thisFrame.add(southPanel,BorderLayout.SOUTH);
    setVisible(true);
    setSize(800,600);
  }
  
  
  public Track getTrack(){
    return null;
  }
  public Artist getArtist(){
    return null;
  }
  public Record getRecord(){
    return null;
  }
  
  public void actionPerformed(ActionEvent evt) {
    Object source=evt.getSource();
    if (source == quitItem) {
      exit();
    }
    
    else if (source == searchButton) {
      field.setText("");
      String searchText =inputField.getText();;
      if(comboBox.getSelectedItem() == "Artist"){
        for(String s: myArtists.keySet()){
          if(searchText.equalsIgnoreCase(s)){
            field.setText(myArtists.get(s).toString());
            break;
          }
          else{
            field.setText("The Searched Item Could Not Be Found!");
          }
        }
      }
      else if(comboBox.getSelectedItem() == "Record/Album"){
      for(String s: myRecords.keySet()){
          if(searchText.equalsIgnoreCase(s)){
            field.setText(myRecords.get(s).toString().replaceAll("[,]","").replace("[","").replace("]",""));
            break;
          }
          else{
            field.setText("The Searched Item Could Not Be Found!");
          }
        }
      }
      else if(comboBox.getSelectedItem() == "Track"){
        for(String s: myTracks.keySet()){
          if(searchText.equalsIgnoreCase(s)){
            field.setText(myTracks.get(s).toString());
            break;
          }
          else{
            field.setText("The Searched Item Could Not Be Found!");
          }
        }
      }
    }
      
    else if (source == displayButton) {
      field.setText("");
      if(comboBox.getSelectedItem() == "Artist"){
        for (String s: myArtists.keySet()) {
          field.append(myArtists.get(s).toString() + "\n");
        }
      }
      else if(comboBox.getSelectedItem() == "Record/Album"){
        for (String s: myRecords.keySet()) {
          field.append(myRecords.get(s).toString().replaceAll("[,]","").replace("[","").replace("]","") + "\n");
        }
      }
      else if(comboBox.getSelectedItem() == "Track"){
        for (String s: myTracks.keySet()) {
          field.append(myTracks.get(s).toString() + "\n");
        }
      }
    }
    
    else if (source == editButton) {
      String edited = inputField.getText();
      if(comboBox.getSelectedItem() == "Artist"){
        for(String s: myArtists.keySet()){
          if(edited.equalsIgnoreCase(s)){
            editArtistGUI = new EditArtistGUI(myArtists.get(s), myArtists);
          }
        }
        myArtists = editArtistGUI.getArtistMap();
      }
      else if(comboBox.getSelectedItem() == "Track"){
        for(String s: myTracks.keySet()){
          if(edited.equalsIgnoreCase(s)){
            editTrackGUI = new EditTrackGUI(myTracks.get(s), myTracks);
          }
        }
        myTracks = editTrackGUI.getTrackMap();
      }
      else { //(comboBox.getSelectedItem() == "Record/Album"){
        for(String s: myRecords.keySet()){
          if(edited.equalsIgnoreCase(s)){
            editRecordGUI = new EditRecordGUI(myRecords.get(s), myRecords);
          }
        }
        myRecords = editRecordGUI.getRecordMap();
      }
      
    }
    
    else if (source == addRecordButton) {
      addRecordGUI = new AddRecordGUI(myRecords, myTracks, myArtists); 
      myRecords = addRecordGUI.getRecordMap();
      myTracks = addRecordGUI.getTrackMap();
      myArtists = addRecordGUI.getArtistMap();
    }
    
    else if(source == addTrackButton) {
      addTrackGUI = new AddTrackGUI(myTracks);
      myTracks = addTrackGUI.getTrackMap();
    }
    
    else if(source == addArtistButton){
      addArtistGUI = new AddArtistGUI(myArtists);
      myArtists = addArtistGUI.getArtistMap();
    }
    
    else if(source == helpButton){
      help();
    }
    
    else if(source == helpItem) {
      help();
    }
    
    else { // (source == systemExit){
      exit();
    }

  }
  
  public void exit(){
    try {
    ObjectOutputStream artistOutput = FileChooser.openObjectWriter();
    ObjectOutputStream recordOutput = FileChooser.openObjectWriter();
    ObjectOutputStream trackOutput = FileChooser.openObjectWriter();
    
    recordOutput.writeObject(myRecords);
    trackOutput.writeObject(myTracks);
    artistOutput.writeObject(myArtists);
    
    artistOutput.close();
    trackOutput.close();
    recordOutput.close();
  }
  catch (Exception e) {
    System.out.println("Wasn't able to write out the files"); 
  }
  
  System.exit(0);
    }
  
  public void help(){
    field.setText("\n Thank you for using Andrew Zurn's and Justin Springer's program. \n \n " +
                  "To add a record, hit the Add Record button and fill in all fields, then hit the next buttons until everything is filled in, \n" +
                  " then hit Go! to finish adding.  The same goes for tracks and artists. \n \n To edit something, type the name of the thing" +
                  " you want to edit and select the correct object in the combo box then \n hit the Edit Something button and replace all" +
                  "neccessary fields and hit the go button. \n \n The display all button will display all of the selected item in the combo" +
                  " box. \n \n To search, type the full name of what you are looking for and select the correct item in the combo box \n" +
                  " and hit the search button. \n \n Please be sure to hit the Exit button before closing the program, to ensure all \n"
                    + " changed data is properly saved. \n \n \n \n \n Version: 1.0 \n Last Date Modified: April 11, 2011");
    
  }
  
  public static void main(String [] args) throws Exception{
    new RecordGUI();
  }
}

