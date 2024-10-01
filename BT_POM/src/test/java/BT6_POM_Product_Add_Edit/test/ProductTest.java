package BT6_POM_Product_Add_Edit.test;

import BT6_POM_Product_Add_Edit.page.DashboardPage;
import BT6_POM_Product_Add_Edit.page.LoginPage;
import BT6_POM_Product_Add_Edit.page.ProductPage;
import anhtester.com.ConfigData;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    //Khai bao đối tượng
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductPage productPage;
    private String PRODUCT_NAME = "Áo bò mẫu mới";

    @Test
    public void AddProduct_Success() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        productPage= dashboardPage.clickMenuProduct();

        productPage.clickButtonAddProduct();
        productPage.verifyRedirectAddNewProductPageSuccess();
        sleep(1);
        productPage.inputDataProduct(PRODUCT_NAME);
        productPage.verifyAddProductSuccess();
    }
    @Test
    public void EditProduct_Success() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        productPage= dashboardPage.clickMenuProduct();

        productPage.clickButtonAllProducts();
        productPage.verifyRedirectAllProductPageSuccess();
        productPage.searchProduct();
        productPage.clickButtonEditProducts();
        productPage.editProduct(PRODUCT_NAME);
        productPage.verifyEditProductSuccess();
    }
}
