public class RaceCondition extends Thread {
  private AmountHolder ah;
  private int id;
  public RaceCondition(AmountHolder ah) {
    super();
    this.ah=ah;
    this.id=id;
  }
  public void run() {
    while(true) {
      try {
        ah.add();
        Thread.sleep((int)(Math.random()*1000));
      }
      catch(Exception e) {}
    }
  }
}