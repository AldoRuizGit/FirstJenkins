package twitter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import se.soprasteria.automatedtesting.webdriver.api.base.BasePageObject;
import se.soprasteria.automatedtesting.webdriver.api.base.BaseTestConfig;
import se.soprasteria.automatedtesting.webdriver.helpers.base.baseconfig.config.User;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class LoginPage extends BasePageObject {

    @FindBy(css = ".submit.EdgeButton.EdgeButton--primary.EdgeButtom--medium")
    protected WebElement loginButton;
    @FindBy(css = ".js-username-field.email-input.js-initial-focus")
    protected WebElement usernameTextbox;
    @FindBy(css = ".js-password-field")
    protected WebElement passwordTextbox;
    @FindBy(xpath = "//*[@id=\"page-container\"]/div/div[1]/h1")
    protected WebElement loginHeader;

    public LoginPage(AutomationDriver driver) {
        super(driver);
    }


    @Override
    public boolean isPageLoaded() {
        return isHeaderVisibleAndText();
    }


    public void initWeb(AutomationDriver driver) {
        logger.info("Navigating to login page");
        driver.navigate().to(BaseTestConfig.getConfigurationOption("url.loginpage"));
        sleep(1000);
    }


    public boolean isLoginTextBoxesVisible() {
        if (elementHelper.isElementPresentAndDisplayedWithinTime(usernameTextbox, 5000) &&
                elementHelper.isElementPresentAndDisplayedWithinTime(passwordTextbox, 5000)) {
            logger.info("Login textboxes is visible");
            return true;
        } else if (!elementHelper.isElementPresentAndDisplayedWithinTime(usernameTextbox, 5000) &&
                elementHelper.isElementPresentAndDisplayedWithinTime(passwordTextbox, 5000)) {
            logger.error("Username textbox is not visible");
            return false;
        } else if (elementHelper.isElementPresentAndDisplayedWithinTime(usernameTextbox, 5000) &&
                !elementHelper.isElementPresentAndDisplayedWithinTime(passwordTextbox, 5000)) {
            logger.error("Password textbox is not visible");
            return false;
        }
        logger.error("Login textboxes is not visible");
        return false;
    }


    public void performLogin(User user) {
        elementHelper.sendKeysWithControlledSpeed(usernameTextbox, user.username, 10);
        elementHelper.sendKeysWithControlledSpeed(passwordTextbox, user.password, 10);
        elementHelper.clickWithinTime(loginButton, 3000);
    }


    public boolean isHeaderVisibleAndText() {
        logger.info("Verifying that header at login page is visible and have correct text");
        if (elementHelper.isElementPresentAndDisplayedWithinTime(loginHeader, 5000) &&
                elementHelper.isTextPresentInElementWithinTime(loginHeader, BaseTestConfig.getConfigurationOption("login.header"), 5000)) {
            logger.info("Login page header is displayed and have the correct text");
            return true;
        } else if (elementHelper.isElementPresentAndDisplayedWithinTime(loginHeader, 5000) &&
                !elementHelper.isTextPresentInElementWithinTime(loginHeader, BaseTestConfig.getConfigurationOption("login.header"), 5000)) {
            logger.error("Login page header is displayed but do not have the correct text");
            return false;
        }
        logger.error("Login page header is not displayed");
        return false;
    }


}

