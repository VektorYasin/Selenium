package tests;

import org.junit.Assert;
import org.junit.Test;

public class Day03_Asertions {
    @Test
    public void assertions(){
       /*
    assertion is done to check if expected result is equal to actual result
    -expected==actual --pass
    -expected!=actual --fail

    assertEquals("expected", "actual");
    assertTrue(true);--pass
    assertTrue(false);--fail
    assertFalse(false);--pass
    assertFalse(true);--fail
     */
    Assert.assertEquals(1, 5);//FAIl (execution stops here, because of hard assertion

        //verification
        if("java".contains("apple")) {
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");

        }


    Assert.assertEquals("java", "Java");
    Assert.assertEquals("java".contains("j"), true);
                            //true              //true ---pass
    Assert.assertTrue("java".contains("j"));//true pass
    Assert.assertFalse(("Java".contains("j")));//true  pass

    //what is the difference between "test assertion" and "test verification"?
    //Test execution stops if one of the assertion fails. This is hard assertion
    //test execution continues even if test verification fails.
    //verification is like "IF STATEMENT".
    //assertion stops after assertion fails. Verification continues even after fails.
    //Jnuit assertions are hard assertion.
    //If statement is verification.
    //TestNG has soft assertion as well.
    //hard assertion is mostly used in market. ıt is preffered.
    //to fix the issue, use hard assertion.
    //Hard assertion: If the execution stops in failure, it is called as hard assertion
    //verification: if the execution continues, it is called as verification.

    }







}
