package imdb.web.pages.signinpage;

import se.soprasteria.automatedtesting.webdriver.helpers.base.baseconfig.config.User;

public interface SignInPage {
    public void performSignIn(User user);

    boolean isPageLoaded();
}
