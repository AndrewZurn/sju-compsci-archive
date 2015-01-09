/**
 * File: Tank.java
 * @author Xu,Runbo and Zurn,Andrew
 * @version Jan. 19, 2011
 */

package tank;

/** 
 * Tank is an interface for objects that represent a container
 */
public interface Tank
{
  
  /**
   * this constructor will check whether the tank is empty and return the result as a boolean
   * @return true if the tank is empty; false if the tank is not empty.
   */
  public boolean isEmpty();
  
  /**
   * this constructor will check whether the tank is full and return the result as a boolean
   * @return true if the tank is full; false if the tank is not full.
   */
  public boolean isFull();
  
  /**
   * this constructor will return the capacity of the tank as a double
   * @return the value of tank's capacity
   */
  public double getCapacity();
  
  /**
   * this constructor will return the level of the tank as a double
   * @rturn the value of tank's level
   */
  public double getLevel();
 
  /**
   * this constructor receive a parameter amount and add the amount to the tank
   * @param amount the amount that should be added to the tank
   */
  public void add(double amount);
  
  /**
   * this constructor receive a parameter amount and remove amount from tank
   * @param amount the amount that should be removed from the tank
   */
  public void remove(double amount);

}
