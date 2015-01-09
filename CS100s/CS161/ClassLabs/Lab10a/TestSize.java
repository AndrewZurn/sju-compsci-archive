import objectdraw.*;

// A test of the resizeable interface

public class TestSize extends FrameWindowController {
  
  // initial size of object
  private double START_SIZE = 20;
  
  private Resizeable growing;
  private Square zocolo;
  private Circle center;
  
  private RandomIntGenerator shapeGenerator = new RandomIntGenerator(1, 2);
  
    
    public void onMouseExit(Location point) {
      canvas.clear();
    }
    
    public void onMouseEnter(Location point) {
      if (shapeGenerator.nextValue() == 1) {
        growing = new Square(canvas.getWidth()/2, canvas.getHeight()/2, 
                             START_SIZE, canvas);
      }
      else  {
        growing = new Circle(canvas.getWidth()/2, canvas.getHeight()/2+ 3*START_SIZE, 
                        START_SIZE, canvas);
      }
    }
    
    public void onMouseClick(Location point) {
      if (growing.contains(point)) {
        growing.resize(2 *START_SIZE);
      }
    }
}
    
    
    
    
    
    