package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    // amazon ana sayfaya gidilecek ve nutella icin arama yapin ve 9. urune tiklayin

    @Test
    public void test (){

        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER);


        // 9. urune tiklayiniz.

        driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[9]")).click();



    }


}
