package Day10_Reports_PageObjectModel;

import Day09_SoftAssertHardAssert_POM._03_PlaceOrderElements;
import Utils.ParameterDriver;
import Utils.Tools;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _03_WishListPOM extends ParameterDriver {

    @Test
    @Parameters("itemText")
    public void addToWishList(String itemText){
        _03_PlaceOrderElements placeOrderElements = new _03_PlaceOrderElements(driver);

        _02_WishListElements wishListElements = new _02_WishListElements(driver);

        placeOrderElements.searchInput.sendKeys(itemText);
        placeOrderElements.searchButton.click();

        int randNumber = Tools.randomNumberGenerator(wishListElements.productList.size());
        String wishItemName = wishListElements.productList.get(randNumber).getText();

        wishListElements.searchResultWishList.get(randNumber).click();

        wishListElements.wishListLink.click();

        Tools.listContainsString(wishListElements.tableNames, wishItemName);
    }

    @Test
    public void clearWishList(){
        _02_WishListElements wishListElements = new _02_WishListElements(driver);
       while(wishListElements.removeButtonsList.size()!=0){
           wishListElements.removeButtons.click();
       }
       Assert.assertEquals(wishListElements.actualEmptyMessage.getText(), "Your wish list is empty.");
    }

    @Test
    public void failGenerator(){
        System.out.println("Merhaba Dunya");
        Assert.fail();
    }
}
