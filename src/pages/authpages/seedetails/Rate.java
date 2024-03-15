package pages.authpages.seedetails;

import database.Actions;
import database.Output;
import database.TempOutput;
import pages.CurrentUser;

public final class Rate {
    /**
     *
     * @param actions
     */
    public void rate(final Actions actions) {
        if (actions.getRate() > 5 || actions.getRate() < 0) {
            TempOutput tempOutput = new TempOutput();
            tempOutput.addObjectNode(new Output().getOutputError());
        } else {
            if (new CurrentUser().getCurrentUser().getWatchedMovies()
                    .contains(new SeeDetails().getViewMovie())) {
                if (!new CurrentUser().getCurrentUser().getRatedMovies()
                        .contains(new SeeDetails().getViewMovie())) {
                    new CurrentUser().getCurrentUser().addRatedMovies(new SeeDetails()
                            .getViewMovie());
                    new SeeDetails().getViewMovie()
                            .setNumRatings(new SeeDetails().getViewMovie().getNumRatings() + 1);
                    new SeeDetails().getViewMovie()
                            .setRating((new SeeDetails().getViewMovie().getRating()
                                    * (new SeeDetails().getViewMovie().getNumRatings() - 1)
                                    + actions.getRate())
                                    / (new SeeDetails().getViewMovie().getNumRatings()));
                    new SeeDetails().getViewMovie().addMovieRates(
                            new CurrentUser().getCurrentUser().getCredentials()
                                    .getName(), actions.getRate());

                } else {
                    new SeeDetails().getViewMovie()
                            .setRating((new SeeDetails().getViewMovie().getRating()
                                    * new SeeDetails().getViewMovie().getNumRatings()
                                    - new SeeDetails().getViewMovie().retMovieRates()
                                    .get(new CurrentUser().getCurrentUser()
                                            .getCredentials().getName())
                                    + actions.getRate())
                                    / (new SeeDetails().getViewMovie().getNumRatings()));
                    new SeeDetails().getViewMovie().changeMovieRates(
                            new CurrentUser().getCurrentUser().getCredentials()
                                    .getName(), actions.getRate());
                }
                //for (Map.Entry<String, Integer> entry: )
                new SeeDetails().getViewMovie()
                        .setRating((new SeeDetails().getViewMovie().getRating()
                                * new SeeDetails().getViewMovie().getNumRatings()
                                - new SeeDetails().getViewMovie().retMovieRates()
                                .get(new CurrentUser().getCurrentUser()
                                        .getCredentials().getName())
                                + actions.getRate())
                                / (new SeeDetails().getViewMovie().getNumRatings()));



                new OneMovieOut().oneMovieOut();
            } else {
                TempOutput tempOutput = new TempOutput();
                tempOutput.addObjectNode(new Output().getOutputError());
            }
        }
    }
}
