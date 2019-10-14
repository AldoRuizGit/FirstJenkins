package twitter;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import se.soprasteria.automatedtesting.webdriver.api.base.BaseTestConfig;

import se.soprasteria.automatedtesting.webdriver.api.base.BaseTestCase;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;
import twitter.datastructure.Page;
import twitter.pages.LoginPage;
import twitter.pages.MainPage;
import twitter.pages.TweetPage;
import twitter.pages.UserPage;


public class TwitterBaseTest extends BaseTestCase {

    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected TweetPage tweetPage;
    protected UserPage userPage;


    public TwitterBaseTest() {
        super();
    }

    @Override
    protected String getDriverConfigId() {
        return "chromedriver";}

    @Override
    protected String getConfigFile() {
        return "twitter_config.xml";
    }

    @Override
    protected void initPages(AutomationDriver driver) {
    }

    @Override
    protected void initializeDriver(AutomationDriver driver) {
        logger.info("Initialising pages to be used in test");
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        tweetPage = new TweetPage(driver);
        userPage = new UserPage(driver);
    }

    public void initialize(Page page){
        switch (page){
            case MAIN_PAGE:
                loginPage.initWeb(driver);
                Assert.assertTrue(loginPage.isPageLoaded(), "Login page failed to load correctly");
                loginPage.performLogin(BaseTestConfig.getInstance().getConfig().users.get(0));
                Assert.assertTrue(mainPage.isPageLoaded(), "Main page failed to load correctly");
                break;
            case LOGIN_PAGE:
                loginPage.initWeb(driver);
                Assert.assertTrue(loginPage.isPageLoaded(), "Login page failed to load correctly");
                break;
            case USER_PAGE:
                userPage.initWeb(driver);
                Assert.assertTrue(userPage.isPageLoaded(), "User page failed to lead correctly");
                break;
        }
    }

}
