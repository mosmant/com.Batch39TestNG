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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class C02_IFrameHandle {

    // ● Bir class olusturun: C02_IframeTest
    //  ● https://the-internet.herokuapp.com/iframe adresine gidin.
    //  ● Bir metod olusturun: iframeTest
    // ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda  yazdirin.
    // ○ Text Box’a “Merhaba Dunya!” yazin.
    // ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.


    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        //“An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda  yazdirin.
        WebElement titleTextElement = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(titleTextElement.isEnabled(),"header could not be accessed");
        System.out.println(titleTextElement.getText());


        // ○ Text Box’a “Merhaba Dunya!” yazin.
        // <iframe id="mce_0_ifr" frameborder="0" allowtransparency="true" title="Rich Text Area.
        // Press ALT-0 for help." class="tox-edit-area__iframe"></iframe>

        // iframe ler de id yerine index yazmis olsaydik daha hizli sonuc alirdik.
        //driver.switchTo().frame(0);
        // locate ederek yapmak istedigimiz de iframe i locate ederiz ardından frame(Webelement) yazariz.
        driver.switchTo().frame("mce_0_ifr");
        WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']"));
        // **** bu webelementinden emindik fakat NoSuchElementException aldık. bu iframe olduguna isaret olabilir.
        textBox.click();
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya!");

        // ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.


        // iframe dunyasina gittik fakat su an hala ordayiz. buradan cikmak lazim.
        // yapmazsak NoSuchElementException aliriz.
        // Bır iframe e gecis yaptıktan sonra yeniden ana sayfa ile ilgili bir islem yapmak isterseniz gecis yaptigimiz iframe den geri donmeliyiz.
        // CIKMAK ICIN parentFrame() -> 1 UST SEVIYEDEKI IFRAME E GECER
        // CIKMAK ICIN defaultContent() -> En ustteki frame’e cikmak icin kullanilir

        driver.switchTo().defaultContent();
        WebElement elemantalLink = driver.findElement(By.linkText("Elemental Selenium"));

        SoftAssert softAssert= new SoftAssert();
        softAssert.assertTrue(elemantalLink.isDisplayed());
        System.out.println(elemantalLink.getText());

        elemantalLink.click();

        Thread.sleep(5000);


        softAssert.assertAll();






    }


    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
