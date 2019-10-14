package twitter.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import se.soprasteria.automatedtesting.webdriver.api.base.BasePageObject;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class TweetPage extends BasePageObject {

    @FindBy(css = ".notranslate.public-DraftEditor-content")
    WebElement tweetTextBox;

    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div/div/div/div[3]/div")
    WebElement sendTweetButton;

    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div/div/div/div[1]/div")
    WebElement closeTweetPageButton;

    public TweetPage(AutomationDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageLoaded() {
        logger.info("Checking if TweetPage is opened by checking if tweetbox is visable");
        boolean isTweetBoxVisable = elementHelper.isElementDisplayedWithinTime(tweetTextBox, 5000);
        if(isTweetBoxVisable){
            logger.info("tweetTextBox is visable");
            return true;
        }
        logger.error("tweetTextBox is not visable");
        return false;
    }

    public void postTweet(String message){
        logger.info("Trying to enter message into tweetTextBox");
        elementHelper.sendKeysWithControlledSpeed(tweetTextBox, message, 10);
        elementHelper.isTextPresentInElementWithinTime(tweetTextBox, message, 5000);
        logger.info("Trying to press send button");
        sleep(500);
        elementHelper.clickWithinTime(sendTweetButton, 5000);
    }

    public void closeTweetPage(){
        logger.info("Trying to close TweetPage");
        elementHelper.clickWithinTime(closeTweetPageButton, 5000);
    }


}
