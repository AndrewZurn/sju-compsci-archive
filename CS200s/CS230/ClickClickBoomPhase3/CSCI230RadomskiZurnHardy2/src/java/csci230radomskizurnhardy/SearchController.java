/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci230radomskizurnhardy;

import java.util.ArrayList;

/**
 * This class will be used to perform the searching that a user will need to
 * find schools that they are interested in, and also schools that should be
 * recommended for them to consider.
 *
 * @author Andrew Zurn, Wiley Radomski, Preston Hardy
 * @version 1.0
 * @since March 18, 2012
 */
public class SearchController {

    /**
     * The universities found in the search, which is then added to the
     * listBeforeMethod list.
     */
    private static ArrayList<University> updatingList = new ArrayList<University>();
    /**
     * The ArrayList that will be used for some minor testing in the main class
     * method.
     */
    private static ArrayList<University> testArray = new ArrayList<University>();
    /**
     * List of all eligible schools still in search before put through a
     * specific search method.
     */
    private static ArrayList<University> listBeforeMethod = DatabaseController.getAllUniversities();
    

    /**
     * This method will call upon other private methods within this class to
     * compile a map of all relevant schools to the user's query and also
     * recommended schools that the user should consider.
    /**
     * This method will call upon other private methods within this class to
     * compile a map of all relevant schools to the user's query and also
     * recommended schools that the user should consider.
     * @param wantedSchool Name of wanted school
     * @param wantedState State where wanted school should be
     * @param wantedLocation Location where wanted school should be
     * @param wantedControl Control of School wanted
     * @param lowWantedNumber Minimum wanted number of students
     * @param highWantedNumber Maximum wanted number of students
     * @param lowPercentFemales Lowest percent female preferred
     * @param highPercentFemales Highest percent female preferred
     * @param lowSATVerbal Lowest Verbal SAT score preferred
     * @param highSATVerbal Highest Verbal SAT score preferred
     * @param lowSATMath Lowest Math SAT score preferred
     * @param highSATMath Highest Math SAT score preferred
     * @param lowExpenses Minimum wanted expenses
     * @param highExpenses Highest wanted expenses
     * @param lowFinAid Minimum Financial Aid wanted
     * @param highFinAid Maximum Financial Aid wanted
     * @param lowNumApplicants Lowest number of Applicants 
     * @param highNumApplicants Highest number of Applicants
     * @param lowAdmitted Lowest number admitted to the University
     * @param highAdmitted Hightest number admitted to the University
     * @param lowEnrolled Lowest number enrolled
     * @param highEnrolled Highest number enrolled
     * @param lowAcademicScale Lowest Academic Rating
     * @param highAcademicScale Highest Academic Rating
     * @param lowSocialScale Lowest Social Rating
     * @param highSocialScale Highest Social Rating
     * @param lowQualityScale Lowest quality of life accepted
     * @param highQualityScale Highest quality of life accepted
     * @param emphasesList Emphases preferred
     * @return Returns an ArrayList of the Schools which match all of the search criteria.
     */
    public static ArrayList<University> search(String wantedSchool,
            String wantedState, String wantedLocation, String wantedControl, Integer lowWantedNumber, Integer highWantedNumber,
            Double lowPercentFemales, Double highPercentFemales, Double lowSATVerbal, Double highSATVerbal, Double lowSATMath,
            Double highSATMath, Double lowExpenses, Double highExpenses, Double lowFinAid, Double highFinAid,
            Integer lowNumApplicants, Integer highNumApplicants, Double lowAdmitted, Double highAdmitted,
            Double lowEnrolled, Double highEnrolled, Integer lowAcademicScale, Integer highAcademicScale,
            Integer lowSocialScale, Integer highSocialScale, Integer lowQualityScale,
            Integer highQualityScale, ArrayList<String> emphasesList) {
        updatingList = new ArrayList<University>();
        listBeforeMethod = DatabaseController.getAllUniversities();
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

        /*
         * refinedSearch(wantedSchool, wantedState, wantedLocation,
         * wantedControl, lowWantedNumber, highWantedNumber, lowPercentFemales,
         * highPercentFemales, lowSATVerbal, highSATVerbal, lowSATMath,
         * highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
         * lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted,
         * lowEnrolled, highEnrolled, lowAcademicScale, highAcademicScale,
         * lowSocialScale, highSocialScale, lowQualityScale, highQualityScale,
         * emphasesList);
         */

        return listBeforeMethod;
    }

