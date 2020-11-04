package Day07_Project.CigdemHanim;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Proje2_Task1 extends LoginClass {


    @Test
    void Task1() throws InterruptedException {

        String homePageID = driver.getWindowHandle();

        WebElement facebook = driver.findElement(By.xpath("//a[text()='Facebook']"));
        facebook.click();

        Set<String> windowAllWindow = driver.getWindowHandles();

        for (String window : windowAllWindow) {

            driver.switchTo().window(window);

        }

        String facebookUrl = driver.getCurrentUrl();

        Assert.assertTrue(facebookUrl.contains("facebook"));

        driver.close();

        driver.switchTo().window(homePageID);

        WebElement contactUsLink = driver.findElement(By.xpath("//a[text()='Contact us']"));
        contactUsLink.click();

        WebElement enquiry = driver.findElement(By.id("Enquiry"));
        enquiry.sendKeys("Buraya kadar guzel geldin ...");

        WebElement submitBtn = driver.findElement(By.cssSelector("input[value='Submit']"));
        submitBtn.click();

        String contactUsMesssage = driver.findElement(By.cssSelector("div[class='result']")).getText();

        Assert.assertTrue(contactUsMesssage.contains("enquiry"));


    }
}
