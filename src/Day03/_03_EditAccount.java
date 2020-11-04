package Day03;

import Utils.MethodDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_EditAccount extends MethodDriver {
    /*
      1- Siteyi açınız.
      2- Edit Account a tıklatınız.
      3- Yeni isim ve soyisim göndererek Continue yapınız.     firstname    lastname
      4- İşlem sonucunu kontrol ediniz.
     */

    @Test
    void EditAccount(){
        accountEdit("ismet","Yilmaz");
        accountEdit("asd123","asd");

    }
    public void accountEdit(String name, String surName) {
        WebElement editAccount = driver.findElement(By.xpath(" //a[text()='Edit your account information']"));
        editAccount.click();

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.clear();
        firstName.sendKeys(name);

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.clear();
        lastName.sendKeys(surName);

        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();

        Tools.successMessageValidation(driver);

    }
}
