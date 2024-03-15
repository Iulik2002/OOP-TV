package pages.authpages.seedetails;

import database.Users;
import database.TempOutput;
import database.Output;
import database.Actions;
import database.Movies;
import pages.CurrentPage;
import pages.CurrentUser;
import pages.MyPage;
import pages.authpages.MoviesPage;
import pages.nonauthpages.NonAuthPage;

import java.util.ArrayList;

public final class SeeDetails implements CurrentPage {
    private static Movies viewMovie = new Movies();

    public Movies getViewMovie() {
        return viewMovie;
    }

    /**
     *
     * @param viewMovie
     */
    public void setViewMovie(final Movies viewMovie) {
        SeeDetails.viewMovie = viewMovie;
    }
    private MyPage myPage = new MyPage();

    /**
     *
     * @param actions
     */
    public void changePage(final Actions actions) {
        TempOutput tempOutput = new TempOutput();
        switch (actions.getPage()) {
            case "movies":
                new CurrentUser().resetMovieArrayList(new CurrentUser().getCopyMoviesArrayList());
                tempOutput.addObjectNode(new Output().getOutputMovies());
                myPage.setMyPage(new MoviesPage());
                break;
            case "logout":
                myPage.setMyPage(new NonAuthPage());
                break;
            default:

                tempOutput.addObjectNode(new Output().getOutputError());
                myPage.setMyPage(new SeeDetails());
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
        switch (actions.getFeature()) {
            case "purchase":
                new Purchase().purchase();
                break;
            case "watch":
                new Watch().watch();
                break;
            case "like":
                new Like().like();
                break;
            case "rate":
                new Rate().rate(actions);
                break;
            case "subscribe":
                if (!new CurrentUser().getCurrentUser().returnSubscribedGenre()
                        .contains(actions.getSubscribedGenre())) {
                    if (new SeeDetails().getViewMovie().getGenres().contains(actions
                            .getSubscribedGenre())) {
                        if (!new CurrentUser().getCurrentUser().returnSubscribedGenre()
                                .contains(actions.getSubscribedGenre())) {
                            new CurrentUser().getCurrentUser().addGenres(actions
                                    .getSubscribedGenre());
                        }
                    } else {
                        tempOutput.addObjectNode(new Output().getOutputError());
                    }
                } else {
                    tempOutput.addObjectNode(new Output().getOutputError());
                }
                break;
            default:
                tempOutput.addObjectNode(new Output().getOutputError());
                break;
        }
    }
}
