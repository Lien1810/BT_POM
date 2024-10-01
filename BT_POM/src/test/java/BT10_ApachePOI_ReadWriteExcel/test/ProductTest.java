package BT10_ApachePOI_ReadWriteExcel.test;

import BT10_ApachePOI_ReadWriteExcel.page.DashboardPage;
import BT10_ApachePOI_ReadWriteExcel.page.LoginPage;
import BT10_ApachePOI_ReadWriteExcel.page.ProductPage;
import anhtester.com.ConfigData;
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
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Product");
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        productPage= dashboardPage.clickMenuProduct();

        productPage.clickButtonAddProduct();
        productPage.verifyRedirectAddNewProductPageSuccess();
        sleep(1);
        productPage.inputDataProduct(excelHelper.getCellData("Product Name", 1));
        productPage.verifyAddProductSuccess();
    }
    @Test
    public void EditProduct_Success() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Product");
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        productPage= dashboardPage.clickMenuProduct();

        productPage.clickButtonAllProducts();
        productPage.verifyRedirectAllProductPageSuccess();
        productPage.searchProduct();
        productPage.clickButtonEditProducts();
        productPage.editProduct(excelHelper.getCellData("Product Name", 1));
        productPage.verifyEditProductSuccess();
    }
}
