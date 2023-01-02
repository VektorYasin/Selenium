package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class PrintWebTableDataTest extends TestBase {
//        HOMEWORK
//        Task 5 : Write a method that accepts 2 parameters
//        Parameter 1 = row number
//        Parameter 2 = column number
//        printData(2,3);  => prints data in 2nd row 3rd column

    public void printData(int rowNum, int colNum){

        driver.get("https://the-internet.herokuapp.com/tables");

        //String xpath = "//table[@id='table1']//tr["+rowNum+"]//td["+colNum+"]";
        ////table[@id='table1']//tr[3]//td[1]


        List<WebElement> allData = driver.findElements(By.xpath("//table[@id='table1']//tr["+rowNum+"]//td["+colNum+"]"));

        for (WebElement cellData : allData) {
            System.out.println("RowColNum " + rowNum + colNum + " => " + cellData.getText());
        }

    }

    @Test
    public void printDataTest(){

        printData(2,3);//fbach@yahoo.com
        printData(4,1);//Conway
        printData(3,5);//http://www.jdoe.com
        printData(3,3);//jdoe@hotmail.com
        printData(4,4);//$50.00

    }
}

