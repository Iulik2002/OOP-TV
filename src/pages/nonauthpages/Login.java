package pages.nonauthpages;

import database.Actions;
import database.Output;
import database.Users;
import database.TempOutput;
import pages.authpages.AuthPage;
import pages.CurrentPage;
import pages.CurrentUser;
import pages.MyPage;

import java.util.ArrayList;

public final class Login implements CurrentPage {
    private MyPage myPage = new MyPage();

    /**
     *
     * @param actions
     */
    public void changePage(final Actions actions) {
        if (actions.getPage().equals("nonAuthPage")) {
            myPage.setMyPage(new NonAuthPage());
        }
    }

    /**
     *
     * @param actions
     * @param usersArrayList
     */
    public void onPage(final Actions actions, final ArrayList<Users> usersArrayList) {
        int ok = 0;
        CurrentUser currentUser = new CurrentUser();
        TempOutput tempOutput = new TempOutput();
        for (Users user : usersArrayList) {
            if (user.getCredentials().getName().equals(actions.getCredentials().getName())
                    && user.getCredentials().getPassword().equals(actions.getCredentials().getPassword())) {
                currentUser.setCurrentUser(user);
                currentUser.setMoviesArrayList();
                currentUser.setCopyMoviesArrayList(currentUser.getMoviesArrayList());
                myPage.setMyPage(new AuthPage());
                tempOutput.addObjectNode(new Output().getOutput());
                ok = 1;
                break;
            }
        }

        if (ok != 1) {
            tempOutput.addObjectNode(new Output().getOutputError());
            myPage.setMyPage(new NonAuthPage());
        }
    }
}
