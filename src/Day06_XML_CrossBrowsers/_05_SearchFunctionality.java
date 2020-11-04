package Day06_XML_CrossBrowsers;

import Utils.ParameterDriver2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
/*
      Senaryo ;
      1- Siteyi açınız.
      2- mac kelimeini göndererek aratınız.
      3- Çıkan sonuçlarda mac kelimesinin geçtiğini doğrulayınız.
    */
public class _05_SearchFunctionality extends ParameterDriver2 {
    @Test
    @Parameters("searchText")
    public void searchFunctionality(String searchText) {

        WebElement search = driver.findElement(By.name("search"));
        search.sendKeys(searchText);

        WebElement searchButton = driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']"));
        searchButton.click();

        List<WebElement> items = driver.findElements(By.cssSelector("h4>a"));

        for (WebElement el:items ) {
            System.out.println(el.getText());
            Assert.assertTrue(el.getText().toLowerCase().contains(searchText));

        }
    }
}
