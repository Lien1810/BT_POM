package BT14_Log4j;

import anhtester.com.WebUI;
import anhtester.com.helpers.CaptureHelper;
import anhtester.com.helpers.PropertiesHelper;
import anhtester.com.until.LogUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void onStart(ITestContext result) {
        PropertiesHelper.loadAllFiles();
    }

    @Override
    public void onFinish(ITestContext result) {
       LogUtils.info("onFinish" + result.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {

       LogUtils.info("******** " + result.getName() + "************");
        CaptureHelper.startRecord(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
       LogUtils.info("====> " + result.getName() + "is successfully.");
        CaptureHelper.stopRecord();
    }

    @Override
    public void onTestFailure(ITestResult result) {
       LogUtils.error("====> " + result.getName() + " is FAIL.");

        // Lấy giá trị từ PropertiesHelper và kiểm tra nếu null
        String screenshotFailValue = PropertiesHelper.getValue("SCREENSHOT_FAIL");

        // Kiểm tra null và chuyển đổi sang kiểu Boolean
        if (screenshotFailValue != null && Boolean.parseBoolean(screenshotFailValue) == false) {
            CaptureHelper.captureScreenshot(result.getName());
        }

        WebUI.sleep(1);
        CaptureHelper.stopRecord();
    }


    @Override
    public void onTestSkipped(ITestResult result) {
       LogUtils.warn("******** " + result.getName() + "is SKIPPED *************");
        CaptureHelper.stopRecord();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
       LogUtils.info("onTestFailedButWithinSuccessPercentage: " + result.getName());
    }
}