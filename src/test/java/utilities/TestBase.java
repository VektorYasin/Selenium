package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBase {
    protected static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    //    AUTO COMPLETE REUSABLE METHOD
//    THIS CODE IS USED FOR SELECTING AND VERIFYING OUR APP AUTO COMPLETE SEARCH FUNCTIONALITY
//    NOTE: THIS REUSABLE METHOD DESIGNED FOR OUR CURRENT PROJECT. THIS MAY NOT WORK FOR NEW PROJECTS, BUT CAN BE MODIFIED AND USED FOR THAT NEW PROJECT
//    NOTE: YOU WILL SEE THIS KIND OF REUSABLE METHOD THAT IS SPECIFIC TO YOUR OWN PROJECT
//    THE POINT OF REUSABLE METHOD IS : WRITE ONCE USE MULTIPLE TIMES TO SAVE TIME AND SHORT TEST CLASS
    public static void searchAndSelectFromList(String keyword, String textFromList) throws InterruptedException {
//        searchAndSelectFromList('uni', 'United Kingdom');
        Thread.sleep(2000);//putting wait to see steps slower
//        Sending a KEYWORD DYNAMICALLY using PARAMETER 1
        driver.findElement(By.id("myCountry")).sendKeys(keyword);//uni
        Thread.sleep(2000);
//        Selecting an option from the list DYNAMICALLY using PARAMETER 2
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='" + textFromList + "']")).click();//United Kingdom
        Thread.sleep(2000);
//        Nothing special. Just clicking on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();//click on submit button
        Thread.sleep(2000);
//        Verifying if result contains the option that i selected DYNAMICALLY using PAREMETER 2
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains(textFromList));

    }

    //    TAKE SCREENSHOT OF ENTIRE PAGE WITH THIS REUSABLE METHOD
    public void takeScreenshotOfPage() {
//        1. Take screenshot using getScreenshotAs method and TakeScreenshot API-coming from selenium
        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

//        2. Creating a Path and dynamic name for image
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//getting the current local date and time

// Path is where we save the screenshot.   PROJECT    /FOLDER     /FOLDER      / dynamic name of image
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentTime + ".png";//Where we save the image
//       3. Saving image in the path
        try {
            FileUtils.copyFile(image, new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //    TAKE SCREENSHOT OF SPECIFIC ELEMENT WITH THIS REUSABLE METHOD

    public void takeScreenshotOfTheElement(WebElement webElement) {

//       1. Take screenshot
        File image = webElement.getScreenshotAs(OutputType.FILE);

//       2. Creating a Path and dynamic name for image
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//getting the current local date and time
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentTime + ".png";//Where we save the image

//       3. Saving image in the path
        try {
            FileUtils.copyFile(image, new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //Hard Wait
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Dynamic waits (Explicit and Implicit waits) //many methods with different parameters: method overloading
    //----------Explicit Wait----------------------
    public static WebElement waitForVisibility(WebElement element, int durationOfSeconds){

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durationOfSeconds));

        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    //Hard Wait

    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }


    //---------Fluent Wait----------------
    public static WebElement fluenWait(String xpath, int withTimeout, int pollingEvery) {
        //@params: String xPath of web element, int total time of wait, int polling every period

        Wait<WebDriver> wait = new FluentWait<>(driver). //<WebDriver>-->data type
                withTimeout(Duration.ofSeconds(withTimeout)).//total wait
                        pollingEvery(Duration.ofSeconds(pollingEvery)).//checking period of web element ==>Ths will check the web element in each 2 secs.
                        withMessage("Ignoring No Such Element Exception").//optional, giving custom message
                        ignoring(NoSuchElementException.class);//optional, ignoring exception

        //2.Step: Use wait object, apply wait.
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

    }


    /*
    JAVASCRIPT EXECUTER
    @param: WebElement
    Accepts a web element to scroll into that web element
    We may need to scroll for capturing the screenshot properly.
    We may need to scroll into specific element with JS Executer.
     */

    //Used Common
    //Scroll Into a View of an Element By JavaScript
    public void scrollIntoViewByJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //Scroll All The Way Down By using JavaScript
    public void scrollAllTheWayDownByJS() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    //Scroll All The Way Up By using JavaScript
    public void scrollAllTheWayUpByJS() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");

    }

    //Click on a specific web element By using JavaScript
    //important
    public void clickByJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }


    //Set Value By JavaScript
    public void setValueByJS(WebElement element, String inputText) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //"arguments[0].setAttribute('value','inputText')"
        js.executeScript("arguments[0].setAttribute('value','" + inputText + "')", element);

    }

    //Get Value of Input By JavaScript
    public void getValueByJS(String idOfElement){

        JavascriptExecutor js = (JavascriptExecutor)driver;

        //"return document.getElementById('idOfElement').value"
        String value = js.executeScript("return document.getElementById('"+idOfElement+"').value").toString();
        System.out.println("Value of Element = " + value);

    }
    //change background color of a webelement by using JS

    public void changeBackGroundColorByJS(WebElement element, String colorName){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //arguments[0].style.backgroundColor='colorName'

        js.executeScript("arguments[0].style.backgroundColor='"+colorName+"'",element);


    }

    //    This can be used when a new page opens
    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println("Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }





    }
}