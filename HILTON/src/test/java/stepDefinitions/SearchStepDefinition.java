package stepDefinitions;

import common.WebAPI;
import freemarker.core.StringArraySequence;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import join.JoinUser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import searchHotal.SearchHotel;

public class SearchStepDefinition extends WebAPI {
 static SearchHotel hotel;

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
        hotel = PageFactory.initElements(driver, SearchHotel.class);
    }
    @After
    public void cleanUp() {
        closeBrowser();
    }
    @Then(":User can click on searchBox")
    public void user_can_click_on_search_box() {
    hotel.clickSearch();
    }
    @Then(":User can enter cityName {string} and select")
    public void user_can_enter_city_name_and_select(String string){
    hotel.clickSearchHotel(string);
    }
    @Then(":User can select city")
    public void user_can_select_city() throws InterruptedException {
    hotel.selectSearchHotel();
    }
    @Then(":User can select entry and exits date")
    public void user_can_select_entry_and_exits_date() throws InterruptedException {
    hotel.reservationDate();
    }
    @Then(":User can select guest Number")
    public void user_can_select_guest_number() {
    hotel.clickGuest();
    }
    @Then(":User can select special Rate")
    public void user_can_select_special_rate() {
    hotel.clickSpecialRate();
    }
    @Then(":User can click find Hotel")
    public void user_can_click_find_hotel() {
    hotel.clickSubmit();
    }
}
