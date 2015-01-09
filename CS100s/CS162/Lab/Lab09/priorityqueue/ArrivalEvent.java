/*
 * file name: ArrivalEvent.java
 */
package priorityqueue;

/**
 * a class to reperesent an arriving customer
 * @author Xu, Runbo and Zurn, Andrew
 * @version 25 Feb, 2011
 */
public class ArrivalEvent extends Event{
  /**
   * the amounts of items a customer has
   */
  private int items;
  
  /**
   * the constructor for the Arrival Event
   * @param eventTime the time the customer arrived
   * @param items the amount of items the customer has
   */
  public ArrivalEvent(int eventTime, int items){
    super(eventTime);
    this.items=items;
  }
  
  /**
   * a method to describe the state of the objects
   * @return String the stated string
   */
  public String toString(){
    return ("This shopper arrived at a time of: " + super.getEventTime() + " with " + items + " items.");
  }
  
  /**
   * a method to return the items the class contains
   * @return int the number of items
   */
  public int getItems(){
    return (items);
  }
  
  /**
   * a method to return the departure time of the object
   * @return int the departure time
   */
  public int getDepartureTime(){
    return (items + super.getEventTime());
  }
  
  /**
   * a method used to describe the type of the object
   * @return int 0 to represent it as an arrival class
   */
  public int getType(){
   return 0; 
  }
}

  