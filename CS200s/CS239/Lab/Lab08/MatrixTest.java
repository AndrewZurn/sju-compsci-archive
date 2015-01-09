import acm.program.*;
import java.util.*;
public class MatrixTest extends ConsoleProgram {
  private double[] a0={5.0,2.0,7.0};
  private double[] a1={1.0,4.0,6.0};
  private double[] a2={3.0,4.0,7.0};
  private double[] a3={3.0,1.0,9.0};
  private double[] a4={4.0,2.0,1.0};
  private double[] a5={2.0,5.0,3.0};
  private double[][] a6={{5.0,2.0,1.0},{2.0,3.0,4.0}};
  private RealVector v0,v1,v2,v3,v4,v5;
  private RealMatrix m0, m1, m2;
  private ArrayList<RealVector> vectorList0, vectorList1;
  private Vector vec1;

  public void init(){
    vectorList0 = new ArrayList<RealVector>();
    vectorList1 = new ArrayList<RealVector>();
    ArrayList<Double> vecList = new ArrayList<Double>();
    vecList.add(1.0);
    vecList.add(2.0);
    vecList.add(1.0);
    vec1 = new Vector(vecList);
    v0 = new RealVector(a0, 3);
    println("v0="+v0);
    vectorList0.add(v0);
    v1 = new RealVector(a1, 3);
    println("v1="+v1);
    vectorList0.add(v1);
    v2 = new RealVector(a2, 3);
    println("v2="+v2+"\n");
    vectorList0.add(v2);
    m0 = new RealMatrix(vectorList0);
    println("m0=v0,v1,v2\n"+m0);
    v3 = new RealVector(a3, 3);
    println("v3="+v3);
    vectorList1.add(v3);
    v4 = new RealVector(a4, 3);
    println("v4="+v4);
    vectorList1.add(v4);
    v5 = new RealVector(a5, 3);
    println("v5="+v5+"\n");
    vectorList1.add(v5);
    m1 = new RealMatrix(vectorList1);
    println("m1=v3,v4,v5\n"+m1);
    m2 = new RealMatrix(a6);
    println("m2=\n"+m2);
  }
  
  public void run() {
    println("Number of Rows in Matrix 0: " + m0.numRows());
    println("Number of Rows in Matrix 1: " + m1.numRows());
    println("Number of Rows in Matrix 2: " + m2.numRows());
    println("Number of Columns in Matrix 0: " + m0.numColumns());
    println("Number of Columns in Matrix 1: " + m1.numColumns());
    println("Number of Columns in Matrix 2: " + m2.numColumns());
    println("The Value at row 1, column 1 of Matrix 0 is: " + m0.getValue(1, 1));
    println("The Value at row 2, column 0 of Matrix 1 is: " + m1.getValue(2, 0));
    //println("The Value at row 1, column 2 of Matrix 2 is: " + m2.getValue(1, 2) + "\n");
    println("The Transposition of Matrix 0 is: \n" + m0.transpose().toString());
    println("The Transposition of Matrix 2 is: \n" + m2.transpose().toString());
    println("The Vector Product of Matrix 0 and vec1 is: \n" + m0.matrixVectorProduct(vec1) + "\n");
    println("The sum of Matrix 0 and Matrix 1 is: \n" + m0.add(m1) + "\n");
    println("The difference of Matrix 0 and Matrix 1 is: \n" + m0.subtract(m1) + "\n");
    println("The Matrix returned when Matrix 0 is multiplied by a scalar product of 2.1: \n"
              + m0.scalarProduct(2.1) + "\n");
    println("The product of Matrix 0 multiplied by Matrix 1 is: \n"
              + m0.matrixMultiply(m1) + "\n");
    println("The product of Matrix 0 multiplied by Matrix 1 is: \n"
              + m1.matrixMultiply(m2) + "\n");
    println("When Row 0 and Row 2 of Matrix 0 are swapped, the matrix looks like: \n"
              + m0.swapRows(0,2) + "\n");
    println("When Row 1 of Matrix 0 is multiplied by a scalar product of 3.5, the matrix becomes: \n" 
              + m0.scalarRowMultiply(3.5, 1) + "\n");
    println("When Row 2 is multiplied by -1.5 then added to row 1 the result is: \n"
              + m0.addRowMultiple(-1.5, 2, 1) +"\n");
  }
  
  public static void main(String [] args) {
    (new MatrixTest()).start();
  }
}