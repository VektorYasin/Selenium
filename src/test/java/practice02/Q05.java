package practice02;

import com.beust.ah.A;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q05 extends TestBase {

    // Go to URL : https://demo.automationtesting.in/Static.html
    // Drag and drop elements.

    @Test
    public void tes(){

        driver.get("https://demo.automationtesting.in/Static.html");

        //locate source
        WebElement angular= driver.findElement(By.id("angular"));
        WebElement mongo= driver.findElement(By.id("mongo"));
        WebElement node= driver.findElement(By.id("node"));

        //locate target
        WebElement droparea= driver.findElement(By.id("droparea"));

        Actions actions=new Actions(driver);
        actions.dragAndDrop(angular, droparea ).
                dragAndDrop(mongo,droparea).
                dragAndDrop(node, droparea).
                build().//it is recommended
                perform();

        //same steps


    }

}
