package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_KeyboardActions extends TestBase {



    @Test
    public void test(){
        //1- Bir Class olusturalim D14_KeyboardActions2
        //2- https://html.com/tags/iframe/ sayfasina gidelim,
        driver.get("https://html.com/tags/iframe/");
        //3- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        //4- videoyu izlemek icin Play tusuna basin
        WebElement iFrameElement = driver.findElement(By.className("lazy-loaded"));
        driver.switchTo().frame(iFrameElement);


        WebElement playButton = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        actions.click(playButton).perform();

        //5- videoyu calistirdiginizi test edin

        // play butonu artik yerinde yok. play butonu yerinde olmadigini test edecegim.

        Assert.assertFalse(playButton.isDisplayed(),"play button's here TEST FAILED");







    }
}
