/*
 * File: TankTest.java
 */

import tank.*;

import junit.framework.*;

/**
 * A JUnit test case class for the DoubleTank class.
 * 
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class TankTest extends TestCase {
  
  private Tank tank1, tank2;
  
  public void setUp() {
    tank1 = new DoubleTank();       // uses default constructor
    tank2 = new DoubleTank(250.0);
  }
  
  /**
   * This method tests whether newly constructed tanks are empty.
    */
  public void testInitialState() {
    assertTrue("Tank 1 initially empty", tank1.isEmpty());
    assertTrue("Tank 2 initially empty", tank2.isEmpty());
    assertEquals("Tank 1 capacity is appropriate default",tank1.getCapacity(), /* default capacity */);
    assertEquals("Thank 2 capacity is 250", tank2.getCapacity(), 250.0);
  }
  
  public void testIsFullAtCapacity() {
    // test that adding to an empty tank gives the expected level
    // assert that each tank is full
  }
  
  // Put additional test methods here. Each method name must begin with "test"
  
}
