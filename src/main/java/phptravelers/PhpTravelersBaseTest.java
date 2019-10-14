package phptravelers;


import phptravelers.pages.MainPage;
import se.soprasteria.automatedtesting.webdriver.api.base.BaseTestCase;
import se.soprasteria.automatedtesting.webdriver.api.base.BaseTestConfig;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class PhpTravelersBaseTest extends BaseTestCase {
    protected MainPage mainPage;

    @Override
    protected String getDriverConfigId() {
        return "chromedriver";
    }

    @Override
    protected String getConfigFile() {
        return "phptravelers_config.xml";
    }

    @Override
    protected void initPages(AutomationDriver driver) {

        mainPage = new MainPage(driver);

    }

    public void initMainPage(AutomationDriver driver){
        driver.navigate().to(BaseTestConfig.getConfigurationOption("url.mainpage"));
    }

}
