import acm.program.*;
import java.util.*;
public class VectorTest extends ConsoleProgram {
  private double[] a1={5.0,2.0,3.0,4.0,6.0};
  private double[] a2={-2.0,3.0,-4.0,3.0};
  private double[] a3={5.0,2.0,7.0};
  private RealVector v1,v2,v3,v4;
  private double scalarValue=4.6;
  public void init() {
    v1=new RealVector(a1,4);
    println("v1="+v1);
    v2=new RealVector(a2,4);
    println("v2="+v2);
    ArrayList<Double> t3=new ArrayList<Double>();
    for(int i=0;i<3;i++) {
      t3.add(a3[i]);
    }
    v3=new RealVector(t3);
    println("v3="+v3);
  }
  
  public void run() {
    println("vector norm: " + v1.vectorNorm());
    v4=v3.scalarProduct(scalarValue);
    println(""+scalarValue+" * "+v3+" = "+v4);
    v4=v1.add(v2);
    println(""+v1+" + "+v2+" = "+v4);
    try {
      v4=v1.add(v3);
    }
    catch(Throwable e1) {
      println(e1);
    }
    v4=v1.subtract(v2);
    println(""+v1+" - "+v2+" = "+v4);
    try {
      v4=v1.subtract(v3);
    }
    catch(Throwable e2) {
      println(e2);
    }
    double x=v1.dotProduct(v2);
    println(""+v1+" * "+v2+" = "+ x);
    try {
      x=v1.dotProduct(v3);
    }
    catch(Throwable e3) {
      println(e3);
    }
    v4=v1.scalarProduct(3.0);
    println("3.0 * "+v1+" = "+v4);
  }
  
  public static void main(String [] args) {
    (new VectorTest()).start();
  }
}