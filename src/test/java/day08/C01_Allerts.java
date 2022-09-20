package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_Allerts {



    // https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
// Click for JS Alert butonuna tıklayalım
// Tıkladıktan sonra çıkan uyarı mesajına (Alerte) tamam diyelim
    WebDriver driver;
    Select select;

    @Before
            public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }
    @After
    public void tearDown(){
     //   driver.close();
    }
    @Test
    public void test1() throws InterruptedException {
        // Click for JS Alert butonuna tıklayalım
driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
Thread.sleep(1500);

        //   - Tıkladıktan sonra çıkan uyarı mesajına (alerte) tamam diyelim
driver.switchTo().alert().accept();

    }

}
