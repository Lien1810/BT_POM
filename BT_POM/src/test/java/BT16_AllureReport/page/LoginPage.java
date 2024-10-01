package BT16_AllureReport.page;
import anhtester.com.ConfigData;
import anhtester.com.WebUI;
import anhtester.com.WebUI1;
import anhtester.com.drivers.DriverManager;
import anhtester.com.until.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    //Khai bao bien
    private WebDriver driver;
    private WebDriverWait wait;
    
    //Tao ham xay dung
    public LoginPage() {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //khai bao tat ca cac object(element) tren page nay
    By headerLoginPage = By.xpath("//h1[@class='h3 text-primary mb-0']");
    By descriptionLoginPage = By.xpath("//p[normalize-space()='Login to your account.']");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    By checkboxRememberMe = By.xpath("//input[@id='remember']/following-sibling::span[2]");
    By linkForgotPW = By.xpath("//a[normalize-space()='Forgot password ?']");
    By errorEmailMessage = By.xpath("//span[@data-notify='message']");
    By menuDashBoard = By.xpath("//span[normalize-space()='Dashboard']");


    //XD cac ham xu ly chinh tren trang nay
    private void setEmailInput(String email) {
        WebUI1.setText(inputEmail, email);
        LogUtils.info("Set email value: " + email);
    }

    private void setPasswordInput(String password) {
        WebUI1.setText(inputPassword, password);
        LogUtils.info("Set password value: " + password);
    }

    private void clickbuttonLogin() {
        WebUI1.clickElement(buttonLogin);
    }

    private void clickCheckboxRemember() {
        WebUI1.clickElement(checkboxRememberMe);
    }

    private void clickLinkForgotPW() {
        WebUI1.clickElement(linkForgotPW);
    }

    public DashboardPage LoginCMS(String email, String password) {
       WebUI1.openURL(ConfigData.URL); // thay the cho   DriverManager.getDriver().get(url);
        WebUI1.waitForPageLoaded();
        setEmailInput(email);
        setPasswordInput(password);
        clickbuttonLogin();
        WebUI1.waitForPageLoaded();
        return new DashboardPage();
    }

    public void LoginCMS_SelectCheckboxRemember(String email, String password) {
        WebUI1.openURL(ConfigData.URL);
        WebUI1.waitForPageLoaded();
//        System.out.println("Navigate to url: " + url);
        setEmailInput(email);
        setPasswordInput(password);
        clickCheckboxRemember();
        clickbuttonLogin();
        WebUI1.waitForPageLoaded();
    }

    public void LoginCMS_ForgotPW(String email, String password) {
        WebUI1.openURL(ConfigData.URL);
        WebUI1.waitForPageLoaded();
        setEmailInput(email);
        setPasswordInput(password);
        clickLinkForgotPW();
    }

    public void verifyLoginSuccess() {
       // Assert.assertTrue(driver.findElement(By.xpath("//a[@class='aiz-side-nav-link active']")).isDisplayed());
        System.out.println("Verify Login Success");
        Assert.assertTrue(DriverManager.getDriver().findElement(menuDashBoard).isDisplayed(), "Menu dashboard not displayed");
    }

    public void verifyLoginFail() {
        System.out.println("Verify Login Fail");
        Assert.assertTrue(DriverManager.getDriver().findElement(errorEmailMessage).isDisplayed(), "Error Message not displayed");
        Assert.assertEquals(WebUI.getElementText(errorEmailMessage), "Invalid login credentials", "Content of error message not match");
    }

    public void verifyLoginFail_WithNullEmailField() {
        WebElement inputElement = driver.findElement(inputEmail);
        String validationMessage = inputElement.getAttribute("validationMessage");
        LogUtils.info(validationMessage);
        Assert.assertEquals(validationMessage, "Please fill out this field.", "The validation message of Email field not match.");
    }

    public void verifyLoginFail_WithNullPasswordField() {
        WebElement inputElement = driver.findElement(inputPassword);
        String validationMessage = inputElement.getAttribute("validationMessage");
        LogUtils.info(validationMessage);
        Assert.assertEquals(validationMessage, "Please fill out this field.", "The validation message of Password field not match.");
    }

    public void verifyCheckbox() {
        // Kiểm tra xem checkbox đã được chọn hay chưa
        boolean isChecked = (driver.findElement(checkboxRememberMe).isSelected());
        // Sử dụng assert để kiểm tra điều kiện
        Assert.assertTrue(isChecked, "checkbox chưa được chọn");
    }

    public void verifyNavigateForgotPW() {
        Assert.assertTrue(driver.findElement(By.xpath("//button[normalize-space()='Send Password Reset Link']")).isDisplayed());
    }

    public void verifyRedirectLoginPage() {
        Assert.assertTrue(driver.findElement(headerLoginPage).isDisplayed()
                && driver.findElement(descriptionLoginPage).isDisplayed());
        Assert.assertEquals(driver.findElement(headerLoginPage).getText(), "Welcome to Active eCommerce CMS", "Header of Login Page not match");
        Assert.assertEquals(driver.findElement(descriptionLoginPage).getText(), "Login to your account.", "Description of Login Page not match");
    }

}
