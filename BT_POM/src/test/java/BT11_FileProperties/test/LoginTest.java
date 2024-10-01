package BT11_FileProperties.test;

import BT11_FileProperties.page.LoginPage;
import anhtester.com.helpers.ExcelHelper;
import anhtester.com.helpers.PropertiesHelper;
import org.testng.annotations.Test;

public class LoginTest extends SetupBrowser {

    //Khai bao đôi tượng
    LoginPage loginPage;

    @Test
    public void testLoginCMS_Success() {
        //XỬ LÝ FILE PROPERTIES
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginCMS_WithEmailPasswordInvalid() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS(excelHelper.getCellData("email", 2), excelHelper.getCellData("password", 2));
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCMS_WithEmailInvalid() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS(excelHelper.getCellData("email", 3), excelHelper.getCellData("password", 3));
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCMS_WithPasswordlInvalid() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS(excelHelper.getCellData("email", 4), excelHelper.getCellData("password", 4));
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCMS_WithNullEmailPassword() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS(excelHelper.getCellData("email", 7), excelHelper.getCellData("password", 7));
        loginPage.verifyLoginFail_WithNullEmailField();
    }

    @Test
    public void testLoginCMS_WithNullEmail() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS(excelHelper.getCellData("email", 6), excelHelper.getCellData("password", 6));
        loginPage.verifyLoginFail_WithNullEmailField();
    }

    @Test
    public void testLoginCMS_WithNullPassword() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS(excelHelper.getCellData("email", 5), excelHelper.getCellData("password", 5));
        loginPage.verifyLoginFail_WithNullPasswordField();
    }

    //Login thành công khi tích checkbox remember
    @Test
    public void testLoginCMS_Success_WithCheckbox() {
        PropertiesHelper.loadAllFiles();
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS_SelectCheckboxRemember(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        loginPage.verifyLoginSuccess();
    }

    //Navigate to ForgotPWW
    @Test
    public void testNavigateToForgotPW() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Login");
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS_ForgotPW(excelHelper.getCellData("email", 7), excelHelper.getCellData("password", 7));
        loginPage.verifyNavigateForgotPW();
    }

}
