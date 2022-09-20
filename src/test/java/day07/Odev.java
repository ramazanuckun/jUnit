package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Odev {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'New User Signup!' is visible
    //6. Enter name and email address
    //7. Click 'Signup' button
    //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    //9. Fill details: Title, Name, Email, Password, Date of birth
    //10. Select checkbox 'Sign up for our newsletter!'
    //11. Select checkbox 'Receive special offers from our partners!'
    //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    //13. Click 'Create Account button'
    //14. Verify that 'ACCOUNT CREATED!' is visible
    //15. Click 'Continue' button
    //16. Verify that 'Logged in as username' is visible
    //17. Click 'Delete Account' button
    //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

    WebDriver driver;
    Select select;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://automationexercise.com/");
    }
    @After
    public void tearDown(){
       // driver.close();
    }
    @Test
    public void test1(){
        //3. Verify that home page is visible successfully
        driver.getTitle();

        //4. Click on 'Signup / Login' button
driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();

        //5. Verify 'New User Signup!' is visible
       Assert.assertTrue(driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed());

        //6. Enter name and email address
        WebElement newUser=driver.findElement(By.xpath("//input[@type='text']"));
        WebElement newEmail=driver.findElement(By.xpath("(//input[@type='email'])[2]"));

newUser.sendKeys("rru3206", Keys.ENTER);
newEmail.sendKeys("rru.3206@gmail.com",Keys.ENTER);

        //7. Click 'Signup' button



        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible

Assert.assertTrue(driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]")).isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth

        driver.findElement(By.xpath("//div[@id='uniform-id_gender1']")).click();


        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("rru3206");
        driver.findElement(By.xpath("(////input[@id='email']")).sendKeys("rru.3206@gmail.com");

        WebElement pasvord=driver.findElement(By.xpath("//input[@id='password']"));
        pasvord.sendKeys("418639",Keys.ENTER);

        driver.findElement(By.xpath("//*[@id='days']")).sendKeys("18",Keys.ENTER);
        driver.findElement(By.xpath("//*[@id='months']")).sendKeys("08",Keys.ENTER);
        driver.findElement(By.xpath("//*[@id='years']")).sendKeys("1981",Keys.ENTER);
        //10. Select checkbox 'Sign up for our newsletter!'
        //11. Select checkbox 'Receive special offers from our partners!'
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'
        //14. Verify that 'ACCOUNT CREATED!' is visible
        //15. Click 'Continue' button
        //16. Verify that 'Logged in as username' is visible
        //17. Click 'Delete Account' button
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button



    }


}








