package imdb.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import se.soprasteria.automatedtesting.webdriver.api.base.BasePageObject;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class ResultPageAndroidApp extends BasePageObject {

    @FindBy(id = "com.imdb.mobile:id/title")
    protected WebElement title;


    public ResultPageAndroidApp(AutomationDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageLoaded() {
        if (elementHelper.isElementPresentAndDisplayedWithinTime(title, 5000)) {
            logger.info("Result page loaded correctly, returning true");
            return true;
        }
        logger.error("Result page failed to load correctly, returning false");
        return false;
    }

    public boolean verifyResultPageTitle(String name) {
        if (elementHelper.isTextPresentInElementWithinTime(title, name, 2000)) {
            logger.info("Title: '" + name + "', is shown correctly");
            return true;
        }
        logger.error("Title '" + name + "' is not shown correctly");
        return false;
    }
}
