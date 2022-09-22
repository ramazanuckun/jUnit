package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeClassAfterClass;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tekrr01 extends TestBaseBeforeClassAfterClass {

    @Test
    public void name1() {

        //https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        //Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin

        Actions actions=new Actions(driver);
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@type='text']"));
        actions.click(aramaKutusu).sendKeys("samsung").sendKeys(" ").sendKeys(Keys.SHIFT).
   sendKeys("a").keyUp(Keys.SHIFT).sendKeys("7").sendKeys("1").sendKeys(Keys.ENTER).perform();
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).isDisplayed());
WebElement A71=driver.findElement(By.xpath("//*[text()='1-16 of 107 results for']"));

        System.out.println(A71.getText());
    String metin=A71.getText();


    }

    @Test
    public void name2() {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        //
        Actions actions=new Actions(driver);
        WebElement isim=driver.findElement(By.xpath("//input[@name='firstname']"));
                isim.sendKeys("rru");
                actions.sendKeys(Keys.TAB).sendKeys("umut").sendKeys(Keys.TAB).
                        sendKeys("rru.3206@gmail.com").sendKeys(Keys.TAB).sendKeys("123456frtr").sendKeys(Keys.TAB).sendKeys("123456frtr")
                        .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("18").sendKeys(Keys.TAB).
                        sendKeys("08").sendKeys(Keys.TAB).sendKeys("1981").sendKeys(Keys.TAB).sendKeys(Keys.TAB)

                        .sendKeys(Keys.RIGHT).sendKeys(Keys.RIGHT).
                        sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                        perform();

    }

    @Test
    public void name03() {
driver.get("https://hepsiburada.com");
//Actions actions=new Actions(driver);
WebElement tikla= driver.findElement(By.xpath("//div[@id='myAccount']"));
//Select select=new Select(tikla);
        tikla.click();
       WebElement tiklaa= driver.findElement(By.xpath("//a[@title='Hesap oluştur']"));
   // tiklaa.click();
   tiklaa.click();
   Actions actions=new Actions(driver);

  driver.findElement(By.xpath("(//div[@role='presentation'])[3]")).click();
 driver.findElement(By.xpath("//input[@type='email']")).sendKeys("rru.3206@gmail.com",Keys.ENTER);
  // actions.sendKeys("rru.3206@gmail.com").sendKeys(Keys.TAB).perform();


    }

}

