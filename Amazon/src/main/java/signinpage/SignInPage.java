package signinpage;
import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static signinpage.SignInPageWebElements.*;

public class SignInPage extends WebAPI {

    @FindBy(xpath = signIn)
    public WebElement signInButton;
    @FindBy(xpath = sendMail)
    public WebElement signInEmail;
    @FindBy(xpath = continueElement)
    public WebElement continueButton;
    @FindBy(xpath = passWord)
    public WebElement signInPassword;
    @FindBy(xpath = submit)
    public WebElement signInSubmit;
    
    @FindBy(xpath=wrongSignIn)
    public WebElement replyMge;

    public void clickSignIn() {
        signInButton.click();
    }
    public void enterEmail(String email) {
        signInEmail.sendKeys(email);
        continueButton.click();
    }
    public void enterPassWord(String password) {
        signInPassword.sendKeys(password);
    }
    public void enterSignIn() {
        signInSubmit.click();
    }
    public void verifyName(String expectedText) {
    	 String actualText =replyMge.getText();
    	 Assert.assertEquals(actualText,expectedText,"name not match");
    }

}
