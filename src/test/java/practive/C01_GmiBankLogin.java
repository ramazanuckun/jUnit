package practive;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_GmiBankLogin {

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test1(){
        //1-https://www.gmibank.com/ adresine gidin
        driver.get("https://www.gmibank.com/");

        //2-sig in butonuna tiklayin

        driver.findElement(By.xpath("(//a[@class='dropdown-toggle nav-link'])[2]")).click();
driver.findElement(By.xpath("(//*[text()='Sign in'])[1]")).click();//text dedigimizde basi ne olursa olsun ilgiliclassi al

        //
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Batch81");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Batch81+");
        driver.findElement(By.xpath("//button[@type='submit']")).click();


    }
}
