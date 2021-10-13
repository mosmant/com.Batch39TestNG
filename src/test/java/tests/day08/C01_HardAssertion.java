package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C01_HardAssertion {

    // amazon sayfasina git
    // url'in "amazon" icerip icermedigini test et
    // title'in amazon icerip icermedigini test edin
    // java kelimesini aratin ve ilk urunun java kelimesi icerip icermdigini test edin

    /*=========================================
    OZET;
    HARD ASSERTION DA YAPILAN TUM TESTLERDE TESTLERDEN 1 TANESI HATALI OLURSA TUM TESTLER CALISMAYI BIRAKIR.

     */

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();



    }
    @Test
    public void test1(){

        // url'in "amazon" icerip icermedigini test et
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

        // title'in amazon icerip icermedigini test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        // java kelimesini aratin ve ilk urunun java kelimesi icerip icermdigini test edin
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("java"+ Keys.ENTER);

        WebElement firstElement = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        Assert.assertTrue(firstElement.getText().contains("Java"));





    }



    @AfterClass
    public void tearDrop(){
        driver.close();
    }

}
