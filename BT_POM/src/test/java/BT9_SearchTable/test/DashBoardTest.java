package BT9_SearchTable.test;

import BT9_SearchTable.page.CategoryPage;
import BT9_SearchTable.page.DashboardPage;
import BT9_SearchTable.page.LoginPage;
import BT9_SearchTable.page.ProductPage;
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
    //    loginPage.verifyLoginSuccess();
        productPage = dashboardPage.clickMenuProduct();

        //customerPage = new CustomerPage(driver); thay thế dòng này bằng dòng trên để thu gọn code
        productPage.verifyRedirectNewProductPageSuccess();
    }
    @Test
    public void testOpenCategoryPage() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.LoginCMS("admin@example.com", "123456");
     //   loginPage.verifyLoginSuccess();
        categoryPage = dashboardPage.clickMenuCategory();

        //customerPage = new CustomerPage(driver); thay thế dòng này bằng dòng trên để thu gọn code
        categoryPage.verifyRedirectCategoryPageSuccess();
    }

    @Test
    public void logout() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.LoginCMS("admin@example.com", "123456");
      //  loginPage.verifyLoginSuccess();
        loginPage = dashboardPage.clickLogout();
        loginPage.verifyRedirectLoginPage();
    }
}
