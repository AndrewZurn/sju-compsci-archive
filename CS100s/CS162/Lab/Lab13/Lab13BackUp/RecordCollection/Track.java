package RecordCollection;
import java.util.*;
import java.io.*;
import fileStuff.*;

public class Track implements Serializable{
  private String title, releaseDate, trackNum, rating, length;
  private ArrayList<MusicPeople> musicPeople;
  
  public Track(String title, String length, String trackNum, String rating, 
               String releaseDate, ArrayList<MusicPeople> musicPeople){
    this.title = title;
    this.trackNum = trackNum;
    this.length=length;
    this.rating = rating;
    this.releaseDate = releaseDate;
    this.musicPeople = musicPeople;
  }
  
  public String getMusicPeople(){
   String list = "";
   for(int i = 0; i<musicPeople.size(); i++){
     list = list + musicPeople.get(i).getType() + ": " + musicPeople.get(i).getName() + " ";
   }
   return list;
  }
  public ArrayList<MusicPeople> getPeople() {
    return musicPeople;
  }
  public String getTitle(){
    return title;
  }
  public String getTrackNum(){
    return trackNum;
  }
  public String getRating(){
    return rating;
  }
  public String getLength(){
    return length;
  }
  public String getReleaseDate(){
    return releaseDate;
  }
  public void changeTitle(String newTitle){
    title = newTitle;
  }
  public void changeRating(String newRating){
    rating = newRating;
  }
  public void changeReleaseDate(String newReleaseDate){
    releaseDate = newReleaseDate;
  }
  public void changeTrackNum(String newTrackNum){
    trackNum = newTrackNum;
  }
  public void changeLength(String newLength){
    length = newLength;
  }
  
  public String toString(){
   return ("Track Title: " + title + "\n      Associators: " + this.getMusicPeople() + 
   "\n      Number: " + trackNum + "\n      Length: " 
   + length + " seconds\n      Release Date: " + releaseDate + "\n      Rating: " + rating + "/10\n");
   }
  
  public static void main (String [] args) throws Exception{
    ObjectInputStream track = FileChooser.openObjectReader();
    TreeMap<String,Track> myTracks = (TreeMap<String,Track>) track.readObject();
    for(String s: myTracks.keySet()){
      System.out.println(myTracks);
    }
  }
}