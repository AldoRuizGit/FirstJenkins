package imdb;

import imdb.web.ImdbBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import se.soprasteria.automatedtesting.webdriver.api.base.BaseTestConfig;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class ImdbTest extends ImdbBaseTest {

    private final String MOVIE = "Breaking Bad";

    @Test(timeOut = 180000, dataProvider = "getDriver", groups = {"WEB", "MOBILE"})
    public void loadWebPageTest(AutomationDriver driver){
        logger.info("Starting test that verifies that web page is loading");
        initPages(driver);
        Assert.assertTrue(mainPage.isPageLoaded());
    }

    @Test(timeOut = 180000, dataProvider = "getDriver", groups = {"WEB", "MOBILE"})
    public void movieSearchTest (AutomationDriver driver){
        logger.info("Starting movie search test");
        initPages(driver);
        Assert.assertTrue(mainPage.isPageLoaded());
        mainPage.searchMovie(MOVIE);
        Assert.assertTrue(resultPage.isPageLoaded());
        Assert.assertTrue(resultPage.verifyResultPageTitle(MOVIE));
    }

    @Test(timeOut = 180000, dataProvider = "getDriver", groups = {"WEB", "MOBILE"})
    public void signInTest (AutomationDriver driver){
        logger.info("Starting sign in test using IMDb account");
        initPages(driver);
        Assert.assertTrue(mainPage.isPageLoaded());
        mainPage.navigateToSignInPage();
        Assert.assertTrue(signInPage.isPageLoaded());
        signInPage.performSignIn(BaseTestConfig.getInstance().getConfig().users.get(0));
        Assert.assertTrue(mainPage.isPageLoaded());
    }
}
