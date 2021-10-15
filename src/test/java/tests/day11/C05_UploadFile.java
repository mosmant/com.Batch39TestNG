package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_UploadFile extends TestBase {

    //1.Tests packagenin altina bir class oluşturun : C05_UploadFile
    //2.https://the-internet.herokuapp.com/upload adresine gidelim
    //3.chooseFile butonuna basalim
    //4.Yuklemek istediginiz dosyayi secelim.
    //5.Upload butonuna basalim.
    //6.“File Uploaded!” textinin goruntulendigini test edelim.

    @Test
    public void test(){

        driver.get("https://the-internet.herokuapp.com/upload");

        //3.chooseFile butonuna basalim


        //4.Yuklemek istediginiz dosyayi secelim.
        String filePath = System.getProperty("user.home")+"\\Desktop\\picture.jpg";
        WebElement dosyaYolu = driver.findElement(By.id("file-upload"));


        dosyaYolu.sendKeys(filePath);
        // *********************************************************
        // BURADA CHOOSE FILE ILE DOSYA ORAYA GONDERİLMİYOR SADECE DOSYA YOLU GOSTERILIYOR.
        // ********************************************************
        // Choose file'a aslında dosya yolunu gosteriyoruz.

        driver.findElement(By.id("file-submit")).click();

        //6.“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement sonucYaziElementi = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(sonucYaziElementi.isDisplayed());




    }


}
