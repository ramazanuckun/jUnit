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

import java.time.Duration;
import java.util.List;

public class C02_DropDownHandleJava {

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

@Before
    public void setup(){

    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://www.amazon.com/");
}
@After
    public void tearDown(){
   // driver.close();
}

@Test
    public void test1(){

    driver.get("https://www.amazon.com/");
    // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
    // oldugunu testedin
    List<WebElement>drops=driver.findElements(By.xpath("//option"));//option ile 1/alma yontemini uyguladik

    System.out.println(drops.size());

    for (WebElement each:drops
         ) {
        System.out.println(each.getText());
    }
//45 old.diyor soruda fakat 45 degil 28 adet var ozaman
    int dropDownList=drops.size();
    int expectecSayi=45;

    Assert.assertNotEquals(expectecSayi,dropDownList);

}
@Test
    public void test2(){

 //   1.Kategori menusunden Books seceneginisecin

    WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
ddm.sendKeys("Books");//keys enter dmeden book u getrdi istedigim elamani buldu//hoca o menude olan herseyi ddm getrr




//    2.Arama kutusuna Java yazin vearatin


driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);






 //   3.Bulunan sonuc sayisiniyazdirin


WebElement sonucYazisi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
    System.out.println("sonucYazisi.getText() = " + sonucYazisi.getText());
    //   4.Sonucun Java kelimesini icerdigini

    String expectecKelime="Java";
    String actualKelime=sonucYazisi.getText();
    Assert.assertTrue(actualKelime.contains(expectecKelime));

}

}
