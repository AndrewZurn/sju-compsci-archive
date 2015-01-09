
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
    ObjectOutputStream trackOutput = FileChooser.openObjectWriter();
    ObjectOutputStream recordOutput = FileChooser.openObjectWriter();
    Scanner file = FileChooser.openScanner();
    
    tracks = new TreeMap<String, Track>();
    artist = new TreeMap<String, Artist>();
    recordMap = new TreeMap<String, Record>();
    
    while (file.hasNext()) {
      
      
      
      while (file.nextLine() != "&") {
        
        recordTracks = new ArrayList<Track>();
        people = new ArrayList<MusicPeople>();
        
        
        System.out.println("here .5");
        
        title = file.nextLine(); 
        
        System.out.println("here .6");
        
        String line1 = file.nextLine();
        while (line1 != "@") {
          
          trackNumbers = new ArrayList<Integer>();
          
          artistName = line1;
          
          
          System.out.println("here .7");
          
          artistGenre = file.nextLine();
          
          String line2 = file.nextLine();
          
          while (line2 != "#") {
            
            trackNumbers.add(Integer.parseInt(line2));
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
        System.out.println("here 2");
        
        if (file.nextLine() != "#") {
          
          songTitle = file.nextLine();
          songLength = file.nextLine();
          songNumber = file.nextLine();
          songRating = file.nextLine();
          songReleaseDate = file.nextLine();
          
          String line3 = file.nextLine();
          while (line3 != "#") {
            
            if (file.nextLine() != "%") {
              
              people.add(new MusicPeople(file.nextLine(), file.nextLine(), songTitle));
              
            }
            
            else {
              file.nextLine();
            }
            line3 = file.nextLine();
          }
          
        }
        
        System.out.println("here 3");
        
        recordTracks.add(new Track(songTitle, songLength, songNumber, songRating, songReleaseDate, people));
        
        tracks.put(songTitle, new Track(songTitle, songLength, songNumber, songRating, songReleaseDate, people));
        
        file.nextLine();
        
        format = file.nextLine();
        
        if (file.nextLine() != "&") {
          commentary = file.nextLine();
        }
        
      }
      
      recordMap.put(title, new Record(title, artistName, recordGenre, producer, releaseDate, numberOfTracks, recordTracks, format, commentary));
      
      file.nextLine();
      
      
      System.out.println("here 4");
      
      
      
      
      
    }
    
    recordOutput.writeObject(recordMap);
    trackOutput.writeObject(tracks);
    artistOutput.writeObject(artist);
    artistOutput.close();
    trackOutput.close();
    recordOutput.close();
    file.close();
    
    
    
  }
  
  
}