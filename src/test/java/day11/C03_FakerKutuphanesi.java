package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_FakerKutuphanesi extends TestBaseBeforeAfter {

    @Test
    public void name() {

/*
// faker class'i kullanmak icin mvn repository.com adresinden java faker kütüphanesinin aratir
// ve en cok kullanilani pom.xml dosyamiza ekleriz
// ve faker class'indan bir obje olusturup email icin faker.internet methodunu kullanarak
// emailAdress() methodunu seceriz
// password icinde ayni internet methodunu kullaniriz
// isim ve soyisimler icin faker.name() methodu ile firstname() ve lastname() methodunu kullaniriz
// faker claas'ini kullanma amacimiz form dordurmamiz gereken sitelerde defalarca kendi üretecegimiz
// veriler yerine bizim icin random veriler üretir ve isimizi kolaylastirir
 */

        //"https://facebook.com"  Adresine gidin
        driver.get("https://www.facebook.com");
        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //“firstName” giris kutusuna bir isim yazin
        Faker faker = new Faker();
        WebElement isim = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        Actions actions = new Actions(driver);
        String email = faker.internet().emailAddress();// Aynı mail adresini girmesi için String bir değişkene atama yaptık
        /*
        Faker classını kullanma amacımız form doldurmamız gereken web sitelerde defalarca kendi üreteceğimiz veriler yerine
        bizim için rondom veriler üretir ve işimizi kolaylaştırır
        Faker classını kullanmak için mvnrepository.com adresinden java-faker kütüphanesini aratır ve ençok kullanılanı
        pom.xml dosyamıza ekleriz. Ve faker class'ından bir obje oluşturup;
        email için faker.internet() methodunu kullanarak emailAddress() methodunu seçeriz.
        password içinde aynı internet methodunu kullanırız.
        İsim ve soyisimler için faker.name() methodu ile firstname() ve lastname() methodunu kullanırız
         */
        actions.click(isim).sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).sendKeys(faker.name().lastName()). sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("1").sendKeys(Keys.TAB).sendKeys("Tem").
                sendKeys(Keys.TAB).sendKeys("1982").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

    }
}

