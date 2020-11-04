package Day01_Annotations_Priority;

/* 1- http://opencart.abstracta.us/index.php?route=account/login  sitesini açınız.
     2- asd@gmail.com  ve 123qweasd   bilgileri ile login olan test metodunu yazınız.
     3- Login olup olmadığınızı assert ile kontrol ediniz.
     4- bir utils paketi açınız ve buraya beforeClass ve afterClass metdolarını yazarak
        genel kullanım için MetodWebDriver isimli test klasını tanımlayınız.
         */

import Utils.MethodDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _05_Ornek extends MethodDriver {

    @Test (enabled = false)
    void loginTest1() throws InterruptedException {

        driver.findElement(By.id("input-email")).sendKeys("asd@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("123qweasd");


        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button#details-button")).click();

        driver.findElement(By.cssSelector("#proceed-link")).click();
        Thread.sleep(2000);

        String sonuc=driver.findElement(By.xpath("//h2[text()='My Account']")).getText();
    }

    @Test
    void loginTest2() {
        driver.findElement(By.id("input-email")).sendKeys("asd@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("123qweasd");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.not(ExpectedConditions.titleIs("Account Login")));
        if (driver.getTitle().equals("Privacy error")){
            driver.findElement(By.id("details-button")).click();
            driver.findElement(By.id("proceed-link")).click();
        }
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.not(ExpectedConditions.titleIs("Privacy error")));

        String title = driver.getTitle();
        Assert.assertEquals(title, "My Account");

    }



}
