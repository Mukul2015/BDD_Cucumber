package productDropDown;
import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static productDropDown.DropDownWebElement.*;

public class DropDownPage extends WebAPI {
//	Boolean found = false;
	@FindBy(xpath=selectProduct)
	public WebElement productSelect;
    @FindBy(id = searchBoxWebElement)
    public WebElement searchBox;
    @FindBy(id = searchButtonWebElement)
    public WebElement searchButton;
    @FindBy(xpath = searchTextWebElement)
    public WebElement searchText;
	
	public void markProduct() {
		productSelect.click();
	}
    public void listProduct() {
    	Select select =new Select(productSelect);
    	select.selectByVisibleText("Smart Home");
    }
    public void checkSearchBox(String Name) {
        searchBox.sendKeys(Name);
        searchButton.click();
    }
    public void verifySearchBox(String expectedText) {
        String actualText = searchText.getText();
        Assert.assertEquals(actualText, expectedText, "Product match");
    }
}
