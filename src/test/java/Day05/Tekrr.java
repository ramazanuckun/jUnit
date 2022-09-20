package Day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Tekrr {
WebDriver driver;

    @Before//notasyonu her her testten once calisir
    public  void setup(){

        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @Test

    public void method1() throws InterruptedException {

        driver.get("https://hepsiburada.com");
//WebElement aranan=driver.findElement(By.className("desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b"));
        WebElement aranan=driver.findElement(By.xpath("//*[@class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']"));



//baslik kontrolu
String title=driver.getTitle();
String baslik="google";
        System.out.println(title.contains(baslik)?"PASSED":"FAILED");
//bisiklet aramasi
Thread.sleep(1500);
aranan.sendKeys("bisiklet", Keys.ENTER);

//bulunan sonuc sayisini yazdiralim
        WebElement aramaSonuc=driver.findElement
                (By.xpath("//*[@class='paginatorStyle-ljY8JJVmGenvjaVPstVr']"));

        System.out.println(aramaSonuc.getText());

String[]sonucayristir=aramaSonuc.getText().split("/");
        System.out.println("Bisiklet Arama Sonucu==>"+sonucayristir[1]);

//sonuc sayisinin 1000 den fazla oldugunu test edin
        int sonucInt=Integer.parseInt(sonucayristir[1].replaceAll("\\D",""));
        System.out.println(sonucInt);

        System.out.println(sonucInt>1000?"PASSED":"FAILED");




    }
@After
    public void tearDown(){
        driver.close();
}



}
