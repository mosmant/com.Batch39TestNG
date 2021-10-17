package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C01_WaitTest extends TestBase {
    //1. Bir class olusturun : C01_WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //  Iki metod icin de asagidaki adimlari test edin.
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Remove butonuna basin.
    //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //6. Add buttonuna basin
    //7. It’s back mesajinin gorundugunu test edin


    @Test
    public void implicitlyWaitTest(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        SoftAssert softAssert = new SoftAssert();

        WebElement resultText = driver.findElement(By.xpath("//p[@id='message']"));

        softAssert.assertTrue(resultText.isDisplayed(),"result text not displayed TEST FAILED");

        softAssert.assertAll();

        //6. Add buttonuna basin
        // burada locatora dikkat etmek gerekir. //button[@onclick='swapChechbox()'] yazmis olsaydim
        // add butonu icin yeni bir locator olusturmama gerek yoktu

        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();


        //7. It’s back mesajinin gorundugunu test edin
        resultText = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(resultText.isDisplayed(),"result text is not displayed TEST FAILED");

        // burada test pass olmasinin sebebi implicitly wait den dolayi. remove buttonuna bastigimizda yaklasik 3 sn bekledi.
        // bizim TESTBASE classimizda impliciitly wait 15 sn olarak tanimladik.


        /*
        =================================
        burada olusturdugumuz web element ve locatorlara dikkat etmeliyiz.
        =================================
         */




    }

    @Test
    public void explicitlyWaitTest(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");


        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();


        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver,20);
        // olusturdugumuz eleman bu durumda 20 saniyeye kadar bekleyecek demektir.


        WebElement textWithLocate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(textWithLocate.isDisplayed(),"text doesnt see TEST FAILED");
        /*

        // ONCE WEB ELEMENT OLUSTURDUK
        WebElement resultText = driver.findElement(By.xpath("//p[@id='message']"));

        // SIMDI ISE BEKLETME ISLEMI YAPACAGIZ.
        wait.until(ExpectedConditions.visibilityOf(resultText));

        Assert.assertTrue(resultText.isDisplayed(),"text doesnt see TEST FAILED");
        */
        // BU TEST ICIN WEB ELEMENT OLUSTURMAK ANLAMSIZ OLUR. CUNKU WAIT ISLEMINI ZATEN O WEB ELEMENT OLUSSUN DIYE YAPIYORUZ.
        // WAIR OLMADAN O EELEMENT OLMAZ. O ELEMENT OLMADAN DA SECTIGIMIZ METHOD CALISMAZ.

        // explicitly waiti istersek locate islemi ile birlikte tek satirda yapabiliriz
        // yada once locate edip uygun method kullanarak bekletmeyi yapabiliriz.


        //6. Add buttonuna basin
        // burada locatora dikkat etmek gerekir. //button[@onclick='swapChechbox()'] yazmis olsaydim
        // add butonu icin yeni bir locator olusturmama gerek yoktu

        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackWıthocate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        Assert.assertTrue(itsBackWıthocate.isDisplayed(),"element not visible TEST FAILED");
    }


}
