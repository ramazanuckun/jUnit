package Zautonationexercise.com;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class Test1_Case1 extends TestBaseBeforeAfter {

    @Test
    public void test1(){

        // 2. Navigate to url 'http://automationexercise.com'

      driver.get("http://automationexercise.com");




        // 3. Verify that home page is visible successfully
driver.getTitle();

        //4. Click on 'Signup / Login' button
driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();

        // 5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[3]")).isDisplayed());

        //6. Enter name and email address

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("rru3206");
    driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("rru.3271@gmail.com");
        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
     Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed());
        //9. Fill details: Title, Name, Email, Password, Date of birth
driver.findElement(By.id("uniform-id_gender1")).click();
driver.findElement(By.xpath("//input[@id='password']"))
        .sendKeys("418639");
driver.findElement(By.xpath("//select[@id='days']")).sendKeys("18");
WebElement ayim=driver.findElement(By.xpath("//select[@id='months']"));
        Select select=new Select(ayim);
        select.selectByIndex(8);

driver.findElement(By.xpath("//select[@id='years']")).sendKeys("1981");
      /*
//10. Select checkbox 'Sign up for our newsletter!'

  driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();


       */
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

        driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("rahmi");
        driver.findElement(By.xpath("//input[@type='text'][4]")).sendKeys("rahmi");
        driver.findElement(By.xpath("//input[@type='text'][5]")).sendKeys("rahmi");
        driver.findElement(By.xpath("//input[@type='text'][6]")).sendKeys("rahmi");
        driver.findElement(By.xpath("//input[@type='text'][7]")).sendKeys("rahmi");
WebElement company=driver.findElement(By.xpath("//select[@id='country']"));
Select select1=new Select(company);
select1.selectByIndex(3);
        //13. Click 'Create Account button'
        //1/4. Verify that 'ACCOUNT CREATED!' is visible
        //15. Click 'Continue' button
        //16. Verify that 'Logged in as username' is visible
        //17. Click 'Delete Account' button
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button






















    }



}
