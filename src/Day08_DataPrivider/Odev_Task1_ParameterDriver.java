package Day08_DataPrivider;

import Utils.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class Odev_Task1_ParameterDriver extends ParameterDriver {
    /**
     * Daha önceki derslerde yaptğımı Search fonksiyonunu
     * Mac ve Laptop için Dataprovider ile yapınız.
     * Fonksiyonu aynen kopyalabilirsiniz.
     *
     * 1- _04_Task1   deki testi ParameterDriver ile yapınız.
     */

    @Test(dataProvider = "getData")
    public void searchFunctionality(String searchText){
        WebElement search = driver.findElement(By.name("search"));
        search.clear();
        search.sendKeys(searchText);

        WebElement searchButton = driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']"));
        searchButton.click();

        List<WebElement> items = driver.findElements(By.cssSelector("h4>a"));

        for (WebElement el:items ) {
            System.out.println(el.getText());
            Assert.assertTrue(el.getText().toLowerCase().contains(searchText.toLowerCase()));
        }
    }
@DataProvider
    public Object[] getData(){ // DataProvider olarak kullanılcak metodun tipi Object olmak zorunda.

        Object[] data={
                "mac",
                "samsung",
                "canon",
                "Tab"
        };

        return data;
    }
}