package tests;

import org.junit.Test;
import utilities.TestBase;

import java.io.IOException;

public class Day10_ScreenshotsOfEntirePage extends TestBase {

    @Test
    public void takeScreenshotTest() throws IOException {
        /*
    Given
        user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
    When
        user type “uni” in the search box
    And
        select the "‘United Kingdom’" from the suggestions
    And
        click on submit button
    Then
        verify the result contains ‘United Kingdom’
     */

        //Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");

        //TAKE A SCREENSHOT
        takeScreenshotOfPage();



    }


}
