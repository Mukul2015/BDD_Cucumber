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
import searchBox.SearchBox;

import java.net.MalformedURLException;

public class SearchBoxStepDefinition extends WebAPI {
    static SearchBox search;
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a Screenshot
            final byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", "demo1");
        }
    }
    @BeforeStep
    public static void getInit() {
        search = PageFactory.initElements(driver, SearchBox.class);
    }
    @After
    public void cleanUp() {
        closeBrowser();
    }

    @Given("user in Amazon Homepage")
    public void user_in_amazon_homepage() throws MalformedURLException {
        openBrowser("https://www.Amazon.com/");
    }
    @Then("User can enter camera {string} and search")
    public void user_can_enter_camera_and_search(String string) {
        search.checkSearchBox(string);
        search.checkSearchButton();
    }
    @Then("User can verify camera Product Mgs")
    public void user_can_verify_camera_product_mgs() {
        search.verifySearch("\"camera\"");
    }
    @Then("User can enter car {string} and search")
    public void user_can_enter_car_and_search(String string) {
        search.checkSearchBox(string);
        search.checkSearchButton();
    }
    @Then("User can verify car Product Mgs")
    public void user_can_verify_car_product_mgs() {
        search.verifySearch("\"car\"");
    }
    @Then("User can enter purell {string} and search")
    public void user_can_enter_purell_and_search(String string) {
        search.checkSearchBox(string);
        search.checkSearchButton();
    }
    @Then("User can verify purell Product Mgs")
    public void user_can_verify_purell_product_mgs() {
        search.verifySearch("\"purell\"");
    }
    @Then("User can enter pen {string} and search")
    public void user_can_enter_pen_and_search(String string) {
        search.checkSearchBox(string);
        search.checkSearchButton();
    }
    @Then("User can verify pen Product Mgs")
    public void user_can_verify_pen_product_mgs() {
        search.verifySearch("\"pen\"");
    }
}
