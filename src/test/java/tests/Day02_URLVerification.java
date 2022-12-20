package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_URLVerification {
    public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();

    driver.get("https://www.techproeducation.com");

    //Verify if homepage url is “https://www.techproeducation.com”
    String actualURL= driver.getCurrentUrl();

    String expectedURL="https://techproeducation.com/";

    if (actualURL.equals(expectedURL)) {
        System.out.println("PASS");
    } else {
        System.out.println("FAIL");
        System.out.println("ACTUAL URL: " + actualURL);
        System.out.println("BUT EXPECTED URL: " + actualURL);
    }
    driver.quit();

/*
what s your approach for automation?
-I read acceptance criteria carefully
-I then create my test cases
-then I do manual testing First
-if all good, then I start automation testing.
-if I find a bug/defect, then I talk to dev, dev fixes issue and I retest
- when the automation is completed, I prepare report for  the user story,my automation script generates html report for us.
  I upload the reports to Jira.
- for manual test cases, I manually take screenshots, prepare reports and attach them to Jira
  what do you do when your test case pass?

 */

  }//main
}//class

