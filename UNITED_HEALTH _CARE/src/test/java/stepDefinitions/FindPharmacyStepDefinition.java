package stepDefinitions;

import common.WebAPI;
import findPharmacy.FindPharmacy;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

import static findPharmacy.FindPharmacyWebElements.*;

public class FindPharmacyStepDefinition extends WebAPI {
 static FindPharmacy pharmacy;
 @BeforeStep
 public static void getInit(){
     pharmacy= PageFactory.initElements(driver,FindPharmacy.class);
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
    @Given(":User in United Health Care HomePage")
    public void user_in_united_health_care_home_page() throws MalformedURLException {
        openBrowser("https://www.uhc.com");
    }
    @Then(":User can click find doctor Button")
    public void user_can_click_find_doctor_button() {
        pharmacy.clickFindDoctor();
    }
    @Then(":User can click pharmacy Button")
    public void user_can_click_pharmacy_button() {
        pharmacy.clickPharmacy();
    }
    @Given(":User can enter pharmacy Name {string} and zip {string}")
    public void user_can_enter_pharmacy_name_and_zip(String string,String string2) throws InterruptedException {
     waitFor(3);
     handleNewTab1(driver);

    pharmacy.enterPharmacyAddress(string);
    pharmacy.enterAddressZip(string2);
    }
    @Then(":User can click search Button")
    public void user_can_click_search_button() {
    pharmacy.clickSearch();
    }
//    @Then(":User can verify pharmacy")
//    public void user_can_verify_pharmacy() {
//    pharmacy.validateMgs(queensDrugMgs);
//    //pharmacy.validateMgs1(cvsMgs);

    }

