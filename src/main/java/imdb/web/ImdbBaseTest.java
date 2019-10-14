package imdb.web;

import imdb.web.pages.ImdbPageFactory;
import imdb.web.pages.mainpage.MainPage;
import imdb.web.pages.resultpage.ResultPage;
import imdb.web.pages.signinpage.SignInPage;
import se.soprasteria.automatedtesting.webdriver.api.base.BaseTestCase;
import se.soprasteria.automatedtesting.webdriver.api.base.BaseTestConfig;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class ImdbBaseTest extends BaseTestCase {
    protected MainPage mainPage;
    protected ResultPage resultPage;
    protected SignInPage signInPage;


    @Override
    protected String getDriverConfigId() {
        return "chromedriver";
    }

    @Override
    protected String getConfigFile() {
        return "config_imdb.xml";
    }

    @Override
    protected void initPages(AutomationDriver automationDriver) {
        driver.navigate().to(BaseTestConfig.getConfigurationOption("url_mainpage"));
        mainPage = ImdbPageFactory.getMainPage(automationDriver);
        resultPage = ImdbPageFactory.getResultPage(automationDriver);
        signInPage = ImdbPageFactory.getSignInPage(automationDriver);

    }
}
