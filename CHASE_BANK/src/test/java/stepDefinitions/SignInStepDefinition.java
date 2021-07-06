package stepDefinitions;
import common.WebAPI;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import signIn.SignIn;

import java.net.MalformedURLException;

public class SignInStepDefinition extends WebAPI {
    static SignIn signPage;

    @BeforeStep
    public static void getInit() {
        signPage = PageFactory.initElements(driver, SignIn.class);
    }
    @AfterStep
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            // Take a Screenshot
            final byte[] screenShot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot,"image/png","demo1");
        }
    }
    @After
    public void cleanUp() {
        closeBrowser();
    }
    @Given("User is in chase Bank Home Page")
    public void user_is_in_chase_bank_home_page() throws MalformedURLException {
        openBrowser("https://www.chase.com");
    }
    @Then("user gets the title of the HomePage")
    public void user_gets_the_title_of_the_home_page() {
    signPage.checkTitle();
    }
    @When("User can able to enter valid {string} and {string}")
    public void user_can_able_to_enter_valid_and(String string, String string2) throws InterruptedException {

        signPage.enterValidUserName_Password("Urme1338","mukul1986");
    }
    @When("User can click submit button")
    public void user_can_click_submit_button() throws InterruptedException {
        signPage.clickSignIn();
    }
    @Then("user gets the title of the page after logIn")
    public void user_gets_the_title_of_the_page_after_log_in() throws InterruptedException {
    signPage.checkTitleAfterSignIn();
    }
}
