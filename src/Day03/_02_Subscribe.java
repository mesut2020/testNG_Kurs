package Day03;

import Utils.MethodDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_Subscribe extends MethodDriver {



    @Test
    void subscribeFunctionYes(){
        WebElement subscribeButton = driver.findElement(By.xpath(" //a[text()='Subscribe / unsubscribe to newsletter']"));
        subscribeButton.click();

        WebElement yesRadioButton = driver.findElement(By.cssSelector(" input[value='1']"));
        yesRadioButton.click();

        WebElement continueButton = driver.findElement(By.cssSelector(" input[value='Continue']"));
        continueButton.click();

        Tools.successMessageValidation(driver);

    }

    @Test (priority = 1)
    void subscribeFunctionNo(){
        WebElement subscribeButton = driver.findElement(By.xpath(" //a[text()='Subscribe / unsubscribe to newsletter']"));
        subscribeButton.click();

        WebElement noRadioButton = driver.findElement(By.cssSelector(" input[value='0']"));
        noRadioButton.click();

        WebElement continueButton = driver.findElement(By.cssSelector(" input[value='Continue']"));
        continueButton.click();

        Tools.successMessageValidation(driver);
    }

    @Test
    void subscribeFunctionForBoth(){
        WebElement subscribeButton = driver.findElement(By.xpath(" //a[text()='Subscribe / unsubscribe to newsletter']"));
        subscribeButton.click();

        WebElement yesRadioButton = driver.findElement(By.cssSelector(" input[value='1']"));
        WebElement noRadioButton = driver.findElement(By.cssSelector(" input[value='0']"));

        if(yesRadioButton.isSelected()) noRadioButton.click();
        else yesRadioButton.click();

        WebElement continueButton = driver.findElement(By.cssSelector(" input[value='Continue']"));
        continueButton.click();

        Tools.successMessageValidation(driver);

    }

}
