package Day07_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Task2 {
    /*TASK 2
        - Bu siteye gidiniz.  "http://demowebshop.tricentis.com/"
        - Sağ üstteki "Log in" yazısına tıklayınız.
        - "email" ve "password" girip "log in"e tıklayınız.


        - Soldaki "categories" başlığının altındaki "Computers"a tıklayınız.
        - Soldaki yerde "Computers"ın altında "Desktops"a tıklayınız.
        - "BUILD YOUR OWN EXPENSIVE COMPUTER" yazan bilgisayarın altındaki "Add to cart" buttonuna tıklayınız.
        - Processor kısmında Fast'i seçin.
        - Ram kısmından 8GB'yi seçin.
        - HDD kısmından 400 GB'yi seçin.
        - Software kısmından Other Office Suite'i seçinç
        - Add to Cart buttonuna tıklayınız.
        - En yukarıdan Shopping Cart'a tıklayınız.
        - I agree with the terms checkbox'una tıklayınız.
        - Checkout buttonuna tıklayınız.
        - Billing Address formunu doldurun.
        - Formu doldurduktan sonra Continue buttonuna tıklayınız.
        - Shipping Address penceresindeki Continue Buttonuna tıklayınız.
        - Shipping Method penceresindeki Continue Buttonuna tıklayınız.
        - Cash On Delivery'yi seçip Continue buttonuna tıklayınız.
        - Payment Information penceresindeki Continue Buttonuna tıklayınız.
        - Confirm Order penceresindeki Continue Buttonuna tıklayınız.
        - Ekranda yazan mesajı doğrulayınız.*/

    public static void main(String[] args) throws InterruptedException {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); // Konsoldaki kirmizi yazilari gostermez
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);  // sayfanin yuklenmesini bekler
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // sayfadaki butun elemeanlarin yuklenmesini max. 30sn bekler...

        driver.manage().deleteAllCookies();

//        - Bu siteye gidiniz.  "http://demowebshop.tricentis.com/"
//                - Sağ üstteki "Log in" yazısına tıklayınız.
//        - "email" ve "password" girip "log in"e tıklayınız.

        driver.get("http://demowebshop.tricentis.com/");

        String homePageID = driver.getWindowHandle();

        WebElement login= driver.findElement(By.cssSelector("a.ico-login"));
        login.click();

        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("med@tset.ng");

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("test1234");

        WebElement loginButton = driver.findElement(By.cssSelector("input[class='button-1 login-button']"));
        loginButton.click();
//        - Soldaki "categories" başlığının altındaki "Computers"a tıklayınız.
        WebElement computers = driver.findElement(By.xpath("(//li[@class='inactive']/a)[2]"));
        computers.click();
//        - Soldaki yerde "Computers"ın altında "Desktops"a tıklayınız.
        WebElement desktops = driver.findElement(By.xpath("(//li[@class='inactive']/a)[2]"));
        desktops.click();
//        - "BUILD YOUR OWN EXPENSIVE COMPUTER" yazan bilgisayarın altındaki "Add to cart" buttonuna tıklayınız.
        WebElement addToCart = driver.findElement(By.cssSelector("input[onclick*='catalog/74']"));
        addToCart.click();
//        - Processor kısmında Fast'i seçin.
//                - Ram kısmından 8GB'yi seçin.
//                - HDD kısmından 400 GB'yi seçin.
//                - Software kısmından Other Office Suite'i seçinç
//                - Add to Cart buttonuna tıklayınız.
        WebElement processorFast = driver.findElement(By.cssSelector("input#product_attribute_74_5_26_82"));
        processorFast.click();
        WebElement ram8GB = driver.findElement(By.cssSelector("input#product_attribute_74_6_27_85"));
        ram8GB.click();
        WebElement hdd400GB = driver.findElement(By.cssSelector("input#product_attribute_74_3_28_87"));
        hdd400GB.click();
        WebElement softwareOther = driver.findElement(By.cssSelector("input#product_attribute_74_8_29_90"));
        softwareOther.click();
        WebElement addToCart2 = driver.findElement(By.cssSelector("input#add-to-cart-button-74"));
        addToCart2.click();
//        - En yukarıdan Shopping Cart'a tıklayınız.
//                - I agree with the terms checkbox'una tıklayınız.
//                - Checkout buttonuna tıklayınız.
        WebElement shoppingCart = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
        shoppingCart.click();
        WebElement agreeCheckBox = driver.findElement(By.cssSelector("input#termsofservice"));
        agreeCheckBox.click();
        WebElement checkOutButton = driver.findElement(By.cssSelector("button#checkout"));
        checkOutButton.click();
//        - Billing Address formunu doldurun.
//                - Formu doldurduktan sonra Continue buttonuna tıklayınız.
        WebElement city = driver.findElement(By.id("BillingNewAddress_City"));

        if(city.isDisplayed()) {

            Select countries = new Select(driver.findElement(By.cssSelector("select#BillingNewAddress_CountryId")));
            countries.selectByValue("35"); // germany
            System.out.println(countries.getOptions().size());

            city.sendKeys("Rudesheim");

            WebElement address1 = driver.findElement(By.id("BillingNewAddress_Address1"));
            address1.sendKeys("Geisenheimer Str 22");

            WebElement zipCode = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
            zipCode.sendKeys("65385");

            WebElement phoneNumber = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
            phoneNumber.sendKeys("01233224455");
        }

        WebElement continueForm = driver.findElement(By.cssSelector("input[onclick='Billing.save()']"));
        continueForm.click();
//                - Shipping Address penceresindeki Continue Buttonuna tıklayınız.
        WebElement continueShippingAddress = driver.findElement(By.cssSelector("input[onclick='Shipping.save()']"));
        continueShippingAddress.click();
//                - Shipping Method penceresindeki Continue Buttonuna tıklayınız.
        WebElement continueShippingMethod = driver.findElement(By.cssSelector("input[onclick='ShippingMethod.save()']"));
        continueShippingMethod.click();
//                - Cash On Delivery'yi seçip Continue buttonuna tıklayınız.
        WebElement cashOnDelivery = driver.findElement(By.id("paymentmethod_0"));
        cashOnDelivery.click();
        WebElement continuePaymentMethod = driver.findElement(By.cssSelector("input[onclick='PaymentMethod.save()']"));
        continuePaymentMethod.click();
//                - Payment Information penceresindeki Continue Buttonuna tıklayınız.
        WebElement continuePaymentInfo = driver.findElement(By.cssSelector("input[onclick='PaymentInfo.save()']"));
        continuePaymentInfo.click();
//                - Confirm Order penceresindeki Continue Buttonuna tıklayınız.
        WebElement continueConfirmOrder = driver.findElement(By.cssSelector("input[onclick='ConfirmOrder.save()']"));
        continueConfirmOrder.click();
//                - Ekranda yazan mesajı doğrulayınız.*/
        String actualSuccessMessage = driver.findElement(By.cssSelector("div.title")).getText();

        Assert.assertTrue(actualSuccessMessage.contains("successfully"));

        Thread.sleep(5000);
        driver.quit();

    }
}
