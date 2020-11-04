package Challenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;


public class AutoTraderPOM extends BaseDriver{

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

        AutoTrader_Elements autoTrader_elements = new AutoTrader_Elements(driver);

        if(autoTrader_elements.browseByMake.isEnabled()) System.out.println(autoTrader_elements.browseByMake.getText() + " is present...");
        else {driver.manage().deleteAllCookies();driver.navigate().refresh(); driver.manage().deleteAllCookies();}
         if(autoTrader_elements.browseByStyle.isEnabled()) System.out.println(autoTrader_elements.browseByStyle.getText() + " is present...");
         else {driver.manage().deleteAllCookies();driver.navigate().refresh(); driver.manage().deleteAllCookies();}
        if(autoTrader_elements.advancedSearch.isEnabled()) System.out.println(autoTrader_elements.advancedSearch.getText() + " is present...");
        else {driver.manage().deleteAllCookies();driver.navigate().refresh(); driver.manage().deleteAllCookies();}
        if(autoTrader_elements.searchButton.isEnabled()) System.out.println(autoTrader_elements.searchButton.getText() + " button is present...");
        else {driver.manage().deleteAllCookies();driver.navigate().refresh(); driver.manage().deleteAllCookies();}

        if(autoTrader_elements.dropDownMake.isEnabled()) System.out.println("DropDowns Make is present...");
        else {driver.manage().deleteAllCookies();driver.navigate().refresh(); driver.manage().deleteAllCookies();}

        if(autoTrader_elements.dropDownModel.getText().contains("Any Model")) System.out.println("DropDowns Model is present...");
        else {driver.manage().deleteAllCookies();driver.navigate().refresh(); driver.manage().deleteAllCookies();}

    }
    @Parameters({"makeAuto","startYear", "endYear"})
    @Test(priority = 2)
        public  void advancedSearchTest( String makeAuto, String startYear, String endYear) {
/**
 * Click on the ‘Advanced Search’ link on the home page and do the following:
 * o Enter 30004 in the ‘Zip code’ text box
 * o Select the ‘Certified’ check box under ‘Condition’
 * o Select the ‘Convertible’ check box under ‘Style’
 * o Update the ‘Year’ drop down menus as follows: select 2017 as From year and select 2020 as To year
 * o Select Make as ‘BMW’ under Make, Model & Trim section
 * • Click the button ‘Search’ at the bottom of the page
 */        AutoTrader_Elements autoTrader_elements = new AutoTrader_Elements(driver);

            driver.manage().deleteAllCookies();
            autoTrader_elements.advancedSearch.click();
            autoTrader_elements.zipCode.sendKeys("30004");
            autoTrader_elements. certified.click();
          // Coupe yapinca 14 tane buldu...
            autoTrader_elements.convertible.click();
            Select startYearMenu = new Select(autoTrader_elements.startYear);
            startYearMenu.selectByVisibleText(startYear);

            Select endYearMenu = new Select(autoTrader_elements.endYear);
            endYearMenu.selectByVisibleText(endYear);

            Select makeMenu = new Select(autoTrader_elements.make);
            makeMenu.selectByVisibleText(makeAuto);

            driver.manage().deleteAllCookies(); // search butonuna basmadan once COOKIES leri temizle
            autoTrader_elements.searchButton.click();
            //wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

            /**
             * You will see some results/listings in the next page
             * • Assert that you see only BMW cars in the results page
             * • Log to the console, the total number of cars/listings you see in the results page
             * */
            for (WebElement el : autoTrader_elements.searchList ) {
                Assert.assertTrue(el.getText().contains(makeAuto));
                System.out.println(el.getText());
            }
            System.out.println("the total number of cars/listings:" + autoTrader_elements.searchList.size());

        }
}
