package practice01;

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

import static org.junit.Assert.assertEquals;

public class Q04 {
    // ...Practice 4...
    // Create chrome driver by using @Before annotation and WebDriverManager
    // Navigate to  https://testpages.herokuapp.com/styled/index.html
    // Click on  Calculator under Micro Apps
    // Type any number in the first input
    // Type any number in the second input
    // Click on Calculate
    // Get the result
    // Verify the result
    // Print the result
    // Close the browser by using @After annotation



    // Create chrome driver by using @Before annotation and WebDriverManager
    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @Test
    public void herOkuAppTest(){

    // Navigate to  https://testpages.herokuapp.com/styled/index.html

        driver.get("https://testpages.herokuapp.com/styled/index.html");

    // Click on  Calculator under Micro Apps

        driver.findElement((By.id("calculatetest"))).click();

        //select divide operation
        WebElement functionDropdown=driver.findElement(By.id("function"));
        Select select=new Select(functionDropdown);
        select.selectByVisibleText("divide");

        // Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("6");

    // Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("2");

    // Click on Calculate
        driver.findElement(By.id("calculate")).click();

    // Get the result
        String result= driver.findElement(By.id("answer")).getText();

    // Assert the result
        assertEquals("3", result);

    // Print the result

        System.out.println("result = " + result);
        // Close the browser by using @After annotation
}

@Test
    public void divisionTest(){

    // Navigate to  https://testpages.herokuapp.com/styled/index.html

    driver.get("https://testpages.herokuapp.com/styled/index.html");

    // Click on  Calculator under Micro Apps

    driver.findElement((By.id("calculatetest"))).click();

    // Type any number in the first input
    driver.findElement(By.id("number1")).sendKeys("6");

    // Type any number in the second input
    driver.findElement(By.id("number2")).sendKeys("4");

    // Click on Calculate
    driver.findElement(By.id("calculate")).click();

    // Get the result
    String result= driver.findElement(By.id("answer")).getText();

    // Assert the result
    assertEquals("10", result);

    // Print the result

    System.out.println("result = " + result);
    // Close the browser by using @After annotation

}
@After
    public void teardown(){
        driver.quit();
}


}
