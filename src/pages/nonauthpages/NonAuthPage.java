package pages.nonauthpages;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import database.Actions;
import database.Output;
import database.TempOutput;
import database.Users;
import pages.CurrentPage;
import pages.MyPage;

import java.util.ArrayList;

public class NonAuthPage implements CurrentPage {
    private MyPage myPage = new MyPage();

    /**
     *
     * @param actions
     */
    public void changePage(final Actions actions) {
        ArrayNode output;
        ObjectMapper mapper = new ObjectMapper();
        output = mapper.createArrayNode();
        switch (actions.getPage()) {
            case "login":
                myPage.setMyPage(new Login());
                break;
            case "register":
                myPage.setMyPage(new Register());
                break;
            default:
                TempOutput tempOutput = new TempOutput();
                tempOutput.addObjectNode(new Output().getOutputError());
                myPage.setMyPage(new NonAuthPage());
                break;
        }
    }

    /**
     *
     * @param actions
     * @param usersArrayList
     */
    @Override
    public void onPage(final Actions actions, final ArrayList<Users> usersArrayList) { }
}

