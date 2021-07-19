package stepDefinitions;
import accountList.AccountList;
import common.WebAPI;
import io.cucumber.java.After;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class AccountListStepDefinition extends WebAPI {
    static AccountList account;
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a Screenshot
            final byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", "demo1");
        }
    }
    @BeforeStep
    public static void getInit() {
        account = PageFactory.initElements(driver, AccountList.class);
    }
    @After
    public void cleanUp() {
        closeBrowser();
    }

    @Given("User in Amazon SearchBox")
    public void user_in_amazon_home_page() throws MalformedURLException {
      openBrowser("https://www.Amazon.com/");
    }
    @Then("User hover AccountList Button")
    public void user_hover_account_list_button(){
        account.HoverOver();
    }
    @Then("User can click  SignIn Button")
    public void user_can_click_sign_in_button() {
   account.clickSignIn();
    }
    @Then("User can logIn with email {string}")
    public void user_can_log_in_with_email(String string) {
       account.enterEmailId(string);
    }
    @Then("User can logIn with password {string}")
    public void user_can_log_in_with_password(String string) {
      account.enterPassword(string);
    }
    @Then("User can click Browsing History")
    public void user_can_click_browsing_history() {
        account.clickBrowseHistory();
    }
    @Then("User can Verify Browser History mgs")
    public void user_can_verify_browser_history_mgs() {
        account.verifyHistory("\n" +
                "            Browsing history\n" +
                "         ");
    }
    @Then("User can click order button")
    public void user_can_click_order_button() {
        account.clickOrderButton();
    }
    @Then("User can Verify your order mgs")
    public void user_can_verify_your_order_mgs() {
        account.verifyOrder("Your Orders");
    }
    @Then("User can click Account Button")
    public void user_can_click_account_button() {
      account.clickAccountButton();
    }
    @Then("User can Verify Your Account mgs")
    public void user_can_verify_your_account_mgs() {
        account.verifyAccount("Your Account");
    }
    @Then("User can click WatchList")
    public void user_can_click_watch_list() {
        account.clickWatchListButton();
    }
    @Then("User can Verify Purchases & Rentals mgs")
    public void user_can_verify_purchases_rentals_mgs() {
        account.verifyWatchList("Purchases & Rentals");
    }
    @Then("User can click Prime Membership")
    public void user_can_click_prime_membership() {
        account.clickPrimeMember();
    }
    @Then("User can verify free trial mgs")
    public void user_can_verify_free_trial_mgs() {
        account.verifyPrimeMember("Start your 30-day free trial");
    }
    @Then("User can click Create a List")
    public void user_can_click_create_a_list() {
        account.clickCreateList();
    }
    @Then("User can Verify Shopping List mgs")
    public void user_can_verify_shopping_list_mgs() {
        account.verifyCreateList("Your Lists");
    }
    @Then("User can click ContentDevices")
    public void user_can_click_content_devices() {
        account.clickContentDevice();
    }
    @Then("User can Verify ContentDevices mgs")
    public void user_can_verify_content_devices_mgs() {
        account.verifyContentDevice("Manage Your Content and Devices");
    }
}