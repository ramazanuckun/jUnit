package Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03 {


      /*
        1) Bir class oluşturun: BestBuyAssertions
        2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
            ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
            ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
            ○ logoTest => BestBuy logosunun görüntülendigini test edin
            ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
     */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com");
    }
    @Test
    public void test1(){
       //            ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin

        String ecpectecUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(ecpectecUrl));

    }
    @Test
    public void test2(){

        //  ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

        String expectecTitle="Rest";
        String actualUrl=driver.getTitle();
        Assert.assertFalse(actualUrl.contains(expectecTitle));

    }
    @Test
    public void test3(){

       // ○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoTest=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));

        Assert.assertTrue(logoTest.isDisplayed());

    }
    @Test
    public void test4(){
       //  ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement linkTest=driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(linkTest.isDisplayed());
    }

}
//hamdolsun uzun bir aradan sonra ilk gibi