package BT15_ExtentReport.test;


import BT15_ExtentReport.page.CategoryPage;
import BT15_ExtentReport.page.DashboardPage;
import BT15_ExtentReport.page.LoginPage;
import anhtester.com.ConfigData;
import anhtester.com.WebUI1;
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
        WebUI1.waitForPageLoaded();
        CaptureHelper.takeScreenshot("Category screen"); //chụp ảnh màn hình category
        categoryPage.verifyRedirectCategoryPageSuccess();

        categoryPage.clickButtonAddNew();
        categoryPage.inputDataCategory(excelHelper.getCellData("Category Name", 1));
        categoryPage.verifyAddCategorySuccess();
    }

}
