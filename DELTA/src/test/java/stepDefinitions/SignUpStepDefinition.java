package stepDefinitions;
import common.WebAPI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import signUp.SignUp;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

public class SignUpStepDefinition extends WebAPI {
    static SignUp sign;
    @AfterStep
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            // Take a Screenshot
            final byte[] screenShot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot,"image/png","demo1");
        }
    }
    @BeforeStep
    public static void getInit() {
        sign = PageFactory.initElements(driver, SignUp.class);
    }
    @After
    public void cleanUp() {
        closeBrowser();
    }
    @Given("User on Delta Airlines HomePage")
    public void user_on_delta_airlines_home_page() throws MalformedURLException {
        openBrowser("https://www.Delta.com/");
    }
    @Then("User can click SIGN UP Button")
    public void user_can_click_sign_up_button() {
        sign.clickSignUp();
    }
    @Then("User can select their Prefix")
    public void user_can_select_their_prefix(){
        sign.selectPrefix();
    }
    @Then("^User can fillUp firstName and lastName$")
    public void user_can_fill_up_first_name_and_last_name(DataTable name) {
        List<Map<String,String>> data = name.asMaps(String.class, String.class);
        for(Map<String,String> credential :data ){
           sign.firstName.sendKeys(credential.get("firstName"));
           sign.lastName.sendKeys(credential.get("lastName"));
        }
    }
    @Then("User can select their Gender")
    public void user_can_select_their_gender() {
        sign.selectGender();
    }
    @Then("User can fillUp their DOB month and day and year")
    public void user_can_fill_up_their_dob_month_and_day_and_year() throws InterruptedException {

       // sign.clickMonth();
        sign.clickDay();
        sign.clickYear();
    }
    @Then("User can select their Country")
    public void user_can_select_their_country() {
    sign.selectCountry();
    }
    @Then("User can select their AddressType")
    public void user_can_select_their_address_type() {
    sign.selectAddressType();
    }
    @Then("User can fillUp address and city and zipCode")
    public void user_can_fill_up_address_and_city_and_zip_code(DataTable dataTable) {
        List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);
        for(Map<String,String> address :data ){
            sign.addressLine.sendKeys(address.get("address"));
            sign.city.sendKeys(address.get("city"));
            sign.zipCode.sendKeys(address.get("zipCode"));
        }
    }
    @Then("User can select their CountryCode")
    public void user_can_select_their_country_code() {
        sign.selectCountryCode();

    }
    @Then("User can fillUp AreaCode and PhoneNumber and Email and ConfirmEmail")
    public void user_can_fill_up_area_code_and_phone_number_and_email_and_confirm_email(DataTable dataTable) {
        List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);
        for(Map<String,String> personal :data ){
            sign.areaCode.sendKeys(personal.get("AreaCode"));
            sign.phone.sendKeys(personal.get("PhoneNumber"));
            sign.email.sendKeys(personal.get("Email"));
            sign.confirmEmail.sendKeys(personal.get("ConfirmEmail"));
        }
    }
    @Then("User can fillUp UserName and Password and ConfirmPassword")
    public void user_can_fill_up_user_name_and_password_and_confirm_password(DataTable dataTable) {
        List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);
        for(Map<String,String> login :data ){
            sign.userName.sendKeys(login.get("UserName"));
            sign.password.sendKeys(login.get("Password"));
            sign.confirmPassword.sendKeys(login.get("ConfirmPassword"));
        }
    }
    @Then("User can select Question1")
    public void user_can_select_question1() {
    sign.selectFirstQuestion();
    }
    @Then("User can fillUp Answer1")
    public void user_can_fill_up_answer1() {
    sign.firstAnswer();
    }
    @Then("User can select Question2")
    public void user_can_select_question2() {

    }
    @Then("User can fillUp Answer2")
    public void user_can_fill_up_answer2() {

    }
    @Then("User can select their Language")
    public void user_can_select_their_language() {

    }
    @Then("User can select their SkyMiles")
    public void user_can_select_their_sky_miles() {

    }
    @Then("User can click Complete Button")
    public void user_can_click_complete_Button() {

    }

}

