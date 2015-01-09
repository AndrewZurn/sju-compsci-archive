/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.TestCase;

/**
 *
 * @author irahal
 */
public class NewTelephoneCompanyTest_WBT extends TestCase {
   
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
        int[] validInputHours = {400, 100,  1000 , 1000};
        int[] validLength =     {100,10,100,10};
        double[] expResults =   {1700,200,3400,400};
       
        
        double result;
        for(int i=0;i<validInputHours.length;i++){
            ntc.setHours(validInputHours[i]);
            ntc.setLength(validLength[i]);
            result = ntc.computeCharge();
            assertEquals("Charge is " + expResults[i], expResults[i], result);
        }
        
        ntc.setHours(-5);
        ntc.setLength(5);
        try{
            result = ntc.computeCharge();
            fail("THE CALL SHOULD PRODUCE AN EXCEPTION FOR INVALID HOURS");
        }
        catch(Exception e){
            if(!e.getMessage().equals("Invalid HOURS"))
                fail("THE CALL SHOULD PRODUCE AN EXCEPTION FOR INVALID HOURS");
        }

        ntc.setHours(10);
        ntc.setLength(-5);
        try{
            result = ntc.computeCharge();
            fail("THE CALL SHOULD PRODUCE AN EXCEPTION FOR INVALID LENGTH");
        }
        catch(Exception e){
            if(!e.getMessage().equals("Invalid LENGTH"))
                fail("THE CALL SHOULD PRODUCE AN EXCEPTION FOR INVALID LENGTH");
        }
    }
}
