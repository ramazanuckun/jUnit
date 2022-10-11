package practive04mehmetHoca;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
// ikinci emojiye tıklayın (hayvan emojisini seçin)
// tüm hayvan emojilerine tıklayın
// formu doldurun (dilediğinizi yazabilirsiniz)
// apply butonuna tıklayın

public class tkrr extends TestBaseBeforeAfter {


    @Test
    public void name() {

    //    https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/

      driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
// ikinci emojiye tıklayın (hayvan emojisini seçin)

  WebElement iframe=driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement
                (By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
// tüm hayvan emojilerine tıklayın

        List<WebElement>hayvanEmoji=driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']//img"));
/*
        for (WebElement w:hayvanEmoji
             ) {
            w.click();
        }


 */
        hayvanEmoji.forEach(t->t.click());
driver.switchTo().defaultContent();
        // formu doldurun (dilediğinizi yazabilirsiniz)
  List<WebElement>formlar=      driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
    List<String>text=new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9","10","11"));
        for (int i = 0; i <formlar.size() ; i++) {
            formlar.get(i).sendKeys(text.get(i));
//*[text()='Apply']
            driver.findElement(By.xpath("//*[text()='Apply']")).click();
        }

    }

    @Test
    public void name1() {

        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
WebElement iframe=driver.findElement(By.xpath("//iframe[@id='emoojis']"));
driver.switchTo().frame(iframe);
driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[1]")).click();
List<WebElement>emoji=driver.findElements(By.xpath("//div[@id='smiles']//img"));
     /*   for (WebElement w:emoji
             ) {
            w.click();
        }

      */
emoji.forEach(t->t.click());
driver.switchTo().defaultContent();
//input[@id='text']
        List<WebElement>formm=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String>doldur=new ArrayList<>(Arrays.asList("1","2","3"));


        for (int i = 0; i <formm.size() ; i++) {
           formm.get(i).sendKeys(doldur.get(i));
        }
    }
}
