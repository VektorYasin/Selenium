package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day14_StaleElementException extends TestBase {
    @Test
    public void timeOutExceptionTest(){
        driver.get("https://techproeducation.com/");

        WebElement LMS = driver.findElement(By.linkText("LMS LOGIN"));
        System.out.println(LMS.getText());
        driver.navigate().refresh();
        System.out.println(LMS.getText());//org.openqa.selenium.StaleElementReferenceException

        //Note: After the refresh we need to relocate the element: driver.findElement(By.linkText("LMS LOGIN"));

    }
}
