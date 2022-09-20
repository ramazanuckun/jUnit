package Day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class tekrar03 {

      /*
      a. Verilen web sayfasına gidin.
      https://the-internet.herokuapp.com/checkboxes
      b. Checkbox1 ve checkbox2 elementlerini locate edin.
      c. Checkbox1 seçili değilse onay kutusunu tıklayın
      d. Checkbox2 seçili değilse onay kutusunu tıklayın
     */
WebDriver driver;
    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.manage().window().maximize();






    }
    @Test
    public void method1(){
        //a. Verilen web sayfasına gidin.
        //  https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //      b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement Checkbox1=driver.findElement
                (By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement Checkbox2=driver.findElement
                (By.xpath("(//input[@type='checkbox'])[2]"));

        Checkbox1.click();


    }

}
