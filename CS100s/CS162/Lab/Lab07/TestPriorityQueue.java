import priorityqueue.*;

import junit.framework.*;

public class TestPriorityQueue extends TestCase{
 private ArrayPriorityQueue testA;
 
 public void setUp(){
   testA=new ArrayPriorityQueue();
 }
 
 public void testBoolean(){
   assertTrue("The Queue should be empty", testA.empty());
  testA.enqueue(20.0);
  assertFalse("The Queue Should not be empty",testA.empty());
  
 }
 
}