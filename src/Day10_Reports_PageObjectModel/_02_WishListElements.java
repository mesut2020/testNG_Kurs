package Day10_Reports_PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _02_WishListElements {

    public _02_WishListElements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    // FindAll:   FindBy in buldugu butun elemanlari al
    // birden fazla findBy in buldugu elemanlari tek bir listeye atabiliyoruz...
    @FindAll(      {
            @FindBy(css = "div[class='caption']>h4")
            //@FindBy(css = "????????????????"),
                         }
    )
    public List<WebElement> productList;

    @FindAll(      {
            @FindBy(css = "button[data-original-title='Add to Wish List']")
        }
    )
    public List<WebElement> searchResultWishList;

    @FindBy(id="wishlist-total")
    public WebElement wishListLink;

    @FindAll(      {
            @FindBy(xpath = "//tbody//td[2]")
        }
    )
    public List<WebElement> tableNames;

    @FindAll(
            {
                    @FindBy(css="a[data-original-title='Remove']")
            }
    )
    public List<WebElement> removeButtonsList;

    @FindBy(css="a[data-original-title='Remove']")
    public WebElement removeButtons;

    @FindBy(css="div#content>p")
    public WebElement actualEmptyMessage;
}
