package pages;

import database.Actions;
import database.Users;

import java.util.ArrayList;

public interface CurrentPage {
    /**
     *
     * @param actions
     */
    void changePage(Actions actions);

    /**
     *
     * @param actions
     * @param usersArrayList
     */
    void onPage(Actions actions, ArrayList<Users> usersArrayList);
}
