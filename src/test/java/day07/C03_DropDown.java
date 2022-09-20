package day07;

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

public class C03_DropDown {

    /*
●Bir class oluşturun:C3_DropDownAmazon
●https://www.amazon.com/ adresinegidin.
-Test1
Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
oldugunu testedin
-Test2
1.Kategori menusunden Books seceneginisecin
2.Arama kutusuna Java yazin vearatin
3.Bulunan sonuc sayisiniyazdirin
4.Sonucun Java kelimesini icerdigini testedin
*/



    WebDriver driver;
    Select select;//hata almamak icin class seviyesinde tanimalamak gerek
    @Before
    public void setuo(){


        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://amazon.com");
    }
    @After
    public void tearDown()
    {
       driver.close();

    }
  @Test
    public void test1(){
    //  Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
     // oldugunu testedin

      WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
      Select select=new Select(ddm);
      List<WebElement>ddmList=select.getOptions();
      System.out.println(ddmList.size());
/*
Dropdown menuye ulasmak icin select clasindan bir obje olstrruz.olusan
 obje ilelocate ettigimiz web elementi yani Drobdown web elementini select
clasina tanimlariz ve get option methedunu kullanarak dropdown u bir list
 e atarak drobdown menunun butun elamanlarinin sayisini a ulasabiliriz
 */
      //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
      //oldugunu testedin
   int expectecSayi=45;
   int actualDDs=ddmList.size();
      Assert.assertNotEquals(expectecSayi,actualDDs);
  }
    @Test
    public void test2(){
      //  1.Kategori menusunden Books seceneginisecin
        WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
    select=new Select(ddm);
    //books a ulasmak icin icin method var sira ile ulasiyoruz

    //select.selectByVisibleText("Books");//eger drobdown munudeki option a string olarak ulasmak istersek u methodu kullaniriz
        //select.selectByIndex(5);//eger index ile ulasmak istersek bu methodu kullaniriz

select.selectByValue("search-alias=stripbooks-intl-ship");//value  ile book ulasabiliyoruz
  /*
        Ddb menude en son secilen option a ulasmak istersek
        en son secim yailan menunun altina koruz kotu
        ===>select.getfirstSelect===<methodunu kullaniriz
         */


        //  2.Arama kutusuna Java yazin vearatin

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

     //   3.Bulunan sonuc sayisiniyazdirin

        WebElement sonucYazisi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println("sonucYazisi.getText() = " + sonucYazisi.getText());

        //   4.Sonucun Java kelimesini icerdigini

        String expectecKelime="Java";
        String actualKelime=sonucYazisi.getText();
        Assert.assertTrue(actualKelime.contains(expectecKelime));


    }
}
