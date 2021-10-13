package tests.day09;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_TestBaseFirstTest extends TestBase {
    /*
    burada inheritance ile TestBase extends ettik.
    bundan sonra her classta extends testbase yapacagiz. test base classında
    */
    @Test
    public void test(){
        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getTitle());


    }



}
