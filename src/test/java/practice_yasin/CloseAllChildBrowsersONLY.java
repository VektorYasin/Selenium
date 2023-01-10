package practice_yasin;

import org.junit.Test;
import utilities.TestBase;

import java.util.Set;

public class CloseAllChildBrowsersONLY extends TestBase {
    @Test
    public void closeAllChildBrowsersONLY() {
        driver.get("https://www.naukri.com/");

        //get the window handle id of the parent browser window
        String parentWindowhandleID = driver.getWindowHandle();

        Set<String> allWindowHandles = driver.getWindowHandles();

        int count = allWindowHandles.size();

        System.out.println("Number of browser windows opened on the system is:" + count);

        //switch to each browser window
        for (String windowHandle : allWindowHandles) {
            driver.switchTo().window(windowHandle);
            String title = driver.getTitle();

        /*
        compare the window id of all the browser switch the Parent browser windowid,
        if it is not equal,then only close the browser windows.
        */

            if (!windowHandle.equals(parentWindowhandleID)) {
                driver.close();
                System.out.println("Child Browser window with title-->" + title + "-->is closed");

            }
        }
    }
}