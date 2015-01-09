import complex.*;
public class TestComplex {
  public TestComplex() {
    Complex z1,z2,z3,z4,z5;
    z1=new Complex(1.0,1.0);
    z2=new Complex(2.0,-3.0);
    z3=new Complex();
    z4=new Complex(-5.3);
    z5=new Complex(0.0,3.6);
    System.out.println("z1="+z1+" modulus(z1)="+z1.modulus()+
                       " argument(z1)="+z1.argument()+
                       " conjugate(z1)="+z1.conjugate()+
                       "\nrealPart(z1)="+z1.getRealPart()+
                       " imaginaryPart(z1)="+z1.getImaginaryPart());
    System.out.println("\nz2="+z2+" modulus(z2)="+z2.modulus()+
                       " argument(z2)="+z2.argument()+
                       " conjugate(z2)="+z2.conjugate()+
                       "\nrealPart(z2)="+z2.getRealPart()+
                       " imaginaryPart(z2)="+z2.getImaginaryPart());
    System.out.println("\nz3="+z3+" modulus(z2)="+z3.modulus()+
                       " argument(z3)="+z3.argument()+
                       " conjugate(z3)="+z3.conjugate()+
                       "\nrealPart(z3)="+z3.getRealPart()+
                       " imaginaryPart(z3)="+z3.getImaginaryPart());
    System.out.println("\nz4="+z4+" modulus(z4)="+z4.modulus()+
                       " argument(z4)="+z4.argument()+
                       " conjugate(z4)="+z4.conjugate()+
                       "\nrealPart(z4)="+z4.getRealPart()+
                       " imaginaryPart(z4)="+z4.getImaginaryPart());
    System.out.println("\nz5="+z5+" modulus(z5)="+z5.modulus()+
                       " argument(z5)="+z5.argument()+
                       " conjugate(z5)="+z5.conjugate()+
                       "\nrealPart(z5)="+z5.getRealPart()+
                       " imaginaryPart(z5)="+z5.getImaginaryPart());
    System.out.println(""+z1+" * "+z2+"="+z1.multiply(z2));
    System.out.println(""+z1+" / "+z2+"="+z1.divide(z2));
    System.out.println(""+z1+" + "+z2+"="+z1.add(z2));
    System.out.println(""+z1+" - "+z2+"="+z1.subtract(z2));
    try {
      z2=new Complex(0.0);
      System.out.println(""+z1+"/"+z2+"="+z1.divide(z2));
    }
    catch(ComplexDivideByZeroRuntimeException e) {
      System.out.println("Attempt to divide "+z1+" by zero.");
      e.printStackTrace();
    }
    System.out.println(""+z1+"/"+z2+"="+z1.divide(z2));
 }
  public static void main(String [] args) {
    new TestComplex();
  }
}