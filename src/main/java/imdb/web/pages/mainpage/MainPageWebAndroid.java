package imdb.web.pages.mainpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import se.soprasteria.automatedtesting.webdriver.api.base.BasePageObject;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class MainPageWebAndroid extends BasePageObject implements MainPage {
    @FindBy(id = "suggestion-search")
    protected WebElement searchTextbox;
    @FindBy(id = "imdbHeader-searchOpen")
    protected WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"pagecontent\"]/div/div[2]/div[2]/a/div/div[2]/span")
    protected WebElement topSearchResult;
    @FindBy(xpath = "//*[@id=\"page\"]/header/nav/div[1]/div/div[3]/a")
    protected WebElement signInButton;
    @FindBy(xpath = "//*[@id=\"signin-options\"]/div[1]/a[1]")
    protected WebElement signInWithImdbAccount;
    @FindBy(xpath = "//*[@id=\"upsell-banner\"]/div/a")
    protected WebElement declineSwitchingToApp;

    public MainPageWebAndroid(AutomationDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageLoaded() {
        if(elementHelper.isElementPresentAndDisplayedWithinTime(searchButton, 5000)){
            logger.info("Main page loaded correctly");
            declineSwitchingToApp();
            return true;
        }
        logger.error("Main page did not load correctly");
        return false;
    }

    @Override
    public void searchMovie(String movie) {
        logger.info("Entering: '" + movie + "' into search box");
        elementHelper.clickWithinTime(searchButton, 5000);
        searchTextbox.sendKeys(movie + "\n");
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

    private void declineSwitchingToApp(){
        if(elementHelper.isElementPresentAndDisplayedWithinTime(declineSwitchingToApp, 5000)){
            elementHelper.clickWithinTime(declineSwitchingToApp, 2000);
        }
    }
}
