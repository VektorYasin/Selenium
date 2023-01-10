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

import static org.junit.Assert.assertTrue;

public class Day03_Locators {
    WebDriver driver;
    @Before
    public void setUp(){
        //user goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }
    @Test
    public void logInTest(){
        /*
        User goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        Locate the elements of Username textbox, Password textbox, and Login button
        Enter below username and password then click on login button
                Username :  Admin
                Password :  admin123
        Assert the login is successful
        Sign out from the page
        */

        //locating the username and typing password
        WebElement username= driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        WebElement loginButton= driver.findElement(By.tagName("button"));
        loginButton.click();

        //Assert login is successful
        //https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index
        boolean actualValue= driver.getCurrentUrl().contains("dashboard");

        assertTrue(actualValue);

    }
        @After
        public void tearDown() {
            driver.quit();
        }

}
