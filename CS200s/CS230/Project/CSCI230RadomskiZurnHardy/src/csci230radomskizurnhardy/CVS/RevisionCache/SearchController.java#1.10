/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci230radomskizurnhardy;
import java.util.ArrayList;
/**
 * This class will be used to perform the searching that a user will need to find schools that they
 * are interested in, and also schools that should be recommended for them to consider.
 * @author awzurn
 * @version 1.0
 * @since March 18, 2012
 */
public class SearchController {   
    
    private static ArrayList<University> allUniversitiesList = DatabaseController.getAllUniversities();
    private static ArrayList<University> updatingList = new ArrayList<University>();
    private static ArrayList<University> testArray = new ArrayList<University>();
    private static ArrayList<University> listBeforeMethod = DatabaseController.getAllUniversities();
    
    /**
     * This method will call upon other private methods within this class to compile a map of all relevant
     * schools to the user's query and also recommended schools that the user should consider.
     * @param wantedSchool The school name the user wants to find.
     * @param wantedState The state in which the user wants the school to be located.
     * @param wantedLocation The location in which the user wants the school to be located.
     * @param wantedControl The control of the school, being a public or private school.
     * @param wantedNumberOfStudents The wanted number of students at the university.
     * @param wantedPercentFemales The wanted percentage of students that are female at the university.
     * @param wantedSATVerbal The wanted SAT Verbal range for the school.
     * @param wantedSATMath The wanted SAT Math range for the school.
     * @param wantedExpenses The wanted expense in attending this school.
     * @param wantedPercentFinancialAid The wanted percent of financial aid given by the school.
     * @param wantedNumberOfApplicants The wanted number of applicants applying to the school.
     * @param wantedPercentAdmitted The wanted percentage of applicants admitted to the school.
     * @param wantedPercentEnrolled The wanted percentage of admitted students that enroll.
     * @param wantedAcademicsScale The wanted score of the academics on a scale 1-5 at the school.
     * @param wantedSocialScale The wanted score of the social life on a scale of 1-5 at the school.
     * @param wantedQualityOfLifeScale The wanted score for the quality of life on a scale of 1-5 at the school.
     * @return Will return both the list of school relevant to the user's query, and a list of recommended schools for the student to view.
     */
    public static ArrayList<University> search(String wantedSchool,
            String wantedState, String wantedLocation,String wantedControl, Integer lowWantedNumber, Integer highWantedNumber,
            Double lowPercentFemales, Double highPercentFemales, Double lowSATVerbal, Double highSATVerbal, Double lowSATMath,
            Double highSATMath, Double lowExpenses, Double highExpenses, Double lowFinAid, Double highFinAid,
            Integer lowNumApplicants, Integer highNumApplicants, Double lowAdmitted, Double highAdmitted,
            Double lowEnrolled, Double highEnrolled, Integer lowAcademicScale, Integer highAcademicScale,
            Integer lowSocialScale, Integer highSocialScale, Integer lowQualityScale,
            Integer highQualityScale, ArrayList<String> emphasesList){
        
        searchWantedSchools(wantedSchool);
        searchWantedState(wantedState);
        searchWantedLocation(wantedLocation);
        searchWantedControl(wantedControl);
        searchWantedNumberOfStudents(lowWantedNumber, highWantedNumber);
        searchWantedPercentFemales(lowPercentFemales, highPercentFemales);
        searchWantedSATVerbal(lowSATVerbal, highSATVerbal);
        searchWantedSATMath(lowSATMath, highSATMath);
        searchWantedExpenses(lowExpenses, highExpenses);
        searchWantedPercentFinancialAid(lowFinAid, highFinAid);
        searchWantedNumberOfApplicants(lowNumApplicants, highNumApplicants);
        searchWantedPercentAdmitted(lowAdmitted, highAdmitted);
        searchWantedPercentEnrolled(lowEnrolled, highEnrolled);
        searchWantedAcademicsScale(lowAcademicScale, highAcademicScale);
        searchWantedSocialScale(lowSocialScale, highSocialScale);
        searchWantedQualityOfLifeScale(lowQualityScale, highQualityScale);
        searchWantedEmpheses(emphasesList);
        
        /*refinedSearch(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                highQualityScale, emphasesList);*/
        
        return listBeforeMethod;
    }
    
