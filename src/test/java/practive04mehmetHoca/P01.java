package practive04mehmetHoca;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 extends TestBaseBeforeAfter {

    // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
// ikinci emojiye tıklayın (hayvan emojisini seçin)
// tüm hayvan emojilerine tıklayın
// formu doldurun (dilediğinizi yazabilirsiniz)
// apply butonuna tıklayın


    @Test
    public void name() {



        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
// tüm hayvan emojilerine tıklayın


        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);//unutma iframe girdik isin bittiginde cikmayi unutma
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
// ikinci emojiye tıklayın (hayvan emojisini seçin)

       List<WebElement>animalEmojist=//64 adet emojiyi aldim ve liste attim ve iframe katmanindayiz
               driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']//img"));
/*1===yol for each ile cozum
        for (WebElement each:animalEmojist
             ) {
            each.click();
        }

 */
        //2/=yol======<lambda ile cozum
        animalEmojist.forEach(t->t.click());
        driver.switchTo().defaultContent();//iframe den ciktim ve bir sonraki asamaya gecebilirim
        // formu doldurun (dilediğinizi yazabilirsiniz)
   List<WebElement>boxes= driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
   //liste tek tek eklemek yerine aslist methodunu kullandim;

   List<String>text=new ArrayList<>(Arrays.asList("bu","listi","kullanarak","kolayca","her","bir"
           ,"webElementi","kolayca","boxes","liste","tasiyabilirsiniz"));
        for (int i = 0; i <boxes.size() ; i++) {

            boxes.get(i).sendKeys(text.get(i));


        }
// apply butonuna tıklayın

        driver.findElement(By.xpath("//button[@id='send']")).click();
    }
}
