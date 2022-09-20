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

public class tekrr {


    /*
  - https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
  - Click for js Alert butonuna tıklayalım
  - Tıkladıktan sonra çıkan uyarı mesajına (alerte) tamam diyelim
    */
    WebDriver driver;
    Select select;

    @Before
    public void setup(){

     WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
public void test1(){

}
}
