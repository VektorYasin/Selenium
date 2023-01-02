package practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q05 extends TestBase {
    /*
   Given
       Go to http://webdriveruniversity.com/To-Do-List/index.html
   When
       Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
   And
       Strikethrough all todos.
   And
       Delete all todos.
   Then
       Assert that all todos deleted.
    */


    @Test
    public void test() throws InterruptedException {

//       Go to http://webdriveruniversity.com/To-Do-List/index.html
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");


//      Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
        List<String> todosList = new ArrayList<>(Arrays.asList("Prepare breakfast", "Wash the dishes", "Take care of baby", "Help your kid's homework", "Study Selenium", "Sleep"));
        WebElement iputTodos= driver.findElement(By.xpath("//input[@placeholder='Add new todo']"));

        //1st way:
//        for(String w : todosList){
//            iputTodos.sendKeys(w, Keys.ENTER);
//
//        }

        //2nd way

        Actions actions=new Actions(driver);
        for(String w: todosList){
            actions.
                    click(iputTodos).
                    sendKeys(w).
                    sendKeys(Keys.ENTER).
                    perform();
        }

//      Strikethrough all todos.
        List<WebElement> allTodos = driver.findElements(By.xpath("//li"));
        for(WebElement w : allTodos){
            w.click();
        }

//      Delete all todos
        List<WebElement> trashes = driver.findElements(By.xpath("//i[@class='fa fa-trash']"));
        for(WebElement w : trashes){
            w.click();
        }

//      Assert that all todos deleted.
        Thread.sleep(2000);
        List<WebElement> allTodosAfterDelete = driver.findElements(By.xpath("//li"));
        assertEquals(0,allTodosAfterDelete.size());
    }
}


