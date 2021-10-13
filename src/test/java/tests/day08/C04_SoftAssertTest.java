package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C04_SoftAssertTest {
    // Yeni bir Class Olusturun : D11_SoftAssert1
    //1.“https://www.hepsiburada.com/” Adresine gidin
    //2.Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin
    //3.search kutusuna araba yazip arattirin
    //4.bulunan sonuc sayisini yazdirin
    //5.sonuc yazisinin "araba" icerdigini dogrulayin
    //6.Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin


    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test(){
        driver.get("https://www.hepsiburada.com/");

        SoftAssert softAssert = new SoftAssert();

        //2.Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin
        softAssert.assertTrue(driver.getTitle().contains("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com"),"Title - Test Failed");

        // 3.search kutusuna araba yazip arattirin
        driver.findElement(By.xpath("//input[@class ='desktopOldAutosuggestTheme-input']")).sendKeys("araba"+ Keys.ENTER);

        //4.bulunan sonuc sayisini yazdirin
        WebElement result = driver.findElement(By.className("category-suggestion-title"));
        System.out.println(result.getText());

        //5.sonuc yazisinin "araba" icerdigini dogrulayin
        softAssert.assertTrue(result.getText().contains("araba"),"Result doesnt contains 'araba' - Test Failed");

        //6.Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin
        softAssert.assertFalse(result.getText().contains("oto"),"Result contains 'oto' - Test Failed");







        softAssert.assertAll();









    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }



}
