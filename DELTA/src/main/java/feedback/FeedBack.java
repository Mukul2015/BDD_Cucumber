package feedback;

import common.WebAPI;
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
    @FindBy(xpath = feedBackSubmitWebElement)
    public WebElement feedBackSubmit;

    public void clickFeedBack(){
        feedBack.click();
    }
    public void clickFeedRateStar(){
        feedRateStar.click();
    }
    public void clickSelectFeedBack(){
        selectFeedBack.click();
    }
    public void clickFeedBackMassage(){
        feedBackMassage.sendKeys("i like delta Airline");
    }
    public void clickFeedBackSubmit(){
        feedBackSubmit.click();
    }
}
