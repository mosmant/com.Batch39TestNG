package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C98_Practise extends TestBase {

    @Test
    public void Test1()  {
        //Actions Class Home Work
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2- Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hoverOverMeFirst= driver.findElement(By.xpath("(//div[@class='dropdown hover'])"));
        actions.moveToElement(hoverOverMeFirst).perform();
        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])")).click();
        //4- Popup mesajini yazdirin
        System.out.println("Pop-up mesaji : "+driver.switchTo().alert().getText());
        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHold=driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHold).perform();
        // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("Click and hold kutusu : "+clickAndHold.getText());
        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClickMe=driver.findElement(By.tagName("h2"));
        actions.doubleClick(doubleClickMe).perform();

    }


}
