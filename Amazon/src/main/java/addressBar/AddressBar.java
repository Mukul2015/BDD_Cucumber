package addressBar;
import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static addressBar.AddressBarWebElements.*;

public class AddressBar extends WebAPI {
    @FindBy(xpath = addressWebElement)
    public WebElement addressButton;
    @FindBy(xpath = enterZipCodeWebElement)
    public WebElement enterZipCode;
    @FindBy(xpath = applyZipCodeWebElement)
    public WebElement applyZipCode;
    @FindBy(xpath = doneButtonWebElement)
    public WebElement doneButton;
    @FindBy(xpath = verifyMgsWebElement)
    public WebElement verifyMgs;

    public void addressClick() {
        addressButton.click();
    }
    public void EnterZipCode(String name) {
        enterZipCode.sendKeys(name);
        applyZipCode.click();
    }
    public void clickContinue() {
        doneButton.click();
    }
    public void checkVerifyMgs(String exceptionText) {
        String actualText=verifyMgs.getText();
        Assert.assertEquals(actualText,exceptionText);
    }
}