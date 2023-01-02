package tests;
import org.junit.Assert;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class Day09_FileExistTest {
    @Test
    public void isExistTest(){
        /*
    Given
        Create a file on desktop
        C:\Users\yayte\Desktop\file.txt.txt
        (cmd ile komut penceresini aç ve dosyayı içine sürükle, path ekrana çıkar)
    When
        Copy the path of file
    Then
        Assert if the file exists
    */
        String userHome = System.getProperty("user.home");
        System.out.println("userHome = " + userHome);

        boolean isExist= Files.exists(Paths.get(userHome+ "/Desktop/file.txt.txt"));//writing the path dynamically, so that it works on other computers
        //  C:/Users/yayte/Desktop/file.txt.txt bu sekılde de olur, ya da \\, ya da / olacak
        assertTrue(isExist);

        String userDIR= System.getProperty("user.dir");
        //=>gives the path of the current project folder

        System.out.println(userDIR);
        //Users/techproed/IdeaProjects/SeleniumNewProject

        String userHOME=System.getProperty("user.home");
        //=>gives you the user folder

        System.out.println(userHOME); ///Users/techproed
//        Pick a file on your desktop
//        And verify if that file exist on your computer or not

        String pathOfFile = userHOME + "/Desktop/logo.jpeg";
        //WRITING THE PATH DYNAMICALLY SO TIS PATH CAN WORKS ON OTHER LAPTOPS

        //boolean isExist = Files.exists(Paths.get(pathOfFile));
        // returns TRUE if file exists. FALSE if file doesn't exists

        assertTrue(isExist);
    }
}