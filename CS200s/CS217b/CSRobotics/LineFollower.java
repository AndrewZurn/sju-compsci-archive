import lejos.nxt.*;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.RotateMoveController;
import lejos.util.PilotProps;

public class LineFollower1{
  private static boolean running = true;
  private static LightSensor light = new LightSensor(SensorPort.S1);
  
  public static void run()throws Exception{
    while(running){
      if( light.readValue() < 45){
        Motor.B.stop();
        Motor.C.forward();
      }
      else if( light.readValue() > 45 ){
        Motor.C.stop();
        Motor.B.forward();
      }
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