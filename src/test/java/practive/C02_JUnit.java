package practive;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_JUnit {



    @BeforeClass
    public static void beforeClass(){
        System.out.println("her classtan once calisir===>Befora Class");
    }
    @Before
    public void setup(){
        System.out.println("her Testten once mutlaka calisir ====>Befora");
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    //alfabetik calistirir

    @Test
    public void aest01(){

        System.out.println("Test 01");
    }    @Test
    public void best02(){

        System.out.println("Test 02");
    }    @Test
    public void cest03(){

        System.out.println("Best 03");
    }
    @AfterClass
    public static void AfterClass(){
        System.out.println("her classtan sonra calisir==>AfterClass");
    }
    @After
    public void after(){
        System.out.println("her tetten sonra calisir===>After");
    }

}

