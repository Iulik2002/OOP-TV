package pages.nonauthpages;

import database.Input;
import database.Actions;
import database.Output;
import database.Users;
import database.TempOutput;
import database.Credentials;
import pages.authpages.AuthPage;
import pages.CurrentPage;
import pages.CurrentUser;
import pages.MyPage;

import java.util.ArrayList;

public final class Register implements CurrentPage {
    /**
     *
     */
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
        Users newUser = new Users();
        CurrentUser currentUser = new CurrentUser();
        Credentials credentials = new Credentials();
        credentials.setName(actions.getCredentials().getName());
        credentials.setBalance(actions.getCredentials().getBalance());
        credentials.setCountry(actions.getCredentials().getCountry());
        credentials.setPassword(actions.getCredentials().getPassword());
        credentials.setAccountType(actions.getCredentials().getAccountType());
        newUser.setCredentials(credentials);
        new Input().addUsers(newUser);
        currentUser.setCurrentUser(newUser);
        currentUser.setMoviesArrayList();
        currentUser.setCopyMoviesArrayList(currentUser.getMoviesArrayList());
        TempOutput tempOutput = new TempOutput();
        myPage.setMyPage(new AuthPage());
        tempOutput.addObjectNode(new Output().getOutput());
    }
}
