package location;

import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static location.LocationWebElements.*;

public class HotelLocation extends WebAPI {

  @FindBy(xpath =locationButtonWebElement)
    public WebElement locationButton ;
  @FindBy(xpath =AsiaZoneWebElement)
    public WebElement AsiaZone ;
  @FindBy(xpath =countryIndiaWebElement)
    public WebElement countryIndia ;
  @FindBy(xpath =northAmericaZoneWebElement)
    public WebElement northAmericaZone ;
  @FindBy(xpath =countryAlaskaWebElement)
    public WebElement countryAlaska ;
  @FindBy(xpath =selectIndiaHotelWebElement)
    public WebElement selectIndiaHotel ;
  @FindBy(xpath =selectAlaskaHotelWebElement)
    public WebElement selectAlaskaHotel ;

  public void clickLocation(){
      locationButton.click();
  }
  public void clickAsiaZone(){
        AsiaZone.click();
  }
  public void clickCountryIndia(){
        countryIndia.click();
  }
  public void clickNorthAmericaZone(){
        northAmericaZone.click();
  }
  public void clickCountryAlaska(){
        countryAlaska.click();
  }
  public void clickSelectIndiaHotel(){
        selectIndiaHotel.click();
  }
  public void clickSelectAlaskaHotel(){
        selectAlaskaHotel.click();
  }

}