    private static void updateTwoLists(){
        listBeforeMethod = new ArrayList<University>();
        for(University subject: updatingList){
            listBeforeMethod.add(subject);
        }
        updatingList = new ArrayList<University>();
    }
    
    
    /**
     * Will search the name of the given school against the list of schools in the database.
     * @param wantedSchool name of school.
     */
    private static void searchWantedSchools(String wantedSchool){
        if(wantedSchool != null){
           for(University uni: listBeforeMethod){
                if(uni.getSchool().toLowerCase().indexOf(wantedSchool.toLowerCase())>=0){
                    updatingList.add(uni);
                }
            }
           updateTwoLists();
        }
        else{}//do nothing
    }
    
    /**
     * Will search the name of the given state against the list of schools in the database.
     * @param wantedState name of state.
     */
    private static void searchWantedState(String wantedState){
        
        if(wantedState != null){
            for(University uni: listBeforeMethod){
                if(uni.getSchool().toLowerCase().indexOf(wantedState.toLowerCase())>=0){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else{}//do nothing
    }
    
    /**
     * Will search the name of the given location against the list of schools in the database.
     * @param wantedLocation name of location.
     */
    private static void searchWantedLocation(String wantedLocation){
        if(wantedLocation != null && !wantedLocation.equals("-1")){
            for(University uni: listBeforeMethod){
                if(uni.getSchool().toLowerCase().indexOf(wantedLocation.toLowerCase())>=0){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else{}//do nothing
    }
    
    /**
     * Will search the name of the given control against the list of schools in the database.
     * @param wantedControl private or public education.
     */
    private static void searchWantedControl(String wantedControl){
        if(wantedControl != null && !wantedControl.equals("-1")){
            for(University uni: listBeforeMethod){
                if(uni.getSchool().toLowerCase().indexOf(wantedControl.toLowerCase())>=0){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else{}//do nothing
    }
    
    /**
     * Will search the name of the given number of students against the list of schools in the database.
     * @param lowNumberWanted low number of range in wanted students.
     * @param highNumberWanted high number of range in wanted students.
     */
    private static void searchWantedNumberOfStudents(Integer lowNumberWanted, Integer highNumberWanted){
        if(lowNumberWanted != null && highNumberWanted != null){
            for(University uni: listBeforeMethod){
                if(uni.getNumberOfStudents() <= highNumberWanted 
                        && uni.getNumberOfStudents() >= lowNumberWanted){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else if(lowNumberWanted == null && highNumberWanted != null){
            for(University uni: listBeforeMethod){
                if(uni.getNumberOfStudents() <= highNumberWanted){
                    updatingList.add(uni);
                }
                updateTwoLists();
            }
        }
        else if(lowNumberWanted != null && highNumberWanted == null){
            for(University uni: listBeforeMethod){
                if(uni.getNumberOfStudents() >= lowNumberWanted){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else{}//do nothing
    }
    
    /**
     * Will search the name of the given percent of females against the list of schools in the database.
     * @param lowPercentFemales low number of range in wanted percentage of females.
     * @param highPercentFemales high number of range in wanted percentage of females. 
     */
    private static void searchWantedPercentFemales(Double lowPercentFemales, Double highPercentFemales){
        if(lowPercentFemales != null && highPercentFemales != null){
            for(University uni: listBeforeMethod){
                if(uni.getPercentFemales() <= highPercentFemales 
                        && uni.getPercentFemales() >= lowPercentFemales){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else if(lowPercentFemales == null && highPercentFemales != null){
            for(University uni: listBeforeMethod){
                if(uni.getPercentFemales() <= highPercentFemales){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else if(lowPercentFemales != null && highPercentFemales == null){
            for(University uni: listBeforeMethod){
                if(uni.getPercentFemales() >= lowPercentFemales){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else{}//do nothing
    }
    
    /**
     * Will search the name of the given SAT verbal score against the list of schools in the database.
     * @param lowSATVerbal low number in range of SAT verbal scores.
     * @param highSATVerbal high number in range of SAT verbal scores.
     */
    private static void searchWantedSATVerbal(Double lowSATVerbal, Double highSATVerbal){
        if(lowSATVerbal != null && highSATVerbal != null){
            for(University uni: listBeforeMethod){
                if(uni.getSATVerbal() <= highSATVerbal 
                        && uni.getSATVerbal() >= lowSATVerbal){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else if(lowSATVerbal == null && highSATVerbal != null){
            for(University uni: listBeforeMethod){
                if(uni.getSATVerbal() <= highSATVerbal){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else if(lowSATVerbal != null && highSATVerbal == null){
            for(University uni: listBeforeMethod){
                if(uni.getSATVerbal() >= lowSATVerbal){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else{}//do nothing
        //System.out.println(foundSchools);
    }
    
    /**
     * Will search the name of the given SAT math score against the list of schools in the database.
     * @param lowSATMath low number in range of SAT math scores.
     * @param highSATMath high number in range of SAT math scores.
     */
    private static void searchWantedSATMath(Double lowSATMath, Double highSATMath){
        if(lowSATMath != null && highSATMath != null){
            for(University uni: listBeforeMethod){
                if(uni.getSATMath() <= highSATMath
                        && uni.getSATMath() >= lowSATMath){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else if(lowSATMath == null && highSATMath != null){
            for(University uni: listBeforeMethod){
                if(uni.getSATMath() <= highSATMath){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else if(lowSATMath != null && highSATMath == null){
            for(University uni: listBeforeMethod){
                if(uni.getSATMath() >= lowSATMath){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else{}//do nothing
    }
    
    /**
     * Will search the name of the given expense against the list of schools in the database.
     * @param lowExpenses low number in range of expenses.
     * @param highExpenses high number in range of expenses.
     */
    private static void searchWantedExpenses(Double lowExpenses, Double highExpenses){
        if(lowExpenses != null && highExpenses != null){
            for(University uni: listBeforeMethod){
                if(uni.getExpenses() <= highExpenses
                        && uni.getExpenses() >= lowExpenses){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else if(lowExpenses == null && highExpenses != null){
            for(University uni: listBeforeMethod){
                if(uni.getExpenses() <= highExpenses){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else if(lowExpenses != null && highExpenses == null){
            for(University uni: listBeforeMethod){
                if(uni.getExpenses() >= lowExpenses){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else{}//do nothing
    }
    
    /**
     * Will search the name of the given percent of financial aid against the list of schools in the database.
     * @param lowFinAid low number in range of financial aid.
     * @param highFinAid high number in range of financial aid.
     */
    private static void searchWantedPercentFinancialAid(Double lowFinAid, Double highFinAid){
        if(lowFinAid != null && highFinAid != null){
            for(University uni: listBeforeMethod){
                if(uni.getPercentFinancialAid() <= highFinAid
                        && uni.getPercentFinancialAid() >= lowFinAid){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else if(lowFinAid == null && highFinAid != null){
            for(University uni: listBeforeMethod){
                if(uni.getPercentFinancialAid() <= highFinAid){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else if(lowFinAid != null && highFinAid == null){
            for(University uni: listBeforeMethod){
                if(uni.getPercentFinancialAid() >= lowFinAid){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else{}//do nothing
    }
    
    /**
     * Will search the name of the given number of applicants against the list of schools in the database.
     * @param lowNumApplicants low number in range of applicants.
     * @param highNumApplicants high number in range of applicants.
     */
    private static void searchWantedNumberOfApplicants(Integer lowNumApplicants, Integer highNumApplicants){
        if(lowNumApplicants != null && highNumApplicants != null){
            for(University uni: listBeforeMethod){
                if(uni.getNumberOfApplicants() <= highNumApplicants
                        && uni.getNumberOfApplicants() >= lowNumApplicants){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else if(lowNumApplicants == null && highNumApplicants != null){
            for(University uni: listBeforeMethod){
                if(uni.getNumberOfApplicants() <= highNumApplicants){
                    updatingList.add(uni);
                }
                updateTwoLists();
            }
        }
        else if(lowNumApplicants != null && highNumApplicants == null){
            for(University uni: listBeforeMethod){
                if(uni.getNumberOfApplicants() >= lowNumApplicants){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else{}//do nothing
    }
    
    /**
     * Will search the name of the given percent admitted against the list of schools in the database.
     * @param lowAdmitted low number in range of admitted students.
     * @param highAdmitted high number in range of admitted students.
     */
    private static void searchWantedPercentAdmitted(Double lowAdmitted, Double highAdmitted){
        if(lowAdmitted != null && highAdmitted != null){
            for(University uni: listBeforeMethod){
                if(uni.getPercentAdmitted() <= highAdmitted
                        && uni.getPercentAdmitted() >= lowAdmitted){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else if(lowAdmitted == null && highAdmitted != null){
            for(University uni: listBeforeMethod){
                if(uni.getPercentAdmitted() <= highAdmitted){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else if(lowAdmitted != null && highAdmitted == null){
            for(University uni: listBeforeMethod){
                if(uni.getPercentAdmitted() >= lowAdmitted){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else{}//do nothing
    }
    
    /**
     * Will search the name of the given percent enrolled against the list of schools in the database.
     * @param lowEnrolled low number in range of enrolled students that were admitted.
     * @param highEnrolled high number in range of enrolled students that were admitted.
     */
    private static void searchWantedPercentEnrolled(Double lowEnrolled, Double highEnrolled){
        if(lowEnrolled != null && highEnrolled != null){
            for(University uni: listBeforeMethod){
                if(uni.getPercentEnrolled() <= highEnrolled
                        && uni.getPercentEnrolled() >= lowEnrolled){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else if(lowEnrolled == null && highEnrolled != null){
            for(University uni: listBeforeMethod){
                if(uni.getPercentEnrolled() <= highEnrolled){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else if(lowEnrolled != null && highEnrolled == null){
            for(University uni: listBeforeMethod){
                if(uni.getPercentEnrolled() >= lowEnrolled){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else{}//do nothing
    }
    
    /**
     * Will search the name of the given academics score against the list of schools in the database.
     * @param lowAcademicScale low number in range of academics scale at this school.
     * @param highAcademicScale high number in range of academics scale at this school. 
     */
    private static void searchWantedAcademicsScale(Integer lowAcademicScale, Integer highAcademicScale){
        if(lowAcademicScale != null && highAcademicScale != null){
            for(University uni: listBeforeMethod){
                if(uni.getAcademicsScale() <= highAcademicScale
                        && uni.getAcademicsScale() >= lowAcademicScale){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else if(lowAcademicScale == null && highAcademicScale != null){
            for(University uni: listBeforeMethod){
                if(uni.getAcademicsScale() <= highAcademicScale){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else if(lowAcademicScale != null && highAcademicScale == null){
            for(University uni: listBeforeMethod){
                if(uni.getAcademicsScale() >= lowAcademicScale){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else{}//do nothing
    }
    
    /**
     * Will search the name of the given social score against the list of schools in the database.
     * @param lowSocialScale low number in range of social scale at this school.
     * @param highSocialScale high number in range of social scale at this school.
     */
    private static void searchWantedSocialScale(Integer lowSocialScale, Integer highSocialScale){
        if(lowSocialScale != null && highSocialScale != null){
            for(University uni: listBeforeMethod){
                if(uni.getSocialScale() <= highSocialScale
                        && uni.getSocialScale() >= lowSocialScale){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else if(lowSocialScale == null && highSocialScale != null){
            for(University uni: listBeforeMethod){
                if(uni.getSocialScale() <= highSocialScale){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else if(lowSocialScale != null && highSocialScale == null){
            for(University uni: listBeforeMethod){
                if(uni.getSocialScale() >= lowSocialScale){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else{}//do nothing
    }
    
    /**
     * Will search the name of the given quality of life score against the list of schools in the database.
     * @param lowQualityScale low number in range of quality of life scale at this school.
     * @param highQualityScale high number in range of quality of life scale at this school.
     */
    private static void searchWantedQualityOfLifeScale(Integer lowQualityScale, Integer highQualityScale){
        if(lowQualityScale != null && highQualityScale != null){
            for(University uni: listBeforeMethod){
                if(uni.getQualityOfLifeScale() <= highQualityScale
                        && uni.getQualityOfLifeScale() >= lowQualityScale){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else if(lowQualityScale == null && highQualityScale != null){
            for(University uni: listBeforeMethod){
                if(uni.getQualityOfLifeScale() <= highQualityScale){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else if(lowQualityScale != null && highQualityScale == null){
            for(University uni: listBeforeMethod){
                if(uni.getQualityOfLifeScale() >= lowQualityScale){
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
        else{}//do nothing
    }
    
    /**
     * Will search through the given emphases, and compare them to all the schools to find the schools with
     * like emphases.
     * @param emphases list of emphases to be compared schools against.
     */
    private static void searchWantedEmpheses(ArrayList<String> emphases){
        if(!emphases.isEmpty()){
            for(University uni: listBeforeMethod){
                if(uni.getEmphases() != null){
                    for(String uniEmphases: uni.getEmphases()){
                         for(String emphasis: emphases){
                            if(uniEmphases.equalsIgnoreCase(emphasis)){
                                updatingList.add(uni);
                            }
                         }
                    }
                }
            }
            updateTwoLists();
        }
        else{}//do nothing
    }
    
    /*private static void refinedSearch(String wantedSchool,
            String wantedState, String wantedLocation,String wantedControl, Integer lowWantedNumber, Integer highWantedNumber,
            double lowPercentFemales, double highPercentFemales, double lowSATVerbal, double highSATVerbal, double lowSATMath,
            double highSATMath, double lowExpenses, double highExpenses, double lowFinAid, double highFinAid,
            Integer lowNumApplicants, Integer highNumApplicants, double lowAdmitted, double highAdmitted,
            double lowEnrolled, double highEnrolled,Integer lowAcademicScale, Integer highAcademicScale,
            Integer lowSocialScale, Integer highSocialScale, Integer lowQualityScale,
            Integer highQualityScale, ArrayList<String> emphasesList){
        for(University uni: foundSchools){
            if((wantedSchool != null && )){
                
            }
                
        }
        
    }*/
    
    /**
     * Used to run this class from the command line.
     * @param args Arguments given to the class from stdin.
     */
    public static void main(String args[]){
    }
    public SearchController(){
//        for(University uni: universitiesList){
//            System.out.println(uni.getSchool());
//        }
        
        String wantedSchool = null;
        String wantedState = null;
        String wantedLocation = "-1";
        String wantedControl = "-1";
        Integer lowWantedNumber = 0;
        Integer highWantedNumber = 1000000;
        Double lowPercentFemales = null;
        Double highPercentFemales = null;
        Double lowSATVerbal = null;
        Double highSATVerbal = null;
        Double lowSATMath = 400.0;
        Double highSATMath = 600.0;
        Double lowExpenses = null;
        Double highExpenses = null;
        Double lowFinAid = null;
        Double highFinAid = null;
        Integer lowNumApplicants = null;
        Integer highNumApplicants = null;
        Double lowAdmitted = null;
        Double highAdmitted = null;
        Double lowEnrolled = null;
        Double highEnrolled = null;
        Integer lowAcademicScale = null;
        Integer highAcademicScale = null;
        Integer lowSocialScale = null;
        Integer highSocialScale = null;
        Integer lowQualityScale = null;
        Integer highQualityScale = null;
        ArrayList<String> empList = new ArrayList<String>();
        //empList.add("science");
        //empList.add("math");
        
        testArray = search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                highQualityScale, empList);
        //add all entries in testArray into a TreeSet to remove doubles!
//        TreeSet<University> t = new TreeSet<University>();
//        for(University uni: testArray){
//            System.out.println(uni.getSchool());
//            t.add(uni);
//            
//        }
        for(University uni: testArray){
            System.out.println("AAA: "+ uni.getSchool() + "|"+ uni.getSATMath());
        }
        //System.out.println("TEST ARRAY:" + testArray);
        
//        for(University uni: universitiesList){
//            System.out.println(uni.getNumberOfStudents()+"|"+uni.getSchool());
//        }
            
    }
}
