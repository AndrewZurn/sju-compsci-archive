package RecordCollection;
import java.io.*;

public class MusicPeople implements Serializable{
  
  private String name, songTitle, type;
  
  public MusicPeople (String name, String type, String songTitle){
    
    this.name = name;
    this.type = type;
    this.songTitle = songTitle;
    
  }
  
  public void changeName(String s){
    name = s;
  }
  public void changeType(String s){
    type = s;
  }
  public void changeSongTitle(String s){
    songTitle = s;
  }
  public String getName(){
    return name;
  }
  public String getType(){
    return type;
  }
  public String getSongTitle(){
    return songTitle;
  }
  
  public String toString(){
    return ("Name: " + name + " Type: " + type);
  }
  
  
}