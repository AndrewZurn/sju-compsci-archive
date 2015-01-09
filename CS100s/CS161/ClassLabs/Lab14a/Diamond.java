import objectdraw.*;
import java.awt.*;

public class Diamond {
    
    Line [] edge = new Line[4];
    
    public Diamond( Location vert1, Location vert2, 
                     DrawingCanvas canvas){
      Location vert3 = new Location(vert1.getX(), vert2.getY() + (vert2.getY()-vert1.getY()));
      Location vert4 = new Location(vert1.getX() + (vert1.getX() - vert2.getX()), vert2.getY());
        edge[0] = new Line(vert1, vert2, canvas);
        edge[1] = new Line(vert2, vert3, canvas);
        
        edge[2] = new Line(vert3, vert4, canvas);
        edge[3] = new Line(vert4, vert1, canvas);
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
    
    public Location [ ] getVertices() {
        Location [ ] result = new Location[ edge.length ];
        
        for ( int edgeNum = 0; edgeNum < edge.length; edgeNum++ ) {
            result[ edgeNum ] = edge[ edgeNum ].getStart();
        }
        return result;
    }
    
}
