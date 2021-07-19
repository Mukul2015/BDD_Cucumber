package homePageButton;

import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static homePageButton.ButtonWebElements.*;

public class HomeButton extends WebAPI {
	@FindBy(xpath = homePageLogo)
	public WebElement amazonLogo;

	@FindBy(xpath = bestSeller)
	public WebElement sellLink;
	@FindBy(xpath = pharmacyWebElement)
	public WebElement pharmacy;
	@FindBy(xpath = customerService)
	public WebElement customService;
	@FindBy(xpath = newRelease)
	public WebElement release;
	@FindBy(xpath = books)
	public WebElement amazonBooks;
	@FindBy(xpath = fashion)
	public WebElement amazonFashion;
	@FindBy(xpath = kindleBook)
	public WebElement kindleBooks;
	@FindBy(xpath = gift)
	public WebElement amazonGift;
	@FindBy(xpath = toys)
	public WebElement amazonToys;

	//validation
	@FindBy(xpath = validateSeller)
	public WebElement seller;
	@FindBy(xpath = validatePharmacy)
	public WebElement validatePhar;
	@FindBy(xpath = validateCustomerService)
	public WebElement customer;
	@FindBy(xpath = validateNewRelease)
	public WebElement releaseNew;
	@FindBy(xpath = validateBooks)
	public WebElement book;
	@FindBy(xpath = validateFashion)
	public WebElement fashionAmazon;
	@FindBy(xpath = validateKindleBook)
	public WebElement bookKindle;
	@FindBy(xpath = validateGift)
	public WebElement AmazonGift;
	@FindBy(xpath = validateToys)
	public WebElement toy;


	public void checkLogo() {
		boolean linkPresent=amazonLogo.isDisplayed();
		if(linkPresent==true){
			System.out.println("Amazon logo is present--passed");}
		else{
			System.out.println("Amazon logo is present--failed");
		}
	}
	public void sellButton() {
		sellLink.click();
	}
	public void todayButton() {
		pharmacy.click();
	}
	public void customerButton() {
		customService.click();
	}
	public void releaseButton() {
		release.click();
	}
	public void amazonBookButton() {
		amazonBooks.click();
	}
	public void amazonFashionButton() {
		amazonFashion.click();
	}
	public void kindleButton() {
		kindleBooks.click();
	}
	public void amazonGiftButton() {
		amazonGift.click();
	}
	public void amazonToysButton() {
		amazonToys.click();
	}
	public void verifySellButton(String expectedText) {
		String actualText = seller.getText();
		Assert.assertEquals(actualText, expectedText, "Product match");
	}
	public void verifyPharmacyButton(String expectedText) {

		String actualText = validatePhar.getAttribute("class");
		Assert.assertEquals(actualText, expectedText, "Product match");
	}
	public void verifyCustomerButton(String expectedText) {
		String actualText = customer.getText();
		Assert.assertEquals(actualText, expectedText, "Product match");
	}
	public void verifyReleaseButton(String expectedText) {
		String actualText = releaseNew.getText();
		Assert.assertEquals(actualText, expectedText, "Product match");
	}
	public void verifyAmazonBookButton(String expectedText) {

		String actualText = book.getText();
		Assert.assertEquals(actualText, expectedText, "Product match");
	}
	public void verifyAmazonFashionButton(String expectedText) {

		String actualText = fashionAmazon.getText();
		Assert.assertEquals(actualText, expectedText, "Product match");
	}
	public void verifyKindleButton(String expectedText) {

		String actualText = bookKindle.getText();
		Assert.assertEquals(actualText, expectedText, "Product match");
	}
	public void verifyAmazonGiftButton(String expectedText) {

		String actualText = AmazonGift.getText();
		Assert.assertEquals(actualText, expectedText, "Product match");
	}
	public void verifyAmazonToysButton(String expectedText) {

		String actualText = toy.getText();
		Assert.assertEquals(actualText, expectedText, "Product match");
	}

}

