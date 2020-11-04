package Day03;

import Utils.MethodDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class _01_ValidateMenu extends MethodDriver {

  /*
        Senaryo;
        1- Siteyi açınız
        2- Top Menudeki menu elemanlarının olduğunu doğrulayınız.
     */


    @Test
    void menuValidation()
    {
       List<String> menuExpectedList = new ArrayList<>(List.of("Desktops","Laptops & Notebooks" ,"Components", "Tablets","Software" , "Phones & PDAs" , "Cameras" ,"MP3 Players"));
        System.out.println(menuExpectedList);

        //List<WebElement> menuActualList = driver.findElements(By.xpath("//li[@class='dropdown']"));
        By menu=By.xpath("//ul[@class='nav navbar-nav']/li");  // Değişken tipi By
        List<WebElement> menuActualList = driver.findElements(menu);

        Tools.compareToList(menuActualList, menuExpectedList);

    }

}



