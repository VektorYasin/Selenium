package practice_yasin;

import org.junit.Test;
import utilities.TestBase;

import java.util.Set;

public class CloseAnySpecifiedBrowser extends TestBase {

    @Test
    public void closeAnySpecifiedBrowser() {
        driver.get("https://www.naukri.com/");

//Set the expected title of the browser window which you want to close
        String expected_title = "TechMahindra";

        Set<String> allWindowHandles = driver.getWindowHandles();

        int count = allWindowHandles.size();

        System.out.println("Number of browser windows opened on the system is:" + count);

        for (String windowHandle : allWindowHandles) {
//switch to each browser window
            driver.switchTo().window(windowHandle);
            String actual_title = driver.getTitle();

//Checks whether the actual title contains the specified expected title
            if (actual_title.contains(expected_title)) {
                driver.close();
                System.out.println("Specified Browser window with title-->" + actual_title + "-->is closed");
            }
        }
    }
}