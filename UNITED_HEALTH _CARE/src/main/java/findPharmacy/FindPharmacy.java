package findPharmacy;

import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static findPharmacy.FindPharmacyWebElements.*;

public class FindPharmacy extends WebAPI {
    @FindBy(xpath = findDoctorWebElement)
    public WebElement findDoctor;
    @FindBy(xpath = pharmacyWebElement)
    public WebElement pharmacy;
    @FindBy(xpath = pharmacyNameWebElement)
    public WebElement pharmacyName;
    @FindBy(css = zipCodeWebElement)
    public WebElement zipCode;
    @FindBy(xpath = searchWebElement)
    public WebElement search;
    @FindBy(xpath = verifyMgsWebElement)
    public WebElement verifyMgs;
    @FindBy(xpath = verifyMgs1WebElement)
    public WebElement verifyMgs1;


    public void clickFindDoctor(){
        findDoctor.click();
    }
    public void clickPharmacy(){
        pharmacy.click();
    }
    public void enterPharmacyAddress(String PharmacyName){
        pharmacyName.sendKeys(PharmacyName);
    }
    public void enterAddressZip(String ZipCode){
        zipCode.sendKeys(ZipCode);
    }
    public void clickSearch(){
        search.click();
    }

//    public void validateMgs(String expected){
//        String actual=verifyMgs.getText();
//        Assert.assertEquals(expected,actual);
//    }
//    public void validateMgs1(String expected){
//        String actual=verifyMgs1.getText();
//        Assert.assertEquals(expected,actual);
//    }
}

