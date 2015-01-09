/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author irahal
 */
public class NewTelephoneCompanyTestSuite extends TestCase {
    

    
    public static Test suite() {
        TestSuite suite = new TestSuite("NewTelephoneCompanyTestSuite");
        suite.addTestSuite(NewTelephoneCompanyTest_BBT.class);
        suite.addTestSuite(NewTelephoneCompanyTest_WBT.class);
        return suite;
    }
}
