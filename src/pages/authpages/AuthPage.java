package pages.authpages;

import database.Actions;
import database.Output;
import database.TempOutput;
import database.Users;
import pages.CurrentPage;
import pages.MyPage;
import pages.authpages.upgrades.UpgradesPage;
import pages.nonauthpages.NonAuthPage;
import java.util.ArrayList;

public final class AuthPage implements CurrentPage {
    private MyPage myPage = new MyPage();

    /**
     *
     * @param actions
     */
    public void changePage(final Actions actions) {
        TempOutput tempOutput = new TempOutput();
        switch (actions.getPage()) {
            case "movies":
                tempOutput.addObjectNode(new Output().getOutputMovies());
                myPage.setMyPage(new MoviesPage());
                break;
            case "upgrades":
                myPage.setMyPage(new UpgradesPage());
                break;
            case "logout":
                myPage.setMyPage(new NonAuthPage());
                break;
            default:
                tempOutput.addObjectNode(new Output().getOutputError());
                myPage.setMyPage(new AuthPage());
                break;
        }
    }

    /**
     *
     * @param actions
     * @param usersArrayList
     */
    public void onPage(final Actions actions, final ArrayList<Users> usersArrayList) {
        TempOutput tempOutput = new TempOutput();
        tempOutput.addObjectNode(new Output().getOutputError());
        myPage.setMyPage(new AuthPage());
    }
}
