package BT15_ExtentReport.test;

import BT15_ExtentReport.page.LoginPage;
import anhtester.com.drivers.DriverManager;
import anhtester.com.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    //Khai bao đôi tượng
    LoginPage loginPage;

    @Test
    public void testLoginCMS_Success() {
        DriverManager.setDriver(driver);
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS(excelHelper.getCellData("email", 1), excelHelper.getCellData("password", 1));
       // CaptureHelper.takeScreenshot("testLoginSuccess");
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginCMS_WithEmailPasswordInvalid() {
        DriverManager.setDriver(driver);
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS(excelHelper.getCellData("email", 2), excelHelper.getCellData("password", 2));
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCMS_WithEmailInvalid() {
        DriverManager.setDriver(driver);
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS(excelHelper.getCellData("email", 3), excelHelper.getCellData("password", 3));
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCMS_WithPasswordlInvalid() {
        DriverManager.setDriver(driver);
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS(excelHelper.getCellData("email", 4), excelHelper.getCellData("password", 4));
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCMS_WithNullEmailPassword() {
        DriverManager.setDriver(driver);
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS(excelHelper.getCellData("email", 7), excelHelper.getCellData("password", 7));
        loginPage.verifyLoginFail_WithNullEmailField();
    }

    @Test
    public void testLoginCMS_WithNullEmail() {
        DriverManager.setDriver(driver);
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS(excelHelper.getCellData("email", 6), excelHelper.getCellData("password", 6));
        loginPage.verifyLoginFail_WithNullEmailField();
    }

    @Test
    public void testLoginCMS_WithNullPassword() {
        DriverManager.setDriver(driver);
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS(excelHelper.getCellData("email", 5), excelHelper.getCellData("password", 5));
        loginPage.verifyLoginFail_WithNullPasswordField();
    }

    //Login thành công khi tích checkbox remember
    @Test
    public void testLoginCMS_Success_WithCheckbox() {
        DriverManager.setDriver(driver);
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS_SelectCheckboxRemember(excelHelper.getCellData("email", 1), excelHelper.getCellData("password", 1));
        loginPage.verifyLoginSuccess();
    }

    //Navigate to ForgotPWW
    @Test
    public void testNavigateToForgotPW() {
        DriverManager.setDriver(driver);
        //Gọi hàm setExcel file để chỉ định file excel và sheet cụ thể
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS_ForgotPW(excelHelper.getCellData("email", 7), excelHelper.getCellData("password", 7));
        loginPage.verifyNavigateForgotPW();
    }

}
