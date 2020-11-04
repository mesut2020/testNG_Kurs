package Day07_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); // Konsoldaki kirmizi yazilari gostermez
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);  // sayfanin yuklenmesini bekler
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // sayfadaki butun elemeanlarin yuklenmesini max. 30sn bekler...

        driver.manage().deleteAllCookies();

        /////////////////
        /* TASK 1
                - Bu siteye gidiniz.  "http://demowebshop.tricentis.com/"
                - Sağ üstteki "Log in" yazısına tıklayınız.
                - "email" ve "password" girip "log in"e tıklayınız.
                - Sayfanın en altındaki "Follow Us" başlığındaki "Facebook" buttonuna tıklayınız.
                    Sonrasında açılan pencerenin URL'indeki "facebook" kelimesini doğrulayınız.
                - Ana sayfaya geri dönün.
                - "Information" başlığı altındaki "Contact Us" buttonuna tıklayınız.
                - "Enquiry" yazan yerin altındaki text kutusuna mesajınızı yazıp "submit" butonuna tıklayınız.
                - Sonrasında çıkan yazıyı dpğrulayınız. */

        driver.get("http://demowebshop.tricentis.com/");

        String homePageID = driver.getWindowHandle();

        WebElement login= driver.findElement(By.cssSelector("a.ico-login"));
        login.click();

        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("ahm@kaya.com");

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("ahmet1234");

        WebElement loginButton = driver.findElement(By.cssSelector("input[class='button-1 login-button']"));
       loginButton.click();

//        - Sayfanın en altındaki "Follow Us" başlığındaki "Facebook" buttonuna tıklayınız.
        WebElement facebook = driver.findElement(By.xpath("//a[text()='Facebook']"));
        facebook.click();

        Set<String> windowsIDs = driver.getWindowHandles();

        for (String id : windowsIDs ) {
            if(homePageID.equals(id)) continue;
           driver.switchTo().window(id);
            System.out.println("Window title : " +driver.getTitle() + "   "+ driver.getCurrentUrl());
        }
        //        Sonrasında açılan pencerenin URL'indeki "facebook" kelimesini doğrulayınız.
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));

        driver.close();
        //                - Ana sayfaya geri dönün.
        driver.switchTo().window(homePageID);

        //                - "Information" başlığı altındaki "Contact Us" buttonuna tıklayınız.
        WebElement contactUs = driver.findElement(By.xpath("//a[text()='Contact us']"));
        contactUs.click();
//        - "Enquiry" yazan yerin altındaki text kutusuna mesajınızı yazıp "submit" butonuna tıklayınız.
        WebElement enquiry = driver.findElement(By.id("Enquiry"));
        enquiry.sendKeys("Burdan bir garip gecti diye yazarsiniz...");

        WebElement submitButoon = driver.findElement(By.name("send-email"));
        submitButoon.click();
//        - Sonrasında çıkan yazıyı dpğrulayınız.
        String actualSuccessMessage = driver.findElement(By.cssSelector("div.result")).getText();
        System.out.println(actualSuccessMessage);
        Assert.assertTrue(actualSuccessMessage.contains("successfully"));

        Thread.sleep(5000);
        driver.quit();

    }
}
