package Day04_Dependency;

import Utils.MethodDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

public class _02_AddressFunctionality extends MethodDriver {

    @Test
    void addAddress() throws InterruptedException {

        WebElement addressBookButton = driver.findElement(By.linkText("Address Book"));
        addressBookButton.click();

        WebElement newAddressButton = driver.findElement(By.linkText("New Address"));
        newAddressButton.click();

        WebElement inputFirstName = driver.findElement(By.id("input-firstname"));
        inputFirstName.sendKeys("ahmet");

        WebElement inputLastName = driver.findElement(By.id("input-lastname"));
        inputLastName.sendKeys("kaya");

        WebElement inputCompany = driver.findElement(By.id("input-company"));
        inputCompany.sendKeys("Techno Study");

        WebElement inputAddress1 = driver.findElement(By.id("input-address-1"));
        inputAddress1.sendKeys("Gesineheimer Str 2");

        WebElement inputAddress2 = driver.findElement(By.id("input-address-2"));
        inputAddress2.sendKeys("Hessen");

        WebElement inputCity = driver.findElement(By.id("input-city"));
        inputCity.sendKeys("Rudesheim am Rhein");

        WebElement inputPostCode = driver.findElement(By.id("input-postcode"));
        inputPostCode.sendKeys("65385");


        WebElement inputCountry = driver.findElement(By.id("input-country"));

        Tools.selectByIndex(inputCountry);
        //By locaterState = By.cssSelector("select[id='input-zone']>option");
        // wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locaterState, 2));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fa fa-circle-o-notch fa-spin"))); // ulke secildikten sonra donen halkanin class adi
        //Thread.sleep(1000);

        WebElement regionState = driver.findElement(By.id("input-zone"));
        Tools.selectByIndex(regionState);

//        WebElement radioNo = driver.findElement(By.cssSelector("input[value='0']"));
//        radioNo.click();
//        WebElement radioYes = driver.findElement(By.cssSelector("input[value='1']"));
//        radioYes.click();

        WebElement continueButton = driver.findElement(By.xpath("//input[@value = 'Continue']"));
        continueButton.click();

        Tools.successMessageValidation(driver);
    }


    @Test(dependsOnMethods = {"addAddress"})
    void editLastAddress(){
        List<WebElement> editButtons = driver.findElements(By.xpath("//a[text()='Edit']"));
        editButtons.get(editButtons.size()-1).click();

        WebElement inputFirstName = driver.findElement(By.id("input-firstname"));
        inputFirstName.clear();
        inputFirstName.sendKeys("mehmet");

        WebElement inputLastName = driver.findElement(By.id("input-lastname"));
        inputLastName.clear();
        inputLastName.sendKeys("kaya");

        WebElement continueButton = driver.findElement(By.xpath("//input[@value = 'Continue']"));
        continueButton.click();

        Tools.successMessageValidation(driver);
    }

    @Test(dependsOnMethods = {"editLastAddress"})
    void deleteLastAddress(){
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//a[text()='Delete']"));
        deleteButtons.get(deleteButtons.size()-1).click();

       Tools.successMessageValidation(driver);
    }

    @Test(dependsOnMethods = {"deleteLastAddress"})
    void deleteAllAddress() throws InterruptedException {
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//a[text()='Delete']"));
        for (WebElement e : deleteButtons) {
            driver.findElement(By.xpath("//a[text()='Delete']")).click();
        }
        Tools.successMessageValidation(driver);
    }

}
