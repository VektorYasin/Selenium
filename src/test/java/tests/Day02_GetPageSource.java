package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
    /*
    //getPageSource() returns page source code as a string
    //We might use this to verify if a certain text exist in the entire page
    //Note that pageSource is not used a lot to do assertions
    //Because it is too general and can lead false result
    TEST CASE:
    Test if amazon contains “Registry” on the homepage
    Create a new class : GetPageSource
     */
public class Day02_GetPageSource {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");
        String pageSource=driver.getPageSource();

        String expectedWord="Registry";

        if(pageSource.contains(expectedWord)) {
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("PAGE SOURCE: "+ pageSource);
            System.out.println("EXPECTED WORD: "+ pageSource);
        }
        driver.quit();
    }

}
