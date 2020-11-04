package Day08_DataPrivider;

import Utils.MethodDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Odev_ContactUsDataProvider extends MethodDriver {
    @Test(dataProvider = "getData")
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

    @DataProvider
    public Object[] getData(){

        Object[] data={
                        "Kulaklarimda hep bir gurbet şiiri",
                        "Her nagmemde bir poyraz serinligi...",
                        "Düşüncem 'veda' diyor bu yerlere.",
                        "Ülkemden ayrildigim günden beri"
        };

        return data;
    }

}