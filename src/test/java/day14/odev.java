package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class odev {
    @Test
    public void name() throws IOException {

//    1.satirdaki 2.hucreye gidelim ve yazdiralim

    String dosyaYolu="src/resources/ulkeler.xlsx";
    FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        workbook.getSheet("Sayfa1").getRow(0).getCell(1).setCellValue("isparta");
//    1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim

//    2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
       String expectedVeri="Afganistan";
        Assert.assertNotEquals(expectedVeri,workbook.getSheet("Sayfa1").getRow(3).getCell(5));
//    Satir sayisini bulalim
        int kullanilanSatir=workbook.getSheet("sayfa1").getPhysicalNumberOfRows();
        System.out.println(kullanilanSatir);
//    Fiziki olarak kullanilan satir sayisini bulun

//    Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim



}}
