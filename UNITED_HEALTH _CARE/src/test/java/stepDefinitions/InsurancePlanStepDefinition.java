package stepDefinitions;

import common.WebAPI;
import insurancePlan.InsurancePlan;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class InsurancePlanStepDefinition extends WebAPI {

     static InsurancePlan Insurance;
     @BeforeStep
     public static void getInit(){
         Insurance= PageFactory.initElements(driver,InsurancePlan.class);
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
    @Given("User in United Health care page")
    public void user_in_united_health_care_page() throws MalformedURLException {
         openBrowser("https://www.uhc.com");
    }
    @Then("User can click Insurance plan Button")
    public void user_can_click_insurance_plan_button() throws InterruptedException {
         waitFor(2);
        Insurance.clickInsurancePlan();
    }
    @Then("User can click Medicare Button")
    public void user_can_click_medicare_button() {
        Insurance.clickMedicare();
    }
    @Then("User can enter zipcode {string}")
    public void user_can_enter_zipcode(String zipcode1) {
        Insurance.enterZipcode(zipcode1);
    }
    @Then("User can click find Medicare plan Button")
    public void user_can_click_find_Medicare_plan_button() {
        Insurance.clickFindMedicare();
    }
    @Then("User can click medicare advantage plan Button")
    public void user_can_click_medicare_advantage_plan_button() throws InterruptedException {
        waitFor(3);
        handleNewTab1(driver);
        Insurance.clickViewPlan();
    }
    @Then("User can click Get started Button")
    public void user_can_click_get_started_button() {
        Insurance.clickGetStart();
    }
    @And("User can verify Medicare massage")
    public void user_can_verify_Medicare_massage() {
        Insurance.verifyMassage1("Get Started");
    }
    @Then("User can click Medicaid Button")
    public void user_can_click_medicaid_button() {
        Insurance.clickMedicaid();
    }
    @Then("User can click find Medicaid plan Button")
    public void user_can_click_find_medicaid_plan_button() {
        Insurance.clickFindPlan();
    }
    @Then("User can click MarketPlace")
    public void user_can_click_market_place() throws InterruptedException {
        waitFor(3);
        handleNewTab1(driver);
        Insurance.clickMarketPlace();
    }
    @Then("User view plan Details")
    public void user_view_plan_details() throws InterruptedException {
         waitFor(3);
        Insurance.clickViewPlanDetail();
    }
    @Then("User can verify Medicaid massage")
    public void user_can_verify_medicaid_massage() {
        Insurance.verifyMassage("Essential Plan");
    }

}
