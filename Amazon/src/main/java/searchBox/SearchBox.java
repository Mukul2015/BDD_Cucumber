package searchBox;
import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static searchBox.SearchBoxWebElements.*;
public class SearchBox extends WebAPI {

    @FindBy(id = searchBoxWebElement)
    public WebElement searchBox;
    @FindBy(id = searchButtonWebElement)
    public WebElement searchButton;

    @FindBy(xpath = verifyMgsWebElement)
    public WebElement verifyMgs;

    public void checkSearchBox(String name) {
        searchBox.sendKeys(name);
    }
    public void checkSearchButton() {
        searchButton.click();
    }
    public void verifySearch(String expectedText) {
        String actualText = verifyMgs.getText();
        Assert.assertEquals(actualText, expectedText);
    }
}
