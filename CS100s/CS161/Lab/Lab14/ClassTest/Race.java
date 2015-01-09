import objectdraw.*;
import java.awt.*;
import java.util.ArrayList;


/**
 * A race program between a rabbit and a turtle
 */
public class Race extends FrameWindowController{
// Location of start and end line for race 
  private static final int X_STARTLINE=28;
  private static final int Y_LINE=0;
  private static final double X_ENDLINE=250;
  private static final Location ANNOUNCE_LOCATION= new Location (30, 20); 
  
// initial locations for the first contestant
  private static final double RACER_X = 5;
  private static final double RACER_Y = 50;
  private static final double SPACING = 50;
  
  private Rabbit rabbit;
  private Turtle turtle;
  private Dog dog;
  
  private boolean raceDone = false;
  private Text announce;
  private static final int MAX_RACERS=8;
  private RandomIntGenerator pickRacer;
  //private Racer[] runner=new Racer[MAX_RACERS];
  private int numberOfRacers;
  private int wanted;
  private RandomIntGenerator color=new RandomIntGenerator(0,255);
  
  private ArrayList<Racer> racerList = new ArrayList<Racer>();
  
  /**
   * initiate the screen   
   */
  public void begin() {
      
    wanted=PopUpInput.getInt("How many Racers do you want?");
    if(wanted<2){
      wanted=2;
    }
    for (numberOfRacers=0; numberOfRacers<wanted&& numberOfRacers<MAX_RACERS; numberOfRacers++){
      pickRacer=new RandomIntGenerator(0,2);
      double x=pickRacer.nextValue();
      if(x==1){
        String name=PopUpInput.getString("Name Your Racer");
        racerList.add(new Turtle(RACER_X,RACER_Y+(numberOfRacers*SPACING), X_ENDLINE, canvas, this, name));
      }
      if(x==0){
        String name=PopUpInput.getString("Name Your Racer");
         racerList.add(new Rabbit(RACER_X,RACER_Y+(numberOfRacers*SPACING), X_ENDLINE, canvas, this, name));
      }      
      if(x==2){
        String name=PopUpInput.getString("Name Your Racer");
         racerList.add(new Dog(RACER_X,RACER_Y+(numberOfRacers*SPACING), X_ENDLINE, canvas, this, name));
        runner[numberOfRacers].setColor(new Color(color.nextValue(),color.nextValue(),color.nextValue()));
      }      
    }
      
      resize(300, 500);
      new Line(X_STARTLINE, Y_LINE, X_STARTLINE, canvas.getHeight(), canvas);
      new Line(X_ENDLINE, Y_LINE,X_ENDLINE, canvas.getHeight(), canvas);
      
      
      
      announce = new Text("Click to start the race", ANNOUNCE_LOCATION, canvas); 
      
    }
    
    /**
     * Start the racers on a mouse click
     */
    public void onMouseClick(Location point){
      for(numberOfRacers=0;numberOfRacers<wanted&& numberOfRacers<MAX_RACERS;numberOfRacers++){
        runner[numberOfRacers].start();
      }
    }
    
    /**
     * Declare a winner
     */
    public void raceOver(String name) {
      if (!raceDone){
        announce.setText(name + " wins!");
      }
      raceDone = true;    
    }
    
    
  }