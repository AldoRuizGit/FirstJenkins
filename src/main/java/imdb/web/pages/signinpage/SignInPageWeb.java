package imdb.web.pages.signinpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import se.soprasteria.automatedtesting.webdriver.api.base.BasePageObject;
import se.soprasteria.automatedtesting.webdriver.helpers.base.baseconfig.config.User;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class SignInPageWeb extends BasePageObject implements SignInPage {
    @FindBy(id = "ap_email")
    protected WebElement email;
    @FindBy(id = "ap_password")
    protected WebElement password;
    @FindBy(id = "signInSubmit")
    protected WebElement signInSubmitButton;


    public SignInPageWeb(AutomationDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageLoaded() {
        if(elementHelper.isElementPresentAndDisplayedWithinTime(email, 5000)){
            logger.info("Sign-In page loaded correctly");
            return true;
        }
        logger.error("Sign-In page did not load correctly");
        return false;
    }

    @Override
    public void performSignIn(User user) {
        logger.info("Entering username and password");
        elementHelper.sendKeysWithControlledSpeed(email, user.username, 20);
        elementHelper.sendKeysWithControlledSpeed(password, user.password, 20);
        elementHelper.clickWithinTime(signInSubmitButton, 5000);
    }
}
