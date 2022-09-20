package Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertion {
    /*
/*
1-Amazon sayfasina git
2- 3 farkli test method'u olustur
- url'in "amazon" icergini test et
- title'in "facebook" icermedigini test et
- sol ust kosede amazon logosunun gorundugunu test et
- a url nin https://facebook.com oldugunu test edin
     */

  static   WebDriver driver;
@BeforeClass

public static void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://amazon.com");

//Before class ta test yapilacak class i tanimlarsak



}
@AfterClass
    public static void tearDown(){

    //driver.close();
}
@Test
    public void test1(){

    // - url'in "amazon" icergini test et

String expectedurl="amazon";
String actualUrl=driver.getTitle();

//amazon  icerdigini bildigim icin
    Assert.assertFalse(actualUrl.contains(expectedurl));


}
@Test
public void test2(){

    //- title'in "facebook" icermedigini test et
String actualTitle=driver.getTitle();
String expectedTitle="facebook";
Assert.assertFalse(actualTitle.contains(expectedTitle));

}
@Test
public void test3(){


    //- sol ust kosede amazon logosunun gorundugunu test et

    WebElement logo=driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));

    Assert.assertTrue(logo.isDisplayed());

}
@Test
    public void test4(){

    //a url nin https://facebook.com oldugunu test edin
    String expectedTitle="https://facebook.com";
    String actualUrl=driver.getCurrentUrl();
    //Assert.assertEquals("Url er est degilse",expectedTitle,actualUrl);

    Assert.assertNotEquals(expectedTitle,actualUrl);//biliyorum ki facebbook degil onun icin egulas dememk icin not dedim
}
/*
  /*
    1) Bir class oluşturun: BestBuyAssertions
    2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki
    testleri yapin
         ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
         ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
         ○ logoTest => BestBuy logosunun görüntülendigini test edin
         ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
     */



}
