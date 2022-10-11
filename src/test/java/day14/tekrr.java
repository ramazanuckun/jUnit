package day14;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.*;

public class tekrr extends TestBaseBeforeAfter {

    @Test
    public void name1() throws IOException {


        driver.get("https://arabam.com");
        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;

        File tumsayfaResmi= takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumsayfaResmi,new File("target/ekranGoruntusu/AllPage"+tarih+".jpeg"));


    }


    }

