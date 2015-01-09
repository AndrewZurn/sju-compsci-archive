import objectdraw.*;
import java.awt.*;

public class Triangle {
    
    Line [] edge = new Line[3];
    
    public Triangle( Location vert1, Location vert2, Location vert3, 
                     DrawingCanvas canvas){
        edge[0] = new Line(vert1,vert2,canvas);
        edge[1] = new Line(vert2,vert3,canvas);
        
        edge[2] = new Line(vert3,vert1,
                           canvas);
    }
    
    public void hide( ) {
        for ( int edgeNum = 0; edgeNum < edge.length; edgeNum++ ){
            edge[edgeNum].hide();
        }
    }
    
    public void move( double dx, double dy) {
        for ( int edgeNum = 0; edgeNum < edge.length; edgeNum++ ){
            edge[edgeNum].move(dx, dy);
        }
    }
    
    public void show( ) {
        for ( int edgeNum = 0; edgeNum < edge.length; edgeNum++ ){
            edge[edgeNum].show();
        }
    }
    
    public Location [] getVertices() {
        Location[] result = new Location[ edge.length ];
        
        for ( int edgeNum = 0; edgeNum <edge.length; edgeNum++ ) {
            result[edgeNum] = edge[edgeNum].getStart();
        }
        return result;
    }
    
}
