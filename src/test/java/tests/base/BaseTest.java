package tests.base;

import common.CommonAction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.base.BasePage;
import pages.listing.RealListingPage;
import pages.realHome.RealHomePage;

import java.util.Set;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;

public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected RealHomePage realHomePage = new RealHomePage(driver);
    protected RealListingPage realListingPage = new RealListingPage(driver);

    //    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    protected void switchWindow() {

//        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//        driver.switchTo().alert();
//        alert.accept();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String window1 = driver.getWindowHandle();
        js.executeScript("window.open()");

        Set<String> currentWindows = driver.getWindowHandles();

        String window2 = null;
        for (String window : currentWindows) {
            if (!window.equals(window1)) {
                window2 = window;
                break;
            }
        }

        driver.switchTo().window(window2);
    }
    @AfterTest
    public void clearCookiesAndLocalStorage(){
        if(CLEAR_COOKIES_AND_STORAGE){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void close() {
        driver.quit();
    }
}
