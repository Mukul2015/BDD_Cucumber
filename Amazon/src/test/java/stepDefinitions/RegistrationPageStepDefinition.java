package stepDefinitions;
import common.WebAPI;
import io.cucumber.java.After;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import registrationpage.RegistrationPage;

import java.net.MalformedURLException;

public class RegistrationPageStepDefinition extends WebAPI {
    static RegistrationPage page;
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a Screenshot
            final byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", "demo1");
        }
    }
    @BeforeStep
    public static void getInit() {
        page = PageFactory.initElements(driver, RegistrationPage.class);
    }
    @After
    public void cleanUp() {
        closeBrowser();
    }

    @Given("User in amazon homepage")
    public void user_in_amazon_homepage() throws MalformedURLException {
        openBrowser("https://www.Amazon.com/");
    }
    @Then("User can hover and click SignIn")
    public void user_can_hover_and_click_sign_in() {
      page.txtClickButton1();
    }
    @Then("User can click create amazon account")
    public void user_can_click_create_amazon_account() {
        page.txtAccountButton1();
    }
    @Then("User can enter name {string} email {string} password {string} rePassword {string}")
    public void user_can_enter_name_email_password_re_password(String string, String string2, String string3, String string4) {
        page.createAccountName(string);
        page.createAccountEmail(string2);
        page.createAccountPassword(string3);
        page.createAccountRePassword(string4);
    }
    @Then("User can click create your amazon account")
    public void user_can_click_create_your_amazon_account() {
        page.AccountContinueButton();
    }
    @Then("User can verify Mgs")
    public void user_can_verify_Mgs() {
        page.verifyMassage("Email address already in use");
    }
}
