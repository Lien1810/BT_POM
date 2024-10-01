package BT16_AllureReport.page;

import anhtester.com.WebUI1;
import anhtester.com.until.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public DashboardPage() {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By menuProduct = By.xpath("//span[normalize-space()='Products']");
    By menuCategory = By.xpath("//span[normalize-space()='Category']");
    By menuBrand = By.xpath("//span[normalize-space()='Brand']");
    By dropdownProfile = By.xpath("//a[@class='dropdown-toggle no-arrow text-dark']");
    By optionLogout = By.xpath("//span[normalize-space()='Logout']");
    By optionMyProfile = By.xpath("//span[normalize-space()='Profile']");

    public ProductPage clickMenuProduct() { //Thay thế void = CustomerPage vì để vào đc màn customer thi phải đi qua màn dashboard, customer là trang sẽ lket đến
        WebUI1.clickElement(menuProduct);
        LogUtils.info("Click on menu Product");
        return new ProductPage(driver); // nhớ thêm return nhé
    }

    public CategoryPage clickMenuCategory() {
        WebUI1.clickElement(menuProduct);
        LogUtils.info("Click on menu Product");
        WebUI1.clickElement(menuCategory);
        LogUtils.info("Click on menu Category");
        return new CategoryPage(driver); // nhớ thêm return nhé
    }

    public BrandPage clickMenuBrand() {
        WebUI1.clickElement(menuProduct);
        LogUtils.info("Click on menu Product");
        WebUI1.clickElement(menuBrand);
        LogUtils.info("Click on menu Category");
        return new BrandPage(driver); // nhớ thêm return nhé
    }

    public LoginPage clickLogout() {
        WebUI1.clickElement(dropdownProfile);
        LogUtils.info("Click on dropdownProfile");
        WebUI1.sleep(1);
        WebUI1.clickElement(optionLogout);
        LogUtils.info("Click on option Logout");
        return new LoginPage();
    }
}
