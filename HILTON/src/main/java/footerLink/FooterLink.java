package footerLink;

import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;

public class FooterLink extends WebAPI {
//    @FindBy(xpath = footerWebElement)
//    public WebElement footer;

    public void takeFooterLink() throws InterruptedException {
        WebElement footer = driver.findElement(By.xpath("//*[@id='main']/div[2]/footer/div[2]"));
        System.out.println(footer.findElements(By.tagName("a")).size());

        for (int i = 0; i < footer.findElements(By.tagName("a")).size(); i++) {
            waitFor(5);
            String clickLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
            footer.findElements(By.tagName("a")).get(i).sendKeys(clickLink);
        }
        Set<String> window = driver.getWindowHandles();
        Iterator<String> it = window.iterator();
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }
}

