import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import database.Actions;
import database.Input;
import database.Output;
import database.TempOutput;
import pages.CurrentUser;
import pages.BackString;
import pages.CurrentPage;
import pages.DataBase;
import pages.MyPage;
import pages.nonauthpages.Login;
import pages.nonauthpages.NonAuthPage;
import pages.nonauthpages.Register;
import pages.Recommendations;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class Main {
    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(final String[] args) throws IOException {
        String input = args[0];
        String output = args[1];
        ObjectMapper objectMapper = new ObjectMapper();
        Input inputData = objectMapper.readValue(new File(input), Input.class);
        TempOutput tempOutput = new TempOutput();
        tempOutput.createTempOut();

        MyPage myPage = new MyPage();
        CurrentPage currentPage = new NonAuthPage();
        myPage.setMyPage(currentPage);
        Stack<CurrentPage> back = new Stack<>();
        for (Actions action: inputData.getActions()) {
            switch (action.getType()) {
                case "change page":
                    currentPage.changePage(action);
                    if (!currentPage.getClass().getName()
                            .equals(myPage.getMyPage().getClass().getName())) {
                        back.push(myPage.getMyPage());
                        currentPage = myPage.getMyPage();
                    }


                    break;
                case "on page":
                    currentPage.onPage(action, inputData.getUsers());
                    if (!currentPage.getClass().getName()
                            .equals(myPage.getMyPage().getClass().getName())) {
                        back.push(myPage.getMyPage());
                        currentPage = myPage.getMyPage();
                    }
                    break;
                case "back":
                    BackString backString = new BackString();
                    if (back.size() > 1) {
                        back.pop();
                    }
                    if (back.lastElement().getClass().getName()
                            .equals(Login.class.getName())
                            || back.lastElement().getClass().getName()
                            .equals(Register.class.getName())
                            || back.lastElement().getClass().getName()
                            .equals(NonAuthPage.class.getName())) {
                        tempOutput = new TempOutput();
                        tempOutput.addObjectNode(new Output().getOutputError());
                    } else {
//                        if (!back.lastElement().getClass().getName()
//                                .equals(AuthPage.class.getName())
//                                || !back.lastElement().getClass().getName()
//                                .equals(NonAuthPage.class.getName())) {
                            action.setPage(backString.classToString(back.lastElement()));
                            action.setType("change page");
                            currentPage.changePage(action);
                            currentPage = myPage.getMyPage();
//                        }
                    }
                    break;
                case "database":
                    if (action.getFeature().equals("add")) {
                        new DataBase().add(action);
                    } else {
                        new DataBase().remove(action);
                    }
                    break;
                default:
                    break;
            }
        }
        if (!myPage.getMyPage().getClass().getName().equals(NonAuthPage.class.getName())) {
            if (new CurrentUser().getCurrentUser().getCredentials()
                    .getAccountType().equals("premium")) {
                new Recommendations().recommend();
                new CurrentUser().resetMovieArrayList(null);
                tempOutput.addObjectNode(new Output().getOutputMovies());
            }
        }
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(new File(output), tempOutput.getTempOut());
    }
}
