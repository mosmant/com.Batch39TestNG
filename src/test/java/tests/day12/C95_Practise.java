package tests.day12;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C95_Practise extends TestBase {

    @Test
    public void test() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/");

        String ilkSayfaHandleNo=driver.getWindowHandle();

        driver.findElement(By.xpath("//*[@id=\"login-portal\"]/div/div[1]/h1")).click();

        Set<String> tumWindowHandleNo=driver.getWindowHandles();
        String ikinciSayfaHandleNo="";
        for (String each:tumWindowHandleNo) {
            if (!each.equals(ilkSayfaHandleNo)){
                ikinciSayfaHandleNo=each;
            }
        }
        driver.switchTo().window(ikinciSayfaHandleNo);
        driver.findElement(By.id("text")).sendKeys("username");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("login-button")).click();
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String ActualResult=driver.switchTo().alert().getText();
        String ExpectedResult="validation failed";
        //-->test edin dediği için Hard Assert
        Assert.assertEquals(ActualResult, ExpectedResult,"beklenen popup mesajı hatalı");
        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        String ikinciSayfaTitle=driver.getTitle();
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(ilkSayfaHandleNo);
        //10.Ilk sayfaya donuldugunu test edin
        String ilkSayfaTitle=driver.getTitle();
        //-->test edin dediği için Hard Assert
        System.out.println("ilk sayfa Title : "+ilkSayfaTitle);
        System.out.println("ikici sayfa Title : "+ikinciSayfaTitle);
        Assert.assertEquals(ilkSayfaTitle,"WebDriverUniversity.com","beklenen title hatalı");



    }
}
