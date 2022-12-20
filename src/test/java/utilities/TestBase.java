package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {
    protected WebDriver driver; //default variable can not be seen from other classes etc
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(20)));
        driver.manage().window().maximize();
    }

//    @After
//    public void tearDown(){
//
//        driver.quit();
//    }

}



