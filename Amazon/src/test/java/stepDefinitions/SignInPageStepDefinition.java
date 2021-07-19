package stepDefinitions;

import accountList.AccountList;
import common.WebAPI;
import io.cucumber.datatable.DataTable;
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
import java.util.List;
import java.util.Map;

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
    @Then("User can enter Email and continuePage and enter password")
    public void user_can_enter_email_and_continue_page_and_enter_password(DataTable dataTable) {
        List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);
        for(Map<String,String> info :data ){
            signIn.signInEmail.sendKeys(info.get("Email"));
            signIn.continueButton.click();
            signIn.signInPassword.sendKeys(info.get("password"));
        }
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
