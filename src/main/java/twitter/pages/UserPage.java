package twitter.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import se.soprasteria.automatedtesting.webdriver.api.base.BasePageObject;
import se.soprasteria.automatedtesting.webdriver.api.base.BaseTestConfig;
import se.soprasteria.automatedtesting.webdriver.helpers.base.baseconfig.config.User;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class UserPage extends BasePageObject {

    private User user = BaseTestConfig.getInstance().getConfig().users.get(0);

    @FindBy(xpath = "//*[@id=\"page-container\"]/div[2]/div/div/div[1]/div/div/div/div[1]/h2/a/span/b")
    protected WebElement userName;

    @FindBy(xpath = "//*[@id=\"stream-item-tweet-1169494721301008385\"]/div[1]/div[2]/div[2]/p")
    protected  WebElement newestTweet;

    public UserPage(AutomationDriver driver) {
        super(driver);
    }


    @Override
    public boolean isPageLoaded() {
        logger.info("Check if UserPage loaded correct by comparing username with displayed username");
        if (elementHelper.isElementDisplayedWithinTime(userName, 5000)
                && elementHelper.isTextPresentInElementWithinTime(userName, user.username, 5000)) {
            logger.info("User page loaded correctly and username match user");
            return true;
        } else if (elementHelper.isElementDisplayedWithinTime(userName, 50000)
                && !elementHelper.isTextPresentInElementWithinTime(userName, user.username, 5000)) {
            logger.error("User page loaded but username does not match user");
        }
        return false;
    }


    public void initWeb(AutomationDriver driver) {
        logger.info("Navigating to user page");
        driver.navigate().to(BaseTestConfig.getConfigurationOption("url.twitter") + user.username);
        sleep(1000);
    }
}
