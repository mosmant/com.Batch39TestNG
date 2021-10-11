package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C01_Priority {

    // 3 adet test methodu kosturacagiz.
    // 1. amazon.com'a gitsin
    // 2. techproeducation.com'a gitsin
    // 3. facebook.com anasayfaya gitsin
    // ve sayfa title larini yazalim.

    /*
    ==================================================================
    OZET
    PRIORITY YAZMADIGIMIZ METHODLAR (pririty = 0) KABUL EDER.
    PRIORTY OLMAYALANLARI KENDI ICINDE SIRALAYIP ONLARI KEDI PRIORTY SIRALAMASINA GORE SIRALAR.



     */
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void testAmazon () {
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());

    }
    @Test
    public void testYahoo () {
        driver.get("https://www.yahoo.com");
        System.out.println(driver.getTitle());
    }

    @Test (priority = -101) // siralama yapmak icin kullandik
    public void testGoogle () {
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
    }
    @Test (priority = 10)
    public void testFacebook () {
        driver.get("https://www.facebook.com");
        System.out.println(driver.getTitle());
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    // siralama
    // AMAZON
    // FACEBOOK
    // TECHPROED
    // calisacak natural ordera gore harf siralamasi

    // PRIORITY SIRALAMASI
    // techproed
    // amazon
    // facebook

    // PRIORITY vermezsek priority i 0 (sifir) kabul eder.






}
