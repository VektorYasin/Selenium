import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {
    public static void main(String[] args) {

        //1. set up chrome driver; "driver name" and "the path"
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");

        //2.create chrome driver
        WebDriver driver=new ChromeDriver();

        //3. now that we created web driver, we can automate web application
        driver.get("https://www.techproeducation.com");
    }
}
