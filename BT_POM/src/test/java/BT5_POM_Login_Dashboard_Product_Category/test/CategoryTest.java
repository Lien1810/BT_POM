package BT5_POM_Login_Dashboard_Product_Category.test;

import BT5_POM_Login_Dashboard_Product_Category.page.LoginPage;
import anhtester.com.ConfigData;
import org.testng.annotations.Test;
import BT5_POM_Login_Dashboard_Product_Category.page.CategoryPage;
import BT5_POM_Login_Dashboard_Product_Category.page.DashboardPage;

public class CategoryTest extends BaseTest{
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
