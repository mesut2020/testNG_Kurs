package Day12_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TestNGProjectElements {

    public TestNGProjectElements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="a.ico-login")
    public WebElement login;

    @FindBy(id="Email")
    public WebElement email;

    @FindBy(id="Password")
    public WebElement passwordElement;

    @FindBy(css="input[class='button-1 login-button']")
    public WebElement loginButton;
    /*********************************/
    @FindBy(xpath="//a[text()='Contact us']")
    public WebElement contactUs;

    @FindBy(css=".enquiry")
    public WebElement enquiryTextBox;

    @FindBy(css="input[value='Submit']")
    public WebElement submitButton;

    @FindBy(css="div.result")     //Your enquiry has been successfully sent to the store owner.
    public WebElement submitMessage;

    /**************************************/

    @FindBy(css="a[href='/apparel-shoes']")
    public WebElement apparelShoesLink;

    @FindBy(xpath="//a[text()='Blue and green Sneaker']")
    public WebElement blueAndGreenSneaker;

    @FindBy(css="input[value='Add to wishlist']")
    public WebElement addToWishList;

    //@FindBy(xpath="(//div[@class='details']/h2/a)[1]")
//    @FindBy(linkText="50's Rockabilly Polka Dot Top JR Plus Size")
//    @FindBy(partialLinkText="Rockabilly Polka Dot")
//    @FindBy(partialLinkText="50's Rockabilly")
    @FindBy(css="a:contains('50's Rockabilly')")
    public WebElement RockabillyPolkaDot;

    @FindBy(css=".ico-wishlist")
    public WebElement wishList;

    @FindAll(
            {
                    @FindBy(css="td.product>a")
            }
    )
    public List<WebElement> actualProductLists;


}
