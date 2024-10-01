package BT12_TakesScreenShot_VideoRecord.test;

import BT12_TakesScreenShot_VideoRecord.page.DashboardPage;
import BT12_TakesScreenShot_VideoRecord.page.LoginPage;
import BT12_TakesScreenShot_VideoRecord.page.ProductPage;
import BT5_POM_Login_Dashboard_Product_Category.page.CategoryPage;
import org.testng.annotations.Test;


public class DashBoardTest extends SetupBrowser {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductPage productPage;
    CategoryPage categoryPage;

    @Test
    public void testOpenProductPage() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.LoginCMS("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        productPage = dashboardPage.clickMenuProduct();

        productPage.clickButtonAddProduct();
        productPage.verifyRedirectAddNewProductPageSuccess();
    }
    @Test
    public void testOpenCategoryPage() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.LoginCMS("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        categoryPage = dashboardPage.clickMenuCategory();

        //customerPage = new CustomerPage(driver); thay thế dòng này bằng dòng trên để thu gọn code
        categoryPage.verifyRedirectCategoryPageSuccess();
    }
    @Test
    public void logout() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.LoginCMS("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        loginPage = dashboardPage.clickLogout();
        loginPage.verifyRedirectLoginPage();
    }
}
