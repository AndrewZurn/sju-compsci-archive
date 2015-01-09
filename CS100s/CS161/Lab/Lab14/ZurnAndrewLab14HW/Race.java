import objectdraw.*;
import java.awt.*;

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
  
  private Rabbit rabbit, rabbitOne;
  private Turtle turtle, turtleOne, turtleTwo;
  private Dog dog, dogOne, dogTwo;
  
  private boolean raceDone = false;
  private Text announce;
  private static final int MAX_RACERS=8;
  private RandomIntGenerator pickRacer;
  private Racer[] runner=new Racer[MAX_RACERS];
  private int numberOfRacers;
  private int wanted;
  private RandomIntGenerator color=new RandomIntGenerator(0,255);
  private double crowdY;
  private double crowdX = 0;
  private String dogA, dogB, turtleA, turtleB, rabbitA;
  private RandomIntGenerator crowdMove=new RandomIntGenerator(0,15);
  private double DELAY_TIME = 33;
  private double moveTime = 7500;
  private double runTime;
  
  /**
   * initiate the screen   
   */
  public void begin() {
    resize(300, 700);
    wanted=PopUpInput.getInt("How many Racers do you want?");
    if(wanted<2){
      wanted=2;
    }
    for (numberOfRacers=0; numberOfRacers<wanted&& numberOfRacers<MAX_RACERS; numberOfRacers++){
      pickRacer=new RandomIntGenerator(0,2);
      double x=pickRacer.nextValue();
      if(x==1){
        String name=PopUpInput.getString("Name Your Racer");
        runner[numberOfRacers]=new Turtle(RACER_X,RACER_Y+(numberOfRacers*SPACING), X_ENDLINE, canvas, this, name);
        runner[numberOfRacers].setColor(new Color(color.nextValue(),color.nextValue(),color.nextValue()));
      }
      if(x==0){
        String name=PopUpInput.getString("Name Your Racer");
        runner[numberOfRacers]=new Rabbit(RACER_X,RACER_Y+(numberOfRacers*SPACING), X_ENDLINE, canvas, this, name);
        runner[numberOfRacers].setColor(new Color(color.nextValue(),color.nextValue(),color.nextValue()));
      }      
      if(x==2){
        String name=PopUpInput.getString("Name Your Racer");
        runner[numberOfRacers]=new Dog(RACER_X,RACER_Y+(numberOfRacers*SPACING), X_ENDLINE, canvas, this, name);
        runner[numberOfRacers].setColor(new Color(color.nextValue(),color.nextValue(),color.nextValue()));
      }      
    }
    
    
    new Line(X_STARTLINE, Y_LINE, X_STARTLINE, canvas.getHeight(), canvas);
    new Line(X_ENDLINE, Y_LINE,X_ENDLINE, canvas.getHeight(), canvas);
    
    
    crowdY = runner[wanted-1].getY();
    
    dogOne=new Dog(crowdX+50, crowdY+60, X_ENDLINE, canvas, this, dogA);
    dogOne.setColor(new Color(color.nextValue(),color.nextValue(),color.nextValue()));
    turtleOne=new Turtle(crowdX + 80, crowdY+80, X_ENDLINE, canvas, this, turtleA);
    turtleOne.setColor(new Color(color.nextValue(),color.nextValue(),color.nextValue()));
    rabbitOne=new Rabbit(crowdX + 110, crowdY+60, X_ENDLINE, canvas, this, rabbitA);
    rabbitOne.setColor(new Color(color.nextValue(),color.nextValue(),color.nextValue()));
    turtleTwo=new Turtle(crowdX + 140, crowdY+80, X_ENDLINE, canvas, this, turtleB);
    turtleTwo.setColor(new Color(color.nextValue(),color.nextValue(),color.nextValue()));
    dogTwo=new Dog(crowdX+170, crowdY+60, X_ENDLINE, canvas, this, dogB);
    dogTwo.setColor(new Color(color.nextValue(),color.nextValue(),color.nextValue()));
    
    
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
    dogOne.moveCrowd();
    turtleOne.moveCrowd();
    rabbitOne.moveCrowd();
    turtleTwo.moveCrowd();
    dogTwo.moveCrowd();
  }
}
