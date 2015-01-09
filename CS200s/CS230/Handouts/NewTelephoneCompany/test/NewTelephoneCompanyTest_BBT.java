/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.*;

/**
 *
 * @author irahal
 */
public class NewTelephoneCompanyTest_BBT extends TestCase {
    
    private NewTelephoneCompany ntc;
    
    @Override
    protected void setUp() throws Exception {
        ntc = new NewTelephoneCompany();
    }
    

    /**
     * Test of getHours method, of class NewTelephoneCompany.
     */
    public void testGetHours() {
        System.out.println("getHours");
        int expResult = 0;
        int result = ntc.getHours();
        assertEquals("Hours is " + expResult,expResult, result);
    }

    /**
     * Test of setHours method, of class NewTelephoneCompany.
     */
    public void testSetHours() {
        System.out.println("setHours");
        int expResult = 40;
        ntc.setHours(expResult);
        int result = ntc.getHours();
        assertEquals("Hours is now " + expResult,expResult, result);
    }

    /**
     * Test of getLength method, of class NewTelephoneCompany.
     */
    public void testGetLength() {
        System.out.println("getLength");
        int expResult = 0;
        int result = ntc.getLength();
        assertEquals("Length is" + expResult,expResult, result);
    }

    /**
     * Test of setLength method, of class NewTelephoneCompany.
     */
    public void testSetLength() {
        System.out.println("setLength");
        int expResult = 40;
        ntc.setLength(expResult);
        int result = ntc.getLength();
        assertEquals("Length is now " + expResult,expResult, result);
    }

    /**
     * Test of computeCharge method, of class NewTelephoneCompany.
     */
    public void testComputeCharge() throws Exception {
        System.out.println("computeCharge");
        
        //these work fine
        int[] validInputHours = {400, 0,  700 ,  1800,  1801, 800 ,  801 ,  1759, 400};
        int[] validLength ={40 , 1,  59  ,  60  ,  0   , 65  ,  61  ,  40  , 65};
        double[] expResults = {800, 20, 1180,  1200,  0   , 2210,  2074,  1600, 1105};
       
        //these produce Exception -- Invalid hours
        int[] invalidInputHours_1 =  {-5, -1, 2400, 2401};
        int[] invalidInputLength_1 = {-5, -1, 65  , 61};
        
        //these produce Exception -- Invalid length
        int[] invalidInputHours_2 = {2359, 1000};
        int[] invalidInputLength_2 = {-5, -1};        
        
        System.out.println("--- using optimistic combinations");
        
        for(int i=0;i<validInputHours.length;i++){
            ntc.setHours(validInputHours[i]);
            ntc.setLength(validLength[i]);
            double result = ntc.computeCharge();
            assertEquals("Charge is " + expResults[i], expResults[i], result);
        }
        
        for(int i=0;i<invalidInputHours_1.length;i++){
            ntc.setHours(invalidInputHours_1 [i]);
            ntc.setLength(invalidInputLength_1[i]);
            try{
                double result = ntc.computeCharge();
                fail("THE CALL SHOULD PRODUCE AN EXCEPTION FOR INVALID HOURS");
            }
            catch(Exception e){
                if(!e.getMessage().equals("Invalid HOURS"))
                    fail("THE CALL SHOULD PRODUCE AN EXCEPTION FOR INVALID HOURS");
            }
        }
        
        for(int i=0;i<invalidInputHours_2.length;i++){
            ntc.setHours(invalidInputHours_2 [i]);
            ntc.setLength(invalidInputLength_2[i]);
            try{
                ntc.computeCharge();
                fail("THE CALL SHOULD PRODUCE AN EXCEPTION FOR INVALID LENGTH");
            }
            catch(Exception e){
                if(!e.getMessage().equals("Invalid LENGTH"))
                    fail("THE CALL SHOULD PRODUCE AN EXCEPTION FOR INVALID LENGTH");
            }
        }        
        
    }

}
