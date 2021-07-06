package stepDefinitions;

import common.WebAPI;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import location.HotelLocation;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class LocationStepDefinition extends WebAPI {
    static HotelLocation location;

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
        location = PageFactory.initElements(driver, HotelLocation.class);
    }
    @After
    public void cleanUp() {
        closeBrowser();
    }
    @Given("user in hotel HomePage")
    public void user_in_hotel_home_page() throws MalformedURLException {
        openBrowser("https://www.hilton.com");

    }
    @Then("user can click Location button")
    public void user_can_click_location_button() {
        location.clickLocation();

    }
    @Then("user can select Asia zone")
    public void user_can_select_asia_zone() {
        location.clickAsiaZone();
    }
    @Then("user can select Indian Hotel")
    public void user_can_select_indian_Hotel() {
        location.clickCountryIndia();
    }
    @Then("user can select first one from the Indian Hotel list")
    public void user_can_select_first_one_from_the_Indian_Hotel_list() {

        location.clickSelectIndiaHotel();
    }
    @Then("user can select North America zone")
    public void user_can_select_north_america_zone() {
        location.clickNorthAmericaZone();
    }
    @Then("user can select Alaska Hotel")
    public void user_can_select_alaska_Hotel() {
        location.clickCountryAlaska();
    }
    @Then("user can select first one from the Alaska Hotel list")
    public void user_can_select_first_one_from_the_Alaska_Hotel_list() {

        location.clickSelectAlaskaHotel();
    }
}
