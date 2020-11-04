package Day07_Project.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;
/* TASK 1
            - Bu siteye gidiniz.  "http://demowebshop.tricentis.com/"
            - Sağ üstteki "Log in" yazısına tıklayınız.
            - "email" ve "password" girip "log in"e tıklayınız.

            - Sayfanın en altındaki "Follow Us" başlığındaki "Facebook" buttonuna tıklayınız.
                Sonrasında açılan pencerenin URL'indeki "facebook" kelimesini doğrulayınız.
            - Ana sayfaya geri dönün.

            - "Information" başlığı altındaki "Contact Us" buttonuna tıklayınız.
            - "Enquiry" yazan yerin altındaki text kutusuna mesajınızı yazıp "submit" butonuna tıklayınız.
            - Sonrasında çıkan yazıyı doğrulayınız. */
public class TestNGTask1 extends  BaseDriverProject{

    @Test
    public void faceBookTest() {

        String homePageID = driver.getWindowHandle();
        WebElement facebook = driver.findElement(By.xpath("//a[text()='Facebook']"));  // linktext ile anabiliriz...
        facebook.click();

        Set<String> windowsIDs = driver.getWindowHandles();

        for (String id : windowsIDs ) {
            if(homePageID.equals(id)) continue;
           driver.switchTo().window(id);  // BURAYA FIREFOX YAKALAYAMIYOR wait ayarla...
            wait.until(ExpectedConditions.urlContains("facebook"));
            System.out.println("Window title : " +driver.getTitle() + "  |  "+ driver.getCurrentUrl());
        }
        textValidation(driver.getCurrentUrl(), "facebook");

        driver.close();
        driver.switchTo().window(homePageID);
    }

    @Test
    public void successfullyMessageTest (){
        WebElement contactUs = driver.findElement(By.xpath("//a[text()='Contact us']"));
        contactUs.click();

        WebElement enquiry = driver.findElement(By.id("Enquiry"));
        enquiry.sendKeys("Burdan bir garip gecti diye yazarsiniz...");

        WebElement submitButoon = driver.findElement(By.name("send-email"));
        submitButoon.click();
        String actualSuccessMessage = driver.findElement(By.cssSelector("div.result")).getText();
        System.out.println(actualSuccessMessage);
        textValidation(actualSuccessMessage, "successfully");
    }

    public void textValidation(String actualText, String keyText){
        Assert.assertTrue(actualText.contains(keyText));
    }

}
