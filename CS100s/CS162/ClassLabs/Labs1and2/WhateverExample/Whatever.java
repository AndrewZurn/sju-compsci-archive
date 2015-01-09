import objectdraw.*;

/**
 * This is where you describe your class. Do a general
 * description of what the class is for. Then follow it
 * with your name as the author of the class. (If it is
 * a pair project, do both names.) You do the author
 * with the @author structure below.
 * 
 * Note that if you know html tags, you can add some of
 * them into your javadoc. For example, you could use
 * <b>bold</b> to make bold type or <i>italic</i>
 * or <b><i>bold and italic</i></b> or use the paragraph code
 * <p>...</p> 
 * <p>to surround a paragraph. Get ahold of an html manual
 * if you want to go crazy with this.</p>
 * You can also do bullet lists:
 * <ul>
 * <li> first item
 * <li>second item which
 * goes across lines
 * </ul>
 * or numbered lists:
 * <ol>
 * <li>first numbered item
 * <li>second numbered item
 * <li>third numbered item
 * </ol>
 * or pictures: <p>
 * <img src="jupiter_small.jpg" alt="Jupiter" width: 100px; height: 103px;">
 * <p>
 * or references to other sites:
 * <p>
 * <a href="http://www.users.csbsju.edu/~lziegler/Calculus/">Plotting applet</a>
 * <p>
 * @author John Q. Public and T. C. Mits
 * @version 3.14159
 */
public class Whatever {
  //private variables get this kind of comment describing them
  private int wherever;
  /**
   * public variables get this kind of comment describing them
   */
  public double someData;
  
  /**
   * Public constructors also need to have javadoc comments stating
   * what it is they do at construction time.
   */
  public Whatever() {
    //the default constructor
  }
  
  /**
   * Other constructors may need additional comments. For example, this
   * constructor receives a parameter and, possibly, throws an exception.
   * thus, we need to add:
   * 
   * <b>precondition:</b> The parameter x is positive.
   * </p><br>
   * @param x The initial value of the Whatever object.
   * @throws BadWhateverException whenever x is <=0
   */
  public Whatever(Double x) throws BadWhateverException {
    if(x<0) throw new BadWhateverException("Must have positive parameter x");
  }

  /**
   * public String whomever(int x,int y) computes blah and also
   * blah and also blah. (Of course, you are more specific
   * about what it does.) Note the blank line before the
   * beginning of the code for the method. Every public method
   * must have a comment like this - including constructors.
   * <p><br>Optionally you may want to include preconditions, postconditions,
   * parameter descriptions, a return description, and throws statements
   * as shown in this example.
   * <p><br>
   * <b>precondition:</b> a description of the preconditions
   * </p><br>
   * <b>postcondition: </b> a description of the postcondition
   * @param x the x-coordinate of the point
   * @param y the y-coordinate of the point
   * @throws NumberFormatException statement as to why that Exception
   * is thrown.
   * @return Only me
   */
  public String whomever(int x, int y) throws NumberFormatException{
    return("Only me!");
  }
  
  /*
   * private int whatevercalc(int x, int y) computes blah too.
   * Note that private methods have a slightly different comment
   * since their comments will NOT be part of the javadoc page
   * generated. You can still use @param statements if you like,
   * but it is pretty pointless.
   * @param x the x-coordinate of the point
   * @param y the y-coordinate of the point
   * @return the value 3
   */
  private int whatevercalc(int x, int y) {
    return(3);
  }
}
  
  
