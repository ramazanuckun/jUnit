package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class tekrr02 {
    WebDriver driver;
    Select select;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @After
    public void tearDown(){
     //   driver.close();

    }
    @Test
    public void test1(){
        //Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        WebElement DDm=driver.findElement(By.xpath("//select[@id='dropdown']"));
        select=new Select(DDm);
        select.selectByIndex(1);
        //Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın

    select.selectByValue("2");
        //Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        //Tüm dropdown değerleri(value) yazdırın
        List<WebElement>ddm=select.getOptions();
       System.out.println(ddm.size());
        for (WebElement each:ddm
             ) {
            System.out.println(each.getSize());
        }
        //Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        int Actualboyut=ddm.size();
        int expectecBoyut=4;
        if (Actualboyut==expectecBoyut){
            System.out.println(true);
        }else System.out.println(false);
        //False yazdırın.
    }
}
