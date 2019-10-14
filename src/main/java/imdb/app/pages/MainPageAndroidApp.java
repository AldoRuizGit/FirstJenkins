package imdb.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import se.soprasteria.automatedtesting.webdriver.api.base.BasePageObject;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class MainPageAndroidApp extends BasePageObject {
    @FindBy(id = "com.imdb.mobile:id/alertTitle")
    protected WebElement alertTitle;
    @FindBy(id = "android:id/button2")
    protected WebElement alertOkButton;
    @FindBy(id = "com.imdb.mobile:id/self_implemented_search")
    protected WebElement searchButton;
    @FindBy(id = "com.imdb.mobile:id/search_query")
    protected WebElement searchTextbox;
    @FindBy(xpath = "./hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]")
    protected WebElement firstSearchResult;


    public MainPageAndroidApp(AutomationDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageLoaded() {
        handleAlertMessage();
        if(elementHelper.isElementPresentAndDisplayedWithinTime(searchButton, 5000)){
            logger.info("Main page loaded correctly");
            return true;
        }
        logger.error("Main page didn't load correctly");
        return false;
    }

    private void handleAlertMessage(){
        if(elementHelper.isElementPresentAndDisplayedWithinTime(alertTitle, 5000)){
            logger.info("Alert message displayed, pressing OK");
            elementHelper.clickWithinTime(alertOkButton, 2000);
        }
    }

    public boolean searchMovie(String name){
        elementHelper.clickWithinTime(searchButton, 2000);
        if (elementHelper.isElementPresentAndDisplayedWithinTime(searchTextbox, 2000)){
            logger.info("Entering text: '" + name + "'");
            searchTextbox.sendKeys(name);
            //elementHelper.sendKeysWithControlledSpeed(searchTextbox, name, 20);
            if (elementHelper.isTextPresentInElementWithinTime(searchTextbox, name, 5000)){
                logger.info("Text entered correctly");
                if(elementHelper.isTextPresentInElementWithinTime(firstSearchResult, name, 5000)) {
                    logger.info("First search result is correct, selecting....");
                    elementHelper.clickWithinTime(firstSearchResult, 5000);
                    return true;
                } else { logger.error("Movie not found"); return false;}
            } else { logger.error("Text not entered correctly"); return false;}
        }
        logger.error("Failed to search");
        return false;
    }

}
