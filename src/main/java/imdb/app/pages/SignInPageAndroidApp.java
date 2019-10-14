package imdb.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import se.soprasteria.automatedtesting.webdriver.api.base.BasePageObject;
import se.soprasteria.automatedtesting.webdriver.helpers.base.baseconfig.config.User;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class SignInPageAndroidApp extends BasePageObject {
    @FindBy(id = "com.imdb.mobile:id/alertTitle")
    protected WebElement alertTitle;
    @FindBy(id = "android:id/button2")
    protected WebElement alertOkButton;
    @FindBy(id = "com.imdb.mobile:id/splash_not_now")
    protected WebElement notNowButton;
    @FindBy(id = "com.imdb.mobile:id/imdb_auth_portal")
    protected WebElement signInWithIMDB;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[4]/android.widget.EditText")
    protected WebElement emailTexbox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[6]/android.widget.EditText")
    protected WebElement passwordTextbox;
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[14]/android.view.View/android.widget.Button")
    protected WebElement signInSubmitButton;


    public SignInPageAndroidApp(AutomationDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageLoaded() {
        sleep(1000);
        handleAlertMessage();
        if (elementHelper.isElementPresentAndDisplayedWithinTime(notNowButton, 2000)) {
            logger.info("Application started correctly");
            return true;
        }
        logger.error("Application didn't start correctly");
        return false;
    }

    private void handleAlertMessage() {
        if (elementHelper.isElementPresentAndDisplayed(alertTitle)) {
            logger.info("Alert message displayed, pressing OK");
            elementHelper.clickWithinTime(alertOkButton, 5000);
        }
    }

    public void dontSignIn() {
        if (elementHelper.isElementPresentAndDisplayedWithinTime(notNowButton, 5000)) {
            logger.info("Sign in page shown, continuing without signing in");
            elementHelper.clickWithinTime(notNowButton, 2000);
        }
    }

    public boolean performSignIn(User user) {
        elementHelper.clickWithinTime(signInWithIMDB, 5000);
        if (elementHelper.isElementPresentAndDisplayedWithinTime(signInSubmitButton, 5000)) {
            logger.info("Sign in with IMDB account shown correctly, entering credentials....");
            emailTexbox.sendKeys(user.username);
            passwordTextbox.sendKeys(user.password);
            elementHelper.clickWithinTime(signInSubmitButton, 5000);
            return true;
        }
        logger.error("Login not performed correctly");
        return false;
    }


}
