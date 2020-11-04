package Day09_SoftAssertHardAssert_POM;

import Utils.MethodDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Senaryo:
 * Siteyi aciniz.
 * Sitede "ipod" kelimesini aratiniz
 * Cikan sonuclardan ilkini sepete atiniz
 * Sepete tiklatiniz
 * Checkout yapiniz
 * Continue butonlarina tiklatip bilgileri giriniz.
 * En son confirm ile siparis verdiginizi dogrulayiniz...
 * En son cikan test ile dogrulamayi yap...
 */

public class _02_PlaceOrder extends MethodDriver {

    @Test
    public void proceedToCheckOut(){
         WebElement search = driver.findElement(By.name("search"));
         search.sendKeys("ipod");

         WebElement searchButton = driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']"));
         searchButton.click();

        WebElement addToCard1 = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
        addToCard1.click();

        WebElement shoppingCart = driver.findElement(By.xpath("//*[text()='Shopping Cart']"));
        shoppingCart.click();

        WebElement checkoutButton = driver.findElement(By.xpath("//*[text()='Checkout']"));
        checkoutButton.click();

        WebElement continueBillingdetails = driver.findElement(By.id("button-payment-address"));
        continueBillingdetails.click();

        WebElement continueDeliverydetails = driver.findElement(By.id("button-shipping-address"));
        continueDeliverydetails.click();

        WebElement continueDeliverymethods = driver.findElement(By.id("collapse-shipping-address"));
        continueDeliverymethods.click();

        WebElement continueShippingMethod = driver.findElement(By.id("button-shipping-method"));
        continueShippingMethod.click();

        WebElement checkBox =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));
        checkBox.click();

        WebElement continuePaymentmethod = driver.findElement(By.id("button-payment-method"));
        continuePaymentmethod.click();

        WebElement confirmButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-confirm")));
        confirmButton.click();

        wait.until(ExpectedConditions.urlContains("success"));

        WebElement mesaj = driver.findElement(By.xpath("//div[@id='content']/h1"));
        String ekranMesaji = mesaj.getText();

        Assert.assertEquals(ekranMesaji, "Your order has been placed!");

    }
}
