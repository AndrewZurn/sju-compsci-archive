package csci230radomskizurnhardy;

import java.util.ArrayList;

/**
 * This class creates an object of type University complete with all attributes
 * and the ability to set and get the University's Emphases
 *
 * @author Andrew Zurn, Wiley Radomski, Preston Hardy
 * @version 1.1
 */
public class University {

    /**
     * The name of the school.
     */
    private String school;
    /**
     * The state the school is in.
     */
    private String state;
    /**
     * The location that the school is in.
     */
    private String location;
    /**
     * The control of the university, public/state or private.
     */
    private String control;
    /**
     * The number of students currently attending the school.
     */
    private int numberOfStudents;
    /**
     * The percentage of students that are female.
     */
    private double percentFemales;
    /**
     * The average SAT verbal score of those attending the school.
     */
    private double SATVerbal;
    /**
     * The average SAT math score of those attending the school.
     */
    private double SATMath;
    /**
     * The cost/expense of the school.
     */
    private double expenses;
    /**
     * The amount of students receiving financial aid.
     */
    private double percentFinancialAid;
    /**
     * The number of applicants that apply to this school.
     */
    private int numberOfApplicants;
    /**
     * The percent of those applicants that are admitted.
     */
    private double percentAdmitted;
    /**
     * The percent of those students admitted that go on to enroll.
     */
    private double percentEnrolled;
    /**
     * The academic standing of the school, scale 1-5.
     */
    private int academicsScale;
    /**
     * The social standing of the school, scale 1-5.
     */
    private int socialScale;
    /**
     * The quality of life score of the school, scale 1-5.
     */
    private int qualityOfLifeScale;
    /**
     * The emphases this school is known for.
     */
    private ArrayList<String> emphases;

    /**
     * Constructor for University
     *
     * @param school The name of the University
     * @param state The state where the University is located
     * @param location What setting the university is in urban, rural,
     * metropolitan
     * @param control Whether or not the school is public or private
     * @param numberOfStudents Number of students attending the University
     * @param percentFemales Percent of student body which is female
     * @param SATVerbal Average SATVerbal score
     * @param SATMath Average SATMath score
     * @param expenses Cost of attending the University
     * @param percentFinancialAid Percent of students which receive financial
     * aid
     * @param numberOfApplicants Number of Applicants
     * @param percentAdmitted Percent of potential students admitted
     * @param percentEnrolled Percent of potential students enrolled
     * @param academicsScale Scale from 1-5 of the academics
     * @param socialScale Scale from 1-5 of the social structure
     * @param qualityOfLifeScale Scale from 1-5 of the quality of life
     */
    public University(String school, String state, String location,
            String control, int numberOfStudents, double percentFemales,
            double SATVerbal, double SATMath, double expenses,
            double percentFinancialAid, int numberOfApplicants,
            double percentAdmitted, double percentEnrolled, int academicsScale,
            int socialScale, int qualityOfLifeScale) {
        this.school = school;
        this.state = state;
        this.location = location;
        this.control = control;
        this.numberOfStudents = numberOfStudents;
        this.percentFemales = percentFemales;
        this.SATVerbal = SATVerbal;
        this.SATMath = SATMath;
        this.expenses = expenses;
        this.percentFinancialAid = percentFinancialAid;
        this.numberOfApplicants = numberOfApplicants;
        this.percentAdmitted = percentAdmitted;
        this.percentEnrolled = percentEnrolled;
        this.academicsScale = academicsScale;
        this.socialScale = socialScale;
        this.qualityOfLifeScale = qualityOfLifeScale;
    }

    /**
     * Will return the name of the school.
     *
     * @return the school
     */
    public String getSchool() {
        return school;
    }

    /**
     * Will set the name of the school.
     *
     * @param school the school to set
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * Will return the state of the school.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Will set the state of the school.
     *
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Will return the location of the school.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Will set the location of the school.
     *
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Will return the control of the school.
     *
     * @return the control
     */
    public String getControl() {
        return control;
    }

    /**
     * Will set the control of the school.
     *
     * @param control the control to set
     */
    public void setControl(String control) {
        this.control = control;
    }

