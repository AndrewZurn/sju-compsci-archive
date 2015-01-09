
/**
 * @author Jim Schnepf
 * 
 * a class that hold a name and grade
 * 
 */
public class Score {
  
  /**Name of student */
  private String studentName;
  
  /** grade for student */
  private int grade;  
  
  /**
   * Constructor for a Score with the name and grade as parameters
   * @param name the name of the student
   * @param number grade of the student
   */
  public Score(String name, int number) {
    studentName = name;
    grade = number;
  }
  
  /**
   * Change the selection of a student
   *   @param name the name of the student
   */
  public void setName(String name) {
    studentName = name;
  }
  
  /**
   * Change the choice of a student
   * @param newGrade  new grade of the student
   */
  public void setGrade(int newGrade) {
    grade = newGrade;
  }    
  
  /**
   * retrieve the name of a student
   * @return name of the student
   */
  public String getName(){
    return studentName;
  }
  
  /**
   * retrieve the choice of a student
   * @return grade of student
   */
  public int getGrade() {
    return grade;
  }
}