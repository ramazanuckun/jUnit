package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void name() throws IOException {

        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        //- FileInputStream objesi olusturup,parametre
        // olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
//Olusturmuş olduğumuz dosyayı sistemde işleme alır

        //- Workbook objesi olusturalim,parameter
        // olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fis);
        //Workbook objesiyle fis oblesi ile akışa
        // aldığımız dosyamızla bir excell dosyası create ettik
        //- Sheet objesi olusturun workbook.getSheetAt(index)
        //- Row objesi olusturun sheet.getRow(index)
        //- Cell objesi olusturun row.getCell(index)

        String actualData=workbook.getSheet("sayfa1")
                .getRow(3)
                .toString();
        System.out.println(actualData);

    }
}
