package phptravelers.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import se.soprasteria.automatedtesting.webdriver.api.base.BasePageObject;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;


public class MainPage extends BasePageObject {
    @FindBy(css = ".navbar-brand.go-right")
    protected static WebElement mainLogo;

    //*****************************
    //*** Hotel tab elements ******
    //*****************************
    //@FindBy(css = ".fa.fa-hotel")
    @FindBy(xpath = "//*[@id=\"body-section\"]/section/div[2]/div/div/div[2]/ul/li[1]")
    protected WebElement hotelsButton;
    @FindBy(xpath = "//*[@id=\"s2id_location\"]")
    protected WebElement hotelsSearch;
    @FindBy(xpath = "//*[@id=\"select2-drop\"]/div/input")
    protected WebElement hotelsSearchText;
    @FindBy(xpath = "//*[@id=\"select2-drop\"]/ul/li/ul/li/div/span")
    protected WebElement firstSearchResult;
    @FindBy(xpath = "//*[@id=\"dpd1\"]/div/input")
    protected WebElement checkInDate;
    @FindBy(xpath = "//*[@id=\"dpd2\"]/div/input")
    protected WebElement checkOutDate;
    @FindBy(xpath = "//*[@id=\"htravellersInput\"]")
    protected WebElement enterPassengers;
    @FindBy(id = "hadultPlusBtn")
    protected WebElement plusAdultBtn;
    @FindBy(id = "hadultMinusBtn")
    protected WebElement minusAdultBtn;
    @FindBy(id = "hchildPlusBtn")
    protected WebElement plusChildBtn;
    @FindBy(id = "hadultMinusBtn")
    protected WebElement minusChildBtn;
    @FindBy(xpath = "//*[@id=\"thhotels\"]/form/div[5]/button")
    protected WebElement hotelsSearchButton;


    //    @FindBy(css = ".fa.fa-plane")
    @FindBy(xpath = "//*[@id=\"body-section\"]/section/div[2]/div/div/div[2]/ul/li[2]/a")
    protected WebElement flightButton;


    public MainPage(AutomationDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageLoaded() {
        logger.info("Verifying that Main page is loaded by checking if hotels button is present");
        if (elementHelper.isElementPresentAndDisplayedWithinTime(hotelsButton, 50000)) {
            logger.info("Hotels button is present and displayed");
            return true;
        }
        logger.error("Hotels button is not present and displayed");
        return false;
    }

    public boolean selectHotelTab() {
        if (elementHelper.clickWithinTime(hotelsButton, 5000)) {
            logger.info("Hotels button was found and clickable");
            return true;
        }
        logger.error("Hotels button was not clickable");
        return false;
    }

    public boolean selectFlightTab() {
        if (elementHelper.clickWithinTime(flightButton, 5000)) {
            logger.info("Flights button was found and clickable");
            return true;
        }
        logger.error("Flights button was not clickable");
        return false;
    }

    public boolean setCheckInDate(String date) {
        if (elementHelper.isElementPresentAndDisplayed(checkInDate)) {
            elementHelper.sendKeysWithControlledSpeed(checkInDate, date, 10);
            logger.info("Check in date set to: '" + date + "'");
            return true;
        }
        logger.error("Check in date could not be set");
        return false;
    }

    public boolean setCheckOutDate(String date) {
        if (elementHelper.isElementPresentAndDisplayed(checkOutDate)) {
            elementHelper.sendKeysWithControlledSpeed(checkOutDate, date, 10);
            logger.info("Check out date set to: '" + date + "'");
            return true;
        }
        logger.error("Check out date could not be set");
        return false;
    }

    public boolean setDestination(String location) {
        if (elementHelper.isElementPresentAndDisplayed(hotelsSearch)) {
            elementHelper.clickWithinTime(hotelsSearch, 1000);
            elementHelper.sendKeysWithControlledSpeed(hotelsSearchText, location, 20);
            if (elementHelper.isElementPresentAndDisplayedWithinTime(firstSearchResult, 5000)) {
                elementHelper.clickWithinTime(firstSearchResult, 5000);
                logger.info("Destination: '" + location + "' was set");
                return true;
            }
        }
        logger.error("Failed to set destination");
        return false;
    }

    public void setPersons(int adults, int childs) {
        if (elementHelper.isElementPresentAndDisplayed(enterPassengers)) {
            elementHelper.clickWithinTime(enterPassengers, 1000);
            if (elementHelper.isElementPresentAndDisplayedWithinTime(plusAdultBtn, 1000)) {

                int nAdults = adults - 2;
                while (nAdults != 0) {
                    if (nAdults < 0) {
                        elementHelper.clickWithinTime(minusAdultBtn, 1000);
                        nAdults++;
                    } else {
                        elementHelper.clickWithinTime(plusAdultBtn, 1000);
                        nAdults--;
                    }
                }

                int nChild = childs;
                while (nChild != 0) {
                    elementHelper.clickWithinTime(plusChildBtn, 1000);
                    nChild--;
                }
            }
        }
    }



    public void isAllUrlResponding(AutomationDriver driver) {
        driver.isAllHrefResponding(driver, "a", "hrf");

    }

    public void isAllImagesResponding(AutomationDriver driver) {
        driver.isAllHrefResponding(driver, "img", "src");
    }


}
