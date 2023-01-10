package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day14_NoSuchElementException extends TestBase {

    @Test
    public void noSuchElementException(){

        driver.get("https://www.techproeducation.com/");

        //wrong id locator
        driver.findElement(By.id("wrong-id")).click();
        //org.openqa.selenium.NoSuchElementException: no such element:
        // Unable to locate element: {"method":"css selector","selector":"#wrong\-id"}

    }
}
