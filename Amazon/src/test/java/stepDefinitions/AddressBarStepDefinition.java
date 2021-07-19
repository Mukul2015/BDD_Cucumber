package stepDefinitions;

import addressBar.AddressBar;
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

public class AddressBarStepDefinition extends WebAPI {
    static AddressBar address;
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a Screenshot
            final byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", "demo1");
        }
    }
    @BeforeStep
    public static void getInit() {
        address = PageFactory.initElements(driver, AddressBar.class);
    }
    @After
    public void cleanUp() {
        closeBrowser();
    }
    @Given("User in Amazon Homepage")
    public void user_in_Amazon_Homepage() throws MalformedURLException {
        openBrowser("https://www.Amazon.com/");
    }
    @Then("User can click Address Bar")
    public void user_can_click_address_bar() {
        address.addressClick();
    }
    @Then("User can enter {string} zip Code")
    public void user_can_enter_zip_code(String string) {
        address.EnterZipCode(string);
    }
    @Then("User can click continue Button")
    public void user_can_click_continue_button() {
        address.clickContinue();
    }
    @Then("User can verify user Address")
    public void user_can_verify_user_address() {
        address.checkVerifyMgs("Elmhurst 11373");
    }
}
