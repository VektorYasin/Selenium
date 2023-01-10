package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoogleHomework {

    /*
    3 methods
    testTitle: verify if google title "Google"
    imageTest: verify if google image displays or not
    gmailLinkTest: verify if gmail link is diplayed or not
    close browser after each test
     */

    @Test
    public void google() {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        driver.getTitle();

        assertEquals("Google", driver.getTitle());

        driver.close();

    }


    //imageTest: verify if google image displays or not
    @Test
    public void imageTest(){

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        WebElement imageGoogle= driver.findElement(By.xpath("//img[@class='lnXdpd']"));

        assertTrue(imageGoogle.isDisplayed());

        driver.close();

    }

    //gmailLinkTest: verify if gmail link is diplayed or not

    @Test
    public void gmailLinkTest(){

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        //WebElement gmailLink= driver.findElement(By.xpath("//*[.='Gmail'][1]"));

        //assertTrue(gmailLink.isDisplayed());

        assertTrue(driver.findElement(By.xpath("//*[.='Gmail'][1]")).isDisplayed());

        driver.close();


    }





}