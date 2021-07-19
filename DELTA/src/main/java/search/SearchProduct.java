package search;

import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static search.SearchWebElements.*;

public class SearchProduct extends WebAPI {
    @FindBy(xpath = searchButtonWebElement)
    public WebElement searchButton;
    @FindBy(xpath = searchFieldWebElement)
    public WebElement searchField;
    @FindBy(xpath = searchWebElement)
    public WebElement search;
    @FindBy(xpath = searchJfkWebElement)
    public WebElement searchJfk;
    @FindBy(xpath = flightPartnersWebElement)
    public WebElement flightPartners;
    @FindBy(xpath = CashlessAirportsWebElement)
    public WebElement CashlessAirports;
    @FindBy(xpath = friendsWebElement)
    public WebElement friends;
    @FindBy(xpath = verifyNewYorkWebElement)
    public WebElement verifyNewYork;
    @FindBy(xpath = verifyCashlessWebElement)
    public WebElement verifyCashless;

   public void clickSearchButton(){
       searchButton.click();
   }
   public void clickSearchField(String name){
       searchField.sendKeys(name);
   }

   public void clickSearch(){
       search.click();
   }
   public void clickJfkField(){
       searchJfk.click();
   }
   public void clickFlightPartner(){
       flightPartners.click();
   }
   public void ClickCashlessAirports(){
       CashlessAirports.click();
   }
   public void verifyFriends(String actual){
      String Expected =friends.getText();
       Assert.assertEquals(Expected,actual);
   }
   public void validateNewYork(String actual){
      String Expected =verifyNewYork.getText();
       Assert.assertEquals(Expected,actual);
   }
   public void validateCashless(String actual){
      String Expected =verifyCashless.getText();
       Assert.assertEquals(Expected,actual);
   }
}
