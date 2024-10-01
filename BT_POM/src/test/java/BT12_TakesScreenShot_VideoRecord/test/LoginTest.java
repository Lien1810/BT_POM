package BT12_TakesScreenShot_VideoRecord.test;

import BT12_TakesScreenShot_VideoRecord.page.LoginPage;
import anhtester.com.helpers.CaptureHelper;
import anhtester.com.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class LoginTest extends SetupBrowser {

    //Khai bao đôi tượng
    LoginPage loginPage;

    @Test
    public void testLoginCMS_Success() {
        loginPage = new LoginPage();
        CaptureHelper.takeScreenshot("Login screen");

        //  CaptureHelper.startRecord("testLoginCRM_LoginSuccess");

        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");

        loginPage.LoginCMS(
                excelHelper.getCellData("email", 1),
                excelHelper.getCellData("password", 1)
        );
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginCMS_WithEmailPasswordInvalid() {
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new LoginPage();
        loginPage.LoginCMS(excelHelper.getCellData("email", 2), excelHelper.getCellData("password", 2));
        CaptureHelper.takeScreenshot("testLoginCMS_WithEmailPasswordInvalid");//chụp ảnh màn hình case login fail
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCMS_WithEmailInvalid() {
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new LoginPage();
        loginPage.LoginCMS(excelHelper.getCellData("email", 3), excelHelper.getCellData("password", 3));
        CaptureHelper.takeScreenshot("testLoginCMS_WithEmailInvalid");
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCMS_WithPasswordlInvalid() {
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new LoginPage();
        loginPage.LoginCMS(excelHelper.getCellData("email", 4), excelHelper.getCellData("password", 4));
        CaptureHelper.takeScreenshot("testLoginCMS_WithPasswordlInvalid");
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCMS_WithNullEmailPassword() {
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new LoginPage();
        loginPage.LoginCMS(excelHelper.getCellData("email", 7), excelHelper.getCellData("password", 7));
        CaptureHelper.takeScreenshot("testLoginCMS_WithNullEmailPassword");
        loginPage.verifyLoginFail_WithNullEmailField();
    }

    @Test
    public void testLoginCMS_WithNullEmail() {
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new LoginPage();
        loginPage.LoginCMS(excelHelper.getCellData("email", 6), excelHelper.getCellData("password", 6));
        CaptureHelper.takeScreenshot("testLoginCMS_WithNullEmail");
        loginPage.verifyLoginFail_WithNullEmailField();
    }

    @Test
    public void testLoginCMS_WithNullPassword() {
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new LoginPage();
        loginPage.LoginCMS(excelHelper.getCellData("email", 5), excelHelper.getCellData("password", 5));
        CaptureHelper.takeScreenshot("testLoginCMS_WithNullPassword");
        loginPage.verifyLoginFail_WithNullPasswordField();
    }

    //Login thành công khi tích checkbox remember
    @Test
    public void testLoginCMS_Success_WithCheckbox() {
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new LoginPage();
        loginPage.LoginCMS_SelectCheckboxRemember(excelHelper.getCellData("email", 1), excelHelper.getCellData("password", 1));
        loginPage.verifyLoginSuccess();
    }

    //Navigate to ForgotPWW
    @Test
    public void testNavigateToForgotPW() {
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new LoginPage();
        loginPage.LoginCMS_ForgotPW(excelHelper.getCellData("email", 7), excelHelper.getCellData("password", 7));
        CaptureHelper.takeScreenshot("Forgot password screen");
        loginPage.verifyNavigateForgotPW();
    }

}
