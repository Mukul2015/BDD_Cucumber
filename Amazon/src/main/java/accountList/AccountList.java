package accountList;

import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static accountList.AccountListWebElements.*;

public class  AccountList extends WebAPI {

	@FindBy(xpath= accountListHoverWebElement)
	public WebElement accountListHoverOver;
	@FindBy(xpath= signInWebElement)
	public WebElement signIn;
	@FindBy(xpath= emailIdWebElement)
	public WebElement emailId;
	@FindBy(xpath= continueWebElement)
	public WebElement continueButton;
	@FindBy(xpath= passwordWebElement)
	public WebElement password;
	@FindBy(xpath= enterLogInWebElement)
	public WebElement enterLogIn;
	@FindBy(xpath = browserHistoryWebElement)
	public WebElement browseHistory;
	@FindBy(xpath = AccountButtonWebElement)
	public WebElement AccountButton;
	@FindBy(xpath = OrderButtonWebElement)
	public WebElement OrderButton;
	@FindBy(xpath = WatchListButtonWebElement)
	public WebElement WatchListButton;
	@FindBy(xpath = PrimeMemberWebElement)
	public WebElement PrimeMember;
	@FindBy(xpath = CreateListWebElement)
	public WebElement CreateList;
	@FindBy(xpath = ContentDevicesWebElement)
	public WebElement ContentDevice;
	@FindBy(xpath = KindleWebElement)
	public WebElement Kindle;
	@FindBy(xpath = CancelWebElement)
	public WebElement Cancel;

	@FindBy(xpath = validateBrowserHistoryWebElement)
	public WebElement BrowserHistoryLogo;
	@FindBy(xpath = validateYourAccountWebElement)
	public WebElement validateYourAccount;
	@FindBy(xpath = validatePrimeMemberWebElement)
	public WebElement validatePrimeMember;
	@FindBy(xpath = validateOrderWebElement)
	public WebElement validateOrder;
	@FindBy(xpath = validateWatchListWebElement)
	public WebElement validateWatchList;
	@FindBy(xpath = validateContentDeviceWebElement)
	public WebElement validateContentDevice;
	@FindBy(xpath = validateCreateYourListsWebElement)
	public WebElement validateCreateYourList;
	@FindBy(xpath = validateKindleWebElement)
	public WebElement validateKindle;

	public void HoverOver(){
		Actions action = new Actions(driver);
		action.moveToElement(accountListHoverOver).build().perform();
	}
	public void clickSignIn(){
		signIn.click();
	}
	public void enterEmailId(String name){
		emailId.sendKeys(name);
		continueButton.click();
	}
	public void enterPassword(String name){
		password.sendKeys(name);
		enterLogIn.click();
	}
	public void clickBrowseHistory() {
		browseHistory.click();
	}
	public void clickAccountButton() {
		AccountButton.click();
	}
	public void clickOrderButton() {
		OrderButton.click();
	}
	public void clickWatchListButton() {
		WatchListButton.click();
	}
	public void clickPrimeMember() {
		PrimeMember.click();
	}
	public void clickCreateList() {
		CreateList.click();
	}
	public void clickContentDevice() {
		ContentDevice.click();
	}
	public void clickKindleWebElement() {
		Kindle.click();
	}
	public void clickCancel() {
		Cancel.click();
	}
		public void verifyHistory(String expectedText) {
			String actualText = BrowserHistoryLogo.getAttribute("h1");
			Assert.assertEquals(actualText, expectedText, "logo match");
		}
		public void verifyAccount(String expectedText) {
			String actualText = validateYourAccount.getText();
			Assert.assertEquals(actualText, expectedText, "logo match");
		}
		public void verifyOrder(String expectedText) {
			String actualText = validateOrder.getText();
			Assert.assertEquals(actualText, expectedText, "logo match");
		}
		public void verifyWatchList(String expectedText) {
			String actualText = validateWatchList.getText();
			Assert.assertEquals(actualText, expectedText, "logo match");
		}
		public void verifyContentDevice(String expectedText) {
			String actualText = validateContentDevice.getText();
			Assert.assertEquals(actualText, expectedText, "logo match");
		}
		public void verifyKindle(String expectedText) {
			String actualText = validateKindle.getText();
			Assert.assertEquals(actualText, expectedText, "logo match");
		}
		public void verifyCreateList(String expectedText) {
			String actualText = validateCreateYourList.getText();
			Assert.assertEquals(actualText, expectedText, "logo match");
		}
		public void verifyPrimeMember(String expectedText) {
			String actualText = validatePrimeMember.getAttribute("value");
			Assert.assertEquals(actualText, expectedText, "logo match");
		}

		//this 2 line alternate this 2 line down.
//		action.moveToElement(new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(accountListHoverOver))).perform();
//		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='nav-al-your-account']/a[4]/span"))).click();


}
