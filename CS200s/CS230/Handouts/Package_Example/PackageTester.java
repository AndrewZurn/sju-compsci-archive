import edu.csbsju.cs.*;
  // the Employee class is defined in that package


public class PackageTester
{  
   public static void main(String[] args)
   {  
      // because of the import statement, we don't have to edu.csbsju.cs.Employee here
       Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);
       //edu.csbsju.cs.Employee harry = new edu.csbsju.cs.Employee("Harry Hacker", 50000, 1989, 10, 1);

      // raise salary by 5%
      harry.raiseSalary(5);

      // print out information about harry
      // use java.lang.System.out here
      System.out.println("name=" + harry.getName() + ",salary=" + harry.getSalary());
      //System.out.println("name=" + harry.getName() + ",salary=" + harry.getSalary());
      System.out.println("name=" + harry.getName() + ",salary=" + harry.getSalary());
   }
}

