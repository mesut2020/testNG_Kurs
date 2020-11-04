package Day10_Reports_PageObjectModel;

import Utils.ParameterDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
/*
Senaryo:
         1-Siteye gidiniz.
         2-ipod urununu aratiniz.
         3-cikan elemanlardan random bir elemani Add Wish butonuna tiklayiniz.
         4-Daha sonra WishList e tiklatiniz.
         5-Burada cikan urunle, tiklanan urunun isminin ayni olup olmadigini dogrulayiniz.

         2.Test
         1-WishList i bosaltiniz.
         */
public class _01_WishList extends ParameterDriver {
    @Test
    @Parameters("itemName")
    public void addToWishList(String itemName)  {

        //1. yontem
        WebElement search = driver.findElement(By.name("search"));
        search.sendKeys(itemName);

        WebElement searchButton = driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']"));
        searchButton.click();

//        // 2. yontem  Odev:
//        _04_SearchFunctionality searchItem = new _04_SearchFunctionality(); // 6. gunde yaptigimiz class
//        searchItem.searchFunctionality(itemName); // 6.gun de yaptigimiz class daki metodu cagirdik

        List<WebElement> productList = driver.findElements(By.cssSelector("div[class='caption']>h4"));
        int randNumber = Tools.randomNumberGenerator(productList.size());
        String wishItemName = productList.get(randNumber).getText();

        List<WebElement> searchResultWishList = driver.findElements(By.cssSelector("button[data-original-title='Add to Wish List']"));
        searchResultWishList.get(randNumber).click();


        WebElement wishListLink = driver.findElement(By.id("wishlist-total"));
        wishListLink.click();

        List<WebElement> tableNames = driver.findElements(By.xpath("//tbody//td[2]")); //table[@class ='table table-bordered table-hover']
        System.out.println("wishItemName :"+ wishItemName);
        Tools.listContainsString(tableNames, wishItemName);
    }

    @Test
    public void clearWishList() throws InterruptedException {
        List<WebElement> removeButtonsList = driver.findElements(By.cssSelector("a[data-original-title='Remove']"));
        WebElement removeButtons = driver.findElement(By.cssSelector("a[data-original-title='Remove']"));
        for (WebElement el: removeButtonsList ) {
            driver.findElement(By.cssSelector("a[data-original-title='Remove']")).click();
        }

        String actualMessage = driver.findElement(By.cssSelector("div#content>p")).getText();
        Assert.assertEquals(actualMessage, "Your wish list is empty.");
    }

}
