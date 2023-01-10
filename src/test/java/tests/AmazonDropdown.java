package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AmazonDropdown {
    /*
    Create A Class: AmazonDropdown
    Create A Method dropdownTest
    Go to https://www.amazon.com/
    Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
    Print the first selected option and assert if it equals “All Departments”.If it fails, then comment that code out and continue rest of the test case.
    Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.(after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
    Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
    Print the  total number of options in the dropdown
    Assert if ‘Appliances’ is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
            BONUS: Assert if the dropdown is in Alphabetical Order
     */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void dropdownTest() {

        //Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));

        //Print the first selected option and
        Select select = new Select(dropdown);
        select.selectByIndex(0);

        String nameOfOption = select.getFirstSelectedOption().getText();
        System.out.println("selected option = " + nameOfOption);

        System.out.println("*************************************");

        //assert if it equals “All Departments”. If it fails, then comment that code out and
        // continue rest of the test case.
        assertEquals("All Departments", nameOfOption);

        System.out.println("*******************************************");
        System.out.println("Select the 4th option by index-'index of 3' and assert if the name is “Amazon Devices”");
        // Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.
        //(after you select you need to use get first selected option method).
        //If it fails, then comment that code out and continue rest of the test case.

//        select.selectByIndex(3);
//        String nameOfFourthOption = select.getFirstSelectedOption().getText();
//        assertEquals("Amazon Devices", nameOfFourthOption);

        System.out.println("*******************************************");

        System.out.println("Print all the dropdown options- getOptions() method returns the List<WebElement>. Using loop, print all options");

        List<WebElement> allOptions = select.getOptions();

        for (WebElement eachOption : allOptions) {

            System.out.println(eachOption.getText());
        }

        System.out.println("*******************************************");

        System.out.println("Print the total number of options in the dropdown");

        int numberOfOptions = select.getOptions().size();
        System.out.println("numberOfOptions = " + numberOfOptions);
        int expectedNumberOfOptions = 28;
        assertEquals(28, numberOfOptions);

        System.out.println("*******************************************");

        System.out.println("Assert if ‘Appliances’ is a dropdown option. Print true if “Appliances” is an option. Print false otherwise.");

        boolean appliancesIsOption = false;

        for (WebElement dropdownOptions : allOptions) {
            if (dropdownOptions.getText().equals("Appliances")) {

                appliancesIsOption = true;
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }

        System.out.println("*******************************************");

        System.out.println("BONUS: Assert if the dropdown is in Alphabetical Order");

        List<WebElement> optionsOrder = select.getOptions();

        List<String> options = new ArrayList<>();//boş bir liste yarattık

        for (WebElement optionsElement : optionsOrder) {
            options.add(optionsElement.getText());//seçenekleri bu listeye attık
        }

        options.remove("All Departments");//seçenek olmayanı çıkardık
        System.out.println("options = " + options);//options listesini yazdırdık

        List<String> tempList = new ArrayList<>(options);//options listesini geçici listeye aktardık

        Collections.sort(tempList);//geçici listeyi sortladık
        System.out.println("Sorted List = " + tempList);

        boolean sortedAscending = options.equals(tempList);//dropdown secenekleri sort edilmiş liste ile eşit
        if (sortedAscending) { //if (true) loopa girer.
            System.out.println("list is sorted");
        } else {
            System.out.println("list is not sorted");
        }
    }
}
