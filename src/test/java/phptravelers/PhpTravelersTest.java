package phptravelers;

import org.testng.Assert;
import org.testng.annotations.Test;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class PhpTravelersTest extends PhpTravelersBaseTest {


    @Test(timeOut = 180000, dataProvider = "getDriver", groups = ("standard"))
    public void verifyMainPageIsLoading(AutomationDriver driver){
        initMainPage(driver);
        Assert.assertTrue(mainPage.isPageLoaded(), "Main page was not loaded correctly");
    }

    @Test(timeOut = 180000, dataProvider = "getDriver", groups = ("standard"))
    public void verifyMainPageUrls(AutomationDriver driver){
        logger.info("Starting test that verifies Main page links");
        initMainPage(driver);
        Assert.assertTrue(mainPage.isPageLoaded(), "Main page was not loaded correctly");
        Assert.assertFalse(driver.isAllHrefResponding(driver, "a", "href"));
    }

    @Test(timeOut = 180000, dataProvider = "getDriver", groups = ("standard"))
    public void verifyMainPageImages(AutomationDriver driver){
        logger.info("Starting test that verifies Main page image links");
        initMainPage(driver);
        Assert.assertTrue(mainPage.isPageLoaded(), "Main page was not loaded correctly");
        Assert.assertFalse(driver.isAllHrefResponding(driver, "img", "src"));
    }

    @Test(timeOut = 180000, dataProvider = "getDriver", groups = {"browser"})
    public void performHotelBooking(AutomationDriver driver){
        String destination = "New York";
        String checkInDate = "24/12/19";
        String checkOutDate = "26/12/19";
        int adults = 3;
        int childs = 5;

        initMainPage(driver);
        logger.info("Starting test that test hotel booking");
        Assert.assertTrue(mainPage.isPageLoaded(), "Main page was not loaded correctly");

        Assert.assertTrue(mainPage.selectHotelTab());
        Assert.assertTrue(mainPage.setDestination(destination));
        Assert.assertTrue(mainPage.setCheckInDate(checkInDate));
        Assert.assertTrue(mainPage.setCheckOutDate(checkOutDate));
        mainPage.setPersons(adults, childs);



    }




}
