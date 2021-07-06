package signIn;
import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import static signIn.SignInWebElement.*;

public class SignIn extends WebAPI {

    @FindBy(xpath = iframeWebElement)
    public WebElement iframe;
    @FindBy(xpath = userNameWebElement)
    public WebElement userName;
    @FindBy(xpath = passwordWebElement)
    public WebElement password;
    @FindBy(xpath = radioWebElement)
    public WebElement radioButton;
    @FindBy(xpath = submitWebElement)
    public WebElement submit;

    public void checkTitle(){
    String title =driver.getTitle();
    System.out.println(title);
    }
    public void enterValidUserName_Password(String UserName,String password1) throws InterruptedException {
        iframeHandle(iframe);
        waitFor(5);
        userName.sendKeys(UserName);
        password.sendKeys(password1);
    }
    public void clickSignIn(){
        radioButton.click();
        submit.click();
    }
    public void checkTitleAfterSignIn() throws InterruptedException {
        waitFor(10);
        String title =driver.getTitle();
        System.out.println(title);
    }

}
