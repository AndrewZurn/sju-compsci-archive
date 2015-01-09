/*
 * file name: DepartureEvent.java
 */
package priorityqueue;

/**
 * a class to reperesent a departing customer
 * @author Xu, Runbo and Zurn, Andrew
 * @version 25 Feb, 2011
 */
public class DepartureEvent extends Event{
  /**
   * creates objects to hold the arrival time of the param ArrivalEvent, the items of ArrivalEvent, the queueNum it is placed in, and its depart time
   */
  private int arrivalTime, items, queueNum, departTime;
  
  /**
   * a constructor to create a departuer event
   * @param arrivalEvent the arrivalEvent passed to acquire date from
   * @param queue the queue the departure event is placed in
   */
  public DepartureEvent(ArrivalEvent arrivalEvent, int queue){
    super(arrivalEvent.getDepartureTime());
    arrivalTime = arrivalEvent.getEventTime();
    items = arrivalEvent.getItems();
    queueNum = queue;
    departTime = arrivalTime + items;
  }
  
  /**
   * a method to describe the state of the objects
   * @return String the stated string
   */
  public String toString(){
    return ("This shopper arrived at a time of " + arrivalTime + " with " + items + 
            " items. The shopper will depart from line " + queueNum + " at a time of " + departTime );
  }
  
  /**
   * a method to return the event time of the object
   * @return int the event time
   */
  public int getEventTime(){
    return (arrivalTime);
  }
  
  /**
   * a method to return the departure time of the object
   * @return int the departure time
   */
  public int getDepartureTime(){
    return (departTime);
  }
  
  /**
   * a method to return the number of items for the class
   * @return int the items held
   */
  public int getNumItems(){
    return (items);
  }

  /**
   * a method to return the queue number the class is held in
   * @param int the queue number
   */
  public int getQueueNum(){
    return (queueNum);
  }
  
  /**
   * a method used to describe the type of the object
   * @return int 1 to represent it as an departure class
   */
  public int getType(){
   return 1; 
  }
}