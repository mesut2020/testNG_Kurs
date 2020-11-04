package Day09_SoftAssertHardAssert_POM;

import Utils.MethodDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_PlaceOrderPOM extends MethodDriver {
/* POM (Page Object Model) avantajları
   1- Bütün sayfalada isimleri aynı olan elemanlar için 1 tanımlama yeterli oluyor.
      Böylece tanımlanan elemanlar tekrar kullanılabilir yani Reusable oluyor.
   2- Kodun içerisinden HTML kodları ayrıldığından kod okunabilirliği artıyor.
   3- Developer locatorlarda bir değişiklik yaptığı zaman, asıl kodla hiç bir şekilde
      uğraşmak zorunda kalmıyoruz, sadece gidip locator ı değiştiriyoruz.
 */

    @Test
    public void proceedToCheckOut(){
        _03_PlaceOrderElements placeOrderElements = new _03_PlaceOrderElements(driver);

        placeOrderElements.searchInput.sendKeys("ipod");
        placeOrderElements.searchButton.click();
        placeOrderElements.addToCard1.click();
        placeOrderElements.shoppingCart.click();
        placeOrderElements.checkoutButton.click();

        // wait.until(ExpectedConditions.elementToBeClickable(placeOrderElements.continu1)).click();
        placeOrderElements.continueBillingdetails.click();
        placeOrderElements.continueDeliverymethods.click();
        placeOrderElements.continueShippingAddress.click();
        placeOrderElements.continueShippingMethod.click();
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderElements.checkBox)).click();
        placeOrderElements.continuePaymentmethod.click();
        placeOrderElements.confirmButton.click();

        wait.until(ExpectedConditions.urlContains("success"));

        Assert.assertEquals(placeOrderElements.ekranMesaji.getText(), "Your order has been placed!");



    }
}
