
/*
 * File: DoubleTank.java
 */

package tank;

/** 
 * DoubleTank is for objects that represent a container.
 * 
 * @author Zurn,Andrew and Xu,Runbo
 * @version Jan.21, 2011
 */
public class DoubleTank implements Tank {
  private double level=0;
  private static final double CAPACITY=500;
  private double capacity;
  /**
   * this constructor will creat a new doubletank with pre-set capacity 500 
   */
  public DoubleTank(){
    capacity=CAPACITY;
  }
  
  /**
   * this constructor will creat a new doubletank with given capacity
   * pre: capacity should be positive
   * @param capacity the given capacity for the tank
   */
  public DoubleTank(double capacity) throws IllegalArgumentException{
    if(capacity>0){
      this.capacity=capacity;
    }
    else{
     throw new IllegalArgumentException("The capacity should be no less than zero");
    }
  }
  // Class implementation details go here
  
  /**
   * this constructor will check whether the tank is empty and return the result as a boolean
   * @return true if the tank is empty; false if the tank is not empty.
   */
  public boolean isEmpty(){
    if(level==0){
      return true;
    }
    return false;
  }
  
  /**
   * this constructor will get the current level and capacity of tank and return these as a String
   * @return String a piece of message that will show the current level and capacity of tank
   */
  public String toString(){
    return ("DoubleTank--level: "+level+", capacity: "+capacity +".");
  }
  
  /**
   * this constructor will check whether the tank is full and return the result as a boolean
   * @return true if the tank is full; false if the tank is not full.
   */
  public boolean isFull(){
    if(level==capacity){
      return true; 
    }
    return false;
  }
  
  /**
   * this constructor will return the capacity of the tank as a double
   * @return the value of tank's capacity
   */
  public double getCapacity(){
    return capacity; 
  }
  
  /**
   * this constructor will return the level of the tank as a double
   * @return the value of tank's level
   */
  public double getLevel(){
    return level; 
  }
  
  /**
   * this constructor receive a parameter amount and add the amount to the tank
   * pre: cannot increase the level more than the capacity
   * pre: the amount cannot be negative
   * @param amount the amount that should be added to the tank
   * @throws IllegalArgumentException the max level cannot be more than the capacity. 
   */
  public void add(double amount) throws IllegalArgumentException{
    double templevel=level+ amount;
    if(amount>0){
      if(templevel>capacity){
        throw new IllegalArgumentException("You cannot increase the level more than the capacity");
      }
      else{
       level=templevel; 
      }
    }
    else{
     throw new IllegalArgumentException("You cannot add an amount no more than zero");
    }
  }
  
  /**
   * this constructor receive a parameter amount and remove amount from tank
   * pre: cannot decrease the level less than 0
   * pre: the amount cannot be negative
   * @param amount the amount that should be removed from the tank
   * @throws IllegalArgumentException the min amount cannot be less than 0.
   */
  public void remove(double amount){
      double templevel=level-amount;
    if(amount>0){
      if(templevel<0){
        throw new IllegalArgumentException("You cannot decrease the level less than 0");
      }
      else{
       level=templevel; 
      }
    }
    else{
     throw new IllegalArgumentException("You cannot remove an amount no more than zero");
    }
  }
  
  
}
