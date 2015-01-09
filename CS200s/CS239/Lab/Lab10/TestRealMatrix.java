public class TestRealMatrix {
  
  public static void main(String [] args) {
    double [][] m1={{1,4,2},{2,3,1}};
    double [][] m2={{1,3,1},{3,1,3}};
    double [][] m3={{1,0},{0,2},{3,-2}};
    double [] v1={1,0,1};
    double [] v2={1.0,-1.0};
    double [][] m4={{1,1,1},{2,3,-1},{1,-1,1}};
    double [] v3={6,3,2};
    RealMatrix m=new RealMatrix(m1);
    RealMatrix m0=new RealMatrix(m2);
    RealMatrix mP=new RealMatrix(m3);
    RealVector v=new RealVector(v1,3);
    System.out.println("Matrix\n"+m+"\nhas number of rows = "+m.numRows()+
                       " and number of columns = "+m.numColumns());
    System.out.println("The element at position (1,1) of m is "+m.getValue(1,1));
    System.out.println("Column 1 of m is "+m.getColumn(1));
    System.out.println("If Vector v = "+v);
    System.out.println("Then the product of m and v = "+m.matrixVectorProduct(v));
    RealMatrix mTranspose=m.transpose();
    System.out.print("The transpose of m is\n"+mTranspose+"\n");
    RealVector v0=new RealVector(v2,2);
    System.out.println("If Vector v1 = "+v0+
                       " then the product of m transpose and v1 is\n"+
                       mTranspose.matrixVectorProduct(v0));
    System.out.print("\nThe sum of\n"+m+"\nand\n"+m0+"\nis\n"+m.add(m0)+"\n");
    System.out.println("The difference of those matrices is\n"+m.subtract(m0));
    System.out.println("\nThe scalar product of\n"+m+"and 2.0 is\n"+
                       m.scalarProduct(2.0));
    System.out.println("\nThe matrix product of\n"+m+"and\n"+mP+"is\n"+
                       m.matrixMultiply(mP));
    System.out.println("After swapping rows 0 and 2, the matrix\n"+mP+
                       "\nbecomes\n"+mP.swapRows(0,2));
    System.out.println("\nAfter multiplying row 1 by -3, matrix\n"+m+
                       "\nbecomes\n"+m.scalarRowMultiply(-3.0,1));
    System.out.println("\nAfter adding 2 * row 1 to row 0 of\n"+mP+"we get "+
                       "\nthe RealMatrix\n"+mP.addRowMultiple(2.0,1,0));
    m=new RealMatrix(m4);
    System.out.println("Here is m:\n"+m);
    v0=new RealVector(v3,3);
    System.out.println("\nThe Gauss Jordan reduction method on\n"+m+
                       "with vector "+v0+"\ngives solution"+
                       m.gaussJordan(v0));
    System.out.println("m, unchanged, is:\n"+m);
    m=new RealMatrix(m4);
    RealMatrix minv=m.inverse();
    System.out.println("\nThe inverse of the matrix m\n"+m+"\nis the matrix minv\n"+minv+
                       "\nand the product m*minv is\n"+(m.matrixMultiply(minv))+
                       "\nand the product minv*m is \n"+minv.matrixMultiply(m));
    System.out.println("\nm, unchanged, is:\n"+m);
  }
}