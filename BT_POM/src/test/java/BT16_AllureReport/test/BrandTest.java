package BT16_AllureReport.test;

import BT16_AllureReport.page.BrandPage;
import BT16_AllureReport.page.DashboardPage;
import BT16_AllureReport.page.LoginPage;
import BT16_AllureReport.page.ProductPage;
import anhtester.com.ConfigData;
import anhtester.com.WebUI1;
import anhtester.com.helpers.CaptureHelper;
import anhtester.com.helpers.ExcelHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class BrandTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductPage productPage;
    BrandPage brandPage;
    private String BRAND_NAME = "Christian Dior ";

    @Test
    public void testAddBrand_Success() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Brand");
        loginPage = new LoginPage();
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        brandPage = dashboardPage.clickMenuBrand();
        WebUI1.waitForPageLoaded();
        CaptureHelper.takeScreenshot("Brand screen");//chụp ảnh màn hình Brand
        brandPage.verifyRedirectBrandPageSuccess();

        brandPage.inputDataBrand(excelHelper.getCellData("Name Brand", 1),excelHelper.getCellData("Title Brand", 1),excelHelper.getCellData("Description Brand", 1));
        brandPage.verify_AddBrand_Success();
    }

    @Test
    public void testEditBrand_Success() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/importdata_CMS.xlsx", "Brand");
        loginPage = new LoginPage();
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        brandPage = dashboardPage.clickMenuBrand();
        brandPage.verifyRedirectBrandPageSuccess();

        brandPage.searchBrand("Brand test2");
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        WebUI1.sleep(1);
        brandPage.editBrand();
        brandPage.editDataBrand(excelHelper.getCellData("Name Brand", 3),excelHelper.getCellData("Title Brand", 3),excelHelper.getCellData("Description Brand", 3));
        brandPage.verify_EditBrand_Success();
        brandPage = dashboardPage.clickMenuBrand();
        brandPage.searchBrand(BRAND_NAME);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        WebUI1.sleep(1);
    }
    @Test
    public void testDeleteBrand_Success() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        brandPage = dashboardPage.clickMenuBrand();
        brandPage.verifyRedirectBrandPageSuccess();
        brandPage.searchBrand(BRAND_NAME);
      //  brandPage.searchBrand("Brand test2");
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        WebUI1.sleep(1);
        brandPage.deleteBrand();
        brandPage.verify_DeleteBrand_Success();
    }
}
