import objectdraw.*;



/**
 * Ball to moves within the Pong game
 */
public class MovingBall extends ActiveObject
{
    private static final int BALLSIZE = 30;
    private static final int SCREENGAP = 130;
    
    // Constants to determine ball speeds
    private static final double MINSPEED = 0.08;
    private static final double SPEEDRANGE = 0.55;
    private static final int PAUSETIME = 33;
    
    private FilledOval ball;
    
    // components of speed vector
    private double xspeed, yspeed, initYspeed;
    
    // boundaries of playing area
    private double bleft,bright,btop,offScreen;
    
    private Pong myPong;
    private boolean counted = false;
    
    // the paddle
    private FilledRect paddle;
    //Pong.java
    private RandomDoubleGenerator speedGen;
    private DrawingCanvas canvas;
    
    
    /**
     * contructor that take a canvas, paddle, boundary and Pong game
     */
    public MovingBall(DrawingCanvas aCanvas, FilledRect thePaddle,
                      FramedRect boundary, Pong theGame)
    {
      canvas = aCanvas;
      paddle = thePaddle;
      myPong = theGame;
      
      ball = new FilledOval(boundary.getLocation() ,
                            BALLSIZE,BALLSIZE,canvas);
      ball.move(1,1);
      
      // pick random pixel/pause speeds
      speedGen = new RandomDoubleGenerator(MINSPEED,SPEEDRANGE);
      xspeed = speedGen.nextValue()-SPEEDRANGE/2;
      if (xspeed > 0){
        xspeed = xspeed + MINSPEED;
      }
      else {
        xspeed = xspeed - MINSPEED;
      }
      
      yspeed = speedGen.nextValue() + MINSPEED;
      
      initYspeed = yspeed;
      
      // give names to boundary values
      bleft = boundary.getX();
      btop = boundary.getY();
      bright = bleft + boundary.getWidth() - BALLSIZE;
      
      offScreen = btop + boundary.getHeight() + SCREENGAP;

     
      start();
    }
    
    /**
     * Move the ball as long it remains on the court, bouncing of the side and top barriers
     */
    public void run()
    {
      // used to record times and compute time between moves
      double lastTime, currentTime, elapsedTime;
      
      lastTime = System.currentTimeMillis();
      
      while (ball.getY() < offScreen) {
        
        // determine how much time has passed
        currentTime = System.currentTimeMillis();
        elapsedTime = currentTime - lastTime;
        // restart timing
        lastTime = currentTime;
        
        ball.move(xspeed*elapsedTime,yspeed*elapsedTime);
        
        if ( ball.getX() < bleft  || ball.getX() > bright ) {
          xspeed = -xspeed;
        }
        
        if ( ball.getY() < btop ) {
          yspeed = initYspeed;
        } else if ( ball.overlaps(paddle) ) {
          yspeed = -initYspeed;
          if(!counted){
            myPong.addToScore();
            counted = true;
          }
        }
        else{ //ball doesn't overlap the paddle
          counted = false;
        }
        pause(PAUSETIME);
      }
      ball.removeFromCanvas();
    }
    
    
}
