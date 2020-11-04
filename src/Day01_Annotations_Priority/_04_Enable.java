package Day01_Annotations_Priority;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class _04_Enable {
    public static WebDriver driver;

    @BeforeClass
    void beforeClass(){
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");


    }

    @AfterClass
    void afterClass() throws InterruptedException {Thread.sleep(5000);
    driver.quit();
    }

    @Test
    void test1(){
        String u1 = driver.getCurrentUrl();

        System.out.println(u1);
    }

    @Test (enabled = false)  // testi kapattik...
    void test2(){
        String u2 = driver.getTitle();

        System.out.println(u2);
    }

    @Test
    void test3(){
        String handle=driver.getWindowHandle();

        System.out.println(handle);
    }

}
