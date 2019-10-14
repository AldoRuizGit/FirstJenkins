package twitter;

import org.testng.Assert;
import org.testng.annotations.Test;
import se.soprasteria.automatedtesting.webdriver.api.base.BaseTestConfig;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;
import twitter.datastructure.MainPageButton;
import twitter.datastructure.Page;

public class TwitterTest extends TwitterBaseTest {


    @Test(timeOut = 180000, dataProvider = "getDriver", groups = ("standard"))
    public void performLoginAndWriteTweet(AutomationDriver driver){

        logger.info("Starting test that verifies we can open the loginpage");
        initialize(Page.LOGIN_PAGE);

        logger.info("Starting login test");
        Assert.assertTrue(loginPage.isLoginTextBoxesVisible(), "Login textboxes failed to load correctly");
        loginPage.performLogin(BaseTestConfig.getInstance().getConfig().users.get(0));

        Assert.assertTrue(mainPage.isPageLoaded(), "Main page failed to load correctly");
        mainPage.openTweetBox();


        logger.info("Starting post tweet test");
        Assert.assertTrue(tweetPage.isPageLoaded(), "Tweet page failed to load correctly");
        tweetPage.postTweet(BaseTestConfig.getConfigurationOption("tweet.testMessage"));
        Assert.assertTrue(mainPage.isPageLoaded(), "Main page failed to load correctly");
    }


    @Test(timeOut = 180000, dataProvider = "getDriver", groups = ("standard"))
    public void testIfUserPageLoads(AutomationDriver driver){
        logger.info("Starting test that verifies that user page loads correctly");
        initialize(Page.USER_PAGE);
    }



    @Test(timeOut = 180000, dataProvider = "getDriver", groups = ("standard"))
    public void checkIfButtonsIsPresentInLeftColumn(AutomationDriver driver){
        logger.info("Starting test that verifies that all buttons are shown on MainPage");
        initialize(Page.MAIN_PAGE);
        Assert.assertTrue(mainPage.isButtonDisplayed(MainPageButton.HOME), "Home button failed to display");
        Assert.assertTrue(mainPage.isButtonDisplayed(MainPageButton.EXPLORE), "Explore button failed to display");
        Assert.assertTrue(mainPage.isButtonDisplayed(MainPageButton.NOTIFICATIONS), "Notifications button failed to display");
        Assert.assertTrue(mainPage.isButtonDisplayed(MainPageButton.MESSAGES), "Messages button failed to display");
        Assert.assertTrue(mainPage.isButtonDisplayed(MainPageButton.BOOKMARKS), "Bookmarks button failed to display");
        Assert.assertTrue(mainPage.isButtonDisplayed(MainPageButton.LISTS), "Lists button failed to display");
        Assert.assertTrue(mainPage.isButtonDisplayed(MainPageButton.PROFILE), "Profile button failed to display");
        Assert.assertTrue(mainPage.isButtonDisplayed(MainPageButton.MORE), "More button failed to display");
        Assert.assertTrue(mainPage.isButtonDisplayed(MainPageButton.TWEET), "Tweet button failed to display");
    }

}
