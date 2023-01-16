package pages.listing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;


public class RealListingPage extends BasePage {
    public RealListingPage(WebDriver driver) {
        super(driver);
    }

    private final By card = By.xpath("//div[@class='listing view-format']//div[@data-mode='3']");

    public RealListingPage checkCountCards() {
        waitElementInvisible(driver.findElement(card));
        int countCard = driver.findElements(card).size();
        Assert.assertEquals(countCard, 20);
        return this;
    }


}
