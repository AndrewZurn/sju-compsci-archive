import lejos.nxt.*;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.RotateMoveController;
import lejos.util.PilotProps;

public class LineStopper{
  private boolean running = true;
  private static LightSensor light = new LightSensor(SensorPort.S1);
  
  public static void run()throws Exception{
    while(light.readValue() < 40){
      Motor.B.forward();
      Motor.C.forward();
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