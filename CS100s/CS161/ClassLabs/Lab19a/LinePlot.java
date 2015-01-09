import java.util.Scanner;
public class LinePlot{
  private int oldX = 0;
  private int oldY = 0;
  
  public LinePlot(){
    Scanner stdIn = new Scanner(System.in);
    String xStr, yStr;
    int x, y;
    
    System.out.print ("enter x and y coordinates (q to quit): ");
    xStr =stdIn.next();
    while (!xStr.equalsIgnoreCase("q")) {
      yStr = stdIn.next();
      x = Integer.parseInt(xStr);
      y = Integer.parseInt(yStr);
      plotSegment(x,y);
      System.out.print("Enter x and y coordinates (q to quit): ");
      xStr = stdIn.next();
    }
  }    
  public void plotSegment(int x, int y) {
    System.out.println("New segment = (" +oldX + " ," + oldY + ")-(" + x + "," + y + ")" );
    oldX = x;
    oldY =y;
  }
  
  public static void main(String[] args) {
    LinePlot path = new LinePlot();
  }
}
