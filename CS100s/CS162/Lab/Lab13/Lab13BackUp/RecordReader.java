import RecordCollection.*;
import fileStuff.*;
import java.util.*;
import java.io.*;

public class RecordReader implements Serializable {
  
  private String title, artistGenre, recordGenre, commentary, format, numberOfTracks, songRating,
    songNumber, songLength, releaseDate, producer, songTitle, songReleaseDate, artistName;
  private ArrayList<MusicPeople> people;
  private ArrayList<Integer> trackNumbers;
  private TreeMap<String, Track> tracks;
  private ArrayList<Track> recordTracks;
  private TreeMap<String, Artist> artist;
  private TreeMap<String, Record> recordMap;
  
  
  public RecordReader () throws Exception {
    
    ObjectOutputStream artistOutput = FileChooser.openObjectWriter();
    ObjectOutputStream recordOutput = FileChooser.openObjectWriter();
    ObjectOutputStream trackOutput = FileChooser.openObjectWriter();
    Scanner file = FileChooser.openScanner();
    
    tracks = new TreeMap<String, Track>();
    artist = new TreeMap<String, Artist>();
    recordMap = new TreeMap<String, Record>();
    
    while (file.hasNext()) {
      
      
      String line0 = file.nextLine();
      while (!line0.equals("&")) {
        
        recordTracks = new ArrayList<Track>();
        
        title = line0; 
        
        String line1 = file.nextLine();
        while (!line1.equals("@")) {
          
          trackNumbers = new ArrayList<Integer>();
         
          
          artistName = line1;
          
          artistGenre = file.nextLine();
          
          String line2 = file.nextLine();
          
          while (!line2.equals("#")) {
            
            int i = Integer.parseInt(line2);
            
            trackNumbers.add(i);
            
            line2 = file.nextLine();
            
          }
          
          System.out.println("here 1");
          
          artist.put(artistName, new Artist(artistName, artistGenre, trackNumbers));
          line1 = file.nextLine();
        }
        
        recordGenre = file.nextLine();
        
        producer = file.nextLine();
        
        releaseDate = file.nextLine();
        
        numberOfTracks = file.nextLine();
        
        String line5 = file.nextLine();
        while (!line5.equals("@")) {
          people = new ArrayList<MusicPeople>();
          
          songTitle = line5;
          songLength = file.nextLine();
          songNumber = file.nextLine();
          songRating = file.nextLine();
          songReleaseDate = file.nextLine();
          
          String line3 = file.nextLine();
          while (!line3.equals("#")) {
            
            String line4 = line3;
            while (!line4.equals("%")) {
              
              people.add(new MusicPeople(line4, file.nextLine(), songTitle));
              line4 = file.nextLine();
            }
            
            line3 = file.nextLine();
          }
          
          
          recordTracks.add(new Track(songTitle, songLength, songNumber, songRating, songReleaseDate, people));
          
          tracks.put(songTitle, new Track(songTitle, songLength, songNumber, songRating, songReleaseDate, people));
          
          line5 = file.nextLine();
          
        }
        
        format = file.nextLine();
        
        if (file.hasNext()){
          String line6 = file.nextLine();
          
          if (!line6.equals("&")) {
            commentary = line6;
          }
          else {
            line0 = line6;
          }
          
        }
      }
      
      recordMap.put(title, new Record(title, artistName, recordGenre, producer, releaseDate, numberOfTracks, recordTracks, format, commentary));
      
    }
    
    System.out.println(recordMap);
    System.out.println(tracks);
    System.out.println(artist);
    
    recordOutput.writeObject(recordMap);
    trackOutput.writeObject(tracks);
    artistOutput.writeObject(artist);
    
    artistOutput.close();
    trackOutput.close();
    recordOutput.close();
    file.close();
    
    
    
  }
  
  public static void main(String [] args) throws Exception{
    new RecordReader();
  }
}