package tests;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day05_JavaFaker {

    /*
    TEST DATA: username, password, URL, test environment, address etc...
    Where do you get your test data?
    BA-Business Analyst
    Test lead
    Manual Tester
    Developer
    From database
    From API(documentation)
    Mock data(fake data)--> Java Faker
    (Java Faker creates data randomly)
     */
    @Test
    public void javaFakerTest(){
        //1st step:  create Faker Pbject
        Faker faker= new Faker();

        //2nd step: Create Fake Data
        //generating first name

        String firstName=faker.name().firstName();
        System.out.println("firstName = " + firstName);

        //genertaing lastname
        String lastName= faker.name().lastName();
        System.out.println(lastName);

        //generating user name
        String username= faker.name().username();
        System.out.println("username = " + username);

        //generating title
        String title=faker.name().title();
        System.out.println("title = " + title);

        //full adresse
        String fullAddress=faker.address().fullAddress();
        System.out.println("fullAddress = " + fullAddress);

        //cell phone
        String cellPhone=faker.phoneNumber().cellPhone();
        System.out.println("cellPhone = " + cellPhone);

        //numberBetwee
        int numberBetween= faker.number().numberBetween(1,5);
        System.out.println("numberBetween = " + numberBetween);


    }

}
