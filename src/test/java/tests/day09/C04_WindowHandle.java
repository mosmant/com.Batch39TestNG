package tests.day09;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C04_WindowHandle extends TestBase {

    //● Tests package’inda yeni bir class olusturun: C04_WindowHandle
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

    @Test
    public void Test(){

        // ● https://the-internet.herokuapp.com/windows adresine gidin.

        driver.get("https://the-internet.herokuapp.com/windows");

        // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.

        String textElement = driver.findElement(By.tagName("h3")).getText();
        String expectedText = "Opening a new window";

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(textElement,expectedText,"expected text not equal actual text");

        // ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";

        softAssert.assertEquals(actualTitle,expectedTitle,"title istenenden farkli");



        // ● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window("");
        String actualNewTitle = driver.getTitle();
        String expectedNewTitle = "New Window";

        softAssert.assertEquals(actualNewTitle,expectedNewTitle,"New page Title is wrong");


        softAssert.assertAll();

    }


}
