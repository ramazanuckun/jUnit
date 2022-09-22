package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeClassAfterClass;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExists extends TestBaseBeforeClassAfterClass {

    @Test
    public void name() {

      //1-  Tests packagenin altina bir class oluşturalim : C04_FileDownload

        //3-downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
        //4-https://the-internet.herokuapp.com/download adresine gidelim.
        //5-test.txt dosyasını indirelim

        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//*[text()='test.txt']")).click();
        //6-Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu="C:\\Users\\Kullanıcı\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        //indirildigini konsolda gosterin
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
    }
}
