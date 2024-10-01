package BT13_TestListener.page;

import anhtester.com.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BrandPage {
    private WebDriver driver;

    public BrandPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver);
    }

    private By headerBrand = By.xpath("//h1[normalize-space()='All Brands']");
    private By inputSearchBrand = By.xpath("//input[@id='search']");
    private By inputNameBrand = By.xpath("//input[@name='name']");
    private By chooseImageLogo = By.xpath("//label[contains(.,'Logo')]/following-sibling::div[@data-type='image']");
    private By editImageLogo = By.xpath("//div[@class='input-group']");
    private By inputMetaTitle = By.xpath("//input[@name='meta_title']");
    private By inputMetaDescription = By.xpath("//textarea[@name='meta_description']");
    private By buttonSaveBrand = By.xpath("//button[normalize-space()='Save']");
    private By firstItemListBrand = By.xpath("(//div[@class='card-body'])[1]//tr[1]//td[2]");
    private By optionEditBrand = By.xpath("(//a[@title='Edit'])[1]");
    private By optionDeleteBrand = By.xpath("(//a[@title='Delete'])[1]");
    private By confirmDeleteBrand = By.xpath("//a[@id='delete-link']");
    private By messageDeleteBrandSuccess = By.xpath("//span[@data-notify='message']");//Brand has been deleted successfully
    private By messageAddBrandSuccess = By.xpath("//span[@data-notify='message']"); //Brand has been inserted successfully
    private By messageEditBrandSuccess = By.xpath(""); //Brand has been updated successfully

    public void verifyRedirectBrandPageSuccess() {
        Assert.assertTrue(driver.findElement(headerBrand).isDisplayed(), "Không tìm thấy  header page");
        Assert.assertEquals(driver.findElement(headerBrand).getText(), "All Brands", "Header màn Category không đúng");
    }

    public void inputDataBrand(String brandName, String titleBrand,String descriptionBrand) {
        driver.findElement(inputNameBrand).clear();
        WebUI.setText(inputNameBrand, brandName);
        WebUI.clickElement(chooseImageLogo);
        WebUI.clickElement(By.xpath("//div[@title='Profile AnhTester 512px.jpg']"));
        WebUI.clickElement(By.xpath("//button[normalize-space()='Add Files']"));
        WebUI.setText(inputMetaTitle, titleBrand);
        WebUI.setText(inputMetaDescription, descriptionBrand);
        WebUI.sleep(2);
        WebUI.clickElement(buttonSaveBrand);
    }

    public void verify_AddBrand_Success() {
        Assert.assertTrue(driver.findElement(messageAddBrandSuccess).isDisplayed(), "Lỗi, Không thêm được category");
        Assert.assertEquals(driver.findElement(messageAddBrandSuccess).getText(), "Brand has been inserted successfully", "Nội dung message không chính xác");
    }

    public void verifyAddBrandFail_WithNullNameField() {
        WebElement inputElement = driver.findElement(inputNameBrand);
        String validationMessage = inputElement.getAttribute("validationMessage");
        System.out.println(validationMessage);
        Assert.assertEquals(validationMessage, "Please fill out this field.", "The validation message of Email field not match.");
    }

    public void searchBrand(String nameBrand) {
        WebUI.setText(inputSearchBrand, nameBrand);
        // WebUI.clickElement(firstItemListBrand);
    }

    public void editBrand() {
        WebUI.clickElement(optionEditBrand);
    }
    public void editDataBrand(String brandName, String titleBrand,String descriptionBrand) {
        driver.findElement(inputNameBrand).clear();
        WebUI.setText(inputNameBrand, brandName);
        WebUI.clickElement(editImageLogo);
        WebUI.clickElement(By.xpath("//div[@title='Profile AnhTester 512px.jpg']"));
        WebUI.clickElement(By.xpath("//button[normalize-space()='Add Files']"));
        driver.findElement(inputMetaTitle).clear();
        WebUI.setText(inputMetaTitle, titleBrand);
        driver.findElement(inputMetaDescription).clear();
        WebUI.setText(inputMetaDescription, descriptionBrand);
        WebUI.sleep(1);
        WebUI.clickElement(buttonSaveBrand);
    }
    public void deleteBrand() {
        WebUI.clickElement(optionDeleteBrand);
        WebUI.clickElement(confirmDeleteBrand);
    }

    public void verify_EditBrand_Success() {
        Assert.assertTrue(driver.findElement(messageEditBrandSuccess).isDisplayed(), "Lỗi, Không thêm được category");
        Assert.assertEquals(driver.findElement(messageEditBrandSuccess).getText(), "Brand has been updated successfully", "Nội dung message không chính xác");
    }

    public void verify_DeleteBrand_Success() {
        Assert.assertTrue(driver.findElement(messageDeleteBrandSuccess).isDisplayed(), "Lỗi, Không thêm được category");
        Assert.assertEquals(driver.findElement(messageDeleteBrandSuccess).getText(), "Brand has been deleted successfully", "Nội dung message không chính xác");
    }
}

