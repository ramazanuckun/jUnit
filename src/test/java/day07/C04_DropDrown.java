package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_DropDrown {
/*
    Bir class oluşturun: DropDown
    https://the-internet.herokuapp.com/dropdown adresine gidin.
    Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    Tüm dropdown değerleri(value) yazdırın
    Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    False yazdırın.

 */

    WebDriver driver;
    Select select;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @After
    public void tearDown(){
     //  driver.close();

    }
    @Test
    public void test1(){
       // Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
WebElement ddm=driver.findElement(By.xpath("//select[@id='dropdown']"));

select=new Select(ddm);
select.selectByIndex(1);
//bir onceki adimda ne sectigimizi yazdiriyor
        System.out.println(select.getFirstSelectedOption().getText());
        // 2. Value kullanarak Secenek 2'yi (Option 2) secin ve yazdirin
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

//  // 3. Visible Text(Gorunen metin) kullanarak Secenek'i (Option) secin ve yazdirin

        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

       // Tüm dropdown değerleri(value) yazdırın
        List<WebElement>DDpDegerleri=select.getOptions();
      /*  for (WebElement each:DDpDegerleri
             ) {
            System.out.println(each.getText());
        }


       */
        //2.yol
        DDpDegerleri.forEach(t-> System.out.println(t.getText()));//lambda ille

    //    Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
int ddpBoyut=DDpDegerleri.size();
        int istenen=4;

        Assert.assertNotEquals(istenen,DDpDegerleri);
if (ddpBoyut==istenen){
    System.out.println(true);
}else System.out.println(false);
    Assert.assertNotEquals(DDpDegerleri.size(),4);
    }
@Test
    public void test2(){


}
}
//size ile boyutunu bulurum get ile ogelerini