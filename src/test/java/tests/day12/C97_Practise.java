package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C97_Practise extends TestBase {

    @Test
    public void isEnabledTest() throws InterruptedException {
    driver.get("https://the-internet.herokuapp.com/dynamic_controls");

    WebElement textBox=driver.findElement(By.xpath("//input[@type='text']"));
    SoftAssert softAssert=new SoftAssert();
    softAssert.assertFalse(textBox.isEnabled(),"TextBox erişilebilir durumda");




    driver.findElement(By.xpath("(//button[@onclick='swapInput()'])")).click();


    WebDriverWait wait=new WebDriverWait(driver,10);
    WebElement enableButon=wait.until(ExpectedConditions.elementToBeClickable(textBox));

    WebElement actText=driver.findElement(By.id("message"));


    softAssert.assertTrue(actText.isDisplayed(),"It's enabled! görünür değil");//görüntülenebiliyor mu?
    softAssert.assertTrue(driver.findElement(By.xpath("(//button[@onclick='swapInput()'])")).isEnabled(),"TextBox etkin değil");

    softAssert.assertAll();
}




}
