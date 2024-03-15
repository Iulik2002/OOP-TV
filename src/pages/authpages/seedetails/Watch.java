package pages.authpages.seedetails;

import database.Output;
import database.TempOutput;
import pages.CurrentUser;


public final class Watch {
    /**
     *
     */
    public void watch() {
        if (new CurrentUser().getCurrentUser().getPurchasedMovies()
                .contains(new SeeDetails().getViewMovie())) {
            if (!new CurrentUser().getCurrentUser().getWatchedMovies()
                    .contains(new SeeDetails().getViewMovie())) {
                new CurrentUser().getCurrentUser().addWatchedMovies(new SeeDetails()
                        .getViewMovie());
            }
            new OneMovieOut().oneMovieOut();
        } else {
            TempOutput tempOutput = new TempOutput();
            tempOutput.addObjectNode(new Output().getOutputError());
        }
    }
}
