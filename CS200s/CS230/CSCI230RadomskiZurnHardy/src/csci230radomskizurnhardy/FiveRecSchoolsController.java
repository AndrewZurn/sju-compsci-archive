package csci230radomskizurnhardy;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author pghardy
 */
public class FiveRecSchoolsController {
    
    private University u;
    private ArrayList<University> allU = DatabaseController.getAllUniversities();
    private ArrayList<Double> allScore = new ArrayList<Double>();
        
    public FiveRecSchoolsController(University u){
        this.u = u;
        for(University uni: allU){
            allScore.add(0.0);
        }
    }
   public void findDifference(){
       
   }
    
    
    
    public static void main(String[] args) {
         
    }
}
