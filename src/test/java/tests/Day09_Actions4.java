package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class Day09_Actions4 extends TestBase {
    /*
    Create a class: Action4
    Create a method dragAndDropTest
    Given
        user is on https://jqueryui.com/droppable/
    And
        user moves the target element(Drag me to my target) in to destination(Drop here)
     */

    @Test
    public void dragAndDrop() {

        driver.get("https://jqueryui.com/droppable/");
        //move target element into the destination element

        //below elements are in the iframe, so switch to frame first
        //create actions object
        Actions actions = new Actions(driver);

        //locate source and target web element
        driver.switchTo().frame(0);//switching into the first iframe
        WebElement source = driver.findElement((By.id("draggable")));
        WebElement target = driver.findElement(By.id("droppable"));

        //use actions class "dragAndDrop()" method to move source to drag to the target
        actions.dragAndDrop(source, target).perform();
    }
    /*
    IF test FAILS;                      1.dragAndDrop(source, target) method
    1.check locator                     2.clickAndHold(source).moveToElement(target).
    2.check iframe                      3.clickAndHold(source).moveByOffset(160, 30)
    3.wait or synchronization issue     4.dragAndDropBy(source, 160,30)
     */
    @Test
    public void clickAndHoldTest() {

        driver.get("https://jqueryui.com/droppable/");
        //move target element into the destination element

        //below elements are in the iframe, so switch to frame first
        driver.switchTo().frame(0);//switching into the first iframe
        WebElement source = driver.findElement((By.id("draggable")));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.
                clickAndHold(source).
                moveToElement(target).
                build().
                perform();
        //holds the source and move and drop to the target

    }

    @Test
    public void moveOffsetByTest(){
        driver.get("https://jqueryui.com/droppable/");
        //move target element into the destinaton element

        //below elements are in the iframe so switch to frame first
        driver.switchTo().frame(0);//switching into the firs iframe
        WebElement source = driver.findElement((By.id("draggable")));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.
                clickAndHold(source).
                moveByOffset(160, 30).
                build().
                perform();

    }

    @Test
    public void dragAndDropBy(){
        driver.get("https://jqueryui.com/droppable/");
        //move target element into the destination element

        //below elements are in the iframe, so switch to frame first
        driver.switchTo().frame(0);//switching into the firs iframe
        WebElement source = driver.findElement((By.id("draggable")));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.
                dragAndDropBy(source, 160,30).
                perform();

    }
}