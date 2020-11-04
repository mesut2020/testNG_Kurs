package Day06_XML_CrossBrowsers;

import Utils.MethodDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
/*
        Senaryo-2
        1- Siteye gidiniz
        2- Specials tiklayiniz
        3- Cikan urun sayisi ile indirimli urun sayisi ayni mi dogrulayiniz

     */

public class _02_Specials extends MethodDriver {
    @Test
    public void specials(){
        WebElement specialsLink=driver.findElement(By.linkText("Specials"));
        specialsLink.click();

        List<WebElement> oldAmount = driver.findElements(By.cssSelector("span.price-old"));
        List<WebElement> items = driver.findElements(By.cssSelector("div.product-thumb"));

        Assert.assertEquals(oldAmount.size(), items.size());

    }
}
