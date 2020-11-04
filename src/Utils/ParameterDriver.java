package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class ParameterDriver {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser){

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("opera")) {
            System.setProperty("webdriver.opera.driver","drivers/operadriver.exe");
            driver = new OperaDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        js = (JavascriptExecutor) driver;    // js.executeScript("window.scrollBy(0,6000)");

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 10);

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");


        // Login
        driver.findElement(By.id("input-email")).sendKeys("asd@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("123qweasd");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.not(ExpectedConditions.titleIs("Account Login")));
        if (driver.getTitle().equals("Privacy error")){
            driver.findElement(By.id("details-button")).click();
            driver.findElement(By.id("proceed-link")).click();
        }
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(7000);
        driver.quit();
    }
}
