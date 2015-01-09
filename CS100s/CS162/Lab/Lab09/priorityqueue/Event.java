/*
 * file name: Event.java
 */
package priorityqueue;

import java.util.*;

public abstract class Event implements Comparable<Event>{
  private int eventTime;
  public Event(int eventTime){
   this.eventTime=eventTime; 
  }
  public int compareTo(Event e){
    if( eventTime>e.getEventTime()){
     return -1; 
    }
    else if(this.getEventTime()==e.getEventTime()){
     return 0; 
    }
    else{
     return 1; 
    }
  }
  
  public int getEventTime(){
   return eventTime;
  }
  
  public abstract String toString();
  
  public abstract int getType();
}