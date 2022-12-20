package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
    /*
    getPageSource() returns page source code as a string
    We might use this to verify if a certain text exist in the entire page
    Note that pageSource is not used a lot to do assertions
    Because it is too general and can lead false result
    TEST CASE:
            Test if amazon contains “Registry” on the homepage
            Create a new class : GetPageSource
     */

public class Day02_TitleVerification {
    public static void main(String[] args) {
        //1.set up
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        //2.create chrome driver
        WebDriver driver = new ChromeDriver();

        //3.write Test scripts
        //maximize the window
        driver.manage().window().maximize();

        driver.get("https://www.techproeducation.com");

        //get title
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";

        //Verify if page title is “Techpro Education | Online It Courses & Bootcamps”

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("ACTUAL TITLE: " + actualTitle);
            System.out.println("BUT EXPECTED TITLE: " + expectedTitle);
        }
        driver.quit();
    }//main
}//class
