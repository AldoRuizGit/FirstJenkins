package imdb.app;

import imdb.app.pages.SignInPageAndroidApp;
import imdb.app.pages.MainPageAndroidApp;
import imdb.app.pages.ResultPageAndroidApp;

import se.soprasteria.automatedtesting.webdriver.api.base.BaseTestCase;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class ImdbAppBaseTest extends BaseTestCase {
    protected MainPageAndroidApp mainPageAndroidApp;
    protected SignInPageAndroidApp signInPageAndroidApp;
    protected ResultPageAndroidApp resultPageAndroidApp;


    @Override
    protected String getDriverConfigId() {
        return "android_pixel3_emulator_app";
    }

    @Override
    protected String getConfigFile() {
        return "config_imdb.xml";
    }

    @Override
    protected void initPages(AutomationDriver automationDriver) {
        signInPageAndroidApp = new SignInPageAndroidApp(automationDriver);
        mainPageAndroidApp = new MainPageAndroidApp(automationDriver);
        resultPageAndroidApp = new ResultPageAndroidApp(automationDriver);

    }
}
