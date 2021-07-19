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
     openBrowser("https://www.delta.com/");
    }
    @Then(":user can click Book button")
    public void user_can_click_book_button() {
       flight.clickBook();
       flight.clickDepartureFlight();
    }
    @Then(":user can select {string} as Departure")
    public void user_can_select_as_departure(String string) {
       flight.clickDepartureFlightInput(string);
       flight.selectDepartureFlight();
    }
       @Then(":user can select {string} as Departure2")
    public void user_can_select_as_departure2(String string) {
       flight.clickDepartureFlightInput(string);
       flight.selectDeparture2Flight();
    }
       @Then(":user can select {string} as Departure3")
    public void user_can_select_as_departure3(String string) {
       flight.clickDepartureFlightInput(string);
       flight.selectDeparture3Flight();
    }
    @Then(":user can select {string} as Arrival")
    public void user_can_select_as_arrival(String string) {
       flight.clickArrivalFlight();
       flight.clickArrivalFlightInput(string);
       flight.selectArrivalFlight();
    }
    @Then(":user can select {string} as Arrival2")
    public void user_can_select_as_arrival2(String string)  {
       flight.clickArrivalFlight();
       flight.clickArrivalFlightInput(string);
       flight.selectArrival2Flight();
    }
    @Then(":user can select {string} as Arrival3")
    public void user_can_select_as_arrival3(String string) {
       flight.clickArrivalFlight();
       flight.clickArrivalFlightInput(string);
       flight.selectArrival3Flight();

    }
    @Then(":user can select Trip")
    public void user_can_select_trip() {
      flight.clickTripeType();
      flight.clickRoundTripeType();
      flight.clickTripeType();
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
    public void user_can_select_number_of_passenger() throws InterruptedException {
      flight.clickPassengerNumber();
    }

    @Then(":user can submit request")
    public void user_can_submit_request() throws InterruptedException {
      flight.selectNextButton();
    }

    @Then(":user can verify Compare Nearby Airports")
    public void user_can_verify_compare_nearby_airports() throws InterruptedException {
      flight.validateCompare("It's Simple: No Change Fees");
    }

}
