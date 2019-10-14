package imdb.web.pages.mainpage;

public interface MainPage {
    public void searchMovie(String movie);
    public void navigateToSignInPage();

    boolean isPageLoaded();
}
