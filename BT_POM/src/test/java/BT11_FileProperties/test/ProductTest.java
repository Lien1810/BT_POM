package BT11_FileProperties.test;

import BT11_FileProperties.page.DashboardPage;
import BT11_FileProperties.page.LoginPage;
import BT11_FileProperties.page.ProductPage;
import anhtester.com.ConfigData;
import org.testng.annotations.Test;

public class ProductTest extends SetupBrowser {
    //Khai bao đối tượng
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductPage productPage;
    private String PRODUCT_NAME = "Áo thun loại 1";

    @Test
    public void AddProduct_Success() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

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
        loginPage.verifyLoginSuccess();

        productPage = dashboardPage.clickMenuProduct();

        productPage.clickButtonAllProducts();
        productPage.verifyRedirectAllProductPageSuccess();
        productPage.searchProduct();
        productPage.clickButtonEditProducts();
        productPage.editProduct(PRODUCT_NAME);
        productPage.verifyEditProductSuccess();
    }

    @Test
    public void testCheckDataOnProductTable() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        productPage = dashboardPage.clickMenuProduct();
        productPage.clickButtonAllProducts();
        productPage.searchDataProductTable("s");
        productPage.checkSearchTableByColumn(2, "s"); // so sanh chứa contains

    }
}
