import zhstructures.*;
import junit.framework.*;

/**
 * A JUnit test case class for the ZHTreeMap class.
 * 
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class TreeMapTest extends TestCase {
  
  private ZHTreeMap<Integer,Integer> treeMap;
  
  public void setUp() {
    treeMap=new ZHTreeMap<Integer,Integer>();
  }
  public void testAll() {
    int i=0;
    while(i<9) {
      int temp=(int)(Math.random()*90.0)+10;
      /* Note that we print out temp, the null that occurs when
       * temp is first "put" in the map associated with temp+5
       * and temp+5 when we "re-put" temp associated with temp+10.
       * Look in the interactions panel to see the result.*/
      if(!treeMap.containsKey(temp)) {
        Integer val=treeMap.put(temp,temp+5);
        System.out.print("|"+temp+" "+val+" ");
        assertEquals("failed put",val,null);
        val=treeMap.put(temp,temp+10);
        System.out.print(val+"|");
        assertEquals("failed put",val,new Integer(temp+5));
        i++;
      }
    }
    System.out.println();
    /* Note that in this for loop we print out what each key
     * is associated with as well as doing the test. */
    for(Integer i2:treeMap.keySet()) {
      System.out.print("<"+i2+" -> "+treeMap.get(i2)+"> ");
      //Compare i with i+10
      assertEquals("failed",treeMap.get(i2),new Integer(i2+10));
    }
    System.out.println();
    //For each exception we print out what happened.
    try {
      treeMap.get(null);
      fail("got a null value");
    }
    catch(Exception e) {
      System.out.println("Got an exception on a null key for get.");
    }
    try {
      treeMap.put(null,100);
      fail("put a null key");
    }
    catch(Exception e) {
      System.out.println("Got an exception when putting a null key.");
    }
    try {
      treeMap.put(100,null);
      fail("put a null key");
    }
    catch(Exception e) {
      System.out.println("Got an exception when putting a null value.");
    }
    
  }
}