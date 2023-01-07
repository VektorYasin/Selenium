package practice04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class Q03 extends TestBase {
    /*
    Given
        Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
    When
        Click all the buttons
    Then
        Assert all buttons clicked
     */

    @Test
    public void test() {
//        Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

//        Click all the buttons
        driver.findElement(By.id("onblur")).click();//in the first click it is not going to work. It should lose the focus.
        driver.findElement(By.id("onclick")).click();//This click did not trigger the second button. Cos it worked for "onblur" button.
        driver.findElement(By.id("onclick")).click();//This will trigger the second button.

        WebElement oncontextmenu = driver.findElement(By.id("oncontextmenu"));
        WebElement ondoubleclick = driver.findElement(By.id("ondoubleclick"));
        WebElement onfocus = driver.findElement(By.id("onfocus"));
        WebElement onkeydown = driver.findElement(By.id("onkeydown"));
        WebElement onkeyup = driver.findElement(By.id("onkeyup"));
        WebElement onkeypress = driver.findElement(By.id("onkeypress"));
        WebElement onmouseover = driver.findElement(By.id("onmouseover"));
        WebElement onmouseleave = driver.findElement(By.id("onmouseleave"));
        WebElement onmousedown = driver.findElement(By.id("onmousedown"));

        Actions actions = new Actions(driver);

        actions.
                contextClick(oncontextmenu).
                doubleClick(ondoubleclick).
                click(onfocus).
                click(onkeydown).
                sendKeys(Keys.ENTER).
                click(onkeyup).
                sendKeys(Keys.SPACE).
                click(onkeypress).
                sendKeys(Keys.ENTER).
                moveToElement(onmouseover).
                moveToElement(onmouseleave).
                click(onmousedown).//This click triggered "onmouseleave" element.
                click(onmousedown).
                perform();
//        Assert all buttons clicked
        int numberOfClickedButtons = driver.findElements(By.xpath("//p[.='Event Triggered']")).size();
        assertEquals(11,numberOfClickedButtons);
    }
}