package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import javax.swing.text.DateFormatter;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_GetScreenShot extends TestBaseBeforeAfter {
    @Test
    public void name() throws IOException {
        //Amazon sayfasina gidelim tum sayfanin resmini alalim
        driver.get("https://amazon.com");
        TakesScreenshot ts= (TakesScreenshot) driver;
/*
Bir web sayfanin resmini alabilmek icin  TakesScreenshot clasindan obje olusturup gecici bir
file class indan degiskene TakesScreenShot dan olustrdugum objeden getScreenShotAs methodunu kullanarak
gecici bir file olustururum.
 */
        File tumSayfaResmi=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntusu/AllPage"+tarih+".jpeg"));


    }
}
