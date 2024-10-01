package BT9_SearchTable.test;

import BT9_SearchTable.page.CategoryPage;
import BT9_SearchTable.page.DashboardPage;
import BT9_SearchTable.page.LoginPage;
import anhtester.com.ConfigData;
import org.testng.annotations.Test;

public class CategoryTest extends BaseTest {
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
