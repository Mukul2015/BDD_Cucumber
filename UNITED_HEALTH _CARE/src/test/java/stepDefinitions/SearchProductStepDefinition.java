package stepDefinitions;

import common.WebAPI;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import searchProduct.SearchProduct;

public class SearchProductStepDefinition extends WebAPI {
    static SearchProduct product;
    @BeforeStep
    public static void getInit(){
        product= PageFactory.initElements(driver, SearchProduct.class);
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
    @Then(":User can search {string}")
    public void user_can_search(String string) {
        product.clickSearchBox(string);
    }
    @Then(":User can click products")
    public void user_can_click_products() {
     product.clickProduct();
    }
    @Then(":User can click vision plan")
    public void user_can_click_vision_plan() {
     product.clickVision();
    }
    @Then(":User can enter zipCode {string}")
    public void user_can_enter_zip_code(String string) {
    product.clickZipCode(string);
    }
    @Then(":User can click search")
    public void user_can_click_search() {
    product.clickSearch();
    }
    @Then(":User can validate massage")
    public void user_can_validate_massage() {
    product.ValidateMgs("Provider Search");
    }
    @Then(":User can click health insurance plans texas")
    public void user_can_click_health_insurance_plans_texas() {
        product.clickTexasHealthPlan();
    }
    @Then(":User can click Short term health insurance plan")
    public void user_can_click_short_term_health_insurance_plan() throws InterruptedException {

        product.clickTexasShortTermHealthPlan();
        waitFor(5);
        handleNewTab1(driver);
    }
    @Then(":User can validate massage texas")
    public void user_can_validate_massage_texas() throws InterruptedException {
        waitFor(5);
        product.ValidateMgsTexas("Enter your info to find Short Term plan options");
    }
}
