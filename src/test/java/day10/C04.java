package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C04 extends TestBaseBeforeAfter {
    @Test
    public void test1(){

        /*
        Yeni bir class olusturalim: MouseActions1
https://the-internet.herokuapp.com/context_menu sitesine gidelim  3- Cizili alan uzerinde sag click yapalim
Alert’te cikan yazinin “You selected a context menu” oldugunu
test edelim.
Tamam diyerek alert’i kapatalim
Elemental Selenium linkine tiklayalim
Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

         */

        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Cizili alan uzerinde sag click yapalim"

   WebElement cizgiliAlan= driver.findElement(By.xpath("//div[@id='hot-spot']"));//cigili alani locate ettim
        Actions actions=new Actions(driver);
        actions.contextClick(cizgiliAlan).perform();

        //Alert’te cikan yazinin “You selected a context menu” oldugunu

      // 1.yol  Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());
        String ecpected="You selected a context menu";
        String actual=driver.switchTo().alert().getText();
        Assert.assertEquals(ecpected,actual);
       // Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

       // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        List<String>windowlist=new ArrayList<>(driver.getWindowHandles());//yeni bir sayfa acildigi icin bu olmadan yeni sayfaya
        // gidemiyordum sebebi tikladi gitti fakat islem yapabilmem icin bu sartti
        driver.switchTo().window(windowlist.get(1));

      //  Assert.assertEquals("Elemental Selenium",driver.findElement(By.xpath("//h1")).getText());
        WebElement tagName=driver.findElement(By.xpath("//h1"));
       Assert.assertTrue(tagName.getText().contains("Elemental Selenium"));
    }
}
