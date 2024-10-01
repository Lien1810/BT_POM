package BT16_AllureReport.test;

import BT16_AllureReport.TestListener;
import anhtester.com.WebUI;
import anhtester.com.drivers.DriverManager;
import anhtester.com.helpers.CaptureHelper;
import anhtester.com.helpers.PropertiesHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {
    public WebDriver driver;
    public BaseTest() {
        this.driver = driver;
        new WebUI(driver);
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void createBrowser(@Optional("chrome") String browserName) {
        PropertiesHelper.loadAllFiles();
        WebDriver driver = setBrowser(PropertiesHelper.getValue("browser")); //c2 đọc từ file
        DriverManager.setDriver(driver);
    }

    public WebDriver setBrowser(String browserName) {
        WebDriver driver = null;
        if (browserName.trim().toLowerCase().equals("chrome")) { //chuyen ve chu thuong cat khoang trang o 2 dau
            ChromeOptions options = new ChromeOptions();
            if (PropertiesHelper.getValue("HEADLESS").equals("true")) {
                // set chrome as Headless
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);
        }
        if (browserName.trim().toLowerCase().equals("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            // set chrome as Headless
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        }
        if (browserName.trim().toLowerCase().equals("edge")) {
            EdgeOptions options = new EdgeOptions();
            // set chrome as Headless
            options.addArguments("--headless");
            driver = new EdgeDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public void closeBrowser(ITestResult iTestResult) {
        if (ITestResult.FAILURE == iTestResult.getStatus()) {
            CaptureHelper.takeScreenshot((iTestResult.getName()));
        }
        DriverManager.quit();
    }
}


