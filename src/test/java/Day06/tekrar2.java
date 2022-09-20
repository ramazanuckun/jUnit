package Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.image.Kernel;
import java.time.Duration;

public class tekrar2 {
    // 1.Bir Class olusturalimYanlisEmailTesti
    // 2.http://automationpractice.com/index.php sayfasinagidelim
    // 3.Sign in butonunabasalim
    // 4.Email kutusuna @isareti olmayan bir mail yazipenter'a
    // bastigimizda "Invalid email address" uyarisi ciktigini testedelim
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com/");
    }
    @AfterClass
    public static void tearDown(){
        //  driver.close();
    }
    @Test

    public void test1(){
     //   4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
      //  5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünü
        //6. Adı ve e-posta adresini girin
        WebElement email=driver.findElement(By.tagName("Title" +
                ""));
        WebElement pasword=driver.findElement(By.xpath("(//input[@type='email'])[2]"));
        WebElement onay=driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        email.sendKeys("ramazan",Keys.ENTER);
        pasword.sendKeys("rru.3206@gmail.com");
        onay.click();
//8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
      WebElement gorunurluk=driver.findElement(By.xpath("//b"));
Assert.assertTrue(gorunurluk.isDisplayed());

//9-9. Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
WebElement ppsvordBelirle=driver.findElement(By.xpath("//input[@type='password']"));
ppsvordBelirle.sendKeys("418639",Keys.ENTER);
WebElement cinsiyet=driver.findElement(By.id("(//label[@for='id_gender1']"));
WebElement dogumTarihigun=driver.findElement(By.id("days"));
WebElement dogumTarihiAy=driver.findElement(By.id("months"));
WebElement dogumTarihiYil=driver.findElement(By.id("years"));

cinsiyet.click();
dogumTarihigun.sendKeys("18",Keys.ENTER);
dogumTarihiAy.sendKeys("08",Keys.ENTER);
dogumTarihiYil.sendKeys("1981",Keys.ENTER);

    }
    @Test

    public void test2(){

    }

    }



