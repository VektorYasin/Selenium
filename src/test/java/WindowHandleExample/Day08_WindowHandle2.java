package WindowHandleExample;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class Day08_WindowHandle2 extends TestBase {

    //window: new window new page, not on the same browser
    //tab: opens in window on the same browser

    /*
    Open 3 new windows and verify their Title
    Open 3 new tabs and verify their Title
    Open 3 new windows and verify their TITLES
    Open 3 new tabs and verify their TITLES
     */

    @Test
    public void newWindowTest() throws InterruptedException {

//        open techproeducation on window 1
        driver.get("https://www.techproeducation.com");
        String techProTitle = driver.getTitle();
        Assert.assertTrue(techProTitle.contains("Techpro Education"));
        String techProHandle = driver.getWindowHandle();//getting window 1 id

        Thread.sleep(5000);

//        open amazon on a new window 2
        driver.switchTo().newWindow(WindowType.WINDOW);//creates a new window and switches to that window automatically
        driver.get("https://www.amazon.com");
        String amazonTitle = driver.getTitle();
        Assert.assertTrue(amazonTitle.contains("Amazon"));
        String amazonHandle = driver.getWindowHandle();//getting window 2 id


        Thread.sleep(5000);
//        open linkedin on a new window 3
        driver.switchTo().newWindow(WindowType.WINDOW);//creates a new window and switches to that window automatically
        driver.get("https://www.linkedin.com");
        String linkedinTitle = driver.getTitle();
        Assert.assertTrue(linkedinTitle.contains("LinkedIn"));
        String linkedinHandle = driver.getWindowHandle();//getting window 3 id
    }

    @Test
    public void newTabTest() throws InterruptedException {

//        open techproeducation on TAB 1
        driver.get("https://www.techproeducation.com");
        String techProTitle = driver.getTitle();
        Assert.assertTrue(techProTitle.contains("Techpro Education"));
        String techProHandle = driver.getWindowHandle();//getting TAB 1 id

        Thread.sleep(5000);

//        open amazon on a new TAB 2
        driver.switchTo().newWindow(WindowType.TAB);//creates a new window and switches to that window automatically
        driver.get("https://www.amazon.com");
        String amazonTitle = driver.getTitle();
        Assert.assertTrue(amazonTitle.contains("Amazon"));
        String amazonHandle = driver.getWindowHandle();//getting TAB 2 id


        Thread.sleep(5000);
//        open linkedin on a new TAB 3
//        driver.switchTo().newWindow(WindowType.TAB);//creates a new TAB and switches to that TAB automatically
//        driver.get("https://www.linkedin.com");
//        String linkedinTitle = driver.getTitle();
//        Assert.assertTrue(linkedinTitle.contains("LinkedIn"));
//        String linkedinHandle = driver.getWindowHandle();//getting TAB 3 id
    }
}