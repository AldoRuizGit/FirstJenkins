package imdb;

import imdb.app.ImdbAppBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import se.soprasteria.automatedtesting.webdriver.api.base.BaseTestConfig;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class ImdbAppTest extends ImdbAppBaseTest {

    private final String MOVIE = "Breaking Bad";



    @Test(timeOut = 180000, dataProvider = "getDriver", groups = {"APP"})
    public void movieSearchTest (AutomationDriver driver){
        initPages(driver);
        Assert.assertTrue(signInPageAndroidApp.isPageLoaded(), "Login page failed to load");
        signInPageAndroidApp.dontSignIn();
        Assert.assertTrue(mainPageAndroidApp.isPageLoaded(), "Main page failed to load");
        Assert.assertTrue(mainPageAndroidApp.searchMovie(MOVIE));
        Assert.assertTrue(resultPageAndroidApp.isPageLoaded());
        Assert.assertTrue(resultPageAndroidApp.verifyResultPageTitle(MOVIE));

    }

    @Test(timeOut = 180000, dataProvider = "getDriver", groups = {"APP"})
    public void performLoginTest (AutomationDriver driver){
        initPages(driver);
        Assert.assertTrue(signInPageAndroidApp.isPageLoaded());
        Assert.assertTrue(signInPageAndroidApp.performSignIn(BaseTestConfig.getInstance().getConfig().users.get(0)));
        Assert.assertTrue(mainPageAndroidApp.isPageLoaded(), "Login failed");
    }

}
