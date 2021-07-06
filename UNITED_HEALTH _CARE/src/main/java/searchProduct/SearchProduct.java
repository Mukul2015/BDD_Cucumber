package searchProduct;
import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static searchProduct.SearchProductWebElements.*;

public class SearchProduct extends WebAPI {
    @FindBy(xpath = searchBoxWebElement)
    public WebElement searchBox;
    @FindBy(xpath = searchWebElement)
    public WebElement search;
    @FindBy(xpath = productWebElement)
    public WebElement product;
    @FindBy(xpath = visionWebElement)
    public WebElement vision;
    @FindBy(xpath = zipCodeWebElement)
    public WebElement zipCode;
    @FindBy(xpath = searchButtonWebElement)
    public WebElement searchButton;
    @FindBy(xpath = validateMgsWebElement)
    public WebElement validateMgs;

    public void clickSearchBox(String name){
        searchBox.sendKeys(name);
        search.click();
    }
    public void clickProduct(){
        product.click();
    }
    public void clickVision(){
        vision.click();
    }
    public void clickZipCode(String zip){
        handleNewTab1(driver);
        zipCode.sendKeys(zip);
    }
    public void clickSearch(){
        searchButton.click();
    }
    public void ValidateMgs(String expectedText){
        String actualText =validateMgs.getText();
        Assert.assertEquals(expectedText,actualText);
    }
}
