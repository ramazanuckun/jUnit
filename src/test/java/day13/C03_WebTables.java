package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C03_WebTables extends TestBaseBeforeAfter {
    //Bir önceki class'daki adrese gidelim
    //Login() methodunu kullanarak sayfaya giriş yapalım
    //input olarak verilen satır sayısı ve sutun sayısına sahip cell'deki text'i yazdıralım
    //price basligindaki tum numaralari yazdiriniz

    @Test
    public void name() {

login();

        //input olarak verilen satır sayısı ve sutun sayısına sahip cell'deki text'i yazdıralım

        int satir = 1;
        int sutun = 2;

        WebElement cell=driver.findElement
                (By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));//
        System.out.println("satir ve sutundaki text="+cell.getText());
        //price basligindaki tum numaralari yazdiriniz
        List<WebElement>price=driver.findElements(By.xpath("//tbody//tr//td[6]"));

        //price.forEach(t-> System.out.println(t.getText()));===>1.yol lambda ile

        for (WebElement each:price//=========>2.yol for each ile
             ) {
            System.out.println(each.getText());
        }


    }

    private void login() {

        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        //driver.findElement(By.xpath("//*[@id='UserName']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }
}
