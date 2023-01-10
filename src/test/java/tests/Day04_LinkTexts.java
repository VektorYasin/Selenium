package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.*;

public class Day04_LinkTexts {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(15)));
        driver.manage().window().maximize();
    }

    @Test
    public void LMSPage(){
        driver.get("https://www.techproeducation.com/");
        //click on LMS LOGIN
        //LMS lOGIN IS A LINK
        //TEXT OF THAT LINK IS "LMS LOGIN"
        driver.findElement(By.linkText("LMS LOGIN")).click();

        //verify LMS page is visible
        String expectedURL="https://lms.techproeducation.com/";
        String actualURL= driver.getCurrentUrl();
        assertEquals("LMS LOGIN PAGE IS NOT DISPLAYED", expectedURL,actualURL);
        //message only will be visible if test case fails
    }
    /*
    LinkText and PartialLinkText are case-sensitive.
     */
    @Test
    public void LMSPagePartialLinkText(){
        driver.get("https://www.techproeducation.com/");
        driver.findElement(By.partialLinkText("LMS LO")).click();

        //Alternatively we can locate a core element on lms login page and check that element is displayed
        String expectedURL="https://lms.techproeducation.com/";
        String actualURL= driver.getCurrentUrl();
        assertEquals("LMS LOGIN PAGE IS NOT DISPLAYED", expectedURL,actualURL);

        WebElement loginElement= driver.findElement(By.linkText("Login/Register"));
        assertTrue(loginElement.isDisplayed());

        //isDisplayed() returns TRUE if that element is on the page

        //returns false if element is not displayed on the page

        //assertTrue(driver.findElement(By.linkText("Login/Register")).isDisplayed());

    }
    @After
    public void tearDown(){
        driver.quit();

    }
}
