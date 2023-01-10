package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Day05_DropDown1 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }


    @Test
    public void dropDownTest() {
        //Select "option 1" by index from the dropdown
        //1. Step: Locate the dropdown
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        //2. Step: Create Select object
        Select select = new Select(dropDown);
        //3. Step: Select option by index/value/visibleText
        select.selectByIndex(1);

    }


    @After
    public void tearDown() {
        driver.quit();
    }

}