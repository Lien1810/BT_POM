package BT12_TakesScreenShot_VideoRecord.test;

import anhtester.com.drivers.DriverManager;
import anhtester.com.helpers.CaptureHelper;
import anhtester.com.helpers.PropertiesHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class SetupBrowser {
    public WebDriver driver;
    private PropertiesHelper propertiesHelper;

    @BeforeMethod
    @Parameters({"browser"}) //Gọi hàm getValue để lấy giá trị browser từ file properties để truyền vào class
    public void createBrowser(@Optional("Chrome") String browserName) {
        PropertiesHelper.loadAllFiles();
        WebDriver driver = setBrowser(PropertiesHelper.getValue("browser"));
        DriverManager.setDriver(driver);
    }

    public WebDriver setBrowser(String browserName) {
        WebDriver driver = null;
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
        return driver;
    }

    @AfterMethod
    public void closeBrowser(ITestResult iTestResult) {
        // Chụp màn hình nếu testcase fail
        if (ITestResult.FAILURE == iTestResult.getStatus()) {
            CaptureHelper.takeScreenshot(iTestResult.getName()); // Truyền driver
        }
        CaptureHelper.stopRecord();
        DriverManager.quit();
    }

}
