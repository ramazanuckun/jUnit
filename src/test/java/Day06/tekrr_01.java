package Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class tekrr_01 {

    /*
  Bir Class olusturalim YanlisEmailTesti
  http://automationpractice.com/index.php sayfasina gidelim
  Sign in butonuna basalim
  Email kutusuna @isareti olmayan bir mail yazip enter’a
  bastigimizda “Invalid email address” uyarisi ciktigini test edelim
​
 */
   static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationpractice.com/index.php");
    }
    @AfterClass
    public static void tearDown(){

        //driver.close();
    }
    @Test
    public void tes1(){

      //  Sign in butonuna basalim
driver.findElement(By.xpath("//a[@class='login']")).click();
/*
Email kutusuna @isareti olmayan bir mail yazip enter’a
  bastigimizda “Invalid email address” uyarisi ciktigini test edelim
​
 */

        WebElement email=driver.findElement(By.xpath("//input[@id='email_create']"));
        WebElement emailEnter=driver.findElement(By.xpath("//i[@class='icon-user left']"));
        email.sendKeys("rrr.3206gmail.com",Keys.ENTER);
        emailEnter.click();

Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Invalid email address.']")).isDisplayed());
    }
}
