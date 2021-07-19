package registrationpage;
import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static registrationpage.RegistrationPageWebElements.*;
public class RegistrationPage extends WebAPI {
    @FindBy(xpath = txtClick)
    public WebElement txtClickButton;
    @FindBy(xpath = txtAccountClick)
    public WebElement txtAccountButton;
    @FindBy(xpath = txtCustomer)
    public WebElement txtCustomerName;
    @FindBy(xpath = txtEmail)
    public WebElement txtEmailName;
    @FindBy(xpath = txtClickPass)
    public WebElement txtPass;
    @FindBy(xpath = txtUserPass)
    public WebElement setUserName;
    @FindBy(xpath = txtClickContinue)
    public WebElement txtContinueButton;

    @FindBy(xpath=replyTextMassage)
    public WebElement replyMassage  ;

    public void txtClickButton1() {
        txtClickButton.click();
    }
    public void txtAccountButton1() {
        txtAccountButton.click();
    }
    public void createAccountName(String name) {
            txtCustomerName.sendKeys(name);
        }
    public void createAccountEmail( String email) {
            txtEmailName.sendKeys(email);
        }
    public void createAccountPassword(String password ) {
            txtPass.sendKeys(password);
        }
    public void createAccountRePassword(String rePassword) {
            setUserName.sendKeys(rePassword);
        }
    public void AccountContinueButton() {
        txtContinueButton.click();
    }
    public void verifyMassage(String expectedText){
        String actualText=replyMassage.getText();
        Assert.assertEquals(actualText,expectedText);
    }
}
