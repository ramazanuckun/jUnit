package day12_dosyaYukleme;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C04_SenkranizasyonWait extends TestBaseBeforeAfter {
    @Test
    public void isEnabled() {

    //    Bir class olusturun : EnableTest
    //    Bir metod olusturun : isEnabled()
    //    https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    //    Textbox’in etkin olmadigini(enabled) dogrulayın

        WebElement textBoxWE = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBoxWE.isEnabled());
    //    Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin

driver.findElement(By.xpath("//*[text()='Enable']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(textBoxWE));//textBoxWE oraya click yapana kadar bekle diyorum
    //“It’s enabled!” mesajinin goruntulendigini dogrulayın.
Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]")).isDisplayed());

    //            Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(textBoxWE.isEnabled());




}}
