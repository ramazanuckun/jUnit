package Day09_iframe_Handle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WindovsHandle {
    WebDriver driver;


    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void getDown(){
       // driver.quit();
    }
    @Test
    public void test1(){
      //  Yeni bir class olusturun: WindowHandle

      //  Amazon anasayfa adresine gidin.
   driver.get("https://amazon.com");
      //  Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonHandle=driver.getWindowHandle();
     //   Sayfa expectectitle’nin “Amazon” icerdigini test edin
        String expectectitle="Amazon";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectectitle));
     //   Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");
     //   Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin

        String ecpectecTitle="TECHPROEDUCATION";
        String actualTitlee=driver.getTitle();
        Assert.assertFalse(actualTitlee.contains(ecpectecTitle));
     //   Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://walmart.com");
      //  Sayfa title’nin “Walmart” icerdigini test edin
String  WalmartIceriyormu="Walmart";
String actual=driver.getTitle();
Assert.assertTrue(actual.contains(WalmartIceriyormu));
     //   Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

        driver.switchTo().window(amazonHandle);
        Assert.assertTrue(driver.getTitle().contains(actualTitle));//39.satirda aldigim kulandim
    }
}
