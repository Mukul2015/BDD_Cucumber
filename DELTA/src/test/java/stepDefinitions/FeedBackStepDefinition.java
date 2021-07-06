package stepDefinitions;

import bookFlight.BookFlight;
import common.WebAPI;
import feedback.FeedBack;
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

public class FeedBackStepDefinition extends WebAPI {
    static FeedBack feedBack;
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
        feedBack = PageFactory.initElements(driver, FeedBack.class);
    }
    @After
    public void cleanUp() {
        closeBrowser();
    }
    @Given(":User can go to Delta Airline HomePage")
    public void user_can_go_to_delta_airline_home_page() throws MalformedURLException {
        openBrowser("https://www.delta.com");
    }
    @Then(":User can click FeedBack Button")
    public void user_can_click_feed_back_button() {
    feedBack.clickFeedBack();
    }

    @Then(":User can provide feedback rate")
    public void user_can_provide_feedback_rate() {
    feedBack.clickFeedRateStar();
    }
    @Then(":User can select feedback type")
    public void user_can_select_feedback_type() {
    feedBack.clickSelectFeedBack();
    }
    @Then(":User can provide feedback massage")
    public void user_can_provide_feedback_massage() {
    feedBack.clickFeedBackMassage();
    }
    @Then(":User can submit feedback request")
    public void user_can_submit_feedback_request() {
    feedBack.clickFeedBackSubmit();
    }
}
