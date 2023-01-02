package practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q03 extends TestBase {

    /*
    Given
        Go to http://the-internet.herokuapp.com/add_remove_elements/
    When
        Click on the "Add Element" button 100 times
    And
        Click on the "Delete" button 20 times
    Then
        Assert that 20 buttons were deleted.
      */


    @Test
    public void test(){

        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        // Click on the "Add Element" button 100 times
        WebElement addButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        for(int i=0; i<100; i++){
            addButton.click();
        }


        //Click on the "Delete" button 20 times

        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[@class='added-manually']"));
        System.out.println("Number of delete buttons before delete : "+deleteButtons.size());


        for(int i=0; i<20; i++){
            deleteButtons.get(i).click();
        }

        //Assert that 20 buttons were deleted.
        List<WebElement> deleteButtonsAfterDelete = driver.findElements(By.xpath("//button[@class='added-manually']"));
        System.out.println("Number of delete buttons after delete : "+ deleteButtonsAfterDelete.size());


        assertEquals(deleteButtons.size()-20, deleteButtonsAfterDelete.size());

    }
}
