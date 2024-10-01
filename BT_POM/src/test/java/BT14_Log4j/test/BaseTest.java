package BT14_Log4j.test;

import BT13_TestListener.TestListener;
import anhtester.com.drivers.DriverManager;
import anhtester.com.helpers.CaptureHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.time.Duration;
@Listeners(TestListener.class)
public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void createBrowser() {
        driver = new ChromeDriver();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);

    }

    public void createBrowser(String browserName) {
        if (browserName.trim().toLowerCase().equals("chrome")) { //chuyen ve chu thuong cat khoang trang o 2   dau
            driver = new ChromeDriver();
        }
        if (browserName.trim().toLowerCase().equals("firefox")) {
            driver = new FirefoxDriver();
        }
        if (browserName.trim().toLowerCase().equals("edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);

    }

    @AfterMethod
    public void closeBrowser(ITestResult iTestResult) {
        //chụp màn hình khi testcase bị fail, ngược lại không chụp
        if (ITestResult.FAILURE == iTestResult.getStatus()) {
            CaptureHelper.takeScreenshot((iTestResult.getName())); // getName lấy tên của testcase
        }
        driver.quit();
    }
}
