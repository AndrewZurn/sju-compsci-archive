import lejos.nxt.addon.*;
import lejos.nxt.*;

/**
 * This is a test of remote reading of sensors from the PC
 * using the iCommand equivalent classes in pccomm.jar
 * 
 * @author Lawrie Griffiths
 *
 */
public class SensorTest {
 public static void main(String[] args) {
  LightSensor light1 = new LightSensor(SensorPort.S1);
  CompassSensor compass = new CompassSensor(SensorPort.S2);
  UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S3);
  LightSensor light2 = new LightSensor(SensorPort.S4);
  
  while(true) {  
   System.out.println("light1 = " + light1.readValue());
   System.out.println("compass = " + compass.getDegrees());
   System.out.println("distance = " + sonic.getDistance());
   System.out.println("light2 = " + light2.readValue());
   try {
    Thread.sleep(1000);
   } catch (InterruptedException ie) {}
  }
 }
}
