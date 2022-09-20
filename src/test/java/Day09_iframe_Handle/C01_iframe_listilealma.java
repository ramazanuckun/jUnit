package Day09_iframe_Handle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C01_iframe_listilealma {

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    public void test1(){
/*
bir web sitesinde bir video varsa >iframe< tagi icerisinde ise bu videoyu direk
locate edip calistirmak dogru dinamik almaz.cunku link degisebilir ve locate calismaz,bunun icin butun frameleri bir arayliste atip
index ile frame secip sonrasinda play tusunu locate edip calistirabiliriz.
 */
        driver.get("https://html.com/tags/iframe");
//iframe leri araylist e atik  ;ve gitmet istenileni cagiracagiz
        List<WebElement>iframeList=new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iframeList.get(0));
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
    }
}
