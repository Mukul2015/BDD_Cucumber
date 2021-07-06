package stepDefinitions;
import common.WebAPI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import join.JoinUser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

public class JoinStepDefinition extends WebAPI {
    static JoinUser user ;

    @AfterStep
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a Screenshot
            final byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", "demo1");
        }
    }
    @BeforeStep
    public static void getInit() {
        user = PageFactory.initElements(driver, JoinUser.class);
    }
    @After
    public void cleanUp() {
        closeBrowser();
    }
    @Given(":User in Hilton hotel homePage")
    public void user_in_hilton_hotel_home_page() throws MalformedURLException {
        openBrowser("https://www.hilton.com");
    }
    @Then(":User can click join Button")
    public  void User_can_click_join_Button(){
        user.clickJoinButton();
    }
    @Then(":User can enter {string} and {string}")
    public void user_can_enter_and(String string, String string2) {
    user.clickFirstNLastName(string,string2);
    }
//    @Then(":User can enter{String}")
//    public void user_can_enter(String string) {
//        user.selectPhone(string);
//    }
    @Then(":User can enter email{string}")
    public void user_can_enter_email(String string)throws InterruptedException {
        user.clickEmail1(string);
    }
    @Then(":User can select country")
    public void user_can_select_country() throws InterruptedException {
     user.selectCountry();
     waitFor(3);
    }
    @Then(":User can enter address and zip and city")
    public void user_can_enter_address_and_zip_and_city(DataTable dataTable) {
        List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);
        for(Map<String,String> personal :data ){
            user.address.sendKeys(personal.get("address"));
            user.postalCode.sendKeys(personal.get("zip"));
        }
    }
    @Then(":User can enter password and confirmPassword")
    public void user_can_enter_password_and_confirm_password(DataTable dataTable) {
        List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);
        for(Map<String,String> personal :data ){
            user.password.sendKeys(personal.get("password"));
            user.confirmPassword.sendKeys(personal.get("confirmPassword"));
        }
    }
    @Then(":User in click joinFree button")
    public void user_in_click_join_free_button() {
     user.clickSubmit();
    }
    @Then(":User can verify Error Massage")
    public void user_can_verify_error_massage() {
        user.verifyError("Let's fix a few things:");
    }
}

