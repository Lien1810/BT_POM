package BT9_SearchTable.test;

import BT9_SearchTable.page.DashboardPage;
import BT9_SearchTable.page.LoginPage;
import BT9_SearchTable.page.ProductPage;
import anhtester.com.ConfigData;
import org.testng.annotations.Test;

import java.util.Random;

public class ProductTest extends BaseTest {
    //Khai bao đối tượng
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductPage productPage;
    private String PRODUCT_NAME = "Áo thun loại ";

    @Test
    public void Login_Success() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
     //   loginPage.verifyLoginSuccess();

        productPage = dashboardPage.clickMenuProduct();

        productPage.clickButtonAddProduct();
        productPage.verifyRedirectNewProductPageSuccess();
        productPage.inputDataProduct(PRODUCT_NAME);
        productPage.verifyAddProductSuccess();
    }

    @Test
    public void EditProduct_Success() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
     //   loginPage.verifyLoginSuccess();

        productPage = dashboardPage.clickMenuProduct();

        productPage.clickButtonAllProducts();
        productPage.verifyRedirectAllProductPageSuccess();
        productPage.searchProduct();
        productPage.clickButtonEditProducts();
        Random random = new Random();
        productPage.editProduct(PRODUCT_NAME + random.nextInt() );
        productPage.verifyEditProductSuccess();
    }

    @Test
    public void testCheckDataOnProductTable() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
 //       loginPage.verifyLoginSuccess();

        productPage = dashboardPage.clickMenuProduct();
        productPage.clickButtonAllProducts();
        productPage.searchDataProductTable("s");
        productPage.checkSearchTableByColumn(2, "s"); // so sanh chứa contains

    }
}
