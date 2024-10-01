package BT15_ExtentReport.test;

import BT15_ExtentReport.page.CategoryPage;
import BT15_ExtentReport.page.DashboardPage;
import BT15_ExtentReport.page.LoginPage;
import BT15_ExtentReport.page.ProductPage;
import org.testng.annotations.Test;


public class DashBoardTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductPage productPage;
    CategoryPage categoryPage;

    @Test
    public void testOpenProductPage() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.LoginCMS("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        productPage = dashboardPage.clickMenuProduct();
        productPage.clickButtonAddProduct();
        productPage.verifyRedirectAddNewProductPageSuccess();
    }
    @Test
    public void testOpenCategoryPage() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.LoginCMS("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        categoryPage = dashboardPage.clickMenuCategory();

        //customerPage = new CustomerPage(driver); thay thế dòng này bằng dòng trên để thu gọn code
        categoryPage.verifyRedirectCategoryPageSuccess();
    }

    @Test
    public void logout() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.LoginCMS("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        loginPage = dashboardPage.clickLogout();
        loginPage.verifyRedirectLoginPage();
    }
}
