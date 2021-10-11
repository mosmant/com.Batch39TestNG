package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C02_DropDown {
    // Bir class oluşturun: DropDown
    // ● https://the-internet.herokuapp.com/dropdown adresine gidin.
    //    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //    4.Tüm dropdown değerleri(value) yazdırın
    //    5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.


    WebDriver driver ;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

    }
    @Test
    public void test() throws InterruptedException {
        // 1. adim : Web elementini locate edelim

        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Thread.sleep(2000);
        // sayfa acilinca 2 saniye islem yapmasin ardindan 1. indexi secmek icin thread.sleep kullandik.

        // 2. adim :  Select class ini kullanarak bir obje olusturalim ve parametre olarak locate ettigimiz Webelementi yazalim

        Select select = new Select(dropDown);

        // 3. adim :  istedigimiz option i select objesini sec
        //    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText()); // yazdirmak icin kullandik.
        Thread.sleep(2000);

        //    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        // <option value="2">Option 2</option>  ====> value string olarak 2
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        //    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1"); // burada parametreyi girerken string oldugunu unutmamaliyiz.
        System.out.println(select.getFirstSelectedOption().getText());
        // **** select.getFirstSelectedOption() menude secili olan hangisiyse onu yazdirir.
        // **** burada option 1 secili oldugundan dolayi option 1 yazdirir.
        //    4.Tüm dropdown değerleri(value) yazdırın

        List<WebElement> allOptions = select.getOptions();
        System.out.println("=========TUM OPSIYONLARIN LISTESI======");
        allOptions.stream().forEach(t-> System.out.println(t.getText()));

        //    5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        System.out.println(allOptions.size());
        System.out.println(allOptions.size()==4 ? "True" : "False");

    }
    @AfterMethod
    public void tearDrop(){
        driver.close();
    }




}
