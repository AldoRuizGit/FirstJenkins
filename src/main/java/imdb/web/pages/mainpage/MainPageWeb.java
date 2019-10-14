package imdb.web.pages.mainpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import se.soprasteria.automatedtesting.webdriver.api.base.BasePageObject;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class MainPageWeb extends BasePageObject implements MainPage {

    @FindBy(id = "navbar-query")
    protected WebElement searchTextbox;
    @FindBy(id = "navbar-submit-button")
    protected WebElement searchSubmitButton;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/table/tbody/tr[1]/td[2]/a")
    protected WebElement topSearchResult;
    @FindBy(id = "imdb-signin-link")
    protected WebElement signInButton;
    @FindBy(xpath = "//*[@id=\"signin-options\"]/div/div[1]/a[1]")
    protected WebElement signInWithImdbAccount;


    public MainPageWeb(AutomationDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageLoaded() {
        if(elementHelper.isElementPresentAndDisplayedWithinTime(searchTextbox, 5000)){
            logger.info("Main page loaded correctly");
            return true;
        }
        logger.error("Main page did not load correctly");
        return false;
    }

    @Override
    public void searchMovie(String movie) {
        logger.info("Entering: '" + movie + "' into search box");
        elementHelper.sendKeysWithControlledSpeed(searchTextbox, movie, 20);
        elementHelper.clickWithinTime(searchSubmitButton, 5000);
        logger.info("Selecting top search result");
        elementHelper.clickWithinTime(topSearchResult, 5000);
    }

    @Override
    public void navigateToSignInPage() {
        logger.info("Clicking sign in button");
        elementHelper.clickWithinTime(signInButton, 5000);
        logger.info("Clicking sign in with IMDb");
        elementHelper.clickWithinTime(signInWithImdbAccount, 5000);
    }
}
