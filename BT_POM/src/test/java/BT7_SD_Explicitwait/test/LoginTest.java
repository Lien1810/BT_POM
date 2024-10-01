package BT7_SD_Explicitwait.test;

import BT7_SD_Explicitwait.page.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    //Khai bao đôi tượng
    LoginPage loginPage;

    @Test
    public void testLoginCMS_Success() {
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginCMS_WithEmailPasswordInvalid() {
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS("admin1@example.com", "1234");
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCMS_WithEmailInvalid() {
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS("admin1@example.com", "123456");
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCMS_WithPasswordlInvalid() {
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS("admin@example.com", "123");
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCMS_WithNullEmailPassword() {
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS("", "");
        loginPage.verifyLoginFail_WithNullEmailField();
    }

    @Test
    public void testLoginCMS_WithNullEmail() {
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS("", "123456");
        loginPage.verifyLoginFail_WithNullEmailField();
    }

    @Test
    public void testLoginCMS_WithNullPassword() {
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS("admin@example.com", "");
        loginPage.verifyLoginFail_WithNullPasswordField();
    }

    //Login thành công khi tích checkbox remember
    @Test
    public void testLoginCMS_Success_WithCheckbox() {
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS_SelectCheckboxRemember("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
    }

    //Navigate to ForgotPWW
    @Test
    public void testNavigateToForgotPW() {
        loginPage = new LoginPage(driver);
        loginPage.LoginCMS_ForgotPW("", "");
        loginPage.verifyNavigateForgotPW();
    }

}
