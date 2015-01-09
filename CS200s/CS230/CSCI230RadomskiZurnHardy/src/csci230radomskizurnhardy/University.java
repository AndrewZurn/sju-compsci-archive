package csci230radomskizurnhardy;

import java.util.ArrayList;

/**
 * This class creates an object of type University complete with all attributes
 * and the ability to set and get the University's Emphases
 * @author pghardy
 * @version 1.1
 */
public class University {
    private String school;
    private String state;
    private String location;
    private String control;
    private int numberOfStudents;
    private double percentFemales;
    private double SATVerbal;
    private double SATMath;
    private double expenses;
    private double percentFinancialAid;
    private int numberOfApplicants;
    private double percentAdmitted;
    private double percentEnrolled;
    private int academicsScale;
    private int socialScale;
    private int qualityOfLifeScale;
    private ArrayList<String> emphases;
    
    /**
     * 
     * @param school
     * @param state
     * @param location
     * @param control
     * @param numberOfStudents
     * @param percentFemales
     * @param SATVerbal
     * @param SATMath
     * @param expenses
     * @param percentFinancialAid
     * @param numberOfApplicants
     * @param percentAdmitted
     * @param percentEnrolled
     * @param academicsScale
     * @param socialScale
     * @param qualityOfLifeScale
     */
    public University(String school, String state, String location, 
            String control, int numberOfStudents, double percentFemales, 
            double SATVerbal, double SATMath, double expenses, 
            double percentFinancialAid, int numberOfApplicants, 
            double percentAdmitted, double percentEnrolled, int academicsScale, 
            int socialScale, int qualityOfLifeScale){
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
     * @return the school
     */
    public String getSchool() {
        return school;
    }

    /**
     * @param school the school to set
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the control
     */
    public String getControl() {
        return control;
    }

    /**
     * @param control the control to set
     */
    public void setControl(String control) {
        this.control = control;
    }

    /**
     * @return the numberOfStudents
     */
    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    /**
     * @param numberOfStudents the numberOfStudents to set
     */
    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    /**
     * @return the percentFemales
     */
    public double getPercentFemales() {
        return percentFemales;
    }

    /**
     * @param percentFemales the percentFemales to set
     */
    public void setPercentFemales(double percentFemales) {
        this.percentFemales = percentFemales;
    }

    /**
     * @return the SATVerbal
     */
    public double getSATVerbal() {
        return SATVerbal;
    }

    /**
     * @param SATVerbal the SATVerbal to set
     */
    public void setSATVerbal(double SATVerbal) {
        this.SATVerbal = SATVerbal;
    }

    /**
     * @return the SATMath
     */
    public double getSATMath() {
        return SATMath;
    }

    /**
     * @param SATMath the SATMath to set
     */
    public void setSATMath(double SATMath) {
        this.SATMath = SATMath;
    }

    /**
     * @return the expenses
     */
    public double getExpenses() {
        return expenses;
    }

    /**
     * @param expenses the expenses to set
     */
    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    /**
     * @return the percentFinancialAid
     */
    public double getPercentFinancialAid() {
        return percentFinancialAid;
    }

    /**
     * @param percentFinancialAid the percentFinancialAid to set
     */
    public void setPercentFinancialAid(double percentFinancialAid) {
        this.percentFinancialAid = percentFinancialAid;
    }

    /**
     * @return the numberOfApplicants
     */
    public int getNumberOfApplicants() {
        return numberOfApplicants;
    }

    /**
     * @param numberOfApplicants the numberOfApplicants to set
     */
    public void setNumberOfApplicants(int numberOfApplicants) {
        this.numberOfApplicants = numberOfApplicants;
    }

    /**
     * @return the percentAdmitted
     */
    public double getPercentAdmitted() {
        return percentAdmitted;
    }

    /**
     * @param percentAdmitted the percentAdmitted to set
     */
    public void setPercentAdmitted(double percentAdmitted) {
        this.percentAdmitted = percentAdmitted;
    }

    /**
     * @return the percentEnrolled
     */
    public double getPercentEnrolled() {
        return percentEnrolled;
    }

    /**
     * @param percentEnrolled the percentEnrolled to set
     */
    public void setPercentEnrolled(double percentEnrolled) {
        this.percentEnrolled = percentEnrolled;
    }

    /**
     * @return the academicsScale
     */
    public int getAcademicsScale() {
        return academicsScale;
    }

    /**
     * @param academicsScale the academicsScale to set
     */
    public void setAcademicsScale(int academicsScale) {
        this.academicsScale = academicsScale;
    }

    /**
     * @return the socialScale
     */
    public int getSocialScale() {
        return socialScale;
    }

    /**
     * @param socialScale the socialScale to set
     */
    public void setSocialScale(int socialScale) {
        this.socialScale = socialScale;
    }

    /**
     * @return the qualityOfLifeScale
     */
    public int getQualityOfLifeScale() {
        return qualityOfLifeScale;
    }

    /**
     * @param qualityOfLifeScale the qualityOfLifeScale to set
     */
    public void setQualityOfLifeScale(int qualityOfLifeScale) {
        this.qualityOfLifeScale = qualityOfLifeScale;
    }

    /**
     * @return the emphases
     */
    public ArrayList<String> getEmphases() {
        return emphases;
    }

    /**
     * @param emphases the emphases to set
     */
    public void setEmphases(ArrayList<String> emphases) {
        this.emphases = emphases;
    }
    
    /**
     * 
     * @param singleEmphases
     */
    public void addEmphases(String singleEmphases) {
        this.emphases.add(singleEmphases);
    }

    @Override
    public String toString() {
        return "University{" + "school=" + school + ", state=" + state + ", location=" + location + ", control=" + control + ", numberOfStudents=" + numberOfStudents + ", percentFemales=" + percentFemales + ", SATVerbal=" + SATVerbal + ", SATMath=" + SATMath + ", expenses=" + expenses + ", percentFinancialAid=" + percentFinancialAid + ", numberOfApplicants=" + numberOfApplicants + ", percentAdmitted=" + percentAdmitted + ", percentEnrolled=" + percentEnrolled + ", academicsScale=" + academicsScale + ", socialScale=" + socialScale + ", qualityOfLifeScale=" + qualityOfLifeScale + ", emphases=" + emphases + '}';
    }
    
    
}
