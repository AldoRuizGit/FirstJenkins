import androidcalculator.CalculatorBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class CalculatorTest extends CalculatorBaseTest {

    private final String addition = "500 + 200";
    private final String subtraction = "500 - 200";
    private final String multiplication = "20 * 2";
    private final String division = "20 / 2";



    @Test(timeOut = 180000, dataProvider = "getDriver", groups = {"mobile"})
    public void additionTest (AutomationDriver driver){
        initPages(driver);
        Assert.assertTrue(mainPage.isPageLoaded());
        mainPage.calculateEquation(addition);

        Assert.assertTrue(mainPage.getResult("700"));
    }

    @Test(timeOut = 180000, dataProvider = "getDriver", groups = {"mobile"})
    public void subtractionTest (AutomationDriver driver){
        initPages(driver);
        Assert.assertTrue(mainPage.isPageLoaded(), "Application did not load correctly");
        mainPage.calculateEquation(subtraction);
        Assert.assertTrue(mainPage.getResult("300"));
    }

    @Test(timeOut = 180000, dataProvider = "getDriver", groups = {"mobile"})
    public void multiplicationTest (AutomationDriver driver){
        initPages(driver);
        Assert.assertTrue(mainPage.isPageLoaded(), "Application did not load correctly");
        mainPage.calculateEquation(multiplication);
        Assert.assertTrue(mainPage.getResult("40"));
    }

    @Test(timeOut = 180000, dataProvider = "getDriver", groups = {"mobile"})
    public void divisionTest (AutomationDriver driver){
        initPages(driver);
        Assert.assertTrue(mainPage.isPageLoaded(), "Application did not load correctly");
        mainPage.calculateEquation(division);
        Assert.assertTrue(mainPage.getResult("10"));
    }
}
