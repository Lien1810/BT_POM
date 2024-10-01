package BT14_Log4j.test;

import BT14_Log4j.page.DashboardPage;
import BT14_Log4j.page.LoginPage;
import BT14_Log4j.page.ProductPage;
import anhtester.com.ConfigData;
import anhtester.com.WebUI;
import anhtester.com.drivers.DriverManager;
import anhtester.com.helpers.CaptureHelper;
import anhtester.com.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    //Khai bao đối tượng
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductPage productPage;
    private String PRODUCT_NAME = "Áo bò mẫu mới";

    @Test
    public void AddProduct_Success() {
        DriverManager.setDriver(driver);
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Product");
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        productPage= dashboardPage.clickMenuProduct();

        productPage.clickButtonAddProduct();
        WebUI.waitForPageLoaded();
        CaptureHelper.takeScreenshot("Add Product screen"); //chụp ảnh màn hình category
        productPage.verifyRedirectAddNewProductPageSuccess();
        productPage.inputDataProduct(excelHelper.getCellData("Product Name", 1));
        productPage.verifyAddProductSuccess();
    }
    @Test
    public void EditProduct_Success() {
        DriverManager.setDriver(driver);
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Product");
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        productPage= dashboardPage.clickMenuProduct();

        productPage.clickButtonAllProducts();
        WebUI.waitForPageLoaded();
        CaptureHelper.takeScreenshot("All Product screen"); //chụp ảnh màn hình All Product
        productPage.verifyRedirectAllProductPageSuccess();

        productPage.searchProduct();
        productPage.clickButtonEditProducts();
        productPage.editProduct(excelHelper.getCellData("Product Name", 1));
        productPage.verifyEditProductSuccess();
    }
}
