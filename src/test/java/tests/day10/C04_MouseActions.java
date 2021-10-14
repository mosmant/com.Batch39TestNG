package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_MouseActions extends TestBase {
    // DRAG AND DROP // DRAG AND DROP // DRAG AND DROP // DRAG AND DROP
    // DRAG AND DROP // DRAG AND DROP // DRAG AND DROP // DRAG AND DROP
    // DRAG AND DROP // DRAG AND DROP // DRAG AND DROP // DRAG AND DROP
    // DRAG AND DROP // DRAG AND DROP // DRAG AND DROP // DRAG AND DROP



    @Test
    public void Test (){

        //Yeni bir class olusturalim: D14_MouseActions2
        //1- https://demoqa.com/droppable adresine gidelim
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        WebElement dragElement = driver.findElement(By.id("draggable"));
        WebElement dropArea = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(dragElement,dropArea).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String actualDroppedText = driver.findElement(By.xpath("//*[text()='Dropped!']")).getText();
        String expectedDroppedText = "Dropped!";

        Assert.assertEquals(actualDroppedText,expectedDroppedText,"mismatch Dropped text TEST FAILED");


    }
}
