/**
 * This class demonstrates how to use printf to print things in a formatted
 * way. It can be used with any PrintWriter or PrintStream.
 */
public class PrintfTest {
  double x=Math.PI;
  int y=76543210;
  boolean b=true;
  String s="Hello there world";
  public PrintfTest() {
    //print x (pi) in 8 columns with two places right of the decimal
    System.out.printf("%8.2f\n",x);
    //the ^'s are to show it is 8 columns wide
    System.out.println("^^^^^^^^");
    //print x in 8 columns with 6 places right of the decimal
    System.out.printf("%8.6f\n",x);
    //print x in 8 columns without specifying how many right of the decimal
    System.out.printf("%8f\n",x);
    //print 100*x in floating point format. e represents the power of 10
    System.out.printf("%10.3e\n",100*x);
    //print out integer y in 10 columns
    System.out.printf("%10d\n",y);
    //print out integer y in 10 columns left justified
    System.out.printf("%-10d:\n",y);
    //try to print out integer y in 5 columns
    System.out.printf("%5d\n",y);
    //print out integer 6 in hexadecimal
    System.out.printf("%10x\n",y);
    //print out boolean b in 10 columns
    System.out.printf("%10b\n",b);
    //try to print out String s in 10 columns
    System.out.printf("%10s\n",s);
    //print out String s in 20 columns
    System.out.printf("%20s\n",s);
    //Show how to mix strings and other stuff
    System.out.printf("Here is y:%10d and x:%-10.5fand b:%10b~\n",y,x,b);
  }
  public static void main(String [] args) {
    new PrintfTest();
  }
}
