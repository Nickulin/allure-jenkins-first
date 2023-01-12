package tests.searchapartments;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static common.Config.Urls.REALT_HOME_PAGE;

public class SearchApartTest extends BaseTest {
    @Test
    public void  checkIsRedrectToListing(){
        basePage.open(REALT_HOME_PAGE);

        realHomePage
                .enterCountRooms()
                .clickToFind();
        realListingPage
                .checkCountCards();

        switchWindow();
    }
}
