package tests.day12;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C99_Practise extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        driver.switchTo().frame(0);

        //2. “Our Products” butonuna basin
        driver.findElement(By.linkText("Our Products")).click();
        //3. “Cameras product”i tiklayin
        driver.findElement(By.id("camera-img")).click();
        Thread.sleep(3000);
        //4. Popup mesajini yazdirin

        String popupYazısı=driver.findElement(By.xpath("(//div[@class='modal-content'])")).getText();//TRİCK---> popup'ımsı ama degil.

        System.out.println(popupYazısı);

        //5. “close” butonuna basin
        driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[3]/button[2]")).click();

        driver.switchTo().defaultContent();
        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.findElement(By.xpath("//*[@id=\"nav-title\"]")).click();

        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        //-->test edin dediği için Hard Assert
        String actualURL=driver.getCurrentUrl();
        String expectedURL="http://webdriveruniversity.com/index.html";
        Assert.assertEquals(actualURL,expectedURL,"beklenen url yanlış");

    }
}
