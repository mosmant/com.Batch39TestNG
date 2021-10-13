package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    /*
    ====================================================================

    biz test base classi sadece extends edereke kullanacagiz. Dolayisiyla olusturdugumuz driver variable i icin
    pretected acc. modifieri seciyoruz.

    ====================================================================

    ABSTRACT yaparak bu classtan obje olusturulmasının onune geceriz. Sart degildir.

    ====================================================================

     */
    // inheritance ile bu class kullanacagimiz testlerde super class olacak.WebDriver public oldu.
    // protected : ayni package dekiler ve subclasslar kullanabilir. (child class)
    //

    protected WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
