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
import productDropDown.DropDownPage;

import java.net.MalformedURLException;

public class ProductDropDownStepDefinition extends WebAPI {
    static DropDownPage page;
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a Screenshot
            final byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", "demo1");
        }
    }
    @BeforeStep
    public static void getInit() {
        page = PageFactory.initElements(driver, DropDownPage.class);
    }
    @After
    public void cleanUp() {
        closeBrowser();
    }
    @Given("user in amazon homepage")
    public void user_in_amazon_homepage() throws MalformedURLException {
        openBrowser("https://www.Amazon.com/");
    }
    @Then("User can select product Using dropDown")
    public void user_can_select_product_using_drop_down() {
    page.markProduct();
    page.listProduct();
    }
    @Then("User can search samsungTv {string} Using dropDown")
    public void user_can_search_samsung_tv_using_drop_down(String string) {
        page.checkSearchBox(string);
    }
    @Then("User can verify samsungTv product Mgs")
    public void user_can_verify_samsung_tv_product_mgs() {
        page.verifySearchBox("\"samsung tv\"");
    }
    @Then("User can search samsung phone {string} Using dropDown")
    public void user_can_search_samsung_phone_samsung_phone_using_drop_down(String string) {
        page.checkSearchBox(string);
    }
    @Then("User can verify samsung phone product Mgs")
    public void user_can_verify_samsung_phone_product_mgs() {
        page.verifySearchBox("\"samsung phone\"");
    }
    @Then("User can search samsung phone case {string} Using dropDown")
    public void user_can_search_samsung_phone_case_using_drop_down(String string) {
        page.checkSearchBox(string);
    }
    @Then("User can verify samsungPhoneCase product Mgs")
    public void user_can_verify_samsung_phone_case_product_mgs() {
        page.verifySearchBox("\"samsung phone case\"");
    }
    @Then("User can search sonyTv {string} Using dropDown")
    public void user_can_search_sony_tv_using_drop_down(String string) {
        page.checkSearchBox(string);
    }
    @Then("User can verify sonyTv product Mgs")
    public void user_can_verify_sony_tv_product_mgs() {
        page.verifySearchBox("\"sony Tv\"");
    }
}
