package BT12_TakesScreenShot_VideoRecord.test;

import BT5_POM_Login_Dashboard_Product_Category.page.CategoryPage;
import BT5_POM_Login_Dashboard_Product_Category.page.DashboardPage;
import BT5_POM_Login_Dashboard_Product_Category.page.LoginPage;
import anhtester.com.ConfigData;
import anhtester.com.WebUI;
import anhtester.com.helpers.CaptureHelper;
import anhtester.com.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class CategoryTest extends SetupBrowser {
    //Khai bao đối tượng
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CategoryPage categoryPage;
    private String CATEGORY_NAME = "Giay cao got";


    @Test
    public void testAddCategory_Success() {
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
