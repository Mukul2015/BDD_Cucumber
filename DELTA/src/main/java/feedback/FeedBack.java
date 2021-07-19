package feedback;

import common.WebAPI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static feedback.FeedBackWebElement.*;

public class FeedBack extends WebAPI {
    @FindBy(xpath = feedBackWebElement)
    public WebElement feedBack;
    @FindBy(xpath = feedRateStarWebElement)
    public WebElement feedRateStar;
    @FindBy(xpath = selectFeedBackWebElement)
    public WebElement selectFeedBack;
    @FindBy(xpath = feedBackMassageWebElement)
    public WebElement feedBackMassage;
    @FindBy(xpath = selectOtherFeedBackWebElement)
    public WebElement selectOtherFeedBack;
    @FindBy(xpath = feedBackSubmitWebElement)
    public WebElement feedBackSubmit;
    @FindBy(xpath = checkInTripWebElement)
    public WebElement checkInTrip;


    public void clickFeedBack(){
        feedBack.click();
    }
    public void clickFeedRateStar(){
        feedRateStar.click();
    }
    public void clickSelectFeedBack(){
        selectFeedBack.click();
    }
    public void clickSelectOtherFeedBack() throws InterruptedException {
        waitFor(3);
        selectOtherFeedBack.click();
    }
    public void clickCheckInTrip() throws InterruptedException {
        waitFor(3);
        checkInTrip.click();
    }
    public void clickFeedBackMassage(){
        feedBackMassage.sendKeys("i like delta Airline");
    }
    public void clickFeedBackSubmit(){
        feedBackSubmit.click();
    }
}
