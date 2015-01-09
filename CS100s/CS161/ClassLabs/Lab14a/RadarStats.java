import java.awt.*;
import objectdraw.*;

// class to record and graph traffic data
public class RadarStats {
    
    // inset of the graph from the edges of the canvas
    private static final int INSET = 30
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
    private int[] speedersAt = { 7, 2, 1, 0, 4, 9, 20, 25, 40, 15, 17, 12, 14,
                                 13,12,10,15,17,20, 23, 24, 10, 19, 15 };
    
    // set instance variables and draw a graph
    public RadarStats( double speedLimit, DrawingCanvas canvas ) {
        this.speedLimit = speedLimit;
        this.canvas = canvas;
      
        barWidth = (canvas.getWidth()-2*INSET)/speedersAt.length;
        graphHeight = canvas.getHeight() - 2*INSET;
        graphBottom = canvas.getHeight() - INSET;
        graphLeft = INSET;
       
//        drawGrid();
//        drawHistogram();
    }
    
    // update data then redraw the graph
    public void vehicleReport( double speed, int hour ) {
        
        if ( speed > speedLimit ) {
            speedersAt [ hour ] ++;
        }
        canvas.clear();
        drawGrid();
        drawHistogram();
    }
    
    // return number of speeders recorded
    private int speedersSeen() {
        int total = 0;
        
        for ( int hour = 0; hour < speedersAt.length; hour++ ) {
            total = total + speedersAt[ hour ];
        }
        
        return total;
    }
    
    // return the maximum number of speeders seen in an hour
    private int maxSpeeders() {
        int max = speedersAt[ 0 ];
        
        for ( int hour = 1; hour < speedersAt.length; hour++ ) {
            if ( max < speedersAt[ hour ])
                max = speedersAt[ hour ];
        }
        return max;
    }
    
    // draw horizontal and vertical axes
    public void drawGrid( ) {
        int mostSpeeders = maxSpeeders();
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
        new Line( INSET, graphBottom, INSET + speedersAt.length*barWidth, graphBottom, canvas);
        
        for ( int hour = 0; hour < speedersAt.length; hour++) {
            temp = new Text( hour, INSET + barWidth*hour, graphBottom, canvas );
            temp.move((barWidth-temp.getWidth())/2,0);
        }
    }
    
    // draw the graph
    public void drawHistogram( ) {
        double barHeight;
        double mostSpeeders = maxSpeeders();
        
        for ( int hour = 0; hour < speedersAt.length; hour++ ) {
            barHeight = (speedersAt[hour]/mostSpeeders)*graphHeight;
            
            new FilledRect( graphLeft + hour*barWidth,
                            graphBottom - barHeight,
                            barWidth-1,
                            barHeight,
                            canvas );
        }
        
    }
    
}
