package BT15_ExtentReport.page;
import anhtester.com.WebUI1;
import anhtester.com.until.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        new WebUI1();
    }

    private By menuDashBoard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuProduct = By.xpath("//span[normalize-space()='Products']");
    private By menuCategory = By.xpath("//span[normalize-space()='Category']");
    private By menuBrand = By.xpath("//span[normalize-space()='Brand']");
    private By dropdownProfile = By.xpath("//a[@class='dropdown-toggle no-arrow text-dark']");
    private By optionLogout = By.xpath("//span[normalize-space()='Logout']");
    private By optionMyProfile = By.xpath("//span[normalize-space()='Profile']");

    public ProductPage clickMenuProduct(){ //Thay thế void = CustomerPage vì để vào đc màn customer thi phải đi qua màn dashboard, customer là trang sẽ lket đến
        WebUI1.clickElement(menuProduct);
       LogUtils.info("Click on menu Product");
        return new ProductPage(driver); // nhớ thêm return nhé
    }
    public CategoryPage clickMenuCategory(){
        WebUI1.clickElement(menuProduct);
       LogUtils.info("Click on menu Product");
        WebUI1.clickElement(menuCategory);
       LogUtils.info("Click on menu Category");
        return new CategoryPage(driver); // nhớ thêm return nhé
    }

    public BrandPage clickMenuBrand(){
        WebUI1.clickElement(menuProduct);
       LogUtils.info("Click on menu Product");
        WebUI1.clickElement(menuBrand);
       LogUtils.info("Click on menu Category");
        return new BrandPage(driver); // nhớ thêm return nhé
    }

    public LoginPage clickLogout(){
        WebUI1.clickElement(dropdownProfile);
       LogUtils.info("Click on dropdownProfile");
        WebUI1.sleep(1);
        WebUI1.clickElement(optionLogout);
       LogUtils.info("Click on option Logout");
        return new LoginPage(driver);
    }
}
