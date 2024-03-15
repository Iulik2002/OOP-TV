package pages.authpages.seedetails;

import database.Movies;
import database.Output;
import database.TempOutput;
import pages.CurrentUser;

import java.util.ArrayList;

public final class OneMovieOut {
    /**
     *
     */
    public void oneMovieOut() {
        ArrayList<Movies> oneMovieList = new ArrayList<>();
        oneMovieList.add(new SeeDetails().getViewMovie());
        new CurrentUser().setCopyMoviesArrayList(new CurrentUser().getMoviesArrayList());
        new CurrentUser().resetMovieArrayList(oneMovieList);
        TempOutput tempOutput = new TempOutput();
        tempOutput.addObjectNode(new Output().getOutputMovies());
        new CurrentUser().resetMovieArrayList(new CurrentUser().getCopyMoviesArrayList());
    }
}
