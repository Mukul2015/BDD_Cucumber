package insurancePlan;
import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static insurancePlan.InsurancePlanWebElements.*;

public class InsurancePlan extends WebAPI {
    @FindBy(xpath = InsurancePlanWebElement)
    public WebElement InsurancePlan;
    @FindBy(xpath = medicareWebElement)
    public WebElement medicare;
    @FindBy(xpath = medicaidWebElement)
    public WebElement medicaid;
    @FindBy(xpath = zipcodeWebElement)
    public WebElement zipcode;
    @FindBy(xpath = findMedicareWebElement)
    public WebElement findMedicare;
    @FindBy(xpath = findPlanWebElement)
    public WebElement findPlan;
    @FindBy(xpath = viewPlanWebElement)
    public WebElement viewPlan;
    @FindBy(xpath = marketPlaceWebElement)
    public WebElement marketPlace;
    @FindBy(xpath = getStartWebElement)
    public WebElement getStart;
    @FindBy(xpath = viewPlanDetailWebElement)
    public WebElement viewPlanDetail;
    @FindBy(xpath = verifyEssentialPlanWebElement)
    public WebElement verifyEssentialPlan;
    @FindBy(xpath = verifyGetStartedWebElement)
    public WebElement verifyGetStarted;

    public void clickInsurancePlan() throws InterruptedException {
        waitFor(2);
        InsurancePlan.click();
    }
    public void clickMedicare(){
        medicare.click();
    }
    public void clickMedicaid(){
        medicaid.click();
    }
    public void enterZipcode(String zipcode1){
        zipcode.sendKeys(zipcode1);
    }
    public void clickFindMedicare(){
        findMedicare.click();
    }
    public void clickFindPlan(){
        findPlan.click();
    }
    public void clickViewPlan(){
        viewPlan.click();
    }
    public void clickMarketPlace(){
        marketPlace.click();
    }
    public void clickGetStart(){
        getStart.click();
    }
    public void clickViewPlanDetail() throws InterruptedException {
        waitFor(2);
        viewPlanDetail.click();
    }
    public void verifyMassage(String expected){
        String actual =verifyEssentialPlan.getText();
        Assert.assertEquals(actual,expected);
    }
    public void verifyMassage1(String expected){
        String actual =verifyGetStarted.getText();
        Assert.assertEquals(actual,expected);
    }

}