/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci230radomskizurnhardy;

/**
 *
 * @author pghardy
 */
public class CSCI230RadomskiZurnHardy {

    public void CSCI230RadomskiZurnHardy(){
        
    }
    
    
    
    /**
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
        FiveRecSchoolsController frsc = new FiveRecSchoolsController(DatabaseController.getAllUniversities().get(0));
        SearchController sc = new SearchController();
       }
}
