package BT5_POM_Login_Dashboard_Product_Category.test;

import BT5_POM_Login_Dashboard_Product_Category.page.LoginPage;
import anhtester.com.ConfigData;
import org.testng.annotations.Test;
import BT5_POM_Login_Dashboard_Product_Category.page.DashboardPage;
import BT5_POM_Login_Dashboard_Product_Category.page.ProductPage;

public class ProductTest extends BaseTest {
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

        productPage= dashboardPage.clickMenuProduct();

        productPage.clickButtonAddProduct();
        productPage.verifyRedirectNewProductPageSuccess();
        productPage.inputDataProduct(PRODUCT_NAME);
        productPage.verifyAddProductSuccess();
    }
}
