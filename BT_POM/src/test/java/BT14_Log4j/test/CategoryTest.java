package BT14_Log4j.test;

import BT5_POM_Login_Dashboard_Product_Category.page.CategoryPage;
import BT5_POM_Login_Dashboard_Product_Category.page.DashboardPage;
import BT5_POM_Login_Dashboard_Product_Category.page.LoginPage;
import BT5_POM_Login_Dashboard_Product_Category.test.BaseTest;
import anhtester.com.ConfigData;
import anhtester.com.WebUI;
import anhtester.com.drivers.DriverManager;
import anhtester.com.helpers.CaptureHelper;
import anhtester.com.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class CategoryTest extends BaseTest {
    //Khai bao đối tượng
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CategoryPage categoryPage;
    private String CATEGORY_NAME = "Giay cao got";


    @Test
    public void testAddCategory_Success() {
        DriverManager.setDriver(driver);
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Category");
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        categoryPage = dashboardPage.clickMenuCategory();
        WebUI.waitForPageLoaded();
        CaptureHelper.takeScreenshot("Category screen"); //chụp ảnh màn hình category
        categoryPage.verifyRedirectCategoryPageSuccess();

        categoryPage.clickButtonAddNew();
        categoryPage.inputDataCategory(excelHelper.getCellData("Category Name", 1));
        categoryPage.verifyAddCategorySuccess();
    }

}
