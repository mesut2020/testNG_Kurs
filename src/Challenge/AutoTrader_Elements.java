package Challenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class AutoTrader_Elements {

    public AutoTrader_Elements (WebDriver driver){

        PageFactory.initElements(driver, this);
    }
    @FindBy(css="button[data-qaid='lnk-browseByMake']")
    public WebElement browseByMake;

    @FindBy(css="button[data-qaid='lnk-browseByStyle']")
    public WebElement browseByStyle;

    @FindBy(css="a[data-qaid='adv_srch']")
    public WebElement advancedSearch;

    @FindBy(css="button[type='submit']")   // iki tane var
    public WebElement searchButton;

    @FindBy(id="makeCode")
    public WebElement dropDownMake;

    @FindBy(id="ModelCode")
    public WebElement dropDownModel;

    @FindBy(id="zip")
    public WebElement zipCode;

    @FindBy(xpath="//div[text()='Certified']")
    public WebElement certified;

    @FindBy(xpath="//div[text()='Convertible']")
    public WebElement convertible;

    @FindBy(name="startYear")
    public WebElement startYear;

    @FindBy(name="endYear")
    public WebElement endYear;

    @FindBy(name="makeFilter0")
    public WebElement make;

    @FindAll(
            {
                    @FindBy(css="a>h2")
            }
    )
            public List<WebElement>  searchList;



}
