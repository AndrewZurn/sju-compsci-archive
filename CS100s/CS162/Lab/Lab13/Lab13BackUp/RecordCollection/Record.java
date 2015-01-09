package RecordCollection;

import java.util.*;
import java.io.*;

public class Record implements Serializable{
  
  private String title, genre, producer, releaseDate, format, commentary, numberOfTracks, artistName;
  private ArrayList<Track> tracks;
  
  
  
  
  public Record (String title, String artistName, String genre, String producer, String releaseDate, 
                 String numberOfTracks, ArrayList<Track> tracks, String format, String commentary) {
    
    this.title = title;
    this.artistName = artistName;
    this.genre = genre;
    this.producer = producer;
    this.releaseDate = releaseDate;
    this.numberOfTracks = numberOfTracks;
    this.tracks = tracks;
    this.format = format;
    this.commentary = commentary;
    
    
  }
  
  public String getName () {
   return artistName; 
  }
  public String getGenre () {
    return genre;
  }
  public String getProducer () {
    return producer;
  }
  public String getTitle () {
    return title;
  }
  public String getReleaseDate () {
    return releaseDate;
  }
  public String getNumber () {
    return numberOfTracks;
  }
  public String getFormat () {
    return format;
  }
  public String getCommentary () {
    return commentary;
  }
  public void changeName (String s) {
    artistName = s;
  }
  public void changeGenre (String s) {
    genre = s;
  }
  public void changeProducer (String s) {
    producer = s;
  }
  public void changeTitle (String s) {
    title = s;
  }
  public void changeReleaseDate (String s) {
    releaseDate = s;
  }
  public void changeNumber (String s) {
    numberOfTracks = s;
  }
  public void changeFormat (String s) {
    format = s;
  }
  public void changeCommentary (String s) {
    commentary = s;
  }
  
  public String toString(){
    return ("Album Title: " + title + "\n      Artist: " + artistName + "\n      Genre: " 
              + genre + "\n      Producer: " + producer + "\n      Release Date: " + releaseDate + 
            "\n      Tracks: " + numberOfTracks + "\n      Format: " + format + 
            "\n      Commentary: " + commentary + "\n");
  }
}