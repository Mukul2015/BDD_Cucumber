package stepDefinitions;
import common.WebAPI;
import findPharmacy.FindPharmacy;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import registation.Registration;

public class RegistrationStepDefinition extends WebAPI {
    static Registration page;
    @BeforeStep
    public static void getInit(){
        page= PageFactory.initElements(driver, Registration.class);
    }
    @AfterStep
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot,"image/png","demo1");
        }
    }
    @After
    public void cleanUp(){
        closeBrowser();
    }
    @Then(":User can click SignIn Button")
    public void user_can_click_sign_in_button() {
    page.clickSignIn();
    }
    @Then(":User can click Medicare Plan")
    public void user_can_click_medicare_plan() {
    page.clickMedicarePlan();
    }
    @Then(":User can click Register Button")
    public void user_can_click_register_button() {
    handleNewTab1(driver);
    page.clickRegistrationButton();
    }
    @Then(":User can enter {string} and {string}")
    public void user_can_enter_and(String string, String string2) {
    page.enterFirstName(string);
    page.enterLastName(string2);
    }
    @Then(":User can enter {string} and {string} and {string}")
    public void user_can_enter_and_and(String string, String string2, String string3) {
    page.enterDOB(string);
    page.enterZipCode(string2);
    page.enterPlanId(string3);
    }
    @Then(":User can  click submitButton")
    public void user_can_click_submit_button() {
    page.clickSubmit();
    }
}
