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

public class Day03_Checkbox {

    WebDriver driver;

    @Before
    public void setUp(){
        //user goes to https://testcenter.techproeducation.com/index.php?page=checkboxes
        //locate checkbox 1 and 2
        //click on the checkbox 1 if it is not already selected
        //then verify that checkbox 1 is already checked

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=checkboxes");

    }
    @Test
    public void checkBoxTest(){
        //locate checkbox
        WebElement checkBox1=driver.findElement(By.id("box1"));
        WebElement checkBox2=driver.findElement(By.id("box2"));

        //click on the checkbox 1 if it is not already selected

        if(!checkBox1.isSelected()){
            checkBox1.click();
        }

        //click on the checkbox 2 if it is not already selected

        if(!checkBox2.isSelected()){
            checkBox2.click();
        }

        //then verify that checkbox 1 is already checked
        assertTrue(checkBox1.isSelected());

    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
