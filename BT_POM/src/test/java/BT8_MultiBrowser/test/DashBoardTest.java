package BT8_MultiBrowser.test;

import BT5_POM_Login_Dashboard_Product_Category.page.CategoryPage;
import BT8_MultiBrowser.page.DashboardPage;
import BT8_MultiBrowser.page.LoginPage;
import BT8_MultiBrowser.page.ProductPage;
import org.testng.annotations.Test;


public class DashBoardTest extends SetupBrowser {
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
