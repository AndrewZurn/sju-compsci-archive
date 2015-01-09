public class UseEnum {
  public void run() {
    Colors a,b,c,d;
    a=Colors.RED;
    b=Colors.GREEN;
    c=Colors.BLUE;
    d=null;
    printIt(a);
    printIt(b);
    printIt(c);
    printIt(d);
  }
  public void printIt(Colors x) throws RuntimeException {
    switch(x) {
      case RED: System.out.println("The color is "+x); break;
      case GREEN: System.out.println("The color is "+x); break;
      case BLUE: System.out.println("The color is "+x); break;
      default: throw new RuntimeException("Illegal Color.");
    }
  }
  public static void main(String [] args) {
    new UseEnum().run();
  }
}