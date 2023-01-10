package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day12_WebTable2 extends TestBase {

    @Test
    public void print_data() {
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

        //Get number of rows In table.
        int Row_count = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr")).size();
        System.out.println("Number Of Rows = " + Row_count);

        //Get number of columns In table.
        int Col_count = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr[2]/td")).size();
        //header da cell'Ler aktif değil
        System.out.println("Number Of Columns = "+Col_count);

//      divided xpath In three parts to pass Row_count and Col_count values.
        String first_part = "//*[@id='post']/div[1]/table/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";

//        //Used for loop for number of rows.
//        for (int i=1; i<=Row_count; i++){

//            //Used for loop for number of columns.
//            for(int j=1; j<=Col_count; j++){
//
//                //Prepared final xpath of specific cell as per values of i and j.
//                String final_xpath = first_part+i+second_part+j+third_part;
//
//                //Will retrieve value from located cell and print It.
//                String Table_data = driver.findElement(By.xpath(final_xpath)).getText();
//                System.out.print(Table_data +" ");
//            }
//
//            System.out.println("");
//            System.out.println("");
//        }
//    }
    }
}

