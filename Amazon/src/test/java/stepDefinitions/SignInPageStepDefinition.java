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
import signinpage.SignInPage;

import java.net.MalformedURLException;

public class SignInPageStepDefinition extends WebAPI {
    static SignInPage signIn;
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a Screenshot
            final byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", "demo1");
        }
    }
    @BeforeStep
    public static void getInit() {
        signIn = PageFactory.initElements(driver, SignInPage.class);
    }
    @After
    public void cleanUp() {
        closeBrowser();
    }
    @Given("User in Amazon homepage")
    public void User_in_Amazon_homepage() throws MalformedURLException {
        openBrowser("https://www.Amazon.com/");
    }
    @Then("User can click signIn Button")
    public void user_can_click_sign_in_button() {
     signIn.clickSignIn();
    }
    @Then("User can enter {string} and continuePage")
    public void user_can_enter_and_continue_page(String string) {
     signIn.enterEmail(string);
    }
    @Then("User can enter {string}")
    public void user_can_enter(String string) {
       signIn.enterPassWord(string);
    }
    @Then("User can enter SignIn")
    public void user_can_enter_sign_in() {
      signIn.enterSignIn();
        }
    @Then("User can verify SignIn")
    public void user_can_verify_sign_in() {
     signIn.verifyName("There was a problem");
    }
}
