package signUp;
import common.WebAPI;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Map;
import static signUp.SignUpWebElements.*;

public class SignUp extends WebAPI {

@FindBy(xpath = signUpWebElement)
    public WebElement signUp;
@FindBy(xpath = prefixWebElement)
    public WebElement prefix;
@FindBy(xpath = mrWebElement)
    public WebElement mr;
@FindBy(xpath = firstNameWebElement)
   public WebElement firstName;
@FindBy(xpath = lastNameWebElement)
   public WebElement lastName;
@FindBy(xpath = genderSelectWebElement)
    public WebElement genderSelect;
@FindBy(xpath = maleWebElement)
    public WebElement male;
@FindBy(xpath = monthWebElement)
    public WebElement month;

@FindBy(xpath = selectMonthWebElement)
    public WebElement selectMonth;

@FindBy(xpath = mayWebElement)
    public WebElement may;
@FindBy(xpath = dayWebElement)
    public WebElement day;
@FindBy(xpath = oneWebElement)
    public WebElement one;
@FindBy(xpath = yearWebElement)
    public WebElement year;
@FindBy(xpath = twentyWebElement)
    public WebElement twenty;
@FindBy(xpath = countryWebElement)
    public WebElement country;
@FindBy(xpath = selectCountryWebElement)
    public WebElement selectCountry;
@FindBy(xpath = addressTypeWebElement)
    public WebElement addressType;
@FindBy(xpath = homeTypeWebElement)
    public WebElement homeType;
@FindBy(xpath = addressLineWebElement)
    public WebElement addressLine;
@FindBy(xpath = cityWebElement)
    public WebElement city;
@FindBy(xpath = zipCodeWebElement)
    public WebElement zipCode;
@FindBy(xpath = countryCodeWebElement)
    public WebElement countryCode;
@FindBy(xpath = selectCountryCodeWebElement)
    public WebElement selectCountryCode;
@FindBy(xpath = areaCodeWebElement)
    public WebElement areaCode;
@FindBy(xpath = phoneWebElement)
    public WebElement phone;
@FindBy(xpath = emailWebElement)
    public WebElement email;
@FindBy(xpath = confirmEmailWebElement)
    public WebElement confirmEmail;
@FindBy(xpath = userNameWebElement)
    public WebElement userName;
@FindBy(xpath = passwordWebElement)
    public WebElement password;
@FindBy(xpath = confirmPasswordWebElement)
    public WebElement confirmPassword;
@FindBy(xpath = question1WebElement)
    public WebElement question1;
@FindBy(xpath = selectQuestion1WebElement)
    public WebElement selectQuestion1;
@FindBy(xpath = answer1WebElement)
    public WebElement answer1;
@FindBy(xpath = question2WebElement)
    public WebElement question2;
@FindBy(xpath = selectQuestion2WebElement)
    public WebElement selectQuestion2;
@FindBy(xpath = answer2WebElement)
    public WebElement answer2;
@FindBy(xpath = languageWebElement)
    public WebElement language;
@FindBy(xpath = selectLanguageWebElement)
    public WebElement selectLanguage;
@FindBy(xpath = selectWebElement)
    public WebElement select;
@FindBy(xpath = completeWebElement)
    public WebElement complete;

public void clickSignUp(){
    signUp.click();
}
public void selectPrefix(){
    prefix.click();
    mr.click();
}
public void clickFirstLastName(DataTable name){
    List<Map<String,String>> data = name.asMaps(String.class, String.class);
    for(Map<String,String> credential :data ){
    firstName.sendKeys(credential.get("firstName"));
    lastName.sendKeys(credential.get("lastName"));
}
}
public void selectGender(){
    genderSelect.click();
    male.click();
}
public void clickMonth() throws InterruptedException {
    month.click();
    waitFor(2);
    may.click();
//    mouseHoverByXpath1(mayWebElement);
//    selectOptionByVisibleText(selectMonth,"May");

    }
public void clickDay() throws InterruptedException {
    day.click();
    waitFor(2);
    one.click();

    }
public void clickYear() throws InterruptedException {
    year.click();
    waitFor(2);
    twenty.click();
    }

public void selectCountry(){
    country.click();
    selectCountry.click();
    }
public void selectAddressType(){
    addressType.click();
    homeType.click();
    }
public void clickAddressCityZipCode(DataTable dataTable){
    List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);
    for(Map<String,String> address :data ){
        addressLine.sendKeys(address.get("address"));
        city.sendKeys(address.get("city"));
        zipCode.sendKeys(address.get("zipCode"));
    }
    }
    public void selectCountryCode(){
      countryCode.click();
      selectCountryCode.click();
    }
    public void selectFirstQuestion(){
        question1.click();
        selectQuestion1.click();
    }
    public void firstAnswer(){
        answer1.sendKeys("Tomi");
    }
}
