package Day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class tkkrr01 {

    WebDriver driver;

    @Before//notasyonu her her testten once calisir
    public  void setup(){

        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
    @Test
public void methot1(){

        driver.get("https://amazon.com");
WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
aramaKutusu.sendKeys("city bike", Keys.ENTER);
        List<WebElement>istenenElement=driver.findElements(By.className("sg-col-inner"));
        WebElement sonucYazisiElementi=istenenElement.get(0);
        System.out.println(sonucYazisiElementi.getText());

        List<WebElement>urunResimleri=driver.findElements(By.className("s-image"));
        WebElement ilkResim=urunResimleri.get(0);
   ilkResim.click();


   /*
   <img class="s-image" src="https://m.media-amazon.com/images/I/61oXs1j9p8L._AC_UY218_.jpg"
    srcset="https://m.media-amazon.com/images/I/61oXs1j9p8L._AC_UY218_.jpg 1x,
     https://m.media-amazon.com/images/I/61oXs1j9p8L._AC_UY327_FMwebp_QL65_.jpg 1.5x
     , https://m.media-amazon.com/images/I/61oXs1j9p8L._AC_UY436_FMwebp_QL65_.jpg 2x,
      https://m.media-amazon.com/images/I/61oXs1j9p8L._AC_UY545_FMwebp_QL65_.jpg 2.5x,
      https://m.media-amazon.com/images/I/61oXs1j9p8L._AC_UY654_FMwebp_QL65_.jpg 3x"
       alt="Sponsored Ad - SLANIGIRO Adult Urban Bike Helmet - Adjustable Fit System &amp; Integrated
    Taillight for Men Women" data-image-index="1" data-image-load="" data-image-latency="s-product-image" data-image-source-density="1">
    */

       //(img[@class='s-img']

driver.close();


}

@Test
    public void method2() {
    //Amazon Sayfasına git
    driver.get("https://amazon.com");
    //Arama butonuna bas, "cat food" arat.
    WebElement mam = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
    mam.sendKeys("cat food", Keys.ENTER);
    //Ilk kedi mamasini sec.
    driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

    //Listeye ekle;
    driver.findElement(By.xpath("//a[@title='Add to List']")).click();

//driver.findElement(By.xpath("(//span[@class='a-size-base-plus'])[1]")).click();
//email

  WebElement email=driver.findElement(By.xpath("//input[@id='ap_email']"));
    email.sendKeys("rru.3206@gmail.com",Keys.ENTER);

//pasword gir
   WebElement pasword=driver.findElement(By.xpath("//input[@type='password']"));
    pasword.sendKeys("418639RRU",Keys.ENTER);

    //Urunu listeye ekle;
    //Urunu listeye ekle;
 //driver.findElement(By.xpath("//*[@id=\"add-to-wishlist-button-submit\"]")).click();

    //Listeme gidip bak;
    driver.findElement(By.xpath("//*[@id=\"my-lists-tab\"]/a/div")).click();
    driver.findElement(By.xpath("//*[@id=\"huc-view-your-list-button\"]/span/a")).click();}}