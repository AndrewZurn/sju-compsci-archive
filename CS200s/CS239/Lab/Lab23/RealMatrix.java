import java.util.*;
public class RealMatrix {
  private ArrayList<RealVector> matrix;
  
  public RealMatrix(ArrayList<RealVector> a) {
    matrix = new ArrayList<RealVector>();
    for(int i = 0; i<a.size(); i++){
      matrix.add(a.get(i));
    }
  }
  
  public RealMatrix(double[][] a) {
    matrix = new ArrayList<RealVector>();
    ArrayList<Integer> intList = new ArrayList<Integer>();
    for(int i = 0; i<a.length; i++){
      intList.add(a[i].length);
    }
    for(int j = 0; j<a.length; j++){
      ArrayList<Double> doubleList = new ArrayList<Double>();
      for(int k = 0; k<a[j].length; k++){
        doubleList.add(a[j][k]);
      }
      matrix.add(new RealVector(doubleList));
    }
  }
  
  public int numRows(){
    return (matrix.size());
  }
  
  public int numColumns(){
    return (matrix.get(0).getLength());
  }
  
  public double getValue(int i, int j){
    return ( matrix.get(i).get(j));
  }
  
  public RealVector getColumn(int i){
    ArrayList<Double> list = new ArrayList<Double>();
    for (int j = 0; j<matrix.size(); j++){
      list.add(matrix.get(j).get(i));
    }
    RealVector vector = new RealVector(list);
    return (vector);
  }
  
  public RealVector getRow(int i){
    return (matrix.get(i));
  }
  
  public RealMatrix transpose(){
    ArrayList<RealVector> list = new ArrayList<RealVector>();
    for(int i = 0; i <matrix.get(0).getLength(); i++){
      ArrayList<Double> doubleList = new ArrayList<Double>();
      for(int j = 0; j<matrix.size(); j++){
        doubleList.add(matrix.get(j).get(i));
      }
      list.add(new RealVector(doubleList));
    }
    RealMatrix newMatrix = new RealMatrix(list);
    return (newMatrix);
  }
  
  public RealVector matrixVectorProduct(RealVector v){
    ArrayList<Double> doubleList = new ArrayList<Double>();
    if(v.getLength() == matrix.get(0).getLength()){
      for(int i = 0; i< matrix.size(); i++){
        doubleList.add(matrix.get(i).dotProduct(v));
      }
    }
    RealVector newVector = new RealVector(doubleList);
    return (newVector);
  }
  
  public RealMatrix add(RealMatrix m){
    ArrayList<RealVector> vectorTemp = new ArrayList<RealVector>();
    if(matrix.size() == m.numRows() && matrix.get(0).getLength() == m.numColumns()){
      for(int i = 0; i<matrix.size(); i++){
        ArrayList<Double> doubleList = new ArrayList<Double>();
        for(int j = 0; j<matrix.get(0).getLength(); j++){
          doubleList.add( matrix.get(i).get(j) + m.getValue(i, j));
        }
        vectorTemp.add(new RealVector(doubleList));
      }
      return (new RealMatrix(vectorTemp));
    }
    else{
      return (null);
    }
  }
  
  public RealMatrix subtract(RealMatrix m){
    ArrayList<RealVector> vectorTemp = new ArrayList<RealVector>();
    if(matrix.size() == m.numRows() && matrix.get(0).getLength() == m.numColumns()){
      for(int i = 0; i<matrix.size(); i++){
        ArrayList<Double> doubleList = new ArrayList<Double>();
        for(int j = 0; j<matrix.get(0).getLength(); j++){
          doubleList.add( matrix.get(i).get(j) - m.getValue(i, j));
        }
        vectorTemp.add(new RealVector(doubleList));
      }
      return (new RealMatrix(vectorTemp));
    }
    else{
      return (null);
    }
  }
  
  public RealMatrix scalarProduct(double a){
    ArrayList<RealVector> vectorTemp = new ArrayList<RealVector>();
    for(int i = 0; i<matrix.size(); i++){
      ArrayList<Double> doubleList = new ArrayList<Double>();
      for(int j = 0; j<matrix.get(0).getLength(); j++){
        doubleList.add( matrix.get(i).get(j) * a);
      }
      vectorTemp.add(new RealVector(doubleList));
    }
    return (new RealMatrix(vectorTemp));
  }
  
  public RealMatrix matrixMultiply(RealMatrix m){
    if( matrix.size() == m.numColumns()){
      RealMatrix tempMatrix = m.transpose();
      ArrayList<RealVector> vectorList = new ArrayList<RealVector>();
      for(int i = 0; i<matrix.size(); i++){
        ArrayList<Double> doubleList = new ArrayList<Double>();
        for(int k = 0; k<tempMatrix.numRows(); k++){
          double d = 0.0;
          for(int j = 0; j<tempMatrix.numColumns(); j++){
            d = d + (matrix.get(i).get(j) * tempMatrix.getValue(k, j));
          }
          if( d < 1.000001 && d > .999999 ){
            doubleList.add(1.0);
          }
          else if( d < 0.000001 && d >-0.000001 ) {
            doubleList.add(0.0);
          }
          else{
            doubleList.add(d);
          }
        }
        vectorList.add(new RealVector(doubleList));
      }
      return (new RealMatrix(vectorList));
    }
    else {
      return (null);
    }
  }

  
  public String toString(){
    String temp="";
    for(int i=0;i<matrix.size();i++) {
      temp=temp+matrix.get(i).toString()+"\n";
    }
    return(temp);
  }
  
