package stepDefinitions;
import common.WebAPI;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import search.SearchProduct;

import java.net.MalformedURLException;

public class SearchStepDefinition extends WebAPI {
    static SearchProduct product;

    @AfterStep
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a Screenshot
            final byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", "demo1");
        }
    }
    @BeforeStep
    public static void getInit() {
        product = PageFactory.initElements(driver, SearchProduct.class);
    }
    @After
    public void cleanUp() {
        closeBrowser();
    }
    @Given(":user in Delta HomePage")
    public void user_in_delta_home_page() throws MalformedURLException {
        openBrowser("https://www.delta.com");
    }
    @Then(":user can click search button")
    public void user_can_click_search_button() {
    product.clickSearchButton();
    }
    @Then(":User Can enter {string} in searchBox")
    public void user_can_enter_in_search_box(String string) {
    product.clickSearchField(string);
    }
//    @Then(":User Can enter jkf {string} in searchBox")
//    public void user_can_enter_jkf_in_search_box(String string) {
//        product.clickSearchJfkField(string);
//    }
    @Then(":user can click searchField search button")
    public void user_can_click_searchField_search_button() {
    product.clickSearch();
    }
    @Then(":user can click Flight Partners")
    public void user_can_click_Flight_Partners() {
    product.clickFlightPartner();
    }
    @Then(":user can click Cashless airport")
    public void user_can_click_Cashless_airport() {
    product.ClickCashlessAirports();
    }
    @Then(":user can click NewYork Jfk")
    public void user_can_click_NewYork_Jfk() {
    product.clickJfkField();
    }

    @Then(":user can validate Friends")
    public void user_can_validate_Friends() {
    product.verifyFriends("Friends in High Places");
    }
    @Then(":user can validate NewYorkCity")
    public void user_can_validate_NewYorkCity() {
    product.validateNewYork("New York City");
    }
    @Then(":user can validate Cashless")
    public void user_can_validate_Cashless() {
    product.validateCashless("Cashless Airports");
    }
}
