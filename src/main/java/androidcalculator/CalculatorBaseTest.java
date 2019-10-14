package androidcalculator;

import androidcalculator.pages.MainPage;
import se.soprasteria.automatedtesting.webdriver.api.base.BaseTestCase;
import se.soprasteria.automatedtesting.webdriver.api.base.BaseTestConfig;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class CalculatorBaseTest extends BaseTestCase {
    protected MainPage mainPage;

    @Override
    protected String getDriverConfigId() {
        return "android_pixel3_emulator";
    }

    @Override
    protected String getConfigFile() {
        return "config_calculator.xml";
    }

    @Override
    protected void initPages(AutomationDriver automationDriver) {
        mainPage = new MainPage(automationDriver);

    }
}
