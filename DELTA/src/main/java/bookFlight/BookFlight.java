package bookFlight;

import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static bookFlight.BookFlightWebElement.*;

public class BookFlight extends WebAPI {
    @FindBy(xpath = closeUpWebElement)
    public WebElement closeUp;
    @FindBy(xpath = bookFlightWebElement)
    public WebElement bookFlight;
    @FindBy(xpath = departureFlightWebElement)
    public WebElement departureFlight;
    @FindBy(xpath = departureInputWebElement)
    public WebElement departureInput;
    @FindBy(xpath = selectDepartureWebElement)
    public WebElement selectDeparture;
    @FindBy(xpath = selectDeparture2WebElement)
    public WebElement selectDeparture2;
    @FindBy(xpath = selectDeparture3WebElement)
    public WebElement selectDeparture3;
    @FindBy(xpath = arrivalFlightWebElement)
    public WebElement arrivalFlight;
    @FindBy(xpath = arrivalInputWebElement)
    public WebElement arrivalInput;
    @FindBy(xpath = selectArrivalWebElement)
    public WebElement selectArrival;
   @FindBy(xpath = selectArrival2WebElement)
    public WebElement selectArrival2;
   @FindBy(xpath = selectArrival3WebElement)
    public WebElement selectArrival3;
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
    @FindBy(xpath = selectNextWebElement)
    public WebElement selectNext;
    @FindBy(xpath = verifyCompareWebElement)
    public WebElement verifyCompare;

    public void clickBook(){
        closeUp.click();
        bookFlight.click();
    }
    public void clickDepartureFlight(){
        departureFlight.click();
    }
    public void clickDepartureFlightInput(String name){
        departureInput.sendKeys(name);
    }
    public void selectDepartureFlight(){
        selectDeparture.click();
    }
    public void selectDeparture2Flight(){
        selectDeparture2.click();
    }
    public void selectDeparture3Flight(){
        selectDeparture3.click();
    }
    public void clickArrivalFlight() {

        arrivalFlight.click();
    }
    public void clickArrivalFlightInput(String name)  {

        arrivalInput.sendKeys(name);
    }
    public void selectArrivalFlight(){
        selectArrival.click();
    }
    public void selectArrival2Flight(){
        selectArrival2.click();
    }
    public void selectArrival3Flight(){
        selectArrival3.click();
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
    public void clickPassengerNumber() throws InterruptedException {
        waitFor(3);
        passengerNumber.click();
        selectPassenger.click();
    }
    public void selectNextButton() throws InterruptedException {
        waitFor(3);
        selectNext.click();
    }
    public void validateCompare(String expected) throws InterruptedException {
        waitFor(10);
        String actual =verifyCompare.getText();
        Assert.assertEquals(actual,expected);
    }
}
