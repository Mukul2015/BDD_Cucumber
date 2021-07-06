package join;

import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static join.JoinWebElement.*;

public class JoinUser extends WebAPI {
    @FindBy(xpath = joinButtonWebElement)
    public WebElement joinButton;
    @FindBy(xpath = firstNameWebElement)
    public WebElement firstName;
    @FindBy(xpath = lastNameWebElement)
    public WebElement lastName;
    @FindBy(xpath = phoneAreaCodeWebElement)
    public WebElement phoneAreaCode;
    @FindBy(xpath = emailWebElement)
    public WebElement email;
    @FindBy(xpath = countryWebElement)
    public WebElement country;
    @FindBy(xpath = addressWebElement)
    public WebElement address;
    @FindBy(xpath = postalCodeWebElement)
    public WebElement postalCode;
    @FindBy(xpath = cityWebElement)
    public WebElement city;
    @FindBy(xpath = stateWebElement)
    public WebElement state;
    @FindBy(xpath = passwordElement)
    public WebElement password;
    @FindBy(xpath = confirmPasswordWebElement)
    public WebElement confirmPassword;
    @FindBy(xpath = SubmitWebElement)
    public WebElement Submit;
    @FindBy(xpath = errorMgsWebElement)
    public WebElement errorMgs;

    public void clickJoinButton()
    {
        joinButton.click();
    }
    public void clickFirstNLastName(String first,String last) {
        firstName.sendKeys(first);
        lastName.sendKeys(last);
    }
//    public void selectPhone(String phone) {
//        phoneAreaCode.sendKeys(phone);
//    }
    public void clickEmail1(String name) {
        email.sendKeys(name);
    }
    public void selectCountry(){
        selectOptionByVisibleText(country,"USA");
    }
    public void sendEmailConfirmEmail() {

    }
    public void clickSubmit()
    {
        Submit.click();
    }
    public void verifyError(String expected) {
    String actual =errorMgs.getText();
        Assert.assertEquals(expected,actual);
    }
}
