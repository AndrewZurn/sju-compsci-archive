package RecordCollection;
import fileStuff.*;
import java.util.*;
import java.io.*;

public class Artist implements Serializable{
  private String artistName;
  private String artistGenre;
  private ArrayList<Integer> trackNumber;
  
  public Artist(String artistName, String artistGenre, ArrayList<Integer> trackNumber){
    this.artistName = artistName;
    this.artistGenre = artistGenre;
    this.trackNumber = trackNumber;
  }
  
  public String getArtist(){
    return artistName;
  }
  public String getGenre(){
    return artistGenre;
  }
  public Integer getNumOfTracks(){
    int count = 0;
    for(int i:trackNumber){
      count++;
    }
    return count;
  }
  public ArrayList<Integer> getNumbers() {
   return trackNumber; 
  }
  public void changeArtist(String newArtist){
    artistName = newArtist;
  }
  public void changeGenre(String newGenre){
    artistGenre = newGenre;
  }
  public void changeNumber (ArrayList<Integer> a) {
    trackNumber = a;
  }
  
  public String getTrackList(){
    String trackList = "";
    for(int i = 0; i<trackNumber.size();i++){
      trackList = trackList + trackNumber.get(i).toString() + " ";
    }
    return trackList;
  }
  
  public String toString (){
    
    return(getArtist() + "\n      Genre: " + getGenre() + 
           "\n      In Track(s): " + getTrackList() + "\n");
   
  }
  
  public static void main(String [] args) throws Exception{
    ObjectInputStream artist = FileChooser.openObjectReader();
    TreeMap<String,Artist> myArtists = (TreeMap<String,Artist>) artist.readObject();
    for(String s: myArtists.keySet()){
      System.out.println(myArtists);
    }
  }
}