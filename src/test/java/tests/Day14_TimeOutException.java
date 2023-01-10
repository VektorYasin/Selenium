package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day14_TimeOutException extends TestBase {

    @Test
    public void timeOutExceptionTest(){

        driver.get("https://techproeducation.com/");

        //org.openqa.selenium.TimeoutException
        waitForVisibility(By.xpath("//123"),3);
        //If it can not find the element in 3 secs,...

    }
}
