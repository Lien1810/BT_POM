package BT12_TakesScreenShot_VideoRecord.page;

import BT5_POM_Login_Dashboard_Product_Category.page.CategoryPage;
import anhtester.com.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }

    private By menuDashBoard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuProduct = By.xpath("//span[normalize-space()='Products']");
    private By menuCategory = By.xpath("//span[normalize-space()='Category']");
    private By menuBrand = By.xpath("//span[normalize-space()='Brand']");
    private By dropdownProfile = By.xpath("//a[@class='dropdown-toggle no-arrow text-dark']");
    private By optionLogout = By.xpath("//span[normalize-space()='Logout']");
    private By optionMyProfile = By.xpath("//span[normalize-space()='Profile']");

    public ProductPage clickMenuProduct(){ //Thay thế void = CustomerPage vì để vào đc màn customer thi phải đi qua màn dashboard, customer là trang sẽ lket đến
        WebUI.clickElement(menuProduct);
        System.out.println("Click on menu Product");
        return new ProductPage(driver); // nhớ thêm return nhé
    }
    public CategoryPage clickMenuCategory(){
        WebUI.clickElement(menuProduct);
        System.out.println("Click on menu Product");
        WebUI.clickElement(menuCategory);
        System.out.println("Click on menu Category");
        return new CategoryPage(driver); // nhớ thêm return nhé
    }
    public BrandPage clickMenuBrand(){
        WebUI.clickElement(menuProduct);
        System.out.println("Click on menu Product");
        WebUI.clickElement(menuBrand);
        System.out.println("Click on menu Category");
        return new BrandPage(driver); // nhớ thêm return nhé
    }

    public LoginPage clickLogout(){
        WebUI.clickElement(dropdownProfile);
        System.out.println("Click on dropdownProfile");
        WebUI.sleep(1);
        WebUI.clickElement(optionLogout);
        System.out.println("Click on option Logout");
        return new LoginPage();
    }
}
