package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class ActionsClassHomeWork extends TestBaseBeforeAfter {
    @Test
    public void name() {

        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
// 2- Hover over Me First" kutusunun ustune gelin
        Actions actions1=new Actions(driver);
        WebElement click=driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));


        //3- Link 1" e tiklayin
        actions1.click(click).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        // 4-Popup mesajini yazdirin
        System.out.println("driver.switchTo().alert().getText() = " + driver.switchTo().alert().getText());

        //  5-Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //   6-      “Click and hold" kutusuna basili tutun
        WebElement basilitut=driver.findElement(By.xpath("(//p)[3]"));
        actions1.clickAndHold(basilitut).perform();

        //        7-“Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement bas=driver.findElement(By.xpath("(//div[@class='col-lg-12 text-center'])[3]"));
        actions1.clickAndHold(bas);
        System.out.println(bas.getText());
        //       8- “Double click me" butonunu cift tiklayin
        WebElement cift= driver.findElement(By.xpath("//*[text()='Double Click Me!']"));
actions1.doubleClick(cift).perform();

    }
}