    /**
     * Will return the number of students at the school.
     *
     * @return the numberOfStudents
     */
    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    /**
     * Will set the number of students at the school.
     *
     * @param numberOfStudents the numberOfStudents to set
     */
    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    /**
     * Will return the percentage of females at the school.
     *
     * @return the percentFemales
     */
    public double getPercentFemales() {
        return percentFemales;
    }

    /**
     * Will set the percentage of females at the school
     *
     * @param percentFemales the percentFemales to set
     */
    public void setPercentFemales(double percentFemales) {
        this.percentFemales = percentFemales;
    }

    /**
     * Will return the SAT verbal score of the school.
     *
     * @return the SATVerbal
     */
    public double getSATVerbal() {
        return SATVerbal;
    }

    /**
     * Will set the SAT verbal score of the school.
     *
     * @param SATVerbal the SATVerbal to set
     */
    public void setSATVerbal(double SATVerbal) {
        this.SATVerbal = SATVerbal;
    }

    /**
     * Will return the SAT math score of the school.
     *
     * @return the SATMath
     */
    public double getSATMath() {
        return SATMath;
    }

    /**
     * Will set the SAT math score of the school.
     *
     * @param SATMath the SATMath to set
     */
    public void setSATMath(double SATMath) {
        this.SATMath = SATMath;
    }

    /**
     * Will return the expenses of the school.
     *
     * @return the expenses
     */
    public double getExpenses() {
        return expenses;
    }

    /**
     * Will set the expenses of the school.
     *
     * @param expenses the expenses to set
     */
    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    /**
     * Will return the percent of financial aid of the school.
     *
     * @return the percentFinancialAid
     */
    public double getPercentFinancialAid() {
        return percentFinancialAid;
    }

    /**
     * Will set the percent of financial aid of the school.
     *
     * @param percentFinancialAid the percentFinancialAid to set
     */
    public void setPercentFinancialAid(double percentFinancialAid) {
        this.percentFinancialAid = percentFinancialAid;
    }

    /**
     * Will return the number of applicants to the school.
     *
     * @return the numberOfApplicants
     */
    public int getNumberOfApplicants() {
        return numberOfApplicants;
    }

    /**
     * Will set the number of applicants to the school.
     *
     * @param numberOfApplicants the numberOfApplicants to set
     */
    public void setNumberOfApplicants(int numberOfApplicants) {
        this.numberOfApplicants = numberOfApplicants;
    }

    /**
     * Will return the percent admitted to the school.
     *
     * @return the percentAdmitted
     */
    public double getPercentAdmitted() {
        return percentAdmitted;
    }

    /**
     * Will set the percent admitted to the school.
     *
     * @param percentAdmitted the percentAdmitted to set
     */
    public void setPercentAdmitted(double percentAdmitted) {
        this.percentAdmitted = percentAdmitted;
    }

    /**
     * Will return the percent enrolled at the school.
     *
     * @return the percentEnrolled
     */
    public double getPercentEnrolled() {
        return percentEnrolled;
    }

    /**
     * Will set the percent enrolled at the school.
     *
     * @param percentEnrolled the percentEnrolled to set
     */
    public void setPercentEnrolled(double percentEnrolled) {
        this.percentEnrolled = percentEnrolled;
    }

    /**
     * Will return the academic score at the school.
     *
     * @return the academicsScale
     */
    public int getAcademicsScale() {
        return academicsScale;
    }

    /**
     * Will set the academic score at the school.
     *
     * @param academicsScale the academicsScale to set
     */
    public void setAcademicsScale(int academicsScale) {
        this.academicsScale = academicsScale;
    }

    /**
     * Will return the social score at the school.
     *
     * @return the socialScale
     */
    public int getSocialScale() {
        return socialScale;
    }

    /**
     * Will set the social score at the school.
     *
     * @param socialScale the socialScale to set
     */
    public void setSocialScale(int socialScale) {
        this.socialScale = socialScale;
    }

    /**
     * Will return the quality of life score at the school.
     *
     * @return the qualityOfLifeScale
     */
    public int getQualityOfLifeScale() {
        return qualityOfLifeScale;
    }

