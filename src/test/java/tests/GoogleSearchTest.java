package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
/*
    Create a new class : GoogleSearchTest
    Create main method and complete the following task.
    When user goes to https://www.google.com/
    Search for “porcelain teapot”
    And print how many related results displayed on Google
    */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com/");
        
        WebElement searchTeapot=driver.findElement(By.xpath("//input[@class='gLFyf']"));
                searchTeapot.sendKeys("porcelain teapot");
                searchTeapot.sendKeys(Keys.ENTER);

        String numOfResult= driver.findElement(By.id("result-stats")).getText();

        System.out.println("numOfResult = " + numOfResult);

     }

}
