import java.util.ArrayList;

public class RaceArrayList{
  public class RaceArrayList(){
    
    RaceArrayList<Racer> racerList = new ArrayList<Racer>();
    
     int numRacers = PopUpInput.getInt("How many Racers do you want?");
     
     for ( int i = 0; i < numRacers.length; i++){
       racerList.add("a