package Day09_iframe_Handle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Iframe {
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
     //   driver.close();

    }
    @Test
    public void iframeTest() throws InterruptedException {
          /*
    ● Bir class olusturun: IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
       ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
       ○ Text Box’a “Merhaba Dunya!” yazin.
       ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
         dogrulayin ve konsolda yazdirin
     */

        // ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //   ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
 WebElement IframeYazisi=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(IframeYazisi.isDisplayed());
        System.out.println(IframeYazisi.getText());

        //  ○ Text Box’a “Merhaba Dunya!” yazin.

        WebElement textBox=driver.findElement(By.id("mce_0_ifr"));//Frame gecis yapmadan onceorayi id ile locate ettik
        driver.switchTo().frame(textBox);//locate edilen frame gecmek icin bu methodu kullaniriz
        WebElement textBoxFrame=driver.findElement(By.xpath("//p"));

Thread.sleep(2000);
        textBoxFrame.clear();//yazi yazilacak alanin ici temizlendi
        Thread.sleep(2000);
textBoxFrame.sendKeys("Merhaba Dunya");

 //  ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
    //    dogrulayin ve konsolda yazdirin
//WebElement yazi=driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));

        //frame den cikamdigimiz icin direk yadiramiyoruz
        driver.switchTo().defaultContent();//===>frameden cikma kodu malum arada yazdiramadim cikmayi bilmedigim icin
 WebElement seleniumTest=driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
Assert.assertTrue(seleniumTest.isDisplayed());
        System.out.println(seleniumTest.getText());

        /*
        swich to ile yapilan 3 sey var allert-frame-handle
         */
    }
}
