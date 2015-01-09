import java.util.*;
public class RealMatrix{
  private RealVector rows;
  private ArrayList<RealVector> matrix;
  
  public RealMatrix(){
  }
  
  public String toString(){
  }
  
  public int numRows(){
  }
  
  public int numColumns(){
  }
  
  public double getValue(int i, int j){
  }
  
  public RealMatrix transpose(){
  }
  
  public RealVector matrixVectorProduct(Vector v) throws RealVectorError{
  }
  
  public RealMatrix add(RealMatrix m) throws RealVectorError{
  }
  
  public RealMatrix substract(RealMatrix m){
  }
  
  public RealMatrix scalarProduct(double a){
  }
  
  public RealMatrix matrixMultiply(RealMatrix m){
  }
}