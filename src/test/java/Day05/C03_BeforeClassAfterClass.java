package Day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {


    /*
    BeforClass ve
    AfterClass notasyonlari kullaniyorsak olusturulan method static olmak zorundadir

    testleri sira ile calistrdi ve hepsini kapatti befor ve afterin beforclass ve afterclass ile farklari
     */
    static WebDriver driver;
    @BeforeClass
    public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(1500);
        driver.close();
    }
    @Test
    @Ignore//test olmasini istemedigim testin altina koyuyorum ve o test bolumnu test etmiyor
    public void method1() throws InterruptedException {

        Thread.sleep(1500);
        driver.get("https://amazon.com");
    }
    @Test
    public void method2(){
        driver.get("https://techproeducation.com");
    }
    @Test

    public void method3() throws InterruptedException {
        Thread.sleep(1500);
        driver.get("https://hepsiburada.com");
    }
}
