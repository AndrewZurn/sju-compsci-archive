import java.awt.*;
import objectdraw.*;

// class to record and graph traffic data
public class RadarStats2D {
  
  // inset of the graph from the edges of the canvas
  private static final int INSET = 30;
  private static final int DAYS = 30;
  private static final int HOURS = 24;
  
  ;
  
  // dimensions and locations of the graph
  private double graphHeight,
    graphLeft,
    graphBottom;
  
  // width of bar on graph
  private int barWidth;
  
  private double speedLimit;
  
  private DrawingCanvas canvas;
  
  // initialize the array with example data
  private int[][] speedersAt = new int[DAYS][HOURS];
  
  // set instance variables and draw a graph
  public RadarStats2D(DrawingCanvas canvas) {
    RandomIntGenerator speedGenerator = new RandomIntGenerator( 0,30 );
    
    this.canvas = canvas;
    
    barWidth = (canvas.getWidth()-2*INSET)/speedersAt.length;
    graphHeight = canvas.getHeight() - 2*INSET;
    graphBottom = canvas.getHeight() - INSET;
    graphLeft = INSET;
    for(int i= 0; i < DAYS; i++) {
      for (int j = 0; j <HOURS; j++){
        speedersAt[i][j]= speedGenerator.nextValue();
      }
    }
    
  }
  
  // update data then redraw the graph
  public void vehicleReport( int day ) {
    
    canvas.clear();
    drawGrid(day);
    drawHistogram(day);
    
  }
  //Find the highest number of speeders of any hour of the month
  int getHighestHour(){
    //fill in your code
    
    return 0;  //placeholder statement
  }
  
  //Find the number of speeders on the day that had the most speeders
  int getHighestDay(){
    //fill in your code
    
    return 0;  //placeholder statement
    
  }
  
  //Find thetotal number ofspeeders for the month
  int getTotal() {
    //fill in your code
    
    return 0;  //placeholder statement
    
  }
  
  // find the maximum speeders on a given day
  private int maxSpeeders(int row) {
    int max = speedersAt[row][ 0 ];
    
    for ( int hour = 1; hour < speedersAt[row].length; hour++ ) {
      if ( max < speedersAt[row][ hour ])
        max = speedersAt[row][ hour ];
    }
    return max;
  }
  
  
  // draw horizontal and vertical axes
  public void drawGrid(int row) {
    int mostSpeeders = maxSpeeders(row);
    barWidth = (canvas.getWidth()-2*INSET)/speedersAt.length;
    graphHeight = canvas.getHeight() - 2*INSET;
    graphBottom = canvas.getHeight() - INSET;
    graphLeft = INSET;
    
    Text temp = new Text( mostSpeeders, 0, INSET, canvas);
    temp.move( (INSET - temp.getWidth())/2, - temp.getHeight()/2);
    
    double numSpacing = graphHeight/mostSpeeders;
    
    for ( int count = 0; count < mostSpeeders; count = count + 10 ) {
      temp = new Text( count, 0, graphBottom - numSpacing*count, canvas);
      temp.move( (INSET - temp.getWidth())/2, - temp.getHeight()/2);
    }
    
    new Line( INSET, INSET, INSET, graphBottom, canvas);
    new Line( INSET, graphBottom, INSET + speedersAt[row].length*barWidth, graphBottom, canvas);
    
    for ( int hour = 0; hour < speedersAt[row].length; hour++) {
      temp = new Text( hour, INSET + barWidth*hour, graphBottom, canvas );
      temp.move((barWidth-temp.getWidth())/2,0);
    }
  }
  
  // draw the graph
  public void drawHistogram(int row ) {
    double barHeight;
    double mostSpeeders = maxSpeeders(row);
    
    for ( int hour = 0; hour < speedersAt[row].length; hour++ ) {
      barHeight = (speedersAt[row][hour]/mostSpeeders)*graphHeight;
      
      new FilledRect( graphLeft + hour*barWidth,
                     graphBottom - barHeight,
                     barWidth-1,
                     barHeight,
                     canvas );
    }
    
  }
  
}
