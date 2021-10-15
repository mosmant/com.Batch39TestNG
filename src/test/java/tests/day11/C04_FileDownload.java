package tests.day11;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    //2. Iki tane metod oluşturun : isExist() ve downloadTest()
    //3. downloadTest () metodunun icinde aşağıdaki testi yapalim:
    //  - https://the-internet.herokuapp.com/download adresine gidelim.
    //  - logo.png dosyasını indirelim
    //4. Ardından isExist()  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim




    @Test
    public void downloadtest() throws InterruptedException {
        // bu testi 1 defadan fazla calistirdigimizda logo.png doysaından 1 den fazla indiriyor. logo(1).png oluyor.
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[text()='logo.png']")).click();


        // indirmesi icin gereken zaman kadar sureyi driver.close() vermedi

        Thread.sleep(5000);



    }
    @Test
    public void isExist(){

        //4. Ardından isExist()  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String filePath = System.getProperty("user.home")+"\\Downloads\\logo.png";

        Assert.assertTrue(Files.exists(Paths.get(filePath)));


    }
}