    /**
     * Will set the quality of life score at the school.
     *
     * @param qualityOfLifeScale the qualityOfLifeScale to set
     */
    public void setQualityOfLifeScale(int qualityOfLifeScale) {
        this.qualityOfLifeScale = qualityOfLifeScale;
    }

    /**
     * Will return the emphases that are relevant to the school.
     *
     * @return the emphases
     */
    public ArrayList<String> getEmphases() {
        return emphases;
    }

    /**
     * Will set the emphases that are relevant to the school.
     *
     * @param emphases the emphases to set
     */
    public void setEmphases(ArrayList<String> emphases) {
        this.emphases = emphases;
    }

    /**
     * Will add a single emphases to this school.
     *
     * @param singleEmphases
     */
    public void addEmphases(String singleEmphases) {
        this.emphases.add(singleEmphases);
    }

    /**
     * Will return the current values associated with University.
     *
     * @return the values to be return
     */
    @Override
    public String toString() {
        return ("\n-University-\nSchool: " + school + ", State: "
                + state + ", Location: " + location + ", Control: "
                + control + ", NumberOfStudents: " + numberOfStudents + ", PercentFemales: "
                + percentFemales + ", SATVerbal: " + SATVerbal + ", SATMath: "
                + SATMath + ", expenses: " + expenses + ", PercentFinancialAid: "
                + percentFinancialAid + ", NumberOfApplicants: " + numberOfApplicants
                + ", PercentAdmitted: " + percentAdmitted + ", PercentEnrolled:"
                + percentEnrolled + ", AcademicsScale: " + academicsScale + ", SocialScale:"
                + socialScale + ", QualityOfLifeScale:" + qualityOfLifeScale + ", Emphases: " + emphases);
    }

    public static void main(String args[]) {
        University uni = new University("Zurn University", "Zurn State", "URBAN", "PRIVATE", 
                5000, 65.5, 800, 800, 25000, 85.9, 2000, 50.0, 25.0, 5, 5, 5);
        System.out.println(uni);
        System.out.println("~We now set all of the University's attributes, get them and print them out");
        uni.setSchool("NewSchoolName");
        System.out.println("The new School Name for uni is: " + uni.getSchool());
        uni.setState("NewState");
        System.out.println("The new School State for uni is: " + uni.getState());
        uni.setLocation("NewLocation");
        System.out.println("The new Location for uni is: " + uni.getLocation());
        uni.setControl("NewControl");
        System.out.println("The new Control for uni is: " + uni.getControl());
        uni.setNumberOfStudents(10000);
        System.out.println("The new number of Students for uni is: " + uni.getNumberOfStudents());
        uni.setPercentFemales(85);
        System.out.println("The new percent females for uni is: " + uni.getPercentFemales());
        uni.setSATVerbal(400);
        System.out.println("The new SATVerbal for uni is: " + uni.getSATVerbal());
        uni.setSATMath(600);
        System.out.println("The new SATMath for uni is: " + uni.getSATMath());
        uni.setExpenses(50000);
        System.out.println("The new Expenses for uni is: " + uni.getExpenses());
        uni.setPercentFinancialAid(93);
        System.out.println("The new percent financial aid for uni is: " + uni.getPercentFinancialAid());
        uni.setNumberOfApplicants(2500);
        System.out.println("The new number of applicants for uni is: " + uni.getNumberOfApplicants());
        uni.setPercentAdmitted(75);
        System.out.println("The new percent admitted for uni is: " + uni.getPercentAdmitted());
        uni.setPercentEnrolled(10);
        System.out.println("The new percent enrolled for uni is: " + uni.getPercentEnrolled());
        uni.setAcademicsScale(4);
        System.out.println("The new academic scale for uni is: " + uni.getAcademicsScale());
        uni.setSocialScale(4);
        System.out.println("The new social scale for uni is: " + uni.getSocialScale());
        uni.setQualityOfLifeScale(4);
        System.out.println("The new quality of life for uni is: " + uni.getQualityOfLifeScale());
        ArrayList<String> emphases1 = new ArrayList<String>();
        emphases1.add("LIBERAL-ARTS");
        uni.setEmphases(emphases1);
        System.out.println("The new emphases for uni is" +uni.getEmphases());
    }
}
