public class ThreadLauncher {
  private AmountHolder ah=new AmountHolder();
  public void run() {
    for(int i=0;i<10;i++) {
      new RaceCondition(ah).start();
    }
  }
  public static void main(String [] args) {
    new ThreadLauncher().run();
  }
}