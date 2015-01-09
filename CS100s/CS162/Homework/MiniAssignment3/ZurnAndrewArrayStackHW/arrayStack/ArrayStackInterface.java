/*
 * File: ArrayStackInterface.java
 */
package arrayStack;

public interface ArrayStackInterface<Type>{
  
  public void push(Type value);
  
  public Type pop();
  
  public Type peek();
  
  public boolean isEmpty();
}