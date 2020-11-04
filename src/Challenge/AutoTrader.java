package Challenge;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class AutoTrader extends BaseDriver{

    @Test (priority = 1)
    public  void presentElements() {

        /**
         * On the home page, verify that the following types of elements are present:
         * o Links: Browse by Make, Browse by Style, Advanced Search
         * o Buttons: Search
         * o Drop downs: Make, Model
         */
        driver.manage().deleteAllCookies();
//        driver.navigate().refresh();
//        driver.manage().deleteAllCookies();

        WebElement browseByMake = driver.findElement(By.cssSelector("button[data-qaid='lnk-browseByMake']"));
        if(browseByMake.isEnabled()) System.out.println(browseByMake.getText() + " is present...");
        WebElement browseByStyle = driver.findElement(By.cssSelector("button[data-qaid='lnk-browseByStyle']"));
        if(browseByStyle.isEnabled()) System.out.println(browseByStyle.getText() + " is present...");
        WebElement advancedSearch = driver.findElement(By.cssSelector("a[data-qaid='adv_srch']"));
        if(advancedSearch.isEnabled()) System.out.println(advancedSearch.getText() + " is present...");
        WebElement searchButton = driver.findElement(By.id("search"));
        if(searchButton.isEnabled()) System.out.println(searchButton.getText() + " button is present...");
        WebElement dropDownMake = driver.findElement(By.id("makeCode"));
        if(dropDownMake.isEnabled()) System.out.println("DropDowns Make is present...");
        WebElement dropDownModel = driver.findElement(By.id("ModelCode"));
        if(dropDownModel.getText().contains("Any Model")) System.out.println("DropDowns Model is present...");
    }
        @Test(priority = 2)
        public  void advancedSearchTest() {
/**
 * Click on the ‘Advanced Search’ link on the home page and do the following:
 * o Enter 30004 in the ‘Zip code’ text box
 * o Select the ‘Certified’ check box under ‘Condition’
 * o Select the ‘Convertible’ check box under ‘Style’
 * o Update the ‘Year’ drop down menus as follows: select 2017 as From year and select 2020 as To year
 * o Select Make as ‘BMW’ under Make, Model & Trim section
 * • Click the button ‘Search’ at the bottom of the page
 */
            driver.manage().deleteAllCookies();
            WebElement advancedSearch = driver.findElement(By.cssSelector("a[data-qaid='adv_srch']"));
            advancedSearch.click();

            WebElement zipCode = driver.findElement(By.id("zip"));
            driver.findElement(By.id("zip")).sendKeys("30004");

            WebElement certified = driver.findElement(By.xpath("//div[text()='Certified']"));
            certified.click();

            WebElement convertible = driver.findElement(By.xpath("//div[text()='Convertible']"));  // Coupe yapinca 14 tane buldu...
            convertible.click();

            WebElement startYear = driver.findElement(By.name("startYear"));
            Select startYearMenu = new Select(startYear);
            startYearMenu.selectByVisibleText("2017");

            WebElement endYear = driver.findElement(By.name("endYear"));
            Select endYearMenu = new Select(endYear);
            endYearMenu.selectByVisibleText("2020");

            WebElement make = driver.findElement(By.name("makeFilter0"));
            Select makeMenu = new Select(make);
            String searchByMake = "BMW";
            makeMenu.selectByVisibleText(searchByMake);

            driver.manage().deleteAllCookies(); // search butonuna basmadan once COOKIES leri temizle

            WebElement searchButton = driver.findElement(By.cssSelector("button[type='submit']"));
            searchButton.click();
            //wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

            /**
             * You will see some results/listings in the next page
             * • Assert that you see only BMW cars in the results page
             * • Log to the console, the total number of cars/listings you see in the results page
             * */

            List<WebElement> searchList = driver.findElements(By.cssSelector("a>h2"));
            for (WebElement el : searchList) {
                Assert.assertTrue(el.getText().contains(searchByMake));
                System.out.println(el.getText());
            }
            System.out.println("the total number of cars/listings:" + searchList.size());

        }
}
