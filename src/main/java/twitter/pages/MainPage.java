package twitter.pages;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import se.soprasteria.automatedtesting.webdriver.api.base.BasePageObject;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;
import twitter.datastructure.MainPageButton;

public class MainPage extends BasePageObject {

    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div/main/div/div/div/div[1]/div/a/div[2]/div/div")
    protected WebElement openTweetBox;
    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div/header/div/div/div/div/div[2]/nav/a[1]")
    protected WebElement homeButton;
    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div/header/div/div/div/div/div[2]/nav/a[2]")
    protected WebElement exploreButton;
    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div/header/div/div/div/div/div[2]/nav/a[3]")
    protected WebElement notificationsButton;
    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div/header/div/div/div/div/div[2]/nav/a[4]")
    protected WebElement messagesButton;
    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div/header/div/div/div/div/div[2]/nav/a[5]")
    protected WebElement bookmarksButton;
    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div/header/div/div/div/div/div[2]/nav/a[6]")
    protected WebElement listsButton;
    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div/header/div/div/div/div/div[2]/nav/a[7]")
    protected WebElement profileButton;
    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div/header/div/div/div/div/div[2]/nav/div")
    protected WebElement moreButton;
    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div/header/div/div/div/div/div[3]/a")
    protected WebElement tweetButton;

    public MainPage(AutomationDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageLoaded() {
        logger.info("Verifying that main page is showing by checking if open tweetbox is visable");
        boolean isOpenTweetBoxShown = elementHelper.isElementPresentAndDisplayedWithinTime(openTweetBox, 5000);
        if (isOpenTweetBoxShown) {
            logger.info("Open tweetbox is visable");
            return true;
        }
        logger.info("Open tweetbox is not visable");
        return false;
    }


    public void openTweetBox() {
        elementHelper.clickWithinTime(openTweetBox, 5000);
        sleep(500);
    }

    public boolean isButtonDisplayed(MainPageButton button) {
        if (elementHelper.isElementDisplayedWithinTime(selectButton(button), 5000)) {
            logger.info(button + " button is present and displayed");
            return true;
        }
        logger.info(button + " button is not present and displayed");
        return false;
    }

    private WebElement selectButton (MainPageButton button) {
        switch(button){
            case HOME:
                return homeButton;
            case EXPLORE:
                return exploreButton;
            case NOTIFICATIONS:
                return notificationsButton;
            case MESSAGES:
                return messagesButton;
            case BOOKMARKS:
                return bookmarksButton;
            case LISTS:
                return listsButton;
            case PROFILE:
                return profileButton;
            case MORE:
                return moreButton;
            case TWEET:
                return tweetButton;
            default:
                throw new RuntimeException("Incorrect button was chosen, test cannot continue");
        }
    }

}
