package Challenge;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseDriver {

    protected  WebDriver driver;
    protected  WebDriverWait wait;
    protected  JavascriptExecutor js;

    @BeforeClass
    void BeforeClass(){
    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

    driver = new ChromeDriver();
    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 10);

    driver.manage().window().maximize();

    js = (JavascriptExecutor) driver;   //js.executeScript("arguments[0].scrollIntoView();", element);

    driver.get("http://www.autotrader.com");
    driver.manage().deleteAllCookies();
}


    @AfterClass
    void AfterClass() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
