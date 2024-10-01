package BT16_AllureReport.page;

import anhtester.com.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Add sản phẩm mới
     By buttonAddNewProduct = By.xpath("//span[normalize-space()='Add New Product']");
     By headerAddNewProduct = By.xpath("//h5[normalize-space()='Add New Product']");
    //Product Information
     By inputProductName = By.xpath("//label[contains(normalize-space(),'Product Name')]/following-sibling::div/input");
     By dropdownCategoryProduct = By.xpath("//button[@data-id='category_id']");
     By inputSearchCategoryProduct = By.xpath("//div[@class='bs-searchbox']//input[@aria-controls='bs-select-1']");
     By dropdownBrand = By.xpath("//button[@data-id='brand_id']");
    ;
     By inputSearchBrand = By.xpath("//div[@class='bs-searchbox']//input[@aria-controls='bs-select-2']");
     By inputUnit = By.xpath("//input[@name='unit']");
     By inputWeight = By.xpath("//input[@name='weight']");
     By inputMinPurchaseQty = By.xpath("//input[@name='min_qty']");
     By inputTags = By.xpath("//span[@role='textbox']");
    //product image
     By selectGalleryImages = By.xpath("//label[.='Gallery Images (600x600)']/following-sibling::div/div[@data-type='image']");
     By selectThumbnailImages = By.xpath("//label[contains(.,'Thumbnail Image')]/following-sibling::div/div[@data-type='image']");
    //Product Videos
     By inputVideoProvider = By.xpath("//button[@data-id='video_provider']");
     By inputLinkVideo = By.xpath("//input[@name='video_link']");
    //Product Variation
     By buttonEnableColors = By.xpath("//div[@class='col-md-1']//span");
     By dropdownColors = By.xpath("//button[@data-id='colors']");
     By selectColor1 = By.xpath("//a[@id='bs-select-4-0']");
     By selectColor2 = By.xpath("//a[@id='bs-select-4-1']");
     By selectColor3 = By.xpath("//a[@id='bs-select-4-2']");
     By dropdownAttributes = By.xpath("//button[@data-id='choice_attributes']");
     By inputSearchAttributes = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    //Product price + stock
     By inputUnitPrice = By.xpath("//input[@name='unit_price']");
     By inputDiscountRangeDate = By.xpath("//input[@placeholder='Select Date']");
     By inputDiscount = By.xpath("//input[@name='discount']");
     By inputQuantity = By.xpath("//input[@name='current_stock']");
     By inputSku = By.xpath("//input[@name='sku']");
     By inputExternalLinks = By.xpath("//input[@name='external_link']");
     By inputExternalLinkButtonText = By.xpath("//input[@name='external_link_btn']");
    //Product Description
     By inputDescription = By.xpath("//input[@name='min_qty']");
    //PDF Specification
     By uploadFilePDF = By.xpath("//div[@data-type='document']");
    //Button Save
     By buttonSavePublish = By.xpath("//button[normalize-space()='Save & Publish']");
     By buttonSaveUnpublish = By.xpath("//button[normalize-space()='Save & Publish']");

     By msgAddProductSuccess = By.xpath("//div[@role='alert']");

    //search lại sản phẩm vừa tạo
     By inputSearchProduct = By.xpath("//input[@id='search']");
     By firstItemOnProductTable = By.xpath("(//div[@class='col'])[2]//span");
    //Edit sản phẩm vừa tạo
     By buttonAllProducts = By.xpath("//span[normalize-space()='All products']");
     By headerAllProducts = By.xpath("//h1[normalize-space()='All products']");

     By firstIconProductEdit = By.xpath("(//form[@id='sort_products']//div//tr//td//a[@title='Edit'])[1]");
     By selectCategory1 = By.xpath("(//span[@class='text'][normalize-space()='------ TestExcel1'])[1]");
     By buttonUpdateProduct = By.xpath("//button[normalize-space()='Update Product']");
     By msgUpdateProductSuccess = By.xpath("//span[@data-notify='message']");

    //XD cac ham xu ly chinh tren trang nay
    public void clickButtonAddProduct() {
        WebUI.clickElement(buttonAddNewProduct);
    }

    public void verifyRedirectAddNewProductPageSuccess() {
        Assert.assertTrue(driver.findElement(headerAddNewProduct).isDisplayed(), "Không tìm thấy header page");
        Assert.assertEquals(driver.findElement(headerAddNewProduct).getText(), "Add New Product", "Header màn New Product không đúng");
    }

    public void inputDataProduct(String productName) {
        WebUI.setText(inputProductName, productName);

        WebUI.clickElement(dropdownCategoryProduct);
        WebUI.setText(inputSearchCategoryProduct, "Áo");
        WebUI.sleep(1);
        driver.findElement(inputSearchCategoryProduct).sendKeys(Keys.ENTER);
        WebUI.sleep(2);

        WebUI.clickElement(dropdownBrand);
        WebUI.setText(inputSearchBrand, "test");
        WebUI.sleep(1);
        driver.findElement(inputSearchBrand).sendKeys(Keys.ENTER);

        WebUI.setText(inputUnit, "VNĐ");
        driver.findElement(inputWeight).clear();
        WebUI.setText(inputWeight, "1.3");
        driver.findElement(inputMinPurchaseQty).clear();
        WebUI.setText(inputMinPurchaseQty, "100");
        WebUI.sleep(2);
        WebUI.setText(inputTags, "S");
        driver.findElement(inputTags).sendKeys(Keys.ENTER);
        WebUI.sleep(1);
        WebUI.setText(inputTags, "L");
        driver.findElement(inputTags).sendKeys(Keys.ENTER);
        WebUI.sleep(2);
        driver.findElement(inputUnitPrice).clear();
        WebUI.setText(inputUnitPrice, "50,000");
        WebUI.sleep(2);
        driver.findElement(inputDiscount).clear();
        WebUI.setText(inputDiscount, "0");
        WebUI.sleep(2);
        driver.findElement(inputQuantity).clear();
        WebUI.setText(inputQuantity, "25");
        WebUI.sleep(2);
        WebUI.clickElement(buttonSavePublish);
    }

    public void verifyAddProductSuccess() {
        Assert.assertTrue(driver.findElement(msgAddProductSuccess).isDisplayed(), "Lỗi, Không thêm được sản phẩm");
        Assert.assertEquals(driver.findElement(msgAddProductSuccess).getText(), "Product has been inserted successfully", "Nội dung message không chính xác");
    }

    public void clickButtonAllProducts() {
        WebUI.clickElement(buttonAllProducts);
    }

    public void verifyRedirectAllProductPageSuccess() {
        Assert.assertTrue(driver.findElement(headerAllProducts).isDisplayed(), "Không tìm thấy header page");
        Assert.assertEquals(driver.findElement(headerAllProducts).getText(), "All products", "Header màn All Products không đúng");
    }

    public void searchProduct() {
        WebUI.setText(inputSearchProduct, "Áo bò mẫu mới");
        driver.findElement(inputSearchProduct).sendKeys(Keys.ENTER);
    }
    public void clickButtonEditProducts() {
        WebUI.clickElement(firstIconProductEdit);
    }

    public void editProduct(String productName) {
        driver.findElement(inputProductName).clear();
        WebUI.setText(inputProductName, productName);
        WebUI.sleep(3);

        WebUI.clickElement(dropdownCategoryProduct);
        WebUI.setText(inputSearchCategoryProduct, "Áo");
        WebUI.sleep(1);
        driver.findElement(inputSearchCategoryProduct).sendKeys(Keys.ENTER);
        WebUI.sleep(2);

        WebUI.clickElement(dropdownBrand);
        WebUI.setText(inputSearchBrand, "test1");
        WebUI.sleep(1);
        driver.findElement(inputSearchBrand).sendKeys(Keys.ENTER);
        WebUI.sleep(2);

        driver.findElement(inputUnit).clear();
        WebUI.setText(inputUnit, "VNĐ");

        driver.findElement(inputWeight).clear();
        WebUI.setText(inputWeight, "1.3");
        WebUI.sleep(2);

        driver.findElement(inputMinPurchaseQty).clear();
        WebUI.setText(inputMinPurchaseQty, "100");
        WebUI.sleep(2);

        WebUI.setText(inputTags, "S");
        driver.findElement(inputTags).sendKeys(Keys.ENTER);
        WebUI.sleep(1);

        driver.findElement(inputUnitPrice).clear();
        WebUI.sleep(1);
        WebUI.setText(inputUnitPrice, "200");

        driver.findElement(inputDiscount).clear();
        WebUI.setText(inputDiscount, "0");
        WebUI.sleep(2);

//        driver.findElement(inputQuantity).clear();
//        WebUI.setText(inputQuantity, "100");
//        WebUI.sleep(2);

        WebUI.clickElement(buttonUpdateProduct);
    }

    public void verifyEditProductSuccess() {
        Assert.assertTrue(driver.findElement(msgUpdateProductSuccess).isDisplayed(), "Lỗi, Không thêm được sản phẩm");
        Assert.assertEquals(driver.findElement(msgUpdateProductSuccess).getText(), "Product has been updated successfully", "Nội dung message không chính xác");
    }

}
