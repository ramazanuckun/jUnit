package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class odev {

       /*
    1. http://zero.webappsecurity.com/ Adresine gidin
2. Sign in butonuna basin
3. Login kutusuna “username” yazin
4. Password kutusuna “password.” yazin
5. Sign in tusuna basin
6. Pay Bills sayfasina gidin
7. “Purchase Foreign Currency” tusuna basin
8. “Currency” drop down menusunden Eurozone’u secin
9. “amount” kutusuna bir sayi girin
10. “US Dollars” in secilmedigini test edin
11. “Selected currency” butonunu secin
12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
     */

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }@After
    public void getDown(){
       driver.close();
    }
    @Test
    public void test1() throws InterruptedException {


    // http://zero.webappsecurity.com/ Adresine gidin

        driver.get("http://zero.webappsecurity.com/");

Thread.sleep(2000);
//2. Sign in butonuna basin

driver.findElement(By.xpath("//button[@id='signin_button']")).click();

//3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

      //4. Password kutusuna “password.” yazin

driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
Thread.sleep(2000);
//driver.findElement(By.xpath("//input[@type='submit']")).click();
     //5. Sign in tusuna basin
Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
     // driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        driver.navigate().back();


        //6. Pay Bills sayfasina gidin
driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Pay Bills", Keys.ENTER);
Thread.sleep(2000);
driver.findElement(By.xpath("//*[text()='Zero - Pay Bills']")).click();
        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

      //  8. “Currency” drop down menusunden Eurozone’u secin

        WebElement ddb=driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select=new Select(ddb);
        select.selectByIndex(6);


   //     9. “amount” kutusuna bir sayi girin
driver.findElement(By.id("pc_amount")).sendKeys("7");
       // 10. “US Dollars” in secilmedigini test edin

      WebElement dolar=  driver.findElement(By.xpath("(//label[@class='radio inline'])[1]"));

      Assert.assertFalse(dolar.isSelected());


        //11. “Selected currency” butonunu secin
driver.findElement(By.xpath("(//label[@class='radio inline'])[2]")).click();


       //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin


driver.findElement(By.id("pc_calculate_costs")).click();
driver.findElement(By.id("purchase_cash")).click();

//13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
WebElement yazi=driver.findElement(By.xpath("//*[text()='Foreign currency cash was successfully purchased.']"));
        System.out.println(yazi.getText());
String ss="Foreign currency cash was successfully purchased.";
Assert.assertEquals(ss,yazi.getText());



    }
}
