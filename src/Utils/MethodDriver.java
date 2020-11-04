package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class MethodDriver {

    public static WebDriver driver;    // driver static oldugu icin paralel olarak ayni anda iki driver kullanamyiz...
    public static WebDriverWait wait;

    @BeforeClass
    public void beforeClass(){
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 10);

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

        // Login
        driver.findElement(By.id("input-email")).sendKeys("asd@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("123qweasd");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.not(ExpectedConditions.titleIs("Account Login")));
        if (driver.getTitle().equals("Privacy error")){
            driver.findElement(By.id("details-button")).click();
            driver.findElement(By.id("proceed-link")).click();
        }
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
