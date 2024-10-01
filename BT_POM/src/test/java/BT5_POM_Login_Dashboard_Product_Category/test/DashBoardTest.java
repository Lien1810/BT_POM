package BT5_POM_Login_Dashboard_Product_Category.test;

import BT5_POM_Login_Dashboard_Product_Category.page.CategoryPage;
import BT5_POM_Login_Dashboard_Product_Category.page.LoginPage;
import BT5_POM_Login_Dashboard_Product_Category.page.ProductPage;
import anhtester.com.WebUI;
import org.testng.annotations.Test;
import BT5_POM_Login_Dashboard_Product_Category.page.DashboardPage;


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
