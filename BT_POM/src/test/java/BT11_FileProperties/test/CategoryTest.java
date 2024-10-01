package BT11_FileProperties.test;

import BT11_FileProperties.page.CategoryPage;
import BT11_FileProperties.page.DashboardPage;
import BT11_FileProperties.page.LoginPage;
import anhtester.com.ConfigData;
import org.testng.annotations.Test;

public class CategoryTest extends SetupBrowser {
    //Khai bao đối tượng
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CategoryPage categoryPage;
    private String CATEGORY_NAME = "Giay cao got";

    @Test
    public void testAddCategory_Success(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.LoginCMS(ConfigData.EMAIL, ConfigData.PASSWORD);
        categoryPage= dashboardPage.clickMenuCategory();
        categoryPage.verifyRedirectCategoryPageSuccess();

        categoryPage.clickButtonAddNew();
        categoryPage.inputDataCategory(CATEGORY_NAME);
        categoryPage.verifyAddCategorySuccess();
    }

}
