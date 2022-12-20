package WindowHandleExample;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day08_Actions1 extends TestBase {
        /*
        Step 1:  Create the action object:
        Actions actions=new Actions(driver);
        Step 2:  Locate the WebElement you want to work on :
        WebElement element = driver.findElement(By.id(“ID"));
        Step 3:  Perform the action on the WebElement by using this actions object.
        For instance, to right click: actions.contextClick(element).perform();
        perform() : Executes an action.This must be used at the end to perform an action.DO NOT FORGET TO USE PERFORM()
             */
@Test
    public void rightClickTest(){

    driver.get("https://the-internet.herokuapp.com/context_menu");

    //when use right click on the box
    //1. creating action object to do right click
    Actions actions=new Actions(driver);

    //2. locating the element I want to do right click
    WebElement box= driver.findElement(By.id("hot-spot"));

    //3. use actions object and appropriate function to do right click
    actions.contextClick(box).perform();


    //then verify the alert message is “You selected a context menu”
    String text= driver.switchTo().alert().getText();
    Assert.assertEquals("You selected a context menu", text);


    //Then accept the alert
    driver.switchTo().alert().accept();

    }

}
