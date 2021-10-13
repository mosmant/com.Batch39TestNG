package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class C01_AlertsHandle {

    //  ● Bir class olusturun: C01_Alerts
    //  ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //  ● Bir metod olusturun: acceptAlert
    //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //        “You successfully clicked an alert” oldugunu test edin.
    //  ● Bir metod olusturun: dismissAlert
    //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //        “successfuly” icermedigini test edin.
    //
    //  ● Bir metod olusturun: sendKeysAlert
    //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.


    /*
    ===================================
    Her alert JS alert degildir. anlamak icin sag click()  incele (inspect) cikarsa HTML alert cikmazsa JS alert
    HTML alertler weblementler gibi handle edilebilir.
    ===================================
     */


    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void acceptAlert(){

        //Bir metod olusturun: acceptAlert
        //       ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //        “You successfully clicked an alert” oldugunu test edin.

        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();

        // JS alert'e gectik ardından kabul ettik. accept() -> OK

        WebElement resultYaziElementi = driver.findElement(By.id("result"));
        String expectedResult = "You successfully clicked an alert";
        String actualResult = resultYaziElementi.getText();

        // test edin demek hard assert yap demek.
        assertEquals(actualResult,expectedResult,"the result text is not the same as the requested text");
    }
    @Test
    public void dismissAlert(){
        // Bir metod olusturun: dismissAlert
        //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //        “successfuly” icermedigini test edin.

        WebElement resultYaziElementi = driver.findElement(By.id("result"));
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();

        // JS alert'e gectik ardından kabul etmedik. dismiss() -> CANCEL

        String unexpectedResult = "successfuly";
        String actualResult = resultYaziElementi.getText();
        assertFalse(actualResult.contains(unexpectedResult),"result text contains the unexpected text.");


    }
    @Test
    public void sendKeysAlert(){
        // Bir metod olusturun: sendKeysAlert
        //         ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //         tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        String isim = "Osman";
        driver.switchTo().alert().sendKeys(isim);
        // Keys.ENTER yapabilirdik. ama soruda dlick yapin diyor.
        driver.switchTo().alert().accept();
        WebElement resultYaziElementi = driver.findElement(By.id("result"));

        String actualResult = resultYaziElementi.getText();

        // dogrulayin derse (verify) soft assertion kullaniliriz.

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(actualResult.contains(isim));


        softAssert.assertAll();



    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }


}
