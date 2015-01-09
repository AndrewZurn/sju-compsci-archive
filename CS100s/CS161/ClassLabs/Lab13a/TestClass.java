import objectdraw.*;

public class TestClass extends FrameWindowController{
  
  private Text message;
  private Location messageLocation = new Location (10,10);
  
public void begin() {
  
  message = new Text("", messageLocation, canvas);
  
  
  
    for (double index = 1.0; index <5.0; index = index + 1.0/3.0) {
      messageLocation.translate(0,20);
      message = new Text("Index is " + index,messageLocation, canvas);
    }
  }
}