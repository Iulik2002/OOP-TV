package pages;

public class BackString {
    /**
     * Factory pattern
     * @param currentPage
     * @return
     */
    public String classToString(final CurrentPage currentPage) {
        switch (currentPage.getClass().getName()) {
            case "pages.authpages.MoviesPage":
                return "movies";
            case "pages.authpages.seedetails.SeeDetails":
                return "see details";
            case "pages.authpages.upgrades.UpgradesPage":
                return "upgrades";
            case "pages.nonauthpages.Login":
                return "login";
            case "pages.nonauthpages.NonAuthPage":
                return "nonAuthPage";
            case "pages.authpages.AuthPage":
                return "authPage";
            default:
                return null;
        }
    }
}
