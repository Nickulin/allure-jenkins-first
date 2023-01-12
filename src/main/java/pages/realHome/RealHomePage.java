package pages.realHome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class RealHomePage extends BasePage {
    public RealHomePage(WebDriver driver) {
        super(driver);
    }

    By countRooms = By.xpath("//select[@id='rooms']");
    By options2Rooms = By.xpath("//select[@id='rooms']/option[@value='2']");
    By findBtn = By.xpath("//div[@id='residentialInputs']//a[text()='Найти']");

    public RealHomePage enterCountRooms(){
        driver.findElement(countRooms).click();
        driver.findElement(options2Rooms).click();

        return this;
    }

    public RealHomePage clickToFind (){
        WebElement btnFind =  driver.findElement(findBtn);
        waitElementInvisible(btnFind).click();

        return this;
    }

}
