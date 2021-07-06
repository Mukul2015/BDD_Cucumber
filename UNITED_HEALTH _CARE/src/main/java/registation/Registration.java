package registation;

import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static registation.RegistrationWebElements.*;

public class Registration extends WebAPI {
    @FindBy(xpath = signInWebElement)
    public WebElement signIn;
    @FindBy(xpath = medicarePlanWebElement)
    public WebElement medicarePlan;
    @FindBy(xpath = registrationWebElement)
    public WebElement registrationButton;
    @FindBy(xpath = firstNameWebElement)
    public WebElement firstName;
    @FindBy(xpath = lastNameWebElement)
    public WebElement lastName;
    @FindBy(xpath = DOBWebElement)
    public WebElement DOB;
    @FindBy(xpath = zipCodeWebElement)
    public WebElement zipCode;
    @FindBy(xpath = planMemberIdWebElement)
    public WebElement planMemberId;
    @FindBy(xpath = continueWebElement)
    public WebElement continueButton;

    public void clickSignIn(){
        signIn.click();
    }
    public void clickMedicarePlan(){
        medicarePlan.click();
    }
    public void clickRegistrationButton(){
        registrationButton.click();
    }
    public void enterFirstName(String fName){
        firstName.sendKeys(fName);
    }
    public void enterLastName(String lName){
        lastName.sendKeys(lName);
    }
    public void enterDOB(String date){
        DOB.sendKeys(date);
    }
    public void enterZipCode(String zip){
        zipCode.sendKeys(zip);
    }
    public void enterPlanId(String plan){
        planMemberId.sendKeys(plan);
    }
    public void clickSubmit(){
        continueButton.click();
    }
}
