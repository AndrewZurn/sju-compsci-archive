package priorityqueue;
import java.util.*;

public class MHPriorityQueue<T extends Comparable<T>> implements PriorityQueueInterface<T>{
  private ArrayList<T> list;
  
  public MHPriorityQueue(){
    list = new ArrayList<T>();
  }
  
  public boolean empty(){
    return(list.isEmpty());
  }
  public void enqueue(T value){
    int i = list.size()-1;
    if(list.isEmpty()){
      list.add(value);
    }
    else{//list !empty
      list.add(value);
      while(i != 0){
        if(value.compareTo(list.get((i-1)/2)) >= 0 ){
          list.set(i, list.get((i-1)/2));
          list.set((i-1)/2, value);
          i=(i-1)/2;
        }
        else{//value<parent
          i=0;
        }
      }
    }
    
  }
  public T peek() throws EmptyQueueException{
    if(list.size()==0){
      throw new EmptyQueueException("The queue is empty");
    }
    return(list.get(0));
  }
  
  public T dequeue() throws ClassCastException{
    boolean done = true;
    if(list.size()==0){
      throw new EmptyQueueException("The queue is empty");
    }
    T result = list.get(0);
    for(int j=0;j<list.size();j++){
     System.out.println(list.get(j)); 
    }
    T temp =list.get(list.size()-1);
    int i =0;
    list.remove(list.size()-1);
    list.set(0, temp);
    while(done){
      if(2*i+1>=list.size()){
        list.set(i, temp);
        done=false; 
      }
      else if(2*i+1==list.size()-1){
        if(temp.compareTo(list.get(2*i+1))>0){
          list.set(i, temp);
          done=false;
        }
        else{
          list.set(i, list.get(2*i+1));
          list.set(2*i+1, temp);
          i=2*i+1;
        }
      }
      else {
        if((temp.compareTo(list.get(2*i+1)) > 0) && (temp.compareTo(list.get(2*i+2)) > 0)){ 
          list.set(i, temp);
          done=false;
        }
        else{
          if((list.get(2*i+2).compareTo(list.get(2*i+1)) < 0)){ //list.get(2*i+2).compareTo(list.get(2*i+1)) < 0)
            list.set(i, list.get(2*i+1));
            list.set(2*i+1, temp);
            i=2*i+1;
          }
          else if((list.get(2*i+2).compareTo(list.get(2*i+1)) >= 0)){
            list.set(i, list.get(2*i+2));
            list.set((2*i+2), temp);
            i=2*i+2;
          }
        }
      }
    }
    return result;
  }
  
  
}

