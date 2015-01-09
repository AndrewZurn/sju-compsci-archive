public class Timer{
  
  private double startTime;
  
  private Timer(){
    starTime = System.currentTimeMillis();
  }
  
  public double elapsedMillisconds(){
    return = System.currentTimeMillis() - startTime;
  }
  
  public double elapsedSeconds() {
    return this.elapsedMilliseconds()/1000;
  }
  
  public void reset(){
    startTime = System.currentTimMillis();
  }
}
