import objectdraw.*;
import java.awt.*;

public class 

public void moveStack(int numDisks, int start, int target, int helper){
  if(numDisk==1){
    moveDisk(start, target);
  }
  else{
    moveStack(numDisks - 1, start, helper, target);
    moveDisk(start, target);
    moveStack(numDisks - 1, helper, target, start);
  }
}