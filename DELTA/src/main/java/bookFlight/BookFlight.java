package bookFlight;

import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static bookFlight.BookFlightWebElement.*;

public class BookFlight extends WebAPI {
    @FindBy(xpath = bookFlightWebElement)
    public WebElement bookFlight;
    @FindBy(xpath = departureFlightWebElement)
    public WebElement departureFlight;
    @FindBy(xpath = departureInputWebElement)
    public WebElement departureInput;
    @FindBy(xpath = selectDepartureWebElement)
    public WebElement selectDeparture;
    @FindBy(xpath = arrivalFlightWebElement)
    public WebElement arrivalFlight;
    @FindBy(xpath = arrivalInputWebElement)
    public WebElement arrivalInput;
    @FindBy(xpath = selectArrivalWebElement)
    public WebElement selectArrival;
    @FindBy(xpath = tripeTypeWebElement)
    public WebElement tripeType;
    @FindBy(xpath = roundTripeTypeWebElement)
    public WebElement roundTripeType;
    @FindBy(xpath = calenderWebElement)
    public WebElement calender;
    @FindBy(xpath = departureDateWebElement)
    public WebElement departureDate;
    @FindBy(xpath = nextDateWebElement)
    public WebElement nextDate;
    @FindBy(xpath = arrivalDateWebElement)
    public WebElement arrivalDate;
    @FindBy(xpath = FlightDateDoneWebElement)
    public WebElement FlightDateDone;
    @FindBy(xpath = passengerNumberWebElement)
    public WebElement passengerNumber;
    @FindBy(xpath = selectPassengerWebElement)
    public WebElement selectPassenger;
    @FindBy(xpath = showFareWebElement)
    public WebElement showFare;
    @FindBy(xpath = bestFareWebElement)
    public WebElement bestFare;
    @FindBy(xpath = selectBestFareWebElement)
    public WebElement selectBestFare;
    @FindBy(xpath = submitButtonWebElement)
    public WebElement submitButton;
    @FindBy(xpath = verifyCompareWebElement)
    public WebElement verifyCompare;

    public void clickBook(){
        bookFlight.click();
    }
    public void clickDepartureFlight(){
        departureFlight.click();
    }
    public void clickDepartureFlightInput(String name){
        departureInput.sendKeys(name);
    }
    public void selectDeparture(){
        selectDeparture.click();
       //mouseHoverByXpath1(selectDepartureWebElement);
    }
    public void clickArrivalFlight() throws InterruptedException {
        waitFor(3);
        arrivalFlight.click();
    }
    public void clickArrivalFlightInput(String name) throws InterruptedException {
        waitFor(3);
        arrivalInput.sendKeys(name);
    }
    public void selectArrivalFlight(){
       // mouseHoverByXpath1(selectArrivalWebElement);
        selectArrival.click();
    }
    public void clickTripeType(){
        tripeType.click();
    }
    public void clickRoundTripeType(){
        roundTripeType.click();
    }
    public void clickDepartureDate(){
        calender.click();
        departureDate.click();
    }
    public void clickNextDate(){
        nextDate.click();
    }
//    public void clickArrivalDate(){
//        arrivalDate.click();
//    }
    public void clickFlightDateDone(){
        arrivalDate.click();
        FlightDateDone.click();

    }
    public void clickPassengerNumber(){
        passengerNumber.click();
        selectPassenger.click();
    }
    public void clickShowFare(){
        showFare.click();
    }
    public void clickBestFare(){
        bestFare.click();
        selectBestFare.click();
    }
    public void clickSubmitButton(){
        submitButton.click();
    }
    public void validateCompare(String expected) throws InterruptedException {
        waitFor(10);
        String actual =verifyCompare.getText();
        Assert.assertEquals(actual,expected,"match");
    }
}
