package anhtester.com.reports;
import anhtester.com.drivers.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureManager {
    //Text attachments for Allure--Hàm để ghi log
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) { //- ghi từng bước
        return message;
    }

    //Screenshot attachments for Allure --Hàm để chụp màn hình
    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

