package stepDefinitions;

import bookFlight.BookFlight;
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

import java.net.MalformedURLException;

public class BookFlightStepDefinition extends WebAPI {
    static BookFlight flight;

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
        flight = PageFactory.initElements(driver, BookFlight.class);
    }
    @After
    public void cleanUp() {
        closeBrowser();
    }

    @Given(":user in DeltaAirline HomePage")
    public void user_in_delta_airline_home_page() throws MalformedURLException {
            openBrowser("https://www.delta.com");
    }
    @Then(":user can click Book button")
    public void user_can_click_book_button() {
    flight.clickBook();
    }
    @Then(":user can select {string} as Departure")
    public void user_can_select_as_departure(String string) {
    flight.clickDepartureFlight();
    flight.clickDepartureFlightInput(string);
    flight.selectDeparture();
    }
    @Then(":user can select {string} as Arrival")
    public void user_can_select_as_arrival(String string) throws InterruptedException {
    flight.clickArrivalFlight();
    flight.clickArrivalFlightInput(string);
    flight.selectArrivalFlight();
    }
    @Then(":user can select Trip")
    public void user_can_select_trip() {
    flight.clickTripeType();
    flight.clickRoundTripeType();
    }
    @Then(":user can select Departure Date")
    public void user_can_select_departure_date() {
    flight.clickDepartureDate();

    }
    @Then(":user can select Arrival Date")
    public void user_can_select_arrival_date() {
    flight.clickNextDate();
    flight.clickFlightDateDone();
    }
    @Then(":user can select number of Passenger")
    public void user_can_select_number_of_passenger() {
    flight.clickPassengerNumber();
    }
    @Then(":user can click show fareButton")
    public void user_can_click_show_fare_button() {
    flight.clickShowFare();
    }
    @Then(":user can select best fare")
    public void user_can_select_best_fare_for() {
    flight.clickBestFare();

    }
    @Then(":user can submit request")
    public void user_can_submit_request() {
        flight.clickSubmitButton();
    }
    @Then(":user can verify Compare Nearby Airports")
    public void user_can_verify_Compare_Nearby_Airports() throws InterruptedException {
    flight.validateCompare("Compare Nearby Airports");
    }

}
