/*
 * File: GrocerySimulation.java
 */
import java.util.*;
import java.io.*;
import fileStuff.*;
import queue.*;
import priorityqueue.*;

/**
 * A program to represent a Grocery Market Checkout Line
 * @author Xu, Runbo and Zurn, Andrew
 * @version 2 Mar, 2011
 */
public class GrocerySimulation {
  /**
   * the array list to hold the seperate checkout queues
   */
  private ArrayList<LinkedQueue1<ArrivalEvent>> checkouts;
  /**
   * the priority queue interface to reference event queue
   */
  private PriorityQueueInterface<Event> eventQueue;
  /**
   * the total waiting time used
   */
  private int[] totalWaitTime;
  /**
   * the last queue to dequeue from
   */
  private int finishedQN=-1;
  
  /**
   * The constructor for the GrocerySimulation
   * @param numQueues the amount of checkout queues to be simulated
   * @param al the data used to represent customers
   */
  public GrocerySimulation(int numQueues,ArrayList<ArrivalEvent> al) {
    //create ArrayList<SimpleQueue<ArrivalEvent>> checkouts and
    //  add numQueues queues to that checkouts ArrayList.
    checkouts=new ArrayList<LinkedQueue1<ArrivalEvent>>();
    totalWaitTime=new int[numQueues];
    for(int j=0;j<numQueues;j++){
      checkouts.add(new LinkedQueue1<ArrivalEvent>());
    }
    //create the priority queue eventQueue
    eventQueue=new ArrayPriorityQueue<Event>();
    //take the events in al and add them to the eventQueue.
    for(int i=0;i<al.size();i++){
      eventQueue.enqueue(al.get(i));
    }
    
  }
  
  /**
   * method to run the simulation
   */
  public void run() {
    Event currentEvent;
    int currentTime;
    int queueNum;
    //This is the actual simulation as described in the writeup.
    while(!eventQueue.empty()) {
      currentEvent=eventQueue.dequeue();
      currentTime=currentEvent.getEventTime();
      System.out.println(currentEvent.toString());
      if(currentEvent.getType()==1){ //Departure Event
        DepartureEvent ourEvent=(DepartureEvent)currentEvent;
        int k=ourEvent.getQueueNum();
        checkouts.get(ourEvent.getQueueNum()).dequeue();
        
        totalWaitTime[k]=totalWaitTime[k]+ourEvent.getDepartureTime();
        System.out.println(checkouts.get(k).empty());
        if(!checkouts.get(k).empty()){
          eventQueue.enqueue(new DepartureEvent(checkouts.get(k).peek(), k));
        }
        if(eventQueue.empty()){
         finishedQN=k;
        }
      }
      else if(currentEvent.getType()==0){ //Arrival Event
        LinkedQueue1 temp=checkouts.get(0);
        queueNum=0;
        for(int i=1;i<checkouts.size();i++){
          
          if(temp.size()>checkouts.get(i).size()){
            queueNum=i;
            temp=checkouts.get(i);
          }
        }
        ArrivalEvent tempE=(ArrivalEvent)currentEvent;
        
        if(checkouts.get(queueNum).empty()){
          eventQueue.enqueue(new DepartureEvent(tempE, queueNum));
        }
        checkouts.get(queueNum).enqueue(tempE);
        System.out.println("queue "+queueNum);
      }
     //ystem.out.println(eventQueue.size());
    }
    System.out.println(totalWaitTime[finishedQN]);
  }
  
  
  
  /**
   * a method to call the class from the command line
   * @param args does nothing
   */
  public static void main(String [] args) {
    try {
      Scanner sc=FileChooser.openScanner();
      ArrayList<ArrivalEvent> al=new ArrayList<ArrivalEvent>();
      //Use the scanner to read in all the events and add them to al
      while(sc.hasNextInt()){
        al.add(new ArrivalEvent(sc.nextInt(),sc.nextInt()));
      }
      sc.close();
      for(int i=1;i<=10;i++) {
        GrocerySimulation gs=new GrocerySimulation(i,al);
        gs.run();
      }
    }
    catch(Exception e) {
    }
  }
}