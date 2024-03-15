package pages.authpages.upgrades;

import database.Actions;
import database.Output;
import database.TempOutput;
import database.Users;
import pages.CurrentPage;
import pages.MyPage;
import pages.authpages.AuthPage;
import pages.authpages.MoviesPage;
import pages.nonauthpages.NonAuthPage;
import java.util.ArrayList;

public final class UpgradesPage implements CurrentPage {
    private MyPage myPage = new MyPage();

    /**
     *
     * @param actions
     */
    @Override
    public void changePage(final Actions actions) {
        TempOutput tempOutput = new TempOutput();
        switch (actions.getPage()) {
            case "movies":
                tempOutput.addObjectNode(new Output().getOutputMovies());
                myPage.setMyPage(new MoviesPage());
                break;
            case "logout":
                myPage.setMyPage(new NonAuthPage());
                break;
            case "authPage":
                myPage.setMyPage(new AuthPage());
                break;
            default:
                tempOutput.addObjectNode(new Output().getOutputError());
                myPage.setMyPage(new UpgradesPage());
                break;
        }
    }

    /**
     *
     * @param actions
     * @param usersArrayList
     */
    @Override
    public void onPage(final Actions actions, final ArrayList<Users> usersArrayList) {
        TempOutput tempOutput = new TempOutput();
        switch (actions.getFeature()) {
            case "buy tokens":
                new BuyTokens().buyTokens(actions);
                break;
            case "buy premium account":
                new BuyPremium().buyPremium(actions);
                break;
            default:
                tempOutput.addObjectNode(new Output().getOutputError());
                break;
        }
    }
}
