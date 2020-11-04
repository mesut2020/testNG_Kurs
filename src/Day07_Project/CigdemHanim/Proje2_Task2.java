package Day07_Project.CigdemHanim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Proje2_Task2 extends LoginClass {

    @Test
    public void Task2() {


        WebElement computersLink = driver.findElement(By.xpath("(//li[@class='inactive']/a)[2]"));
        // By.xpath("//li[@class='inactive'][2]/a")
        computersLink.click();

        WebElement desktopsLink = driver.findElement(By.xpath("(//ul[@class='sublist']/li/a)[1]"));
        desktopsLink.click();

        WebElement expensiveComputerAddCart = driver.findElement(By.cssSelector("input[onclick*='catalog/74']"));
        expensiveComputerAddCart.click();

        WebElement processorFast = driver.findElement(By.cssSelector("input[value='82']"));
        processorFast.click();

        WebElement ram8gb = driver.findElement(By.cssSelector("input[value='85']"));
        ram8gb.click();

        WebElement hdd_400gb = driver.findElement(By.cssSelector("input[value='87']"));
        hdd_400gb.click();

        WebElement softwareOtherSuit = driver.findElement(By.cssSelector("input[value='90']"));
        softwareOtherSuit.click();

        WebElement addBtn = driver.findElement(By.id("add-to-cart-button-74"));
        addBtn.click();

        WebElement shoppingCart = driver.findElement(By.xpath("//a[text()='shopping cart']"));
        shoppingCart.click();

        WebElement checkBox = driver.findElement(By.id("termsofservice"));
        checkBox.click();

        WebElement checkOut = driver.findElement(By.id("checkout"));
        checkOut.click();

//        WebElement newAdress = driver.findElement(By.id("billing-address-select"));
//        newAdress.sendKeys("New Address");

        WebElement city = driver.findElement(By.id("BillingNewAddress_City"));


        if (city.isDisplayed()) {

            WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
//            List<WebElement> countryList = driver.findElements(By.cssSelector("select[id='BillingNewAddress_CountryId']>option"));

            Select select = new Select(country);
            select.selectByIndex((int) (Math.random() * select.getOptions().size() - 1) + 1);

            city.sendKeys("Lvrksn");

            WebElement address1 = driver.findElement(By.id("BillingNewAddress_Address1"));
            address1.sendKeys("NRW");

            WebElement address2 = driver.findElement(By.id("BillingNewAddress_Address2"));
            address2.sendKeys("Lvrksn");

            WebElement postalCode = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
            postalCode.sendKeys("573468");

            WebElement phoneNumber = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
            phoneNumber.sendKeys("727462964");

        }

        WebElement billigAddress = driver.findElement(By.cssSelector("input[onclick='Billing.save()']"));
        billigAddress.click();

        WebElement shippingAddress = driver.findElement(By.cssSelector("input[onclick='Shipping.save()']"));
        shippingAddress.click();

        WebElement shippingMethod = driver.findElement(By.cssSelector("input[onclick='ShippingMethod.save()']"));
        shippingMethod.click();

        WebElement cashOnDelivery = driver.findElement(By.id("paymentmethod_0"));
        cashOnDelivery.click();

        WebElement patmentMethod = driver.findElement(By.cssSelector("input[onclick='PaymentMethod.save()']"));
        patmentMethod.click();

        WebElement paymentInfo = driver.findElement(By.cssSelector("input[onclick='PaymentInfo.save()']"));
        paymentInfo.click();

        WebElement confirmBtn = driver.findElement(By.cssSelector("input[onclick='ConfirmOrder.save()']"));
        confirmBtn.click();

        String confirmMessage = driver.findElement(By.cssSelector("div[class='title']")).getText();

        Assert.assertTrue(confirmMessage.contains("successfully"));


    }
}
