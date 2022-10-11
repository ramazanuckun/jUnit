package day12_dosyaYukleme;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_FileExIstUpload extends TestBaseBeforeAfter {
    @Test
    public void name() {
    //    Tests packagenin altina bir class oluşturun : C05_UploadFile
    //    https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
     //   chooseFile butonuna basalim
      WebElement element= driver.findElement(By.xpath("//*[@id='file-upload']"));

  /*
        Dosyasec butonuna direk click yapamayabiliriz çünkü windows'a müdahaleye izin vermeyebilir
        Bu yüzden Dosyasec butonunu direk locate edip sendKeys() methodu ile string değişkene atadığımız dosya yolumuzu
        göndeririz.
         */

        //   Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu="C:\\Users\\Kullanıcı\\Downloads\\text.txt";
        element.sendKeys(dosyaYolu);
     //   Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
//“File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='File Uploaded!']")).isDisplayed());



    }
}
