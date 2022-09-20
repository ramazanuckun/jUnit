package Day09_iframe_Handle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class tekrr {
    WebDriver driver;
    Select select;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


    }
    @After
    public void getDown(){
      //  driver.quit();

    }
    @Test
    public void test1() throws InterruptedException {
        //●Bir class olusturun:IframeTest02


        //1)"http://demo.guru99.com/test/guru99home/"sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //2)sayfadaki iframe sayısınıbulunuz.

       List<WebElement>iframeSayisi=driver.findElements(By.xpath("//iframe"));
        System.out.println(iframeSayisi);
        //3)ilk iframe'deki (Youtube) play butonunatıklayınız.
driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@width=\"560\"]")));
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
        //4)ilk iframe'den çıkıp ana sayfayadönünüz
        driver.switchTo().defaultContent();
        //5)ikinci iframe'deki (Jmeter Made Easy)
        // linke(https://www.guru99.com/live-selenium-project.html)
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='a077aa5e']")));
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
        Thread.sleep(2000);

        //tıklayınız


    }
    @Test
    public void test2(){
driver.get("https://amazon.com");
String amazonHandle=driver.getWindowHandle();
//        //2- Url'nin amazon içerdiğini test edelim
        String beklenen="amazon";
        String cikti=driver.getCurrentUrl();
        Assert.assertTrue(cikti.contains(beklenen));
        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.
        // (https://www.bestbuy.com)

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.bestbuy.com");
        String betboyHandle=driver.getWindowHandle();

        //4- title'in BestBuy içerdiğini test edelim

        String BbestboyTitle=driver.getTitle();
        String beklenenn="BestBuy";
        Assert.assertFalse(BbestboyTitle.contains(beklenenn));


        //5- İlk sayfaya dönüp sayfada java aratalım

        driver.switchTo().window(amazonHandle);
driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java",Keys.ENTER);
             //   sendKeys("java", Keys.ENTER);

        //6- Arama sonuclarının java içerdiğini test edelim

        Assert.assertTrue(driver.findElement
                (By.xpath("//span[@class='a-color-state a-text-bold']")).isDisplayed());
        //7- Yeniden bestbuy sayfasına gidelim
  driver.switchTo().window(betboyHandle);
        //8- Logonun görünürlüğünü test edelim

        Assert.assertTrue(driver.findElement(By.xpath("(//img[@class='logo'])[1]")).isDisplayed());

    }
    @Test
    public void test3(){

        //Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");
        //Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonHandle= driver.getWindowHandle();
        //Sayfa title’nin “Amazon” icerdigini test edin
String actual=driver.getTitle();
String expec="Amazon";
Assert.assertTrue(actual.contains(expec));
        //Yeni bir tab olusturup, acilan tab’da techproeducation.com
        // adresine gidi
    driver.switchTo().newWindow(WindowType.TAB);
    driver.get("https://techproeducation.com");
    String TechHandle=driver.getWindowHandle();
        //Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
Assert.assertFalse(driver.getTitle().contains("TECHPROEDUCATION"));

        //Yeni bir window olusturup, acilan sayfada arabam.com adresine gidin
driver.switchTo().newWindow(WindowType.TAB);
driver.get("https://arabam.com");
        //Sayfa title’nin “Arabam” icerdigini test edin
        Assert.assertFalse(driver.getTitle().contains("Arabam"));

        //Ikinci acilan sayfaya donun ve Techproeducation sayfasina dondugunuzu test edin
        driver.switchTo().window(TechHandle);
        Assert.assertTrue(driver.getWindowHandle().contains(TechHandle));
    }
    @Test
    public void test4() throws InterruptedException {
//https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(text.getText().contains("Opening a new window"));

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        String expecTitle="The Internet";
        String actualTitle=driver.getTitle();
  Assert.assertEquals(expecTitle,actualTitle);
        //Click Here butonuna basın.
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@target='_blank'])[1]")).click();
List<String>windowsList=new ArrayList<>(driver.getWindowHandles());

        System.out.println(windowsList);
        driver.switchTo().window(windowsList.get(0));
        driver.switchTo().window(windowsList.get(1));

        //Acilan yeni pencerenin
        // sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        String actual=driver.getTitle();
        String ecpecActual="New Window";
Assert.assertEquals(ecpecActual,actual);
        //Bir önceki pencereye geri döndükten sonra
        // sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(windowsList.get(0));

        Assert.assertTrue(driver.getTitle().contains("The Internet"));

    }
}
