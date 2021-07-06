package stepDefinitions;

import common.WebAPI;
import footerLink.FooterLink;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class FooterLinkStepDefinition extends WebAPI {
    static FooterLink link ;

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
        link = PageFactory.initElements(driver, FooterLink.class);
    }
    @After
    public void cleanUp() {
        closeBrowser();
    }
    @Given(":User in Hilton hotel homePage1")
    public void user_in_hilton_hotel_home_page1() throws MalformedURLException {
        openBrowser("https://www.hilton.com");
    }
    @Then(":User can click all footerLink")
    public void user_can_click_all_footer_link() throws InterruptedException {
    link.takeFooterLink();

    }
}
