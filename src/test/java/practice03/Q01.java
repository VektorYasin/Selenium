package practices.practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Q01 extends TestBase {
    /*
    Given
        Go to https://demo.guru99.com/test/drag_drop.html
    When
        Drag orange elements on proper boxes below them
    Then
        Verify they are dropped.
  */

    @Test
    public void test(){
        //Go to https://demo.guru99.com/test/drag_drop.html
        driver.get("https://demo.guru99.com/test/drag_drop.html");

        //Drag orange elements on proper boxes below them
        //Locate sources and targets web elements:
        //Sources
        WebElement price = driver.findElement(By.id("fourth"));
        WebElement bank = driver.findElement(By.id("credit2"));
        WebElement sales = driver.findElement(By.id("credit1"));
        //Targets
        WebElement debitAmount = driver.findElement(By.id("amt7"));
        WebElement creditAmount = driver.findElement(By.id("amt8"));
        WebElement debitAccount = driver.findElement(By.id("bank"));
        WebElement creditAccount = driver.findElement(By.id("loan"));
        //Create actions object:
        Actions actions = new Actions(driver);

        //Drag sources to targets
        actions.
                dragAndDrop(price, debitAmount).
                dragAndDrop(price, creditAmount).
                dragAndDrop(bank, debitAccount).
                dragAndDrop(sales, creditAccount).
                build().perform();

        //Verify they are dropped.
        WebElement perfect = driver.findElement(By.id("equal"));
        assertTrue(perfect.isDisplayed());
        //or
        assertEquals("Perfect!",perfect.getText());
    }
}