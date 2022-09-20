package Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class tkrr02 {

    WebDriver driver;
    Select select;

    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  driver.manage().window().maximize();
  driver.get("https://amazon.com");


    }
@After
    public void tearDown(){
        driver.close();
}
@Test
    public void test1(){
/*
  -Test1
           Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
           oldugunu testedin
 */
  /* Listli cozum
    List<WebElement>drops=driver.findElements(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
    System.out.println(drops.size());
    for (WebElement each:drops
         ) {
        System.out.println(each.getText());

    }
    int dropdownList=drops.size();
    int expectecSayi=45;

    Assert.assertNotEquals(dropdownList,expectecSayi);

   */
    //2.yol select ile
    WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
 select=new Select(ddm);

 List<WebElement>ddmList=select.getOptions();
    System.out.println(ddmList.size());

    int kexpectedSayi=45;
    int actualSayi=ddmList.size();
    Assert.assertNotEquals(kexpectedSayi,actualSayi);

}
@Test
    public void test2(){
/*
      -Test2
           1.Kategori menusunden Books seceneginisecin
           2.Arama kutusuna Java yazin vearatin
           3.Bulunan sonuc sayisiniyazdirin
           4.Sonucun Java kelimesini icerdigini testedin
 */

    WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
    select=new Select(ddm);
  //  select.selectByVisibleText("Deals");
//select.selectByIndex(7);
    System.out.println(select.getFirstSelectedOption().getText());
select.selectByValue("search-alias=baby-products-intl-ship");

//    2.Arama kutusuna Java yazin vearatin
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
}

}

