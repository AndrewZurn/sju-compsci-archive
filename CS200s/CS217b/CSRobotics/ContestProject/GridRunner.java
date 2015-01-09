import lejos.nxt.*;
import lejox.nxt.addon.*;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.RotateMoveController;
import lejos.util.PilotProps;

public class GridRunner{
  private static Area area[][];
  private static boolean found = false;
  private static int white = ;
  private static int black = ;
  private static int red = ;
  LightSensor light1 = new LightSensor(SensorPort.S1);
  CompassSensor compass = new CompassSensor(SensorPort.S2);
  UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S3);
  LightSensor light2 = new LightSensor(SensorPort.S4);
  
  public static void run()throws Exception{
    while(found == false){
     if( area[0].length < 3 || area[1].length < 3 || area[2].length < 3 || area[3].length < 3 
          || area[4].length < 3 || area[5].length < 3 || area[6].length < 3 || area[7].length < 3 ){
       MotorB.stop();
       MotorC.stop();
     }
     else if( area.length < 7 ){
       MotorB.stop();
       MotorC.stop();
     }
     else{
      MotorB.forward();
      MotorC.forward();
      if( light.readValue() <
     }
  }
  
  public static void main(String[] args){
    try{
      run(); 
    }
    catch(Exception e){
      System.out.println("You screwed up somewhere... :P");
    }
  }
}