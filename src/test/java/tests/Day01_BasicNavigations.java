package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.sql.Driver;

public class Day01_BasicNavigations {

    public static void main(String[] args) {
        //1.set up
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        //2.create chrome driver
        WebDriver driver = new ChromeDriver();

        //3.write Test scripts
        //maximize the window
        driver.manage().window().maximize();

        /*Steps:
        Maximize the window
        Open google home page https://www.walmart.com/.
        On the same class, Navigate to amazon home page https://www.amazon.com/
        Navigate back to google
        Navigate forward to amazon
        Refresh the page
        Close/Quit the browser
        }
         */

        driver.get("https://www.walmart.com/");
        //1.way
        //driver.get("https://www.amazon.com/");
        //2nd way:
        driver.navigate().to("https://www.amazon.com/");

        //navigate back to walmart
        driver.navigate().back();

        //navigate forward to amazon
        driver.navigate().forward();

        //refresh the page
        driver.navigate().refresh();

        driver.quit();// stronger than close
        //close only the last active window
        //quit closes all the windows
        //abayram.techproed@gmail.com

    }
}
