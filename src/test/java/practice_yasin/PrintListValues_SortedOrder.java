package practice_yasin;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintListValues_SortedOrder extends TestBase {
    @Test
    public void printListValues_SortedOrder() {

        driver.get("file:///D:/Ajit/Selenium/SeleniumBtm_7thSep17/webpages/ListBox_Breakfast.html");

        WebElement listElement = driver.findElement(By.id("mtr"));

        Select select = new Select(listElement);

        List<WebElement> allOptions = select.getOptions();

        int count = allOptions.size();

        System.out.println(count);
        System.out.println("-----print the values in the list----");

        ArrayList<String> list = new ArrayList<String>();
        for (WebElement option : allOptions) {
            String text = option.getText();
            System.out.println(text);
            list.add(text);
        }
        Collections.sort(list);

        System.out.println("-----print the value in sorted order----");

        for (String value : list) {
            System.out.println(value);
        }
    }
}

