package common;


import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static common.Config.PLATFORM_AND_BROWSER;
import static constant.Constant.TimeoutVariable.IMPLICIT_WAIT;

public class CommonAction {

    private static WebDriver driver = null;

    private CommonAction() {
    }

    public static WebDriver createDriver(){
        if(driver== null){
            switch (PLATFORM_AND_BROWSER){
                case "win_chrome": driver = new ChromeDriver();
                break;
                default:
                    Assertions.fail("Incorect platform or browser name" + PLATFORM_AND_BROWSER);
            }
            driver.manage().window().maximize();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        return driver;
    }

}
