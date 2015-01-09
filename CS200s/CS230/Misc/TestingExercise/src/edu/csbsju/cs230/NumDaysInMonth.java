/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.csbsju.cs230;

/**
 *
 * @author irahl
 * Create a test class to test the following Java class. 
 * 1- Include in your class an instance of type NumDaysInMonth
 * 2- In method setUp(), initialize instance your instance to be = new NumDaysInMonth();
 * 3- Complete the test methods for getNumDaysInMonth & isLeapYear based on the 
 *    test cases shown below (included in comments before the methods)
 * 4- After all your test pass successfully, create a test suite that runs your 
 *    test class twice by calling suite.addTestSuite(NAME_OF_TEST_CLASS.class);
 *    twice
 * 5- HAVE FUN! LOTS OF IT!!!
 * 
 */

public class NumDaysInMonth {

        /* Test the following cases (same derived in class using WBT):
         * Year = 0   , month = 1   ==> throw exception 1
         * Year = 1901, month = 1   ==> return 31
         * Year = 1901, month = 4   ==> return 30
         * Year = 1901, month = 2   ==> return 29
         * Year = 1904, month = 2   ==> return 28
         * Year = 1901, month = 0   ==> throw exception 1
         */

        public int getNumDaysInMonth(int month, int year) throws Exception{
            int numDays;
            if (year < 1) {
                    throw new Exception ("Year Out Of Bounds");
            }
            if (month == 1 || month == 3 || month == 5 || month == 7 ||month == 10 || month == 12) {
                numDays = 31;
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                numDays = 30;
            } else if (month == 2) {
                if (isLeapYear(year)) {
                    numDays = 29;
                } else {
                    numDays = 28;
                }
            } else {
                throw new  Exception ("Month Out Of Bounds");
            }
            return numDays;
        }

        /* Test the following cases (same derived in class using WBT):
         * Year = 400   ==> return true
         * Year = 100 ==> return false
         * Year = 4 ==> return true
         * Year = 1 ==> return false
         */
        public boolean isLeapYear(int year) {
            boolean leap;
            if (year%400==0) {
                leap = true;
            } 
            else if (year%100==0) {
                leap = false;
            } 
            else if(year%4==0){
                leap = true;
            } 
            else{
                leap = false;
            }
            return leap;
 }
}
