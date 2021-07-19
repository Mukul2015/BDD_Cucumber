package stepDefinitions;

import addressBar.AddressBar;
import common.WebAPI;
import homePageButton.HomeButton;
import io.cucumber.java.After;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class HomePageButtonStepDefinition extends WebAPI {
    static HomeButton home;
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a Screenshot
            final byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", "demo1");
        }
    }
    @BeforeStep
    public static void getInit() {
        home = PageFactory.initElements(driver, HomeButton.class);
    }
    @After
    public void cleanUp() {
        closeBrowser();
    }
    @Given("User in Amazon homePage")
    public void user_in_amazon_home_page() throws MalformedURLException {
        openBrowser("https://www.Amazon.com/");
    }
    @Then("User Can check Amazon Logo in Homepage is present or not")
    public void user_can_check_amazon_logo_in_homepage_is_present_or_not() {
      home.checkLogo();
    }
    @Then("User can click Best Seller Button")
    public void user_can_click_best_seller_button() {
      home.sellButton();
    }
    @Then("User can validate Amazon Best Sellers Mgs")
    public void user_can_validate_amazon_best_sellers_mgs() {
        home.verifySellButton("Amazon Best Sellers");
    }
    @Then("User can click today Dells Button")
    public void user_can_click_today_dells_button() {
        home.todayButton();
    }
    @Then("User can validate pharmacy Mgs")
    public void user_can_validate_pharmacy_mgs() {
        home.verifyPharmacyButton("pui-icon sub-nav-logo-img");
    }
    @Then("User can click customer Service Button")
    public void user_can_click_customer_service_button() {
        home.customerButton();
    }
    @Then("User can validate customer Service Mgs")
    public void user_can_validate_customer_service_mgs() {
        home.verifyCustomerButton("Hello. What can we help you with?");
    }
    @Then("User can click new Release Button")
    public void user_can_click_new_release_button() {
        home.releaseButton();
    }
    @Then("User can validate new Release Mgs")
    public void user_can_validate_new_release_mgs() {
        home.verifyReleaseButton("Amazon Hot New Releases");
    }
    @Then("User can click books Button")
    public void user_can_click_books_button() {
        home.amazonBookButton();
    }
    @Then("User can validate books Mgs")
    public void user_can_validate_books_mgs() {
        home.verifyAmazonBookButton("Popular in Books");
    }
    @Then("User can click fashion Button")
    public void user_can_click_fashion_button() {
        home.amazonFashionButton();
    }
    @Then("User can validate fashion Mgs")
    public void user_can_validate_fashion_mgs() {
        home.verifyAmazonFashionButton("Women");
    }
    @Then("User can click kindleBook Button")
    public void user_can_click_kindle_book_button() {
        home.kindleButton();
    }
    @Then("User can click gift Button")
    public void user_can_click_gift_button() {
        home.amazonGiftButton();
    }
    @Then("User can validate gift Mgs")
    public void user_can_validate_gift_mgs() {
        home.verifyAmazonGiftButton("Gift Cards");
    }
    @Then("User can click toys Button")
    public void user_can_click_toys_button() {
        home.amazonToysButton();
    }
    @Then("User can validate toys Mgs")
    public void user_can_validate_toys_mgs() {
        home.verifyAmazonToysButton("Toys & Games");
    }

}
