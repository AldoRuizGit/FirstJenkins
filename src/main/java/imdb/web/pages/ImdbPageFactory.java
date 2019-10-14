package imdb.web.pages;

import imdb.web.pages.mainpage.MainPage;
import imdb.web.pages.mainpage.MainPageWeb;
import imdb.web.pages.mainpage.MainPageWebAndroid;
import imdb.web.pages.resultpage.ResultPage;
import imdb.web.pages.resultpage.ResultPageWeb;
import imdb.web.pages.resultpage.ResultPageWebAndroid;
import imdb.web.pages.signinpage.SignInPage;
import imdb.web.pages.signinpage.SignInPageWeb;
import imdb.web.pages.signinpage.SignInPageWebAndroid;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class ImdbPageFactory {

    public static MainPage getMainPage(AutomationDriver driver){
        if(driver.isWeb()){
            return new MainPageWeb(driver);
        } else if (driver.isAndroid()){
            return new MainPageWebAndroid(driver);
        }
        return null;
    }

    public static ResultPage getResultPage(AutomationDriver driver){
        if(driver.isWeb()){
            return new ResultPageWeb(driver);
        } else if (driver.isAndroid()){
            return new ResultPageWebAndroid(driver);
        }
        return null;
    }

    public static SignInPage getSignInPage(AutomationDriver driver){
        if(driver.isWeb()){
            return new SignInPageWeb(driver);
        } else if (driver.isAndroid()){
            return new SignInPageWebAndroid(driver);
        }
        return null;
    }
}