  public RealMatrix swapRows(int i, int j){
    RealMatrix tempMatrix;
    RealVector temp = matrix.get(i);
    RealVector temp1 = matrix.get(j);
    matrix.set(j,temp);
    matrix.set(i,temp1);
    tempMatrix = new RealMatrix(matrix);
    return (tempMatrix);
  }
  
  public RealMatrix scalarRowMultiply(double x, int i){
    ArrayList<RealVector> vectorTemp = new ArrayList<RealVector>();
    ArrayList<Double> doubleList = new ArrayList<Double>();
    for(int j = 0; j<matrix.size(); j++){
      if( j==i ){
        for(int k = 0; k<matrix.get(j).getLength(); k++){
          doubleList.add(x * matrix.get(j).get(k));
        }
        vectorTemp.add(new RealVector(doubleList));
      }
      else{
        vectorTemp.add(matrix.get(j));
      }
    }
    return (new RealMatrix(vectorTemp));
  }
  
  public RealMatrix addRowMultiple(double x, int i, int j){
    ArrayList<RealVector> vectorTemp = new ArrayList<RealVector>();
    ArrayList<Double> doubleList = new ArrayList<Double>();
    for(int a = 0; a<matrix.get(i).getLength(); a++){
      doubleList.add(x * matrix.get(i).get(a));
    }
    RealVector tempVector = new RealVector(doubleList);
    for(int n = 0; n<matrix.size(); n++){
      doubleList = new ArrayList<Double>();
      if ( n==j ){
        for(int m = 0; m<tempVector.getLength(); m++){
          doubleList.add(tempVector.get(m) + matrix.get(n).get(m));
        }
        vectorTemp.add(new RealVector(doubleList));
      }
      else{
        vectorTemp.add(matrix.get(n));
      }
    }
    return (new RealMatrix(vectorTemp));
  } 
  

  public ArrayList<RealVector> reduce(RealMatrix m){
    RealMatrix tempMatrix = m;
    double d = 0.0;
    ArrayList<RealVector> vectorList = new ArrayList<RealVector>();
    for(int i = 0; i<tempMatrix.numRows(); i++){
      vectorList.add(tempMatrix.getRow(i));
    }
    tempMatrix = new RealMatrix(vectorList);
    vectorList.clear();
    for(int cols = 0; cols<tempMatrix.numRows(); cols++){
      int k = cols;
      d = tempMatrix.getValue(cols, cols);
      for(int i = cols+1; i<tempMatrix.numRows(); i++){
        if (tempMatrix.getValue(i, cols) > d){
          d = tempMatrix.getValue(i, cols);
          k = i;
        }
      }
      tempMatrix = tempMatrix.swapRows(k, cols);
      tempMatrix = tempMatrix.scalarRowMultiply(1/d, cols);
      for(int l = 0; l<tempMatrix.numRows(); l++){
        if(l != cols ){
          tempMatrix = tempMatrix.addRowMultiple((-(tempMatrix.getValue(l, cols))), cols, l);
        }
      }
    }
    for(int i = 0; i<tempMatrix.numRows(); i++){
      vectorList.add(tempMatrix.getRow(i));
    }
    return (vectorList);
  }
  
  public RealVector gaussJordan(RealVector b) throws RealMatrixError{
    ArrayList<RealVector> vectorList = new ArrayList<RealVector>();
    if(matrix.size() != matrix.get(0).getLength() || matrix.size() != b.getLength()){
      throw new RealMatrixError("This matrix is not square or lengths of the vector and matrix don't match.  Operation aborted!");
    }
    else{
      for(int i = 0; i<matrix.size(); i++){
        vectorList.add(new RealVector(matrix.get(i).addToVector(b.get(i))));
      }
      RealMatrix newMatrix = new RealMatrix(vectorList);
      vectorList.clear();
      vectorList = reduce(newMatrix);
      newMatrix = new RealMatrix(vectorList);
      newMatrix = newMatrix.transpose();
      RealVector vector = newMatrix.getRow(newMatrix.numRows()-1);
      return (vector);
    } 
  }
  
  public RealMatrix inverse(){
    if(matrix.size() != matrix.get(0).getLength()){
      throw new RealMatrixError("This matrix is not square.  Operation aborted!");
    }
    else {
      RealMatrix tempMatrix;
      ArrayList<RealVector> inverseVectorList = new ArrayList<RealVector>();
      ArrayList<RealVector> vectorList = new ArrayList<RealVector>();
      double[] d0 = {1,0,0};
      double[] d1 = {0,1,0};
      double[] d2 = {0,0,1};
      inverseVectorList.add(new RealVector(d0, d0.length));
      inverseVectorList.add(new RealVector(d1, d1.length));
      inverseVectorList.add(new RealVector(d2, d2.length));
      for(int i = 0; i<matrix.size(); i++){
        RealVector tempVector = null;
        for(int j = 0; j<inverseVectorList.size(); j++){
          tempVector = new RealVector(matrix.get(i).addToVector(inverseVectorList.get(i).get(j)));
        }
        vectorList.add(tempVector);
      }
      tempMatrix = new RealMatrix(vectorList);
      vectorList.clear();
      vectorList = reduce(tempMatrix);
      tempMatrix = new RealMatrix(vectorList);
      vectorList.clear();
      for(int i = tempMatrix.numRows(); i<tempMatrix.numColumns(); i++){
        vectorList.add(tempMatrix.getColumn(i));
      }
      tempMatrix = new RealMatrix(vectorList);
      tempMatrix = tempMatrix.transpose();
      return (tempMatrix);
    }
  }
}
