package csci230radomskizurnhardy;

/**
 * The Driver/Main class for the CSCI230RadomskiZurnHardy CMC project. This
 * class will call upon all other classes in this package to highlight the
 * working capabilities of this system.
 *
 * @author Andrew Zurn, Wiley Radomski, Preston Hardy
 * @version 1.0
 * @since March 25, 2012
 */
public class CSCI230RadomskiZurnHardy {

    /**
     * User to run this class from the command line
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Just some tests:
        DatabaseController DB = new DatabaseController();
        
        //CSCI230RadomskiZurnHardy rzh = new CSCI230RadomskiZurnHardy();
        //ArrayList<University> test = DB.getAllUniversities();
        //TreeMap test2 = DB.getAllUniversityNamesWithEmphases();
        //ArrayList<User> test3 = DB.getAllUsers();
//        User user = DB.getSpecificUser("nadmin");
//        System.out.println(user);
//        boolean loginStatus = UserController.login("nadmin", "admin");
//        System.out.println(loginStatus);
//        loginStatus = UserController.login("nadmin", "test");
//        System.out.println(loginStatus);
//        loginStatus = UserController.login("noUser", "wrong");
//        System.out.println(loginStatus);
//        String test = "I am Sam";
//        String sub1 = " ";
//        String sub2 = "am";
//        String sub3 = "sa";
//        String sub4 = "ma";
//        System.out.println(test.toLowerCase().indexOf(sub1)>=0);
//        System.out.println(test.toLowerCase().indexOf(sub2)>=0);
//        System.out.println(test.toLowerCase().indexOf(sub3)>=0);
//        System.out.println(test.toLowerCase().indexOf(sub4)>=0);
//        FiveRecSchoolsController frsc = new FiveRecSchoolsController(DatabaseController.getAllUniversities().get(0));
//        System.out.println(DatabaseController.getAllUniversities().get(0));
//        for (University u : frsc.getFiveMatches()) {
//            System.out.println(u);
//        }

        //Admin Functionality
        System.out.println("\n\nAdmin Class Functionality Proof");
        Admin.main(null);

        //User Functionality
        System.out.println("\n\nUser Class Functionality Proof");
        User.main(null);

        //University Functionality
        System.out.println("\n\nUniversity Class Functionality Proof");
        University.main(null);

        //Admin Controller Functionality
        System.out.println("\n\nAdmin Controller Class Functionality Proof");
        //AdminController.main(null);

        //Search Controller Functionality
        System.out.println("\n\nSearch Controller Class Functionality Proof");
        //SearchController.main(null);
        
        //User Controller Functionality
        System.out.println("\n\nUser Controller Class Functionality Proof");
        UserController.main(null);
        
        //FiveRecSchoolsController Functionality
        System.out.println("\n\nFiveRecScoolsController Class Functionality Proof");
        FiveRecSchoolsController.main(null);
        
        //Person Functionality
        //This functionality is shown through the two classes, Admin and User 
        //which extend Person and use the superclasses' methods (Peron's methods)
        
        //Database Controller Functionality
        //The functionality of the Database Controller is shown through all
        //the other classes which properly call and use its methods.
       }
}
