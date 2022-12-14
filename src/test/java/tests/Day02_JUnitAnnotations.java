package tests;

import org.junit.Before;
import org.junit.Test;

public class Day02_JUnitAnnotations {
    /*
    1.so far we kept using main method
    2.we no longer need to use main method to create test case with JUnit
    3. @Test is used for to create test cases
    4. All @Test methods must be void.
    5.@Before: runs before each @Test class
    6.@After: runs after each @Test class.
     */

    @Before
    public void setUp(){
        System.out.println("before method run before each @Test annotation");
    }
    @Test
    public void test1(){
        System.out.println("Test1");
    }
    @Test
    public void test2(){
        System.out.println("Test2");
    }
    @Test
    public void test3(){
        System.out.println("Test3");
    }

    @Test
    public void test4(){
        System.out.println("Test4");
    }
    @Test
    public void test5(){
        System.out.println("Test5");
    }
}
