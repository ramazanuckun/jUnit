package Day09_iframe_Handle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_windowsHandle {

    //1- Amazon Sayfasina girelim
//2- Url'nin amazon içerdiğini test edelim
//3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
//4- title'in BestBuy içerdiğini test edelim
//5- İlk sayfaya dönüp sayfada java aratalım
//6- Arama sonuclarının java içerdiğini test edelim
//7- Yeniden bestbuy sayfasına gidelim
//8- Logonun görünürlüğünü test edelim
//9- Sayfaları Kapatalım


    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }
    @After
    public void tearDown(){
driver.quit();
    }
    @Test
    public void test() throws InterruptedException {

        //1- Amazon Sayfasina girelim


        driver.get("https://amazon.com");

        String amazonWindowHandle=driver.getWindowHandle();
//2- Url'nin amazon içerdiğini test edelim
String Url= driver.getCurrentUrl();
String ecpectecUrl="amazon";
        Assert.assertTrue(Url.contains(ecpectecUrl));

//3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)

       driver.switchTo().newWindow(WindowType.WINDOW);
       driver.get("https://www.bestbuy.com");
       String bestBoyWindowHandle=driver.getWindowHandle();
//4- title'in BestBuy içerdiğini test edelim
        String actualTitle=driver.getTitle();
        String expectecTitle="BestBuy";
        Assert.assertFalse(actualTitle.contains(expectecTitle));

//5- İlk sayfaya dönüp sayfada java aratalım
Thread.sleep(2000);
        driver.switchTo().window(amazonWindowHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

//6- Arama sonuclarının java içerdiğini test edelim

    WebElement aramaSonucu= driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
    String arananKelime="Java";
    String actualSonuc=aramaSonucu.getText();
   Assert.assertTrue(actualSonuc.contains(arananKelime));
//7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestBoyWindowHandle);


//8- Logonun görünürlüğünü test edelim
Assert.assertTrue(driver.findElement(By.xpath("(//img[@class='logo'])[1]")).isDisplayed());

//9- Sayfaları Kapatalım


    }
}
