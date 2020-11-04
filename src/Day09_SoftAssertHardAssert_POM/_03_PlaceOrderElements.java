package Day09_SoftAssertHardAssert_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _03_PlaceOrderElements {
    // Bu sayfadaki bütün elemenalrın driverlar bağlantısı gerekiyor
    // bunun için aşağıdaki consructor eklendi ve için PageFactory ile
    // driver üzerinden bu (this) sayfadaki bütün elemnalar ilşkilendirildi.
    // Böylece Sayfada dan nesne türetildiği zaman değil, kullanıldığı
    // anda elemanların bulunması aktif oluyor.Bu yöntemle bütün sayfalarda
    // aynı isimde elemanlar var ise buradaki tanımlama hepsi için geçerli hale
    // gelmiş oluyor. buna yapıya Page Object Model (POM) adı veriliyor.

    public _03_PlaceOrderElements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="input[name='search']")
    public WebElement searchInput;

    @FindBy(css = "button[class='btn btn-default btn-lg']")
    public WebElement searchButton;

    @FindBy(xpath = "(//span[text()='Add to Cart'])[1]")
    public WebElement addToCard1;

    @FindBy(xpath = "//*[text()='Shopping Cart']")
    public WebElement shoppingCart;

    @FindBy(xpath = "//*[text()='Checkout']")
    public WebElement checkoutButton;

    @FindBy(id = "button-payment-address")
    public WebElement continueBillingdetails;

    @FindBy(id = "button-shipping-address")
    public WebElement continueDeliverymethods;

    @FindBy(id = "collapse-shipping-address")
    public WebElement continueShippingAddress;

    @FindBy(id = "button-shipping-method")
    public WebElement continueShippingMethod;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkBox;

    @FindBy(id = "button-payment-method")
    public WebElement continuePaymentmethod;

    @FindBy(id = "button-confirm")
    public WebElement confirmButton;

    @FindBy(xpath = "//div[@id='content']/h1")
    public WebElement ekranMesaji;

}
