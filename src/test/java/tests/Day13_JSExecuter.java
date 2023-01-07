package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day13_JSExecuter extends TestBase {

     /*
    Given
        Go to https://techproeducation.com/"
    When
        Scroll into "WE OFFER"
    And
        Scroll into "LMS LOGIN"
    And
        Scroll into "WHY US"
    And
        Scroll back up to "Enroll Free"
    And
        Scroll all the way down
    And
        Scroll all the way up
    Then
        Take a screenshot of each step
     */

    @Test
    public void scrollIntoViewTest() {
//        Go to https://techproeducation.com/
        driver.get("https://techproeducation.com/");
        takeScreenshotOfPage();
        //Thread.sleep(3000);
        waitFor(3);

//        Scroll into "WE OFFER"
        WebElement weOffer = driver.findElement(By.xpath("//*[.='we offer']"));
        //Create JS Executer object
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", weOffer);
        takeScreenshotOfPage();

//        Scroll into "LMS LOGIN"
        waitFor(2);
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.linkText("LMS LOGIN")));
        takeScreenshotOfPage();

//        Scroll into "WHY US"
        waitFor(2);
        //scrollIntoViewByJS() reusable method in testbase class to scroll into a view by using javascript executer
        scrollIntoViewByJS(driver.findElement(By.xpath("//h3[.='WHY US?']")));
        takeScreenshotOfPage();

//        Scroll back up to "Enroll Free"
        waitFor(2);
        scrollIntoViewByJS(driver.findElement(By.xpath("//span[.=' Enroll Free ']")));
        takeScreenshotOfPage();

//        Scroll all the way down
        waitFor(3);
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        scrollAllTheWayDownByJS();
        takeScreenshotOfPage();

//        Scroll all the way up
        waitFor(3);
        scrollAllTheWayUpByJS();
        takeScreenshotOfPage();
//        Take a screenshot of each step
    }

    @Test
    public void clickByJSTest(){
        //Go to https://techproeducation.com/
        driver.get("https://techproeducation.com/");

        //click on LMS LOGIN by using JS Executer
        WebElement LMSLoginButton = driver.findElement(By.linkText("LMS LOGIN"));
        //LMSLoginButton.click();//Selenium Click
        clickByJS(LMSLoginButton); // If you have an issue with selenium click, you can use JS cilck

    }

    @Test
    public void clickByJSTest2(){
        //Go to http://www.uitestpractice.com/Students/Form
        driver.get("http://www.uitestpractice.com/Students/Form");

        //Click on "submit" button
        //driver.findElement(By.xpath("//button[.='Submit']")).click();//Selenium click did not work
        clickByJS(driver.findElement(By.xpath("//button[.='Submit']")));

    }

    @Test
    public void setValueByJSTest(){
        //Go to https://techproeducation.com/
        driver.get("https://techproeducation.com/");

        //Type "QA" into search box
        WebElement searchBox = driver.findElement(By.name("s"));
        //searchBox.sendKeys("QA");//Selenium sendKey() method
        setValueByJS(searchBox,"QA");//JS set Attribute
    }

    @Test
    public void getValueByJSTest(){

        //Go to https://www.carettahotel.com/
        driver.get("https://www.carettahotel.com/");
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();//We did use these two because of security issue

        //Get the value of "CHECK-IN DATE"
        System.out.println("Selenium getText(): "+driver.findElement(By.id("checkin_date")).getText());//It does not take the default value of web element by using selenium getText()
        getValueByJS("checkin_date");

    }

    @Test
    public void changeBackgroundColorAndBorderByJs(){
        //Go to https://www.carettahotel.com/
        driver.get("https://www.carettahotel.com/");
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();//We did use these two because of security issue

        //Change the color of "Check Availability"
        WebElement checkAvailability = driver.findElement(By.xpath("//input[@type='submit']"));
        changeBackGroundColorByJS(checkAvailability,"red");



    }
}