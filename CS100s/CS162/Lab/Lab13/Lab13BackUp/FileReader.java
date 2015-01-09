import RecordCollection.*;
import fileStuff.*;
import java.io.*;
import java.util.*;

public class FileReader implements Serializable {
  
  public FileReader () throws Exception{
    
    ObjectInputStream artist = FileChooser.openObjectReader();
    ObjectInputStream record = FileChooser.openObjectReader();
    ObjectInputStream track = FileChooser.openObjectReader();
    
    TreeMap<String,Artist> myArtists =  (TreeMap<String,Artist>) artist.readObject();
    TreeMap<String,Record> myRecords = (TreeMap<String,Record>) record.readObject();
    TreeMap<String,Track> myTracks = (TreeMap<String,Track>) track.readObject();
    
    for (String s: myArtists.keySet()) {
      System.out.println (myArtists.get(s).toString());
    }
    
    for (String s: myRecords.keySet()) {
      System.out.println (myRecords.get(s).toString());
    }
    
    for (String s: myTracks.keySet()) {
      System.out.println (myTracks.get(s).toString());
    }
    
    artist.close();
    record.close();
    track.close();
    
    
  }
  
  public static void main(String [] args) throws Exception{
    new FileReader();
  }
}