package BT12_TakesScreenShot_VideoRecord.test;

import BT12_TakesScreenShot_VideoRecord.page.DashboardPage;
import BT12_TakesScreenShot_VideoRecord.page.LoginPage;
import BT12_TakesScreenShot_VideoRecord.page.ProductPage;
import anhtester.com.ConfigData;
import anhtester.com.WebUI;
import anhtester.com.helpers.CaptureHelper;
import anhtester.com.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class ProductTest extends SetupBrowser {
    //Khai bao đối tượng
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductPage productPage;
    private String PRODUCT_NAME = "Áo bò mẫu mới";

    @Test
    public void AddProduct_Success() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Product");
        loginPage = new LoginPage();
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        productPage= dashboardPage.clickMenuProduct();

        productPage.clickButtonAddProduct();
        WebUI.waitForPageLoaded();
        CaptureHelper.takeScreenshot("Add Product screen"); //chụp ảnh màn hình category
        productPage.verifyRedirectAddNewProductPageSuccess();
        WebUI.sleep(1);
        productPage.inputDataProduct(excelHelper.getCellData("Product Name", 1));
        productPage.verifyAddProductSuccess();
    }
    @Test
    public void EditProduct_Success() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Product");
        loginPage = new LoginPage();
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
