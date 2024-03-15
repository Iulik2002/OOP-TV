package pages.authpages.seedetails;

import database.Output;
import database.TempOutput;
import pages.CurrentUser;


public final class Like {
    /**
     *
     */
    public void like() {
        if (new CurrentUser().getCurrentUser().getWatchedMovies()
                .contains(new SeeDetails().getViewMovie())) {
            if (!new CurrentUser().getCurrentUser().getLikedMovies()
                    .contains(new SeeDetails().getViewMovie())) {
                new SeeDetails().getViewMovie().setNumLikes(
                        new SeeDetails().getViewMovie().getNumLikes() + 1);
                new CurrentUser().getCurrentUser().addLikedMovies(new SeeDetails().getViewMovie());
            }
            new OneMovieOut().oneMovieOut();
        } else {
            TempOutput tempOutput = new TempOutput();
            tempOutput.addObjectNode(new Output().getOutputError());
        }
    }
}
