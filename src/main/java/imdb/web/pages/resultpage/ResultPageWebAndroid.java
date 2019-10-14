package imdb.web.pages.resultpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import se.soprasteria.automatedtesting.webdriver.api.base.BasePageObject;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class ResultPageWebAndroid extends BasePageObject implements ResultPage {
    @FindBy(xpath = "//*[@id=\"titleOverview\"]/div[2]/div")
    protected WebElement resultTitle;

    public ResultPageWebAndroid(AutomationDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageLoaded() {
        logger.info("Verifying that result page is loaded by checking that result page title is visible");
        if (elementHelper.isElementPresentAndDisplayedWithinTime(resultTitle, 5000)){
            logger.info("Title header visible");
            return true;
        }
        logger.error("Title header is not visible, result page failed to load correctly");
        return false;
    }

    @Override
    public boolean verifyResultPageTitle(String name) {
        logger.info("Checking if result page title matches search");
        if(elementHelper.isTextPresentInElementWithinTime(resultTitle, name, 5000)){
            logger.info("Result page title is correct");
            return true;
        }
        logger.error("Result page title is not correct");
        return false;
    }
}
