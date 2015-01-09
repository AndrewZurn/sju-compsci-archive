public class AmountHolder {
  int n1=0,n2=0;
  public synchronized void add() {
    if(Math.random()<=0.5) {
      n1=n1-1;
      System.out.print("<");
      n2=n2+1;
    }
    else {
      n2=n2-1;
      System.out.print("<");
      n1=n1+1;
    }
    System.out.println(""+(n1+n2)+">");
  }
}