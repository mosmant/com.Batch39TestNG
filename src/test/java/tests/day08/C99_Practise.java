package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C99_Practise {
    /*
     * Navigate to  https://www.saucedemo.com/
     * Enter the user name  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     * Choose price low to high
     * Verify item prices are sorted from low to high
     */

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }



    @Test
    public void test (){
        // * Navigate to  https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

        // * Enter the user name  as standard_user
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");

        // * Enter the password as   secret_sauce
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");

        // * Click on login button
        driver.findElement(By.id("login-button")).click();

        // * Choose price low to high
        WebElement option = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(option);

        select.selectByValue("lohi");



    }
    @AfterClass
    public void tearDown(){}


}
