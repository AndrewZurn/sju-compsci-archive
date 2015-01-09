import java.util.*;
public class RealVector {
  //values holds the co-ordinate values for the vector
  private ArrayList<Double> values;
  //length is the size of the vector.
  private int length;
  
  /**
   * This constructor constructs a RealVector from an array of doubles
   * and an int telling what size the vector should be - i.e., how many
   * values from the array of doubles to use.
   */
  public RealVector(double [] arrayOfDoubles,int length) {
    this.length=length;
    values=new ArrayList<Double>();
    //create a vector by copying the arrayOfDoubles into the ArrayList.
    for(int i=0;i<length;i++) {
      values.add(arrayOfDoubles[i]);
    }
  }
  
  /**
   * This second constructor constructs the RealVector by copying the
   * ArrayList<Double> a into the internal values ArrayList<Double>.
   */
  public RealVector(ArrayList<Double> a) {
    values=new ArrayList<Double>();
    for(int i=0;i<a.size();i++) {
      values.add(a.get(i));
    }
    length=a.size();
  }
  
  /**
   * getLength() returns how many items there are in the vector.
   */
  public int getLength() {
    return(length);
  }
  
  /**
   * get(int i) returns the value at position i in the RealVector.
   */
  public double get(int i) throws RealVectorError {
    if((i<0) || (i>=length)) throw new RealVectorError(
            "Illegal index "+i+" in a RealVector");
    return(values.get(i));
  }
  
  /**
   * vectorNorm returns the result of the vector NORM operations which
   * is, in fact, the actual "length" of the vector in nSpace
   */
  public double vectorNorm() {
    //the norm of a vector is the square root of the sum of squares of
    //the values. Write this method. Of course, you will need to replace
    //the following return with code for what should happen.
    double d = 0.0;
    for(int i = 0; i < values.size(); i++){
      d = d + (values.get(i) * values.get(i));
    }
    d = Math.sqrt(d);
    return(d);
  }
  
  /**
   * add(RealVector v) returns the RealVector which is the term-by-term sum
   * of the values from this vector and the RealVector v.
   */
  public RealVector add(RealVector v) throws RealVectorError {
    //Return the RealVector which is the sum of this vector and v,
    //term by term. That is, the first co-ordinate of the sum is 
    //this.get(0)+v.get(0), the second co-ordinate is this.get(1)+v.get(1),
    //...  You will, of course, have to replace the following with
    //appropriate code.
    if ( v.getLength() != values.size() ){
      throw new RealVectorError("The vectors are of a different size!");
    }
    else{
      ArrayList<Double> newVector = new ArrayList<Double>();
      for(int i = 0; i < v.getLength(); i++){
        newVector.add(values.get(i) + v.get(i));
      }
    return(new RealVector(newVector));
    }
  }
  
  /**
   * subtract(RealVector v) returns the vector difference of this vector
   * and v.
   */
  public RealVector subtract(RealVector v) throws RealVectorError {
    //As in add, your method should return this vector - v meaning
    //subtract term by term to form the new vector. You will, of course,
    //have to replace the following with appropriate code.
    if ( v.getLength() != values.size() ){
      throw new RealVectorError("The vectors are of a different size!");
    }
    else{
      ArrayList<Double> newVector = new ArrayList<Double>();
      for(int i = 0; i < v.getLength(); i++){
        newVector.add(values.get(i) - v.get(i));
      }
    return(new RealVector(newVector));
    }
  }
  
  /**
   * scalarProduct(double a) returns the RealVector which is the result
   * of multiplying each value in ths vector by a.
   */
  public RealVector scalarProduct(double a) {
    //This method returns the vector formed by multiplying each co-ordinate
    //of this vector by a. Replace the following.
    ArrayList<Double> newVector = new ArrayList<Double>();
    for(int i = 0; i < values.size(); i++){
        newVector.add(values.get(i) * a);
      }
    return(new RealVector(newVector));
  }
  
  /**
   * dotProduct(RealVector v) returns the dot product of this RealVector
   * and the RealVector v.
   */
  public double dotProduct(RealVector v) throws RealVectorError {
    //This method will return the dot product of this vector and v.
    //The dot product is the sum of the products of corresponding
    //terms in the two vectors. For example, if this vector were 
    //(3,2,4) and v were (-3,2,6), the dot product would be 
    //3*(-3)+2*2+4*6. Replace the following.
    if ( v.getLength() != values.size() ){
      throw new RealVectorError("The vectors are of a different size!");
    }
    else{
      double x = 0.0;
      for(int i = 0; i < v.getLength(); i++){
        x = x + (values.get(i) * v.get(i));
      }
    return(x);
    }
  }
  
  public ArrayList<Double> addToVector(double x){
    values.add(x);
    return values;
  }
  
  /**
   * toString returns a nice String representation of a vector.
   */
  public String toString() {
    String temp="<<";
    for(int i=0;i<this.length-1;i++) {
      temp= temp+this.get(i)+",";
      
    }
    temp=temp+this.get(this.length-1)+">>";
    return(temp);
  }
}
    