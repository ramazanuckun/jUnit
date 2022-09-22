package day11;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class tkrr02 extends TestBaseBeforeAfter {
    @Test
    public void name() {
        //"https://facebook.com"  Adresine gidin
        driver.get("https://www.facebook.com");
        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //“firstName” giris kutusuna bir isim yazin
        Faker faker=new Faker();
        WebElement isim = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));

        Actions actions1=new Actions(driver);
        String email=faker.internet().emailAddress();
        actions.click(isim).sendKeys(faker.name().firstName())

                .sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)

                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).

                sendKeys("1").sendKeys(Keys.TAB).sendKeys("Tem").sendKeys(Keys.TAB).sendKeys("1982")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();


    }

    @Test
    public void name1() {
        String yol1="C:\\Users\\Kullanıcı\\Desktop\\Yeni Text Document.txt";
        Assert.assertTrue(Files.exists(Paths.get(yol1)));
        //https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        String dosyaYolu="C:\\Users\\Kullanıcı\\Downloads\\some-file.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
