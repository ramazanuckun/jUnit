package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class KeyboardActions2 extends TestBaseBeforeAfter {

    @Test
    public void name() {



    //Bir Class olusturalim KeyboardActions2

//https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
// 3- video’yu gorecek kadar asagi inin


//videoyu izlemek icin Play tusuna basin
        List<WebElement>iframe=new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iframe.get(0));
driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
Assert.assertTrue(driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).isEnabled());
//videoyu calistirdiginizi test edin
     //   driver.switchTo().defaultContent();
    //    Assert.assertTrue(cal.isDisplayed());

    }
}
