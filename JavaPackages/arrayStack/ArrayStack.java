/*
 * File: ArrayStack.java
 */
import java.util.*;
package arrayStack;
public class ArrayStack<Type> {
    private ArrayList<Type> stack;
    private int count;
    
    public ArrayStack() {
        //create the stack and set the count to 0
      stack = new ArrayList<Type>();
      count = 0;
    }
    public void push(Type value) {
        //puts the value at position count and increments count
      stack.add(count, value);
      count++;
    }
    public Type pop() {
      //if count is 0 throw an exception. Otherwise decrement count and return the value count points to
      Type temp;
      if(count == 0){
        throw new EmptyQueueException("The Stack is Empty!");
      }
      temp = stack.get(stack.size()-1);
      stack.remove(stack.size() - 1);
      count--;
      return temp;
    }
    public Type peek() {
        //return the value at position count - 1   
      if(count == 0){
        throw new EmptyQueueException("The Stack is Empty!");
      }
      return stack.get(stack.size()-1);
    }
    public boolean empty() {
        //true if count is 0
      return(count==0);
    }
}