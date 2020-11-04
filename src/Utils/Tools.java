package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class Tools {
    public static void listContainsString(List<WebElement> menuActualList, String expextedString) {
        boolean found = false;
        for (WebElement el : menuActualList) {

            if(el.getText().contains(expextedString)) {
                found = true;
                break;
            }
        }
            Assert.assertTrue(found,"aranan eleman bulunamadi");
    }

    public static void compareToList(List<WebElement> menuActualList, List<String> menuExpectedList) {
        int i = 0;
        for (WebElement el : menuActualList) {
            Assert.assertEquals(el.getText(), menuExpectedList.get(i++));
//            if (el.getText()!=menuExpectedList.get(i++))
//                System.out.println("Menu bulunamadı.");
        }
    }

    public static void successMessageValidation(WebDriver driver) {
        WebElement success = driver.findElement(By.cssSelector("div.alert.alert-success"));
        Assert.assertTrue(success.getText().contains("successfully"));
    }

    public static void selectByIndex(WebElement dropDownName) {
        Select select = new Select(dropDownName);
        select.selectByIndex(randomNumberGenerator(select.getOptions().size()));

    }

    public static int randomNumberGenerator(int max) {
        Random random = new Random();
        return random.nextInt(max - 1) + 1;
    }

}