    /**
     * User to keep track of schools that are still eligible in the search for
     * the group of universities that will be returned to the user.
     */
    private static void updateTwoLists() {
        listBeforeMethod = new ArrayList<University>();
        for (University subject : updatingList) {
            listBeforeMethod.add(subject);
        }
        updatingList = new ArrayList<University>();
    }

    /**
     * Will search the name of the given school against the list of schools in
     * the database.
     *
     * @param wantedSchool name of school.
     */
    private static void searchWantedSchools(String wantedSchool) {
        if (wantedSchool != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getSchool().toLowerCase().indexOf(wantedSchool.toLowerCase()) >= 0) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
    }

    /**
     * Will search the name of the given state against the list of schools in
     * the database.
     *
     * @param wantedState name of state.
     */
    private static void searchWantedState(String wantedState) { 
        if (wantedState != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getState().toLowerCase().indexOf(wantedState.toLowerCase()) >= 0) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
    }

    /**
     * Will search the name of the given location against the list of schools in
     * the database.
     *
     * @param wantedLocation name of location.
     */
    private static void searchWantedLocation(String wantedLocation) {
        if (wantedLocation != null && !wantedLocation.equals("-1")) {
            for (University uni : listBeforeMethod) {
                if (uni.getLocation().toLowerCase().indexOf(wantedLocation.toLowerCase()) == 0) { //String must match exactly up to case
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
    }

    /**
     * Will search the name of the given control against the list of schools in
     * the database.
     *
     * @param wantedControl private or public education.
     */
    private static void searchWantedControl(String wantedControl) {
        if (wantedControl != null && !wantedControl.equals("-1")) {
            for (University uni : listBeforeMethod) {
                if (uni.getControl().toLowerCase().indexOf(wantedControl.toLowerCase()) >= 0) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
    }

    /**
     * Will search the name of the given number of students against the list of
     * schools in the database.
     *
     * @param lowNumberWanted low number of range in wanted students.
     * @param highNumberWanted high number of range in wanted students.
     */
    private static void searchWantedNumberOfStudents(Integer lowNumberWanted, Integer highNumberWanted) /*
     * throws Exception
     */ {
//        if (lowNumberWanted != null && highNumberWanted != null && (lowNumberWanted < -1 || highNumberWanted < -1)) {
//            throw new Exception("Number of Students should be poitive");
//        }
        if (lowNumberWanted != null && highNumberWanted != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getNumberOfStudents() <= highNumberWanted
                        && uni.getNumberOfStudents() >= lowNumberWanted) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        } else if (lowNumberWanted == null && highNumberWanted != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getNumberOfStudents() <= highNumberWanted) {
                    updatingList.add(uni);
                }
                updateTwoLists();
            }
        } else if (lowNumberWanted != null && highNumberWanted == null) {
            for (University uni : listBeforeMethod) {
                if (uni.getNumberOfStudents() >= lowNumberWanted) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }

    }

    /**
     * Will search the name of the given percent of females against the list of
     * schools in the database.
     *
     * @param lowPercentFemales low number of range in wanted percentage of
     * females.
     * @param highPercentFemales high number of range in wanted percentage of
     * females.
     */
    private static void searchWantedPercentFemales(Double lowPercentFemales, Double highPercentFemales) {
        if (lowPercentFemales != null && highPercentFemales != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getPercentFemales() <= highPercentFemales
                        && uni.getPercentFemales() >= lowPercentFemales) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        } else if (lowPercentFemales == null && highPercentFemales != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getPercentFemales() <= highPercentFemales) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        } else if (lowPercentFemales != null && highPercentFemales == null) {
            for (University uni : listBeforeMethod) {
                if (uni.getPercentFemales() >= lowPercentFemales) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
    }

    /**
     * Will search the name of the given SAT verbal score against the list of
     * schools in the database.
     *
     * @param lowSATVerbal low number in range of SAT verbal scores.
     * @param highSATVerbal high number in range of SAT verbal scores.
     */
    private static void searchWantedSATVerbal(Double lowSATVerbal, Double highSATVerbal) {
        if (lowSATVerbal != null && highSATVerbal != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getSATVerbal() <= highSATVerbal
                        && uni.getSATVerbal() >= lowSATVerbal) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        } else if (lowSATVerbal == null && highSATVerbal != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getSATVerbal() <= highSATVerbal) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        } else if (lowSATVerbal != null && highSATVerbal == null) {
            for (University uni : listBeforeMethod) {
                if (uni.getSATVerbal() >= lowSATVerbal) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
    }

    /**
     * Will search the name of the given SAT math score against the list of
     * schools in the database.
     *
     * @param lowSATMath low number in range of SAT math scores.
     * @param highSATMath high number in range of SAT math scores.
     */
    private static void searchWantedSATMath(Double lowSATMath, Double highSATMath) {
        if (lowSATMath != null && highSATMath != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getSATMath() <= highSATMath
                        && uni.getSATMath() >= lowSATMath) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        } else if (lowSATMath == null && highSATMath != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getSATMath() <= highSATMath) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        } else if (lowSATMath != null && highSATMath == null) {
            for (University uni : listBeforeMethod) {
                if (uni.getSATMath() >= lowSATMath) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
    }

    /**
     * Will search the name of the given expense against the list of schools in
     * the database.
     *
     * @param lowExpenses low number in range of expenses.
     * @param highExpenses high number in range of expenses.
     */
    private static void searchWantedExpenses(Double lowExpenses, Double highExpenses) {
        if (lowExpenses != null && highExpenses != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getExpenses() <= highExpenses
                        && uni.getExpenses() >= lowExpenses) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        } else if (lowExpenses == null && highExpenses != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getExpenses() <= highExpenses) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        } else if (lowExpenses != null && highExpenses == null) {
            for (University uni : listBeforeMethod) {
                if (uni.getExpenses() >= lowExpenses) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
    }

    /**
     * Will search the name of the given percent of financial aid against the
     * list of schools in the database.
     *
     * @param lowFinAid low number in range of financial aid.
     * @param highFinAid high number in range of financial aid.
     */
    private static void searchWantedPercentFinancialAid(Double lowFinAid, Double highFinAid) {
        if (lowFinAid != null && highFinAid != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getPercentFinancialAid() <= highFinAid
                        && uni.getPercentFinancialAid() >= lowFinAid) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        } else if (lowFinAid == null && highFinAid != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getPercentFinancialAid() <= highFinAid) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        } else if (lowFinAid != null && highFinAid == null) {
            for (University uni : listBeforeMethod) {
                if (uni.getPercentFinancialAid() >= lowFinAid) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
    }

    /**
     * Will search the name of the given number of applicants against the list
     * of schools in the database.
     *
     * @param lowNumApplicants low number in range of applicants.
     * @param highNumApplicants high number in range of applicants.
     */
    private static void searchWantedNumberOfApplicants(Integer lowNumApplicants, Integer highNumApplicants) {
        if (lowNumApplicants != null && highNumApplicants != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getNumberOfApplicants() <= highNumApplicants
                        && uni.getNumberOfApplicants() >= lowNumApplicants) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        } else if (lowNumApplicants == null && highNumApplicants != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getNumberOfApplicants() <= highNumApplicants) {
                    updatingList.add(uni);
                }
                updateTwoLists();
            }
        } else if (lowNumApplicants != null && highNumApplicants == null) {
            for (University uni : listBeforeMethod) {
                if (uni.getNumberOfApplicants() >= lowNumApplicants) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
    }

    /**
     * Will search the name of the given percent admitted against the list of
     * schools in the database.
     *
     * @param lowAdmitted low number in range of admitted students.
     * @param highAdmitted high number in range of admitted students.
     */
    private static void searchWantedPercentAdmitted(Double lowAdmitted, Double highAdmitted) {
        if (lowAdmitted != null && highAdmitted != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getPercentAdmitted() <= highAdmitted
                        && uni.getPercentAdmitted() >= lowAdmitted) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        } else if (lowAdmitted == null && highAdmitted != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getPercentAdmitted() <= highAdmitted) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        } else if (lowAdmitted != null && highAdmitted == null) {
            for (University uni : listBeforeMethod) {
                if (uni.getPercentAdmitted() >= lowAdmitted) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
    }

    /**
     * Will search the name of the given percent enrolled against the list of
     * schools in the database.
     *
     * @param lowEnrolled low number in range of enrolled students that were
     * admitted.
     * @param highEnrolled high number in range of enrolled students that were
     * admitted.
     */
    private static void searchWantedPercentEnrolled(Double lowEnrolled, Double highEnrolled) {
        if (lowEnrolled != null && highEnrolled != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getPercentEnrolled() <= highEnrolled
                        && uni.getPercentEnrolled() >= lowEnrolled) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        } else if (lowEnrolled == null && highEnrolled != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getPercentEnrolled() <= highEnrolled) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        } else if (lowEnrolled != null && highEnrolled == null) {
            for (University uni : listBeforeMethod) {
                if (uni.getPercentEnrolled() >= lowEnrolled) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
    }

    /**
     * Will search the name of the given academics score against the list of
     * schools in the database.
     *
     * @param lowAcademicScale low number in range of academics scale at this
     * school.
     * @param highAcademicScale high number in range of academics scale at this
     * school.
     */
    private static void searchWantedAcademicsScale(Integer lowAcademicScale, Integer highAcademicScale) {
        if (lowAcademicScale != null && highAcademicScale != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getAcademicsScale() <= highAcademicScale
                        && uni.getAcademicsScale() >= lowAcademicScale) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        } else if (lowAcademicScale == null && highAcademicScale != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getAcademicsScale() <= highAcademicScale) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        } else if (lowAcademicScale != null && highAcademicScale == null) {
            for (University uni : listBeforeMethod) {
                if (uni.getAcademicsScale() >= lowAcademicScale) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
    }

    /**
     * Will search the name of the given social score against the list of
     * schools in the database.
     *
     * @param lowSocialScale low number in range of social scale at this school.
     * @param highSocialScale high number in range of social scale at this
     * school.
     */
    private static void searchWantedSocialScale(Integer lowSocialScale, Integer highSocialScale) {
        if (lowSocialScale != null && highSocialScale != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getSocialScale() <= highSocialScale
                        && uni.getSocialScale() >= lowSocialScale) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        } else if (lowSocialScale == null && highSocialScale != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getSocialScale() <= highSocialScale) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        } else if (lowSocialScale != null && highSocialScale == null) {
            for (University uni : listBeforeMethod) {
                if (uni.getSocialScale() >= lowSocialScale) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
    }

    /**
     * Will search the name of the given quality of life score against the list
     * of schools in the database.
     *
     * @param lowQualityScale low number in range of quality of life scale at
     * this school.
     * @param highQualityScale high number in range of quality of life scale at
     * this school.
     */
    private static void searchWantedQualityOfLifeScale(Integer lowQualityScale, Integer highQualityScale) {
        if (lowQualityScale != null && highQualityScale != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getQualityOfLifeScale() <= highQualityScale
                        && uni.getQualityOfLifeScale() >= lowQualityScale) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        } else if (lowQualityScale == null && highQualityScale != null) {
            for (University uni : listBeforeMethod) {
                if (uni.getQualityOfLifeScale() <= highQualityScale) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        } else if (lowQualityScale != null && highQualityScale == null) {
            for (University uni : listBeforeMethod) {
                if (uni.getQualityOfLifeScale() >= lowQualityScale) {
                    updatingList.add(uni);
                }
            }
            updateTwoLists();
        }
    }

    /**
     * Will search through the given emphases, and compare them to all the
     * schools to find the schools with like emphases.
     *
     * @param emphases list of emphases to be compared schools against.
     */
    private static void searchWantedEmpheses(ArrayList<String> emphases) {
        if (!emphases.isEmpty()) {
            for (University uni : listBeforeMethod) {
                if (uni.getEmphases() != null) {
                            if (uni.getEmphases().containsAll(emphases)) {
                                updatingList.add(uni);
                        }
                }
            }
            updateTwoLists();
        }
    }

    /**
     * Used to run this class from the command line.
     *
     * @param args Arguments given to the class from stdin.
     */
    public static void main(String args[]) {
        System.out.println("***Here is Use Case #3: Search***");
        System.out.println("***Here is Use Case #7: View Results***");
        String wantedSchool = null;
        String wantedState = "TEXAS";
        String wantedLocation = "-1";
        String wantedControl = "-1";
        Integer lowWantedNumber = null;
        Integer highWantedNumber = null;
        Double lowPercentFemales = null;
        Double highPercentFemales = null;
        Double lowSATVerbal = null;
        Double highSATVerbal = null;
        Double lowSATMath = null;
        Double highSATMath = null;
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
        System.out.println("~This search gets all schools within the state of Texas~");
        System.out.println(testArray);
        
        //re-establish the correct ArrayLists        
        updatingList = new ArrayList<University>();
        listBeforeMethod = DatabaseController.getAllUniversities();
        wantedState = null;
        lowPercentFemales = 70.0;
        highPercentFemales = 80.0;
        testArray = search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                highQualityScale, empList);
        System.out.println("\n~This search gets all schools with a Percent Female attribute of 70%-80%~");
        System.out.println(testArray);
               
        
    }
}
