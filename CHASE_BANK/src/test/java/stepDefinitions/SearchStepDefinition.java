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
import search.SearchButton;
import java.net.MalformedURLException;

public class SearchStepDefinition extends WebAPI {
    static SearchButton search;

    @BeforeStep
    public static void getInit() {
        search = PageFactory.initElements(driver, SearchButton.class);
    }

    @AfterStep
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a Screenshot
            final byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", "demo1");
        }
    }

    @After
    public void cleanUp() {
        closeBrowser();
    }

    @Given("User can go to  chase Bank homePage")
    public void user_can_go_to_chase_bank_home_page() throws MalformedURLException, InterruptedException {
        waitFor(5);
        openBrowser("https://www.chase.com");
    }

    @Then("User can able to click search Button")
    public void user_can_able_to_click_search_button() throws InterruptedException {

        search.clickSearchButton();
    }
    @Then("User can able to enter HomeLoan in  search field")
    public void user_can_able_to_enter_home_loan_in_search_field() throws InterruptedException {

        search.homeLoanSearchField("Home Loan");
    }
    @Then("User can able to submit Search request")
    public void user_can_able_to_submit_search_request() throws InterruptedException {

        search.Search();
    }

    @Then("User can able to click on Understanding your loan options")
    public void user_can_able_to_click_on_understanding_your_loan_options() throws InterruptedException {

        search.clickHomeLoanOptions();
    }

    @When("User can verify Mortgage options page title")
    public void user_can_verify_mortgage_options_page_title() {

        search.verifyMortgageOptions("Mortgage options");
//    }
//    @Then("User can able to enter StudentLoan in  search field")
//    public void user_can_able_to_enter_student_loan_in_search_field() throws InterruptedException {
//
//    search.studentLoanSearchField("Student Loan");
//    }
//    @Then("User can able to click on Chase Student Hub")
//    public void user_can_able_to_click_on_chase_student_hub() throws InterruptedException {
//
//    search.clickStudentLoanOptions();
//    }
//    @When("User can verify Get set for every step page title")
//    public void user_can_verify_get_set_for_every_step_page_title() {
//
//        search.verifyStudentHub("Get set for every step");
//    }
//    @Then("User can able to enter CarLoan in  search field")
//    public void user_can_able_to_enter_car_loan_in_search_field() throws InterruptedException {
//
//        search.CarSearchField("Car Loan");
//    }
//    @Then("User can able to click on MyCar")
//    public void user_can_able_to_click_on_my_car() throws InterruptedException {
//
//    search.clickCarLoanOptions();
//    }
//    @When("User can verify resource just for you page title")
//    public void user_can_verify_resource_just_for_you_page_title() {
//
//    search.verifyMyCar("resource just for you");
//    }
    }
}