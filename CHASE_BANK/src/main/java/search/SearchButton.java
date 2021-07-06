package search;
import common.WebAPI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import static search.SearchWebElements.*;

public class SearchButton extends WebAPI {
    @FindBy(xpath = searchButtonWebElement)
    public WebElement searchButton;
    @FindBy(xpath = searchFieldWebElement)
    public WebElement searchField;
    @FindBy(xpath = searchWebElement)
    public WebElement search;

    @FindBy(xpath = loanOptionsWebElement)
    public WebElement loanOptions;
    @FindBy(xpath = validateMortgageOptionsWebElement)
    public WebElement validateMortgageOptions;

    @FindBy(xpath = studentHubWebElement)
    public WebElement studentHub;
    @FindBy(xpath = validateStudentHubWebElement)
    public WebElement validateStudentHub;

    @FindBy(xpath = myCarWebElement)
    public WebElement myCar;
    @FindBy(xpath = validateMyCarWebElement)
    public WebElement validateMyCar;

    public void clickSearchButton() throws InterruptedException {
        waitFor(5);
        searchButton.click();
    }
    public void homeLoanSearchField(String Loan) throws InterruptedException {
        waitFor(3);
        searchField.sendKeys(Loan);
    }
//    public void studentLoanSearchField(String Loan) throws InterruptedException {
//        waitFor(3);
//        searchField.sendKeys(Loan);
//    }
//    public void CarSearchField(String Loan) throws InterruptedException {
//        waitFor(3);
//        searchField.sendKeys(Loan);
//    }
    public void Search() throws InterruptedException {
         waitFor(5);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", search);

        //yourAcc.click();
//       waitFor(5);
//        search.click();
    }
    public void clickHomeLoanOptions() throws InterruptedException {
        waitFor(5);
        loanOptions.click();
    }
//    public void clickStudentLoanOptions() throws InterruptedException {
//        waitFor(5);
//        studentHub.click();
//    }
//    public void clickCarLoanOptions() throws InterruptedException {
//        waitFor(5);
//        myCar.click();
//    }
    public void verifyMortgageOptions(String expectedText){
        String actual =validateMortgageOptions.getText();
        Assert.assertEquals(actual,expectedText);
    }
//    public void verifyStudentHub(String expectedText) {
//        String actual = validateStudentHub.getText();
//        Assert.assertEquals(actual, expectedText);
//    }
//    public void verifyMyCar(String expectedText) {
//        String actual =validateMyCar.getText();
//        Assert.assertEquals(actual,expectedText);
//    }
}
