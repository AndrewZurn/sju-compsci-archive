public class JasonHelper1{
  JasonHelper2 help = new JasonHelper2();
  
  public JasonHelper1(){
    System.out.println("JasonHelper2 contains and passes its string, which is: " + help.getString());
  }

  public static void main(String args[]){
    new JasonHelper1();
  }
}