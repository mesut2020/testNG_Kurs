package Day06_XML_CrossBrowsers;

import Utils.MethodDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _01_ContactUs extends MethodDriver {
    @Test
    @Parameters("enquiry") //xml den alacağı parametrenin adı buraya yazıldı.
    public void contactUs(String enquiry) // parametre alabilir hale getirildi
    {
        WebElement contactLink=driver.findElement(By.linkText("Contact Us"));
        contactLink.click();

        WebElement enquiryInput=driver.findElement(By.id("input-enquiry"));
        enquiryInput.sendKeys(enquiry);

        WebElement submitButton= driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        submitButton.click();

        WebElement successMessage=driver.findElement(By.cssSelector("#content>p"));

        Assert.assertTrue(successMessage.getText().toLowerCase().contains("successfully"));
    }


}