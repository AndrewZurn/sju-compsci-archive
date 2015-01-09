import objectdraw.*;
import java.awt.Color;

/**
 *  A class that implements a nice looking basketball
 */
public class BBall {
        // the color to draw the ball
        private static final Color BALL_ORANGE = new Color(250, 85, 10);

        // size and starting angles for cut arc in degrees
        private static final int CUTSIZE = 100;
        private static final int RIGHTCUTSTART = 90 + (180 - CUTSIZE) / 2;
        private static final int LEFTCUTSTART = 270 + (180 - CUTSIZE) / 2;

        // the orange part of the ball
        private FilledOval body;
        // the border of the ball
        private FramedOval border;
        // the two curves on the sides of the ball
        private FramedArc leftCut, rightCut;
        // the vertical and horizontal lines through the ball
        private Line vert, horiz;

        // initial coordinates of basketball
        private double initX, initY;


        // Create a new basketball
        public BBall(double left, double top, 
                             double size, DrawingCanvas aCanvas) 
        {
                // draw the circles that make it look like a ball
                body = new FilledOval(left, top, size, size, aCanvas);
                body.setColor(BALL_ORANGE);             
                border = new FramedOval(left, top, size, size, aCanvas);
                
                // draw the lines and arcs that make it look like a basketball
                rightCut = new FramedArc( left + size * 2 / 3, top,
                                                  size, size,
                                                  RIGHTCUTSTART, CUTSIZE,  aCanvas);
                leftCut =  new FramedArc( left - size * 2 / 3, top,
                                                  size, size,
                                                  LEFTCUTSTART, CUTSIZE,   aCanvas);
                vert =  new Line( left + size / 2, top,
                                left + size / 2, top + size,   aCanvas);
                horiz = new Line( left, top + size / 2,
                                left + size, top + size / 2,   aCanvas);
                
                // remember the ball's starting position
                initX = left;
                initY= top;
        }
        
        
        // check to see if the ball contains a specified location
        public boolean contains(Location point) 
        {
                return body.contains(point);
        }

        // move the ball by specified offsets
        public void move(double dx, double dy) 
        {
                // move each part of the ball by the offsets provided
                body.move(dx, dy);
                border.move(dx, dy);
                vert.move( dx, dy);
                horiz.move(dx, dy);
                leftCut.move(dx, dy);
                rightCut.move(dx, dy);
        }       
        
        // move the ball to a specified position
        public void moveTo(double x, double y) 
        {
                // determine how far away (x,y) is
                double dx, dy;
                dx = x - body.getX();
                dy = y - body.getY();

                // move each part of the ball by the offsets provided
                body.move(dx, dy);
                border.move(dx, dy);
                vert.move( dx, dy);
                horiz.move(dx, dy);
                leftCut.move(dx, dy);
                rightCut.move(dx, dy);
        }
        
        // return the ball to its starting position
        public void reset() 
        {
                this.moveTo(initX, initY);
        }
        
        // return the x coordinate of ball's corner
        public double getX(){
                return body.getX();
        }
        
        // return the y coordinate of ball's corner
        public double getY(){
                return body.getY();
        }
        
}
