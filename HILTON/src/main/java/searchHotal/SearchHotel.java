package searchHotal;

import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static searchHotal.SearchWebElement.*;

public class SearchHotel extends WebAPI {
    @FindBy(xpath = searchWebElement)
    public WebElement search;
    @FindBy(xpath = selectCityWebElement)
    public WebElement selectCity;
    @FindBy(xpath = dateWebElement)
    public WebElement date;
    @FindBy(xpath = firstDateWebElement)
    public WebElement firstDate;
//    @FindBy(xpath = nextPageWebElement)
//    public WebElement nextPage;
//    @FindBy(xpath = nextDateWebElement)
//    public WebElement nextDate;
    @FindBy(xpath = closeButtonWebElement)
    public WebElement closeButton;
    @FindBy(xpath = guestWebElement)
    public WebElement guest;
    @FindBy(xpath = adultIncWebElement)
    public WebElement adultInc;
    @FindBy(xpath = kidsIncWebElement)
    public WebElement kidsInc;
    @FindBy(xpath = closeWebElement)
    public WebElement close;
    @FindBy(xpath = specialRateWebElement)
    public WebElement specialRate;
    @FindBy(xpath = specialRateRadioButtonWebElement)
    public WebElement specialRateRadioButton;
    @FindBy(xpath = closeSpecialRateButtonWebElement)
    public WebElement closeSpecialRateButton;
    @FindBy(xpath = findHotelWebElement)
    public WebElement findHotel;

    public void clickSearch(){
        search.click();
    }
    public void clickSearchHotel(String hotel) {
        search.sendKeys(hotel);
    }
    public void selectSearchHotel() throws InterruptedException {
        waitFor(3);
        selectCity.click();

    }
    public void reservationDate() throws InterruptedException {
        date.click();
        firstDate.click();
        waitFor(3);
//        nextPage.click();
//        nextDate.click();
        closeButton.click();
    }
    public void clickGuest(){
        guest.click();
        adultInc.click();
        kidsInc.click();
        close.click();
    }
    public void clickSpecialRate(){
        specialRate.click();
        specialRateRadioButton.click();
    }
    public void clickSubmit(){
        closeSpecialRateButton.click();
        findHotel.click();
    }
}
