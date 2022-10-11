package day16;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class C03_tkrr extends TestBaseBeforeAfter {

    @Test
    public void name() throws IOException, InterruptedException {
        driver.get("http://automationexercise.com");

        //3
        WebElement category = driver.findElement(By.xpath("//h2[text()='Category']"));
        Assert.assertTrue(category.isDisplayed());

        //4
        driver.findElement(By.xpath("//i[@class='material-icons card_travel']")).click();

        //5
        WebElement product1 = driver.findElement(By.xpath("(//*[@class='productinfo text-center'])[1]"));
        WebElement productSelect = driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[2]"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",product1);
/*
        Actions actions = new Actions(driver);
        actions.moveToElement(product1).perform();
        String product1Price = driver.findElement(By.xpath("(//h2)[4]")).getText();
        Thread.sleep(2000);
        actions.moveToElement(productSelect).click().perform();



        //6
        driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();

        //7
        WebElement product2 = driver.findElement(By.xpath("(//*[@class='productinfo text-center'])[2]"));
        WebElement productSelect2 = driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[4]"));
        actions.moveToElement(product2).perform();
        String product2Price = driver.findElement(By.xpath("(//h2)[6]")).getText();
        Thread.sleep(2000);
        actions.moveToElement(productSelect2).click().perform();

 */

        //8
      /*  driver.findElement(By.partialLinkText("View Cart")).click();
        Thread.sleep(2000);

        //9
        List<WebElement> productList = driver.findElements(By.xpath("//img[@class='product_image']"));
        Assert.assertEquals(2,productList.size());

        //10
        String cart1Price = driver.findElement(By.xpath("(//td[3]/p)[1]")).getText();
        String cart2Price = driver.findElement(By.xpath("(//td[3]/p)[2]")).getText();

        System.out.printf(product1Price);
        System.out.println(cart1Price);

        Assert.assertEquals(product1Price,cart1Price);
        Assert.assertEquals(product2Price,cart2Price);

       */
    }
}